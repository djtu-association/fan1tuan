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
      <link href="../res/css/flat-ui.css" rel="stylesheet">

      <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="./res/js/html5shiv.js"></script>
      <![endif]-->


      <!-- 每夜独立部分 -->
      <link href="../res/css/custom/signin.css" rel="stylesheet">
      <title>饭团</title>


  </head>

  <body style="background: white">

  <div class="jumbotron">
      <div class="container">
          <div class="col-lg-6">
              <h1>饭1团来啦!</h1>
              <p class="lead">我们专注校园外卖，“食”刻为你准备着！！</p>
              <p><a class="btn btn-primary btn-lg" href="javascript:void(0)" onclick="location='../index.f1t'">进入主页</a></p>
          </div>

		  <#if flag == 0>
          <div id="coll_div2" style="display: none" class="col-lg-3">
          <#else>
          <div id="coll_div2" class="col-lg-3">
          </#if>
              <form class="form-signin pull-right">
                  <h2 class="form-signin-heading"><strong>注册</strong></h2>
                  <span><input id="regCellphone"type="text" class="form-control" placeholder="手机号码" size="100" autofocus></span>
                  <span><input id="regPassword" type="password" class="form-control" placeholder="登陆密码"  size="100"></span>
                  <span><input id="regRepassword" type="password" class="form-control" placeholder="重复密码"  size="100"></span>
                  <span><input id="regCheckcode" type="text" class="form-control" placeholder="验证码"  size="100"></span>
                  <span><button type="button" class="btn btn-sm btn-success">获取验证码</button></span>
                  <br/>
                  <span>
                      <button class="btn btn-info btn-lg" type="button" id="col_btn2">返回登陆</button>
                      <button type="button" class="btn btn-primary btn-lg" id="signIn">注册</button>
                  </span>
                  <br/>
                  <span id="sign_tips" class="label label-danger"></span>
              </form>
          </div>
			
		  <#if flag == 1>
          <div class="col-lg-3" id="coll_div1" style="display: none">
          <#else>
          <div class="col-lg-3" id="coll_div1">
          </#if>

              <div>
                  <form class="form-signin pull-right">
                      <h2 class="form-signin-heading"><strong>请登录</strong></h2>
                      <div id="form_div1">
	                      <span><input name="cellphone" id="logCellphone" type="text" class="form-control" placeholder="手机号码" size="100" autofocus value="<#if lastLogin?exists>${lastLogin.cellphone}</#if>"></span>
	                      <span><input name="password" id="logPassword" type="password" class="form-control" placeholder="登陆密码"  size="100" value=""></span>
	                      <div  class="switch switch-square" data-toggle="tooltip" title="记住我的登陆">
	                          <input type="checkbox" id="rememberMe" checked data-toggle="switch" />
	                      </div>
	                      <br/>
	                      <span>
	                          <button class="btn btn-primary btn-lg" id="btn_login" type="button">登陆</button>
	                          <button type="button" class="btn btn-danger btn-lg" id="col_btn1">注册</button>
	                      </span>
	                      <br/>
	                      <span id="form_tips" class="label label-danger"></span>
                      </div>
                  </form>
              </div>
          </div>

      </div>
  </div>


  <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-gift"/>恭喜你,注册成功</h4>
              </div>
              <div class="modal-body">
                  <p><span class="glyphicon glyphicon-time"/><span id="countTime">5</span>秒后自动登陆进入到饭1团
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location='reg.f1t'">返回注册页面</button>
                  <button type="button" class="btn btn-primary" onclick="location='setArea.f1t'">自动登陆进入主页</button>
              </div>
          </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->




    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  <script src="../res/js/jquery-1.8.3.min.js"></script>
  <script src="../res/js/jquery-ui-1.10.3.custom.min.js"></script>
  <script src="../res/js/jquery.ui.touch-punch.min.js"></script>
  <script src="../res/js/bootstrap.min.js"></script>
  <script src="../res/js/bootstrap-select.js"></script>
  <script src="../res/js/bootstrap-switch.js"></script>
  <script src="../res/js/flatui-checkbox.js"></script>
  <script src="../res/js/flatui-radio.js"></script>
  <script src="../res/js/jquery.tagsinput.js"></script>
  <script src="../res/js/jquery.placeholder.js"></script>
  <script src="../res/js/custom/signin.js"></script>
  </body>
</html>
