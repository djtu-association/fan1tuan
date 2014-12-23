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
    <link href="/res/adminshop/css/signup.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <form class="form-signin" role="form" action="/admin/shop/doSignup.f1t">
        <h2 class="form-signin-heading">"美餐"商家注册</h2>
        <input name="username" type="text" class="form-control" placeholder="用户名" required autofocus>
        <input name="password" type="password" class="form-control" placeholder="密码" required>
        <input name="passwordAgain" type="password" class="form-control" placeholder="密码确认" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->

<script src="/res/adminshop/js/jquery.min.js"></script>
<script src="/res/adminshop/js/bootstrap.min.js"></script>
<script>
    var search = window.location.search;
    var message = search.substr(search.indexOf("message")+("message".length+1), 1);

    if (message == "1") {
        $(".form-signin").prepend(formMessage("danger", "注册失败！", "用户名已被占用，请更换"));
    }

    function formMessage(type, title, body) {
        return ['<div class="alert alert-'+type+'" role="alert">',
            '<b>'+title+'</b>'+body,
            '</div>'].join('');
    }

</script>
</body>
</html>
