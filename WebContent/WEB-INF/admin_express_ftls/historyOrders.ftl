<!DOCTYPE html>
<html>
<head>
    <title>快递管理后台</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="../plugin/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.js"></script>
    <script src="../js/respond.min.js"></script>

    <![endif]-->
</head>
<body>



<!--top navigator bar-->
<div>
    <nav class="navbar navbar-default navbar-inverse " role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand " href="#">Fan1Tuan</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <!--left-->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Main</a></li><!-- add class="active" @ the current use-->
                <li><a href="#">Admin</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">More Entry<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Action</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One Action</a></li>
                    </ul>
                </li>
            </ul>

            <!--Search-->
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

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

    <hr class="divider">

    <div class="panel panel-primary">
        <div class="panel-body">
            <div>
                <ul>
                    <li>
                        <h2><strong>快递单管理</strong></h2>
                        <button type="button" class="btn btn-info">账号管理</button>
                        <button type="button" class="btn btn-info">今天订单</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--mid bar-->
    <div>
        <!--head-->

        <!--center-->
        <div>
            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title"><strong>历史订单查看</strong></h3>
                </div>

                <!--main panel-->
                <div class="panel-body">
                    <div>
                        <table class="table table-responsive table-bordered">
                            <tr>
                                <th>NO.</th>
                                <th>姓名</th>
                                <th>手机</th>
                                <th>快递</th>
                                <th>地址</th>
                                <th>备注</th>
                                <th>状态</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>JOE</td>
                                <td>1864088...</td>
                                <td>顺丰</td>
                                <td>这里</td>
                                <td>备注</td>
                                <td><label class="label label-warning">等待审核</label></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>JOE</td>
                                <td>1864088...</td>
                                <td>顺丰</td>
                                <td>这里</td>
                                <td>备注</td>
                                <td><label class="label label-info">等待领取</label></td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>JOE</td>
                                <td>1864088...</td>
                                <td>顺丰</td>
                                <td>这里</td>
                                <td>备注</td>
                                <td><label class="label label-danger">订单完成</label></td>
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

                <!--footer-->
                <div class="panel" style="float: right;">

                </div>
            </div>
        </div>
    </div>

</div>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../plugin/datepicker/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../plugin/datepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="../plugin/datepicker/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
</body>
</html>