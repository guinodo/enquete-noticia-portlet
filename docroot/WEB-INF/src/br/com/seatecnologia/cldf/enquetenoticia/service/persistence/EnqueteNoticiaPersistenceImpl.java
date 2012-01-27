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
 * @author Wallacy, Adan, Eduardo
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

		EntityCacheUtil.removeResult(EnqueteNoticiaModelImpl.ENTITY_CACHE_ENABLED,
			EnqueteNoticiaImpl.class, enqueteNoticia.getPrimaryKey());

		return enqueteNoticia;
	}

	@Override
	public EnqueteNoticia updateImpl(
		br.com.seatecnologia.cldf.enquetenoticia.model.EnqueteNoticia enqueteNoticia,
		boolean merge) throws SystemException {
		enqueteNoticia = toUnwrappedModel(enqueteNoticia);

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
		enqueteNoticiaImpl.setPollId(enqueteNoticia.getPollId());
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
	private static final String _SQL_COUNT_ENQUETENOTICIA = "SELECT COUNT(enqueteNoticia) FROM EnqueteNoticia enqueteNoticia";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enqueteNoticia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnqueteNoticia exists with the primary key ";
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