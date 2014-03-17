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
        <div class="panel-default" style="margin-bottom: 15px;">
            <div class="panel-default" style="height: 50px;">
                <div class="panel-heading">
                    <div>
                        <div class="form-group">
                            <label><span class="glyphicon glyphicon-wrench">����:</span></label>
                            <button type="button" class="btn btn-warning" onclick="location='showShopAdd.f1t'">�������</button>
                            <button type="button" class="btn btn-success" onclick="location='#'">��ӿ�ζ��ǩ</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="panel panel-info" style="margin-bottom: 10px;">
            <div class="panel-heading">
                 <label><span class="glyphicon glyphicon-pushpin">��������</span></label>
            </div>
            <div class="panel-body">
                <form class="form-group" role="form">
                    <label>
                        ��Ȧ��
                        <select name="collage" id="selDistrict">
                            <option value="����һ��">������Ȧ</option>
                            <option value="����һ��">����һ��</option>
                            <option value="�������">�������</option>
                            <option value="������">������</option>
                        </select>
                    </label>
                    &nbsp;
                    <label>
                        ���ͣ�
                        <select name="collage" id="selType">
                            <option value="����һ��">��������</option>
                            <option value="����һ��">��������</option>
                            <option value="�������">�绰����</option>
                            <option value="������">��Ӫ����</option>
                        </select>
                    </label>
                    &nbsp;
                    <label>
                        Ӫҵ״̬��
                        <select name="collage" id="selOnline">
                            <option>����״̬</option>
                            <option value="1">Ӫҵ��</option>
                            <option value="0">��Ϣ��</option>
                        </select>
                    </label>
                    &nbsp;
                    <label>
                        ����ʱ�䣺
                        <select name="collage" id="selDateOrder">
                            <option value="1">ʱ��˳��</option>
                            <option value="0">ʱ�䵹��</option>
                        </select>
                    </label>
                    &nbsp;
                    <label>
                        ���ָߵͣ�
                        <select name="collage" id="selRankOrder">
                            <option value="1">���ִӸߵ���</option>
                            <option value="0">���ִӵ͵���</option>
                        </select>
                    </label>
                    &nbsp;&nbsp;&nbsp;
                    <label>
                        <button type="button" class="btn btn-primary btn-xs">ȷ��</button>
                    </label>
                    <p>
                    <div>
                        <!--
                        <label>HELLO<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button></label>
                        -->
                        <span class="label label-primary" id="spnDistrict">������Ȧ</span>
                        <span class="label label-success" id="spnType">��������</span>
                        <span class="label label-info" id="spnStatus">����״̬</span>
                        <span class="label label-warning" id="spnDateOrder">ʱ��˳��</span>
                        <span class="label label-danger" id="spnRankOrder">���ִӸߵ���</span>
                    </div>
                </form>


            </div>

            <div class="panel-footer" style="text-align: right">
                <label>
                    <input type="text"  placeholder="�ؼ���">
                    <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"/>��������</button>
                </label>
            </div>
        </div>

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h2 class="panel-title">�����б�</h2>
                </div>

                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>NO.</th>
                        <th>����</th>
                        <th>����</th>
                        <th>��Ȧ</th>
                        <th>ע��ʱ��</th>
                        <th>����</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="location='showShopEdit'">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="location='showShopOrders'">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='showDishList'">�˵�����</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">�˵�����</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">�˵�����</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">�˵�����</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">�˵�����</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>��������</td>
                        <td>�������</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="����ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">�༭</button></label>
                            <label><button type="button" value="����ID" class="btn btn-warning btn-xs btnDel">ɾ��</button></label>
                            <label><button type="button" value="����ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">��ʷ����</button></label>
                            <label><button type="button" value="����ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">�˵�����</button></label>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><span id="modalTitle">��������</span></h4>
            </div>
            <div class="modal-body">
                ������Ϣ(��̬��ȡ������ajax�������ݣ�����modal��complete��ʾmodal)
                <div id="modalContent">
                </div>
                <div>
                    <form role="form">
                        <ul>
                            <li><label>���ƣ�</label></li>
                            <li><label>�绰��</label></li>
                            <li><label>����ʱ�䣺</label></li>
                            <li><label>�ȵȣ�</label></li>
                            <li><label>�ȵȣ�</label></li>
                        </ul>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->

</div><!-- /.modal -->


<!-- trbar Modal -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">ȷ��ɾ��������</h3>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../res/js/custom/adminShop.js"></script>
</body>
</html>