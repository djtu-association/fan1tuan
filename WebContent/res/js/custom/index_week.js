/**
 * 
 */

$('document').ready(function(){
	
	//刷新每周之星
	this.week_AjaxRefreshWeekStar = function(){
		var url = ".f1t";
		var data = {"data":"data"};
		//data需要的参数：shopType，accord，order，open，areaId，pageable
		$.getJSON(url,data,function(json){
			week_refreshWeekStarResult(json);
		});
	};
	
	
	var week_refreshWeekStarResult = function(json){
		//alert("I am the result function");
		//便利json对象
		$.each(json,function(idx,item){
			//alert(item.id);
			//$('#weekStarPanel').html(" ");
		});
	};
	

	
	
	
	
});
