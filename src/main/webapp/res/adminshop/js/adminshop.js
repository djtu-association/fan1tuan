//控制左侧栏
$("#primary-sidebar").find("li").click(function (event) {
    //event.preventDefault();
    $("#primary-sidebar").find("li").removeClass("active");
    $(this).addClass("active");

    var id = $(this).attr("id").substring(0, $(this).attr("id").indexOf("-"));

    $("#primary-view").find("> div").hide();
    $("#"+id).show();
});

var hash = window.location.hash;
if(hash.length>1) {
    hash = hash.substring(1);
    $("#primary-sidebar").find("li[id='"+hash+"-btn']").click();
}

// change password
$("#saveUserInfoButton").click(function (event) {
    event.preventDefault();

    var password = $("#password").val(),
        newPassword = $("#newPassword").val(),
        newPasswordAgain = $("#newPasswordAgain").val();
    if (newPassword && newPasswordAgain && password) {
        if (newPassword == newPasswordAgain) {
            //logic put here
            $.getJSON("/admin/shop/changePassword.f1t?password="+password+"&newPassword="+newPassword, function(data){
                 if(data.flag==2) {
                     alert("修改密码成功！")
                 } else {
                     alert("修改密码失败，用户密码错误！")
                 }
            });

            $("#password").val("");
            $("#newPassword").val("");
            $("#newPasswordAgain").val("");
        } else {
            alert("新密码与确认新密码不相同，请核实后提交");
        }
    } else {
        alert("任何项不可为空");
    }
});

// save shop info
$("#shopForm").submit(function(){
    alert("店铺信息已成功提交，需要刷新页面以继续...");
});
$("#saveShopInfoButton").click(function (event) {
    //event.preventDefault();
    //var postData = $("#shopForm").serialize();
    //
    //$.getJSON();
    //
    //alert(postData);
});

// add dish taste tag
$("#newDishTasteTagButton").click(function () {
    var form = $("#newDishTasteTagForm");

    $("#dishTasteModal").find("button[data-dismiss='modal']").click();

    form.submit();
});

// edit dish taste tag
$('#dishTasteInfo').find('.dish-taste-tag-edit-btn').click(function () {
    var form = $("#editDishTasteTagForm"),
        modal = $("#editDishTasteModal");

    var multiTds = $(this).closest('tr').find('td');

    form.find("input[name='id']").val($(multiTds[0]).text());
    form.find("input[name='name']").val($(multiTds[1]).text());
    form.find("textarea[name='description']").val($(multiTds[2]).text());

    modal.modal();
});

$("#editDishTasteTagButton").click(function () {
    var form = $("#editDishTasteTagForm");


    $('#editDishTasteModal').find("button[data-dismiss='modal']").click();

    form.submit();
});



// remove dish taste tag
$('#dishTasteInfo').find('.dish-taste-tag-remove-btn').click(function () {
    var dishTasteTagId = $(this).attr("data-bind");

    $.getJSON("/admin/shop/removeDishTasteTag.f1t?dishTasteTagId="+dishTasteTagId, function () {
        window.location.reload(true);
    });
});


//add dish
$("#newDishButton").click(function () {

    $('#newDishModal').find("button[data-dismiss='modal']").click();

    $("#newDishForm").submit();
});

$("#dishInfo").find(".edit-dish-btn").click(function(){
    var dishId = $(this).attr("data-bind");

    $.getJSON("/admin/shop/fetchDish.f1t?dishId="+dishId, function(data){
        var dish = data.dish;

        var form = $("#editDishForm");

        form.find("input[name='id']").val(dish.id);
        form.find("input[name='name']").val(dish.name);
        form.find("select[name='dishTasteTagId']").val(dish.dishTasteTagId);
        form.find("input[name='originPrice']").val(dish.originPrice);
        form.find("input[name='price']").val(dish.price);
        form.find("input[name='status'][value='"+dish.status+"']").attr("checked", "");
        form.find("textarea[name='description']").text(dish.description);

    });

    $("#editDishModal").modal();
});

$("#editDishButton").click(function(){
    $('#editDishModal').find("button[data-dismiss='modal']").click();

    $("#editDishForm").submit();
});

// 查看订单
$('button[data-target="#viewOrderModal"]').click(function(event){
    event.preventDefault();
    var orderId = $(this).attr("data-bind");
    $.getJSON("/admin/shop/fetchOrder.f1t?orderId="+orderId, function (data){
        if (data.order) {
            var order = data.order;
            var form = $("#viewOrderForm");
            var modal = $("#viewOrderModal");
            form.find("p[data-bind='orderNo']").text(order.orderNo);
            form.find("p[data-bind='price']").text("￥"+order.price);
            form.find("p[data-bind='address']").text(order.address);
            form.find("p[data-bind='receiver']").text(order.receiver);
            form.find("p[data-bind='cellphone']").text(order.cellphone);
            form.find("p[data-bind='description']").text(order.description);
            form.find("p[data-bind='userRemark']").text(order.userRemark);
            modal.find("table[data-bind='dishItems']").empty();

            for(var index in order.dishItems) {
                var dishItem = order.dishItems[index];
                modal.find("table[data-bind='dishItems']").append(['<tr>',
                    '<td>'+dishItem.dishName+'</td>',
                    '<td>￥'+dishItem.dishPrice+'</td>',
                    '<td>'+dishItem.number+'份</td>',
                    '<td class="text-success"><b>￥'+dishItem.dishSum+'</b></td>',
                '</tr>'].join(""));
            }
        }
        modal.modal();
    });

});

$(".update-order").click(function(){
    var orderId = $(this).attr("data-bind");

    $.get("/admin/shop/updateOrder.f1t?orderId="+orderId, function() {
        location.reload(true);
    })
});

$(".decline-order").click(function(){
    var orderId = $(this).attr("data-bind");

    $.get("/admin/shop/declineOrder.f1t?orderId="+orderId, function() {
        location.reload(true);
    })
});