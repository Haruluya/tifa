import scrapy


class JingdongSpider(scrapy.Spider):
    name = 'dangdang'
    allowed_domains = ['dangdang.com,e.dangdang.com']
    start_urls = ['http://e.dangdang.com/index_page.html']
    DEFAULT_REQUEST_HEADERS = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36',
    }

#     def parse(self, response):
#         first_title_list = response.xpath('//div[@class="new_pub_nav_shadow"]/ul/li/span[@class="nav"]/a')
#         for first_title in first_title_list[:1]:
#             first_category = first_title.xpath('./text()').extract_first()
#             second_html_link = first_title.xpath('./@href').extract_first()
#             # print(second_html_link_list.extract())
# #           访问第二个连接。
#             temp_data = {}
#             temp_data['first_category'] = first_category
#             print(second_html_link + "??")
#
#             yield scrapy.Request(
#                 url=second_html_link,
#                 callback=self.parse_second_url,
#                 meta={"secondData":temp_data}
#             )

    def parse(self,response):


        # temp = response.meta['secondData']
        print("__________________________")
        second_title_list = response.xpath('//div[@class="new_aside"]/dl/dt/a')
        for second_title in second_title_list:
            second_category = second_title.xpath('./text()').extract_first()
            third_html_link = second_title.xpath('./@href').extract_first()
            print(third_html_link)
            # temp_data = {}
            # temp_data['first_category'] = temp['first_category']
            # temp_data['second_category'] = second_category

            # yield scrapy.Request(
            #     url=third_html_link,
            #     callback=self.parse_third_url,
            #     meta={"secondData":temp_data}
            # )


    def parse_third_url(self,response):
        pass
