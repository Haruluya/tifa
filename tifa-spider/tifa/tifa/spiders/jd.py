import scrapy


class JingdongSpider(scrapy.Spider):
    name = 'jd'
    allowed_domains = ['you.163.com']
    start_urls = ['https://you.163.com/xhr/item/saleRankItems.json']
    DEFAULT_REQUEST_HEADERS = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36',
    }

    def parse(self, response):
        pass
#

