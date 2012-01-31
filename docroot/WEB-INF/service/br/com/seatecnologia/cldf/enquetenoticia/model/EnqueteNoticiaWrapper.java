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

/**
 * <p>
 * This class is a wrapper for {@link EnqueteNoticia}.
 * </p>
 *
 * @author    Wallacy, Adan, Eduardo
 * @see       EnqueteNoticia
 * @generated
 */
public class EnqueteNoticiaWrapper implements EnqueteNoticia {
	public EnqueteNoticiaWrapper(EnqueteNoticia enqueteNoticia) {
		_enqueteNoticia = enqueteNoticia;
	}

	public Class<?> getModelClass() {
		return EnqueteNoticia.class;
	}

	public String getModelClassName() {
		return EnqueteNoticia.class.getName();
	}

	/**
	* Gets the primary key of this enquete noticia.
	*
	* @return the primary key of this enquete noticia
	*/
	public long getPrimaryKey() {
		return _enqueteNoticia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enquete noticia
	*
	* @param primaryKey the primary key of this enquete noticia
	*/
	public void setPrimaryKey(long primaryKey) {
		_enqueteNoticia.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the enquete noticia ID of this enquete noticia.
	*
	* @return the enquete noticia ID of this enquete noticia
	*/
	public long getEnqueteNoticiaId() {
		return _enqueteNoticia.getEnqueteNoticiaId();
	}

	/**
	* Sets the enquete noticia ID of this enquete noticia.
	*
	* @param enqueteNoticiaId the enquete noticia ID of this enquete noticia
	*/
	public void setEnqueteNoticiaId(long enqueteNoticiaId) {
		_enqueteNoticia.setEnqueteNoticiaId(enqueteNoticiaId);
	}

	/**
	* Gets the question ID of this enquete noticia.
	*
	* @return the question ID of this enquete noticia
	*/
	public long getQuestionId() {
		return _enqueteNoticia.getQuestionId();
	}

	/**
	* Sets the question ID of this enquete noticia.
	*
	* @param questionId the question ID of this enquete noticia
	*/
	public void setQuestionId(long questionId) {
		_enqueteNoticia.setQuestionId(questionId);
	}

	/**
	* Gets the article ID of this enquete noticia.
	*
	* @return the article ID of this enquete noticia
	*/
	public long getArticleId() {
		return _enqueteNoticia.getArticleId();
	}

	/**
	* Sets the article ID of this enquete noticia.
	*
	* @param articleId the article ID of this enquete noticia
	*/
	public void setArticleId(long articleId) {
		_enqueteNoticia.setArticleId(articleId);
	}

	public boolean isNew() {
		return _enqueteNoticia.isNew();
	}

	public void setNew(boolean n) {
		_enqueteNoticia.setNew(n);
	}

	public boolean isCachedModel() {
		return _enqueteNoticia.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_enqueteNoticia.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _enqueteNoticia.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_enqueteNoticia.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _enqueteNoticia.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enqueteNoticia.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enqueteNoticia.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enqueteNoticia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnqueteNoticiaWrapper((EnqueteNoticia)_enqueteNoticia.clone());
	}

	public int compareTo(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia) {
		return _enqueteNoticia.compareTo(enqueteNoticia);
	}

	@Override
	public int hashCode() {
		return _enqueteNoticia.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> toCacheModel() {
		return _enqueteNoticia.toCacheModel();
	}

	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia toEscapedModel() {
		return new EnqueteNoticiaWrapper(_enqueteNoticia.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enqueteNoticia.toString();
	}

	public java.lang.String toXmlString() {
		return _enqueteNoticia.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enqueteNoticia.persist();
	}

	public EnqueteNoticia getWrappedEnqueteNoticia() {
		return _enqueteNoticia;
	}

	public void resetOriginalValues() {
		_enqueteNoticia.resetOriginalValues();
	}

	private EnqueteNoticia _enqueteNoticia;
}