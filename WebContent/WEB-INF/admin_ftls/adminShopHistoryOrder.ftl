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
                        <li><a href="adminShop.html">���̹���</a></li>
                        <li class="active">��ʷ����</li>
                    </ol>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <h3>���̣���������</h3>
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
                    <h3><span class="glyphicon glyphicon-shopping-cart"/>��ʷ����</h3>
                </label>
            </div>
            <div>
                <table class="table table-hover table-bordered table-responsive">
                    <tr>
                        <th>NO.</th>
                        <th>�������</th>
                        <th>�û��ǳƣ�����ɲ鿴�û����飩</th>
                        <th>����ʱ��</th>
                        <th>����״̬</th>
                        <th>����</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">�����</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-warning">�̼�ȡ��</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-info">���ȡ��</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-info">���ȡ��</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-warning">�̼�ȡ��</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">�����</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">�����</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>FT2013103289</td>
                        <td onclick="javascript:checkUserDetail('JOE');" title="����鿴�û�����">JOE</td>
                        <td>2013-10-24 12:50:30</td>
                        <td><span class="label label-success">�����</span></td>
                        <td><button type="button" class="btn btn-danger btn-xs shopHistoryDel">ɾ��</button></td>
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
                <h3 class="modal-title">ȷ��ɾ���ü�¼</h3>
            </div>
            <div class="modal-body" style="text-align: center">
                <label><button type="button" class="btn btn-danger btn-lg">ɾ��</button></label>
                <label><button type="button" class="btn btn-info btn-lg" data-dismiss="modal">ȡ��</button></label>
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
                <h3 class="modal-title">�û�����</h3>
            </div>
            <div class="modal-body">
                <ul>
                    <li>���֣�JOE</li>
                    <li>�Ա�</li>
                    <li>�ջ��ַ���������5#</li>
                    <li>ͷ��
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