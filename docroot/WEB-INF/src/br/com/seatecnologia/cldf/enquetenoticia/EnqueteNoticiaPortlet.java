package br.com.seatecnologia.cldf.enquetenoticia;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;
import br.com.seatecnologia.cldf.enquetenoticia.service.persistence.EnqueteNoticiaUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class EnqueteNoticiaPortlet
 */
public class EnqueteNoticiaPortlet extends MVCPortlet {

	public void associatePollArticle(ActionRequest request,
			ActionResponse response) throws SystemException, IOException {

		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");
		
		if (articleIds.length == 0 || articleIds == null){
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

	public void removeAssociatePollArticle(ActionRequest request,
			ActionResponse response) throws SystemException, IOException,
			NoSuchEnqueteNoticiaException, NumberFormatException {

		String questionId = request.getParameter("questionId");
		String[] articleIds = request.getParameterValues("articleId");
		
		if (articleIds.length == 0 || articleIds == null){
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

}