import scrapy
from jsonpath import jsonpath
from tifa.items import TifaItem


class JsonSpider(scrapy.Spider):
    name = 'json'
    allowed_domains = ['e.dangdang.com']
    start_urls = ['https://e.dangdang.com/media/api.go?action=mediaCategoryLeaf&promotionType=1&deviceSerialNo=html5&macAddr=html5&channelType=html5&permanentId=20220402205658932304926291687615935&returnType=json&channelId=70000&clientVersionNo=6.8.0&platformSource=DDDS-P&fromPlatform=106&deviceType=pconline&token=&start=21&end=41&category=XS2&dimension=dd_sale&order=0']

    def parse(self, response):

        itemList = jsonpath(response.json(),'$.data.saleList.*')
        for media in itemList:
            item = TifaItem()
            item['name'] = jsonpath(media,'$.mediaList[0].title')[0]
            item['subTitle'] = jsonpath(media,'$.mediaList[0].authorPenname')[0]
            item['orignalPrice'] = jsonpath(media,'$.mediaList[0].originalPrice')[0]
            item['promotePrice'] = jsonpath(media,'$.mediaList[0].lowestPrice')[0]
            item['stock'] = 0
            item['createDate'] = 0
            item['className3'] = jsonpath(media,'$.mediaList[0].categorys')[0]
            item['itemPic'] = jsonpath(media,'$.mediaList[0].coverPic')[0]
            item['itemDisc'] = jsonpath(media,'$.mediaList[0].descs')[0]
            fp = open('./data/json01.txt','a')
            fp.write(str(item) + '\n\n')
            fp.close()
            yield

