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
                    <h3 class="panel-title"><a href="adminShop.html">商铺管理></a><a href="adminShop-dishItem.html">菜品管理</a>>添加菜品</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>添加菜品</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="菜品名称">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="对菜品的描述">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">售价</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="售价">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">原价</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="原价">
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
                                    <select class="form-control">
                                        <option value="">example</option>
                                        <option value="">example</option>
                                        <option value="">example</option>
                                        <option value="">example</option>
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