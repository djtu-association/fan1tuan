/**
 *  by Li He
 */

$("document").ready(function(){
	/*
     * 侧边栏效果！！！
     */
    function removeMask(){

        $('.rst-drawer-wrapper').animate({
            left: -400
        });
        $('.rst-mask').animate({
            opacity: 0
        }, 250,function(){
            $('.rst-mask').attr('style','display: none;');
            $('.rst-drawer').empty();
        });

    }
    
    $('.dish_item').click(function(){
        //var name = $(this).html();

        var id = $(this).attr("title");

        $('.rst-mask').attr('style','display: block; opacity:0');
        $('.rst-mask').animate({
            opacity: 1
        }, 250);
        $('.rst-drawer-wrapper').animate({
            left: 0
        });
        $.ajax({
            url: "./ajax/ajaxGetDishInfo.f1t?dishId="+id+"&pageSize=10&pageNumber=0"
        }).done(function ( data ) {
            $('.rst-drawer').append(data);  
        });
    });

    $('#rst_cmt_close').live("click", function(){
    	removeMask();
    });
    $('.rst-mask').click(function(){
       removeMask();
    });


});