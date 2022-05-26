# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from logging import log

import pymysql
from itemadapter import ItemAdapter
import json

# 
# @date 2022/4/3
# 管道配置一：存入json文件。
# class TifaPipeline:
#     fp = None
#     def open_spider(self, spider):
#         print("Spider begin!")
#         self.fp = open('data.json', 'a', encoding='utf-8')
#
#     def process_item(self, item, spider):
#         data = json.dumps(dict(item), ensure_ascii=False, indent=4) + ',\n'
#         self.fp.write(data)
#         return item
#
#     def close_spider(self, spider):
#         print("Spider end！")
#         self.fp.close()



class TifaPipeline:

    def __init__(self):
        # 连接数据库
        self.connect = pymysql.connect(
            host='localhost',
            db='tifa',
            user='root',
            passwd='2455851377a',
            charset='utf8',
            use_unicode=True)
        self.countId = 2796

        # 通过cursor执行增删查改
        self.cursor = self.connect.cursor()

    # def process_item(self, item, spider):
    #     try:
    #         # 插入数据
    #         self.cursor.execute(
    #             """insert into product(pid, pname, subTitle, orignalPrice ,promotePrice, stock,createDate)
    #             value (%s, %s, %s, %s, %s, %s, %s)""",
    #             (
    #              self.countId,
    #              item['itemDisc'],
    #              item['subTitle'],
    #              item['orignalPrice'][1:],
    #              item['promotePrice'][1:],
    #              item['stock'],
    #              item['createDate']))
    #         self.cursor.execute(
    #             """insert into category(cid,pid,firstParentCName,secondParentCName,categoryName)
    #             values(%s,%s,%s,%s,%s)""",
    #             (
    #                 self.countId,
    #                 self.countId,
    #                 item['className1'],
    #                 item['className2'],
    #                 item['className3']
    #             )
    #         )
    #         self.cursor.execute(
    #             """insert into productimage(pid,type)
    #             values(%s,%s)""",
    #             (
    #                 self.countId,
    #                 item['itemPic']
    #             )
    #         )
    #         self.countId += 1
    #         # 提交sql语句
    #         self.connect.commit()
    #
    #     except Exception as error:
    #         # 出现错误时打印错误日志
    #         log(error)
    #     return item

    def process_item(self, item, spider):
        try:
            # 插入数据
            self.cursor.execute(
                """insert into product(pid, pname, subTitle, orignalPrice ,promotePrice, stock,createDate)
                value (%s, %s, %s, %s, %s, %s, %s)""",
                (
                 self.countId,
                 item['name'],
                 item['subTitle'] + item['itemDisc'],
                 item['orignalPrice'],
                 item['promotePrice'],
                 item['stock'],
                 item['createDate']))
            self.cursor.execute(
                """insert into category(cid,pid,firstParentCName,secondParentCName,categoryName)
                values(%s,%s,%s,%s,%s)""",
                (
                    self.countId,
                    self.countId,
                    item['className1'],
                    item['className2'],
                    item['className3']
                )
            )
            self.cursor.execute(
                """insert into productimage(pid,type)
                values(%s,%s)""",
                (
                    self.countId,
                    item['itemPic']
                )
            )
            self.countId += 1
            # 提交sql语句
            self.connect.commit()

        except Exception as error:
            # 出现错误时打印错误日志
            log(error)
        return item
