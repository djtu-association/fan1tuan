<!--前端页面的导航部分 可以直接被其他页面引用-->
<div class="navbar">
    <div class="navbar-header">
        <button data-target="#nav-collapse-01" data-toggle="collapse" class="btn btn-navbar" type="button"></button>
    </div>
    <div id="nav-collapse-01" class="navbar-collapse collapse">
        <ul class="nav">

            <li>
                <a href="http://localhost:8080/index.f1t"><span>美餐</span></a>
            </li>

            <li id="navLocalLife" data-toggle="popover">
                <a href="javascript:void(0)" onclick="location='http://localhost:8080/life/index.f1t'"
                   id="toOnline"><span class="fui-cmd"></span><span>校园服务</span></a>
            </li>

            <li id="" title="" data-toggle="">
                <a class="need-redirect" href="javascript:void(0)" id="navReserveSeat"
                   onclick="location='http://localhost:8080/areas.f1t'"><span
                        class="fui-location"></span><span><#if areaName?exists>${areaName}<#else>选择位置</#if></span></a>
            </li>

            <!--
            <li id="navPhoneCallOrder" title="" data-toggle="popover">
                <a href="javascript:void(0)" id="toPhone"><span class="fui-chat"></span><span >电话订餐</span></a>
            </li>

            <li id="navReserveSeat" title="" data-toggle="popover">
                <a href="#"><span class="fui-calendar-solid"></span><span >预留餐位</span></a>
            </li>

            <li id="navLifeSurround" title="" data-toggle="popover">
                <a href="javascript:void(0)" onclick="location='../life/index.f1t'"><span class="fui-location"></span><span >本地生活</span></a>
            </li>-->

        </ul>

        <ul class="nav navbar-nav">
        <#if Session["login"]?exists && Session["login"]["loginStatus"]?exists && Session["login"]["loginStatus"]=="1">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                        class="glyphicon glyphicon-user"></span><#if Session["currentUser"]["realName"]?exists> ${Session["currentUser"]["cellphone"]} <#else> ${Session["currentUser"]["cellphone"]} </#if>
                    <b class="caret"></b></a>
                <ul class="dropdown-menu dropdown-inverse">
                    <li><a href="#"><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;我的页面</a></li>
                    <li><a href="http://localhost:8080/user/index.f1t#orders"><i
                            class="glyphicon glyphicon-list-alt"></i>&nbsp;&nbsp;&nbsp;已下的饿单</a></li>
                    <li><a href="http://localhost:8080/user/index.f1t#comments"><i
                            class="glyphicon glyphicon-thumbs-up"></i>&nbsp;&nbsp;&nbsp;已下的评价</a></li>
                    <li><a href="http://localhost:8080/user/index.f1t#favorites"><i
                            class="glyphicon glyphicon-heart"></i>&nbsp;&nbsp;&nbsp;我的收藏</a></li>
                    <li><a href="http://localhost:8080/user/index.f1t#info"><i class="glyphicon glyphicon-tasks"></i>&nbsp;&nbsp;&nbsp;收货地址管理</a>
                    </li>
                    <li><a href="http://localhost:8080/user/index.f1t#info"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;&nbsp;个人信息</a>
                    </li>
                    <li class="divider"></li>
                    <li><a class="need-redirect" href="javascript:void(0)"
                           onclick="location='http://localhost:8080/signout.f1t'" id="logout"><i
                            class="glyphicon glyphicon-off"></i>&nbsp;&nbsp;&nbsp;退出登录</a></li>
                </ul>
            </li>
            <li>
                <a id="pendingOrder" href="#fan1tuanModal" role="button"><i class="glyphicon glyphicon-list-alt"></i>
                    订单动态 <span class="badge badge-success">2</span></a>

                <div id="pendingOrderModal" class="sr-only">
                    <div class="modal-header" style="height:45px">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h6 class="badge" style="font-size:20px" id="myModalLabel">饿单快报</h6>
                    </div>
                    <div class="modal-body">

                    </div>
                    <!-- <div class="modal-footer">
                        <button class="btn close-btn" data-dismiss="modal" aria-hidden="true">Close</button>
                        <button class="btn btn-primary">Save changes</button>
                    </div> -->
                </div>
            </li>
        <#else>
            <li><a class="need-redirect" href="javascript:void(0)"
                   onclick="location='http://localhost:8080/secure/signin.f1t'"><span
                    class="glyphicon glyphicon-user"></span> 登陆</a></li>
            <li><a class="need-redirect" href="javascript:void(0)"
                   onclick="location='http://localhost:8080/secure/signup.f1t'"><span
                    class="glyphicon glyphicon-check"></span> 注册 </a></li>
        </#if>
        </ul>
        <form class="navbar-form navbar-left form-inline pull-right" role="search">
            <div class="input-group">
                <div class="form-group">
                    <input id="searchField" type="text" class="form-control" size="25" placeholder="搜店.搜美食"/>
                    <span class="input-icon fui-search"></span>
                </div>
            </div>
        </form>
    </div>
</div>

