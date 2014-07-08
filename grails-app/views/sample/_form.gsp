<%@ page import="com.zy.work.Sample" %>



<div class="fieldcontain ${hasErrors(bean: sampleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="sample.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sampleInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sampleInstance, field: 'desc', 'error')} ">
	<label for="desc">
		<g:message code="sample.desc.label" default="Desc" />
		
	</label>
	<g:textArea name="desc" cols="40" rows="5" maxlength="3000" value="${sampleInstance?.desc}"/>

</div>

