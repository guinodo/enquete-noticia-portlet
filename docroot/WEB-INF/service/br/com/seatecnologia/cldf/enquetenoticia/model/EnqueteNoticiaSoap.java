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

package br.com.seatecnologia.cldf.enquetenoticia.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Wallacy, Adan, Eduardo
 * @generated
 */
public class EnqueteNoticiaSoap implements Serializable {
	public static EnqueteNoticiaSoap toSoapModel(EnqueteNoticia model) {
		EnqueteNoticiaSoap soapModel = new EnqueteNoticiaSoap();

		soapModel.setEnqueteNoticiaId(model.getEnqueteNoticiaId());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setArticleId(model.getArticleId());

		return soapModel;
	}

	public static EnqueteNoticiaSoap[] toSoapModels(EnqueteNoticia[] models) {
		EnqueteNoticiaSoap[] soapModels = new EnqueteNoticiaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnqueteNoticiaSoap[][] toSoapModels(EnqueteNoticia[][] models) {
		EnqueteNoticiaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnqueteNoticiaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnqueteNoticiaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnqueteNoticiaSoap[] toSoapModels(List<EnqueteNoticia> models) {
		List<EnqueteNoticiaSoap> soapModels = new ArrayList<EnqueteNoticiaSoap>(models.size());

		for (EnqueteNoticia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnqueteNoticiaSoap[soapModels.size()]);
	}

	public EnqueteNoticiaSoap() {
	}

	public long getPrimaryKey() {
		return _enqueteNoticiaId;
	}

	public void setPrimaryKey(long pk) {
		setEnqueteNoticiaId(pk);
	}

	public long getEnqueteNoticiaId() {
		return _enqueteNoticiaId;
	}

	public void setEnqueteNoticiaId(long enqueteNoticiaId) {
		_enqueteNoticiaId = enqueteNoticiaId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	private long _enqueteNoticiaId;
	private long _questionId;
	private long _articleId;
}