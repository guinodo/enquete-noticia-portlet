
<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<portlet:defineObjects/>

<portlet:actionURL name='associatePollArticle' var='submitURL'></portlet:actionURL>

<aui:form method='POST' action="<%= submitURL %>">

<% 


  long questionId = ParamUtil.getLong(request, "questionId");
  System.out.println(questionId);
  
  String redirectURL = renderRequest.getParameter("redirect");
  if(redirectURL == null){
	  redirectURL = PortalUtil.getCurrentURL(renderRequest);
  }
	
		
%>

<div id='poll_search_container'>
<c:choose>
<c:when test="<%= questionId == 0 %>">
	<liferay-ui:search-container>
		<liferay-ui:search-container-results
			results="<%= com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil.getPollsQuestions(searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= PollsQuestionLocalServiceUtil.getPollsQuestionsCount() %>"
		/>
	
		<liferay-ui:search-container-row
			className="com.liferay.portlet.polls.model.PollsQuestion"
			modelVar="aPollsQuestion"
			keyProperty="questionId"
		>
			<liferay-ui:search-container-column-jsp path="/html/enquetenoticia/selector_poll.jsp" cssClass="radio-check-search-poll-column"></liferay-ui:search-container-column-jsp>	
			<liferay-ui:search-container-column-text name="title" value='<%= aPollsQuestion.getTitle("en_US") %>' />
		
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
<portlet:defineObjects />
</c:when>
<c:otherwise>
	<aui:input name="questionId" type="hidden" value="<%= questionId %>"></aui:input>
	<aui:input name="redirect" type="hidden" value="<%= redirectURL %>"></aui:input>
	<h2><liferay-ui:message key="noticias-ja-associadas"></liferay-ui:message></h2>
	<liferay-ui:search-container emptyResultsMessage="nenhuma-noticia-associada" >
		<liferay-ui:search-container-results
			results="<%= EnqueteNoticiaLocalServiceUtil.getNoticiasAssociadas(questionId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= EnqueteNoticiaLocalServiceUtil.countByQuestionId(questionId) %>"
		/>
	
		<liferay-ui:search-container-row
			className="com.liferay.portlet.journal.model.JournalArticle"
			modelVar="aJournalArticle"
			keyProperty="articleId"
		>
		<liferay-ui:search-container-column-text property="title" />
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
</c:otherwise>
</c:choose>
</div>

<div id="journalArticle_search_container">
<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil.getJournalArticles(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= JournalArticleLocalServiceUtil.getJournalArticlesCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portlet.journal.model.JournalArticle"
		modelVar="aJournalArticle"
		keyProperty="primaryKey"
	>
	<% System.out.println(aJournalArticle.getPrimaryKey() + " " + aJournalArticle.getArticleId()); %>
		<liferay-ui:search-container-column-jsp path="/html/enquetenoticia/selector_article.jsp" cssClass="radio-check-search-poll-column"></liferay-ui:search-container-column-jsp>
		<liferay-ui:search-container-column-text property="title" />

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</div>
<aui:button type="submit"></aui:button>
</aui:form>