<%@page import="java.io.StringReader"%>
<%@page import="com.liferay.portal.kernel.util.PropertiesUtil"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.model.LayoutTypePortlet"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.Map"%>
<%@page
	import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<portlet:defineObjects />

<portlet:actionURL name='salvarPreferencias' var='submitURL'></portlet:actionURL>

<form name="fm" method="POST" action="<%=submitURL%>">

<%
	Map<Properties, List<Portlet>> paginasPortal = EnqueteNoticiaLocalServiceUtil.getPaginasPortal();

	if (!PortalUtil.getCurrentURL(renderRequest).contains("/manage")) {
%>

	<aui:input type="radio" name="viewPreference" value="enqueteView"
		label="exibir-enquetes-e-suas-associacoes"></aui:input>
	<aui:input type="radio" name="viewPreference" value="noticiaView"
		label="exibir-noticias-e-suas-associacoes"></aui:input>

	
<%
	}
%>

<portlet:renderURL var="url" />
<aui:select id="paginaPreference" name="paginaPreference" onChange='<%= renderResponse.getNamespace() + "proximoPasso()"%>'>

	<%
		for (Map.Entry<Properties, List<Portlet>> pagina : paginasPortal.entrySet()) {
	%>
	<aui:option label='<%=pagina.getKey().getProperty("pagina") %>' value="<%=pagina.getKey() %>" />
	<%
		}
	%>
</aui:select>
<h4>Escolha qual Asset Publisher as noticias serão submetidas:</h4>
<%
	String requestPagina = renderRequest.getParameter("paginaPreference");

	if (requestPagina != null) {
%>
<aui:select id="portletPreference" name="portletPreference" onChange='<%= renderResponse.getNamespace() + "passoFinal()"%>'>

	<%
		Properties paginaProp = new Properties(); 
		paginaProp.load(new StringReader(requestPagina.substring(1, requestPagina.length() - 1).replace(", ", "\n")));
		List<Portlet> portlets = paginasPortal.get(paginaProp);
		for (Portlet portlet : portlets) {
	%>
		<aui:option label="<%=portlet.getDisplayName() %>" value="<%=portlet.getInstanceId() %>" />
	<%
		}
	%>
</aui:select>

<%
	}
%>
<aui:button type="submit"></aui:button>

</form>

<aui:script>
function <portlet:namespace />proximoPasso() {
	var select = document.getElementById('<portlet:namespace />paginaPreference');
	var value = select.value;
	var url = "<%=url%>" + "&<portlet:namespace />paginaPreference="+value;
	window.location.href = url;
}
function <portlet:namespace />passoFinal() {
	var select = document.getElementById('<portlet:namespace />portletPreferences');
	var value = select.value;
	var url = "<%=url%>" + "&<portlet:namespace />portletPreferences="+value;
	window.location.href = url;
}

</aui:script>