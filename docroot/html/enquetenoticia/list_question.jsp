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
	<liferay-ui:search-container-column-text>
	<!-- Exibindo Enquetes formatadas -->
		<table class="lista_enquete">
			<tr>
				<td>
				<h1><%= aPollsQuestion.getTitle("en_US") %></h1>
					<ol class="resultado" style="list-style-type:lower-alpha">
					<% 
					List<PollsChoice> pollChoices = aPollsQuestion.getChoices();				
					for (PollsChoice pollChoice : pollChoices){ %>					
						<li><%= pollChoice.getDescription() %><span id="<%= pollChoice.getName() %>" style="width:<%= pollChoice.getVotesCount()/aPollsQuestion.getVotesCount()*80 %>%; background-color:#FF0000;">&nbsp;<%= pollChoice.getVotesCount() %>&nbsp;</span><span><%= pollChoice.getVotesCount()/aPollsQuestion.getVotesCount()*100 %> %</span></li>						
					<%
					}
					%>
				</ol>
				<div>
					<span><h6>Data de Criação</h6> <%= aPollsQuestion.getCreateDate() %></span><span><h6>Último voto</h6><%= aPollsQuestion.getLastVoteDate() %></span>
					<div><h5>Descrição</h5><h6><%= aPollsQuestion.getDescription() %></h6></div>
				</div>
				</td>
			</tr>
		</table>
	<!-- Fim  Exibindo Enquetes formatadas-->
	</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>