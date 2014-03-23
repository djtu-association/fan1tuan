
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
    <script src="./../res/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>*饭1团*</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
    <link href="../res/css/custom/shop.css" rel="stylesheet">
</head>

<div class="sr-only">
    <div id="navReserveSeatIntro" class="row" style="width:100px">
        <div class="tile">
            <img class="tile-image big-illustration" alt="Compas" src="../res/images/icons/png/Compas.png">
            <h3 class="tile-title">当前位置</h3>
            <p>点击重新选择您想要的位置</p>
        </div>
    </div>
    <div id="navLocalLifeIntro" class="row" style="width:100px">
        <div class="tile">
            <img class="tile-image big-illustration" alt="Compas" src="../res/images/icons/png/Gift-Box.png">
            <h3 class="tile-title">校园服务</h3>
            <p>赶紧来感受便捷的校园服务吧</p>
        </div>
    </div>
</div>

<!-- NAVBAR================================================== -->
<body>
<div class="navbar-wrapper" >
    <div class="container">
		<#include "./snippet/front-nav.ftl">
    </div>
</div>

<div style="height: 100px"></div><!-- here is the divider-->

<div class="container-fluid" style="background: #f5f5f5">
    <div class="row-fluid">
        <div class="span1 offset1">
        </div>
        <div class="span2">
            <div>
                <a href="javascript:void(0)">
                <img class="tile-image big-illustration" alt="Compas" src="../res/images/icons/svg/clipboard.svg">
                </a>
            </div>
        </div>
        <div class="span5">
            <div class="hero-unit">
                <h4><label class="label label-info">校园快递代取已经加入校园服务，方便同学代取快递哦</label></h4>
                <br/>
                <h4><label class="label label-warning">目前可代取校区：交大二期</label></h4>
                
           </div>
        </div>
        <div class="span1">

        </div>
        <div style="height: 110px"></div>
    </div>

</div>

<div style="height: 30px"></div><!-- here is the divider-->

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span1 offset1">
        </div>
        <div class="span6">
            <div class="well" style="background: #f5ffff">
            	<h5><span class="glyphicon glyphicon-file"></span>填写代取快递信息</h5>
            	<br/>
                <form class="form" method="post" action="doAddNewOrder.f1t">
                    <ul>
                        <li>
                            <h4><label class="control-label label label-danger">姓名 
                            <input type="text" name="username" class="input-lg" placeholder="包裹收件人">
                            </label>
                            </h4>
                        </li>
                        <li>
                            <div class="nav-divider"></div>
                        </li>
                        <li>
                            <h4><label class="control-label label label-info">手机
                            <input type="text" name="cellphone" class="input-lg" placeholder="联系人手机">
                            </label>
                            </h4>
                        </li>
                        <li>
                            <div class="nav-divider"></div>
                        </li>
                        <li>
                            <h4><label class="control-label label label-primary">送至 
                            <input type="text" name="address" class="input-lg" placeholder="您收取地点(校区-寝室楼)">
                            </label>
                            </h4>
                        </li>
                        <li>
                            <div class="nav-divider"></div>
                        </li>
                        <li>
                            <h4><label class="control-label label label-warning">快递 
                            <input type="text" name="expressName" class="input-lg" placeholder="快递公司名字(如顺丰)">
                            </label>
                            </h4>
                        </li>
                        <li>
                            <div class="nav-divider"></div>
                        </li>
                        <li>
                            <h4>
                            <label class="control-label label label-success">备注 
                            <input type="text" name="remark" class="input-lg" placeholder="备注信息(如大包裹)">
                            </label>
                            </h4>
                        </li>
                        <li>
                            <div class="nav-divider"></div>
                        </li>
                        <li style="left:30px;">
                            <button type="submit" class="btn btn-primary"><strong>提交代取订单</strong></button>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="span3">
            <div class="well" style="height:525px;">
                <h4><span class="glyphicon glyphicon-calendar"></span>快速提交订单</h4>
                <p>快速填写信息，提交您的快递代取订单，并发给校园快递哥
                <p>收费标准：小件2元/件        大件5元/件
                <p>或者你也可以亲自联系校园快递哥
                <p><span class="glyphicon glyphicon-phone"></span>1864088****
                <br/>
                <div class="divider"></div>
                <p>
                <p>
                <h4><span class="glyphicon glyphicon-search"></span>订单查询</h4>
                <p><button class="btn btn-primary" onclick="location='showExpressCheck.f1t'"><strong>查询快递订单</strong></button>
            </div>
        </div>
    </div>
</div>

<div style="height: 30px"></div><!-- here is the divider-->

<!--
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span1 offset1">
        </div>
        <div class="span3">
            <div class="well">
                <h4><span class="glyphicon glyphicon-book"></span>查询我的订单</h4>
                <p>
                <p>输入手机号可以查询到您的快递代取订单记录和历史订单记录
                <div class="form-horizontal">
            		<form method="post" action="doSearchOrders.f1t">
	                    <label><input type="text" name="searchCellPhone" class="input input-lg" placeholder="输入您的手机号码"></label>
	                    <div class="controls">
	                        <button type="submit" class="btn btn-primary btn">查询订单</button>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="span6">
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h2 class="panel-title">我的订单记录</h2>
                </div>
                <div class="panel-body">
                	<#if expressOrders?exists>
	                    <table class="table table-bordered table-responsive table-condensed table-striped">
	                       <tr>
	                            <th>姓名</th>
	                            <th>送至</th>
	                            <th>时间</th>
	                            <th>状态</th>
	                       </tr>
	                       <#list expressOrders as order>
		                       <tr>
		                            <td>${order.username}</td>
		                            <td>${order.address}</td>
		                            <td></td>
		                            <td><label class="label label-info">${order.status}</label></td>
		                       </tr>
	                       </#list>
	                        <tr>
	                            <td>JOE</td>
	                            <td>交大二期5#</td>
	                            <td>2013-11-09</td>
	                            <td><label class="label label-info">已完成</label></td>
	                        </tr>
	                        <tr>
	                            <td>JOE</td>
	                            <td>交大二期5#</td>
	                            <td>2013-11-09</td>
	                            <td><label class="label label-info">已完成</label></td>
	                        </tr>
	                        <tr>
	                            <td>JOE</td>
	                            <td>交大二期5#</td>
	                            <td>2013-11-09</td>
	                            <td><label class="label label-info">已完成</label></td>
	                        </tr>
	                        <tr>
	                            <td>JOE</td>
	                            <td>交大二期5#</td>
	                            <td>2013-11-09</td>
	                            <td><label class="label label-info">已完成</label></td>
	                        </tr>
	                    </table>
					<#else>
	                    <div class="well">
	                        <h4>您似乎还没有使用过我们的快递服务哦~</h4>
	                    </div>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
-->

<div style="height: 50px"></div><!-- here is the divider-->
<!-- FOOTER -->
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>



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
<script src="../res/js/custom/index.js"></script>
<script src="../res/js/holder.js"></script>
<script src="../res/js/custom/shop.js"></script>
</body>
</html>
