$(document).ready(function(){
	
	$('.btn-confirm').toggle(function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var btnRej = $('#'+'btnRej_'+$(this).attr('id'));
		var data = {"status":2,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-info");
    	    	label.html("等待领取");
    	    	btn.removeClass();
    	    	btn.addClass("btn btn-info btn-sm btn-fetch");
    	    	btn.html("确认领取");
    	    	btnRej.remove();
    		}
		});
	},function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var data = {"status":3,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-success");
    	    	label.html("等待送达");
    	    	btn.removeClass();
    	    	btn.addClass("btn btn-success btn-sm btn-complete");
    	    	btn.html("确认送达");
    		}
		});
	},function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var data = {"status":4,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-danger");
    	    	label.html("订单完成");
    	    	label.after("<span class='glyphicon glyphicon-ok'></span>");
    	    	btn.replaceWith("<label class='label label-danger'>订单完成</label><span class='glyphicon glyphicon-ok'></span>");
    		}
		});
	});
	$('.btn-fetch').toggle(function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var data = {"status":3,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-success");
    	    	label.html("等待送达");
    	    	btn.removeClass();
    	    	btn.addClass("btn btn-success btn-sm btn-complete");
    	    	btn.html("确认送达");
    		}
		});
	},function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var data = {"status":4,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-danger");
    	    	label.html("订单完成");
    	    	label.after("<span class='glyphicon glyphicon-ok'></span>");
    	    	btn.replaceWith("<label class='label label-danger'>订单完成</label><span class='glyphicon glyphicon-ok'></span>");
    		}
		});
	});
	$('.btn-complete').click(function(){
		var label = $('#'+'lbl_'+$(this).attr('id'));
		var btn = $(this);
		var data = {"status":4,"orderId":$(this).attr('id')};
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-danger");
    	    	label.html("订单完成");
    	    	label.after("<span class='glyphicon glyphicon-ok'></span>");
    	    	btn.replaceWith("<label class='label label-danger'>订单完成</label><span class='glyphicon glyphicon-ok'></span>");
    		}
		});
	});
	//拒绝
	$('.btn-reject').click(function(){
		var orderId = $(this).attr('id').substring(7);
		var label = $('#'+'lbl_'+orderId);
		var btn_confirm = $('#'+orderId);
		var data = {"orderId":orderId};
		var btn = $(this);
		htmlobj=$.ajax({
    		url:"doCheckStatus.f1t",
    		data:data,
    		success:function(){
    			label.removeClass();
    	    	label.addClass("label label-danger");
    	    	label.html("已拒绝");
    	    	label.after("<span class='glyphicon glyphicon-remove'></span>");
    	    	btn.replaceWith("<label class='label label-danger'>已拒绝</label><span class='glyphicon glyphicon-remove'></span>");
    	    	btn_confirm.remove();
    		}
		});
	});
	
	
});