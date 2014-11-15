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
                    <h3 class="panel-title"><a href="showShopList.f1t">商铺管理</a></h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center" >
                        <h2>${subTitle}</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form" method="post" <#if shop?exists>action="doShopEdit.f1t"<#else>action="doShopAdd.f1t"</#if> enctype="multipart/form-data">
                        	<#if shop?exists>
                        		<!--edit-->
                        		<input type="hidden" name="shopId" value="${shop.id}">
                        	</#if>
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">商铺名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" id="inputEmail3" placeholder="商铺名称" value="<#if shop?exists&&shop.name?exists>${shop.name}</#if>">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">简单描述</label>
                                <div class="col-sm-10">
                                    <input type="text" name="description" class="form-control" id="inputPassword3" placeholder="输入对商铺的简短广告描述" value="<#if shop?exists&&shop.name?exists>${shop.name}</#if>">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword44" class="col-sm-2 control-label">起送价(元)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="deliveryCharge" class="form-control" id="inputPassword44" placeholder="输入本商铺送餐起步价（元）" value="<#if shop?exists&&shop.deliveryCharge?exists>${shop.deliveryCharge}</#if>">
                                </div>
                            </div>
                            
                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword445" class="col-sm-2 control-label">人均消费(元)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="avgPersonCost" class="form-control" id="inputPassword445" placeholder="输入本商铺人均消费价（元）" value="<#if shop?exists&&shop.avgPersonCost?exists>${shop.avgPersonCost}</#if>">
                                </div>
                            </div>
                            
                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword4" class="col-sm-2 control-label">平均送达时间(分钟)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="avgDeliveryTime" class="form-control" id="inputPassword4" placeholder="输入本商铺送餐到达平均时间（分钟）" value="<#if shop?exists&&shop.avgDeliveryTime?exists>${shop.avgDeliveryTime}</#if>">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword5" class="col-sm-2 control-label">联系电话(手机)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="cellphone" class="form-control" id="inputPassword5" placeholder="有效的联系电话" value="<#if shop?exists&&shop.cellphone?exists>${shop.cellphone}</#if>">
                                </div>
                            </div>
							
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">店铺类型</label>
                                <div class="col-sm-10">
                                    <input type="radio" name="shopType" value="000" <#if shop?exists&&shop.type?exists&&shop.type==0>checked</#if> >在线订餐
                                    &nbsp;
                                    <input type="radio" name="shopType" value="111" <#if shop?exists&&shop.type?exists&&shop.type==1>checked</#if> >电话订餐
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword6" class="col-sm-2 control-label">开始时间(时:分)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="opentime" class="form-control form_time" readonly id="inputPassword6" placeholder="开始营业时间" value="<#if shop?exists&&shop.openTime?exists>${shop.openTime?string("HH:mm")}<#else>10:30</#if>">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword7" class="col-sm-2 control-label">结束时间(时:分)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="closetime" readonly class="form-control form_time" id="inputPassword7" placeholder="结束营业时间" value="<#if shop?exists&&shop.closeTime?exists>${shop.closeTime?string("HH:mm")}<#else>20:30</#if>">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword8" class="col-sm-2 control-label">店铺地址</label>
                                <div class="col-sm-10">
                                    <input type="text" name="address" class="form-control" id="inputPassword8" placeholder="输入店铺大致地址位置" value="<#if shop?exists&&shop.address?exists>${shop.address}</#if>">
                                </div>
                            </div>
							
							<!--origin picture-->
							<#if shop?exists&&shop.avatar?exists>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">原头像（50x50）</label>
	                                <div class="col-sm-10">
	                                    <a href="${shop.avatar}"><img src="${shop.avatar}" style="width:50px;height:50;"/></a>
	                                </div>
                            	</div>
							</#if>
							
                            <!--file-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">店铺头像（50*50）</label>
                                <div class="col-sm-10">
                                    <input type="file" name="avatar">
                                </div>
                            </div>
							
							
							<!--text 原坐标-->
							<#if shop?exists&&shop.location?exists>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">原坐标</label>
	                                <div class="col-sm-10">
	                                    <label class="label label-primary">（ ${shop.location[0]} , ${shop.location[1]} ）</label>
	                                </div>
	                            </div>
                            </#if>
							<!--text-->
                            <div class="form-group">
                                <label for="inputPassword888" class="col-sm-2 control-label">坐标·经度('C)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="longtitude" class="form-control" id="inputPassword888" placeholder="输入店铺坐标经度" value="<#if shop?exists&&shop.location?exists>${shop.location[0]}</#if>">
                                </div>
                            </div>
                            
                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword88" class="col-sm-2 control-label">坐标·纬度('C)</label>
                                <div class="col-sm-10">
                                    <input type="text" name="latitude" class="form-control" id="inputPassword88" placeholder="输入店铺坐标纬度" value="<#if shop?exists&&shop.location?exists>${shop.location[1]}</#if>">
                                </div>
                            </div>
							
                            <!--Confirm button-->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-success">保存</button>
                                    <#if shop?exists>
                                    	<button type="button" class="btn btn-warning" onclick="location='showShopList.f1t'">取消</button>
                                	<#else>
                                		<button type="reset" class="btn btn-warning">重置</button>
                                		<button type="button" class="btn btn-warning" onclick="location='showShopList.f1t'">取消</button>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
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
        //language:  'fr',
        weekStart: 1,
        todayBtn:  0,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 0,
        forceParse: 0,
        format:'hh:ii'
    });

</script>
</body>
</html>