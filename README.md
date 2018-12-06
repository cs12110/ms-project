# ms-project

Spring cloud的微服务架构使用.

---

## 1. 模块说明

- ms-reg: 注册中心模块

- ms-service: 服务提供者模块

- ms-gateway: 路由模块

- ms-config: 统一配置server模块

- ms-caller: feign负载均衡调用模块

---

## 2. 开启流程

请遵循如下开启顺序: **ms-reg -> ms-config -> ms-service -> ms-caller -> ms-gateway.**

ms-config的配置git上面的文件有:`application.properties`,`application-dev.properties`,`application-test.properties`.

因为是测试,三个文件内容全部一致如下

```properties
spiderUrl=http://movie.douban.com

mysql.url=jdbc:mysql://10.10.2.233:3306/ups_web?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&useCursorFetch=true&useSSL=false
mysql.user=root
mysql.password=*********

redis.cluster.host=10.10.2.233:7000,10.10.2.233:7001,10.10.2.234:7000,10.10.2.234:7001,10.10.2.235:7000,10.10.2.236:7001
redis.cluster.auth=haiyan
```

---

## 3. 其他

如有疑问,请联系: `cs12110@163.com`.
