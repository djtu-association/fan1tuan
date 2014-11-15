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
                        <button type="button" class="btn btn-warning" onclick="location='adminUserEditOrAdd.html'">����û�</button>
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
                    <label><span class="glyphicon glyphicon-pushpin">��������:&nbsp;</span></label>
                </div>
                <label>
                    �Ա�
                    <label><input type="checkbox" name="gender" class="labGender" value="1"/>��</label>
                    <label><input type="checkbox" name="gender" class="labGender" value="0"/>Ů</label>
                </label>
                &nbsp;
                <label>
                    ����У����
                    <select name="collage" id="selCollage">
                        <option value="����һ��">����һ��</option>
                        <option value="�������">�������</option>
                        <option value="������">������</option>
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
                <h2 class="panel-title">�û��б�</h2>
            </div>

            <table class="table table-striped table-hover table-bordered">
                <tr>
                    <th>NO.</th>
                    <th>����</th>
                    <th>�Ա�</th>
                    <th>��ַ</th>
                    <th>ע��ʱ��</th>
                    <th>����</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Joe</td>
                    <td>��</td>
                    <td>�������</td>
                    <td>2013-10-23</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                        <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                        <button type="button" class="btn btn-info btn-xs" onclick="">��ʷ����</button>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Joe</td>
                    <td>��</td>
                    <td>�������</td>
                    <td>2013-10-23</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                        <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                    </td>
                </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>��</td>
                <td>�������</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>��</td>
                <td>�������</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>��</td>
                <td>�������</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>��</td>
                <td>�������</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
                </td>
            </tr><tr>
                <td>1</td>
                <td>Joe</td>
                <td>��</td>
                <td>�������</td>
                <td>2013-10-23</td>
                <td>
                    <button type="button" class="btn btn-primary btn-xs" value="123" onclick="location='adminUserEditOrAdd.html'">�༭</button>
                    <button type="button" class="btn btn-warning btn-xs btnDel" value="456">ɾ��</button>
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
                <h4 class="modal-title">ȷ��ɾ�����û�</h4>
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


</body>
</html>