<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="res/css/bootstrap.css" rel="stylesheet">
    <link href="res/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="res/css/flat-ui.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="./res/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>*美餐*</title>
    <link href="res/css/custom/index.css" rel="stylesheet">
    <link href="res/css/custom/sample.css" rel="stylesheet">
</head>
<body style="background: white">
<span class="col-lg-12"/>

<div class="jumbotron">
    <div class="container">
        <div class="col-lg-12">
            <h1>欢迎来到美餐
                <small></small>
            </h1>
            <p><h4>请选择您所在的商圈</h4></p>
            <p>

            <div class="panel panel-primary">
                <div class="panel-body">
                <#list area as item>
                    <span class="span2">
                		<a href="javascript:void(0);"
                           onclick="location='updateArea.f1t?areaId=${item.id}&areaName=${item.name}&redirect=${redirect!""}'">
                            <div class="palette
                		<#if item_index+1%5 == 1>palette-belize-hole
                		<#elseif item_index+1%5 == 2>palette palette-emerald
                		<#elseif item_index+1%5 == 3>palette palette-carrot
                		<#elseif item_index+1%5 == 4>palette palette-sun-flower
                		<#elseif item_index+1%5 == 0>palette palette-concrete
                		</#if>
                		" style="height: 80px;width: 208px;font-size: 16px;text-align: center;margin-bottom: 35px;">
                            ${item.name}</div>
                        </a></span>
                </#list>
                </div>
            </div>
            </p>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="res/js/jquery-1.8.3.min.js"></script>
<script src="res/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="res/js/jquery.ui.touch-punch.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<script src="res/js/bootstrap-select.js"></script>
<script src="res/js/bootstrap-switch.js"></script>
<script src="res/js/flatui-checkbox.js"></script>
<script src="res/js/flatui-radio.js"></script>
<script src="res/js/jquery.tagsinput.js"></script>
<script src="res/js/jquery.placeholder.js"></script>
<script src="res/js/jquery.pin.min.js"></script>
<script src="res/js/holder.js"></script>
<script src="res/js/custom/chooseArea.js"></script>

</body>
</html>