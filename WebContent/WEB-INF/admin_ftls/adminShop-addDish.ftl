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

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title"><a href="showShopList.f1t">商铺管理></a><a href="showDishList.f1t?shopId=${shopId}">菜品管理</a>>添加菜品</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>添加菜品</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form" method="post" enctype="multipart/form-data" <#if dish?exists>action="doDishEdit.f1t?shopId=${shopId}&dishId=${dishId}"<#else>action="doDishAdd.f1t?shopId=${shopId}"</#if> >
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" placeholder="菜品名称" value="<#if dish?exists&&dish.name?exists>${dish.name}</#if>" >
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10">
                                    <input type="text" name="description" class="form-control" placeholder="对菜品的描述" value="<#if dish?exists&&dish.description?exists>${dish.description}</#if>" >
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">售价</label>
                                <div class="col-sm-10">
                                    <input type="text" name="price" class="form-control" placeholder="售价" value="<#if dish?exists&&dish.price?exists>${dish.price}</#if>" >
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">原价</label>
                                <div class="col-sm-10">
                                    <input type="text" name="originPrice" class="form-control" placeholder="原价" value="<#if dish?exists&&dish.originPrice?exists>${dish.originPrice}</#if>" >
                                </div>
                            </div>

                            <!--file-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">图片上传（50x50）</label>
                                <div class="col-sm-10">
                                    <input type="file">
                                </div>
                            </div>

                            <!--select-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">菜品分类</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="dishTasteTagId">
                                    	<#if dishTagList?exists&&(dishTagList?size>0)>
                                    		<option value="0">选择分类</option>
                                    		<#list dishTagList as tag>
                                    			<option value="${tag.id}" <#if dish?exists&&dish.dishTasteTagId?exists&&(dish.dishTasteTagId==tag.id)>selected</#if> >${tag.name}</option>
                                    		</#list>
                                		<#else>
                                			<option value="0">暂无分类</option>
                                    	</#if>
                                    </select>
                                </div>
                            </div>

                            <!--Confirm button-->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                	<#if dish?exists>
                                		 <button type="submit" class="btn btn-success">确认修改</button>
                                    	<button type="reset" class="btn btn-warning" onclick="location='showDishList.f1t?shopId=${shopId}'">取消</button>
                                	<#else>
                                		<button type="submit" class="btn btn-success">确认保存</button>
                                    	<button type="reset" class="btn btn-warning">重置</button>
                                    	<button type="reset" class="btn btn-warning" onclick="location='showDishList.f1t?shopId=${shopId}'">取消</button>
                                	</#if>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>
        </div>
    </div>

</div>

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