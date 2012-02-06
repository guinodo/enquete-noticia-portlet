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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the enquete noticia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Wallacy
 * @see EnqueteNoticiaPersistenceImpl
 * @see EnqueteNoticiaUtil
 * @generated
 */
public interface EnqueteNoticiaPersistence extends BasePersistence<EnqueteNoticia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnqueteNoticiaUtil} to access the enquete noticia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the enquete noticia in the entity cache if it is enabled.
	*
	* @param enqueteNoticia the enquete noticia to cache
	*/
	public void cacheResult(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia);

	/**
	* Caches the enquete noticias in the entity cache if it is enabled.
	*
	* @param enqueteNoticias the enquete noticias to cache
	*/
	public void cacheResult(
		java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> enqueteNoticias);

	/**
	* Creates a new enquete noticia with the primary key. Does not add the enquete noticia to the database.
	*
	* @param enqueteNoticiaId the primary key for the new enquete noticia
	* @return the new enquete noticia
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia create(
		long enqueteNoticiaId);

	/**
	* Removes the enquete noticia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to remove
	* @return the enquete noticia that was removed
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia remove(
		long enqueteNoticiaId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia updateImpl(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the enquete noticia with the primary key or throws a {@link br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException} if it could not be found.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to find
	* @return the enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByPrimaryKey(
		long enqueteNoticiaId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the enquete noticia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enqueteNoticiaId the primary key of the enquete noticia to find
	* @return the enquete noticia, or <code>null</code> if a enquete noticia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByPrimaryKey(
		long enqueteNoticiaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the enquete noticias where questionId = &#63;.
	*
	* @param questionId the question ID to search with
	* @return the matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findByQuestionID(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByQuestionID_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByQuestionID_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia[] findByQuestionID_PrevAndNext(
		long enqueteNoticiaId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or throws a {@link br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException} if it could not be found.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia
	* @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia findByEnqueteNoticiaID(
		long questionId, long articleId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByEnqueteNoticiaID(
		long questionId, long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia fetchByEnqueteNoticiaID(
		long questionId, long articleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the enquete noticias.
	*
	* @return the enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enquete noticias where questionId = &#63; from the database.
	*
	* @param questionId the question ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuestionID(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the enquete noticia where questionId = &#63; and articleId = &#63; from the database.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEnqueteNoticiaID(long questionId, long articleId)
		throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enquete noticias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the enquete noticias where questionId = &#63;.
	*
	* @param questionId the question ID to search with
	* @return the number of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestionID(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the enquete noticias where questionId = &#63; and articleId = &#63;.
	*
	* @param questionId the question ID to search with
	* @param articleId the article ID to search with
	* @return the number of matching enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public int countByEnqueteNoticiaID(long questionId, long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the enquete noticias.
	*
	* @return the number of enquete noticias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public EnqueteNoticia remove(EnqueteNoticia enqueteNoticia)
		throws SystemException;
}