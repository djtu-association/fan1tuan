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
                    <p class="navbar-text"><b>李赫</b>店主，您好！</p>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul id="primary-sidebar" class="nav nav-sidebar">
                <li id="overview-btn" class="active"><a href="#">概览</a></li>
                <li id="userInfo-btn"><a href="#userInfo">用户信息</a></li>
                <li id="shopInfo-btn"><a href="#shopInfo">店铺信息</a></li>
                <li id="dishTasteInfo-btn"><a href="#dishTasteInfo">菜品口味管理</a></li>
                <li id="dishInfo-btn"><a href="#dishInfo">菜品管理</a></li>
                <li id="orderInfo-btn"><a href="#orderInfo">订单管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/index.f1t">回到饭1团</a></li>
                <li><a href="">退出登陆</a></li>
            </ul>
        </div>
        <div id="primary-view" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div id="overview">
                <h1 class="page-header">信息概览</h1>

            </div>
            <div style="display: none" id="userInfo">
                <h1 class="page-header">用户信息</h1>
                <form role="form">
                    <div class="form-group">
                        <label for="userId">用户编号</label>
                        <input type="text" class="form-control" id="userId" placeholder="用户编号" readonly>
                        <span class="help-block">用户编号为系统自动生成，仅供用户查看，用户无法自行修改。</span>
                    </div>
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" placeholder="用户名" readonly>
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
                <h1 class="page-header">店铺信息</h1>
                <!-- 判断该账户是否已经开店 -->
                <div class="alert alert-warning" role="alert">
                    <b>您还未开店！</b>请填写下面的信息来创建一个店铺
                </div>
                <form id="shopForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="shopId" class="col-sm-1 control-label">店铺编号</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="shopId" placeholder="店铺编号" readonly>
                            <p class="help-block">此编号为只读项，店铺编号为系统自动生成。</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopName" class="col-sm-1 control-label">店铺名称</label>
                        <div class="col-sm-11">
                            <input name="name" type="text" class="form-control" id="shopName" placeholder="店铺名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">店铺口味</label>
                        <div class="col-sm-11">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid1"> 烧烤
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid2"> 奶茶
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid3"> 中式
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid4"> 日式
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid5"> 汉堡
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="shopTasteTagIds" value="tasteid6"> 面包
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">店铺类型</label>
                        <div class="col-sm-11">
                            <label class="radio-inline">
                                <input type="radio" name="type" value="0"> 摊位
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="type" value="1"> 实体店
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopDeliveryCharge" class="col-sm-1 control-label">送餐起送价</label>
                        <div class="col-sm-11">
                            <input name="deliveryCharge" type="number" class="form-control" id="shopDeliveryCharge" placeholder="请输入起送价">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopAddress" class="col-sm-1 control-label">店铺地址</label>
                        <div class="col-sm-11">
                            <input name="address" type="text" class="form-control" id="shopAddress" placeholder="输入店铺地址的文字描述">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopArea" class="col-sm-1 control-label">店铺所在商圈</label>
                        <div class="col-sm-11">
                            <select name="areaId" id="shopArea" class="form-control">
                                <option value="areaid1">大连交通大学</option>
                                <option value="areaid2">大连科技大学</option>
                                <option value="areaid3">大连医科大学</option>
                                <option value="areaid4">大连理工大学</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopPhone" class="col-sm-1 control-label">店铺联系电话</label>
                        <div class="col-sm-11">
                            <input name="cellphone" type="text" class="form-control" id="shopPhone" placeholder="输入店铺的联系电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">店铺营业时间</label>
                        <div class="col-sm-5">
                            <input name="openTime" type="time" class="form-control" placeholder="店铺何时开门">
                            <p class="help-block">在这里输入店铺的起始营业时间。</p>
                        </div>
                        <div class="col-sm-6">
                            <input name="closeTime" type="time" class="form-control" placeholder="店铺何时关门">
                            <p class="help-block">在这里输入店铺的终止营业时间。</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopAnnouncement" class="col-sm-1 control-label">店铺声明</label>
                        <div class="col-sm-11">
                            <textarea name="announcement" id="shopAnnouncement" class="form-control" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shopDescription" class="col-sm-1 control-label">店铺描述</label>
                        <div class="col-sm-11">
                            <textarea name="description" id="shopDescription" class="form-control" rows="3"></textarea>
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
                                <th></th>
                                <th>口味名称</th>
                                <th>描述</th>
                                <th>操作</th>
                            </tr>
                            <tr style="font-size: 18px">
                                <td></td>
                                <td>送可口可乐</td>
                                <td>用户凡购买此口味下的任何一种菜品，每单送一厅可口可乐~</td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <button data-bind="tagid" type="button" data-toggle="modal" data-target="#editDishTasteModal" class="btn btn-success dish-taste-tag-edit-btn"><span class="glyphicon glyphicon-pencil"></span></button>
                                        <button data-bind="tagid" type="button" class="btn btn-danger dish-taste-tag-remove-btn"><span class="glyphicon glyphicon-trash"></span></button>
                                    </div>
                                </td>
                            </tr>
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
                                            <form role="form">
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
                            <tr style="font-size: 18px">
                                <td><img src="/res/adminshop/images/avatar.jpeg" style="width:30px;height:30px"></td>
                                <td>不差钱烤冷面一份</td>
                                <td>送可口可乐</td>
                                <td>￥20</td>
                                <td class="text-danger">￥16</td>
                                <td class="text-success"><b>可预订</b></td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></button>
                                        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                                    </div>
                                </td>
                            </tr>
                            <tr style="font-size: 18px">
                                <td><img src="/res/adminshop/images/avatar.jpeg" style="width:30px;height:30px"></td>
                                <td>不差钱烤冷面一份</td>
                                <td>送可口可乐</td>
                                <td>￥20</td>
                                <td class="text-danger">￥16</td>
                                <td class="text-success"><b>可预订</b></td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></button>
                                        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                                    </div>
                                </td>
                            </tr>
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
                            <tr style="font-size: 18px">
                                <td><span class="badge">2acd1244122faccd12haadffca21</span></td>
                                <td class="text-success"><b>￥34</b></td>
                                <td class="text-warning"><b>未接受</b></td>
                                <td>13:34</td>
                                <td>货到付款</td>
                                <td>18777667676</td>
                                <td>2014-11-12 18:21</td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></button>
                                        <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-arrow-up"></span></button>
                                        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-arrow-down"></span></button>
                                    </div>
                                </td>
                            </tr>
                            <tr style="font-size: 18px">
                                <td><span class="badge">2acd1244122faccd12haadffca21</span></td>
                                <td class="text-success"><b>￥34</b></td>
                                <td class="text-warning"><b>未接受</b></td>
                                <td>13:34</td>
                                <td>货到付款</td>
                                <td>18777667676</td>
                                <td>2014-11-12 18:21</td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></button>
                                        <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-arrow-up"></span></button>
                                        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-arrow-down"></span></button>
                                    </div>
                                </td>
                            </tr>
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

