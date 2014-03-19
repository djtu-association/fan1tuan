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
                            <label><span class="glyphicon glyphicon-wrench">管理:</span></label>
                            <button type="button" class="btn btn-warning" onclick="location='showShopAdd.f1t'">添加商铺</button>
                            <button type="button" class="btn btn-success" onclick="location='#'">添加口味标签</button>
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
                    <p>
                    <div>
                        <!--
                        <label>HELLO<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button></label>
                        -->
                        <span class="label label-primary" id="spnDistrict">所有商圈</span>
                        <span class="label label-success" id="spnType">所有商铺</span>
                        <span class="label label-info" id="spnStatus">所有状态</span>
                        <span class="label label-warning" id="spnDateOrder">时间顺序</span>
                        <span class="label label-danger" id="spnRankOrder">评分从高到低</span>
                    </div>
                </form>


            </div>

            <div class="panel-footer" style="text-align: right">
                <label>
                    <input type="text"  placeholder="关键字">
                    <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"/>快速搜索</button>
                </label>
            </div>
        </div>

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h2 class="panel-title">商铺列表</h2>
                </div>

                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>NO.</th>
                        <th>名称</th>
                        <th>类型</th>
                        <th>商圈</th>
                        <th>注册时间</th>
                        <th>管理</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="location='showShopEdit'">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="location='showShopOrders'">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='showDishList'">菜单管理</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">菜单管理</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">菜单管理</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">菜单管理</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">菜单管理</button></label>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>JOE'S SHOP</td>
                        <td>在线商铺</td>
                        <td>交大二期</td>
                        <td>2013-10-23</td>
                        <td>
                            <label><button type="button" value="商铺ID" class="btn btn-primary btn-xs" onclick="javascript:editShop('shopid')">编辑</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-warning btn-xs btnDel">删除</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-info btn-xs" onclick="javascript:checkHistoryOrder('shopid')">历史订单</button></label>
                            <label><button type="button" value="商铺ID" class="btn btn-success btn-xs" onclick="location='adminShop-dishItem.html'">菜单管理</button></label>
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
                <h4 class="modal-title" id="myModalLabel"><span id="modalTitle">商铺名称</span></h4>
            </div>
            <div class="modal-body">
                商铺信息(动态获取，先用ajax返回数据，更新modal，complete显示modal)
                <div id="modalContent">
                </div>
                <div>
                    <form role="form">
                        <ul>
                            <li><label>名称：</label></li>
                            <li><label>电话：</label></li>
                            <li><label>配送时间：</label></li>
                            <li><label>等等：</label></li>
                            <li><label>等等：</label></li>
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
                <h3 class="modal-title">确定删除该商铺</h3>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../res/js/custom/adminShop.js"></script>
</body>
</html>