# 成员
乔芳盛 20301167
史庄毅 20301170
王天宇 20301173

# 要求

Assignment 1, A **Shipping and Transportation Web application** Development with Spring MVC and More
	In this assignment, you are asked to develop functions for a shipping and transportation web application.

**_Requirements:_**
1, Using Spring MVC/**Spring boot** + **Spring Data JPA**/Mybatis + **Thymeleaf** for Web Application Development.
2, **Authentication** and **authorization for web access** is necessary.
3, Unit **testing for repository level** and **integration testing controllers** are required.
4, You are encouraged to apply **spring security**, cookies, session management, interceptors /filters to improve the system functions.

# 设计报告
## 总体设计
本项目为物流管理系统，主要分为六个模块：
（1）基础信息管理模块
功能有：商品管理；来往单位；员工管理；仓库管理；
（2）销售信息管理
功能有：销售开票；销售记录；
（3）配送信息管理
功能有：申请配送
（4）运输信息管理
功能：对车辆信息和驾驶员信息进行编辑增加和删除。
（5）系统决策管理
功能：入库商品分析和出库商品分析。
（6）系统信息管理
功能：系统管理员设置各用户的管理权限，同时可以查询修改相关信息。

## 系统设计
前端采用了Thymeleaf引擎，后端使用了 Springboot2，Spring Data JPA框架，数据库采用MySQL

## 开发环境
集成开发环境：IDEA + WebStorm
版本控制工具：Git + GitHub
构建工具：Maven
测试工具：Junit + JMeter
数据库管理工具：Navicat

## 运行截图
![img](Assignment_1_design_report.assets/clip_image004.jpg)