<script src="/res/adminshop/js/jquery.min.js"></script>
<script src="/res/adminshop/js/bootstrap.min.js"></script>
<script>
    $("#primary-sidebar").find("li").click(function (event) {
        //event.preventDefault();
        $("#primary-sidebar").find("li").removeClass("active");
        $(this).addClass("active");

        var id = $(this).attr("id").substring(0, $(this).attr("id").indexOf("-"));

        $("#primary-view").find("> div").hide();
        $("#"+id).show();
    });

    var hash = window.location.hash;
    if(hash.length>1) {
        hash = hash.substring(1);
        $("#primary-sidebar").find("li[id='"+hash+"-btn']").click();
    }

    // change password
    $("#saveUserInfoButton").click(function () {
        var password = $("#password").val(),
                newPassword = $("#newPassword").val(),
                newPasswordAgain = $("#newPasswordAgain").val();
        if (newPassword && newPasswordAgain && password) {
            if (newPassword == newPasswordAgain) {
                //logic put here
                alert("success!");


                $("#password").val("");
                $("#newPassword").val("");
                $("#newPasswordAgain").val("");
            } else {
                alert("新密码与确认新密码不相同，请核实后提交");
            }
        } else {
            alert("任何项不可为空");
        }
    });

    // save shop info
    $("#saveShopInfoButton").click(function (event) {
        event.preventDefault();
        var postData = $("#shopForm").serialize();

        alert(postData);
    });

    // add dish taste tag
    $("#newDishTasteTagButton").click(function () {
        var form = $("#newDishTasteTagForm"),
                postData = form.serialize();

        alert(postData);

        $("#dishTasteModal").find("button[data-dismiss='modal']").click();
        form.find("input").val("");
        form.find("textarea").val("");
    });

    // edit dish taste tag
    $('#dishTasteInfo').find('.dish-taste-tag-edit-btn').click(function () {
        var form = $("#editDishTasteTagForm");

    });

    $("#editDishTasteTagButton").click(function () {
        var form = $("#editDishTasteTagForm"),
                postData = form.serialize();

        alert(postData);

        $("#editDishTasteModal").find("button[data-dismiss='modal']").click();
        form.find("input").val("");
        form.find("textarea").val("");
    });

    // remove dish taste tag
    $('#dishTasteInfo').find('.dish-taste-tag-remove-btn').click(function () {
        var form = $("#editDishTasteTagForm");

        alert("remove");
    });
</script>
</body>
</html>
