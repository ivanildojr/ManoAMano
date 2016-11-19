
<%@ page import="manoamano.Vitima" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vitima.label', default: 'Vitima')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vitima" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vitima" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vitima">
			
				<g:if test="${vitimaInstance?.matador}">
				<li class="fieldcontain">
					<span id="matador-label" class="property-label"><g:message code="vitima.matador.label" default="Matador" /></span>
					
						<span class="property-value" aria-labelledby="matador-label"><g:link controller="jogador" action="show" id="${vitimaInstance?.matador?.id}">${vitimaInstance?.matador?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vitimaInstance?.vitima}">
				<li class="fieldcontain">
					<span id="vitima-label" class="property-label"><g:message code="vitima.vitima.label" default="Vitima" /></span>
					
						<span class="property-value" aria-labelledby="vitima-label"><g:link controller="jogador" action="show" id="${vitimaInstance?.vitima?.id}">${vitimaInstance?.vitima?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:vitimaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${vitimaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
