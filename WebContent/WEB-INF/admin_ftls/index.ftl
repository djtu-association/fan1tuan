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

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title">版块管理</h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <h1>Admin System</h1>
                    <div class="jumbotron">
                        <ul>
                            <li>
                                <h2>主版块管理</h2>
                                <button type="button" class="btn btn-primary">主版块管理</button>
                                <button type="button" class="btn btn-warning">子版块管理</button>
                            </li>
                            <li>
                                <h2>用户版块管理</h2>
                                <button type="button" class="btn btn-primary">主版块管理</button>
                                <button type="button" class="btn btn-warning">子版块管理</button>
                            </li>
                        </ul>

                    </div>

                </div>

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>