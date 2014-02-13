<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="../res/css/bootstrap.css" rel="stylesheet">
    <link href="../res/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../res/css/flat-ui.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../res/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>*饭1团*</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
    <link href="../res/css/custom/user.css" rel="stylesheet">
    <link href="../res/css/jquery-ui-smoothness.css" rel="stylesheet">
    <link href="../res/css/custom/favorite.css" rel="stylesheet">
    <link href="../res/css/custom/comments.css" rel="stylesheet">
    <link href="../res/css/custom/pendingOrder.css" rel="stylesheet">
    <!--<link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet">-->
</head>


<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper"  id="top">
    <div class="container">

        <div class="navbar">
            <div class="navbar-header">
                <button data-target="#nav-collapse-01" data-toggle="collapse" class="btn btn-navbar" type="button"></button>
            </div>
            <div id="nav-collapse-01" class="navbar-collapse collapse">
                    <ul class="nav">
                    	
                        <li>
                            <a href="/index.f1t"><span >Fan1tuan</span></a>
                        </li>
                        
                        <li id="navOnlineOrder"   title="" data-toggle="popover">
                            <a href="javascript:void(0)" id="toOnline"><span class="fui-cmd"></span><span >在线订餐</span></a>
                        </li>
                        <li id="navPhoneCallOrder" title="" data-toggle="popover">
                            <a href="javascript:void(0)" id="toPhone"><span class="fui-chat"></span><span >电话订餐</span></a>
                        </li>
                        
                        
                        <!-- <li id="" title="" data-toggle="">
                            <a href="javascript:void(0)" id="navReserveSeat" onclick="location='areas.f1t'"><span class="fui-location"></span><span ><#if areaName?exists>${areaName}</#if></span></a>
                        </li> -->
                        
                        <!--<li id="navLifeSurround" title="" data-toggle="popover">
                            <a href="javascript:void(0)" onclick="location='../life/index.f1t'"><span class="fui-location"></span><span >本地生活</span></a>
                        </li>-->
				
                    </ul>
     
                    
                    <form class="navbar-form navbar-left form-inline pull-right" role="search">
                        <div class="input-group">
                            <div class="form-group">
                                <input id="searchField" type="text" class="form-control" size="25" placeholder="搜店.搜美食" />
                                <span class="input-icon fui-search"></span>
                            </div>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</div><!--end of nav -->

<div class="container-fluid" style="background: antiquewhite">
    <div id="header">
        <div class="hp-common-header <#if morning>theme-morning</#if>">
            <div class="cm-bd">
                <div class="hp-user-info">
                    <div class="hd">
                        <img alt="#" src="../res/img/avatar.jpg" class="user-pic">
                    </div>
                    <div class="bd">
                        <div class="info">
                            <p class="line">
                                <strong class="name lead">
                                    光明的一线2010
                                </strong>
                                <a target="_blank">
                                    <i class="glyphicon glyphicon-user"></i>
                                </a>
                            </p>
                            <p class="line">

                            </p>
                            <div class="line">
                                <span data-day="19" data-month="11"  class="badge">男</span>
                                <i class="dot"></i>
                                <span data-day="19" data-month="11"  class="badge">天蝎座</span>
                                <i class="dot"></i>
                                <span data-day="19" data-month="11"  class="badge">大连交通大学</span>
                                <!-- 可以 data-* 属性来为js提供可存储值 -->
                                <div data-url="" style=""  class="medal">
                                </div>
                            </div>
                        </div>
                        <div data-url="http://my.taobao.com/homepage/ajax/get_user_info.json?user_id=646701379" id="J_HomePageSNS" class="sns">
                            <p class="line edit-btn">
                                <a href="#" target="_blank" class="btn btn-inverse">编辑资料</a>
                            </p>
                            <ul class="user-atten">
                                <li class="atten-item fans">
                                    <a class="atten-link " href="#">
                                        <strong class="J_FansCount">15</strong>
                                        <span>
                                            粉丝
                                        </span>
                                    </a>
                                </li>
                                <li class="atten-item follow">
                                    <a class="atten-link" href="#">
                                        <strong class="J_FollowCount">8</strong>
                                        <span>
                                            关注
                                        </span>
                                    </a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="cm-ft">
                <div id="J_HomePageNav" class="hp-nav">
                    <div class="hd">
                    </div>
                    <div class="bd">
                        <ul class="nav-list">
                            <li class="nav-item">
                                <a href="#" class="nav-link s-active" data-id="orders">
                                    饿单中心
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-id="favorites">
                                    收藏与足迹
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-id="comments">
                                    我的评价
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-id="info">
                                    账户信息
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div id="main_container" class="container-fluid">

