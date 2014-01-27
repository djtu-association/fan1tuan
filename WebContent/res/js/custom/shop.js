/**
 * Created by Lihe on 13-10-29.
 */

$('document').ready(function(){

    var content = $('#starDiagram').html();
    var dishTagListContent = $('#dish_popover_list').html();
    var shopId = $(".shop-title").attr("title");

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

    $('.meal-category-btn').popover({
        "placement" : 'bottom',
        "trigger" : 'click',
        //"container" :'#shopPopoverCotainer',
        "html":true,
        "content" : dishTagListContent
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

    
    //菜品列表的hover效果
    $('.dish_body_list_item').mouseenter(function(){
    	$(this).contents().find('.heart').removeClass('sr-only');
    });
    $('.dish_body_list_item').mouseleave(function(){
    	var heart = $(this).contents().find('.heart');
    	if(!heart.attr("data-cache")){
        	heart.addClass('sr-only');
    	}
    });
    
    //滚动效果
    $('.cate_name').live('click',function(event){
    	
    	//收起美食列表
    	var itemParent = $(this).parents().closest(".popover");
    	
    	if(itemParent){
    		itemParent.prev().trigger('click');
    	}
    	
    	
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
    
    //收藏菜品与店铺！！！！！
    $(".favor-shop-btn").click(function(event){
    	var me = this;
    	$(me).attr("disabled",true);
    	if($(me).attr("data-cache")){
    		//取消收藏
    		$.ajax({
    			url : "/user/ajax/secure/ajaxRemoveFavoriteShop.f1t?shopId="+shopId
    		}).done(function(data){
    			if(data.flag==2){
    				$(me).removeAttr("data-cache");
    	    		$(me).removeClass("btn-danger");
    	    		$(me).addClass("btn-info");
    	    		$(me).html('<i class="glyphicon fui-heart"></i> 收藏');
    	    		$(me).removeAttr("disabled");
    			}else if(data.flag==1){
    				alert("请登录！！！");
    	    		$(me).removeAttr("disabled");
    			}else{
    				alert("未知错误！！！");
    	    		$(me).removeAttr("disabled");
    			}
    		});
    	}else{
    		//收藏店铺
    		$.ajax({
    			url : "/user/ajax/secure/ajaxAddFavoriteShop.f1t?shopId="+shopId
    		}).done(function(data){
    			if(data.flag==2){
    				$(me).attr("data-cache",true);
    	    		$(me).removeClass("btn-info");
    	    		$(me).addClass("btn-danger");
    	    		$(me).html('<i class="glyphicon fui-heart"></i> 已收藏');
    	    		$(me).removeAttr("disabled");
    			}else if(data.flag==1){
    				alert("请登录！！！");
    	    		$(me).removeAttr("disabled");
    			}else{
    				alert("未知错误！！！");
    	    		$(me).removeAttr("disabled");
    			}
    		});
    	}
    });
    
    $(".heart").click(function(event){
    	var me = this;
    	event.preventDefault();
    	var id = $(this).parent().closest(".dish_body_list_item").attr("title");
    	if($(this).attr("data-cache")){
    		//取消收藏菜品
    		$.ajax({
    			url : "/user/ajax/secure/ajaxRemoveFavoriteDish.f1t?dishId="+id
    		}).done(function(data){
				
    			if(data.flag==2){
    				$(me).removeAttr("data-cache");
    	    		$(me).removeClass("glyphicon-heart");
    	    		$(me).addClass("glyphicon-heart-empty");
    			}else if(data.flag==1){
    				alert("请登录！！！");
    			}else{
    				alert("未知错误！！！");
    			}
    		});
    		
    	}else{
    		//收藏菜品
    		$.ajax({
    			url : "/user/ajax/secure/ajaxAddFavoriteDish.f1t?dishId="+id
    		}).done(function(data){
    			if(data.flag==2){
    				$(me).attr("data-cache",true);
    	        	$(me).removeClass("glyphicon-heart-empty");
    	    		$(me).addClass("glyphicon-heart");
    			}else if(data.flag==1){
    				alert("请登录！！！");
    			}else{
    				alert("未知错误！！！");
    			}
    		});
        	
    	}
    });
    
    //页面载入时刷新菜品和店铺的登陆状态
    $.ajax({
    	url:"/user/ajax/ajaxGetFavoriteDishesInShop.f1t?shopId="+shopId
    }).done(function(data){
    	if(data.flag==2){
    		var dishes = data.dishes;
    		
    		$.each(dishes, function(index, dishItem){
    			var heart = $("tr[title="+dishItem.id+"][class=dish_body_list_item]").contents().find('.heart');
    			if(heart){
    				heart.attr("data-cache",true);
    				heart.removeClass("glyphicon-heart-empty");
    				heart.addClass("glyphicon-heart");
    				heart.removeClass("sr-only");
    			}
    		});
    	}
    });
    
});