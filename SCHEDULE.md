#### SCHEDULE

##### 第五周

完成结构化文档。

##### 3-27

完成git和github相关配置及Vue-cli和springboot项目框架搭建。

##### 3-28

完成druid数据源基本配置，mybatis基本整合。

**问题：**

①Thymeleaf不指定版本依赖无法引入。（2.3.4可以而2.1.1不行）

**解决：**

版本变更为2.1.1。

##### 3-29

配置logback，ehcache文件。mybatis-plus整合，测试impl的基本功能。

**问题：**

①jackson-dataformat-xml 2.13.1会导致spring内置tomcat无法启动。

**解决：**

切换至2.9.9即可。

②存在SLF4J时，作为简易日志的log4j将失效。

**解决：**

于是切换为logback。

③JUnit的test类无法使用@Autowired？可能是配置有误。

**解决：**

SpringBootTest扫描配置类时未扫描到，需要主动指定：

```java
@SpringBootTest(classes = TifaApplication.class)
```

##### 3-30

配置pagehelper，CURD功能基本实现。测试CURD功能，并移植到前端，测试前后端交互。

**问题：**

①资源引用路径准确，却报404.

**解决：**

使用相对路径访问静态资源应该注意springboot的静态资源目录配置。

**问题：**

②突然报数据库url未配置错误。

**解决：**

maven如果打包方式为jar包需要配置maven让其包含yaml配置文件：

```xml
<include>**/*.yaml</include>
```

**问题：**

③thymeleaf配置文件无法识别？发现这与maven配置有关。原因暂未清楚。

**问题：**

④pagehelper的PageHelp无法拦截成功。

**解决：**

需使用starter配合springboot。

##### **3-31**

配置axios，完善CRUD功能。配置nprogress、lodash、mock、swiper基本功能。

##### **4-1**

测试项目部署。

##### 4-2

整合redis并完成相关配置。尝试完成爬取京东、天猫、淘宝，发现都更新为jsonp传输数据。。。

**解决**

当当网没有使用jsonp模式！可尝试爬取当当。

##### 4-3,4-4

基本完成当当网爬虫，可以根据数据库物品表爬取物品信息，目前最高可4w行json数据，预计最高可至10w。

##### 4.5

编写register和login模块。

**4.6**

写bug。

##### 4.7

基本完成CRUD功能，编写register和login模块。

**问题**

mapgetter一直无效。

**解决**

低级错误，忘记store是以组件形式整合的。

**问题**

actions无法传参。

**解决**

事实上actions最多只能传递两个参数。
