<%@ page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	JournalArticle art = (JournalArticle) row.getObject();
%>
<!-- 
sfd6 
56_INSTANCE_abcd

-->
<liferay-portlet:renderURL portletName="101_INSTANCE_Xa0s" windowState="maximized" var="articleURL">
	<liferay-portlet:param name="groupId" value="<%= String.valueOf(art.getGroupId())%>" />
	<liferay-portlet:param name="articleId" value="<%= art.getArticleId() %>" />
</liferay-portlet:renderURL>
<liferay-ui:search-container-column-text><a href="<%=articleURL%>"><%=art.getTitle()%></a></liferay-ui:search-container-column-text>