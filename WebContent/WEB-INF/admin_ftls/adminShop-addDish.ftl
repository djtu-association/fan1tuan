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
                    <h3 class="panel-title"><a href="adminShop.html">���̹���></a><a href="adminShop-dishItem.html">��Ʒ����</a>>��Ӳ�Ʒ</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>��Ӳ�Ʒ</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">����</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="��Ʒ����">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">����</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="�Բ�Ʒ������">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">�ۼ�</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="�ۼ�">
                                </div>
                            </div>
                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">ԭ��</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="ԭ��">
                                </div>
                            </div>

                            <!--file-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">ͼƬ�ϴ���50x50��</label>
                                <div class="col-sm-10">
                                    <input type="file">
                                </div>
                            </div>

                            <!--select-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">��Ʒ����</label>
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
                                    <button type="submit" class="btn btn-success">����</button>
                                    <button type="reset" class="btn btn-warning">����</button>
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