<!DOCTYPE html>
<html>
<head>
    <title>快递管理后台</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../../res/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="../../res/plugin/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../../res/js/html5shiv.js"></script>
    <script src="../../res/js/respond.min.js"></script>

    <![endif]-->
</head>
<body>



<!--top navigator bar-->
<div>
    <nav class="navbar navbar-default navbar-inverse " role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand " href="http://localhost:8080/index.f1t">Fan1Tuan</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <!--left-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Main</a></li><!-- add class="active" @ the current use-->
                <li><a href="#">Admin</a></li>
            </ul>

            <!--right-->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign in</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Log out</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</div>

<!--Main frame-->
<div class=".container">

    <!--head of center body-->
    <div>
        <h1>Admin<small> welcome</small></h1>
        <span class="divider"></span>
    </div>

    <hr class="divider">

    <!--left bar-->
    <div style="float: left;margin-right: 20px;width: 13%;">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <h3 class="panel-title"><strong>管理面板</strong></h3>
            </div>
            <div class="panel-body">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="javascript:void(0)">账号信息</a></li>
                    <li><a href="showTodayOrders.f1t">今天未处理订单</a></li>
                    <li><a href="showHistoryOrders.f1t">历史订单</a></li>
                </ul>
            </div>
        </div>


    </div>

    <!--mid bar-->
    <div style="float: left;width: 80%">

        <!--head-->

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title"><strong>版块管理</strong></h3>
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

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../res/plugin/datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</body>
</html>