<!DOCTYPE html>
<html lang="en">
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
    <link href="/res/adminshop/css/signin.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <form class="form-signin" role="form" action="/admin/shop/doSignin.f1t">
        <h2 class="form-signin-heading">请登录</h2>
        <input name="username" type="text" class="form-control" placeholder="用户名" required autofocus>
        <input name="password" type="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div> <!-- /container -->

<script src="/res/adminshop/js/jquery.min.js"></script>
<script src="/res/adminshop/js/bootstrap.min.js"></script>
</body>
</html>
