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
    
    $("#newAddressBtn").click(function(){
    	$("#newAddressModal").removeClass("sr-only");
    });
    
    	
   
    
    this.order_numberAdd = function(num){
    	//$('#button_'+num).attr("disabled","false");
    	var dishPrice = ($('#dishPrice_'+num).text().split('￥'))[1];//
    	var dishNum = $('#dishNum_'+num).val();
    	var dishSum = ($('#dishSum_'+num).text().split('￥'))[1];
    	var dishNumInt = parseInt(dishNum)+1;
    	if(dishNumInt<99){
    		$('#dishNum_'+num).val(dishNumInt.toString());
        	
        	var sumPriceInt = parseInt(dishSum)+parseInt(dishPrice);
        	
        	$('#dishSum_'+num).text('￥'+sumPriceInt.toString());
        	var pre = (num.split('_'))[0];
        	var shopSum =($('#shopSum_'+pre).text().split('￥'))[1];
        	var shopSumInt = parseInt(shopSum)+parseInt(dishPrice);
        	$('#shopSum_'+pre).text('￥'+shopSumInt.toString());
        	var finPrice = ($('#finalPrice').text().split('￥'))[1];
        	var finPriceInt =parseInt(finPrice)+parseInt(dishPrice);
        	$('#finalPrice').text('￥'+finPriceInt.toString());
    	}
    	else
    		$('#dishNum_'+num).val('99');
    		
    	
    };
    
    this.order_numberDec = function(num){
    	var dishPrice = ($('#dishPrice_'+num).text().split('￥'))[1];
    	var dishNum = $('#dishNum_'+num).val();
    	var dishSum = ($('#dishSum_'+num).text().split('￥'))[1];
    	var dishNumInt = parseInt(dishNum)-1;
    	if(dishNumInt>1)
    	{
    		$('#dishNum_'+num).val(dishNumInt.toString());
    		var sumPriceInt = dishNumInt*parseInt(dishPrice);
        	$('#dishSum_'+num).text('￥'+sumPriceInt.toString());
        	var pre = (num.split('_'))[0];
        	var shopSum =($('#shopSum_'+pre).text().split('￥'))[1];
        	var shopSumInt = parseInt(shopSum)-parseInt(dishPrice);
        	$('#shopSum_'+pre).text('￥'+shopSumInt.toString());
        	var finPrice = ($('#finalPrice').text().split('￥'))[1];
        	var finPriceInt =parseInt(finPrice)-parseInt(dishPrice);
        	$('#finalPrice').text('￥'+finPriceInt.toString());
        	
    	}
    	else 
    		{
    		$('#dishNum_'+num).val("1");
    		dishNumInt = 1;
    		//$('#button_'+num).attr("disabled","true");
    		}
    	
    	
    	
    };
    
    this.order_delDishItem = function(num){
    	//alert(num);
    	
    	var dishSum = ($('#dishSum_'+num).text().split('￥'))[1];
    	var pre = (num.split('_'))[0];
    	var shopSum =($('#shopSum_'+pre).text().split('￥'))[1];
    	var shopSumInt = parseInt(shopSum)-parseInt(dishSum);
    	//alert(shopSumInt);
    	$('#shopSum_'+pre).text('￥'+shopSumInt.toString());
    	$('#row_'+num).remove();
    	
    	
        
    };
    
    this.orderSubmit = function(){
    	$('#shopOrder').submit();
    	
    };

    
});



function addOneDishNum(cell){
	alert(cell.parent().next().html());
	var idcell =cell.nextNode.id;
	alert(idcell);
	var row = cell.parentNode.parentNode;
    
	
}
function decOneDishNum(){}
function deleteDishItem(){}
function getSumPrice(){
	var dishNum=$('#dishNum').html();
	alert(dishNum);
    var dishPrice=$('#dishPrice').html();
    var sumPrice = dishNum*dishPrice;
    $('#sumPrice').html(sumPrice);
}
