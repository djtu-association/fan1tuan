/**
 * Created by Administrator on 13-10-23.
 */
var delShopId = "";
var delOrderId = "";
//-----adminShop.htnl------------
$('.btnDel').click(function(){
	delShopId = $(this).attr('id');
    $('#delModal').modal('toggle');
});

//---shopHistoryOrder-------------------
$('.shopHistoryDel').click(function(){
	//delOrderId = $(this).attr('id');
	if(confirm("是否删除该订单记录？")){
		location = "doShopOrderDelete.f1t?orderId="+$(this).attr('id')+"&shopId="+$("#shopId").val();
	}
});


function checkUserDetail(userid){
    $('#shopHistoryUserModal').modal('toggle');
}


//确定删除店铺
function confirmDeleteShop(){
	location="doShopDelete.f1t?shopId="+delShopId;
}
//确认删除订单
function confirmDeleteOrder(){
	location = "doShopOrderDelete.f1t?orderId="+delOrderId;
}
//确定删除店铺口味标签
function confirmDeleteShopTag(tagId){
	if(confirm("是否删除该店铺标签？")){
		location = "doShopTagDelete.f1t?tagId="+tagId;
	}
}
//确定删除菜品分类标签
function confirmDeleteDishTag(tagId){
	if(confirm("是否删除该菜品标签？")){
		location = "doDishTypeDelete.f1t?tagId="+tagId+"&shopId="+$("#shopId").val();
	}
}
//确认删除菜品
function confirmDeleteDish(dishId){
	if(confirm("是否删除该菜品？")){
		location = "doDishDelete.f1t?dishId="+dishId+"&shopId="+$("#shopId").val();
	}
}