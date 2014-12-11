
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
    <title>*美餐*</title>
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
                <a href="local_express.html">
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
        <div class="span3">
            <div class="well">
                <h4><span class="glyphicon glyphicon-book"></span>查询我的订单</h4>
                <p>
                <p>输入手机号可以查询到您的快递代取订单记录和历史订单记录
                <div class="form-horizontal">
            		<form method="get" action="doSearchOrders.f1t">
	                    <label><input type="text" name="searchCellPhone" class="input input-lg" placeholder="输入您的手机号码"></label>
	                    <div class="controls">
	                        <button type="submit" class="btn btn-primary btn">查询订单</button>
	                    </div>
                    </form>
                    <p>
                <h4><span class="glyphicon glyphicon-calendar"></span>订单查询</h4>
                <p><button class="btn btn-primary" onclick="location='showExpress.f1t'"><strong>添加快递订单</strong></button>
                </div>
            </div>
        </div>
        <div class="span6">
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h2 class="panel-title">我的订单记录 <#if successTips?exists><label class="label label-danger">${successTips}</label><#else><label class="label label-success">查询记录,显示最近20条</label></#if> </h2>
                </div>
                <div class="panel-body">
                	<#if expressOrders?exists>
	                    <table class="table table-bordered table-responsive table-condensed table-striped">
	                       <tr>
	                            <th>姓名</th>
	                            <th>快递</th>
	                            <th>送至</th>
	                            <th>时间</th>
	                            <th>状态</th>
	                       </tr>
	                       <#list expressOrders as order>
		                       <tr>
		                            <td>${order.username}</td>
		                            <td>${order.expressName}</td>
		                            <td>${order.address}</td>
		                            <td>${order.createtime?string("yyyy-MM-dd HH:mm:ss")}</td>
		                            <td>
		                            	<#if order.status==1>
		                            		<label class="label label-warning">等待审核</label>
	                            		<#elseif order.status==2>
	                            			<label class="label label-info">等待领取</label>
                            			<#elseif order.status==3>
	                            			<label class="label label-success">等待送达</label>
                            			<#elseif order.status==4>
	                            			<label class="label label-danger">订单完成</label><span class="glyphicon glyphicon-ok"></span>
                            			<#elseif order.status==5||order.status?exists>
		                            			<label class="label label-danger" id="lbl_${order.id}">已拒绝</label><span class="glyphicon glyphicon-remove"></span>
	                            		</#if>
		                            </td>
		                       </tr>
	                       </#list>
	                    </table>
					<#else>
	                    <div class="well">
	                        <h4>输入手机号码查询校园快递服务记录</h4>
	                    </div>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>

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
