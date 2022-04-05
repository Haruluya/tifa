# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface

from itemadapter import ItemAdapter
import json
# 
# @date 2022/4/3
# 管道配置一：存入json文件。
class TifaPipeline:
    fp = None
    def open_spider(self, spider):
        print("Spider begin!")
        self.fp = open('data/data.json', 'a', encoding='utf-8')

    def process_item(self, item, spider):
        data = json.dumps(dict(item), ensure_ascii=False, indent=4) + ',\n'
        self.fp.write(data)
        return item

    def close_spider(self, spider):
        print("Spider end！")
        self.fp.close()
