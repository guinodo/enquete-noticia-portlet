<%@page import="br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:actionURL name='listarPartlets' var='submitURL'></portlet:actionURL>

<% out.println(EnqueteNoticiaLocalServiceUtil.getPaginasPortal()); %>