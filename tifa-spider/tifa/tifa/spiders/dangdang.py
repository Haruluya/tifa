import scrapy
from tifa.items import TifaItem

class JingdongSpider(scrapy.Spider):
    name = 'dangdang'
    allowed_domains = ['dangdang.com','e.dangdang.com']
    start_urls = ['http://dangdang.com']
    DEFAULT_REQUEST_HEADERS = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36',
    }

    def parse(self, response):
        first_title_list = response.xpath('//div[@class="new_pub_nav_shadow"]/ul/li/span[@class="nav"]/a')
        for first_title in first_title_list[4:15]:
            first_category = first_title.xpath('./text()').extract_first()
            second_html_link = first_title.xpath('./@href').extract_first()
#           访问第二个连接。
            temp_data = {}
            temp_data['first_category'] = first_category
            print(first_title)
            print(second_html_link + "??")


            for i in range(0,50):
                if i == 0:
                    pass
                else:
                    second_html_link = second_html_link[0:29] + "pg" + str(i+1) + "-" + second_html_link[-16:]
                print(second_html_link)
                yield scrapy.Request(
                    url=second_html_link,
                    callback=self.parse_second_url,
                    meta={"secondData":temp_data}
                )

    def parse_second_url(self,response):
        temp = response.meta['secondData']
        second_title_list = response.xpath('//div[@id="search_nature_rg"]/ul[@ class="bigimg cloth_shoplist"]/li')
        print(second_title_list)



        for second_title in second_title_list:
            item = TifaItem()
            item['name'] = second_title.xpath("./p[@class='price']/span/text()").extract_first()
            item['subTitle'] = second_title.xpath("./a/@title").extract_first()
            item['orignalPrice'] = second_title.xpath("./p[@class='price']/span/text()").extract_first()
            item['promotePrice'] = second_title.xpath("./p[@class='price']/span/text()").extract_first()
            item['stock'] = 0
            item['createDate'] = 0
            item['className1'] = temp['first_category']
            item['className2'] = second_title.xpath("./p[@class='link']/a/@dd_name").extract_first()
            item['className3'] = second_title.xpath("./p[@class='link']/a/text()").extract_first()
            item['itemPic'] = second_title.xpath("./a/img/@src").extract_first()
            if second_title.xpath("./p[@class='search_hot_word']/text()").extract_first() is None:
                item['itemDisc'] = '无'
            else:
                item['itemDisc'] = second_title.xpath("./p[@class='search_hot_word']/text()").extract_first()
            yield item


