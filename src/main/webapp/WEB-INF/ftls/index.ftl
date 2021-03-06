<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="res/css/bootstrap.css" rel="stylesheet">
    <link href="res/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="res/css/flat-ui.css" rel="stylesheet">
    <script src="res/js/html5shiv.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="./js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>*美餐*</title>
    <link href="res/css/custom/index.css" rel="stylesheet">
    <link href="res/css/custom/sample.css" rel="stylesheet">
    <link href="res/css/custom/shoppingcart.css" rel="stylesheet">
    <link href="res/css/custom/shop.css" rel="stylesheet">
    <link href="res/css/custom/pendingOrder.css" rel="stylesheet">
</head>


<!-- NAVBAR
================================================== -->
<body>
<div class="topPage"></div>
<div class="navbar-wrapper">
    <div class="container">
    <#include "snippet/front-nav.ftl">
    </div>
</div>


<!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">
        <div class="item active">
            <img src="res/img/sunset.jpg" alt="">

            <div class="container">
                <div class="carousel-caption" style="margin-top: 150px">
                    <h1>美餐来啦</h1>

                    <p class="lead">食客~为你准备着</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="res/img/wood.jpg" alt="">

            <div class="container">
                <div class="carousel-caption" style="margin-top: 150px">
                    <h1>美餐来啦</h1>

                    <p class="lead">食客~为你准备着</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="res/img/subway.jpg" alt="">

            <div class="container">
                <div class="carousel-caption" style="margin-top: 150px">
                    <h1>美餐来啦</h1>

                    <p class="lead">食客~为你准备着</p>
                </div>
            </div>
        </div>
    </div>
    <a class="carousel-control" href="#myCarousel" data-slide="prev" style="top:25%">&lsaquo;</a>
    <a class="carousel-control" href="#myCarousel" data-slide="next" style="top:25%;right:0;left:auto;">&rsaquo;</a>
</div>
<!-- /.carousel -->


<!--sec level-->
<div class="carousel"></div>

<br><br>