<!-- 订单 -->
<div data-mapped="orders" class="">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
        </div>
        <div class="span2"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"> </div>
        <div class="span10">
            <div class="well order_cat">
                <span class="text text-primary"><a href="" class="">全部订单</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="text text-primary"><a href="" class="">待卖家受理</a><span class="badge">2</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="text text-primary"><a href="" class="">待确认收货</a><span class="badge">2</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="text text-primary"><a href="" class="">待评价</a><span class="badge">2</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <div class="span1"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"> </div>
        <div class="span10">
            <div class="panel panel-info">
                <div class="panel-body">
                    <form class="form-inline">
                        <input type="text" placeholder="菜品名称" class="form-control" style="width: 300px" />
                        <button class="btn btn-info btn-sm"><span class="lead" style="font-size: 16px">搜 索</span></button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="" class="lead add-order-filter" style="font-size: 13px">更多筛选条件<i class="glyphicon glyphicon-circle-arrow-down"></i> </a>
                        <div class="order-filter sr-only">
                            <input type="text" placeholder="起始日期" class="form-control flat datepicker" style="width: 180px">
                            <input type="text" placeholder="终止日期" class="form-control flat datepicker" style="width: 180px">
                            <input type="text" placeholder="店铺名称" class="form-control flat" style="width: 250px" />
                            <select multiple="multiple" title="订单状态">
                                <option value="0">待卖家受理</option>
                                <option value="1">待确认收货</option>
                                <option value="2">待评价</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"></div>
        <div class="span10">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row-fluid">
                        <div class="span3">
                            <span>订单编号：475410327737913</span>
                        </div>
                        <div class="span3">
                            <span>成交时间：2013-12-11 09:06</span>
                        </div>
                        <div class="span3">
                            <span>西北面食</span>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <td style="width: 50px">
                                <a href="#"><img src="../res/images/shop-image.jpeg"></a>
                            </td>
                            <td colspan="2">
                                <span class="text text-primary lead"><a href="#">蔬菜拌饭</a></span><br>
                                <span class="text"><span class="label label-primary">备注</span>&nbsp;&nbsp;&nbsp;少辣，多醋，不要糖</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">11</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">1</span>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center;vertical-align: baseline">
                                <strong class="lead">22.00</strong><br>
                                <span class="label label-info">手机订单</span>
                            </td>
                            <td colspan="3" rowspan="2" style="text-align: center;vertical-align: baseline;">
                                <strong class="lead">大连市旅顺口区行发路216号</strong><br>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center">
                                <span class="label label-warning lead" style="font-size: 17px">交易成功</span><br><br>
                                <span class="label label-info lead" style="font-size: 17px">已评价</span>
                            </td>
                            <td colspan="2" style="text-align: center;vertical-align: baseline;">
                                <div class="btn-group">
                                    <a href="#" class="btn btn-info">再次购买</a>
                                    <a href="#" class="btn btn-default">评价</a>
                                </div>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center">
                                <div class="btn-group">
                                    <a href="#" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                    <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-share"></i></a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50px">
                                <a href="#"><img src="../res/images/shop-image.jpeg"></a>
                            </td>
                            <td colspan="2">
                                <span class="text text-primary lead"><a href="#">蔬菜拌饭</a></span><br>
                                <span class="text"><span class="label label-primary">备注</span>&nbsp;&nbsp;&nbsp;少辣，多醋，不要糖</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">11</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">1</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row-fluid">
                        <div class="span3">
                            <span>订单编号：475410327737913</span>
                        </div>
                        <div class="span3">
                            <span>成交时间：2013-12-11 09:06</span>
                        </div>
                        <div class="span3">
                            <span>西北面食</span>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <td style="width: 50px">
                                <a href="#"><img src="../res/images/shop-image.jpeg"></a>
                            </td>
                            <td colspan="2">
                                <span class="text text-primary lead"><a href="#">蔬菜拌饭</a></span><br>
                                <span class="text"><span class="label label-primary">备注</span>&nbsp;&nbsp;&nbsp;少辣，多醋，不要糖</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">11</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">1</span>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center;vertical-align: baseline">
                                <strong class="lead">22.00</strong><br>
                                <span class="label label-info">手机订单</span>
                            </td>
                            <td colspan="3" rowspan="2" style="text-align: center;vertical-align: baseline;">
                                <strong class="lead">大连市旅顺口区行发路216号</strong><br>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center">
                                <span class="label label-warning lead" style="font-size: 17px">交易成功</span><br><br>
                                <span class="label label-info lead" style="font-size: 17px">已评价</span>
                            </td>
                            <td colspan="2" style="text-align: center;vertical-align: baseline;">
                                <a href="#" class="btn btn-primary">确认收货</a>
                            </td>
                            <td colspan="2" rowspan="2" style="text-align: center">
                                <div class="btn-group">
                                    <a href="#" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                    <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-share"></i></a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50px">
                                <a href="#"><img src="../res/images/shop-image.jpeg"></a>
                            </td>
                            <td colspan="2">
                                <span class="text text-primary lead"><a href="#">蔬菜拌饭</a></span><br>
                                <span class="text"><span class="label label-primary">备注</span>&nbsp;&nbsp;&nbsp;少辣，多醋，不要糖</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">11</span>
                            </td>
                            <td colspan="1">
                                <span class="lead">1</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
