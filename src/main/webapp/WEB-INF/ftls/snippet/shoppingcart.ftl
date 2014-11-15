<#if Session["login"]?exists && Session["login"]["loginStatus"]?exists && Session["login"]["loginStatus"]=="1">
	<table id="J_CommonBottomBar" style="">
    <tbody>
    <tr>
        <td order="0"></td>

        <td order="50">
            <div class="tm_cmbar_clearfix tm_cmbar tm-mCart tm-mcNilQuick tm-mcUnFold" id="TMinaCart">
                <div class="tm-mcRoot">
                    <div class="tm-mcListBox" style="display: block; height: 350px; top: -300px;">
                        <div class="tm-mcListInner" style="height: 290px;">
                            <div class="tm-mcList">
                                <div class="tm-mcTop">
                                    <span class="lead">
                                        我的菜篮子<a class="pull-right empty-cart" style="font-size: 14px">[清空篮子]</a>
                                    </span>

                                </div>
                                
                                <!-- content start here -->
                                
                                <!-- content end here -->
                                
                                <div class="tm-mcBottom">
                                    <div class="tm-mcBottomMain text-center">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tm-mcFloat"><a class="tm-mcCartBtn" href="http://cart.tmall.com/"
                                                   data-tmc="cart"></a>

                            <div class="tm-mcChk"><input type="checkbox" class="tm-mcElectCart" data-tmc="elect"
                                                         checked="" id="tmcElectCart2"></div>
                            <label for="tm-mcElectCart2">全选</label></div>
                        <div class="tm-mcMask"></div>
                    </div>
                    <div class="tm-mcGenius" data-tmc="" style="bottom: 0px;"></div>
                    <div class="tm-mcGrace"></div>
                    <div class="tm-mcApart"></div>
                    <div class="tm-mcHandler" data-tmc="toggleFold">
                        
                        <h3 style="font-size: 13px">
                            <span class="tm-e1">购物车</span>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<button class="btn btn-danger btn-sm " id="confirm-order">结 算</button>
			 				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <strong class="tm-mcCartNumTotal"></strong>
                            <strong class="tm-mcCartSumCost" style="font-size:15px;"></strong>
                        </h3>
                    </div>
                </div>
            </div>
        </td>
    </tr>
    </tbody>
</table>
	
</#if>