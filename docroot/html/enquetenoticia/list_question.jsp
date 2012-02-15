<%@page import="com.liferay.portlet.polls.model.PollsChoice"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


 <liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= PollsQuestionLocalServiceUtil.getPollsQuestions(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PollsQuestionLocalServiceUtil.getPollsQuestionsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portlet.polls.model.PollsQuestion"
		modelVar="aPollsQuestion"
	>
		<liferay-ui:search-container-column-text name="title">
			<%= aPollsQuestion.getTitle("en_US") %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="description"/>
		
		<liferay-ui:search-container-column-text name="choices">
			<% 
				List<PollsChoice> pollChoices = aPollsQuestion.getChoices();
				
				for (PollsChoice pollChoice : pollChoices){ %>
					<ul>
						<li><% out.println(pollChoice.getName()); %></li>
						<ul>
							<li><% out.println(pollChoice.getDescription()); %></li>
							<li><% out.println(pollChoice.getVotesCount()); %></li>
						</ul>
					</ul>
			<%
			}
			%>
		</liferay-ui:search-container-column-text>
	


		<liferay-ui:search-container-column-text property="lastVoteDate" />

		<liferay-ui:search-container-column-text property="createDate" />

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>