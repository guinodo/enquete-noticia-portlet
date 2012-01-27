package br.com.seatecnologia.cldf.enquetenoticia;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class EnqueteNoticiaPortlet
 */
public class EnqueteNoticiaPortlet extends MVCPortlet {
	
	public void associatePollArticle(ActionRequest request, ActionResponse response) throws SystemException{
		
		String pollId = request.getParameter("pollId");
		System.out.println("PollID: "+ pollId);
		String[] articleIds = request.getParameterValues("articleId");
		
		for (String articleId : articleIds) {
			System.out.println("ArticleID: " + articleId);
			EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();
			enqueteNoticia.setArticleId(Long.parseLong(articleId));
			enqueteNoticia.setPollId(Long.parseLong(pollId));
			enqueteNoticia.setEnqueteNoticiaId(CounterLocalServiceUtil.increment(EnqueteNoticia.class.getName()));
			EnqueteNoticiaLocalServiceUtil.addEnqueteNoticia(enqueteNoticia);
		}
			
		
		
		
	}
	
	
	
 

}
