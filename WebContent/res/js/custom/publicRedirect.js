/**
 * Created by Lihe on 14-1-28.
 */

$('document').ready(function(){
	$(".need-redirect").each(function(index,item){
		var currentUrl = encodeURIComponent(window.location.href);
		var goUrl = $(item).attr("onclick");
		$(item).attr("onclick",goUrl.substring(0,goUrl.length-1)+"?redirect="+currentUrl+"'");
	});
});