</div>


<!-- 收藏 -->
<div data-mapped="favorites" class="sr-only">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
        </div>
        <div class="span2"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"></div>
        <div class="span10">
            <ul class="nav nav-tabs" id="myTab">
                <li class="active"><a data-toggle="tab" href="#fav_shops">店铺收藏</a></li>
                <li class=""><a data-toggle="tab" href="#fav_dishes">菜品收藏</a></li>
                <li class=""><a data-toggle="tab" href="#my_steps">我的足迹</a></li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div id="fav_shops" class="tab-pane fade active in">
                    <div class="row-fluid">
                        <div style="height: 30px"></div>
                        <div class="span12" style="padding-left: 0px;margin-left: 0px">
                            <ul id="J_FavList" class="fav-shop-list J_FavList" style="padding-left: 0px;margin-left: 0px">
                                <li class="shop-item clearfix J_FavListItem">
                                    <div class="shop-some-info">
                                        <div class="shop-item-m">
                                            <a target="_blank" href="#" class="shop-icon">
                                                <span class="png50"></span>
                                                <img width="50" height="50" alt="" src="../res/images/shop-image.jpeg">
                                            </a>
                                            <div class="shop-detail">
                                                <a title="" target="_blank" href="#" class="shop-title ">
                                                    西北牛肉面
                                                </a>

                                                <p class="shop-desc">
                     <span class="shop-desc-text">
                        <a target="_blank" href="#">
                            奶茶，汉堡，料理
                        </a>
                     </span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="shop-item-c clearfix">
                                            <a  href="#" class="cancel-up" ><i class="icon-rst-rating s9"></i></a>
                                            <div class="shop-item-c-info">
                                                <div class="remark J_Remark">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="shop-item-sn">
                                            <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                            <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-share"></i></a>
                                        </div>

                                        <div class="shop-item-s">
                                            <a target="_blank" href="#" class="similar-shop-btn">相似店铺</a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>

                                        </div>
                                    </div>

                                    <div data-href="" class="shop-show">
		    <span class="shop-show-tab">
    			        <ul class="nav nav-tabs" id="myTab">
                            <li class="active"><a data-toggle="tab" href="#">店铺热卖</a></li>
                            <li class=""><a data-toggle="tab" href="#">掌柜推荐</a></li>
                            <li class=""><a data-toggle="tab" href="#">店铺促销</a></li>
                            <li class=""><a data-toggle="tab" href="#">我买过的</a></li>
                        </ul>
    	    </span>
                                        <div class="carousel-container latestUp-tab" style="">
                                            <div style="display: none;" class="loading-j">请稍候</div>
                                            <div class="ul-container">
                                                <ul style="position: absolute;" class="shop-show-container ks-switchable-content">
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="shop-item clearfix J_FavListItem">
                                    <div class="shop-some-info">
                                        <div class="shop-item-m">
                                            <a target="_blank" href="#" class="shop-icon">
                                                <span class="png50"></span>
                                                <img width="50" height="50" alt="" src="../res/images/shop-image.jpeg">
                                            </a>
                                            <div class="shop-detail">
                                                <a title="" target="_blank" href="#" class="shop-title ">
                                                    西北牛肉面
                                                </a>

                                                <p class="shop-desc">
                     <span class="shop-desc-text">
                        <a target="_blank" href="#">
                            奶茶，汉堡，料理
                        </a>
                     </span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="shop-item-c clearfix">
                                            <a  href="#" class="cancel-up" ><i class="icon-rst-rating s9"></i></a>
                                            <div class="shop-item-c-info">
                                                <div class="remark J_Remark">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="shop-item-sn">
                                            <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                            <a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-share"></i></a>
                                        </div>

                                        <div class="shop-item-s">
                                            <a target="_blank" href="#" class="similar-shop-btn">相似店铺</a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>
                                            <a data-spm="d4912213" target="_blank" href="#">
                                                <img src="../res/images/shop-image.jpeg">
                                            </a>

                                        </div>
                                    </div>

                                    <div data-href="" class="shop-show">
		    <span class="shop-show-tab">
    			        <ul class="nav nav-tabs" id="myTab">
                            <li class="active"><a data-toggle="tab" href="#">店铺热卖</a></li>
                            <li class=""><a data-toggle="tab" href="#">掌柜推荐</a></li>
                            <li class=""><a data-toggle="tab" href="#">店铺促销</a></li>
                            <li class=""><a data-toggle="tab" href="#">我买过的</a></li>
                        </ul>
    	    </span>
                                        <div class="carousel-container latestUp-tab" style="">
                                            <div style="display: none;" class="loading-j">请稍候</div>
                                            <div class="ul-container">
                                                <ul style="position: absolute;" class="shop-show-container ks-switchable-content">
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                    <li class="item-show">
                                                        <a title="" class="item-link" target="_blank" href="#">
                                <span class="img-wrap">
                                    <img src="../res/images/shop-image.jpeg" width="160" height="160" alt="">
                                </span>
                                                        </a>
                                                        <div class="cont">
                                                            <div class="g_price"><span>￥</span><strong>29.89</strong></div>
                                                            <div class="g_price g_price-original"><span>￥</span>299.00</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="fav_dishes" class="tab-pane fade">
                    <div class="row-fluid">
                        <div class="span12">
                            <div style="height: 30px"></div>
                            <div id="fav-list">
                                <ul class="grid img-item-list J_FavList clearfix">
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                    <li data-item-id="19520808823"  class="g-u J_FavListItem ">
                                        <div class="img-controller-box J_FavImgController">
                                            <a title="奥尔良煎肉饭"  target="_blank" class="img" href="#" >
                                                <img src="../res/images/shop-image.jpeg" width="210" height="210">
                                            </a>
                                            <div class="pop-rec J_PopRec">
                                                <a target="_blank" href="#" >找相似</a>
                                                <a target="_blank" href="#" >找搭配</a>
                                                <a target="_blank" href="#" >同店收藏</a>
                                                <div title="分享" class="gray floatright sns-widget J_NewPoint sns-sharebtn sns-widget-ui sns-sharebtn-custom">分享</div>
                                            </div>
                                            <div class="old-data-del">
                                            </div>
                                        </div>
                                        <div class="img-item-title">
                                            <i class="glyphicon glyphicon-tag"></i>
                                            <a  href="#" target="_blank" title="">
                                                奥尔良煎肉饭
                                            </a>
                                        </div>
                                        <div class="price-container">
                                            <div class="tagForSale" title="两件130">送加多宝</div>
                                            <div class="g_price"><span>￥</span><strong>14.00</strong>
                                            </div>
                                            <div class="g_price g_price-original"><span>￥</span><strong style="text-decoration: line-through">22.00</strong></div>
                                        </div>
                                        <div class="item-controller">
                                            <a title="删除" href="#" class="J_FavDel fav-item-del miconfont J_NewPoint"><i class="glyphicon glyphicon-trash"></i></a>|
                                            <a title="进入店铺" target="_blank" href="#" class="goto-shop miconfont"><i class="glyphicon glyphicon-home"></i></a>
                                            |<a href="#" title="加入购物车" class="J_AddToCartBtnTgr cart-icon miconfont J_NewPoint" ><i class="glyphicon glyphicon-shopping-cart"></i></a>	</div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="my_steps" class="tab-pane fade">
                    <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
