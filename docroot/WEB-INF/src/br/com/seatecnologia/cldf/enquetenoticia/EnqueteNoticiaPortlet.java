package br.com.seatecnologia.cldf.enquetenoticia;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class EnqueteNoticiaPortlet
 */
public class EnqueteNoticiaPortlet extends MVCPortlet {
	
	public void associatePollArticle(ActionRequest request, ActionResponse response) throws SystemException, IOException{
		
		String questionId = request.getParameter("questionId");
		System.out.println("Question ID: "+ questionId);
		String[] articleIds = request.getParameterValues("articleId");
		
		for (String articleId : articleIds) {
			System.out.println("Article ID: " + articleId);
			EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();
			enqueteNoticia.setArticleId(Long.parseLong(articleId));
			enqueteNoticia.setQuestionId(Long.parseLong(questionId));
			enqueteNoticia.setEnqueteNoticiaId(CounterLocalServiceUtil.increment(EnqueteNoticia.class.getName()));
			EnqueteNoticiaLocalServiceUtil.addEnqueteNoticia(enqueteNoticia);
			
			sendRedirect(request, response);
		}
			
		
		
		
	}
	
	
	
 

}
