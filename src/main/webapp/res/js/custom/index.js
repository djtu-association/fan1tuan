/**
 * Created by apple on 13-10-22.
 */
//页面效果-----------------------------------------------
$("select").selectpicker({style: 'btn btn-primary', menuStyle: 'dropdown-inverse'});

$('document').ready(function () {

    //--------------局部变量-----------------------------------
    //var weekStar = $('#weekStar');
    var shopRank = $('#shopRank');
    var dishRank = $('#dishRank');
    //var navWeekStar = $('#navWeekStar');
    var navShopRank = $('#navShopRank');
    var navDishRank = $('#navDishRank');
    var onlineArray = [dishRank, shopRank];
    var onlineNames = [navDishRank, navShopRank];
    var onlineIndex = 0;
    var collectedTips = "<p>已收藏</p>";


    navShopRank.click(function () {
        if (onlineIndex == 0) {
            onlineArray[onlineIndex].fadeOut(200, function () {
                onlineNames[onlineIndex].toggleClass('active');
                onlineIndex++;
                onlineNames[onlineIndex].toggleClass('active');

                onlineArray[onlineIndex].fadeIn(100, function () {
                });
            });
        }
    });
    navDishRank.click(function () {
        if (onlineIndex == 1) {
            onlineArray[onlineIndex].fadeOut(200, function () {
                onlineNames[onlineIndex].toggleClass('active');
                onlineIndex--;
                onlineNames[onlineIndex].toggleClass('active');

                onlineArray[onlineIndex].fadeIn(100, function () {
                });
            });
        }

    });

    //在线订餐导航条------------------------------------

    //重新选择地点
    $('#resetArea').popover({
        "trigger": "hover",
        "html": true,
        "content": "<h5><label class='label label-info'>重新选择商圈</label></h5>",
        "placement": "right"

    });

    $('.toOnline').click(function () {
        $.scrollTo('#onlineOrder', 800);
    });

    $('.toPhone').click(function () {
        $.scrollTo('#phoneCallOrder', 800);
    });

    $('.toTop').click(function () {
        $.scrollTo('.topPage', 800);
    });


    $('#myCarousel').carousel();

    //pin part
    $('.onlinePin').pin({
        containerSelector: "#onlinePart"
    });

    $('.phoneCallPin').pin({
        containerSelector: "#phoneCallPart"
    });

    $('#weekStarTrigger').pin({
        containerSelector: "#onlinePart"
    });

    $('#rankNavButtonGroup').pin({
        containerSelector: "#rankPart"
    });




    //------------------------------common part--------------------------------------

    //注销登录
    $('#logout').click(function () {

        var url = "signout.f1t";
        var data = {};
        $.getJSON(url, data, function (json) {
            if (json.logoutFlag == "success") {
                location = 'signup.f1t';//跳转到登录页面
            }
        });
    });


    /**
     * 添加到收藏（点击收藏按钮）
     * target是按钮的子元素〈span〉的ID
     * type:0是店铺收藏，1是菜品收藏
     * id是店铺/菜品ID
     */
    this.addToCollectBox = function (target, type, id) {

        var obj = $('#' + target);//obj是<span>
        var objParent = obj.parent();//objParent则是<a>

        //下面判断，按钮是否已经是"已收藏"，如果是则跳过跳出
        var attrArr = (objParent.attr("class")).split(" ");
        for (var i = 0; i < attrArr.length; i++) {
            if (attrArr[i] == "collectTips") {//collectTips控制收藏按钮的现实和可用
                return;
            }
        }

        //Ajax url,data
        var url = (0 == type) ? "user/ajax/secure/ajaxAddFavoriteShop.f1t" : "user/ajax/secure/ajaxAddFavoriteDish.f1t";
        var data = (0 == type) ? {"shopId": id, "type": type} : {"dishId": id, "type": type};
        //Ajax request
        htmlobj = $.ajax({
            url: url,
            data: data,
            success: function (data) {
                if(data.flag==2){
                    //success修改btn的属性，spn的属性
                    obj.addClass("text text-danger");
                    objParent.removeClass();
                    objParent.addClass("btn btn-warning collectTips");
                    objParent.attr("data-toggle", "tooltip");
                    objParent.attr("title", "已收藏");
                    objParent.tooltip("show");
                }else if(data.flag==1){
                    $("#signinModalBtn").trigger("click");
                    objParent.removeAttr("disabled");
                }else{
                    alert("未知错误！！！");
                    objParent.removeAttr("disabled");
                }

            }
        });
    };

    //点击收藏的popover函数
    $('.collectTips').tooltip("show");


    /**
     * accord(人气，排行，评分)在页面隐藏域的值
     */
    this.index_ChangeHiddenAccord = function (type, value) {
        if (type == 1) {
            $('#shop_accord').val(value);
        }
        else if (type == 2) {
            $('#dish_accord').val(value);
        } else {
            $('#call_accord').val(value);
        }
    };

    /**
     * taste(店铺，菜品，电话订餐)口味，隐藏域的值
     */
    this.index_ChangeHiddenSelTaste = function (obj, type) {
        if (type == 1) {
            $('#shop_taste').val(obj.value);
        }
        else if (type == 2) {
            $('#dish_taste').val(obj.value);
        } else {
            $('#call_taste').val(obj.value);
        }
    };


});



	