<html>
<head>
    <title>Hello</title>
</head>
<body>

<h1>${projectName}</h1>
<h3>FreeMarker示例页面</h2>
<hr>
<h3>Struts2中Action Bean的Property</h3>
<hr>
<h4>Property为Java Bean</h4>
<p>Bean Name: shoppingCart</p>
<p>ID:${shoppingCart.id}; Price: ${shoppingCart.price}</p>
<hr>
<h4>Property为集合(List,Set)或数组</h4>
<p>Bean Name : tags</p>
<p>[0]${tags[0]}, [1]${tags[1]}</p>
<hr>
<h4>Property为映射(Map)</h4>
<p>Bean Name : map</p>
<p>['Hello']${map.Hello}, ['你好']${map['你好']}</p>
<hr>
<#-- This is a comment -->
<h3>FreeMarker指令(FTL标签)：注：(1)FTL标签中不可以再使用FTL标签，会报错;(2)无嵌套的FTL标签只能如此使用<# /></h3>
<hr>
<h4>if,else if, else指令</h4>
<p>Bean Name : projectName</p>
<p>
	<#if projectName=="fan1tuan">
		projectName为fan1tuan
	<#elseif projectName=="hello">
		projectName为hello
	<#else>
		projectName为unknown		
	</#if>
</p>
<hr>
<h4>list指令</h4>
<p>Bean Name : dishList</p>
<p>
	<#list dishList as dish>
		- ${dish.dishId}
		- ${dish.dishPrice}
		- ${dish.number}
	</#list>
</p>
<hr>
<h4>compress指令</h4>
<p>用来压缩空间，回车，空格，制表符均被取消，但是HTML起到的作用会保留</p>
<p>
<#compress>
	<#list dishList as dish>
		- ${dish.dishId}
		- ${dish.dishPrice}
		- ${dish.number}
	</#list>
</#compress>
</p>
<hr>
<h4>escape与noescape指令</h4>
<p></p>
<p>
	以下为escape示例:<br>
	<#assign htmlTag="<h1>Hello</h1>" />
	<#escape x as x?html>
		${htmlTag}
		<#noescape>${htmlTag}</#noescape>
	</#escape>
</p>
<hr>
<h4>处理null变量情况</h4>
<p>Bean Name: user(not exist!), projectName, shoppingCart(exist!!)</p>
<p>
	提供缺省值：<strong>Welcome!! ${user!"Anonymous"}</strong><br>
	<#if projectName??>
		判断是否存在<strong>projectName变量存在！！！其值为:${projectName}</strong><br>
	</#if>
	对于多级访问的变量，为了避免NullPointer异常，如此处理：<br>
	<strong>${shoppingCart.aNotHaveProperty!"没有此Property"}</strong><br>
	<strong>${(user.id)!"没有变量"}</strong>
</p>
<hr>
<h3>类型处理</h3>
<hr>
<h4>Number</h4>
<p>Bean Name: shoppingCart</p>
<p>
	half-price: ${shoppingCart.price/2}
</p>
<hr>
<h4>非转义字符串</h4>
<p>Bean Name: projectName</p>
<p>
	非转义字符串: ${r"${projectName}"}<br>
	转义字符串：${"${projectName}"}
</p>
<hr>
<h4>手动创建集合</h4>
<p>Bean Name: null</p>
<p>
	<#list ["Hello","Hi", "Bye"] as str>
		${str},
	</#list>
</p>
<hr>
<h4>手动创建映射</h4>
<p>Bean Name: map</p>
<p>
	<#assign user={"name" : "李赫", "age" : 15} />
	${user.name}
</p>
<hr>
<h3>方法调用以及自定义指令</h3>
<hr>
<h4>Bean对象的方法调用</h4>
<p>Bean Name: shoppingCart</p>
<p>
	toJSON(): ${shoppingCart.toJSON()}
</p>
<hr>
<h4>Struts2的标签可以作为自定义指令使用</h4>
<p>Bean Name: tags</p>
<p>
	<!-- struts2的tag依然可以使用，见下方 -->
	<@s.iterator value="tags">
    	<@s.property /><br>
	</@s.iterator>
</p>
<hr>
<h3>内建函数</h3>
<hr>
<h4>html:非转义html tag</h4>
<p>Bean Name: projectName</p>
<p>
	${"<h1>Hello ${projectName}</h1>"?html}
</p>
<hr>
<h4>html:非转义html tag</h4>
<p>Bean Name: projectName</p>
<p>
	${"<h1>Hello ${projectName}</h1>"?html}
</p>
<hr>
<h4>c:将数据输出为计算机可识别的简单形式（即忽略locale）</h4>
<p>Bean Name: shoppingCart</p>
<p>
	默认区域性输出：${shoppingCart.price}<br>
	计算机识别输出：${shoppingCart.price?c}
</p>
<hr>
<h4>time内建函数:一系列用来处理时间输出的方法</h4>
<p>Bean Name: releaseDate</p>
<p>
	${releaseDate?time}<br>
	${releaseDate?date}<br>
	${releaseDate?datetime}<br>
	${releaseDate?string("yyyy/MM/dd HH:mm:ss")}
	
</p>
<hr>
<h4>更多内建函数</h4>
<img src="memo2.png" />
<hr>
<h3>其他</h3>
<hr>
<h4>用globals来使用被隐藏的全局变量</h4>
<p>
	<#assign projectName="百度" />
	当前变量：${projectName}<br>
	全局变量：${.globals.projectName}
</p>
<hr>
<h4>更多操作参照</h4>
<img src="memo.png" />
<hr>

<h2>Struts2的内建支持！</h2>
<hr>
<h3>Request, Application, Session的Attribute访问</h3>
<p>
	Application Scope: 
	<#if Application.user?exists>
     	${Application.user.toJSON()}<br>
	</#if>
	Session Scope: 
	<#if Session.user?exists>
     	${Session.user.toJSON()}<br>
	</#if>
	Request Scope: 
	<#if Request.user?exists>
     	${Request.user.toJSON()}<br>
	</#if>
	Request Parameter:msg(try add ?msg=xxxx behind your url):
	<#if Parameters.msg?exists>
     	${Parameters.msg}<br>
	</#if>
</p>
<h3>更多context请见下面的table</h3>
<img src="memo3.png" />
</body>
</html>