</div>

<!-- 评论 -->
<div data-mapped="comments" class="sr-only">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
        </div>
        <div class="span2"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"></div>
        <div class="span10">
            <div class="panel panel-info">
                <div class="panel-body">
                    <form class="form-inline">
                        <input type="text" placeholder="菜品名称" class="form-control" style="width: 300px" />
                        <button class="btn btn-info btn-sm"><span class="lead" style="font-size: 16px">搜 索</span></button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="" class="lead add-comments-filter" style="font-size: 13px">更多筛选条件<i class="glyphicon glyphicon-circle-arrow-down"></i> </a>
                        <div class="comments-filter sr-only">
                            <br>
                            <input type="text" placeholder="起始日期" class="form-control flat datepicker" style="width: 180px">
                            <input type="text" placeholder="终止日期" class="form-control flat datepicker" style="width: 180px">
                            <input type="text" placeholder="店铺名称" class="form-control flat" style="width: 250px" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"></div>
        <div class="span10">
            <div class="comment_list">
                <div data-rid="0" class="my-comment-item interact-box">
                    <div class="comment-box">
                        <div class="pic-box">
                            <div class="pic s160">
                                <a title="" target="_blank" href="#">
                                    <img alt="" src="../res/images/shop-image.jpeg" width="160" height="160" />
                                </a>
                            </div>
                            <div class="g_price g_price-reversed">
                                <span>¥</span><span>2</span>
                            </div>
                        </div>
                        <div class="item-right">
                            <div class="comment c3 lead" style="font-size: 20px">
                                “买的东西有点多，就不一一评价啦，东西一件都没少，尝了几样，都很好吃，快递很棒，下回还会来的”
                            </div>
                            <ul class="img-list clearfix">

                            </ul>
                            <div class="item-right-ft clearfix">

                                <span class="date c9 l-left">
                                    1月前发表
                                </span>
                                <div class="btns-area l-right  clearfix">
                                    <a  href="#" title="" class="btn btn-danger btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-trash"></i> <span class="icon iconfont btn-tip">删除</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-info btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-shopping-cart"></i> <span class="icon iconfont btn-tip">再次购买</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-primary btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-home"></i> <span class="icon iconfont btn-tip">西北面食</span></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="cont">
                        <div style="display:none;" class="cont-bd">
                        </div>
                    </div>
                    <div class="act-area-flat">
                        <div class="J_CommentHd">
                        </div>
                    </div>
                </div>
                <div data-rid="0" class="my-comment-item interact-box">
                    <div class="comment-box">
                        <div class="pic-box">
                            <div class="pic s160">
                                <a title="" target="_blank" href="#">
                                    <img alt="" src="../res/images/shop-image.jpeg" width="160" height="160" />
                                </a>
                            </div>
                            <div class="g_price g_price-reversed">
                                <span>¥</span><span>2</span>
                            </div>
                        </div>
                        <div class="item-right">
                            <div class="comment c3 lead" style="font-size: 20px">
                                “买的东西有点多，就不一一评价啦，东西一件都没少，尝了几样，都很好吃，快递很棒，下回还会来的”
                            </div>
                            <ul class="img-list clearfix">

                            </ul>
                            <div class="item-right-ft clearfix">

                                <span class="date c9 l-left">
                                    1月前发表
                                </span>
                                <div class="btns-area l-right  clearfix">
                                    <a  href="#" title="" class="btn btn-danger btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-trash"></i> <span class="icon iconfont btn-tip">删除</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-info btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-shopping-cart"></i> <span class="icon iconfont btn-tip">再次购买</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-primary btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-home"></i> <span class="icon iconfont btn-tip">西北面食</span></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="cont">
                        <div style="display:none;" class="cont-bd">
                        </div>
                    </div>
                    <div class="act-area-flat">
                        <div class="J_CommentHd">
                        </div>
                    </div>
                </div>
                <div data-rid="0" class="my-comment-item interact-box">
                    <div class="comment-box">
                        <div class="pic-box">
                            <div class="pic s160">
                                <a title="" target="_blank" href="#">
                                    <img alt="" src="../res/images/shop-image.jpeg" width="160" height="160" />
                                </a>
                            </div>
                            <div class="g_price g_price-reversed">
                                <span>¥</span><span>2</span>
                            </div>
                        </div>
                        <div class="item-right">
                            <div class="comment c3 lead" style="font-size: 20px">
                                “买的东西有点多，就不一一评价啦，东西一件都没少，尝了几样，都很好吃，快递很棒，下回还会来的”
                            </div>
                            <ul class="img-list clearfix">

                            </ul>
                            <div class="item-right-ft clearfix">

                                <span class="date c9 l-left">
                                    1月前发表
                                </span>
                                <div class="btns-area l-right  clearfix">
                                    <a  href="#" title="" class="btn btn-danger btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-trash"></i> <span class="icon iconfont btn-tip">删除</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-info btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-shopping-cart"></i> <span class="icon iconfont btn-tip">再次购买</span></span>
                                    </a>
                                    <a  href="#" title="" class="btn btn-primary btn-sm">
                                        <span class="border"><i class="glyphicon glyphicon-home"></i> <span class="icon iconfont btn-tip">西北面食</span></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="cont">
                        <div style="display:none;" class="cont-bd">
                        </div>
                    </div>
                    <div class="act-area-flat">
                        <div class="J_CommentHd">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
