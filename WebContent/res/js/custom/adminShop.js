/**
 * Created by Administrator on 13-10-23.
 */
$(document).ready = function(){

    //-----adminShop.htnl------------
    $('.btnDel').click(function(){
        $('#delModal').modal('toggle');
    });

    function editShop(shopId)
    {
        alert("relocation by js function"+"传入商铺ID");
        window.location='adminShopEditOrAdd.html';
    }

    function checkHistoryOrder(shopId)
    {
        alert("relocation by js function"+"传入商铺ID");
        window.location='adminShopHistoryOrder.html';
    }


    //---shopHistoryOrder-------------------
    $('.shopHistoryDel').click(function(){
        $('#shopHistoryDelModal').modal('toggle');
    });

    function checkUserDetail(userid)
    {
        $('#shopHistoryUserModal').modal('toggle');
    }
}