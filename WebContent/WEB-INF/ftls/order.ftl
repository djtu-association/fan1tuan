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
    <title>*饭1团*</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
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
                            <a href="#"><span >Fan1tuan</span></a>
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
        <ul class="breadcrumb">
            <li><a href="#">Fan1tuan</a> <span class="divider"></span></li>
            <li><a href="#">犯罪团伙</a> <span class="divider"></span></li>
            <li class="active">确认饿单</li>
        </ul>
    </div>
    <div class="row-fluid">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row-fluid">
                    <div class="col-lg-4">
                        <h6>选择一个地址</h6>
                    </div>
                    <div class="col-lg-4 col-lg-offset-4">
                        <a id="newAddressBtn" class="btn btn-sm btn-primary" href="#newAddressModal" role="button" data-toggle="modal"><i class="fui-new"></i>添加一个地址</a>
                        <!-- Button to trigger modal -->

                        <!-- Modal -->
                        <div id="newAddressModal" class="modal fade sr-only" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-header" style="height: 50px">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 id="myModalLabe" class="lead text-info">写一个新地址吧</h4>
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
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <tr>
                        <td>
                            <label class="radio" style="font-size: 18px">
                                <input type="radio" name="group1" value="1" data-toggle="radio">
                                <span class="">大连市交通大学二期教学楼</span>
                                <span class="text-muted"><strong>( 李赫 收 )</strong></span>
                                <span class="text-info"><strong>18660809549</strong></span>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="radio" style="font-size: 18px">
                                <input type="radio" name="group1" value="1" data-toggle="radio">
                                <span class="">大连市交通大学二期教学楼</span>
                                <span class="text-muted"><strong>( 李赫 收 )</strong></span>
                                <span class="text-info"><strong>18660809549</strong></span>
                            </label>
                        </td>
                    </tr>
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
                <div class="shopItem">
                    <div class="row-fluid">
                        <div class="span1">
                            <img src="../res/images/shop-image.jpeg">
                        </div>
                        <div class="span6">
                            餐厅名称：<span><a class="btn btn-xs btn-info">犯罪团伙</a></span>
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
                            <tr>
                                <td>原味沙拉鸡排饭</td>
                                <td>¥25</td>
                                <td>
                                    <div>
                                        <a style="float: left;font-size: 25px"><i class="glyphicon glyphicon-minus-sign"></i>&nbsp;</a>
                                        <input class="form-control input-sm" type="text" maxlength="2" style="width: 42px;float: left">
                                        <a style="float: left;font-size: 25px">&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></a>
                                    </div>
                                </td>
                                <td>¥25</td>
                                <td><button class="close">X</button> </td>
                            </tr>
                            <tr>
                                <td>原味沙拉鸡排饭</td>
                                <td>¥25</td>
                                <td>
                                    <div>
                                        <a style="float: left;font-size: 25px"><i class="glyphicon glyphicon-minus-sign"></i>&nbsp;</a>
                                        <input class="form-control input-sm" type="text" maxlength="2" style="width: 42px;float: left">
                                        <a style="float: left;font-size: 25px">&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></a>
                                    </div>
                                </td>
                                <td>¥25</td>
                                <td><button class="close">X</button> </td>
                            </tr>
                        </table>
                    </div>

                    <div class="row-fluid">
                        <div class="span6">
                            <input data-toggle="tooltip"  name="tagsinput" class="tagsinput" value="少辣,多麻酱" placeholder="输入标签，按回车" />
                        </div>

                        <div class="span2 offset4">
                            <span class="lead">店铺合计：</span><span class="lead">¥ 50</span>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="shopItem">
                    <div class="row-fluid">
                        <div class="span1">
                            <img src="../res/images/shop-image.jpeg">
                        </div>
                        <div class="span6">
                            餐厅名称：<span><a class="btn btn-xs btn-info">犯罪团伙</a></span>
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
                            <tr>
                                <td>原味沙拉鸡排饭</td>
                                <td>¥25</td>
                                <td>
                                    <div>
                                        <a style="float: left;font-size: 25px"><i class="glyphicon glyphicon-minus-sign"></i>&nbsp;</a>
                                        <input class="form-control input-sm" type="text" maxlength="2" style="width: 42px;float: left">
                                        <a style="float: left;font-size: 25px">&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></a>
                                    </div>
                                </td>
                                <td>¥25</td>
                                <td><button class="close">X</button> </td>
                            </tr>
                            <tr>
                                <td>原味沙拉鸡排饭</td>
                                <td>¥25</td>
                                <td>
                                    <div>
                                        <a style="float: left;font-size: 25px"><i class="glyphicon glyphicon-minus-sign"></i>&nbsp;</a>
                                        <input class="form-control input-sm" type="text" maxlength="2" style="width: 42px;float: left">
                                        <a style="float: left;font-size: 25px">&nbsp;<i class="glyphicon glyphicon-plus-sign"></i></a>
                                    </div>
                                </td>
                                <td>¥25</td>
                                <td><button class="close">X</button> </td>
                            </tr>
                        </table>
                    </div>

                    <div class="row-fluid">
                        <div class="span6">
                            <input data-toggle="tooltip"  name="tagsinput" class="tagsinput" value="少辣,多麻酱" placeholder="输入标签，按回车" />
                        </div>

                        <div class="span2 offset4">
                            <span class="lead">店铺合计：</span><span class="lead">¥ 50</span>
                        </div>
                    </div>
                </div>

                <hr>
                <div class="row-fluid">
                    <div class="span3 offset3">
                        <select>
                            <option value="0">餐到付款</option>
                            <option value="1">支付宝</option>
                        </select>
                    </div>
                    <div class="span3">
                        <select>
                            <option value="0">立即送出</option>
                            <option value="1">14:30</option>
                            <option value="1">14:45</option>
                            <option value="1">15:00</option>
                            <option value="1">15:15</option>

                        </select>
                    </div>
                    <div class="span2">
                        <span class="featurette-heading text-warning">¥ 100</span>
                        <br>
                        <span class="lead">共 4 份美食</span>
                    </div>
                    <div class="span1">
                        <button class="btn btn-lg btn-info">下单</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
<script src="../res/js/holder.js"></script>
</body>
</html>
