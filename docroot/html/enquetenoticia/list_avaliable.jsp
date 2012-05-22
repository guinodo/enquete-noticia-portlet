<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<% 


%>

<liferay-ui:error key="nenhum-artigo-selecionado" message="nenhum-artigo-selecionado" />
<aui:form name="fm1" method='POST' action="<%= submitURL %>">
	<liferay-ui:error key="nenhum-artigo-selecionado" message="nenhum-artigo-selecionado"></liferay-ui:error>
	<liferay-ui:error key="nenhum-artigo-selecionado" message="nenhum-artigo-selecionado" />
	<h2><liferay-ui:message key="noticias-disponiveis" /></h2>
	<liferay-ui:search-container emptyResultsMessage="todas-noticias-associadas" curParam="available" iteratorURL="<%= portletURL %>">
		
		
		
		<liferay-ui:search-container-results
			results="<%= EnqueteNoticiaLocalServiceUtil.getNoticiasNaoAssociadas(questionId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= JournalArticleLocalServiceUtil.getJournalArticlesCount() - EnqueteNoticiaLocalServiceUtil.countByQuestionId(questionId) %>" />
		<liferay-ui:search-container-row
			className="com.liferay.portlet.journal.model.JournalArticle"
			modelVar="aJournalArticle" keyProperty="primaryKey">
			<liferay-ui:search-container-column-text cssClass="radio-check-search-poll-column">
				<input type="checkbox" name="<portlet:namespace/>articleId" value="<%= aJournalArticle.getPrimaryKey() %>"></input>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Title">
				<a href="<%= EnqueteNoticiaLocalServiceUtil.getUrlBase() + aJournalArticle.getUrlTitle() %>"><%= aJournalArticle.getTitle() %></a>
			</liferay-ui:search-container-column-text>
			<aui:input name="questionId" type="hidden" value="<%= questionId %>" />
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	<aui:button type="submit"></aui:button>
</aui:form>