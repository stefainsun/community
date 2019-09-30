## 第一个社区

##资料
[spring 文档](https://spring.io/)  
[bootstrap](https://www.bootcss.com/)  
[菜鸟教程](https://www.runoob.com/java/java-tutorial.html)  
[spring 官方文档](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/#)  
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/)  
[Visual-Paradigm](https://www.visual-paradigm.com/)  
[OKHttp](https://square.github.io/okhttp/)  

##工具
##脚本
```sql
CREATE TABLE USER
(
    ID integer DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A6AA7BE2_61F8_4E23_B8B1_CA5DD0D2D20F) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID varchar(100),
    NAME varchar(50),
    TOKEN varchar(36),
    GMT_CREATE bigint,
    GMT_MODIFIED bigint
)
```