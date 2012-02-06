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

package br.com.seatecnologia.cldf.enquetenoticia.model.impl;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

/**
 * The cache model class for representing EnqueteNoticia in entity cache.
 *
 * @author Wallacy
 * @see EnqueteNoticia
 * @generated
 */
public class EnqueteNoticiaCacheModel implements CacheModel<EnqueteNoticia> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{enqueteNoticiaId=");
		sb.append(enqueteNoticiaId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append("}");

		return sb.toString();
	}

	public EnqueteNoticia toEntityModel() {
		EnqueteNoticiaImpl enqueteNoticiaImpl = new EnqueteNoticiaImpl();

		enqueteNoticiaImpl.setEnqueteNoticiaId(enqueteNoticiaId);
		enqueteNoticiaImpl.setQuestionId(questionId);
		enqueteNoticiaImpl.setArticleId(articleId);

		enqueteNoticiaImpl.resetOriginalValues();

		return enqueteNoticiaImpl;
	}

	public long enqueteNoticiaId;
	public long questionId;
	public long articleId;
}