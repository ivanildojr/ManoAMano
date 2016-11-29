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

		<g:formRemote name="formProduto"
			url="[controller: 'processaArquivo', action: 'rodar']"
			update="divMensagem">

		</g:formRemote>
		<g:remoteLink url="[controller: 'ProcessaArquivo', action: 'rodar']"
			useToken="true">
			<input type="button" value="Rodar" class="button" />
		</g:remoteLink>
		<div id="divForm"></div>
	</div>
</body>
</html>