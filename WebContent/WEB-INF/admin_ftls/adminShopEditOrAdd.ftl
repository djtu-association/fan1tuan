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
                    <h3 class="panel-title">���̹���</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div style="text-align: center">
                        <h2>�������</h2>
                    </div>
                    <div>
                        <form class="form-horizontal" role="form">
                            <!--text-->
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">��������</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3" placeholder="��������">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">������</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword3" placeholder="��������̵ļ�̹������">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword4" class="col-sm-2 control-label">���ͼ�</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword4" placeholder="���뱾�����Ͳ��𲽼�">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword5" class="col-sm-2 control-label">��ϵ�绰</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword5" placeholder="��Ч����ϵ�绰">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">��������</label>
                                <div class="col-sm-10">
                                    <input type="radio" name="shopType">���߶�������
                                    &nbsp;
                                    <input type="radio" name="shopType">�绰��������
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword6" class="col-sm-2 control-label">��ʼʱ��</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword6" placeholder="��ʼӪҵʱ��">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword7" class="col-sm-2 control-label">����ʱ��</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword7" placeholder="����Ӫҵʱ��">
                                </div>
                            </div>

                            <!--text-->
                            <div class="form-group">
                                <label for="inputPassword8" class="col-sm-2 control-label">���̵�ַ</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword8" placeholder="������̴��µ�ַλ��">
                                </div>
                            </div>

                            <!--file-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">����ͷ��50*50��</label>
                                <div class="col-sm-10">
                                    <input type="file">
                                </div>
                            </div>

                            <!--select-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">������Ȧ</label>
                                <div class="col-sm-10">
                                    <select class="form-control">
                                        <option value="">����һ��</option>
                                        <option value="">�������</option>
                                        <option value="">������ó</option>
                                        <option value="">�����Ƽ�</option>
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