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
            <div class="panel-success" style="height: 50px;">
                <div class="panel-heading">
                        <h3 class="panel-title"><a href="adminShop.html">ÉÌÆÌ¹ÜÀí></a>²ËÆ·¹ÜÀí</h3>
                </div>
            </div>
        </div>

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <div>
                        <div class="form-group">
                            <button type="button" class="btn btn-warning" onclick="location='adminShop-addDish.html'">Ìí¼Ó²ËÆ·</button>
                            <button type="button" class="btn btn-info" onclick="location='adminShop-addType.html'">Ìí¼Ó·ÖÀà</button>
                        </div>
                    </div>
                </div>

                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>NO.</th>
                        <th>Ãû³Æ</th>
                        <th>¼Û¸ñ</th>
                        <th>·ÖÀà</th>
                        <th>Í¼Æ¬</th>
                        <th>²Ù×÷</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>½´±¬Ð¡Íè×Ó</td>
                        <td>18.00</td>
                        <td>½´±¬</td>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">±à¼­</button>
                            <button type="button" class="btn btn-danger btn-xs">É¾³ý</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>½´±¬Ð¡Íè×Ó</td>
                        <td>18.00</td>
                        <td>½´±¬</td>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">±à¼­</button>
                            <button type="button" class="btn btn-danger btn-xs">É¾³ý</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>½´±¬Ð¡Íè×Ó</td>
                        <td>18.00</td>
                        <td>½´±¬</td>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">±à¼­</button>
                            <button type="button" class="btn btn-danger btn-xs">É¾³ý</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>½´±¬Ð¡Íè×Ó</td>
                        <td>18.00</td>
                        <td>½´±¬</td>
                        <td></td>
                        <td>
                            <button type="button" class="btn btn-primary btn-xs">±à¼­</button>
                            <button type="button" class="btn btn-danger btn-xs">É¾³ý</button>
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