<div id="rankPart">
    <div id="onlinePart" class="container-fluid">
        <div class="row-fluid">
            <div class="span1">
                <div id="onlineOrder" style="height: 0px">
                </div>
            </div>
            <div class="span2">
                <div class="featurette-heading">
                </div>
            </div>
            <div class="span6">
                <div class="navbar navbar-inverse onlinePin">
                    <div class="navbar-header">
                        <button data-target="#nav-collapse-01" data-toggle="collapse" class="btn btn-navbar"
                                type="button"></button>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav">
                            <li>
                                <a>
                                    <span class="text-warning"><span class="fui-cmd"></span> 在线订餐</span>
                                </a>
                            </li>

                            <li class="active" id="navDishRank">
                                <a href="#onlineDishRank">
                                    菜品排行
                                </a>
                            </li>
                            <li id="navShopRank">
                                <a href="#onlineShopRank">
                                    店铺排行
                                </a>
                            </li>
                        </ul>

                    </div>
                    <!--/.nav -->
                </div>
            </div>
            <div class="span3">
            </div>
        </div>
        <div style="height: 10px"></div>

        <div class="row-fluid">
            <div class="span1">
            </div>
            <div class="span10" style="height: 600px">

                <div class="panel panel-info" hidden="true" id="shopRank">
                    <div class="panel-heading" style="height: 58px">
                        <div class="col-lg-3">
                            <div class="btn-group" data-toggle="buttons">

                                <a title="有赠品"><label class="btn btn-danger">
                                    <span class="glyphicon glyphicon-gift"></span>
                                </label></a>
                                <a title="两份以上优惠"><label class="btn btn-info">
                                    <span class="glyphicon glyphicon-euro"></span>
                                </label></a>
                                <a title="三份以上优惠"><label class="btn btn-warning">
                                    <span class="glyphicon glyphicon-bell"></span>
                                </label></a>
                                <a title="没有优惠"><label class="btn btn-primary">
                                    <span class="glyphicon glyphicon-home"></span>
                                </label></a>
                            </div>
                        </div>

                        <div class="col-lg-3">
                            <div class="btn-group">
                                <select id="sel_shop_taste" title="选择口味"
                                        onchange="index_ChangeHiddenSelTaste(this,1);shop_AjaxChange(0);">
                                    <option value="">全部</option>
                                <#list shopTasteTags as tags>
                                    <option value="${tags.id}">${tags.name}</option>
                                </#list>
                                </select>

                            </div>
                        </div>

                        <div class="col-lg-6 pull-right">
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-primary active">
                                    <input type="radio" name="options1" id="option1" value="0"
                                           onchange="javascript:index_ChangeHiddenAccord(1,0);shop_AjaxChange(0);"> 人气
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="options1" id="option2" value="1"
                                           onchange="javascript:index_ChangeHiddenAccord(1,1);shop_AjaxChange(0);"> 销量
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="options1" id="option3" value="2"
                                           onchange="javascript:index_ChangeHiddenAccord(1,2);shop_AjaxChange(0);"> 评分
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="row-fluid">
                            <!--商铺面板-->
                            <table id="shopMainPanel" class="table table-bordered table-responsive">
                            </table>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span8 offset4">
                            <div class="pagination pagination-center">
                                <ul id="shop_page">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="panel panel-info" id="dishRank">
                    <div class="panel-heading" style="height: 58px">
                        <div class="span3">
                            <div class="btn-group" data-toggle="buttons">
                                <a title="有赠品"><label class="btn btn-danger">
                                    <span class="glyphicon glyphicon-gift"></span>
                                </label></a>
                                <a title="两份以上优惠"><label class="btn btn-info">
                                    <span class="glyphicon glyphicon-euro"></span>
                                </label></a>
                                <a title="三份以上优惠"><label class="btn btn-warning">
                                    <span class="glyphicon glyphicon-bell"></span>
                                </label></a>
                                <a title="没有优惠"><label class="btn btn-primary">
                                    <span class="glyphicon glyphicon-home"></span>
                                </label></a>
                            </div>
                        </div>

                        <div class="span3">

                        </div>

                        <div class="span6 pull-right">
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-primary active">
                                    <input type="radio" name="options" id="dish_option2" value="1"
                                           onchange="javascript:index_ChangeHiddenAccord(2,1);dish_AjaxChange(0);"> 销量
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                                <label class="btn btn-primary">
                                    <input type="radio" name="options" id="dish_option3" value="2"
                                           onchange="javascript:index_ChangeHiddenAccord(2,2);dish_AjaxChange(0);"> 评分
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <!--菜品面板-->
                    <div class="panel-body">
                        <div class="row-fluid">
                            <table id="dishMianPanel" class="table table-bordered table-responsive">
                                <!-- table面板 -->
                            </table>
                        </div>
                    </div>

                    <div class="row-fluid">
                        <div class="span8 offset4">
                            <div class="pagination pagination-center ">
                                <ul id="dish_page">
                                    <!-- 分页 -->
                                </ul>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <div class="span1 pull-right">
                <div class="row-fluid" id="rankNavButtonGroup" style="margin-top:150px;">
                    <button class="btn btn-primary btn-lg toOnline">在线<br>订餐</button>
                    <br>
                    <br>
                    <button class="btn btn-info btn-lg toPhone">电话<br>订餐</button>
                    <br>
                    <br>
                    <button class="btn btn-default btn-lg toTop">返回<br>顶端</button>
                </div>

            </div>
        </div>
    </div>


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <hr class="featurette-divider">


    <div class="container" id="phoneCallPart">

        <div class="row-fluid">

            <div class="span1">
                <div id="phoneCallOrder" style="height: 0px">
                </div>
            </div>
            <div class="span1">
                <div class="featurette-heading">
                </div>
            </div>
            <div class="span8">
                <div class="navbar navbar-inverse phoneCallPin">
                    <div class="navbar-header">
                        <button data-target="#nav-collapse-01" data-toggle="collapse" class="btn btn-navbar"
                                type="button"></button>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav">
                            <li>
                                <a>
                                    <span class="text-warning"><span class="fui-chat"></span>电话订餐</span>
                                </a>
                                <a href="#phoneCallShopRank">
                                    </span>店铺排行</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav -->
                </div>
            </div>
            <div class="span2">

            </div>
        </div>

        <div style="height: 5px"></div>

        <div class="row-fluid" style="height: 800px">

            <div class="span12">

                <div class="panel panel-warning">
                    <div class="panel-heading" style="height: 58px">
                        <div class="span3">
                            <div class="btn-group" data-toggle="buttons">

                                <a title="有赠品"><label class="btn btn-danger">
                                    <span class="glyphicon glyphicon-gift"></span>
                                </label></a>
                                <a title="两份以上优惠"><label class="btn btn-info">
                                    <span class="glyphicon glyphicon-euro"></span>
                                </label></a>
                                <a title="三份以上优惠"><label class="btn btn-warning">
                                    <span class="glyphicon glyphicon-bell"></span>
                                </label></a>
                                <a title="没有优惠"><label class="btn btn-primary">
                                    <span class="glyphicon glyphicon-home"></span>
                                </label></a>

                            </div>
                        </div>

                        <div class="span3">
                            <select id="sel_call_taste" title="选择口味"
                                    onchange="index_ChangeHiddenSelTaste(this,3);phone_AjaxChange(0);">
                                <option value="">全部</option>
                            <#list shopTasteTags as tags>
                                <option value="${tags.id}">${tags.name}</option>
                            </#list>
                            </select>
                        </div>

                        <div class="span6">
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-primary active">
                                    <input type="radio" name="options" id="option1"
                                           onchange="javascript:index_ChangeHiddenAccord(3,0);phone_AjaxChange(0);"> 人气
                                    <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                                <!--
                                <label class="btn btn-primary">
                                    <input type="radio" name="options" id="option3" value="2" onchange="javascript:index_ChangeHiddenAccord(3,2);phone_AjaxChange(0);"> 评分 <span class="glyphicon glyphicon-sort-by-attributes"></span>
                                </label>
                                -->
                            </div>
                        </div>
                    </div>
                    <!--电话商铺面板-->
                    <div class="panel-body">

                        <div class="row-fluid">
                            <div class="row-fluid">
                                <table id="callMainPanel" class="table table-bordered table-responsive">
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="row-fluid">
                        <div class="span8 offset4">
                            <div class="pagination pagination-center ">
                                <ul id="call_page">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
