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

package br.com.seatecnologia.cldf.enquetenoticia.service;

/**
 * <p>
 * This class is a wrapper for {@link EnqueteNoticiaLocalService}.
 * </p>
 *
 * @author    Wallacy
 * @see       EnqueteNoticiaLocalService
 * @generated
 */
public class EnqueteNoticiaLocalServiceWrapper
	implements EnqueteNoticiaLocalService {
	public EnqueteNoticiaLocalServiceWrapper(
		EnqueteNoticiaLocalService enqueteNoticiaLocalService) {
		_enqueteNoticiaLocalService = enqueteNoticiaLocalService;
	}

	/**
	* Adds the enquete noticia to the database. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticia the enquete noticia
	* @return the enquete noticia that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia addEnqueteNoticia(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.addEnqueteNoticia(enqueteNoticia);
	}

	/**
	* Creates a new enquete noticia with the primary key. Does not add the enquete noticia to the database.
	*
	* @param enqueteNoticiaId the primary key for the new enquete noticia
	* @return the new enquete noticia
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia createEnqueteNoticia(
		long enqueteNoticiaId) {
		return _enqueteNoticiaLocalService.createEnqueteNoticia(enqueteNoticiaId);
	}

	/**
	* Deletes the enquete noticia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia
	* @throws PortalException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEnqueteNoticia(long enqueteNoticiaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_enqueteNoticiaLocalService.deleteEnqueteNoticia(enqueteNoticiaId);
	}

	/**
	* Deletes the enquete noticia from the database. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticia the enquete noticia
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEnqueteNoticia(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia)
		throws com.liferay.portal.kernel.exception.SystemException {
		_enqueteNoticiaLocalService.deleteEnqueteNoticia(enqueteNoticia);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the enquete noticia with the primary key.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia
	* @return the enquete noticia
	* @throws PortalException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia getEnqueteNoticia(
		long enqueteNoticiaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getEnqueteNoticia(enqueteNoticiaId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the enquete noticias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enquete noticias
	* @param end the upper bound of the range of enquete noticias (not inclusive)
	* @return the range of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> getEnqueteNoticias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getEnqueteNoticias(start, end);
	}

	/**
	* Returns the number of enquete noticias.
	*
	* @return the number of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public int getEnqueteNoticiasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getEnqueteNoticiasCount();
	}

	/**
	* Updates the enquete noticia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticia the enquete noticia
	* @return the enquete noticia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia updateEnqueteNoticia(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.updateEnqueteNoticia(enqueteNoticia);
	}

	/**
	* Updates the enquete noticia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticia the enquete noticia
	* @param merge whether to merge the enquete noticia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the enquete noticia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia updateEnqueteNoticia(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.updateEnqueteNoticia(enqueteNoticia,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _enqueteNoticiaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enqueteNoticiaLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link br.com.seatecnologia.cldf.enquetenoticia.service.EnqueteNoticiaLocalServiceUtil} to access the enquete noticia local service.
	*/
	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNoticiasAssociadas(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getNoticiasAssociadas(questionId,
			start, end);
	}

	public int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.countByQuestionId(questionId);
	}

	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNoticiasNaoAssociadas(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getNoticiasNaoAssociadas(questionId,
			start, end);
	}

	public java.util.Map<java.lang.String, com.liferay.portal.model.Layout> getPaginasPortal()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enqueteNoticiaLocalService.getPaginasPortal();
	}

	public EnqueteNoticiaLocalService getWrappedEnqueteNoticiaLocalService() {
		return _enqueteNoticiaLocalService;
	}

	public void setWrappedEnqueteNoticiaLocalService(
		EnqueteNoticiaLocalService enqueteNoticiaLocalService) {
		_enqueteNoticiaLocalService = enqueteNoticiaLocalService;
	}

	private EnqueteNoticiaLocalService _enqueteNoticiaLocalService;
}