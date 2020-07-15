<p align="center">
  <a href="" target="_blank">
    <img width="200" src="https://img.juzibiji.top/20200715191757.png" alt="logo">
  </a>
</p>

<p align="center">
  <a href="https://spring.io/">
    <img src="https://img.shields.io/badge/Spring%20Boot-2.3.0.RELEASE-brightgreen" alt="Spring Boot">
  </a>
  <a href="https://mp.baomidou.com/">
    <img src="https://img.shields.io/badge/MyBatis%20Plus-3.3.2-blue" alt="MyBatis Plus">
  </a>
  <a href="https://mybatis.plus/" rel="nofollow">
  <img src="https://img.shields.io/badge/license-MIT-lightgrey.svg" alt="LISENCE" >
  </a>
</p>

## 介绍

OERP 是 Online Examination Registration Platform 的缩写，中文名称为：**在线考试报名平台**。

该仓库是 OERP 服务端代码仓库，使用 SpringBoot + Mybatis Plus + MySQL 实现。

## 快速开始

- 在你的数据库中新建一个名为`oerp`的数据库
- 导入仓库目录`/src/main/resources/oerp.sql`的 SQL 文件
- 修改`/src/main/resources/application.yml`中的`spring.datasource`配置为你自己的数据库信息
- 在 **IDEA** 或 Eclipse 中启动项目



## 目录结构

```
|-- src
    |-- main
        |-- java
        |   |-- com.juzi.oerp
        |       |-- OerpApplication.java   -> SpringBoot 启动类
        |       |-- common                 -> 项目通用类
        |       |   |-- constant           -> 常量
        |       |   |-- exception          -> 自定义异常
        |       |   |-- interceptor        -> 拦截器（身份认证、权限拦截）
        |       |   |-- jackson            -> Jackson 相关
        |       |-- config                 -> 系统配置
        |       |-- controller             -> 系统 API 接口
        |       |-- dao                    -> 自定义 DAO 层接口（主要做多表查询）
        |       |-- mapper                 -> MyBatis Plus Generator 生成的 DAO 接口（主要做单表 CRUD）
        |       |-- model                  -> Java POJO
        |       |   |-- dto                -> 数据传输对象（主要用在 Controller 与 Service 层之间）
        |       |   |-- po                 -> 持久层对象（和数据库表一一对应，用在 DAO 层）
        |       |   |-- vo                 -> 视图层对象（作为 Controller 的返回值）
        |       |-- service                -> 服务层
        |       |-- util                   -> 通用工具类（JWT Token 生成等）
        |-- resources
            |-- application.yml            -> Spring Boot 配置文件
            |-- banner.txt
            |-- oerp.sql                   -> 数据库 SQL 文件（数据库名为 oerp）
            |-- mybatis
                |-- xml
                    |-- dao                -> 自定义 Mybatis Xml
                    |-- mapper             -> MyBatis Plus Generator 生成的 Xml
```
