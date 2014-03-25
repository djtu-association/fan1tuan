<div>
    <h1>饭1团<small> 管理中心 </small></h1>
    <span class="divider"></span>
</div>

<hr class="divider">

<!--left bar-->
<div style="float: left;margin-right: 20px;width: 13%;">

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">主菜单</h3>
        </div>
        <div class="panel-body">
            <ul class="nav nav-pills nav-stacked">
                <li <#if navName?exists&&navName=="adminindex"> class="active"</#if> ><a href="http://localhost:8080/admin/index.f1t" >主页</a></li>
                <li <#if navName?exists&&navName=="adminuser"> class="active"</#if> ><a href="#">用户管理</a></li>
                <li <#if navName?exists&&navName=="adminshop"> class="active"</#if> > <a href="http://localhost:8080/admin/shop/showShopList.f1t" >店铺管理</a></li>
                <li <#if navName?exists&&navName=="adminorder"> class="active"</#if> ><a href="#">订单管理</a></li>
                <li <#if navName?exists&&navName=="adminadvert"> class="active"</#if> ><a href="#">广告管理</a></li>
            </ul>
        </div>
    </div>


</div>