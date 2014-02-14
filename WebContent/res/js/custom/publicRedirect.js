/**
 * Created by Lihe on 14-1-28.
 */

$('document').ready(function(){
	$(".need-redirect").each(function(index,item){
		var currentUrl = encodeURIComponent(window.location.href);
		var goUrl = $(item).attr("onclick");
		$(item).attr("onclick",goUrl.substring(0,goUrl.length-1)+"?redirect="+currentUrl+"'");
	});
	
	/**
	 * login modal here
	 */
	
	$("#signinModalBtn").click(function(event){
		event.preventDefault();
		
		$("#fan1tuanModal").empty();
    	
    	$("#fan1tuanModal").append($("#signinModal").html());
    	
    	$("#fan1tuanModal").removeClass("sr-only");
				
		$("#fan1tuanModal").modal({
			backdrop : true,
			keyboard : true
		});
		
		$("body").removeClass("modal-open");
		
		
	});
	
	$("#fan1tuanModal .signin-btn").live("click",function(event){
		var me = this;
		
		event.preventDefault();
		
		$("#fan1tuanModal input[name=cellphone]").parents().closest(".form-group").removeClass("has-error");
		$("#fan1tuanModal input[name=password]").parents().closest(".form-group").removeClass("has-error");
		
		var cellphone = $("#fan1tuanModal input[name=cellphone]").val();
		var password = $("#fan1tuanModal input[name=password]").val();
		var isCookie = $("#fan1tuanModal input[name=isCookie]").val();
		if(isCookie=="1"){
			isCookie = "set";
		}else{
			isCookie = "";
		}
		var warningFlag = 0;
		if(!cellphone || cellphone.trim()==""){
			$("#fan1tuanModal input[name=cellphone]").parents().closest(".form-group").addClass("has-warning");
			warningFlag = 1;
		}else{
			$("#fan1tuanModal input[name=cellphone]").parents().closest(".form-group").removeClass("has-warning");
		}
		if(!password || password.trim()==""){
			$("#fan1tuanModal input[name=password]").parents().closest(".form-group").addClass("has-warning");
			warningFlag = 1;
		}else{
			$("#fan1tuanModal input[name=password]").parents().closest(".form-group").removeClass("has-warning");
		}
		
		if(warningFlag==1){
			$("#fan1tuanModal .alert-area").empty();
			$("#fan1tuanModal .alert-area").append('<div class="alert alert-block alert-warning">\
    				<strong>用户名和密码均不可为空</strong>\
    				<button type="button" class="close" data-dismiss="alert">&times;</button>\
   				</div>');
		}else{
			$.ajax({
				url:"/ajax/secure/ajaxSignin.f1t",
				data:{
					cellphone: cellphone,
					password: password,
					isCookie : isCookie
				}
			}).done(function(data){
				if(data.loginFlag=="success"){
					
					$("#fan1tuanModal .close").click();
					location.reload();
					
				}else{
					$("#fan1tuanModal input[name=cellphone]").parents().closest(".form-group").addClass("has-error");
					$("#fan1tuanModal input[name=password]").parents().closest(".form-group").addClass("has-error");
					$("#fan1tuanModal .alert-area").empty();
					$("#fan1tuanModal .alert-area").append('<div class="alert alert-block alert-danger">\
		    				<strong>用户名或密码错误</strong>\
		    				<button type="button" class="close" data-dismiss="alert">&times;</button>\
		   				</div>');
				}
			});
		}
		
	});
	
});