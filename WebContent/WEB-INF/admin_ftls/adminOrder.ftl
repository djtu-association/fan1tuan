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
                        <button type="button" class="btn btn-warning">Action</button>
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


    <div class="panel panel-info" style="margin-bottom: 10px;">
        <div class="panel-heading">
            <label><span class="glyphicon glyphicon-pushpin">过滤条件</span></label>
        </div>
        <div class="panel-body">
            <form class="form-group" role="form">

                <ul>
                    <li>
                        <!--时间控件-->
                        <label class="">选择时间</label>
                        <div>
                            <label>
                                <div class="input-group date form_date col-md-5" data-date-format="dd mm yyyy" data-link-field="dtp_input1">
                                    <input class="form-control" size="16" type="text" value="" readonly>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </label>
                            <input type="hidden" id="dtp_input1" value="" /><br/>
                        </div>
                    </li>
                    <li>

                    </li>
                    <li>
                        <label>
                            商圈：
                            <select name="collage" id="selDistrict">
                                <option value="交大一期">所有商圈</option>
                                <option value="交大一期">交大一期</option>
                                <option value="交大二期">交大二期</option>
                                <option value="交大航运">交大航运</option>
                            </select>
                        </label>
                        &nbsp;
                        <label>
                            类型：
                            <select name="collage" id="selType">
                                <option value="交大一期">所有商铺</option>
                                <option value="交大一期">在线商铺</option>
                                <option value="交大二期">电话商铺</option>
                                <option value="交大航运">自营商铺</option>
                            </select>
                        </label>
                        &nbsp;
                        <label>
                            营业状态：
                            <select name="collage" id="selOnline">
                                <option>所有状态</option>
                                <option value="1">营业中</option>
                                <option value="0">休息中</option>
                            </select>
                        </label>
                        &nbsp;
                        <label>
                            创建时间：
                            <select name="collage" id="selDateOrder">
                                <option value="1">时间顺序</option>
                                <option value="0">时间倒序</option>
                            </select>
                        </label>
                        &nbsp;
                        <label>
                            评分高低：
                            <select name="collage" id="selRankOrder">
                                <option value="1">评分从高到低</option>
                                <option value="0">评分从低到高</option>
                            </select>
                        </label>
                        &nbsp;&nbsp;&nbsp;
                        <label>
                            <button type="button" class="btn btn-primary btn-xs">确定</button>
                        </label>
                    </li>
                </ul>

                <!--
                <p>
                <div>
                    <span class="label label-primary" id="spnDistrict">所有商圈</span>
                    <span class="label label-success" id="spnType">所有商铺</span>
                    <span class="label label-info" id="spnStatus">所有状态</span>
                    <span class="label label-warning" id="spnDateOrder">时间顺序</span>
                    <span class="label label-danger" id="spnRankOrder">评分从高到低</span>
                </div>
                -->
            </form>


        </div>

        <div class="panel-footer" style="text-align: right">
            <label>精确搜索</label>
            <label>
                <input type="text"  placeholder="Detailed Info">
                <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"/> Accurate Search</button>
            </label>
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
                    <th>Name</th>
                    <th>Tel</th>
                    <th>Address</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>11</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>12</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>13</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>14</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
                </tr>
                <tr>
                    <td>15</td>
                    <td>Joe</td>
                    <td>18640886602</td>
                    <td>Conton</td>
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