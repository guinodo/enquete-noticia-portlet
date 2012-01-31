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

import br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Wallacy, Adan, Eduardo
 */
public class EnqueteNoticiaClp extends BaseModelImpl<EnqueteNoticia>
	implements EnqueteNoticia {
	public EnqueteNoticiaClp() {
	}

	public Class<?> getModelClass() {
		return EnqueteNoticia.class;
	}

	public String getModelClassName() {
		return EnqueteNoticia.class.getName();
	}

	public long getPrimaryKey() {
		return _enqueteNoticiaId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEnqueteNoticiaId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_enqueteNoticiaId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		EnqueteNoticiaLocalServiceUtil.updateEnqueteNoticia(this);
	}

	@Override
	public EnqueteNoticia toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (EnqueteNoticia)Proxy.newProxyInstance(EnqueteNoticia.class.getClassLoader(),
				new Class[] { EnqueteNoticia.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		EnqueteNoticiaClp clone = new EnqueteNoticiaClp();

		clone.setEnqueteNoticiaId(getEnqueteNoticiaId());
		clone.setQuestionId(getQuestionId());
		clone.setArticleId(getArticleId());

		return clone;
	}

	public int compareTo(EnqueteNoticia enqueteNoticia) {
		long primaryKey = enqueteNoticia.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EnqueteNoticiaClp enqueteNoticia = null;

		try {
			enqueteNoticia = (EnqueteNoticiaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = enqueteNoticia.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{enqueteNoticiaId=");
		sb.append(getEnqueteNoticiaId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>enqueteNoticiaId</column-name><column-value><![CDATA[");
		sb.append(getEnqueteNoticiaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _enqueteNoticiaId;
	private long _questionId;
	private long _articleId;
}