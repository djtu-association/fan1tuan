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
                        <li><a href="adminShop.html">商铺管理</a></li>
                        <li class="active">历史订单</li>
                    </ol>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <h3>店铺：店铺名称</h3>
                    <!--datePicker-->
                    <div>
                        <div>
                            <div>
                                <label>
                                    <div class="input-group date form_date col-md-5" data-date-format="dd MM yyyy" data-link-field="dtp_input1">
                                        <input class="form-control" size="16" type="text" value="" readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
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
                        <th>用户昵称（点击可查看用户详情）</th>
                        <th>订单时间</th>
                        <th>订单状态</th>
                        <th>管理</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">已完成</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-warning">商家取消</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-info">买家取消</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-info">买家取消</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-warning">商家取消</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">已完成</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">已完成</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="点击查看用户详情">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">已完成</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">删除</button></td>
                    </tr>


                </table>
            </div>
        </div>

        <!--panel footer-->
        <div style="text-align: right">
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


<!-- historyOrderDel Modal -->
<div class="modal fade" id="shopHistoryDelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">确定删除该记录</h3>
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
                                <img data-src="holder.js/100%x180">
                            </a>
                        </div>
                    </div></li>
                </ul>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div><!-- /.modal -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../res/js/custom/adminShop.js"></script>
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