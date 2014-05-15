<!DOCTYPE html>
<html lang="en">
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
    <script src="./js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>搜索也是很简单</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
    <link href="../res/css/custom/shoppingcart.css" rel="stylesheet">
    <link href="../res/css/custom/shop.css" rel="stylesheet">
    <link href="../res/css/custom/pendingOrder.css" rel="stylesheet">
</head>





<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper"  id="top">
    <div class="container">

        <div class="navbar" style="background: #d1f2eb">
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
     
                    <ul class="nav navbar-nav">
                    	<#include "./snippet/userstatus.ftl" />
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
</div>



</body>

</html>
