/**
 * Created by Administrator on 13-10-23.
 */
var delShopId = "";
//-----adminShop.htnl------------
$('.btnDel').click(function(){
	delShopId = $(this).attr('id');
    $('#delModal').modal('toggle');
});

//---shopHistoryOrder-------------------
$('.shopHistoryDel').click(function(){
    $('#shopHistoryDelModal').modal('toggle');
});

function checkUserDetail(userid){
    $('#shopHistoryUserModal').modal('toggle');
}

function confirmDeleteShop(){
	alert(delShopId);
	location="doShopDelete.f1t?shopId="+delShopId;
}