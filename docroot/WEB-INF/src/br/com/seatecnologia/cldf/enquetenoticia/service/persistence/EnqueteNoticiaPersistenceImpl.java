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

import br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException;
import br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaImpl;
import br.com.seatecnologia.cldf.enquetenoticia.model.impl.EnqueteNoticiaModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the enquete noticia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Wallacy
 * @see EnqueteNoticiaPersistence
 * @see EnqueteNoticiaUtil
 * @generated
 */
public class EnqueteNoticiaPersistenceImpl extends BasePersistenceImpl<EnqueteNoticia>
	implements EnqueteNoticiaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnqueteNoticiaUtil} to access the enquete noticia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnqueteNoticiaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_QUESTIONID = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, FINDER_CLASS_NAME_LIST,
			"findByQuestionID",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByQuestionID",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_ENQUETENOTICIAID = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEnqueteNoticiaID",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_ENQUETENOTICIAID = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByEnqueteNoticiaID",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, FINDER_CLASS_NAME_LIST, "findAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the enquete noticia in the entity cache if it is enabled.
	 *
	 * @param enqueteNoticia the enquete noticia to cache
	 */
	public void cacheResult(EnqueteNoticia enqueteNoticia) {
		EntityCacheUtil.putResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, enqueteNoticia.getPrimaryKey(),
			enqueteNoticia);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
			new Object[] {
				Long.valueOf(enqueteNoticia.getQuestionId()),
				Long.valueOf(enqueteNoticia.getArticleId())
			}, enqueteNoticia);

		enqueteNoticia.resetOriginalValues();
	}

	/**
	 * Caches the enquete noticias in the entity cache if it is enabled.
	 *
	 * @param enqueteNoticias the enquete noticias to cache
	 */
	public void cacheResult(List<EnqueteNoticia> enqueteNoticias) {
		for (EnqueteNoticia enqueteNoticia : enqueteNoticias) {
			if (EntityCacheUtil.getResult(
						EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
						EnqueteNoticiaImpl.class,
						enqueteNoticia.getPrimaryKey(), this) == null) {
				cacheResult(enqueteNoticia);
			}
		}
	}

	/**
	 * Clears the cache for all enquete noticias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnqueteNoticiaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnqueteNoticiaImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the enquete noticia.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnqueteNoticia enqueteNoticia) {
		EntityCacheUtil.removeResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, enqueteNoticia.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
			new Object[] {
				Long.valueOf(enqueteNoticia.getQuestionId()),
				Long.valueOf(enqueteNoticia.getArticleId())
			});
	}

	/**
	 * Creates a new enquete noticia with the primary key. Does not add the enquete noticia to the database.
	 *
	 * @param enqueteNoticiaId the primary key for the new enquete noticia
	 * @return the new enquete noticia
	 */
	public EnqueteNoticia create(long enqueteNoticiaId) {
		EnqueteNoticia enqueteNoticia = new EnqueteNoticiaImpl();

		enqueteNoticia.setNew(true);
		enqueteNoticia.setPrimaryKey(enqueteNoticiaId);

		return enqueteNoticia;
	}

	/**
	 * Removes the enquete noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enquete noticia to remove
	 * @return the enquete noticia that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnqueteNoticia remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the enquete noticia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enqueteNoticiaId the primary key of the enquete noticia to remove
	 * @return the enquete noticia that was removed
	 * @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnqueteNoticia remove(long enqueteNoticiaId)
		throws NoSuchEnqueteNoticiaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnqueteNoticia enqueteNoticia = (EnqueteNoticia)session.get(EnqueteNoticiaImpl.class,
					Long.valueOf(enqueteNoticiaId));

			if (enqueteNoticia == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						enqueteNoticiaId);
				}

				throw new NoSuchEnqueteNoticiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					enqueteNoticiaId);
			}

			return enqueteNoticiaPersistence.remove(enqueteNoticia);
		}
		catch (NoSuchEnqueteNoticiaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the enquete noticia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enqueteNoticia the enquete noticia to remove
	 * @return the enquete noticia that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnqueteNoticia remove(EnqueteNoticia enqueteNoticia)
		throws SystemException {
		return super.remove(enqueteNoticia);
	}

	@Override
	protected EnqueteNoticia removeImpl(EnqueteNoticia enqueteNoticia)
		throws SystemException {
		enqueteNoticia = toUnwrappedModel(enqueteNoticia);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, enqueteNoticia);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EnqueteNoticiaModelImpl enqueteNoticiaModelImpl = (EnqueteNoticiaModelImpl)enqueteNoticia;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
			new Object[] {
				Long.valueOf(enqueteNoticiaModelImpl.getQuestionId()),
				Long.valueOf(enqueteNoticiaModelImpl.getArticleId())
			});

		EntityCacheUtil.removeResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, enqueteNoticia.getPrimaryKey());

		return enqueteNoticia;
	}

	@Override
	public EnqueteNoticia updateImpl(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia,
		boolean merge) throws SystemException {
		enqueteNoticia = toUnwrappedModel(enqueteNoticia);

		boolean isNew = enqueteNoticia.isNew();

		EnqueteNoticiaModelImpl enqueteNoticiaModelImpl = (EnqueteNoticiaModelImpl)enqueteNoticia;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, enqueteNoticia, merge);

			enqueteNoticia.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, enqueteNoticia.getPrimaryKey(),
			enqueteNoticia);

		if (!isNew &&
				((enqueteNoticia.getQuestionId() != enqueteNoticiaModelImpl.getOriginalQuestionId()) ||
				(enqueteNoticia.getArticleId() != enqueteNoticiaModelImpl.getOriginalArticleId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
				new Object[] {
					Long.valueOf(
						enqueteNoticiaModelImpl.getOriginalQuestionId()),
					Long.valueOf(enqueteNoticiaModelImpl.getOriginalArticleId())
				});
		}

		if (isNew ||
				((enqueteNoticia.getQuestionId() != enqueteNoticiaModelImpl.getOriginalQuestionId()) ||
				(enqueteNoticia.getArticleId() != enqueteNoticiaModelImpl.getOriginalArticleId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
				new Object[] {
					Long.valueOf(enqueteNoticia.getQuestionId()),
					Long.valueOf(enqueteNoticia.getArticleId())
				}, enqueteNoticia);
		}

		return enqueteNoticia;
	}

	protected EnqueteNoticia toUnwrappedModel(EnqueteNoticia enqueteNoticia) {
		if (enqueteNoticia instanceof EnqueteNoticiaImpl) {
			return enqueteNoticia;
		}

		EnqueteNoticiaImpl enqueteNoticiaImpl = new EnqueteNoticiaImpl();

		enqueteNoticiaImpl.setNew(enqueteNoticia.isNew());
		enqueteNoticiaImpl.setPrimaryKey(enqueteNoticia.getPrimaryKey());

		enqueteNoticiaImpl.setEnqueteNoticiaId(enqueteNoticia.getEnqueteNoticiaId());
		enqueteNoticiaImpl.setQuestionId(enqueteNoticia.getQuestionId());
		enqueteNoticiaImpl.setArticleId(enqueteNoticia.getArticleId());

		return enqueteNoticiaImpl;
	}

	/**
	 * Finds the enquete noticia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enquete noticia to find
	 * @return the enquete noticia
	 * @throws com.liferay.portal.NoSuchModelException if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnqueteNoticia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the enquete noticia with the primary key or throws a {@link br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException} if it could not be found.
	 *
	 * @param enqueteNoticiaId the primary key of the enquete noticia to find
	 * @return the enquete noticia
	 * @throws br.com.seatecnologia.cldf.enquetenoticia.NoSuchEnqueteNoticiaException if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnqueteNoticia findByPrimaryKey(long enqueteNoticiaId)
		throws NoSuchEnqueteNoticiaException, SystemException {
		EnqueteNoticia enqueteNoticia = fetchByPrimaryKey(enqueteNoticiaId);

		if (enqueteNoticia == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + enqueteNoticiaId);
			}

			throw new NoSuchEnqueteNoticiaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				enqueteNoticiaId);
		}

		return enqueteNoticia;
	}

	/**
	 * Finds the enquete noticia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enquete noticia to find
	 * @return the enquete noticia, or <code>null</code> if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnqueteNoticia fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the enquete noticia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enqueteNoticiaId the primary key of the enquete noticia to find
	 * @return the enquete noticia, or <code>null</code> if a enquete noticia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnqueteNoticia fetchByPrimaryKey(long enqueteNoticiaId)
		throws SystemException {
		EnqueteNoticia enqueteNoticia = (EnqueteNoticia)EntityCacheUtil.getResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
				EnqueteNoticiaImpl.class, enqueteNoticiaId, this);

		if (enqueteNoticia == _nullEnqueteNoticia) {
			return null;
		}

		if (enqueteNoticia == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				enqueteNoticia = (EnqueteNoticia)session.get(EnqueteNoticiaImpl.class,
						Long.valueOf(enqueteNoticiaId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (enqueteNoticia != null) {
					cacheResult(enqueteNoticia);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
						EnqueteNoticiaImpl.class, enqueteNoticiaId,
						_nullEnqueteNoticia);
				}

				closeSession(session);
			}
		}

		return enqueteNoticia;
	}

	/**
	 * Finds all the enquete noticias where questionId = &#63;.
	 *
	 * @param questionId the question ID to search with
	 * @return the matching enquete noticias
	 * @throws SystemException if a system exception occurred
	 */
	public List<EnqueteNoticia> findByQuestionID(long questionId)
		throws SystemException {
		return findByQuestionID(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<EnqueteNoticia> findByQuestionID(long questionId, int start,
		int end) throws SystemException {
		return findByQuestionID(questionId, start, end, null);
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
	public List<EnqueteNoticia> findByQuestionID(long questionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				questionId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<EnqueteNoticia> list = (List<EnqueteNoticia>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_QUESTIONID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ENQUETENOTICIA_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				list = (List<EnqueteNoticia>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_QUESTIONID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_QUESTIONID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public EnqueteNoticia findByQuestionID_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchEnqueteNoticiaException, SystemException {
		List<EnqueteNoticia> list = findByQuestionID(questionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEnqueteNoticiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EnqueteNoticia findByQuestionID_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchEnqueteNoticiaException, SystemException {
		int count = countByQuestionID(questionId);

		List<EnqueteNoticia> list = findByQuestionID(questionId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEnqueteNoticiaException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public EnqueteNoticia[] findByQuestionID_PrevAndNext(
		long enqueteNoticiaId, long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchEnqueteNoticiaException, SystemException {
		EnqueteNoticia enqueteNoticia = findByPrimaryKey(enqueteNoticiaId);

		Session session = null;

		try {
			session = openSession();

			EnqueteNoticia[] array = new EnqueteNoticiaImpl[3];

			array[0] = getByQuestionID_PrevAndNext(session, enqueteNoticia,
					questionId, orderByComparator, true);

			array[1] = enqueteNoticia;

			array[2] = getByQuestionID_PrevAndNext(session, enqueteNoticia,
					questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EnqueteNoticia getByQuestionID_PrevAndNext(Session session,
		EnqueteNoticia enqueteNoticia, long questionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENQUETENOTICIA_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(enqueteNoticia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EnqueteNoticia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public EnqueteNoticia findByEnqueteNoticiaID(long questionId, long articleId)
		throws NoSuchEnqueteNoticiaException, SystemException {
		EnqueteNoticia enqueteNoticia = fetchByEnqueteNoticiaID(questionId,
				articleId);

		if (enqueteNoticia == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(", articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEnqueteNoticiaException(msg.toString());
		}

		return enqueteNoticia;
	}

	/**
	 * Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question ID to search with
	 * @param articleId the article ID to search with
	 * @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnqueteNoticia fetchByEnqueteNoticiaID(long questionId,
		long articleId) throws SystemException {
		return fetchByEnqueteNoticiaID(questionId, articleId, true);
	}

	/**
	 * Finds the enquete noticia where questionId = &#63; and articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question ID to search with
	 * @param articleId the article ID to search with
	 * @return the matching enquete noticia, or <code>null</code> if a matching enquete noticia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnqueteNoticia fetchByEnqueteNoticiaID(long questionId,
		long articleId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { questionId, articleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ENQUETENOTICIA_WHERE);

			query.append(_FINDER_COLUMN_ENQUETENOTICIAID_QUESTIONID_2);

			query.append(_FINDER_COLUMN_ENQUETENOTICIAID_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(articleId);

				List<EnqueteNoticia> list = q.list();

				result = list;

				EnqueteNoticia enqueteNoticia = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
						finderArgs, list);
				}
				else {
					enqueteNoticia = list.get(0);

					cacheResult(enqueteNoticia);

					if ((enqueteNoticia.getQuestionId() != questionId) ||
							(enqueteNoticia.getArticleId() != articleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
							finderArgs, enqueteNoticia);
					}
				}

				return enqueteNoticia;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENQUETENOTICIAID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (EnqueteNoticia)result;
			}
		}
	}

	/**
	 * Finds all the enquete noticias.
	 *
	 * @return the enquete noticias
	 * @throws SystemException if a system exception occurred
	 */
	public List<EnqueteNoticia> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EnqueteNoticia> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<EnqueteNoticia> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<EnqueteNoticia> list = (List<EnqueteNoticia>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENQUETENOTICIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENQUETENOTICIA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EnqueteNoticia>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EnqueteNoticia>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the enquete noticias where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionID(long questionId) throws SystemException {
		for (EnqueteNoticia enqueteNoticia : findByQuestionID(questionId)) {
			enqueteNoticiaPersistence.remove(enqueteNoticia);
		}
	}

	/**
	 * Removes the enquete noticia where questionId = &#63; and articleId = &#63; from the database.
	 *
	 * @param questionId the question ID to search with
	 * @param articleId the article ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEnqueteNoticiaID(long questionId, long articleId)
		throws NoSuchEnqueteNoticiaException, SystemException {
		EnqueteNoticia enqueteNoticia = findByEnqueteNoticiaID(questionId,
				articleId);

		enqueteNoticiaPersistence.remove(enqueteNoticia);
	}

	/**
	 * Removes all the enquete noticias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EnqueteNoticia enqueteNoticia : findAll()) {
			enqueteNoticiaPersistence.remove(enqueteNoticia);
		}
	}

	/**
	 * Counts all the enquete noticias where questionId = &#63;.
	 *
	 * @param questionId the question ID to search with
	 * @return the number of matching enquete noticias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionID(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENQUETENOTICIA_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the enquete noticias where questionId = &#63; and articleId = &#63;.
	 *
	 * @param questionId the question ID to search with
	 * @param articleId the article ID to search with
	 * @return the number of matching enquete noticias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEnqueteNoticiaID(long questionId, long articleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionId, articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ENQUETENOTICIAID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENQUETENOTICIA_WHERE);

			query.append(_FINDER_COLUMN_ENQUETENOTICIAID_QUESTIONID_2);

			query.append(_FINDER_COLUMN_ENQUETENOTICIAID_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(articleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENQUETENOTICIAID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the enquete noticias.
	 *
	 * @return the number of enquete noticias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENQUETENOTICIA);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the enquete noticia persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnqueteNoticia>> listenersList = new ArrayList<ModelListener<EnqueteNoticia>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnqueteNoticia>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EnqueteNoticiaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = EnqueteNoticiaPersistence.class)
	protected EnqueteNoticiaPersistence enqueteNoticiaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ENQUETENOTICIA = "SELECT enqueteNoticia FROM EnqueteNoticia enqueteNoticia";
	private static final String _SQL_SELECT_ENQUETENOTICIA_WHERE = "SELECT enqueteNoticia FROM EnqueteNoticia enqueteNoticia WHERE ";
	private static final String _SQL_COUNT_ENQUETENOTICIA = "SELECT COUNT(enqueteNoticia) FROM EnqueteNoticia enqueteNoticia";
	private static final String _SQL_COUNT_ENQUETENOTICIA_WHERE = "SELECT COUNT(enqueteNoticia) FROM EnqueteNoticia enqueteNoticia WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "enqueteNoticia.questionId = ?";
	private static final String _FINDER_COLUMN_ENQUETENOTICIAID_QUESTIONID_2 = "enqueteNoticia.questionId = ? AND ";
	private static final String _FINDER_COLUMN_ENQUETENOTICIAID_ARTICLEID_2 = "enqueteNoticia.articleId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enqueteNoticia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnqueteNoticia exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EnqueteNoticia exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnqueteNoticiaPersistenceImpl.class);
	private static EnqueteNoticia _nullEnqueteNoticia = new EnqueteNoticiaImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<EnqueteNoticia> toCacheModel() {
				return _nullEnqueteNoticiaCacheModel;
			}
		};

	private static CacheModel<EnqueteNoticia> _nullEnqueteNoticiaCacheModel = new CacheModel<EnqueteNoticia>() {
			public EnqueteNoticia toEntityModel() {
				return _nullEnqueteNoticia;
			}
		};
}