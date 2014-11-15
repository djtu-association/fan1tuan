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
                        <label><span class="glyphicon glyphicon-wrench">ToolBar:</span></label>
                        <button type="button" class="btn btn-warning" onclick="location='adminUserEditOrAdd.html'">添加用户</button>
                        <button type="button" class="btn btn-info">Action</button>
                        <!--
                        <button type="button" class="btn btn-success">Action</button>
                        <button type="button" class="btn btn-danger">Action</button>
                        <button type="button" class="btn btn-primary">Action</button>
                        -->
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="panel panel-success" style="margin-bottom: 10px;">
        <div class="panel-heading" style="height: 50px;">
            <form class="form-inline" role="form">
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-pushpin">过滤条件:&nbsp;</span></label>
                </div>
                <label>
                    性别：
                    <label><input type="checkbox" name="gender" class="labGender" value="1"/>男</label>
                    <label><input type="checkbox" name="gender" class="labGender" value="0"/>女</label>
                </label>
                &nbsp;
                <label>
                    所在校区：
                    <select name="collage" id="selCollage">
                        <option value="交大一期">交大一期</option>
                        <option value="交大二期">交大二期</option>
                        <option value="交大航运">交大航运</option>
                    </select>
                </label>
                &nbsp;
                <label style="float: right">
                    <input type="text"  placeholder="Detailed Info">
                    <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"/> Accurate Search</button>
                </label>
                &nbsp;


            </form>
        </div>
    </div>

    <!--center-->
    <div>
        <div class="panel panel-info">

            <div class="panel-heading">
                <h2 class="panel-title">用户列表</h2>
            </div>

            <table class="table table-striped table-hover table-bordered">
                <tr>
                    <th>NO.</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>地址</th>
                    <th>注册时间</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Joe</td>
                    <td>男</td>
                    <td>交大二期</td>
                    <td>2013-10-23</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                        <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                        <button type="button" class="btn btn-info btn-xs" onclick="">历史订单</button>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Joe</td>
                    <td>男</td>
                    <td>交大二期</td>
                    <td>2013-10-23</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                        <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                    </td>
                </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>男</td>
                <td>交大二期</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>男</td>
                <td>交大二期</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>男</td>
                <td>交大二期</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>男</td>
                <td>交大二期</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>男</td>
                <td>交大二期</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">编辑</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">删除</button>
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


<!-- trbar Modal -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">确定删除该用户</h4>
            </div>
            <div class="modal-body" style="text-align: center">
                <label><button type="button" class="btn btn-danger btn-lg">删除</button></label>
                <label><button type="button" class="btn btn-info btn-lg" data-dismiss="modal">取消</button></label>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div><!-- /.modal -->


</body>
</html>