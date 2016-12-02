<!DOCTYPE html>
<%@page import="java.nio.file.Paths"%>
<html>
<head>
<asset:javascript src="uploadr.manifest.js" />
<asset:stylesheet href="uploadr.manifest.css" />

<meta name="layout" content="main" />
<title>Facadas CS</title>
<g:javascript library="jquery" />
</head>
<body>
	<div align="center">
		<% def path = new File("uploadLogs/") %>
		<uploadr:add name="mySecondUploadr" path="${path}" direction="up"
			maxVisible="5"
			unsupported="${createLink(plugin: 'uploadr', controller: 'upload', action: 'warning')}">

		</uploadr:add>
		<%erro = "" %>
		<uploadr:onSuccess>
			<%erro = "deu errado" %>
		</uploadr:onSuccess>

				
		<g:link controller="ProcessaArquivo" action="redireciona" class="button">Processar Arquivos</g:link>
		
		<div id="divForm"></div>
	</div>
</body>
</html>