<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.Map"%>
<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />



<aui:select name="Paginas" onChange="<portlet:namespace />updatePortlets();">

<% 
	Map<String,Layout> paginasPortal = EnqueteNoticiaLocalServiceUtil.getPaginasPortal();
	String test;
	for (Map.Entry<String,Layout> pagina : paginasPortal.entrySet()){

%>
	<aui:option label="<%=pagina.getKey() %>" value="<%=pagina.getValue().getFriendlyURL() %>" />
<%	
	}
%>
</aui:select>

<aui:script use="aui-base"> 
    function <portlet:namespace />updatePortlets() {
		out.println("TESTE");
	}

</aui:script>