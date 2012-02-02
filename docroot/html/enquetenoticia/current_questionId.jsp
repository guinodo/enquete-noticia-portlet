<aui:input name="questionId" type="hidden" value="<%= questionId %>"></aui:input>
<aui:input name="redirect" type="hidden"
	value="<%= PortalUtil.getCurrentURL(renderRequest) %>"></aui:input>

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
		<liferay-ui:search-container-column-jsp
			path="/html/enquetenoticia/selector_article.jsp"
			cssClass="radio-check-search-poll-column"></liferay-ui:search-container-column-jsp>
		<liferay-ui:search-container-column-text property="title" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>