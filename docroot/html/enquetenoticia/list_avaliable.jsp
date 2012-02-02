<liferay-ui:error key="nenhum-artigo-selecionado" message="nenhum-artigo-selecionado" />

<aui:form method='POST' action="<%= submitURL %>">
	<h2><liferay-ui:message key="noticias-disponiveis" /></h2>
	
	<liferay-ui:search-container
		emptyResultsMessage="todas-noticias-associadas">
		<liferay-ui:search-container-results
			results="<%= EnqueteNoticiaLocalServiceUtil.getNoticiasNaoAssociadas(questionId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= JournalArticleLocalServiceUtil.getJournalArticlesCount() %>" />
		<liferay-ui:search-container-row
			className="com.liferay.portlet.journal.model.JournalArticle"
			modelVar="aJournalArticle" keyProperty="primaryKey">
			<liferay-ui:search-container-column-jsp
				path="/html/enquetenoticia/selector_article.jsp"
				cssClass="radio-check-search-poll-column"></liferay-ui:search-container-column-jsp>
			<liferay-ui:search-container-column-text property="title" />
			
			<aui:input name="questionId" type="hidden" value="<%= questionId %>"></aui:input>
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>"></aui:input>
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:button type="submit"></aui:button>
</aui:form>
