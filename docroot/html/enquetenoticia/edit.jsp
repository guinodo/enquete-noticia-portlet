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
	Map<String, Layout> paginasPortal = EnqueteNoticiaLocalServiceUtil.getPaginasPortal();

	if (!PortalUtil.getCurrentURL(renderRequest).contains("/manage")) {
%>

	<aui:input type="radio" name="viewPreferences" value="enqueteView"
		label="exibir-enquetes-e-suas-associacoes"></aui:input>
	<aui:input type="radio" name="viewPreferences" value="noticiaView"
		label="exibir-noticias-e-suas-associacoes"></aui:input>

	
<%
	}
%>

<portlet:renderURL var="url" />
<aui:select id="pagina" name="pagina"
	onChange='<%= renderResponse.getNamespace() + "proximoPasso()"%>'>

	<%
		for (Map.Entry<String, Layout> pagina : paginasPortal.entrySet()) {
	%>
	<aui:option label="<%=pagina.getKey() %>" value="<%=pagina.getKey() %>" />
	<%
		}
	%>
</aui:select>

<%
	System.out.println("Pagina: " + renderRequest.getParameter("pagina"));

	if (renderRequest.getParameter("pagina") != null) {
%>
<aui:select id="portlet" name="portlet" onChange='<%= renderResponse.getNamespace() + "passoFinal()"%>'>

	<%
		Layout layout = paginasPortal.get(renderRequest.getParameter("pagina"));
		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
		List<Portlet> portlets = layoutTypePortlet.getPortlets();
		for (Portlet portlet : portlets) {
	%>
		<aui:option label="<%=portlet.getDisplayName() %>" value="<%=portlet.getActionURLRedirect() %>" />
	<%
		}
	%>
</aui:select>

<%
	System.out.println("Portlet: " + renderRequest.getParameter("portlet"));

	}
%>
<aui:button type="submit"></aui:button>

</form>

<aui:script>
function <portlet:namespace />proximoPasso() {
	var select = document.getElementById('<portlet:namespace />pagina');
	var value = select.value;
	var url = "<%=url%>" + "&<portlet:namespace />pagina="+value;
	window.location.href = url;
}
function <portlet:namespace />passoFinal() {
	var select = document.getElementById('<portlet:namespace />portlet');
	var value = select.value;
	var url = "<%=url%>" + "&<portlet:namespace />portlet="+value;
	window.location.href = url;
}

</aui:script>