<!DOCTYPE html>
<%@page import="java.nio.file.Paths"%>
<html>
<head>
<asset:javascript src="uploadr.manifest.js" />
<asset:stylesheet href="uploadr.manifest.css" />

<meta name="layout" content="main" />
<title>Facadas CS</title>
<g:javascript library="jquery" plugin="jquery"/>
<jqui:resources/>
</head>
<body>
	<div align="center">
		<g:form>
			<g:submitToRemote action="rodar" name="progressButton"
				value="Iniciar Processamento..." />
		</g:form>

		<g:jprogress progressId="barraProgresso" trigger="progressButton" />

	
	</div>
</body>
</html>