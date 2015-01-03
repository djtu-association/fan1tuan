/**
 * 
 */
$(document).ready(function(){
	
	this.phone_GetDefault = function(){
		//alert("in");
		var url = "rank/ajax/phoneCallShopRankDefault.f1t";
		var data = {};
		$.getJSON(url,data,function(json){
			phone_createPanel(json);
		});
	};
	
	this.phone_AjaxChange = function(pNumber){
		var url = "rank/ajax/phoneCallShopRank.f1t";

		var shopTasteTagIds = $('#call_taste').val();

		var data = {
			"pSize": 12,
			"pNumber": pNumber,
			"accord": $('#call_accord').val(),
			"order": 1,
			"shopType": 2,
			"shopTasteTagIds": shopTasteTagIds
		};

		if (shopTasteTagIds == "")
			delete data["shopTasteTagIds"];

		$.getJSON(url,data,function(json){
			phone_createPanel(json);
		});
	};
	
	//phone panel create panel
	 var phone_createPanel = function(json){
		 
		var content = "";
		var partial = "";
		var tdHeader = "";
		var tdFooter = "";
		var pContent = "";
		var funcAddCollect = "";//js添加收藏函数
		 var funcDelCollect = "";
		var shopLink = "";
		var data = json.shopGeo;
		for(var i=0,size=json.shopGeo.length; i<size; i++){
			
			tdHeader = (i==0||(i%4)==0)?"<tr><td>":"<td>";
			tdFooter = (((i+1)%4)==0||(i+1)==size)?"</td></tr>":"</td>";
			funcAddCollect = "addToCollectBox('call_spn_"+i+"','0','"+data[i].content.id+"')";
			funcDelCollect = "delFromCollectBox('call_spn_"+i+"','0','"+data[i].content.id+"')";
			shopLink = "location='shop/index.f1t?shopId="+data[i].content.id+"'";
			
			partial = tdHeader+
			"<div id='callPopPanel_"+(i+1)+"' class='shopPopPanel' data-toggle='popover' title=''  data-original-title='"+data[i].content.name+"'>"+ //这里的id跟下面的popover的id是绑定的
			"<div class='row-fluid'>"+
			"<div class='span5'>"+
			"<a href='javascript:void(0)' onclick="+shopLink+" title='进入店铺'><img class='img-thumbnail'   src='res/avatar/shop/"+data[i].content.avatar+"' alt='Generic placeholder image' style='width: 96px;height: 96px'></a>"+ //进入店铺的href要穿店铺ID，店铺图片
			"<br/><span class='text-primary text-center'><span class='glyphicon glyphicon-time'></span>"+data[i].content.avgDeliveryTime+"分钟</span>"+//平均送餐时间
			"</div>"+
			"<div class='span7'>"+
			"<small class='lead'><strong>"+data[i].content.name+"</strong></small><br>"+//店铺名字
			"<span class='text-info'>"+
			"<span class='glyphicon glyphicon-tag'></span>"+
			"西式,烧烤</span><br>"+//店铺标签
			//电话订餐没有评分！！！
			//"<span class='text-warning'>"+
			//"<i class='icon-rst-rating s"+parseInt(data[i].content.avgCommentLevel*2)+"'></i><a title='评价总数'>("+data[i].content.commentNum+")</a>"+
			//"</span><br>"+
			"<p>"+
			"<a class='btn btn-info' href='javascript:void(0)' onclick="+shopLink+" data-toggle='Enter the shop' title='进入店铺'><span class='glyphicon glyphicon-home'></span></a>";//跟上面的进入店铺一样
			
			if(data[i].isLike != undefined && data[i].isLike == 'true'){
				partial += "&nbsp;<a class='btn btn-warning collectTips' href='javascript:void(0)' onclick="+funcDelCollect+" title='已收藏' data-toggle='tooltip'><span class='glyphicon glyphicon-heart text text-danger' id='call_spn_"+i+"'></span></a>";
			}
			else{
				partial += "&nbsp;<a class='btn btn-danger' href='javascript:void(0)' onclick="+funcAddCollect+" title='收藏该店铺'><span class='glyphicon glyphicon-heart' id='call_spn_"+i+"'></span></a>";
			}
			//"&nbsp;<a class='btn btn-danger' href='javascript:void(0)' onclick="+funcAddCollect+" title='收藏该菜品'><span class='glyphicon glyphicon-heart' id='call_spn_"+i+"'></span></a>"+//点击收藏可以收藏该店铺，这里是收藏店铺，而不是收藏菜品

			var inner_type = data[i].content.type == 0 ? "摊位":"实体店";

			partial += "</p></div>"+
			"</div>"+
			"<div  class='sr-only'>"+//店铺popover弹出框，id动态生成
			"<div id='call_popover_"+(i+1)+"'>"+
			'<p>\
            <span class="text text-warning"><strong>公告:</strong></span>\
            <span class="text text-warning">'+data[i].content.announcement+'</span>\
        </p>\
        <p>\
            <span class="text text-info"><strong>简介:</strong></span>\
            <span class="text text-info">'+data[i].content.description+'</span>\
        </p>\
        <p>\
            <span class="text text-primary"><strong>地址:</strong></span>\
            <span class="text text-primary">'+data[i].content.address+'</span>\
        </p>\
        <p>\
            <span>我是</span>\
            <strong><span class="text text-danger">'+inner_type+'</span></strong>\
            <span>，</span>\
            <strong><span class="text text-danger"><i class="glyphicon glyphicon-road"></i>'+data[i].content.deliveryCharge+'元</span></strong>\
            <span>起送，人均</span>\
            <strong><span class="text text-danger"><i class="glyphicon glyphicon-shopping-cart"></i>'+data[i].content.avgPersonCost+'元</span></strong>\
            <span>，人气</span>\
            <strong><span class="text text-danger"><i class="glyphicon glyphicon-fire"></i>'+data[i].content.popularity+'</span></strong>\
        </p>\
        <p>\
            <span class="text text-info">\
                <i class="glyphicon fui-time"></i>&nbsp;'+new Date(data[i].content.openTime).getHours()+":"+new Date(data[i].content.openTime).getMinutes()+" - "+new Date(data[i].content.closeTime).getHours()+":"+new Date(data[i].content.closeTime).getMinutes()+'\
            </span>\
        </p>\
        <p>\
            <span class="text text-info">\
            <i class="glyphicon glyphicon-phone"></i>'+data[i].content.cellphone+'\
            </span>\
        </p>'+
			
			
			//"<p class='text text-warning'>公告："+data[i].content.announcement+"</p>"+//店铺公告
			//"<small class='lead'><small>起送费<small>：<label class='label label-danger'>"+data[i].content.deliveryCharge+" 元</label></small>"+//最低起送价
			//"<br><small>事务</small>：<span class='label label-primary'><span class='glyphicon glyphicon-star'></span></span>"+//店铺标签
			//"&nbsp;<span class='label label-primary'><span class='glyphicon glyphicon-time'></span></span>"+
			//"&nbsp;<span class='label label-primary'><span class='glyphicon glyphicon-edit'></span></span>"+
			//"<p class='text text-warning'><samll>简介</small>：<label class='label label-success'>"+data[i].content.description+"</label></p>"+
			//"<p class='text text-warning'><samll>地址</small>：<label class='label label-success'>"+data[i].content.address+"</label></p>"+
			//"<p class='text text-success'><small>营业</small>：<label class='label label-info'>"+new Date(data[i].content.openTime).getHours()+":"+new Date(data[i].content.openTime).getMinutes()+" - "+new Date(data[i].content.closeTime).getHours()+":"+new Date(data[i].content.closeTime).getMinutes()+"</label></p>"+//营业时间data[i].content.openTime  data[i].content.closeTime
			"</div></div></div>"+tdFooter;
			content += partial;			
		}
		//and then refresh the shop panel page footer
		var pLength = json.pageMap.length;
		var pNumber = json.pageMap.number;
		if(pLength == 1){
			pContent += "<li class='previous'><a href='javascript:void(0)' class='fui-arrow-left'></a></li>";
			pContent += "<li class='active'><a href='javascript:void(0)'>1</a></li>";
			pContent += "<li class='next'><a href='javascript:void(0)' class='fui-arrow-right'></a></li>";
		}else{
			pContent += "<li class='previous'><a href='javascript:void(0)' onclick='phone_AjaxChange("+(parseInt(i)-1)+");' class='fui-arrow-left'></a></li>";
			for(var i=0; i<pLength; i++){		
				if(i==pNumber){
					pContent += "<li class='active'><a href='javascript:void(0)'>"+(+parseInt(i)+1)+"</a></li>";
				}else{
					pContent += "<li><a href='javascript:void(0)' onclick='phone_AjaxChange("+parseInt(i)+");'>"+(+parseInt(i)+1)+"</a></li>";
				}
			}
			if(pLength==pNumber){
				pContent += "<li class='next'><a href='javascript:void(0)' class='fui-arrow-right'></a></li>";
			}else{
				pContent += "<li class='next'><a href='javascript:void(0)' onclick='phone_AjaxChange("+(parseInt(i)+1)+");' class='fui-arrow-right'></a></li>";
			}
			
		}
		$('#call_page').html(pContent);
		$('#callMainPanel').html(content);
		//重新加载js文件，先前的popover.js失效
		$.getScript('res/js/custom/index_shop_popover.js',null);
		
	};
	
	
	
	//when finish loading the js file and document ,then load the main phone-call's shops panel
	(function(global){
		global.phone_GetDefault();
	})(this);
	
});

