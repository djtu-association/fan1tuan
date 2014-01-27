/**
 * 
 */
$('document').ready(function(){

    //shopping cart
    function buildDishItem(dishItem){
    	return '<div title="'+dishItem.dishId+'" class="tm-mcOrder tm-mcOrderService tm-mcOrderOne tm-mcOrderSelected">'+
                                                    '<div class="tm-mcItem"><a target="_blank" class="tm-mcPic">'+
                                                    '    <img style="padding-left:3px" height="50" src="../res/images/shop-image.jpeg"></a>'+
                                                    '</div>'+
                                                    '<div class="tm-mcSku" style="padding-left: 5px">'+
                                                    '    <p class="lead" style="font-size: 15px" title="">'+dishItem.dishName+'</p>'+
                                                    '</div>'+
                                                    '<div class="tm-mcAmount">'+
                                                    '    <a hidefocus="true" class="tm-mcMinus tm-mcMinusOff" href="javascript:void(0)"><s></s></a>'+
                                                    '    <span class="tm-mcQuantity">'+dishItem.number+'</span>'+
                                                    '    <a hidefocus="true" class="tm-mcPlus" href="javascript:void(0)"><s></s><b></b></a>'+
                                                    '</div>'+
                                                    '<div class="tm-mcCost">'+
                                                    '    <a data-tmc="del" title="删除" class="tm-mcDel"></a><br>'+
                                                    '    <strong class="tm-mcSum">'+dishItem.dishSum+'</strong>'+
                                                    '</div>'+
                                                '</div>';
    }
    
    function buildShopItem(shopItem){
    	var dishItems = shopItem.dishItems;
    	var result = "";
    	$.each(dishItems, function(index, dishItem){
    		result += buildDishItem(dishItem);
    	});
    	return '<div title="'+shopItem.shopId+'" class="tm-mcBundle tm-mcBundleB">'+
        '<div class="tm-mcBundleHeader">'+
        '<div class="tm-mcTitle"><span class="label label-info" style="font-size: 15px" title="">'+shopItem.shopName+'</span></div>'+
        '<div class="tm-mcCost"><strong class="tm-mcPrice">'+shopItem.sumPrice+'</strong></div>'+
    '</div>'+
    '<div class="tm-mcBundleList">'+
        '<div class="tm-mcMainOne" id="tmcMain0">'+
            '<div class="tm-mcMainHead">'+
                '<div class="tm-mcMainHeader">'+
                    '<span class="tm-mcMjzPromo">*元起送</span>'+
                '</div>'+
            '</div>'+
            '<div class="tm-mcMainList">'+result+
                '<div data-order="0_0" class="tm-mcService tm-mcServiceSelected"'+
                     'id="tmcOrderService0_0">'+
                    '<table>'+
                        '<tbody>'+
                        '<tr>'+
                           ' <td class="tm-mcChk">&nbsp;</td>'+
                            '<td class="tm-mcServList">'+
                             '   <i class="icon-rst-badge online-payment"></i>在线付款'+
                              '  <i class="icon-rst-badge new-restaurant"></i>新店'+
                               ' <i class="icon-rst-badge invoice"></i>发票'+
                        '</tr>'+
                        '</tbody>'+
                    '</table>'+
                '</div>'+
            '</div>'+
    '    </div>'+
   ' </div>'+
'</div>';
    }
    
    function hasShopItem(shopId, shopItems){
    	var result = undefined;
    	$.each(shopItems, function(i, v){
			if(v.shopId==shopId){
				result = v;
				return;
			}
		});
    	return result;
    }
    function hasDishItem(dishId, dishItems){
    	var result = undefined;
    	$.each(dishItems, function(i, v){
    		if(v.dishId==dishId){
				result = v;
    			return;
    		}
    	});
    	return result;
    }
    
    function calculateCartHeight(dishItemNum){
    	var cartBox = $('.tm-mcListBox');
    	var maxHeight = 580;
    	var baseHeight = 190;
    	var perScale = 58;
    	//console.log("DishItemNum:"+dishItemNum);
    	if(true){
    		var height;
    		if(dishItemNum==1){
    			height = baseHeight;
    		}else if(dishItemNum==0){
    			height = 0;
    		}else{
    			dishItemNum--;
    			height = (dishItemNum*perScale+baseHeight>maxHeight)?maxHeight:dishItemNum*perScale+baseHeight;
    			//dishItemNum++;
    		}
    		//alert(dishItemNum+"   "+height);
			$('.tm-mcListInner').height(height-5);
			cartBox.attr("style","display: block; height: "+cartBox.height()+"px; top: -"+cartBox.height()+"px;"); //去掉自动生成的overflow:hidden
    		cartBox.animate({
    			height : height,
    			top : -1*height,
    		},180, function(){
    			cartBox.attr("style","display: block; height: "+(height)+"px; top: -"+height+"px;");  //去掉自动生成的overflow:hidden
    		});
    	}
    }
    
    function refreshCart(data){
    	data = data.cart;
		var shopItems = data.shopItems;
		
		$('.tm-mcBundle').each(function(){
			var shopId = $(this).attr("title");
			var result = hasShopItem(shopId, shopItems);
			if(typeof result!='undefined'){
				var dishItems = result.dishItems;
				$(this).contents().find('.tm-mcOrder').each(function(){
					var dishId = $(this).attr("title");
					var res = hasDishItem(dishId, dishItems);
					if(typeof res!='undefined'){
						$(this).contents().find('.tm-mcQuantity').text(res.number);
						$(this).contents().find('.tm-mcSum').text(res.dishSum);
					}else{
						$(this).remove();
					}
				});
			}else{
				$(this).remove();
			}
		});
		
		$.each(shopItems,function(index, value){
			var shopItemDom = $('div[title='+value.shopId+'][class*=tm-mcBundle]');
			if(shopItemDom.html()){
				$.each(value.dishItems, function(i, v){
					var dishDom = $('div[title='+v.dishId+'][class*=tm-mcOrder]');
					if(dishDom.html()){
						dishDom.contents().find(".tm-mcQuantity").text(v.number);
						dishDom.contents().find(".tm-mcSum").text(v.dishSum);
					}else{
						var content = buildDishItem(v);
						shopItemDom.contents().find(".tm-mcMainList").prepend(content);
					}
				});
				shopItemDom.contents().find(".tm-mcPrice").text(value.sumPrice);
			}else{
				var content = buildShopItem(value);
				$(content).insertAfter('.tm-mcTop');
			}
		});
		
		$('.order_number').addClass("sr-only");
		$.each(shopItems,function(index, value){
			$.each(value.dishItems, function(i, v){
				if(v.number!=0){
					var numberDom = $('tr[title='+v.dishId+']').contents().find('.order_number');
					numberDom.removeClass("sr-only");
					numberDom.text(v.number);
				}
			});
		});
		
		$(".tm-mcCartNumTotal").text(data.itemNum+" 件");
		$('.tm-mcCartSumCost').text("       ￥"+data.price);
		
		var cartSize = $('.tm-mcOrder').size();
		//console.log("cartSize"+cartSize);
		calculateCartHeight(cartSize);
    }
    
    $('.order_btn').live("click",function(event){
    	var theButton = $(this);
    	theButton.attr("disabled","true");
    	var id = theButton.attr("title");
    	$.ajax({
    		url : "/user/ajax/secure/ajaxAddDishToCart.f1t?dishId="+id
    	}).done(function(data){
    		if(data.flag==2){
    			var cloneDom = $("img[title="+id+"]").clone();
            	cloneDom.attr("style","z-index: 1;left:"+event.clientX+"px;top:"+event.clientY+"px;position:fixed;");
            	
            	cloneDom.insertAfter("img[title="+id+"]");
            	cloneDom.animate({
            		width: [ "toggle", "swing" ],
            		height: [ "toggle", "swing" ],
            		left : ["+="+(window.innerWidth-event.clientX-200)],
        			top:["+="+(window.innerHeight-event.clientY-50), "easeOutBounce"]
            	},800,function(){
            		cloneDom.remove();
            		theButton.removeAttr("disabled");
            		refreshCart(data);
            	});   
    		}else if(data.flag==1){
    			alert("请登录");
    			theButton.removeAttr("disabled");
    		}else{
    			alert("未知错误");
    			theButton.removeAttr("disabled");
    		}
    		
    	});
    	
    });
    
    var shopping_cart_top = 0;
    $('.tm-mcHandler').live("click",function(){
    	var setTo = $(".tm-mcListBox").position().top;
    	if(setTo!=0){
    		shopping_cart_top = setTo;
    		setTo = 0;
    	}else{
    		setTo = shopping_cart_top;
    	}
    	$(".tm-mcListBox").animate({
    		top : setTo
    	},300, function(){
    		
    	});
    });
    
    
    $('.empty-cart').live("click", function(){
    	$.ajax({
    		url: "/user/ajax/secure/ajaxClearCart.f1t"
    	}).done(function(data){
    		if(data.flag==2){
    			calculateCartHeight(0);
    	    	$('.tm-mcBundle').remove();
    	    	$(".tm-mcCartNumTotal").text("0 件");
    			$('.tm-mcCartSumCost').text("       ￥0");
    			$('.order_number').addClass("sr-only");
    		}else if(data.flag==1){
    			alert("请登录");
    		}else{
    			alert("未知错误");
    		}
    	});
    });
    
    $('.tm-mcDel').live("click",function(event){
    	//event.preventDefault();
    	var dishId = $(this).parents().map(function(){
    		return this.title;
    	}).get(1);
    	
    	$.ajax({
    		url : "/user/ajax/secure/ajaxRemoveDishFromCart.f1t?dishId="+dishId
    	}).done(function(data){
    		if(data.flag==2){
        		refreshCart(data);
    		}else if(data.flag==1){
    			alert("请登录");
    		}else{
    			alert("未知错误");
    		}
    	});
    
    });
    
    //calculateCartHeight($('.tm-mcOrder').size()||0);
    $.ajax({
		url : "/user/ajax/ajaxGetShoppingCart.f1t"
	}).done(function(data){
		//calculateCartHeight(0);
		if(data.flag==2){
			refreshCart(data);  
		}
	});
   
});