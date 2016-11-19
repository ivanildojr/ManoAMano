<%@ page import="manoamano.Jogador" %>



<div class="fieldcontain ${hasErrors(bean: jogadorInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="jogador.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${jogadorInstance?.nome}"/>

</div>

