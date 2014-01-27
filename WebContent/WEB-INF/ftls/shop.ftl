
<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="./favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="../res/css/bootstrap.css" rel="stylesheet">
    <link href="../res/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="../res/css/flat-ui.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="./js/html5shiv.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->

    <!-- page independent -->
    <title>*饭1团*</title>
    <link href="../res/css/custom/index.css" rel="stylesheet">
    <link href="../res/css/custom/shoppingcart.css" rel="stylesheet">
    <link href="../res/css/custom/shop.css" rel="stylesheet">
</head>





<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper"  id="top">
    <div class="container">

        <div class="navbar" style="background: #d1f2eb">
            <div class="navbar-header">
                <button data-target="#nav-collapse-01" data-toggle="collapse" class="btn btn-navbar" type="button"></button>
            </div>
            <div id="nav-collapse-01" class="navbar-collapse collapse">
                    <ul class="nav">
                    	
                        <li>
                            <a href="#"><span >Fan1tuan</span></a>
                        </li>
                        
                        <li id="navOnlineOrder"   title="" data-toggle="popover">
                            <a href="javascript:void(0)" id="toOnline"><span class="fui-cmd"></span><span >在线订餐</span></a>
                        </li>
                        <li id="navPhoneCallOrder" title="" data-toggle="popover">
                            <a href="javascript:void(0)" id="toPhone"><span class="fui-chat"></span><span >电话订餐</span></a>
                        </li>
                        
                        
                        <!-- <li id="" title="" data-toggle="">
                            <a href="javascript:void(0)" id="navReserveSeat" onclick="location='areas.f1t'"><span class="fui-location"></span><span ><#if areaName?exists>${areaName}</#if></span></a>
                        </li> -->
                        
                        <!--<li id="navLifeSurround" title="" data-toggle="popover">
                            <a href="javascript:void(0)" onclick="location='../life/index.f1t'"><span class="fui-location"></span><span >本地生活</span></a>
                        </li>-->
				
                    </ul>
     
                    <ul class="nav navbar-nav">
                    	<#include "./snippet/userstatus.ftl" />
                    </ul>
                    <form class="navbar-form navbar-left form-inline pull-right" role="search">
                        <div class="input-group">
                            <div class="form-group">
                                <input id="searchField" type="text" class="form-control" size="25" placeholder="搜店.搜美食" />
                                <span class="input-icon fui-search"></span>
                            </div>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid" style="background: #f5f5f5">
    <div style="height: 100px"></div>
    <div class="row-fluid">
        <div class="span1">
            <br>
            <a href="../index.f1t" class="btn btn-default btn-lg"><i class="glyphicon glyphicon-step-backward"></i></a>
        </div>
        <div class="span3"  id="shopPopover"  title="" data-toggle="popover" >
            <div class="row-fluid" id="shopPopoverCotainer">
                <div class="span4" >
                    <img class="img-thumbnail"   src="../res/images/shop-image.jpeg" alt="Generic placeholder image" style="width: 96px;height: 96px">
                </div>
                <div class="span8">
                    <div class="row-fluid">
                        <h6 title="${shop.id}" class="shop-title"><strong>${shop.name}</strong></h6>
                    </div>
                    <div class="row-fluid">
                        <a href="/rating" class="rst-rating" id="rst_rating"><i class="icon-rst-rating s${(shop.avgCommentLevel*2)?int}"></i> ${shop.avgCommentLevel}</a>
                    </div>
                    <div  class="sr-only">
                        <div id="starDiagram"  style='width: 250px;height: 400px' class="rst-header-detail rst-header-dropdown">
                            <section class="rst-header-detail-block group">
                                <div class=" row-fluid">
                                    <div class="span5  rating-point">
                                        <a class="point">${shop.avgCommentLevel}</a>
                                    </div>
                                </div>
                                <div class="rating-diagram">
                                	<#if shop.commentNum==0 >
                                		<#assign commentNum=1 />
                                	<#else>
                                		<#assign commentNum=shop.commentNum />
                                	</#if>
                             
                                    <span class="diagram-item"><a href="/rating"><i class="icon-star s5"></i><span style="width: ${140*(commentLevel['5']!'0')?number/commentNum}px;" class="bar"></span> ${100*(commentLevel['5']!'0')?number/commentNum}%</a></span>
                                    <br>
                                    <span class="diagram-item"><a href="/rating"><i class="icon-star s4"></i><span style="width: ${140*(commentLevel['4']!'0')?number/commentNum}px;" class="bar"></span> ${100*(commentLevel['4']!'0')?number/commentNum}%</a></span>
                                    <br>
                                    <span class="diagram-item"><a href="/rating"><i class="icon-star s3"></i><span style="width: ${140*(commentLevel['3']!'0')?number/commentNum}px;" class="bar"></span>  ${100*(commentLevel['3']!'0')?number/commentNum}%</a></span>
                                    <br>
                                    <span class="diagram-item"><a href="/rating"><i class="icon-star s2"></i><span style="width: ${140*(commentLevel['2']!'0')?number/commentNum}px;" class="bar"></span>  ${100*(commentLevel['2']!'0')?number/commentNum}%</a></span>
                                    <br>
                                    <span class="diagram-item"><a href="/rating"><i class="icon-star s1"></i><span style="width: ${140*(commentLevel['1']!'0')?number/commentNum}px;" class="bar"></span> ${100*(commentLevel['1']!'0')?number/commentNum}%</a></span>
                                </div>
                            </section>
                            <section class="rst-header-detail-block group">
                                <p class="text text-danger lead"><i class="glyphicon glyphicon-time"></i> ${shop.openTime?string("HH:mm")} - ${shop.closeTime?string("HH:mm")}  </p>
                                <p class="text text-default"><i class="fui-location"></i> ${shop.address} </p>
                                <p class="text text-primary"><i class="glyphicon glyphicon-info-sign"></i> ${shop.description} </p>
                                <p class="text text-info"><i class="glyphicon glyphicon-user"></i> ${shop.cellphone} </p>
                            </section>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="span7">
            <div class="row-fluid">
                <div class="span4">
                    <br>
                    <p class="featurette-heading lead" style="font-size: 50px">
                    	<i class="glyphicon glyphicon-shopping-cart"></i><span style="font-size:58px">${shop.avgPersonCost}</span>
                    	<span style="font-size: 15px">人均消费/元</span>               
                    </p>
                </div>
                <div class="span4">
                    <br>
                    <p class="featurette-heading lead" style="font-size: 50px">
                    	<i class="glyphicon glyphicon-time"></i><span style="font-size:58px">${shop.avgDeliveryTime}</span>
                    	<span style="font-size: 15px">送餐时间/分钟</span>               
                    </p>
                </div>
                <div class="span4">
                    <br>
                    <p class="featurette-heading lead" style="font-size: 50px">
                    	<i class="fui-location"></i><span style="font-size:58px">${distance}K</span>
                    	<span style="font-size: 15px">距离/米</span>               
                    </p>
                </div>
            </div>
        </div>
        <div class="span1"></div>
        <div style="height: 120px"></div>
    </div>

