/**
 *  created by Lihe
 */

$("document").ready(function(){
	
	
	$("#pendingOrder").click(function(event){
		$("#pendingOrderModal").removeClass("sr-only");
		
		event.preventDefault();
		
		$("#pendingOrderModal").modal({
			backdrop : false,
			keyboard : true
		});
		
		
		$.ajax({
			url : "/user/ajax/ajaxGetPendingOrders.f1t"
		}).done(function(data){
			$(".modal-body").html("");
			
			if(data.flag==2){

				$.each(data.orders, function(index, value){
					$(".modal-body").append("<p>"+value+"</p>");
				});
			}else{
				$(".modal-body").append("获取饿单快报失败...");
			}
		});
	});
});