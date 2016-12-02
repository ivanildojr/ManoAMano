<%@ page import="manoamano.Jogador"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">

</head>
<body>
	<div align="center">
	<ul>
		
			<g:each in="${datasList}" status="j" var="datas">
				<li>
					<g:link controller="Relatorio" action="index" id="${datas}">
					${datas}
					</g:link>
				</li>
			</g:each>
		
		
	</ul>
	</div>
</body>
</html>