</div>

<div style="height: 30px"></div>


<div class="container-fluid">
    <div class="row-fluid">
        <div class="span8 offset1">
            <div class="row-fluid">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="lead">美食分类</span>
                    </div>
                    <div class="panel-body">
                        <div id="dishList">
                            <div class="rst-cate-wrapper" id="menu_cate_wrapper">
                            <ul style="list-style-type:none;" class="rst-cate-list" id="menu_cate_list">
                            	<#list dishTasteTags as dishTasteTag>
									<li class="cate_item cate-item">
                                    	<a  title="${dishTasteTag.id}" class="cate_name cate-name">${dishTasteTag.name}<span class="badge badge-danger">${dishes["${dishTasteTag.id}"].size()}</span></a>&nbsp;
                                	</li>
								</#list>
                            </ul>
                            </div>
                        </div>
                    </div>
                </div>
                
                <#list dishTasteTags as dishTasteTag>
                <div id="${dishTasteTag.id}" class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row-fluid">
                            <div class="span3">
                            	<div class="btn-toolbar">
                            		<div class="dish-cat-head btn-group">
                                		<a class="btn btn-success">${dishTasteTag.name}</a>
                                		<a href="#top" class="btn btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                                	</div>
                            	</div>
                            </div>
                            <div class="span2 offset3">
                                <button class="btn btn-primary">美食分类</button>
                            </div>
                            <div class="span4">
                                <div class="btn-toolbar">
                                    <div class="btn-group">
                                        <a href="#fakelink" class="btn btn-primary active"><i class="fui-time"></i></a>
                                        <a href="#fakelink" class="btn btn-primary"><i class="fui-photo"></i></a>
                                        <a href="#fakelink" class="btn btn-primary"><i class="fui-eye"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover">
                            
                            <#list dishes["${dishTasteTag.id}"] as dish>  
                            <tr title="${dish.id}" class="dish_body_list_item">
                            	
                                <td style="width:250px">
                                    <img title="${dish.id}" src="../res/images/shop-image.jpeg" style="height: 42px;width: 42px" />
                                    <span class="lead dish-cat-head"> <a class="dish_item" title="${dish.id}">${dish.name}</a> </span>
                                    <a><i class="glyphicon glyphicon-tag"></i></a>
                                </td>
                                <td style="width:50px">
                                	<span class="label label-danger order_number sr-only">0</span>                                	                                	                                	
                                </td>                               
                                <td>
                                    <button title="${dish.id}" class="btn btn-info order_btn"><i class="icon-rst-deliver"></i>${dish.price}</button>
                                </td>
                                <td style="width:45px">
                                    <a class="text text-danger lead"><i class="glyphicon glyphicon-heart-empty sr-only heart"></i> </a>
                                </td>
                                <td>
                                    <i class="icon-rst-rating s${(dish.avgCommentLevel*2)?int}"></i>(${dish.commentNum})<br>
                                    月售${dish.saleVolume}份
                                </td>
                            </tr>
                            </#list>
                    
                        </table>
                    </div>
                </div>
                	
				</#list>
             
            </div>
        </div>
        <div class="span3">
            <div class="row-fluid">
                <div class="span11">
                    <div class="row-fluid">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <span class="lead">店铺信息</span>
                            </div>
                            <div class="panel-body">
                                <section>
                                    <p class="text text-primary"><i class="glyphicon glyphicon-bullhorn"></i> ${shop.announcement}</p>
                                </section>
                                <hr>
                                <section>
                                    <p class="text text-danger"><i class="glyphicon glyphicon-road"></i> 起送价${shop.deliveryCharge}元。</p>
                                </section>
                                <hr>
                                <section>                             
                                    <p class="text text-info" style="font-size:13px"><i class="icon-rst-badge online-payment"></i>本店铺支持在线付款。</p>
                                    <p class="text text-info" style="font-size:13px"><i class="icon-rst-badge new-restaurant"></i>本店新开张，有活动和优惠。</p>
                                    <p class="text text-info" style="font-size:13px"><i class="icon-rst-badge invoice"></i>本店支持开具发票。</p>
                                </section>
                                <hr>
                                <section>
                                    <div class="row-fluid">
                                        <div class="span6 text-center">
                                            <button class="btn btn-info btn-lg"><i class="glyphicon fui-heart"></i> 收藏</button>
                                        </div>
                                        <div class="span6 text-center">
                                            <button class="btn btn-info btn-lg"><i class="glyphicon glyphicon-comment"></i> 评论</button>
                                        </div>
                                    </div>
                                </section>
                            </div>

                        </div>
                    </div>
                    
                    <div class="row-fluid">
                        <div class="panel panel-danger">
                            <div id="map_out_body" class="panel-body">
                                <img src="${mapUrl}" />
                            </div>
                        </div>
                    </div>
                    <div class="fixed_right">
                    	<div style="height:25px"></div>
                    	<div class="row-fluid">
                        	<div class="panel panel-danger">
                               	<div style="padding: 10px 15px; border-bottom: 1px solid transparent; border-top-right-radius: 3px; border-top-left-radius: 3px;">
                               		<span class="lead">掌柜热卖</span>
                               	</div>
                            	<div class="panel-body">
									<table class="table table-hover">
									<#list topDishes as topDish>
										<tr>
											<td>
                                    			<span class="lead dish-cat-head"> <a class="dish_item" title="${topDish.id}">${topDish.name}</a></span><br>
                                    			<i class="icon-d-star s${(topDish.avgCommentLevel*2)?int}"></i><span class="lead" style="font-size:14px">(${topDish.commentNum})</span>										
											</td>
											<td>
                                    			<button class="btn btn-info btn-sm order_btn" title="${topDish.id}"><i class="icon-rst-deliver"></i>${topDish.price}</button>
                                			</td>
										</tr>
									</#list>
									</table>
                            	</div>
                        	</div>
                    	</div>
						<#if Session["loginOK"]?exists && Session["loginOK"]==1>
                    	<div class="row-fluid">
                        	<div class="panel panel-success">
                                	
                        		<div style="padding: 10px 15px; border-bottom: 1px solid transparent; border-top-right-radius: 3px; border-top-left-radius: 3px;">
                               		<span class="lead">我的私房菜</span>
                               	</div>
                            	<div class="panel-body">

                            	</div>
                        	</div>
                    	</div>
                    	</#if>
                    </div>
                </div>
                <div class="span1">

                </div>
            </div>
        </div>
    </div>
</div>

<div style="height:250px"></div>

<#include "./snippet/shoppingcart.ftl" />



<!-- FOOTER -->
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>

<div class="rst-mask s_r_m" style="display: none;"></div>
<div class="rst-drawer-wrapper">
    <article class="rst-drawer s_r_d">
        
    </article>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../res/js/jquery-1.8.3.min.js"></script>
<script src="../res/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="../res/js/jquery.ui.touch-punch.min.js"></script>
<script src="../res/js/jquery.scrollto.js"></script>
<script src="../res/js/bootstrap.min.js"></script>
<script src="../res/js/bootstrap-select.js"></script>
<script src="../res/js/bootstrap-switch.js"></script>
<script src="../res/js/flatui-checkbox.js"></script>
<script src="../res/js/flatui-radio.js"></script>
<script src="../res/js/jquery.tagsinput.js"></script>
<script src="../res/js/jquery.placeholder.js"></script>
<script src="../res/js/jquery.pin.min.js"></script>
<script src="../res/js/custom/index.js"></script>
<script src="../res/js/holder.js"></script>
<script src="../res/js/custom/shop.js"></script>
<script src="../res/js/custom/shoppingCart.js"></script>

</body>
</html>
