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

<!--head-->
<div class="panel-default">
    <div class="panel-default" style="height: 50px;">
        <div class="panel-heading">

            <div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-wrench">工具栏:</span></label>
                    <button type="button" class="btn btn-warning" onclick="location='adminAdvertEditOrAdd.html'">添加广告</button>
                    <button type="button" class="btn btn-info">Action</button>
                    <button type="button" class="btn btn-success">Action</button>
                    <button type="button" class="btn btn-danger">Action</button>
                    <button type="button" class="btn btn-primary">Action</button>
                    <button type="button" class="btn btn-danger">Lee</button>
                </div>
            </div>
        </div>
    </div>
</div>






<!--center-->
<div>
    <div class="panel panel-info">

        <div class="panel-heading">
            <h2 class="panel-title">Title</h2>
        </div>

        <table class="table table-striped table-hover table-bordered">
            <tr>
                <th>NO.</th>
                <th>名称</th>
                <th>页面位置</th>
                <th>广告说明</th>
                <th>添加时间</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>1</td>
                <td>Joe</td>
                <td>主页导航</td>
                <td>XXX'S</td>
                <td>XXX'S</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" onclick="javascript:EditAdvert('')">编辑</button>
                    <button type="button" class="btn btn-danger btn-xs">删除</button>
                    <button type="button" class="btn btn-warning btn-xs">图片预览</button>
                </td>
            </tr>

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
</div>

</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../res/js/custom/adminAdvert.js"></script>
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