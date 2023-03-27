# 考试通考试管理系统

## 1.模块介绍

> -- kst-auth					统一认证模块
>
> -- kst-common			公共类模块
>
> -- kst-gatway				网关模块
>
> -- kst-openFeign		  服务调用
>
> -- kst-service-admin	老师和管理员端业务逻辑
>
> -- kst-student				学生端业务逻辑
>
> -- sql								数据库

## 2.技术栈

### 2.1 运行环境

| 环境     | 版本            |
| -------- | --------------- |
| 操作系统 | Windows / Linux |
| NodeJs   | 14              |
| Jdk      | 1.8             |
| Mysql    | 8.0             |

### 2.2后端系统

- SpringBoot 2.2.2.RELEASE
- SpringCloud Hoxton.SR1
- spring-cloud-alibaba 2.1.0.RELEASE
- mysql 8.0.20
- mybatis-plus 持久层
- nacos 注册中心
- openFeign 服务调用
- gatway 网关，拦截器，验证token

### 2.3前端页面连接
https://github.com/caoaxin-max/vue

## 3.展示图
![老师管理员登录页面](https://user-images.githubusercontent.com/63568153/227858985-b96b6b37-fbad-4d5f-8264-789d56bc9a1c.png)

![学生登录页面-1](https://user-images.githubusercontent.com/63568153/227859034-005a6440-141b-4c31-85fd-243d61a3b608.png)

![学生登录页面](https://user-images.githubusercontent.com/63568153/227859051-e77a8dde-2390-4b11-b71b-636b826130f2.png)

![班级管理页面](https://user-images.githubusercontent.com/63568153/227859175-d83f6993-9ff4-4804-8a2b-65c246fd6e54.png)
![老师和管理员试卷分析页面](https://user-images.githubusercontent.com/63568153/227859184-8da8d143-6e43-4607-b3eb-7664c4117be7.png)
![批改完成页面](https://user-images.githubusercontent.com/63568153/227859193-caf5e58e-76bb-4ad9-a89f-bfe5ebde3b7c.png)
![批改页面](https://user-images.githubusercontent.com/63568153/227859194-b6f433f4-a8ff-4572-bb42-83293bf4bf16.png)
![任务管理页面](https://user-images.githubusercontent.com/63568153/227859198-1b3b790e-7ad7-4f9d-b1b4-56f03414f90a.png)
![试卷管理页面](https://user-images.githubusercontent.com/63568153/227859200-d3539f47-7de1-4995-b8bb-9be4d1cb8db5.png)
![题目管理页面](https://user-images.githubusercontent.com/63568153/227859209-50474491-b083-47d9-b536-57bbef98a59e.png)
![学科管理页面](https://user-images.githubusercontent.com/63568153/227859213-f79ed533-7f0f-454b-8ea5-35fcee81a260.png)

![错题本页面 - 副本](https://user-images.githubusercontent.com/63568153/227859309-281e0b21-3e31-42e1-a412-135aedb7bb6c.png)
![错题本页面](https://user-images.githubusercontent.com/63568153/227859389-671cd886-d151-49eb-a72c-e9e44ef79763.png)
![考试记录页面 - 副本](https://user-images.githubusercontent.com/63568153/227859394-4f1dee02-be2e-41f9-b1e6-378e6d1ae8ad.png)
![考试记录页面](https://user-images.githubusercontent.com/63568153/227859396-a6c8b948-9a4d-402f-b904-dcc2ab68d402.png)
![考试页面](https://user-images.githubusercontent.com/63568153/227859401-438b11ec-168c-487d-ac3f-7cd3a4a60d20.png)
![学生端试卷分析页面](https://user-images.githubusercontent.com/63568153/227859406-46ef3890-52d5-4816-b6e1-7525304de89b.png)
