
<%@ page import="manoamano.Facadas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'facadas.label', default: 'Facadas')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-facadas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-facadas" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list facadas">
			
				<g:if test="${facadasInstance?.qtdeFacadas}">
				<li class="fieldcontain">
					<span id="qtdeFacadas-label" class="property-label"><g:message code="facadas.qtdeFacadas.label" default="Qtde Facadas" /></span>
					
						<span class="property-value" aria-labelledby="qtdeFacadas-label"><g:fieldValue bean="${facadasInstance}" field="qtdeFacadas"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${facadasInstance?.vitima}">
				<li class="fieldcontain">
					<span id="vitima-label" class="property-label"><g:message code="facadas.vitima.label" default="Vitima" /></span>
					
						<span class="property-value" aria-labelledby="vitima-label"><g:link controller="vitima" action="show" id="${facadasInstance?.vitima?.id}">${facadasInstance?.vitima?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${facadasInstance?.dataFacada}">
				<li class="fieldcontain">
					<span id="dataFacada-label" class="property-label"><g:message code="facadas.dataFacada.label" default="Data Facada" /></span>
					
						<span class="property-value" aria-labelledby="dataFacada-label"><g:formatDate date="${facadasInstance?.dataFacada}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:facadasInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${facadasInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
