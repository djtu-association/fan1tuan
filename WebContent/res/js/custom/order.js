/**
 * Created by Lihe on 13-11-4.
 */
$('document').ready(function(){
	
	
	
    $(".tagsinput").tagsInput();

    $('.tagsinput').tooltip({
        placement:"top",
        trigger:"hover",
        title:"在+号后输入tag，按回车增加tag，描述你对美食的口味要求"
    });


    $("select").selectpicker({style: 'btn btn-primary', menuStyle: 'dropdown-inverse'});
    //处理modal对话框的遮挡导航栏问题，bug解除
    $("#newAddressBtn").click(function(){
    	$("#newAddressModal").removeClass("sr-only");
    });
    
    //添加一个新地址
    $(".add-address-btn").live("click",function(event){
    	var me = this;
    	$(me).attr("disabled", true);
    	$(me).text("添加中...");
    	$.ajax({
    		url : "/user/ajax/secure/ajaxAddUserAddress.f1t",
    		data : {
    			cellphone : $("input[type=text][name=cellphone]").val(),
    			receiver : $("input[type=text][name=receiver]").val(),
    			detailAddress : $("input[type=text][name=detailAddress]").val()
    		}
    	}).done(function(data){
    		if(data.flag==2){
    			$(me).removeAttr("disabled");
    	    	$(me).text("添加地址");
    			$("#newAddressModal .close").trigger("click");
    		    getUserAddresses();
    		    
    		}else{
    			alert("添加失败...");
    			$(me).removeAttr("disabled");
    	    	$(me).text("添加地址");
    		}
    	});
    	
    	
    });
    	
    
    //动态获取用户地址
    getUserAddresses();
    
    //处理地址的tr标签
    function dealUserAddress(address){
    	return '<tr>\
                        <td>\
                            <label class="radio" style="font-size: 18px">\
                                <input class="address" type="radio" name="address" value="'+address.detailAddress+'|'+address.receiver+'|'+address.cellphone+'" data-toggle="radio">\
                                <span class="detailAddress">'+address.detailAddress+'</span>\
                                <span class="text-muted receiver"><strong>( '+address.receiver+' 收 )</strong></span>\
                                <span class="text-info cellphone"><strong>'+address.cellphone+'</strong></span>\
                            </label>\
                        </td>\
                    </tr>';
    }
    //把获取用户地址封装为一个function
    function getUserAddresses(){
    	$.ajax({
        	url:"/user/ajax/ajaxGetUserAddresses.f1t"
        }).done(function(data){
        	if(data.flag==2){
        		var addresses = data.addresses;
				$(".address-table").html("");
    			$.each(addresses, function(index, value){
    				$(".address-table").append(dealUserAddress(value));
    			});
        	}else if(data.flag==0){
    			$(".address-table").html("");
    			$(".address-table").append("<center><h4>没有地址可以显示</h4></center>");

        	}
        });
    }
    
    
    /*
     * 订单功能部分-----以下
     */
    $(".subtract-dish-btn").click(function(){
    	var me = this;
    	var dishNum = $(me).next().val()-1;
    	if(dishNum<1){
    		dishNum=1;
    	}
    	$(me).next().val(dishNum);
    	
    	updateOrder($(me).next());
    });
    
    $(".add-dish-btn").click(function(){
    	var me = this;
    	var dishNum = parseInt($(me).prev().val())+1;
    	if(dishNum>99){
    		dishNum=99;
    	}
    	$(me).prev().val(dishNum);
    	
    	updateOrder($(me).prev());

    });
    
    $(".dish-number").change(function(){
    	var me = this;
    	    	
    	var inputValue = parseInt($(this).val());
    	if(inputValue){
    		if(inputValue<1) $(me).val(1);
    		else if(inputValue>99) $(me).val(99);
    	}else {
    		$(me).val(1);
    	}
    	
    	updateOrder($(me));

    });
    
    $(".dish-number").keypress(function(event){ 
    	
       	if(event.which!=0 && event.which!=8 && (event.which<48||event.which>57)){
    		event.preventDefault();
    	}
       	
    });
    
    function updateOrder(input){
    	var trNode = input.parents().closest("tr");
    	var dishPrice = trNode.contents().find(".dish-price");
    	var dishSum = trNode.contents().find(".dish-sum");
    	var shopSum = input.parents().closest(".row-fluid").next().contents().find(".shop-sum");
    	    	
    	var originSum = shopSum.text()-dishSum.text();
    	
    	dishSum.text(dishPrice.text()*input.val());
    	
    	shopSum.text(parseInt(originSum)+parseInt(dishSum.text()));
    	
    	var shopSums = $(".shop-sum");
    	var dishNumbers = $(".dish-number");
    	
    	var allSum = 0;
    	var allNumber = 0;
    	$.each(shopSums, function(index, value){
    		allSum+=parseInt($(value).text());
    	});
    	$.each(dishNumbers, function(index, value){
    		allNumber+=parseInt($(value).val());
    	});
    	
    	$(".all-sum").text(allSum);
    	$(".all-number").text(allNumber);
    }
    
    
    //submit order!!!核心逻辑处理
    $(".submit-order").click(function(event){
    	event.preventDefault();
    	
    	var checkedAddress = $("input[name=address][checked=checked]").val();
    	if(!checkedAddress){
    		alert("选择至少一个地址！");
    		return;
    	}
    	var addressParts = checkedAddress.split("|");
    	var detailAddress = addressParts[0];
    	var receiver = addressParts[1];
    	var cellphone = addressParts[2];
    	
    	
    	var chargeType = $("#chargeType").val();
    	var deliveryTime = $("#deliveryTime").val();
    	
    	var shopItems = $(".shopItem");
    	
    	var shopinfos = [];
    	
    	$.each(shopItems, function(index, value){
    		var shopId = $(value).attr("data-title");
    		var userRemark = $(value).contents().find(".tagsinput").val();
    		
    		shopinfos[index] = shopId+"|"+userRemark;
    		
    		var dishItems = $(value).contents().find(".dishItem");
    		$.each(dishItems, function(i, v){
    			var dishId = $(v).attr("data-title");
    			var dishNumber =  $(v).contents().find(".dish-number").val();
    			
    			shopinfos[index] += "|"+dishId+":"+dishNumber;
    		});
    		
    	});

    	//console.log(detailAddress+"\n"+cellphone+"\n"+receiver+"\n"+chargeType+"\n"+deliveryTime+"\n"+shopinfos);
    	var url = "/user/ajax/secure/ajaxSubmitOrder.f1t?";
    	$.each(shopinfos, function(index, value){
    		url += "shopInfo="+value+"&";
    	});
    	
    	url += "detailAddress="+detailAddress+"&";
    	url += "cellphone="+cellphone+"&";
    	url += "receiver="+receiver+"&";
    	url += "chargeType="+chargeType+"&";
    	url += "deliveryTime="+deliveryTime+"&";

    	$.ajax({
    		url : url
    	}).done(function(data){
    		if(data.flag==2){
    			alert("确认订单成功！");
    		}else if(data.flag==1){
    			alert("请登录！");
    		}else{
    			alert("确认订单失败！");
    		}
    	});
    });
});



