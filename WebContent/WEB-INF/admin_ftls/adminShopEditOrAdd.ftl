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
                    <h3 class="panel-title">商铺管理</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>添加商铺</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">商铺名称</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="商铺名称">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">简单描述</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword3" placeholder="输入对商铺的简短广告描述">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword4" class="col-sm-2 control-label">起送价</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword4" placeholder="输入本商铺送餐起步价">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword5" class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword5" placeholder="有效的联系电话">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">店铺类型</label>
                                <div class="col-sm-10">
                                    <input type="radio" name="shopType">在线订餐商铺
                                    &nbsp;
                                    <input type="radio" name="shopType">电话订餐商铺
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword6" class="col-sm-2 control-label">开始时间</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword6" placeholder="开始营业时间">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword7" class="col-sm-2 control-label">结束时间</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword7" placeholder="结束营业时间">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword8" class="col-sm-2 control-label">店铺地址</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword8" placeholder="输入店铺大致地址位置">
                                </div>
                            </div>

                            <!--file-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">店铺头像（50*50）</label>
                                <div class="col-sm-10">
                                    <input type="file">
                                </div>
                            </div>

                            <!--select-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">所属商圈</label>
                                <div class="col-sm-10">
                                    <select class="form-control">
                                        <option value="">交大一期</option>
                                        <option value="">交大二期</option>
                                        <option value="">大连外贸</option>
                                        <option value="">大连科技</option>
                                    </select>
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