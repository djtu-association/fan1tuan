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
$("#saveUserInfoButton").click(function () {
    var password = $("#password").val(),
        newPassword = $("#newPassword").val(),
        newPasswordAgain = $("#newPasswordAgain").val();
    if (newPassword && newPasswordAgain && password) {
        if (newPassword == newPasswordAgain) {
            //logic put here
            alert("success!");


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
$("#saveShopInfoButton").click(function (event) {
    event.preventDefault();
    var postData = $("#shopForm").serialize();

    alert(postData);
});

// add dish taste tag
$("#newDishTasteTagButton").click(function () {
    var form = $("#newDishTasteTagForm"),
        postData = form.serialize();

    alert(postData);

    $("#dishTasteModal").find("button[data-dismiss='modal']").click();
    form.find("input").val("");
    form.find("textarea").val("");
});

// edit dish taste tag
$('#dishTasteInfo').find('.dish-taste-tag-edit-btn').click(function () {
    var form = $("#editDishTasteTagForm");

});

$("#editDishTasteTagButton").click(function () {
    var form = $("#editDishTasteTagForm"),
        postData = form.serialize();

    alert(postData);

    $("#editDishTasteModal").find("button[data-dismiss='modal']").click();
    form.find("input").val("");
    form.find("textarea").val("");
});

// remove dish taste tag
$('#dishTasteInfo').find('.dish-taste-tag-remove-btn').click(function () {
    var form = $("#editDishTasteTagForm");

    alert("remove");
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