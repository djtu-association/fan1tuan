/**
 *  created by Lihe
 */

$("document").ready(function(){
	
	
	$("#pendingOrder").click(function(event){
		event.preventDefault();

		
		$.ajax({
			url : "/user/ajax/ajaxGetPendingOrders.f1t"
		}).done(function(data){
			$("#pendingOrderModal .modal-body").html("");
			$("#pendingOrderModal .modal-body").append(data);

			$("#fan1tuanModal").empty();
	    	
	    	$("#fan1tuanModal").append($("#pendingOrderModal").html());
	    	
	    	$("#fan1tuanModal").removeClass("sr-only");
			
			
			$("#fan1tuanModal").modal({
				backdrop : true,
				keyboard : true
			});
			
			$("body").removeClass("modal-open");
			
			
//			if(data.flag==2){
//
//				
//			}else{
//				$(".modal-body").append("获取饿单快报失败...");
//			}
		});
	});
});