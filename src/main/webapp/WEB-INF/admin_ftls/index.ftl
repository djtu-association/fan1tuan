<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>*美餐网*|店铺用户</title>

    <!-- Bootstrap core CSS -->
    <link href="/res/adminshop/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/res/adminshop/css/dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">美餐店铺管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <p class="navbar-text"><b>${shopClient.username}</b>店主，您好！</p>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul id="primary-sidebar" class="nav nav-sidebar">
                <#if shop??>
                <li id="overview-btn" class="active"><a href="#">概览</a></li>
                </#if>
                <li id="userInfo-btn"><a href="#userInfo">用户信息</a></li>
                <li id="shopInfo-btn"><a href="#shopInfo">店铺信息</a></li>
                <#if shop??>
                    <li id="dishTasteInfo-btn"><a href="#dishTasteInfo">菜品口味管理</a></li>
                    <li id="dishInfo-btn"><a href="#dishInfo">菜品管理</a></li>
                    <li id="orderInfo-btn"><a href="#orderInfo">订单管理</a></li>
                </#if>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/index.f1t">回到饭1团</a></li>
                <li><a href="/admin/shop/doSignout.f1t">退出登陆</a></li>
            </ul>
        </div>
        <div id="primary-view" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <#if shop??>
            <div id="overview">
                <h1 class="page-header">信息概览</h1>
                <div class="row placeholders">
                    <div class="col-xs-8 col-sm-4 placeholder">
                        <canvas id="dishTagChart" width="250" height="250"></canvas>
                        <h4>菜品标签</h4>
                        <span class="text-muted">您的店铺当前共有 <b><#if dishTasteTags??>${dishTasteTags.size()}<#else>0</#if></b> 个菜品标签</span>
                    </div>
                    <div class="col-xs-8 col-sm-4 placeholder">
                        <canvas id="dishChart" width="250" height="250"></canvas>
                        <h4>菜品销量</h4>
                        <span class="text-muted">店铺的 <b><#if dishes??>${dishes.size()}<#else>0</#if></b> 道菜品共卖出了 <b>${shop.saleVolume!0}</b> 份</span>
                    </div>
                    <div class="col-xs-8 col-sm-4 placeholder">
                        <canvas id="orderChart" width="250" height="250"></canvas>
                        <h4>订单动态</h4>
                        <span class="text-muted">您共有 <b><#if activeOrders??>${activeOrders.size()}<#else>0</#if></b> 份订单处于活跃状态</span>
                    </div>
                </div>
                <div class="row placeholders">
                    <div class="col-xs-24 col-sm-12 placeholder">
                        <canvas id="orderRecentChart" width="1200" height="200"></canvas>
                        <h4 class="text-muted">店铺近几日订单受理状况</h4>
                    </div>
                </div>
            </div>
            </#if>
            <div style="display: none" id="userInfo">
                <h1 class="page-header">用户信息</h1>
                <form role="form">
                    <div class="form-group">
                        <label for="userId">用户编号</label>
                        <input type="text" value="${shopClient.id}" class="form-control" id="userId" placeholder="用户编号" readonly>
                        <span class="help-block">用户编号为系统自动生成，仅供用户查看，用户无法自行修改。</span>
                    </div>
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" value="${shopClient.username}" class="form-control" id="username" placeholder="用户名" readonly>
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" placeholder="密码">
                        <span class="help-block">输入现有密码，确认身份后方可修改密码。</span>
                    </div>
                    <div class="form-group">
                        <label for="newPassword">新密码</label>
                        <input type="password" class="form-control" id="newPassword" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <label for="newPasswordAgain">确认新密码</label>
                        <input type="password" class="form-control" id="newPasswordAgain" placeholder="密码">
                    </div>
                    <button type="submit" class="btn btn-default" id="saveUserInfoButton">保存修改</button>
                </form>
            </div>
            <div style="display: none" id="shopInfo">
                <#if shop??>
                    <div class="alert alert-success" role="alert">
                        <b>您的小店开张啦！</b>现在可以随意修改店铺信息
                    </div>
                </#if>
                <h1 class="page-header">店铺信息</h1>
                <#if !shop??>
                    <div class="alert alert-warning" role="alert">
                        <b>您还未开店！</b>请填写下面的信息来创建一个店铺
                    </div>
                </#if>
                <form id="shopForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="shopId" class="col-sm-1 control-label">店铺编号</label>
                        <div class="col-sm-11">
                            <input value="<#if shop??>${shop.id}</#if>" type="text" class="form-control" id="shopId" placeholder="店铺编号" readonly>
                            <p class="help-block">此编号为只读项，店铺编号为系统自动生成。</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopName" class="col-sm-1 control-label">店铺名称</label>
                        <div class="col-sm-11">
                            <input value="<#if shop??>${shop.name}</#if>" name="name" type="text" class="form-control" id="shopName" placeholder="店铺名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">店铺口味</label>
                        <div class="col-sm-11">
                            <#list shopTasteTags as shopTasteTag>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="shopTasteTagIds" value="${shopTasteTag.id}" <#if shop?? && shop.shopTasteTagIds.contains(shopTasteTag.id)>checked</#if>> ${shopTasteTag.name}
                                </label>
                            </#list>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">店铺类型</label>
                        <div class="col-sm-11">
                            <label class="radio-inline">
                                <input type="radio" name="type" value="0" <#if shop?? && shop.type==0>checked</#if>> 摊位
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="type" value="1" <#if shop?? && shop.type==1>checked</#if>> 实体店
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopDeliveryCharge" class="col-sm-1 control-label">送餐起送价</label>
                        <div class="col-sm-11">
                            <input value="<#if shop??>${shop.deliveryCharge}</#if>" name="deliveryCharge" type="number" class="form-control" id="shopDeliveryCharge" placeholder="请输入起送价">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopAddress" class="col-sm-1 control-label">店铺地址</label>
                        <div class="col-sm-11">
                            <input value="<#if shop??>${shop.address}</#if>" name="address" type="text" class="form-control" id="shopAddress" placeholder="输入店铺地址的文字描述">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopArea" class="col-sm-1 control-label">所在商圈</label>
                        <div class="col-sm-11">
                            <select name="areaId" id="shopArea" class="form-control">
                                <option value=""><#if shop??>--保持不变--<#else>--请选择--</#if></option>
                                <#list areas as area>
                                    <option value="${area.id}">${area.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopPhone" class="col-sm-1 control-label">联系电话</label>
                        <div class="col-sm-11">
                            <input value="<#if shop??>${shop.cellphone}</#if>" name="cellphone" type="text" class="form-control" id="shopPhone" placeholder="输入店铺的联系电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">营业时间</label>
                        <div class="col-sm-5">
                            <input value="<#if shop??>${shop.openTime?string("HH:mm")}</#if>" name="openTime" type="time" class="form-control" placeholder="店铺何时开门">
                            <p class="help-block">在这里输入店铺的起始营业时间。</p>
                        </div>
                        <div class="col-sm-6">
                            <input value="<#if shop??>${shop.closeTime?string("HH:mm")}</#if>" name="closeTime" type="time" class="form-control" placeholder="店铺何时关门">
                            <p class="help-block">在这里输入店铺的终止营业时间。</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopAnnouncement" class="col-sm-1 control-label">店铺声明</label>
                        <div class="col-sm-11">
                            <textarea name="announcement" id="shopAnnouncement" class="form-control" rows="3"><#if shop??>${shop.announcement}</#if></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopDescription" class="col-sm-1 control-label">店铺描述</label>
                        <div class="col-sm-11">
                            <textarea name="description" id="shopDescription" class="form-control" rows="3"><#if shop??>${shop.description}</#if></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopAvatar" class="col-sm-1 control-label">店铺头像</label>
                        <div class="col-sm-11">
                            <input name="avatar" type="file" id="shopavatar">
                            <p class="help-block">在这里上传店铺的头像文件。</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-11 col-sm-offset-1">
                            <input id="saveShopInfoButton" type="submit" class="btn btn-default" value="确认保存">
                        </div>
                    </div>
                </form>
            </div>
            <div style="display: none" id="dishTasteInfo">
                <h1 class="page-header">菜品口味管理</h1>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#dishTasteModal">添加菜品口味</button>
                        <!-- Modal -->
                        <div class="modal fade" id="dishTasteModal" tabindex="-1" role="dialog" aria-labelledby="dishTasteModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                        <h4 class="modal-title" id="dishTasteModalLabel">添加菜品口味</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form id="newDishTasteTagForm" role="form">
                                            <div class="form-group">
                                                <label>菜品口味名称</label>
                                                <input name="name" type="text" class="form-control" placeholder="在这里输入菜品的口味名称">
                                            </div>
                                            <div class="form-group">
                                                <label>菜品口味描述</label>
                                                <textarea name="description" class="form-control" rows="3"></textarea>
                                                <p class="help-block">菜品口味的描述信息即为对该口味的解释。</p>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                        <button type="button" id="newDishTasteTagButton" class="btn btn-primary">保存修改</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive table-condensed">
                            <tr>
                                <th class="sr-only"></th>
                                <th>口味名称</th>
                                <th>描述</th>
                                <th>操作</th>
                            </tr>
                            <#if dishTasteTags??>
                                <#list dishTasteTags as dishTasteTag>
                                    <tr style="font-size: 18px">
                                        <td class="sr-only">${dishTasteTag.id}</td>
                                        <td>${dishTasteTag.name}</td>
                                        <td>${dishTasteTag.description}</td>
                                        <td>
                                            <div class="btn-group btn-group-sm">
                                                <button data-bind="${dishTasteTag.id}" type="button" data-toggle="modal" data-target="#editDishTasteModal" class="btn btn-success dish-taste-tag-edit-btn"><span class="glyphicon glyphicon-pencil"></span></button>
                                                <button data-bind="${dishTasteTag.id}" type="button" class="btn btn-danger dish-taste-tag-remove-btn"><span class="glyphicon glyphicon-trash"></span></button>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>
                            </#if>
                        </table>
                    </div>
                </div>
                <!-- Standard button -->
            </div>
            <div style="display: none" id="dishInfo">
                <h1 class="page-header">菜品管理</h1>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="header-btn">
                            <!-- Standard button -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newDishModal">添加菜品</button>
                            <!-- Modal -->
                            <div class="modal fade" id="newDishModal" tabindex="-1" role="dialog" aria-labelledby="newDishModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="newDishModalLabel">添加新菜品</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form id="newDishForm" role="form">
                                                <div class="form-group">
                                                    <label>菜品名称</label>
                                                    <input type="text" class="form-control"  placeholder="输入菜品的名称">
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品口味</label>
                                                    <select class="form-control">
                                                        <option>炒饭</option>
                                                        <option>盖饭</option>
                                                        <option>送可口可乐</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品设定价格</label>
                                                    <input type="number" class="form-control"  placeholder="输入菜品的原有设定价格">
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品售出价格</label>
                                                    <input type="number" class="form-control"  placeholder="输入菜品的折后价格，可与原价一致">
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品图片</label>
                                                    <input type="file">
                                                    <p class="help-block">菜品的图片在这里上传。</p>
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品状态</label>
                                                    <br>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="inlineRadioOptions" value="option1"> 可预订
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="inlineRadioOptions" value="option2"> 暂不提供
                                                    </label>
                                                </div>
                                                <div class="form-group">
                                                    <label>菜品描述</label>
                                                    <textarea class="form-control" rows="3"></textarea>
                                                    <p class="help-block">在这里写上对菜品的详尽描述。</p>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary">确认添加</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive table-condensed">
                            <tr>
                                <th></th>
                                <th>名称</th>
                                <th>口味</th>
                                <th>原价</th>
                                <th>现价</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            <#if dishes??>
                                <#list dishes as dish>
                                    <tr style="font-size: 18px">
                                        <td><img src="/res/avatar/dish/${dish.image}" style="width:30px;height:30px"></td>
                                        <td>${dish.name}</td>
                                        <td>${dishTasteMap[dish.dishTasteTagId]}</td>
                                        <td>￥${dish.originPrice}</td>
                                        <td class="text-danger">￥${dish.price}</td>
                                        <#if dish.status == 0>
                                            <td class="text-success"><b>可预订</b></td>
                                        <#else>
                                            <td class="text-danger"><b>不可预订</b></td>
                                        </#if>
                                        <td>
                                            <div class="btn-group btn-group-sm">
                                                <button data-bind="${dish.id}" type="button" class="btn btn-success edit-dish-btn" data-toggle="modal" data-target="#editDishModal"><span class="glyphicon glyphicon-pencil"></span></button>
                                                <button data-bind="${dish.id}" type="button" class="btn btn-danger remove-dish-btn"><span class="glyphicon glyphicon-trash"></span></button>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>
                            </#if>
                        </table>
                    </div>
                </div>
            </div>
            <div style="display: none" id="orderInfo">
                <h1 class="page-header">订单管理</h1>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <button type="button" class="btn btn-primary">未完成订单</button>
                        <button type="button" class="btn btn-success">已完成订单</button>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover table-striped table-responsive table-condensed">
                            <tr>
                                <th>订单编号</th>
                                <th>订单总额</th>
                                <th>订单状态</th>
                                <th>应送餐时间</th>
                                <th>支付方式</th>
                                <th>联系方式</th>
                                <th>订单日期</th>
                                <th>操作</th>
                            </tr>
                            <#if activeOrders??>
                            <#list activeOrders as activeOrder>
                                <tr style="font-size: 18px">
                                    <td><span class="badge">${activeOrder.orderNo}</span></td>
                                    <td class="text-success"><b>￥${activeOrder.price}</b></td>
                                    <td>
                                        <#if activeOrder.status == 1>
                                            <span class="text-danger">
                                                <b>未处理</b>
                                            </span>
                                        <#elseif activeOrder.status == 2>
                                            <span class="text-warning">
                                                <b>已接受</b>
                                            </span>
                                        <#elseif activeOrder.status == 3>
                                            <span class="text-success">
                                                <b>已送出</b>
                                            </span>
                                        </#if>
                                    </td>
                                    <td>${activeOrder.deliveryTime?string("HH:mm")}</td>
                                    <td>
                                        <#if activeOrder.chargeType == 0>
                                            货到付款
                                        <#else>
                                            其他
                                        </#if>
                                    </td>
                                    <td>${activeOrder.cellphone}</td>
                                    <td>${activeOrder.date?string("yyyy-MM-dd HH:mm")}</td>
                                    <td>
                                        <div class="btn-group btn-group-sm">
                                            <button data-bind="${activeOrder.id}" data-target="#viewOrderModal" type="button" class="btn btn-primary">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                            </button>
                                            <button data-bind="${activeOrder.id}" type="button" class="btn btn-success update-order" <#if activeOrder.status gt 2>disabled="disabled"</#if>>
                                                <span class="glyphicon glyphicon-arrow-up"></span>
                                            </button>
                                            <button type="button" class="btn btn-danger" <#if activeOrder.status gt 1>disabled="disabled"</#if>>
                                                <span class="glyphicon glyphicon-arrow-down"></span>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </#list>
                            </#if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- new dish taste tag -->
<!-- Modal -->
<div class="modal fade" id="editDishTasteModal" tabindex="-1" role="dialog" aria-labelledby="editDishTasteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="editDishTasteModalLabel">修改菜品口味</h4>
            </div>
            <div class="modal-body">
                <form id="editDishTasteTagForm" role="form">
                    <div class="form-group">
                        <label>菜品口味名称</label>
                        <input name="name" type="text" class="form-control" placeholder="在这里输入菜品的口味名称">
                    </div>
                    <div class="form-group">
                        <label>菜品口味描述</label>
                        <textarea name="description" class="form-control" rows="3"></textarea>
                        <p class="help-block">菜品口味的描述信息即为对该口味的解释。</p>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="editDishTasteTagButton" class="btn btn-primary">保存修改</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="editDishModal" tabindex="-1" role="dialog" aria-labelledby="editDishModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="editDishModalLabel">修改菜品</h4>
            </div>
            <div class="modal-body">
                <form id="editDishForm" role="form">
                    <div class="form-group">
                        <label>菜品名称</label>
                        <input type="text" class="form-control"  placeholder="输入菜品的名称">
                    </div>
                    <div class="form-group">
                        <label>菜品口味</label>
                        <select class="form-control">
                            <option>炒饭</option>
                            <option>盖饭</option>
                            <option>送可口可乐</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>菜品设定价格</label>
                        <input type="number" class="form-control"  placeholder="输入菜品的原有设定价格">
                    </div>
                    <div class="form-group">
                        <label>菜品售出价格</label>
                        <input type="number" class="form-control"  placeholder="输入菜品的折后价格，可与原价一致">
                    </div>
                    <div class="form-group">
                        <label>菜品图片</label>
                        <input type="file">
                        <p class="help-block">菜品的图片在这里上传。</p>
                    </div>
                    <div class="form-group">
                        <label>菜品状态</label>
                        <br>
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" value="option1"> 可预订
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" value="option2"> 暂不提供
                        </label>
                    </div>
                    <div class="form-group">
                        <label>菜品描述</label>
                        <textarea class="form-control" rows="3"></textarea>
                        <p class="help-block">在这里写上对菜品的详尽描述。</p>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">确认添加</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="viewOrderModal" tabindex="-1" role="dialog" aria-labelledby="viewOrderModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="viewOrderModalLabel">订单详情</h4>
            </div>
            <div class="modal-body">
                <form id="viewOrderForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单编号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="orderNo"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单价格</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="price"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收餐地址</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="address"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收餐人</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="receiver"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="cellphone"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单描述</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="description"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户留言</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" data-bind="userRemark"></p>
                        </div>
                    </div>
                </form>
                <table class="table table-hover table-condensed" data-bind="dishItems">

                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<script src="/res/adminshop/js/jquery.min.js"></script>
<script src="/res/adminshop/js/bootstrap.min.js"></script>
<script src="/res/adminshop/js/adminshop.js"></script>
<#if shop??>
<script src="/res/adminshop/js/Chart.min.js"></script>
<script>
    function randomColor() {
        var elems = ["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"];
        var ret = "#";
        for(var index = 0; index < 6; index++)
            ret += elems[parseInt(Math.random()*16)];
        return ret;
    }

    var dishTagdata = [
        <#if dishTasteTags??>
            <#list dishTasteTags as dishTasteTag>
                {
                    value: ${dishTagData[dishTasteTag.id]},
                    color: randomColor(),
                    label: "${dishTasteTag.name}"
                },
            </#list>
        </#if>
    ];

    var dishData = [
        <#if dishes??>
            <#list dishes as dish>
                {
                    value: ${dish.saleVolume},
                    color: randomColor(),
                    label: "${dish.name}"
                },
            </#list>
        </#if>
    ];

    var orderData = [
        <#if activeOrders??>
            {
                value: ${orderData["1"]!0},
                color: randomColor(),
                label: "未处理"
            },
            {
                value: ${orderData["2"]!0},
                color: randomColor(),
                label: "已接受"
            },
            {
                value: ${orderData["3"]!0},
                color: randomColor(),
                label: "已送出"
            }
        </#if>
    ];

    if(dishTagdata.length==0) {
        dishTagdata.push({
            value: 100,
            color: randomColor(),
            label: "还未设置任何菜品标签哦"
        });
        Chart.defaults.global.tooltipTemplate = "<%=label%>";
    } else {
        Chart.defaults.global.tooltipTemplate = "有<%= value %>种菜品为类别：<%=label%>";
    }

    //Get context with jQuery - using jQuery's .get() method.
    var dishTagChartCtx = $("#dishTagChart").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var dishTagChart = new Chart(dishTagChartCtx).Doughnut(dishTagdata);

    if(dishData.length==0) {
        dishData.push({
            value: 100,
            color: randomColor(),
            label: "还未有任何菜品售出记录哦"
        });
        Chart.defaults.global.tooltipTemplate = "<%=label%>";
    } else {
        Chart.defaults.global.tooltipTemplate = "<%=label%>共售出<%= value %>份";
    }

    //Get context with jQuery - using jQuery's .get() method.
    var dishChartCtx = $("#dishChart").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var dishChart = new Chart(dishChartCtx).Doughnut(dishData);

    if(orderData.length==0) {
        orderData.push({
            value: 100,
            color: randomColor(),
            label: "貌似所有订单都处理完啦"
        });
        Chart.defaults.global.tooltipTemplate = "<%=label%>";
    } else {
        Chart.defaults.global.tooltipTemplate = "<%=label%>订单有<%= value %>份";
    }

    //Get context with jQuery - using jQuery's .get() method.
    var orderChartCtx = $("#orderChart").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var orderChart = new Chart(orderChartCtx).Doughnut(orderData);

    var data = {
        labels : ["","","","","","","今天"],
        datasets : [
            {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [0,0,0,1,0,0,0]
            }
        ]
    };

    var orderRecentChartCtx = $("#orderRecentChart").get(0).getContext("2d");
    var orderRecentChart = new Chart(orderRecentChartCtx).Line(data);
</script>
</#if>

</body>
</html>
