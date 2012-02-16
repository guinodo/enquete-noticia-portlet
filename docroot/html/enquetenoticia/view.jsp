<%@page import="com.liferay.util.portlet.PortletProps"%>
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
	String questionTitle = ParamUtil.getString(request, "questionTitle");

	String currentTitle = "Noticias associadas a enquete: " + questionTitle;
	String avaliableTitle = "Noticias disponiveis para a enquete: " + questionTitle;

	String redirectURL = renderRequest.getParameter("redirect");
	String currentURL = PortalUtil.getCurrentURL(renderRequest);

	if (redirectURL == null) {
		redirectURL = PortalUtil.getCurrentURL(renderRequest);
	}

	if (PortalUtil.getCurrentURL(renderRequest).contains("/manage") && questionId != 0) {
%>


<liferay-ui:tabs names="current,available" refresh="false">

	<!-- Artigos Associados -->


	<liferay-ui:section>
		<div id='poll_search_container'>
			<liferay-ui:header backURL="<%= redirectURL %>" title="<%= currentTitle %>" />
			<%@ include file="/html/enquetenoticia/list_current.jsp"%>
		</div>

	</liferay-ui:section>

	<liferay-ui:section>

		<!-- Artigos Disponiveis -->
		<div id="journalArticle_search_container">
			<liferay-ui:header backURL="<%= redirectURL %>" title="<%= avaliableTitle %>" />
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