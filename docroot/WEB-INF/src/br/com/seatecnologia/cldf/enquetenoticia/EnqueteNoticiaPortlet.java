package br.com.seatecnologia.cldf.enquetenoticia;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;
import br.com.seatecnologia.cldf.enquetenoticia.service.persistence.EnqueteNoticiaUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class EnqueteNoticia
 */
public class EnqueteNoticiaPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		String available = ParamUtil.getString(renderRequest, "available");
		System.out.println("available: "+available);
		String delta = ParamUtil.getString(renderRequest, "deltaavailable");
		
		if ((available != "") || (delta != "") ) {
			renderRequest.setAttribute("tabs1", "available");
		}
		
		
		super.doView(renderRequest, renderResponse);
	}
	public void associateQuestionArticle(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		System.out.println("passou no associateQuestionArticle");
		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");
//		if (articleIds.length == 0 || articleIds == null) {
//			SessionErrors.add(request, "nenhum-artigo-selecionado");
//			sendRedirect(request, response);
//		}
//		for (String articleId : articleIds) {
//			EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();
//			enqueteNoticia.setArticleId(Long.parseLong(articleId));
//			enqueteNoticia.setQuestionId(Long.parseLong(questionId));
//			enqueteNoticia.setEnqueteNoticiaId(CounterLocalServiceUtil.increment(EnqueteNoticia.class.getName()));
//			EnqueteNoticiaLocalServiceUtil.addEnqueteNoticia(enqueteNoticia);
//		}
		
		
		try {
			for (String articleId : articleIds) {
				EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();
				enqueteNoticia.setArticleId(Long.parseLong(articleId));
				enqueteNoticia.setQuestionId(Long.parseLong(questionId));
				enqueteNoticia.setEnqueteNoticiaId(CounterLocalServiceUtil.increment(EnqueteNoticia.class.getName()));
				EnqueteNoticiaLocalServiceUtil.addEnqueteNoticia(enqueteNoticia);
			}
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "nenhum-artigo-selecionado");
		}
		
		
		sendRedirect(request, response);
	}
	public void removeAssociateQuestionArticle(ActionRequest request, ActionResponse response) throws SystemException, IOException, NoSuchEnqueteNoticiaException, NumberFormatException {
		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");
		if (articleIds.length == 0 || articleIds == null) {
			SessionErrors.add(request, "nenhum-artigo-selecionado");
			sendRedirect(request, response);
		}
		for (String articleId : articleIds) {
			EnqueteNoticia enqueteNoticia = EnqueteNoticiaUtil.findByEnqueteNoticiaID(Long.parseLong(questionId), Long.parseLong(articleId));
			EnqueteNoticiaLocalServiceUtil.deleteEnqueteNoticia(enqueteNoticia);
		}
		sendRedirect(request, response);
	}	
	public void salvarPreferencias(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException{	
		String paginaPreference = actionRequest.getParameter("paginaPreference");
		String portletPreference = actionRequest.getParameter("portletPreference");	
		Properties paginaProp = new Properties(); 
		paginaProp.load(new StringReader(paginaPreference.substring(1, paginaPreference.length() - 1).replace(", ", "\n")));
		paginaPreference = paginaProp.getProperty("paginaURL");
		Properties rewrite = new Properties(paginaProp);
		if(paginaPreference != null)
			rewrite.setProperty("paginaPreference", paginaPreference);
		if(portletPreference != null)
			rewrite.setProperty("portletPreference", portletPreference);
		rewrite.store(new FileOutputStream("enquete-noticia.properties"), null);
				
	} 	
}