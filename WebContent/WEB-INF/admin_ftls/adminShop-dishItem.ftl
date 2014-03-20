<!DOCTYPE html>
<html>
<head>
<#include "./sinppet/admin-head.ftl">
</head>
<body>



<!--top navigator bar-->
<#include "./sinppet/admin-topnav.ftl">

<input type="hidden" id="shopId" value="${shopId}">
<!--Main frame-->
<div class=".container">

    <!--head of center body-->
    <#include "./sinppet/admin-leftnav.ftl">

    <!--mid bar-->
    <div style="float: left;width: 80%">

        <!--head-->
        <div class="panel-default">
            <div class="panel-success" style="height: 50px;">
                <div class="panel-heading">
                        <h3 class="panel-title"><a href="showShopList.f1t">商铺管理></a>菜品管理</h3>
                </div>
            </div>
        </div>

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <div>
                        <div class="form-group">
                            <button type="button" class="btn btn-warning" onclick="location='showDishAdd.f1t?shopId=${shopId}'">添加菜品</button>
                            <button type="button" class="btn btn-info" onclick="location='showDishType.f1t?shopId=${shopId}'">添加分类</button>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>NO.</th>
                        <th>名称</th>
                        <th>价格</th>
                        <th>图片</th>
                        <th>操作</th>
                    </tr>
                    <#if dishList?exists>
                    	<#list dishList as dish>
                    		<tr>
		                        <td>${dish_index+1}</td>
		                        <td>${dish.name}</td>
		                        <td>${dish.price}</td>
		                        <td></td>
		                        <td>
		                            <button type="button" class="btn btn-primary btn-xs" onclick="location='showDishEdit.f1t?dishId=${dish.id}&shopId=${shopId}'">编辑</button>
		                            <button type="button" class="btn btn-danger btn-xs" onclick="javascript:confirmDeleteDish('${dish.id}')" id="">删除</button>
		                        </td>
		                    </tr>
                    	</#list>
                	<#else>
                		<tr>
                			<td colspan="5" style="text-align:center"><h3><strong>目前还没有订单</strong></h3></td>
                    	</tr>
                    </#if>
                </table>


                <!--footer-->
                <div class="panel" style="float: right;">
                    <ul class="pagination">
                        <#if dishListPage?exists>
                        	<#if (dishListPage.currentPage>1)>
                        		<li><a href="showDishList.f1t?shopId=${shopId}&dishPage=${dishListPage.currentPage-1}" >&laquo;</a></li>
                        	<#else>
                        		<li class="disabled"><a>&laquo;</a></li>
                        	</#if>
			            	
		        			<#list 1..dishListPage.pageCount as num>
		        				<#if dishListPage.currentPage == num>
		        					<li class="active"><a>${num}</a></li>
		        				<#else>
		        					<li><a href="showDishList.f1t?shopId=${shopId}&dishPage=${num}">${num}</a></li>
		        				</#if>
		        			</#list>
		        			
		        			<#if (dishListPage.currentPage<dishListPage.pageCount)>
                        		<li><a href="showDishList.f1t?shopId=${shopId}&dishPage=${dishListPage.currentPage+1}" >&raquo;</a></li>
                        	<#else>
                        		<li class="disabled"><a>&raquo;</a></li>
                        	</#if>
			            </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
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