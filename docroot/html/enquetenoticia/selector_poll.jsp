<%@ page import="com.liferay.portlet.polls.model.PollsQuestion" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
PollsQuestion poll = (PollsQuestion)row.getObject();

%>

<aui:input type="radio" name="questionId" value="<%= poll.getQuestionId() %>" label=""></aui:input>