</div>

<!-- 账户信息 -->
<div data-mapped="info" class="sr-only">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
        </div>
        <div class="span2"></div>
    </div>
    <div class="row-fluid">
        <div class="span1"></div>
        <div class="span10">
            <ul class="nav nav-tabs" id="infoTab">
                <li class="active"><a data-toggle="tab" href="#personal_info">个人资料</a></li>
                <li class=""><a data-toggle="tab" href="#my_address">收餐地址</a></li>
                <li class=""><a data-toggle="tab" href="#my_security">安全设置</a></li>
            </ul>
            <div class="tab-content" id="infoTabContent">
                <div id="personal_info" class="tab-pane fade active in">
                    <div style="height: 30px"></div>
                    <div class="row-fluid">
                        <div class="span4">
                            <form class="form-horizontal">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <label class="control-label lead" for="realName">真实姓名</label>
                                    </div>
                                    <div class="col-lg-8">
                                        <div class="form-group has-error">
                                            <input id="realName" type="text" class="form-control" placeholder="真实姓名" />
                                            <span class="input-icon fui-cross"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-4">
                                        <label class="control-label lead" for="qq">QQ</label>
                                    </div>
                                    <div class="col-lg-8">
                                        <div class="form-group has-success">
                                            <input id="qq" type="text" class="form-control" placeholder="QQ" />
                                            <span class="input-icon fui-check"></span>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-primary">保存</button>
                                <button class="btn btn-default">重置</button>
                            </form>
                        </div>
                        <div class="span7">
                            <img src="../res/images/shop-image.jpeg" style="width: 140px;height: 140px;"  class="img-polaroid">
                            <br><br>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info btn-lg">上传头像</button>
                        </div>
                    </div>
                </div>
                <div id="my_address" class="tab-pane fade">
                    <div style="height: 30px"></div>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <div class="row-fluid">
                                        <div class="col-lg-4">
                                            <h5>已有地址</h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-hover">
                                        <tr>
                                            <td>
                                                <i class="fui-location"></i>
                                                <span class="lead">大连市交通大学二期教学楼</span>
                                                <span class="lead"><strong>( 李赫 收 )</strong></span>
                                                <span class="lead"><strong>18660809549</strong></span>
                                            </td>
                                            <td>
                                                <a href="#" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                                <a class="btn btn-primary btn-sm" href="#newAddressModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-pencil"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <i class="fui-location"></i>
                                                <span class="lead">大连市交通大学二期教学楼</span>
                                                <span class="lead"><strong>( 李赫 收 )</strong></span>
                                                <span class="lead"><strong>18660809549</strong></span>
                                            </td>
                                            <td>
                                                <a href="#" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                                                <a class="btn btn-primary btn-sm" href="#newAddressModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-pencil"></i></a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h5>添加一个地址</h5>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal">
                                        <div class="row-fluid">
                                            <div class="span2">
                                                <label class="control-label lead" for="address">收餐地址</label>
                                            </div>
                                            <div class="span4">
                                                <div class="form-group has-error">
                                                    <input id="address" type="text" class="form-control" placeholder="收餐地址" />
                                                    <span class="input-icon fui-cross"></span>
                                                </div>
                                            </div>
                                            <div class="span7"></div>
                                        </div>
                                        <div class="row-fluid">
                                            <div class="span2">
                                            </div>
                                            <div class="span2" >
                                                <div  data-toggle="tooltip" title="是否本人取餐" class="switch switch-square"
                                                     data-on-label="<i class='fui-check'></i>"
                                                     data-off-label="<i class='fui-cross'></i>">
                                                    <input  type="checkbox" />
                                                </div>
                                            </div>
                                            <div class="span8"></div>
                                        </div>
                                        <br>
                                        <div class="row-fluid">
                                            <div class="span2">
                                                <label class="control-label lead" for="receiver">收餐人姓名</label>
                                            </div>
                                            <div class="span2">
                                                <div class="form-group has-success">
                                                    <input id="receiver" type="text" class="form-control" placeholder="收餐人姓名" />
                                                    <span class="input-icon fui-check"></span>
                                                </div>
                                            </div>
                                            <div class="span8"></div>
                                        </div>
                                        <div class="row-fluid">
                                            <div class="span2">
                                                <label class="control-label lead" for="receiver-cellphone">收餐人手机号</label>
                                            </div>
                                            <div class="span4">
                                                <div class="form-group has-warning">
                                                    <input id="receiver-cellphone" type="text" class="form-control" placeholder="收餐人手机号" />
                                                    <span class="input-icon fui-gear"></span>
                                                </div>
                                            </div>
                                            <div class="span7"></div>
                                        </div>
                                        <button class="btn btn-primary">添加</button>
                                        <button class="btn btn-default">重置</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="my_security" class="tab-pane fade">
                    <div class="row-fluid">
                        <div style="height: 30px"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
