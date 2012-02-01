<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.polls.model.PollsQuestion" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
JournalArticle art = (JournalArticle)row.getObject();

%>

<input type="checkbox" name="<portlet:namespace/>articleId" value="<%= art.getPrimaryKey() %>"></input>