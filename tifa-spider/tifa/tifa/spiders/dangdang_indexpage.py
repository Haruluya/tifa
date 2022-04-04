import scrapy
from jsonpath import jsonpath
from tifa.items import TifaItem

#
#@date 2022/4/4
#index_page爬虫。
#当当网电子书页面请求比较特殊，从e.dangdang.com请求json数据，于是需要特殊为电子书编写爬虫。
#
class DangdangIndexpageSpider(scrapy.Spider):
    name = 'index_page'
    allowed_domains = ['dangdang.com','e.dangdang.com']
    start_urls = ['http://e.dangdang.com/index_page.html']
    DEFAULT_REQUEST_HEADERS = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36',
    }


    def parse(self, response):
        # json请求参数。
        self.categoryMap = {"小说": "XS2", "文艺": "WY", "历史文化": "SK", "经济/管理": "JG", "心理/励志": "CGLZ", "生活": "SH",
                            "童书": "TS", "科技/教育": "KJ", "原版书": "JKS"}
        second_title_list = response.xpath('//div[@class="new_aside"]/dl/dt/a')
        for second_title in second_title_list:
            first_category = '电子书'
            second_category = second_title.xpath('./text()').extract_first()
            third_html_link = second_title.xpath('./@href').extract_first()
            temp_data = {}
            temp_data['first_category'] = first_category
            temp_data['second_category'] = second_category
            temp_data['json_url'] = self.categoryMap[second_category]
            yield scrapy.Request(
                url="https:" + third_html_link,
                callback=self.parse_third_url,
                meta={"secondData":temp_data}
            )

    def parse_third_url(self,response):
        temp_data = response.meta["secondData"]
        json_data_url = 'http://e.dangdang.com/media/api.go?action=mediaCategoryLeaf&promotionType=1&deviceSerialNo=html5&macAddr=html5&channelType=html5&permanentId=20220402205658932304926291687615935&returnType=json&channelId=70000&clientVersionNo=6.8.0' \
                        '&platformSource=DDDS-P&fromPlatform=106&deviceType' \
                        '=pconline&token=&start=21&end=41&category='+temp_data['json_url']+'&dimension=dd_sale&order=0'
        yield scrapy.Request(
            url= json_data_url,
            callback=self.parse_json,
            meta={"thirdData": temp_data}
        )


    def parse_json(self,response):
        catagoryData = response.meta["thirdData"]
        itemList = jsonpath(response.json(),'$.data.saleList.*')
        for media in itemList:
            item = TifaItem()
            item['name'] = jsonpath(media,'$.mediaList[0].title')[0]
            item['subTitle'] = jsonpath(media,'$.mediaList[0].authorPenname')[0]
            item['orignalPrice'] = jsonpath(media,'$.mediaList[0].originalPrice')[0]
            item['promotePrice'] = jsonpath(media,'$.mediaList[0].lowestPrice')[0]
            item['stock'] = 0
            item['createDate'] = 0
            item['className1'] = catagoryData['first_category']
            item['className2'] = catagoryData['second_category']
            item['className3'] = jsonpath(media,'$.mediaList[0].categorys')[0]
            item['itemPic'] = jsonpath(media,'$.mediaList[0].coverPic')[0]
            item['itemDisc'] = jsonpath(media,'$.mediaList[0].descs')[0]
            yield item
