/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.seatecnologia.cldf.enquetenoticia.service.impl;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.service.base.EnqueteNoticiaLocalServiceBaseImpl;
import br.com.seatecnologia.cldf.enquetenoticia.service.persistence.EnqueteNoticiaUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

/**
 * The implementation of the enquete noticia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Wallacy
 * @see br.com.seatecnologia.cldf.enquetenoticia.service.base.EnqueteNoticiaLocalServiceBaseImpl
 * @see br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil
 */
public class EnqueteNoticiaLocalServiceImpl
	extends EnqueteNoticiaLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil} to access the enquete noticia local service.
	 */
	


	public List<JournalArticle> getNoticiasAssociadas(long questionId,
			int start, int end) throws SystemException, PortalException {
		List<EnqueteNoticia> enquetesAssociadas = EnqueteNoticiaUtil.findByQuestionID(questionId, start, end);
		List<JournalArticle> listaArtigos = new ArrayList<JournalArticle>();
		for (EnqueteNoticia enqueteNoticia : enquetesAssociadas) {
			long articleId = enqueteNoticia.getArticleId();
			JournalArticle article = JournalArticleLocalServiceUtil.getArticle(articleId);
			listaArtigos.add(article);

		}
		return listaArtigos;

	}

	public int countByQuestionId(long questionId) throws SystemException {
		return EnqueteNoticiaUtil.countByQuestionID(questionId);
	}

	public List<JournalArticle> getNoticiasNaoAssociadas(long questionId,
			int start, int end) throws SystemException, PortalException {
		List<EnqueteNoticia> enquetesAssociadas = EnqueteNoticiaUtil.findByQuestionID(questionId, start, end);
		List<Object> listaArtigosAssociados = new ArrayList<Object>();

		for (EnqueteNoticia enqueteNoticia : enquetesAssociadas) {
			long articleId = enqueteNoticia.getArticleId();
			listaArtigosAssociados.add(articleId);
		}

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				JournalArticle.class, PortalClassLoaderUtil.getClassLoader());
		if (!listaArtigosAssociados.isEmpty()) {
			query.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName(
					"id").in(listaArtigosAssociados)));
		}
		@SuppressWarnings("unchecked")
		List<JournalArticle> results = JournalArticleLocalServiceUtil.dynamicQuery(query, start, end);

		return results;

	}
	
	
	public Map<String,Layout> getPaginasPortal() throws SystemException{		
		Map<String,Layout> ListaPaginas = new LinkedHashMap<String,Layout>();
		List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(0, LayoutLocalServiceUtil.getLayoutsCount());
		List<String> ignore = new ArrayList<String>();
		ignore.add("/manage"); // Excluindo painel de controle da lista
		String prefixo = "-";
		montaPaginasPortal(layouts,ListaPaginas,ignore,prefixo);
		
		return ListaPaginas;
	}
	
	private void montaPaginasPortal(List<Layout> layouts,Map<String,Layout> ListaPaginas, List<String> ignore,String prefixo) throws SystemException{
		
		for (Layout layout : layouts){
			if(!ignore.contains(layout.getFriendlyURL())){
				if(!layout.hasChildren()){	
					ListaPaginas.put(prefixo + layout.getName("en_US"), layout);
					ignore.add(layout.getFriendlyURL());//Pode existir mais de um layout mapeado para a mesma url,
														//então cada pagina adiconada é também removida para evitar reinserção na lista
				}else{
					List<Layout> children = layout.getAllChildren();
					ListaPaginas.put(prefixo + layout.getName("en_US"), layout);					
					montaPaginasPortal(children,ListaPaginas,ignore,prefixo + "-");
					ignore.add(layout.getFriendlyURL()); 
				}
			}
		}
	}
	
			
	

}