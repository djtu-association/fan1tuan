<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../res/img/favicon.ico">

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
    <title>*美餐*</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
    <link href="../res/css/custom/pendingOrder.css" rel="stylesheet">
</head>
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
                            <a href="/index.f1t"><span >美餐</span></a>
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
</div><!--end of nav -->



<div class="container">
    <div class="row-fluid" style="height: 100px"></div>
    
    <div class="row-fluid">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row-fluid">
                    <div class="col-lg-4">
                        <h6>选择一个地址</h6>
                    </div>
                    <div class="col-lg-4 col-lg-offset-4">
                        <a id="newAddressBtn" class="btn btn-sm btn-primary" href="#fan1tuanModal" role="button" ><i class="fui-new"></i>添加一个地址</a>
                        <!-- Button to trigger modal -->

                        <!-- Modal -->
                        <div id="newAddressModal" class="sr-only">
                            <div class="modal-header" style="height: 50px">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4  class="lead text-info">写一个新地址吧</h4>
                            </div>
                            <div class="modal-body" id="newAddressModalLabel">
                                <form action="/user/ajax/secure/ajaxAddUserAddress.f1t" id="add-address-from"  class="form-horizontal">
                                    <div class="control-group inline-block">
                                        <input type="text" name="cellphone" class="form-control input-sm" placeholder="电话" />
                                        <br>
                                        <input type="text" name="receiver" class="form-control input-sm" placeholder="收餐人" />
                                        <br>
                                    </div>
                                    <div class="control-group">
                                        <input type="text" name="detailAddress" class="form-control input-sm" placeholder="地址" />
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button class="btn" data-dismiss="modal" aria-hidden="true">放弃</button>
                                <button class="btn btn-primary add-address-btn">添加地址</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <table class="table table-hover address-table">
                    
                </table>
            </div>
        </div>
    </div>
    <div class="row-fluid">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <h5>确认订单信息</h5>
            </div>
            <div class="panel-body">
            <#list orders as order>
            	<div data-title="${order.shopId}" class="shopItem">
                    <div class="row-fluid">
                        <div class="span1">
                            <img src="../res/avatar/shop/${order.shopAvatar}" style="width: 64px; height: 64px">
                        </div>
                        <div class="span6">
                            餐厅名称：<span><a class="btn btn-xs btn-info" href="/shop/index.f1t?shopId=${order.shopId}">${order.shopName}</a></span>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <table class="table table-hover">
                            <tr>
                                <th>美食</th>
                                <th>单价</th>
                                <th>数量</th>
                                <th>总价</th>
                                <th></th>
                            </tr>
                            <#list order.dishItems as dishItem>
                            <tr class="dishItem" data-title="${dishItem.dishId}">
                                <td>${dishItem.dishName}</td>
                                <td>¥<span class="dish-price">${dishItem.dishPrice}</span></td>
                                <td>
                                    <div>
                                        <a href="javascript:void(0)" class="subtract-dish-btn" style="float: left;font-size: 25px"><i class="glyphicon glyphicon-minus-sign"></i>&nbsp;</a>
                                        <input class="form-control input-sm dish-number" type="text" maxlength="2" style="width: 42px;float: left" value="${dishItem.number}">
                                        <a href="javascript:void(0)" class="add-dish-btn" style="float: left;font-size: 25px">&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></a>
                                    </div>
                                </td>
                                <td class="text-danger">¥<span class="dish-sum">${dishItem.dishSum}</span></td>
                                <td><button class="close dish-close">X</button> </td>
                            </tr>
                            </#list>                            
                        </table>
                    </div>

                    <div class="row-fluid">
                        <div class="span6">
                            <input data-toggle="tooltip"  name="tagsinput" class="tagsinput" value="少辣,多麻酱" placeholder="输入标签，按回车" />
                        </div>

                        <div class="span2 offset4">
                            <span class="lead">店铺合计：</span><span class="lead text-danger"><strong>¥ <span class="shop-sum">${order.price}</span></strong></span>
                        </div>
                    </div>
                </div>
                <hr>
            
            </#list>
                            
                
                <div class="row-fluid">
                    <div class="span3">
                        <select id="chargeType">
                            <option value="0">餐到付款</option>
                        </select>
                    </div>
                    <div class="span3">
                        <select id="deliveryTime">
                            <option value="${now.getNow()?datetime}">立即送出</option>
                            <option value="${now.getNearestQuarter()?datetime}">${now.getNearestQuarter()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                            <option value="${now.next()?datetime}">${now.nextSleep()?string("HH:mm")}</option>
                        </select>
                    </div>
                    <div class="span4">
                        <span class="featurette-heading text-warning">¥ <span class="all-sum">${sumPrice}</span></span>
                        <br>
                        <span class="lead">共 <span class="all-number">${sumDishNum}</span> 份美食</span>
                    </div>
                    <div class="span1">
                        <button class="btn btn-lg btn-info submit-order">下单</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="height:200px">
</div>

<#include "./snippet/globalModal.ftl" />    


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../res/js/jquery-1.8.3.min.js"></script>
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
<script src="../res/js/custom/order.js"></script>
<script src="../res/js/custom/pendingOrder.js"></script>
<script src="../res/js/holder.js"></script>
<script src="../res/js/custom/publicRedirect.js"></script>

</body>
</html>
