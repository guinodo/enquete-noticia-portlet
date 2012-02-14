package br.com.seatecnologia.cldf.enquetenoticia;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;
import br.com.seatecnologia.cldf.enquetenoticia.service.persistence.EnqueteNoticiaUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

/**
 * Portlet implementation class EnqueteNoticia
 */
public class EnqueteNoticiaPortlet extends MVCPortlet {

	public void associateQuestionArticle(ActionRequest request,
			ActionResponse response) throws SystemException, IOException {

		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");

		if (articleIds.length == 0 || articleIds == null) {
			SessionErrors.add(request, "nenhum-artigo-selecionado");
			sendRedirect(request, response);

		}

		for (String articleId : articleIds) {

			EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();
			enqueteNoticia.setArticleId(Long.parseLong(articleId));
			enqueteNoticia.setQuestionId(Long.parseLong(questionId));
			enqueteNoticia.setEnqueteNoticiaId(CounterLocalServiceUtil.increment(EnqueteNoticia.class.getName()));
			EnqueteNoticiaLocalServiceUtil.addEnqueteNoticia(enqueteNoticia);

		}
		sendRedirect(request, response);

	}

	public void removeAssociateQuestionArticle(ActionRequest request,
			ActionResponse response) throws SystemException, IOException,
			NoSuchEnqueteNoticiaException, NumberFormatException {

		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");

		if (articleIds.length == 0 || articleIds == null) {
			SessionErrors.add(request, "nenhum-artigo-selecionado");
			sendRedirect(request, response);

		}

		for (String articleId : articleIds) {

			EnqueteNoticia enqueteNoticia = EnqueteNoticiaUtil.findByEnqueteNoticiaID(Long.parseLong(questionId),
							Long.parseLong(articleId));
			EnqueteNoticiaLocalServiceUtil.deleteEnqueteNoticia(enqueteNoticia);

		}

		sendRedirect(request, response);

	}
	
	public void salvarPreferencias(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException{
		
		
		String viewPreference = actionRequest.getParameter("viewPreference");
		String paginaPreference = actionRequest.getParameter("paginaPreference");
		String portletPreference = actionRequest.getParameter("portletPreference");
		
		Properties paginaProp = new Properties(); 
		paginaProp.load(new StringReader(paginaPreference.substring(1, paginaPreference.length() - 1).replace(", ", "\n")));
		paginaPreference = paginaProp.getProperty("paginaURL");
		
		PortletPreferences preferences = actionRequest.getPreferences();
		if(viewPreference != null)
			preferences.setValue("viewPreference", viewPreference);
		if(paginaPreference != null)
			preferences.setValue("paginaPreference", paginaPreference);
		if(portletPreference != null)
			preferences.setValue("portletPreference", portletPreference);			
		preferences.store();

		PortletProps.set("paginaPreference", paginaPreference);
		PortletProps.set("portletPreference", portletPreference);		
	
	} 

	
}