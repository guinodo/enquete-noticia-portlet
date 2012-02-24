<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@page import="java.text.DateFormat"%>
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
				<h1><%= aPollsQuestion.getTitle(Locale.getDefault()) %></h1>
					<ol class="resultado" style="list-style-type:lower-alpha">
					<% 
					List<PollsChoice> pollChoices = aPollsQuestion.getChoices();				
					for (PollsChoice pollChoice : pollChoices){ 
						int totalVotos = aPollsQuestion.getVotesCount();
						if(totalVotos == 0)
							totalVotos = 1;
					%>					
						<li><p><%= pollChoice.getDescription() %>&nbsp;<span id="<%= pollChoice.getName() %>" style="width:<%= 3 + pollChoice.getVotesCount()/totalVotos*70 %>%; background-color:#FF0000;display:inline-block;">&nbsp;<%= pollChoice.getVotesCount() %>&nbsp;</span><span>&nbsp;<%= pollChoice.getVotesCount()/totalVotos*100 %> %</span></p></li>						
					<%
					}
					%>
				</ol>
				<div>
					<span><strong>Criado em:&nbsp;</strong><%= DateFormat.getDateTimeInstance().format(aPollsQuestion.getCreateDate()) %></span>&nbsp;<span><strong>Último voto:&nbsp;</strong><%= DateFormat.getDateTimeInstance().format(aPollsQuestion.getLastVoteDate()) %></span>
					<h5>Descrição:</h5><span style="margin-left:1em"><%= aPollsQuestion.getDescription() %></span>
				</div>
				<div>
					<%  List<JournalArticle> articles = EnqueteNoticiaLocalServiceUtil.getNoticiasAssociadas(aPollsQuestion.getQuestionId(), 0, EnqueteNoticiaLocalServiceUtil.countByQuestionId(aPollsQuestion.getQuestionId())); %>
					<h5>Leia sobre:</h5>
					<ul>
						<% for (JournalArticle article : articles){ %>
							<li><a href="<%= EnqueteNoticiaLocalServiceUtil.getUrlBase() + article.getUrlTitle() %>"><%= article.getTitle() %></a><br></li>
						<% } %>
					</ul>
				</div>
				</td>
			</tr>
		</table>
	<!-- Fim  Exibindo Enquetes formatadas-->
	</liferay-ui:search-container-column-text>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>