# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy

# 
# @date 2022/4/2
# 商品数据类型。对应数据库中商品各属性。
# 
class TifaItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    name = scrapy.Field()
    subTitle = scrapy.Field()
    orignalPrice = scrapy.Field()
    promotePrice = scrapy.Field()
    itemPic = scrapy.Field()
    stock = scrapy.Field()
    createDate = scrapy.Field()
    className1 = scrapy.Field()
    className2 = scrapy.Field()
    className3 = scrapy.Field()
    itemDisc = scrapy.Field()