</div>

</div>


<!-- Modal -->
<div id="newAddressModal" style="display: none;" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header" style="height: 40px">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 id="myModalLabe" class="lead text-info">编辑地址</h4>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group inline-block">
                <input type="text" class="form-control input-sm" placeholder="电话" />
                <br>
                <input type="text" class="form-control input-sm" placeholder="收餐人" />
                <br>
            </div>
            <div class="control-group">
                <input type="text" class="form-control input-sm" placeholder="地址" />
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">放弃</button>
        <button class="btn btn-primary">添加地址</button>
    </div>
</div>


<div style="height: 30px"></div>


<div style="height: 1000px"></div>


<!-- FOOTER -->
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../res/js/jquery-1.8.3.min.js"></script>
<script src="../res/js/jquery-ui-1.10.3.js"></script>
<script src="../res/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="../res/js/jquery.ui.touch-punch.min.js"></script>
<script src="../res/js/bootstrap.min.js"></script>
<script src="../res/js/bootstrap-select.js"></script>
<script src="../res/js/bootstrap-switch.js"></script>
<script src="../res/js/flatui-checkbox.js"></script>
<script src="../res/js/flatui-radio.js"></script>
<script src="../res/js/jquery.tagsinput.js"></script>
<script src="../res/js/jquery.placeholder.js"></script>
<script src="../res/js/jquery.pin.min.js"></script>
<script src="../res/js/custom/index.js"></script>
<script src="../res/js/holder.js"></script>
<script src="../res/js/custom/user.js"></script>
<script src="../res/js/custom/pendingOrder.js"></script>
</body>
</html>
