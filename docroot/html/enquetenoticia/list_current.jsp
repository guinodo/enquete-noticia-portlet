<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<liferay-ui:error key="nenhum-artigo-selecionado" message="nenhum-artigo-selecionado" />
<aui:input name="questionId" type="hidden" value="<%= questionId %>"></aui:input>
<aui:input name="redirect" type="hidden" value="<%= currentURL %>"></aui:input>
<h2>
	<liferay-ui:message key="noticias-ja-associadas"></liferay-ui:message>
</h2>
<liferay-ui:search-container
	emptyResultsMessage="nenhuma-noticia-associada">
	<liferay-ui:search-container-results
		results="<%= EnqueteNoticiaLocalServiceUtil.getNoticiasAssociadas(questionId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= EnqueteNoticiaLocalServiceUtil.countByQuestionId(questionId) %>" />

	<liferay-ui:search-container-row
		className="com.liferay.portlet.journal.model.JournalArticle"
		modelVar="aJournalArticle" keyProperty="articleId">
		<liferay-ui:search-container-column-text cssClass="radio-check-search-poll-column">
				<input type="checkbox" name="<portlet:namespace/>articleId" value="<%= aJournalArticle.getPrimaryKey() %>"></input>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Title">
			<a href="<%= EnqueteNoticiaLocalServiceUtil.getUrlBase() + aJournalArticle.getUrlTitle() %>"><%= aJournalArticle.getTitle() %></a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>