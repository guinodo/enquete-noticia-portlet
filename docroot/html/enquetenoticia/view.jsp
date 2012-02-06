<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<portlet:actionURL name='associateQuestionArticle' var='submitURL'></portlet:actionURL>
<portlet:actionURL name='removeAssociateQuestionArticle' var='removeURL'></portlet:actionURL>


<%
	long questionId = ParamUtil.getLong(request, "questionId");
	String questionTitle = ParamUtil.getString(request, "questionTitle");

	String currentTitle = "Exibindo as Noticias associadas a enquete: " + questionTitle;
	String avaliableTitle = "Exibindo as Noticias disponiveis para a enquete:" + questionTitle;

	String redirectURL = renderRequest.getParameter("redirect");
	String currentURL = PortalUtil.getCurrentURL(renderRequest);

	if (redirectURL == null) {
		redirectURL = PortalUtil.getCurrentURL(renderRequest);
	}
%>

<liferay-ui:tabs names="current,available" refresh="<%= false %>">

	<!-- Artigos Associados -->


	<liferay-ui:section>
		<div id='poll_search_container'>
			<liferay-ui:header backURL="<%= redirectURL %>"
				localizeTitle="<%= false %>" title="<%= currentTitle %>" />

			<aui:form name="fm" method='POST' action="<%= removeURL %>">

				<liferay-ui:error key="nenhum-artigo-selecionado"
					message="nenhum-artigo-selecionado"></liferay-ui:error>
				<c:choose>
					<c:when test="<%= questionId == 0 %>">
						<%@ include file="/html/enquetenoticia/list_question.jsp" %>
					</c:when>
					<c:otherwise>
						<%@ include file="/html/enquetenoticia/list_current.jsp" %>
					</c:otherwise>
				</c:choose>
				<aui:button type="submit" value='remove'></aui:button>
			</aui:form>
		</div>

	</liferay-ui:section>

	<liferay-ui:section>

		<!-- Artigos Disponiveis -->
		<div id="journalArticle_search_container">
			<liferay-ui:header backURL="<%= redirectURL %>"
				title="<%= avaliableTitle %>" />
			<%@ include file="/html/enquetenoticia/list_avaliable.jsp" %>
		</div>
	</liferay-ui:section>
</liferay-ui:tabs>