<!-- end of rankPart the big part -->
<!-- 购物车开始 -->
<#include "./snippet/globalModal.ftl" />
<#include "./snippet/shoppingcart.ftl" />
<#include "./snippet/signinModal.ftl" />

<!-- 购物车结束 -->


<!--hidden fields-->
<input type="hidden" id="current_areaId" value="">

<input type="hidden" id="shop_accord" value="0"/>
<input type="hidden" id="dish_accord" value="0"/>
<input type="hidden" id="call_accord" value="0"/>

<input type="hidden" id="shop_taste" value=""/>
<input type="hidden" id="dish_taste" value=""/>
<input type="hidden" id="call_taste" value=""/>

<input type="hidden" id="shop_pNumber" value="0">
<input type="hidden" id="dish_pNumber" value="0">
<input type="hidden" id="call_pNumber" value="0">

<!-- FOOTER -->
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>

    <p>&copy; 2015 CodeHolic Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>


<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="res/js/jquery-1.8.3.min.js"></script>
<script src="res/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="res/js/jquery.ui.touch-punch.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<script src="res/js/bootstrap-select.js"></script>
<script src="res/js/bootstrap-switch.js"></script>
<script src="res/js/flatui-checkbox.js"></script>
<script src="res/js/flatui-radio.js"></script>
<script src="res/js/jquery.tagsinput.js"></script>
<script src="res/js/jquery.placeholder.js"></script>
<script src="res/js/jquery.pin.min.js"></script>
<script src="res/js/jquery.scrollto.js"></script>
<script src="res/js/holder.js"></script>
<script src="res/js/custom/index.js"></script>
<script src="res/js/custom/index_phone.js"></script>
<script src="res/js/custom/index_shop.js"></script>
<script src="res/js/custom/index_dish.js"></script>
<script src="res/js/custom/index_shop_popover.js"></script>
<script src="res/js/custom/shoppingCart.js"></script>
<script src="res/js/custom/search.js"></script>
<script src="../res/js/custom/pendingOrder.js"></script>
<script src="../res/js/custom/publicRedirect.js"></script>

</body>
</html>