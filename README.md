# 要求
Assignment 3, A shipping and transportation services development with Micro-services Architecture and Spring-Cloud
	 In this assignment, you are asked to refactor the shipping and transportation management server-end using spring cloud.
**_Requirements:_**
1, Re-structuring your shipping and transportation services as **micro-services**.
2, Service discovery with **Eureka** is necessary.
3, **Circuit breaker implementation with Resilience4j** or Hystrix.
4, **Oauth2** authorization server integrated.
5, Expose API to external users with **Gateway**
6, Centralized configuration and tracking with **Spring cloud** config server and sleuth.

# 系统的重构与部署
## 微服务
将项目分解为四部分，分别为api，负责登录注册校验以及用户权限管理；commodity-client，负责商品管理；Driver-client，负责物流运输模块；employee-client，负责公司工作人员管理以及账目管理模块。
# 运行截图
![image-20230610234727676](Assignment_3_design_report.assets/image-20230610234727676.png)

