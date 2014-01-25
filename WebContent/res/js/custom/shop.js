/**
 * Created by Lihe on 13-10-29.
 */

$('document').ready(function(){

    var content = $('#starDiagram').html();

    /*
     * popover效果
     */
    $('#shopPopover').popover({
        "placement" : 'bottom',
        "trigger" : 'hover',
        //"container" :'#shopPopoverCotainer',
        "html":true,
        "content" : content
    });


    /*
     * pin效果
     */
    $('.panel-heading').pin({
        containerSelector: ".panel"
        //activeClass: "rst-menu-toolbar"
    });
    
    $('.fixed_right').pin({
        //activeClass: "rst-menu-toolbar"
    });
    
    
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
        var name = $(this).html();

        var id = $(this).attr("title");

        $('.rst-mask').attr('style','display: block; opacity:0');
        $('.rst-mask').animate({
            opacity: 1
        }, 250);
        $('.rst-drawer-wrapper').animate({
            left: 0
        });
        $.ajax({
            url: "./ajax_get_dish_info.f1t?dishId="+id+"&pageSize=10&pageNumber=0"
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

    
    
    $('.dish_body_list_item').mouseenter(function(){
    	$(this).contents().find('.heart').removeClass('sr-only');
    });
    $('.dish_body_list_item').mouseleave(function(){
    	$(this).contents().find('.heart').addClass('sr-only');
    });
    
    
    $('.cate_name').click(function(event){
    	var id = $(this).attr("title").toString().trim();
    	//alert(id);
    	$.scrollTo('#'+id, 800);
    	return false;
    });
    
    $('a[href=#top]').click(function(event){
    	$.scrollTo('#top', 800);
    	return false;
    });
    
    
    //map
    var map_outter = $('#map_out_body');
    map_outter.children().css("width",map_outter.width());
    
    $(window).resize(function() {
    	var map_outter = $('#map_out_body');
        map_outter.children().css("width",map_outter.width());
    });
    
    
     
});