
$('document').ready(function(){

	function getUrlParam(name)
	{
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	} 
	
    $('#rememberMe').tooltip({
        placement : "right"
    });

    $('#col_btn1').click(function(){
        $('#coll_div1').hide(1000);
        $('#coll_div2').show(1000);
    });
    $('#col_btn2').click(function(){
        $('#coll_div1').fadeIn(500);
        $('#coll_div2').fadeOut(500);

    });

    
    $('#signIn').click(function(){
    	
    	var cellphone = $('#regCellphone').val();
    	var password = $('#regPassword').val();
    	var repassword = $('#regRepassword').val();
    	var checkcode = $('#regCheckcode').val();
    	
    	//validate the input
    	if(cellphone==""||password==""){
    		$('#sign_tips').html("信息要填写完整哦");
			$('#sign_tips').fadeIn(500);
			$('#sign_tips').fadeOut(3000);
			return;
    	}
    	//ajax url,data
    	var url = "../ajax/secure/ajaxSignup.f1t";
    	var data = {"cellphone":cellphone,"password":password,"checkcode":checkcode};
    	//ajax register
    	$.getJSON(url,data,function(json){
    		
    		if(json.regFlag == "success"){
    			$('#myModal').modal('show');
    			var count = 4;
    			setInterval(function(){
    				if(count>=0){
    					$('#countTime').html(count--);
    				}else{
    					var encodedUrl = getUrlParam("redirect");
    					   if(encodedUrl){
    						   	location=decodeURIComponent(encodedUrl);
    					   }else{
    					   		location="../index.f1t";
    					   }
    				}
    				
    		    },1000);
    			
    		}
    		if(json.regFlag == "cellphone"){
    			$('#sign_tips').html("此手机号已注册过了哦");
    			$('#sign_tips').fadeIn(500);
    			$('#sign_tips').fadeOut(3000);
    		}
    		if(json.regFlag == "error"){ 			
    			$('#sign_tips').html("不小心注册失败了+_+");
    			$('#sign_tips').fadeIn(500);
    			$('#sign_tips').fadeOut(3000);
    		}
    	});
        
    });
    
    //Ajax get login click login button
    $('#btn_login').click(function(){
       
	   var cellphone = $('#logCellphone').val();
	   var password = $('#logPassword').val();
	   var isCookie = ($('#rememberMe').attr('checked')=="checked")?"set":"unset";
	   
	   if(cellphone=="" || password==""){
		   $('#form_tips').html("手机号和密码都要写哦");
		   $('#form_tips').fadeIn(300);
		   $('#form_tips').fadeOut(3000);
		   return;
	   }
	   //ajax url data
	   var url = "../ajax/secure/ajaxSignin.f1t";
	   var data = {"cellphone":cellphone,"password":password,"isCookie":isCookie};
	   //get ajax
	   $.getJSON(url,data,function(json){
		   
		   if(json.loginFlag=="success"){
			   var content = "<h4><label class='label label-success'>登陆成功</label></h4>";
			   content += "<br/><h4><label class='label label-warning'>跳转中...</label></h4>";
			   $('#form_div1').fadeOut(100);
			   $('#form_div1').html(content);
			   $('#form_div1').fadeIn(50);
			   setTimeout(function(){
				   var encodedUrl = getUrlParam("redirect");
				   if(encodedUrl){
					   	location=decodeURIComponent(encodedUrl);
				   }else{
				   		location="../index.f1t";
				   }
			   },1000);
		   }else{
			   $('#form_tips').html("亲，输入的信息不对哦");
			   $('#form_tips').fadeIn(500);
			   $('#form_tips').fadeOut(3000);
		   }
	   });
   });


});