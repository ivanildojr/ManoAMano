<%@ page import="manoamano.Facadas" %>



<div class="fieldcontain ${hasErrors(bean: facadasInstance, field: 'qtdeFacadas', 'error')} required">
	<label for="qtdeFacadas">
		<g:message code="facadas.qtdeFacadas.label" default="Qtde Facadas" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="qtdeFacadas" type="number" value="${facadasInstance.qtdeFacadas}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: facadasInstance, field: 'vitima', 'error')} required">
	<label for="vitima">
		<g:message code="facadas.vitima.label" default="Vitima" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vitima" name="vitima.id" from="${manoamano.Vitima.list()}" optionKey="id" required="" value="${facadasInstance?.vitima?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: facadasInstance, field: 'dataFacada', 'error')} required">
	<label for="dataFacada">
		<g:message code="facadas.dataFacada.label" default="Data Facada" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataFacada" precision="day"  value="${facadasInstance?.dataFacada}"  />

</div>

