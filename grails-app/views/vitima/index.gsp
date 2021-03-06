
<%@ page import="manoamano.Vitima" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vitima.label', default: 'Vitima')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vitima" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vitima" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="vitima.matador.label" default="Matador" /></th>
					
						<th><g:message code="vitima.vitima.label" default="Vitima" /></th>
					
						<g:sortableColumn property="dataFacada" title="${message(code: 'vitima.dataFacada.label', default: 'Data Facada')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${vitimaInstanceList}" status="i" var="vitimaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${vitimaInstance.id}">${fieldValue(bean: vitimaInstance, field: "matador")}</g:link></td>
					
						<td>${fieldValue(bean: vitimaInstance, field: "vitima")}</td>
					
						<td><g:formatDate date="${vitimaInstance.dataFacada}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vitimaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
