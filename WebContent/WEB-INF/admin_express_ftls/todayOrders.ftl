<!DOCTYPE html>
<html>
<head>
    <title>快递管理后台</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../../res/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="../../res/plugin/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../res/js/html5shiv.js"></script>
    <script src="../../res/js/respond.min.js"></script>

    <![endif]-->
</head>
<body>



<!--top navigator bar-->
<div>
    <nav class="navbar navbar-default navbar-inverse " role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand " href="#">Fan1Tuan</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <!--left-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Main</a></li><!-- add class="active" @ the current use-->
                <li><a href="#">Admin</a></li>
            </ul>

            <!--right-->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign in</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Log out</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</div>

<!--Main frame-->
<div class=".container">

    <hr class="divider">

    <div class="panel panel-primary">
        <div class="panel-body">
            <div>
                <ul>
                    <li>
                        <h2><strong>快递单管理:今天的快递单一览</strong></h2>
                        <button type="button" class="btn btn-info" onclick="location='showAdminExpressIndex.f1t'">账号信息</button>
                        <button type="button" class="btn btn-info" onclick="location='showHistoryOrders.f1t'">历史订单</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--mid bar-->
    <div>
        <!--head-->

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title"><strong>今天未处理快递单</strong></h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div>
                        <button class="btn btn-warning" onclick="location='doConfirmAllToday.f1t'">一键确认审核</button>
                        <button class="btn btn-info" onclick="location='doFetchAllToday.f1t'">一键确认领取</button>
                        <button class="btn btn-success" onclick="location='doCompleteAllToday.f1t'">一键确认送达</button>
                    </div>
                    <p>
                    <div>
                        <table class="table table-responsive table-bordered">
                            <tr>
                                <th>NO.</th>
                                <th>姓名</th>
                                <th>手机</th>
                                <th>快递</th>
                                <th>地址</th>
                                <th>备注</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            <#if expressOrders?exists&&(expressOrders?size>0)>
                            	<#list expressOrders as order>
		                            <tr>
		                                <td>${order_index+1}</td>
		                                <td>${order.username}</td>
		                                <td>${order.cellphone}</td>
		                                <td>${order.expressName}</td>
		                                <td>${order.address}</td>
		                                <td>${order.remark}</td>
		                                <td>
			                            	<#if order.status==1>
			                            		<label class="label label-warning" id="lbl_${order.id}">等待审核</label>
		                            		<#elseif order.status==2>
		                            			<label class="label label-info" id="lbl_${order.id}">等待领取</label>
	                            			<#elseif order.status==3>
		                            			<label class="label label-success" id="lbl_${order.id}">等待送达</label>
	                            			<#elseif order.status==4>
		                            			<label class="label label-danger" id="lbl_${order.id}">订单完成</label><span class="glyphicon glyphicon-ok"></span>
	                            			<#elseif order.status==5>
		                            			<label class="label label-danger" id="lbl_${order.id}">已拒绝</label><span class="glyphicon glyphicon-remove"></span>
		                            		</#if>
	                                	</td>
		                                <td>
			                            	<#if order.status==1>
			                            		<button class="btn btn-warning btn-sm btn-confirm" id="${order.id}">确认审核</button> <button class="btn btn-primary btn-sm btn-reject" id="btnRej_${order.id}">拒绝</button>
		                            		<#elseif order.status==2>
		                            			<button class="btn btn-info btn-sm btn-fetch" id="${order.id}">确认领取</button>
	                            			<#elseif order.status==3>
		                            			<button class="btn btn-success btn-sm btn-complete" id="${order.id}">确认送达</button>
	                            			<#elseif order.status==4>
		                            			<label class="label label-danger">订单完成</label><span class="glyphicon glyphicon-ok"></span>
	                            			<#elseif order.status==5>
		                            			<label class="label label-danger" id="lbl_${order.id}">已拒绝</label><span class="glyphicon glyphicon-remove"></span>
		                            		</#if>
	                                	</td>
		                            </tr>
	                            </#list>
                            <#else>
                            	<tr><td colspan="8"><h3><strong>当前还没有订单</strong></h3></td></tr>
                            </#if>
                           
                        </table>

                        <!--footer-->
                        <div class="panel" style="float: right;">
                            <ul class="pagination">
                                <li class="disabled"><a href="#">&laquo;</a></li>
                                <li  class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>

                    </div>

                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>
        </div>
    </div>

</div>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script src="../../res/js/custom/express.js"></script>
</body>
</html>