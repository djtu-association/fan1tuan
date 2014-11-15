<html>
<head>
    <title>Hello</title>
</head>
<body>

<h1>${projectName}</h1>
<h3>FreeMarkerʾ��ҳ��</h2>
<hr>
<h3>Struts2��Action Bean��Property</h3>
<hr>
<h4>PropertyΪJava Bean</h4>
<p>Bean Name: shoppingCart</p>
<p>ID:${shoppingCart.id}; Price: ${shoppingCart.price}</p>
<hr>
<h4>PropertyΪ����(List,Set)������</h4>
<p>Bean Name : tags</p>
<p>[0]${tags[0]}, [1]${tags[1]}</p>
<hr>
<h4>PropertyΪӳ��(Map)</h4>
<p>Bean Name : map</p>
<p>['Hello']${map.Hello}, ['���']${map['���']}</p>
<hr>
<#-- This is a comment -->
<h3>FreeMarkerָ��(FTL��ǩ)��ע��(1)FTL��ǩ�в�������ʹ��FTL��ǩ���ᱨ��;(2)��Ƕ�׵�FTL��ǩֻ�����ʹ��<# /></h3>
<hr>
<h4>if,else if, elseָ��</h4>
<p>Bean Name : projectName</p>
<p>
	<#if projectName=="fan1tuan">
		projectNameΪfan1tuan
	<#elseif projectName=="hello">
		projectNameΪhello
	<#else>
		projectNameΪunknown		
	</#if>
</p>
<hr>
<h4>listָ��</h4>
<p>Bean Name : dishList</p>
<p>
	<#list dishList as dish>
		- ${dish.dishId}
		- ${dish.dishPrice}
		- ${dish.number}
	</#list>
</p>
<hr>
<h4>compressָ��</h4>
<p>����ѹ���ռ䣬�س����ո��Ʊ������ȡ��������HTML�𵽵����ûᱣ��</p>
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
<h4>escape��noescapeָ��</h4>
<p></p>
<p>
	����Ϊescapeʾ��:<br>
	<#assign htmlTag="<h1>Hello</h1>" />
	<#escape x as x?html>
		${htmlTag}
		<#noescape>${htmlTag}</#noescape>
	</#escape>
</p>
<hr>
<h4>����null�������</h4>
<p>Bean Name: user(not exist!), projectName, shoppingCart(exist!!)</p>
<p>
	�ṩȱʡֵ��<strong>Welcome!! ${user!"Anonymous"}</strong><br>
	<#if projectName??>
		�ж��Ƿ����<strong>projectName�������ڣ�������ֵΪ:${projectName}</strong><br>
	</#if>
	���ڶ༶���ʵı�����Ϊ�˱���NullPointer�쳣����˴���<br>
	<strong>${shoppingCart.aNotHaveProperty!"û�д�Property"}</strong><br>
	<strong>${(user.id)!"û�б���"}</strong>
</p>
<hr>
<h3>���ʹ���</h3>
<hr>
<h4>Number</h4>
<p>Bean Name: shoppingCart</p>
<p>
	half-price: ${shoppingCart.price/2}
</p>
<hr>
<h4>��ת���ַ���</h4>
<p>Bean Name: projectName</p>
<p>
	��ת���ַ���: ${r"${projectName}"}<br>
	ת���ַ�����${"${projectName}"}
</p>
<hr>
<h4>�ֶ���������</h4>
<p>Bean Name: null</p>
<p>
	<#list ["Hello","Hi", "Bye"] as str>
		${str},
	</#list>
</p>
<hr>
<h4>�ֶ�����ӳ��</h4>
<p>Bean Name: map</p>
<p>
	<#assign user={"name" : "���", "age" : 15} />
	${user.name}
</p>
<hr>
<h3>���������Լ��Զ���ָ��</h3>
<hr>
<h4>Bean����ķ�������</h4>
<p>Bean Name: shoppingCart</p>
<p>
	toJSON(): ${shoppingCart.toJSON()}
</p>
<hr>
<h4>Struts2�ı�ǩ������Ϊ�Զ���ָ��ʹ��</h4>
<p>Bean Name: tags</p>
<p>
	<!-- struts2��tag��Ȼ����ʹ�ã����·� -->
	<@s.iterator value="tags">
    	<@s.property /><br>
	</@s.iterator>
</p>
<hr>
<h3>�ڽ�����</h3>
<hr>
<h4>html:��ת��html tag</h4>
<p>Bean Name: projectName</p>
<p>
	${"<h1>Hello ${projectName}</h1>"?html}
</p>
<hr>
<h4>html:��ת��html tag</h4>
<p>Bean Name: projectName</p>
<p>
	${"<h1>Hello ${projectName}</h1>"?html}
</p>
<hr>
<h4>c:���������Ϊ�������ʶ��ļ���ʽ��������locale��</h4>
<p>Bean Name: shoppingCart</p>
<p>
	Ĭ�������������${shoppingCart.price}<br>
	�����ʶ�������${shoppingCart.price?c}
</p>
<hr>
<h4>time�ڽ�����:һϵ����������ʱ������ķ���</h4>
<p>Bean Name: releaseDate</p>
<p>
	${releaseDate?time}<br>
	${releaseDate?date}<br>
	${releaseDate?datetime}<br>
	${releaseDate?string("yyyy/MM/dd HH:mm:ss")}
	
</p>
<hr>
<h4>�����ڽ�����</h4>
<img src="memo2.png" />
<hr>
<h3>����</h3>
<hr>
<h4>��globals��ʹ�ñ����ص�ȫ�ֱ���</h4>
<p>
	<#assign projectName="�ٶ�" />
	��ǰ������${projectName}<br>
	ȫ�ֱ�����${.globals.projectName}
</p>
<hr>
<h4>�����������</h4>
<img src="memo.png" />
<hr>

<h2>Struts2���ڽ�֧�֣�</h2>
<hr>
<h3>Request, Application, Session��Attribute����</h3>
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
<h3>����context��������table</h3>
<img src="memo3.png" />
</body>
</html>