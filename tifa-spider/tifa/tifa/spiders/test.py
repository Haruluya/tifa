import scrapy
from tifa.items import TifaItem

class TestSpider(scrapy.Spider):
    name = 'test'
    allowed_domains = ['bilibili.com','qq.com']
    start_urls = ['http://bilibili.com']

    def parse(self, response):
        title = response.xpath('//title/text()').extract_first()
        print(title)
        yield scrapy.Request(
            url='https://www.qq.com/',
            callback=self.test1,
        )


    def test1(self,response):
        title = response.xpath('//title/text()').extract_first()
        print(title)
        item = TifaItem()
        item['name'] = 1
        item['subTitle'] = 2
        item['orignalPrice'] = 3
        item['promotePrice'] = 4
        item['stock'] = 0
        item['createDate'] = 0
        item['className1'] = 5
        item['className2'] = 6
        item['className3'] = 7
        item['itemPic'] = 8
        item['itemDisc'] = 9
        yield item
        # yield scrapy.Request(
        #     url='https://www.qq.com/',
        #     callback=self.test1,
        # )

