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