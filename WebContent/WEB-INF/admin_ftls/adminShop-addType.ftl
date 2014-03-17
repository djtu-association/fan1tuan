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
                    <h3 class="panel-title"><a href="adminShop.html">商铺管理></a><a href="adminShop-dishItem.html">菜品管理</a>>添加分类</h3>
                </div>
                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>添加菜品分类</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">新分类名称</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="请输入新的分类名称">
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
                    <h3 class="panel-title"><a href="adminShop.html">商铺管理></a><a href="adminShop-dishItem.html">菜品管理</a>>现有分类</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>店铺现有菜品分类</h2>
                    </div>
                    <div>
                        <table class="table table-striped table-hover table-bordered">
                            <tr>
                                <th>NO.</th>
                                <th>名称</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>酱爆</td>
                                <td>
                                    <button type="button" class="btn btn-primary btn-xs">编辑</button>
                                    <button type="button" class="btn btn-danger btn-xs">删除</button>
                                </td>
                            </tr>
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