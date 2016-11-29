<%@ page import="manoamano.Vitima" %>



<div class="fieldcontain ${hasErrors(bean: vitimaInstance, field: 'matador', 'error')} required">
	<label for="matador">
		<g:message code="vitima.matador.label" default="Matador" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="matador" name="matador.id" from="${manoamano.Jogador.list()}" optionKey="id" required="" value="${vitimaInstance?.matador?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vitimaInstance, field: 'vitima', 'error')} required">
	<label for="vitima">
		<g:message code="vitima.vitima.label" default="Vitima" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vitima" name="vitima.id" from="${manoamano.Jogador.list()}" optionKey="id" required="" value="${vitimaInstance?.vitima?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vitimaInstance, field: 'dataFacada', 'error')} required">
	<label for="dataFacada">
		<g:message code="vitima.dataFacada.label" default="Data Facada" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataFacada" precision="day"  value="${vitimaInstance?.dataFacada}"  />

</div>

