<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil.getPollsQuestions(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PollsQuestionLocalServiceUtil.getPollsQuestionsCount() %>" />
	<liferay-ui:search-container-row
		className="com.liferay.portlet.polls.model.PollsQuestion"
		modelVar="aPollsQuestion" keyProperty="questionId">
		<liferay-ui:search-container-column-jsp
			path="/html/enquetenoticia/selector_poll.jsp"
			cssClass="radio-check-search-poll-column"></liferay-ui:search-container-column-jsp>
		<liferay-ui:search-container-column-text name="title" value='<%= aPollsQuestion.getTitle("en_US") %>' />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<portlet:defineObjects />