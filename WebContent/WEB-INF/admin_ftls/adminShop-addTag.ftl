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
                    <h3 class="panel-title"><a href="showShopList.f1t">商铺管理></a>口味标签管理</h3>
                </div>
                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>添加店铺口味标签</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form" method="post" action="doShopTagAdd.f1t">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">新口味标签名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="tagName" class="form-control" id="inputEmail3" placeholder="请输入新的口味标签名称/必填">
                                </div>
                            </div>
                            
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">标签描述</label>
                                <div class="col-sm-10">
                                    <input type="text" name="tagDescription" class="form-control" id="inputEmail3" placeholder="请输入新的口味标签描述/必填">
                                </div>
                            </div>

                            <!--Confirm button-->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-success">保存</button>
                                    <button type="reset" class="btn btn-warning">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title">现有口味标签列表</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>现有菜品口味标签一览</h2>
                    </div>
                    <div>
                        <table class="table table-striped table-hover table-bordered">
                            <tr>
                                <th>NO.</th>
                                <th>名称</th>
                                <th>描述</th>
                                <th>操作</th>
                            </tr>
                            <#if shopTasteTagList?exists>
                            	<#list shopTasteTagList as tag>
	                            	<tr>
		                                <td>${tag_index+1}</td>
		                                <td>${tag.name}</td>
		                                <td>${tag.description}</td>
		                                <td>
		                                    <button type="button" class="btn btn-danger btn-xs" onclick="javascript:confirmDeleteShopTag('${tag.id}');" id="">删除</button>
		                                </td>
		                            </tr>
	                            </#list>
                        	<#else>
                        		<tr><td colspan="4"><h4><strong>目前还没有任何口味标签</strong></h4></td></tr>
                            </#if>
                        </table>
                    </div>
                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

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