<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ include file="/html/portlet/polls_display/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%


String redirect = StringPool.BLANK;

PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeys.POLLS_QUESTION);

question = question.toEscapedModel();

List<PollsChoice> choices = question.getChoices();

boolean hasVoted = PollsUtil.hasVoted(request, question.getQuestionId());

if (!question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE)) {
	String cmd = ParamUtil.getString(request, Constants.CMD);

	if (cmd.equals(Constants.ADD)) {
		long choiceId = ParamUtil.getLong(request, "choiceId");

		try {
			PollsVoteServiceUtil.addVote(question.getQuestionId(), choiceId, new ServiceContext());

			SessionMessages.add(renderRequest, "vote_added");

			PollsUtil.saveVote(request, question.getQuestionId());

			hasVoted = true;
		}
		catch (DuplicateVoteException dve) {
			SessionErrors.add(renderRequest, dve.getClass().getName());
		}
		catch (NoSuchChoiceException nsce) {
			SessionErrors.add(renderRequest, nsce.getClass().getName());
		}
		catch (QuestionExpiredException qee) {
		}
	}
}

List<JournalArticle> articles = EnqueteNoticiaLocalServiceUtil.getNoticiasAssociadas(question.getQuestionId(), 0, EnqueteNoticiaLocalServiceUtil.countByQuestionId(question.getQuestionId()));

%>

<portlet:renderURL var="viewPollURL">
	<portlet:param name="struts_action" value="/polls_display/view" />
</portlet:renderURL>

<aui:form action="<%= viewPollURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />

	<liferay-ui:success key="vote_added" message="thank-you-for-your-vote" />

	<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
	<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />

	<%= StringUtil.replace(HtmlUtil.escape(question.getDescription(locale)), StringPool.NEW_LINE, "<br />") %>

	<br /><br />

	<c:choose>
		<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
			<aui:fieldset>
				<aui:field-wrapper>

					<%
					for (PollsChoice choice : choices) {
						choice = choice.toEscapedModel();
					%>

						<aui:input inlineLabel="left" label='<%= "<strong>" + choice.getName() + ".</strong> " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" />

					<%
					}
					%>

				</aui:field-wrapper>

				<aui:button type="submit" value="vote" />
			</aui:fieldset>
		</c:when>
		<c:otherwise>
			<%@ include file="/html/portlet/polls/view_question_results.jspf" %>
		</c:otherwise>
	</c:choose>
</aui:form>

<h5><liferay-ui:message key="nenhuma-noticia-associada"/>:</h5>
<ul>
<% for (JournalArticle article : articles){ %>
	<li><a href="<%= EnqueteNoticiaLocalServiceUtil.getUrlBase() + article.getUrlTitle() %>"><%= article.getTitle() %></a><br></li>
<% } %>
</ul>