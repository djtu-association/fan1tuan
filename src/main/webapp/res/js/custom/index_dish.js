/**
 *
 */

$(document).ready(function () {

    this.dish_AjaxGetDefault = function () {
        var url = "rank/ajax/dishRankDefault.f1t";
        var data = {};
        $.getJSON(url, data, function (json) {
            dish_createPanel(json);
        });
    };

    //dish panel change
    this.dish_AjaxChange = function (pNumber) {

        var pSize = 12;
        var accord = $('#dish_accord').val();
        var open = 1;
        var shopType = 2;
        var areaId = $('#current_areaId').val();
        var order = 1;//0：顺序，1：倒序
        //ajax url data
        var url = "rank/ajax/dishRank.f1t";
        var data = {
            "pSize": pSize,
            "pNumber": pNumber,
            "order": order,
            "open": open,
            "accord": accord,
            "shopType": shopType
        };
        //Params:pNumber,pSize,accord,order,open,areaId
        $.getJSON(url, data, function (json) {
            dish_createPanel(json);
        });
    };

    //change page result
    var dish_createPanel = function (json) {

        var content = "";
        var partial = "";
        var tdHeader = "";
        var tdFooter = "";
        var pContent = "";
        var funcAddCollect = "";
        var shopLink = "";

        //alert(json.rankDishList.length);
        var data = json.dishGeo;
        //seem to the for-in loop structure
        for (var i = 0, size = data.length; i < size; i++) {

            tdHeader = (i == 0 || (i % 4) == 0) ? "<tr><td>" : "<td>";
            tdFooter = (((i + 1) % 4) == 0 || (i + 1) == size) ? "</td></tr>" : "</td>";
            shopLink = "location='shop/index.f1t?shopId=" + data[i].content.shopId + "'";
            funcAddCollect = "addToCollectBox('dish_spn_" + i + "','1','" + data[i].content.id + "')";

            partial = tdHeader +
            "<div>" +
            "<div class='row-fluid'>" +
            "<div class='span5'>" +
            "<a title=''><img class='img-thumbnail'  title=" + data[i].content.id + " src='res/avatar/dish/"+data[i].content.image+"' alt='Generic placeholder image' style='width: 96px;height: 96px'><br></a>" +
            "<label class='label label-info'><strong>￥" + data[i].content.price + "</strong></label>" +
            "<br><span class='text-primary text-center'>销量" + data[i].content.saleVolume + "份</span>" +
            "</div>" +
            "<div class='span7'>" +
            "<small class='lead'><strong>" + data[i].content.name + "</strong></small><br>" +
            "<span class='text-info'>" +
            "<span class='glyphicon glyphicon-tag'></span>" +
            "西式,烧烤" +
            "</span>" +
            "<br>" +
            "<span class='text-warning'>" +
            "<i class='icon-rst-rating s" + parseInt(data[i].content.avgCommentLevel * 2) + "'></i><a title='评价总数'>(" + data[i].content.commentNum + ")</a>" +
            "</span>" +
            "<br>" +
            "<p>" +
            "<a class='btn btn-info ' href='javascript:void(0);' onclick=" + shopLink + " data-toggle='Enter the shop' title='进入菜品所在店铺'><span class='glyphicon glyphicon-home'></span></a>";
            if (data[i].isLike != undefined && data[i].isLike == 'true') {
                partial += "&nbsp;<a class='btn btn-warning collectTips' href='javascript:void(0)' title='已收藏' data-toggle='tooltip' data-original-title='已收藏'><span class='glyphicon glyphicon-heart text text-danger' id='dish_spn_" + i + "'></span></a>";
            } else {
                partial += "&nbsp;<a class='btn btn-danger ' href='javascript:void(0)' onclick=" + funcAddCollect + " title='收藏该菜品'><span class='glyphicon glyphicon-heart' id='dish_spn_" + i + "'></span></a>";
            }
            //partial += "&nbsp;<a class='btn btn-danger ' href='javascript:void(0)' onclick="+funcAddCollect+" title='收藏该菜品'><span class='glyphicon glyphicon-heart' id='dish_spn_"+i+"'></span></a>"+
            partial += "&nbsp;<button class='btn btn-success order_btn' title=" + data[i].content.id + "><span class='glyphicon glyphicon-cutlery'></span></button>" +
            "</p>" +
            "</div></div></div>" + tdFooter;

            content += partial;
        }
        //and then refresh the shop panel page footer
        var pLength = json.pageMap.length;
        var pNumber = json.pageMap.number;
        if (pLength == 1) {
            pContent += "<li class='previous'><a href='javascript:void(0)' class='fui-arrow-left'></a></li>";
            pContent += "<li class='active'><a href='javascript:void(0)'>1</a></li>";
            pContent += "<li class='next'><a href='javascript:void(0)' class='fui-arrow-right'></a></li>";
        } else {
            pContent += "<li class='previous'><a href='javascript:void(0)' onclick='dish_AjaxChange(" + (parseInt(i) - 1) + ");' class='fui-arrow-left'></a></li>";
            if (pNumber - 5 > 0) {
                pContent += "<li><a href='javascript:void(0)' title='前面还有哦'>..</a></li>";
            }
            for (var i = 0; i < pLength; i++) {
                if (i == pNumber) {
                    pContent += "<li class='active'><a href='javascript:void(0)'>" + (parseInt(i) + 1) + "</a></li>";
                } else {
                    //控制一次只能显示的分页按钮
                    if (i >= pNumber - 5 && i <= pNumber + 5) {
                        pContent += "<li><a href='javascript:void(0)' onclick='dish_AjaxChange(" + parseInt(i) + ");'>" + (parseInt(i) + 1) + "</a></li>";
                    }

                }
            }
            if (pLength > pNumber + 5) {
                pContent += "<li><a href='javascript:void(0)' title='后面还有哦'>..</a></li>";
            }
            if (pLength == pNumber) {
                pContent += "<li class='next'><a href='javascript:void(0)' class='fui-arrow-right'></a></li>";
            } else {
                pContent += "<li class='next'><a href='javascript:void(0)' onclick='dish_AjaxChange(" + (parseInt(i) + 1) + ");' class='fui-arrow-right'></a></li>";
            }

        }
        $('#dish_page').html(pContent);
        $('#dishMianPanel').html(content);
    };


    //when finish loading the doucment and js files,then invoke the JUST IN TIME function to create the main shop panel
    (function (global) {
        global.dish_AjaxGetDefault();
    })(this);

});