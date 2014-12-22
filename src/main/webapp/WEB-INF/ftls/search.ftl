<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0">

    <title>*美餐*|搜索美食</title>
    <link rel="stylesheet" href="../res/css/semantic.css">
</head>
<body>

<br>

<div class="ui page padded grid">
    <div class="sixteen wide column">
        <h2 class="ui header">
            <i class="search icon"></i>
            <div class="content">
                "美餐"千百度
                <div class="sub header">欢迎来到美餐网搜索页面，觉着主页信息没有亲相中的宝贝餐食吗，来这里搜搜再试试？</div>
            </div>
        </h2>
    </div>
    <div class="sixteen wide column">
        <div class="ui action fluid input">
            <input id="keyword-field" type="text" value="${keyword}" placeholder="输入关键字搜索店铺或菜品">
            <div class="ui teal right labeled icon button" id="search-button">
                <i class="search icon"></i>
                搜索
            </div>
        </div>
    </div>
    <#if blandRequest==false>
        <div class="sixteen wide column">
            <div class="ui six cards">
                <#list shops as shop>
                    <div class="card">
                        <div class="dimmable image">
                            <div class="ui dimmer">
                                <div class="content">
                                    <div class="center">
                                        <div class="ui inverted left labeled button shop-button" data-bind="${shop.id}"><i class="home icon"></i>进店铺</div>
                                    </div>
                                </div>
                            </div>
                            <img src="../res/avatar/shop/${shop.avatar}">
                        </div>
                        <div class="content">
                            <a class="header" href="#">${shop.name}</a>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
        <div class="sixteen wide column">
            <div class="ui divided items">
                <#list dishes as dish>
                    <div class="item">
                        <div class="ui tiny image">
                            <img src="../res/avatar/dish/${dish.image}">
                        </div>
                        <div class="content">
                            <a class="header">${dish.name}</a>
                            <div class="description">
                                <p>${dish.description}</p>
                                <div class="ui vertical animated blue button">
                                    <div class="hidden content">￥${dish.price}</div>
                                    <div class="visible content">
                                        <i class="shop large icon"></i>
                                    </div>
                                </div>
                                <div class="ui vertical animated green button shop-button" data-bind="${dish.shopId}">
                                    <div class="hidden content">进店铺</div>
                                    <div class="visible content">
                                        <i class="home large icon"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </#if>
    <#if haveResult==false>
        <div class="sixteen wide column">
            <h1 class="ui header">
                <div class="content">
                    抱歉，未找到任何餐厅或菜品
                </div>
            </h1>
        </div>
    </#if>
</div>

<script src="../res/js/jquery-2.0.3.min.js"></script>
<script src="../res/js/semantic.js"></script>
<script>
    $('.cards .image').dimmer({
        on: 'hover'
    });
    $('.shop-button').click(function(){
        var shopId = $(this).attr('data-bind');
        window.open("http://localhost:8080/shop/index.f1t?shopId="+shopId);
    });

    $("#keyword-field").keypress(function(event){
        if (event.which==13){
            $('#search-button').click();
        }
    });

    $('#search-button').click(function(){
        var keyword = $('#keyword-field').val();

        if (!!keyword) {
            window.location.href="http://localhost:8080/search/index.f1t?keyword="+keyword;
        } else {
            alert("请输入有效关键字进行搜索~");
        }
    });
</script>

</body>
</html>