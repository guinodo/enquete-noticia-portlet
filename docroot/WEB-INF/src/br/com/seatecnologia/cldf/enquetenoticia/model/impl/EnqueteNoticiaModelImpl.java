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
import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticiaModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the EnqueteNoticia service. Represents a row in the &quot;EnqueteNoticia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticiaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EnqueteNoticiaImpl}.
 * </p>
 *
 * @author Wallacy, Adan, Eduardo
 * @see EnqueteNoticiaImpl
 * @see br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia
 * @see br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticiaModel
 * @generated
 */
public class EnqueteNoticiaModelImpl extends BaseModelImpl<EnqueteNoticia>
	implements EnqueteNoticiaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a enquete noticia model instance should use the {@link br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia} interface instead.
	 */
	public static final String TABLE_NAME = "EnqueteNoticia";
	public static final Object[][] TABLE_COLUMNS = {
			{ "enqueteNoticiaId", Types.BIGINT },
			{ "questionId", Types.BIGINT },
			{ "articleId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table EnqueteNoticia (enqueteNoticiaId LONG not null primary key,questionId LONG,articleId LONG)";
	public static final String TABLE_SQL_DROP = "drop table EnqueteNoticia";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia"),
			true);

	public Class<?> getModelClass() {
		return EnqueteNoticia.class;
	}

	public String getModelClassName() {
		return EnqueteNoticia.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia"));

	public EnqueteNoticiaModelImpl() {
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
		if (!_setOriginalQuestionId) {
			_setOriginalQuestionId = true;

			_originalQuestionId = _questionId;
		}

		_questionId = questionId;
	}

	public long getOriginalQuestionId() {
		return _originalQuestionId;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		if (!_setOriginalArticleId) {
			_setOriginalArticleId = true;

			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public long getOriginalArticleId() {
		return _originalArticleId;
	}

	@Override
	public EnqueteNoticia toEscapedModel() {
		if (isEscapedModel()) {
			return (EnqueteNoticia)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (EnqueteNoticia)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					EnqueteNoticia.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		EnqueteNoticiaImpl enqueteNoticiaImpl = new EnqueteNoticiaImpl();

		enqueteNoticiaImpl.setEnqueteNoticiaId(getEnqueteNoticiaId());
		enqueteNoticiaImpl.setQuestionId(getQuestionId());
		enqueteNoticiaImpl.setArticleId(getArticleId());

		enqueteNoticiaImpl.resetOriginalValues();

		return enqueteNoticiaImpl;
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

		EnqueteNoticia enqueteNoticia = null;

		try {
			enqueteNoticia = (EnqueteNoticia)obj;
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
	public void resetOriginalValues() {
		EnqueteNoticiaModelImpl enqueteNoticiaModelImpl = this;

		enqueteNoticiaModelImpl._originalQuestionId = enqueteNoticiaModelImpl._questionId;

		enqueteNoticiaModelImpl._setOriginalQuestionId = false;

		enqueteNoticiaModelImpl._originalArticleId = enqueteNoticiaModelImpl._articleId;

		enqueteNoticiaModelImpl._setOriginalArticleId = false;
	}

	@Override
	public CacheModel<EnqueteNoticia> toCacheModel() {
		EnqueteNoticiaCacheModel enqueteNoticiaCacheModel = new EnqueteNoticiaCacheModel();

		enqueteNoticiaCacheModel.enqueteNoticiaId = getEnqueteNoticiaId();

		enqueteNoticiaCacheModel.questionId = getQuestionId();

		enqueteNoticiaCacheModel.articleId = getArticleId();

		return enqueteNoticiaCacheModel;
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

	private static ClassLoader _classLoader = EnqueteNoticia.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			EnqueteNoticia.class
		};
	private long _enqueteNoticiaId;
	private long _questionId;
	private long _originalQuestionId;
	private boolean _setOriginalQuestionId;
	private long _articleId;
	private long _originalArticleId;
	private boolean _setOriginalArticleId;
	private transient ExpandoBridge _expandoBridge;
	private EnqueteNoticia _escapedModelProxy;
}