<!DOCTYPE html>
<html>
<head>
<#include "./sinppet/admin-head.ftl">
</head>
<body>



<!--top navigator bar-->
<#include "./sinppet/admin-topnav.ftl">

<!--Main frame-->
<div class=".container">

    <!--head of center body-->
    <#include "./sinppet/admin-leftnav.ftl">

    <!--mid bar-->
    <div style="float: left;width: 80%">

        <!--center-->
        <div>

            <div class="panel panel-info">

                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="showShopList.f1t">商铺管理</a></li>
                        <li class="active">历史订单</li>
                    </ol>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <h3>店铺<#if shopName?exists> : ${shopName} </#if> </h3>
                    <!--datePicker-->
                    <div>
                        <div>
                            <div>
                                <label>
                                    <div class="input-group date col-md-5"  data-link-field="dtp_input1">
                                        <input class="form-control form_date" data-date-format="yyyy-mm-dd" size="80" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                </label>
                                <input type="hidden" id="dtp_input1" value="" /><br/>
                            </div>
                        </div>
                    </div>
                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>
        </div>

        <!--panel center-->
        <div class="panel panel-info">
            <div class="panel-heading">
                <label>
                    <h3><span class="glyphicon glyphicon-shopping-cart"/>历史订单</h3>
                </label>
            </div>
            <div>
                <table class="table table-hover table-bordered table-responsive">
                    <tr>
                        <th>NO.</th>
                        <th>订单编号</th>
                        <th>用户ID(点击可查看用户详情)</th>
                        <th>订单价格</th>
                        <th>订单状态</th>
                        <th>管理</th>
                    </tr>
                    <#if orderList?exists&&(orderList?size>0)>
                    	<#list orderList as order>
		            		<tr>
		                        <td>${order_index+1}</td>
		                        <td>${order.orderNo}</td>
		                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">${order.userId}</td>
		                        <td>${order.price}</td>
		                        <td>
		                        	<#if order.status == 0>
		                        		<span class="label label-success">done</span>
	                        		<#elseif order.status ==1>
	                        			<span class="label label-warning">undone</span>
	                        		<#else>
	                        			<span class="label label-danger">unpay</span>
		                        	</#if>
		                        </td>
		                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel" id="${order.id}">删除</button></td>
		                    </tr>
                    	</#list>
                	<#else>
                		<tr>
                			<td colspan="6" style="text-align:center"><h3><strong>目前还没有订单</strong></h3></td>
                    	</tr>
                    </#if>
                </table>
            </div>
        </div>

        <!--panel footer-->
        <div style="text-align: right">
            <ul class="pagination">
	            <#if orderListPage?exists>
	            	<#if (orderListPage.currentPage>1)>
	            		<li><a href="showShopOrders.f1t?shopId=${shopId}&orderPage=${orderListPage.currentPage-1}" >&laquo;</a></li>
	            	<#else>
	            		<li class="disabled"><a>&laquo;</a></li>
	            	</#if>
	            	
	    			<#list 1..orderListPage.pageCount as num>
	    				<#if orderListPage.currentPage == num>
	    					<li class="active"><a>${num}</a></li>
	    				<#else>
	    					<li><a href="showShopOrders.f1t?shopId=${shopId}&orderPage=${num}">${num}</a></li>
	    				</#if>
	    			</#list>
	    			
	    			<#if (orderListPage.currentPage<orderListPage.pageCount)>
	            		<li><a href="showShopOrders.f1t?shopId=${shopId}&orderPage=${orderListPage.currentPage+1}" >&raquo;</a></li>
	            	<#else>
	            		<li class="disabled"><a>&raquo;</a></li>
	            	</#if>
	            </#if>
            </ul>
        </div>
    </div>

</div>

<input type="hidden" id="shopId" value="${shopId}">
<!-- historyOrderDel Modal -->
<div class="modal fade" id="shopHistoryDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel0" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">确定删除该记录? 问题不大，酌情删吧！</h3>
            </div>
            <div class="modal-body" style="text-align: center">
                <label><button type="button" class="btn btn-danger btn-lg" onclick="javascript:confirmDeleteOrder();">删除</button></label>
                <label><button type="button" class="btn btn-info btn-lg" data-dismiss="modal">取消</button></label>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div><!-- /.modal -->

<!-- user detail Modal -->
<div class="modal fade" id="shopHistoryUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">用户详情</h3>
            </div>
            <div class="modal-body">
                <ul>
                    <li>名字：JOE</li>
                    <li>性别：</li>
                    <li>收获地址：交大二期5#</li>
                    <li>头像：
                        <div class="row">
                        <div class="col-sm-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src="../../res/img/avatar.jpg">
                            </a>
                        </div>
                    </div></li>
                </ul>
                <p>
                <div style="text-align:center">
                	<label><button type="button" class="btn btn-info btn-lg" data-dismiss="modal">关闭</button></label>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div><!-- /.modal -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../res/js/custom/adminShop.js"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        //language:  'zh',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        showMeridian: 1,
        initialDate:new Date()
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
</body>
</html>