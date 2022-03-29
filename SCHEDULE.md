#### SCHEDULE

##### 第五周

完成结构化文档。

##### 3-27

完成git和github相关配置及Vue-cli和springboot项目框架搭建。

##### 3-28

完成druid数据源基本配置，mybatis基本整合。

**问题：**

①Thymeleaf不指定版本依赖无法引入。（2.3.4可以而2.1.1不行）

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

