<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= PollsQuestionLocalServiceUtil.getPollsQuestions(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PollsQuestionLocalServiceUtil.getPollsQuestionsCount() %>" />
	<liferay-ui:search-container-row
		className="com.liferay.portlet.polls.model.PollsQuestion"
		modelVar="aPollsQuestion"
		keyProperty="questionId">
		<liferay-ui:search-container-column-text>
			<aui:input type="radio" name="questionId" value="<%= aPollsQuestion.getQuestionId() %>" label=""></aui:input>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="title" value='<%= aPollsQuestion.getTitle("en_US") %>' />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>