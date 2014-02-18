/**
 * 
 */

$('document').ready(function(){
	
	//global popover content arr
	var contentArr = {};//shop online
	var callContentArr = {};//shop call
    //刷新popover版 //shop popover panel----------------------------------------------------------------------
    function refreshPopContent(){    	
    	var contentLength = 12;
    	for(var i=1; i<=contentLength; i++){
    		contentArr[i] = $('#popover_'+i).html();
    		callContentArr[i] = $('#call_popover_'+i).html();
    		//console.log(contentArr[i]);
    	}
    }
    
    refreshPopContent();//刷新popover的content
    
    $('#shopPopPanel_1').popover({"trigger" : "hover","html" : true,"content" : contentArr[1]});
    $('#shopPopPanel_2').popover({"trigger" : "hover","html" : true,"content" : contentArr[2]});
    $('#shopPopPanel_3').popover({"trigger" : "hover","html" : true,"content" : contentArr[3]});
    $('#shopPopPanel_4').popover({"trigger" : "hover","html" : true,placement:"left","content" : contentArr[4]});
    $('#shopPopPanel_5').popover({"trigger" : "hover","html" : true,"content" : contentArr[5]});
    $('#shopPopPanel_6').popover({"trigger" : "hover","html" : true,"content" : contentArr[6]});
    $('#shopPopPanel_7').popover({"trigger" : "hover","html" : true,"content" : contentArr[7]});
    $('#shopPopPanel_8').popover({"trigger" : "hover","html" : true,placement:"left","content" : contentArr[8]});
    $('#shopPopPanel_9').popover({"trigger" : "hover","html" : true,"content" : contentArr[9]});
    $('#shopPopPanel_10').popover({"trigger" : "hover","html" : true,"content" : contentArr[10]});
    $('#shopPopPanel_11').popover({"trigger" : "hover","html" : true,"content" : contentArr[11]});
    $('#shopPopPanel_12').popover({"trigger" : "hover","html" : true,placement:"left","content" : contentArr[12]});
    
    $('#callPopPanel_1').popover({"trigger" : "hover","html" : true,"content" : callContentArr[1]});
    $('#callPopPanel_2').popover({"trigger" : "hover","html" : true,"content" : callContentArr[2]});
    $('#callPopPanel_3').popover({"trigger" : "hover","html" : true,"content" : callContentArr[3]});
    $('#callPopPanel_4').popover({"trigger" : "hover","html" : true,placement:"left","content" : callContentArr[4]});
    $('#callPopPanel_5').popover({"trigger" : "hover","html" : true,"content" : callContentArr[5]});
    $('#callPopPanel_6').popover({"trigger" : "hover","html" : true,"content" : callContentArr[6]});
    $('#callPopPanel_7').popover({"trigger" : "hover","html" : true,"content" : callContentArr[7]});
    $('#callPopPanel_8').popover({"trigger" : "hover","html" : true,placement:"left","content" : callContentArr[8]});
    $('#callPopPanel_9').popover({"trigger" : "hover","html" : true,"content" : callContentArr[9]});
    $('#callPopPanel_10').popover({"trigger" : "hover","html" : true,"content" : callContentArr[10]});
    $('#callPopPanel_11').popover({"trigger" : "hover","html" : true,"content" : callContentArr[11]});
    $('#callPopPanel_12').popover({"trigger" : "hover","html" : true,placement:"left","content" : callContentArr[12]});
    
});