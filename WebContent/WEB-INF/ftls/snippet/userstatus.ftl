						<#if Session["login"]?exists && Session["login"]["loginStatus"]?exists && Session["login"]["loginStatus"]=="1">
							<li class="dropdown">
                  				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span><#if Session["currentUser"]["realName"]?exists> ${Session["currentUser"]["cellphone"]} <#else> ${Session["currentUser"]["cellphone"]} </#if> <b class="caret"></b></a>
                  				<ul class="dropdown-menu dropdown-inverse">
                    				<li><a href="#"><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;我的页面</a></li>
                    				<li><a href="#"><i class="glyphicon glyphicon-list-alt"></i>&nbsp;&nbsp;&nbsp;已下的饿单</a></li>
                    				<li><a href="#"><i class="glyphicon glyphicon-thumbs-up"></i>&nbsp;&nbsp;&nbsp;已下的评价</a></li>
                    				<li><a href="#"><i class="glyphicon glyphicon-heart"></i>&nbsp;&nbsp;&nbsp;我的收藏</a></li>
                    				<li><a href="#"><i class="glyphicon glyphicon-tasks"></i>&nbsp;&nbsp;&nbsp;收货地址管理</a></li>
                    				<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;&nbsp;个人信息</a></li>
                    				<li class="divider"></li>
                    				<li><a class="need-redirect" href="javascript:void(0)" onclick="location='/signout.f1t'" id="logout"><i class="glyphicon glyphicon-off"></i>&nbsp;&nbsp;&nbsp;退出登录</a></li>
                  				</ul>
                			</li>
                    		<li>
                    			<a id="pendingOrder" href="#pendingOrderModal" role="button" ><i class="glyphicon glyphicon-list-alt"></i> 订单动态 <span class="badge badge-success">2</span></a>
                    			<div id="pendingOrderModal" class="modal fade sr-only" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h5 id="myModalLabel">饿单快报</h5>
									</div>
									<div class="modal-body">
										
									</div>
									<!-- <div class="modal-footer">
										<button class="btn close-btn" data-dismiss="modal" aria-hidden="true">Close</button>
										<button class="btn btn-primary">Save changes</button>
									</div> -->
								</div>	
                    		</li>
                    		
                    	<#else>
	                        <li><a class="need-redirect" href="javascript:void(0)" onclick="location='/secure/signin.f1t'"><span class="glyphicon glyphicon-user"></span> 登陆</a></li>
	                        <li><a class="need-redirect" href="javascript:void(0)" onclick="location='/secure/signup.f1t'"><span class="glyphicon glyphicon-check"></span> 注册  </a></li>
                        </#if>