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

package br.com.seatecnologia.cldf.enquetenoticia.service.persistence;

import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the enquete noticia service. This utility wraps {@link EnqueteNoticiaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Wallacy
 * @see EnqueteNoticiaPersistence
 * @see EnqueteNoticiaPersistenceImpl
 * @generated
 */
public class EnqueteNoticiaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EnqueteNoticia enqueteNoticia) {
		getPersistence().clearCache(enqueteNoticia);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EnqueteNoticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnqueteNoticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnqueteNoticia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static EnqueteNoticia remove(EnqueteNoticia enqueteNoticia)
		throws SystemException {
		return getPersistence().remove(enqueteNoticia);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EnqueteNoticia update(EnqueteNoticia enqueteNoticia,
		boolean merge) throws SystemException {
		return getPersistence().update(enqueteNoticia, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EnqueteNoticia update(EnqueteNoticia enqueteNoticia,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(enqueteNoticia, merge, serviceContext);
	}

	/**
	* Caches the enquete noticia in the entity cache if it is enabled.
	*
	* @param enqueteNoticia the enquete noticia to cache
	*/
	public static void cacheResult(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia) {
		getPersistence().cacheResult(enqueteNoticia);
	}

	/**
	* Caches the enquete noticias in the entity cache if it is enabled.
	*
	* @param enqueteNoticias the enquete noticias to cache
	*/
	public static void cacheResult(
		java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> enqueteNoticias) {
		getPersistence().cacheResult(enqueteNoticias);
	}

	/**
	* Creates a new enquete noticia with the primary key. Does not add the enquete noticia to the database.
	*
	* @param enqueteNoticiaId the primary key for the new enquete noticia
	* @return the new enquete noticia
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia create(
		long enqueteNoticiaId) {
		return getPersistence().create(enqueteNoticiaId);
	}

	/**
	* Removes the enquete noticia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to remove
	* @return the enquete noticia that was removed
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia remove(
		long enqueteNoticiaId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enqueteNoticiaId);
	}

	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia updateImpl(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enqueteNoticia, merge);
	}

	/**
	* Finds the enquete noticia with the primary key or throws a {@link br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException} if it could not be found.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to find
	* @return the enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByPrimaryKey(
		long enqueteNoticiaId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enqueteNoticiaId);
	}

	/**
	* Finds the enquete noticia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to find
	* @return the enquete noticia, or <code>null</code> if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByPrimaryKey(
		long enqueteNoticiaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enqueteNoticiaId);
	}

	/**
	* Finds all the enquete noticias where questionId = &#63;.
	*
	* @param questionId the question ID to search with
	* @return the matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionID(questionId);
	}

	/**
	* Finds a range of all the enquete noticias where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID to search with
	* @param start the lower bound of the range of enquete noticias to return
	* @param end the upper bound of the range of enquete noticias to return (not inclusive)
	* @return the range of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionID(questionId, start, end);
	}

	/**
	* Finds an ordered range of all the enquete noticias where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID to search with
	* @param start the lower bound of the range of enquete noticias to return
	* @param end the upper bound of the range of enquete noticias to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionID(questionId, start, end, orderByComparator);
	}

	/**
	* Finds the first enquete noticia in the ordered set where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByQuestionID_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionID_First(questionId, orderByComparator);
	}

	/**
	* Finds the last enquete noticia in the ordered set where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionId the question ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByQuestionID_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionID_Last(questionId, orderByComparator);
	}

	/**
	* Finds the enquete noticias before and after the current enquete noticia in the ordered set where questionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param enqueteNoticiaId the primary key of the current enquete noticia
	* @param questionId the question ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia[] findByQuestionID_PrevAndNext(
		long enqueteNoticiaId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionID_PrevAndNext(enqueteNoticiaId, questionId,
			orderByComparator);
	}

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or throws a {@link br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException} if it could not be found.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByEnqueteNoticiaID(
		long questionId, long articleId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEnqueteNoticiaID(questionId, articleId);
	}

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByEnqueteNoticiaID(
		long questionId, long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEnqueteNoticiaID(questionId, articleId);
	}

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByEnqueteNoticiaID(
		long questionId, long articleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEnqueteNoticiaID(questionId, articleId,
			retrieveFromCache);
	}

	/**
	* Finds all the enquete noticias.
	*
	* @return the enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the enquete noticias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enquete noticias to return
	* @param end the upper bound of the range of enquete noticias to return (not inclusive)
	* @return the range of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the enquete noticias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enquete noticias to return
	* @param end the upper bound of the range of enquete noticias to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enquete noticias where questionId = &#63; from the database.
	*
	* @param questionId the question ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionID(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionID(questionId);
	}

	/**
	* Removes the enquete noticia where questionId = &#63; and articleId = &#63; from the database.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEnqueteNoticiaID(long questionId, long articleId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEnqueteNoticiaID(questionId, articleId);
	}

	/**
	* Removes all the enquete noticias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the enquete noticias where questionId = &#63;.
	*
	* @param questionId the question ID to search with
	* @return the number of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionID(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionID(questionId);
	}

	/**
	* Counts all the enquete noticias where questionId = &#63; and articleId = &#63;.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the number of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEnqueteNoticiaID(long questionId, long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEnqueteNoticiaID(questionId, articleId);
	}

	/**
	* Counts all the enquete noticias.
	*
	* @return the number of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnqueteNoticiaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnqueteNoticiaPersistence)PortletBeanLocatorUtil.locate(br.com.seatecnologia.cldf.enquetenoticia.service.ClpSerializer.getServletContextName(),
					EnqueteNoticiaPersistence.class.getName());

			ReferenceRegistry.registerReference(EnqueteNoticiaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(EnqueteNoticiaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(EnqueteNoticiaUtil.class,
			"_persistence");
	}

	private static EnqueteNoticiaPersistence _persistence;
}