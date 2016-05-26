Fan1tuan
========
Fan1tuan is a B2C e-business platform for food sale, providing a lot of features both for shop owners and customers.

Overview
------------
```
Client
  general module - 项目的共同部分，同时包含了项目的配置信息
  order module   - 订单模块，同时包括了购物车功能子模块
  rank module    - 排行模块，包括店铺和菜品的各种排行统计
  search module  - 查询模块，全网内的店铺和菜品的分类和关键字查询
  shop module    - 店铺模块，包括了店铺和菜品信息操作
  user module    - 用户模块，用户为核心的操作
  life module    - 社区或校园生活模块，包括了一些周边的生活便利服务扩展功能
  
Admin
  admin-shop     - 面向商家的后台，店铺管理功能
  admin-express  - 生活服务模块的后台管理
  
WebContent
  一切的assets，都在这里。
```

Configuration
-------------

> 应用详见general模块下的`com.fan1tuan.config`包中的`fan1tuan.properties`文件，在这里列出部分配置信息并作出解释说明。

```
fan1tuan.log=true  # 是否开启日志功能


fan1tuan.display=hello

schemeenforcement.enabled=false # 是否强制使用SSL
securelogin.enabled=false  # 是否开启安全登录
securelogin.http.port=8080 # 安全登录时若scheme为http，使用的端口为
securelogin.https.port=843 # 安全登录时若scheme为https，使用的端口为

fan1tuan.home=http://localhost:8080/index.f1t # 主页地址
```

> 日志配置见general模块下的`com.fan1tuan.config`包中的`log4j2.xml`文件，具体配置见[官网](http://logging.apache.org)。


Screen Shots
------------

> Welcome Page
User will be redirected to visit this age at the very begining.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/1.jpg)

> Select the Area
If User has never selected an area before, this page will be prompted.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/2.jpg)

> Index Page
Index Page contains Shop & Dish Rank List and Dish Recommendations.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/3.jpg)

> Food and Shop Rank list

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/4.jpg)
![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/5.jpg)

> Shop Page
Overview of Shop Page.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/6.jpg)

> You Can see shop info details in this popover.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/7.jpg)

> All the Dishes listed here are grouped.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/8.jpg)

> Hit a dish name and you will see the dish info page slide in from the leftside.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/9.jpg)

> After you sign in the platform, you will see the shopping cart at the bottom.

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/10.jpg)

> Order Page

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/11.jpg)

> User Page

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/12.jpg)

> Orders List

![welcome](https://raw.githubusercontent.com/doomdagger/images/master/fan1tuan/13.jpg)


Who are we
----------
#### **[CodeHolic Teams](https://github.com/CodeRoamer)**
