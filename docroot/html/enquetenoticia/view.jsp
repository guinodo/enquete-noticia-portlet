<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />

<portlet:actionURL name='associateQuestionArticle' var='submitURL'></portlet:actionURL>
<portlet:actionURL name='removeAssociateQuestionArticle' var='removeURL'></portlet:actionURL>


<%
	long questionId = ParamUtil.getLong(request, "questionId");
	int cur = ParamUtil.getInteger(renderRequest, "available");
	long delta = ParamUtil.getLong(renderRequest, "deltaavailable");
	String testeTab = ParamUtil.getString(request, "tabs1");

	String questionTitle = ParamUtil.getString(request, "questionTitle");
	String currentTitle = "Noticias associadas a enquete: " + questionTitle;
	String avaliableTitle = "Noticias disponiveis para a enquete: " + questionTitle;
	String redirectURL = renderRequest.getParameter("redirect");
	String currentURL = PortalUtil.getCurrentURL(renderRequest);
	if (redirectURL == null) {
		redirectURL = PortalUtil.getCurrentURL(renderRequest);
	}
	if ((PortalUtil.getCurrentURL(renderRequest).contains("/manage") && questionId != 0) || cur != 0 || delta !=0 || testeTab != "" ) {

		String currentTab = (String) request.getAttribute("tabs1");
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("struts_action", "/enquetenoticia/view");
		portletURL.setParameter("questionTitle", questionTitle);
		portletURL.setParameter("questionId", questionId+"");
%>
<liferay-ui:tabs 
	names="current,available" 
	refresh="false"
	url="<%=portletURL.toString() %>" 
	value="<%= currentTab %>" 
	>	
	<!-- Artigos Associados -->
	<liferay-ui:section>
		<div id='poll_search_container'>
			<liferay-ui:header title="<%= currentTitle %>" />
			<%@ include file="/html/enquetenoticia/list_current.jsp"%>
		</div>
	</liferay-ui:section>
	<liferay-ui:section>
	<!-- Artigos Disponiveis -->
		<div id="journalArticle_search_container">
			<liferay-ui:header title="<%= avaliableTitle %>" />
			<%@ include file="/html/enquetenoticia/list_avaliable.jsp"%>
		</div>
	</liferay-ui:section>
	
</liferay-ui:tabs>
<%
	} else {
%>
<%@ include file="/html/enquetenoticia/list_question.jsp"%>
<%
	}
%>