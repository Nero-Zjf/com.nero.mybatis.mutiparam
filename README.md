# Mybatis-传递多个参数 demo
文档：Mybatis-传递多个参数
## 演示了mapper接口如何传递多个参数

## 数据库SQL
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user(id,`name`,sex)
VALUES(1,'tom',1),(2,'jerry',1);
```