/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.analytics.message.storage.service.persistence.impl;

import com.liferay.analytics.message.storage.exception.NoSuchAssociationChangeException;
import com.liferay.analytics.message.storage.model.AnalyticsAssociationChange;
import com.liferay.analytics.message.storage.model.AnalyticsAssociationChangeTable;
import com.liferay.analytics.message.storage.model.impl.AnalyticsAssociationChangeImpl;
import com.liferay.analytics.message.storage.model.impl.AnalyticsAssociationChangeModelImpl;
import com.liferay.analytics.message.storage.service.persistence.AnalyticsAssociationChangePersistence;
import com.liferay.analytics.message.storage.service.persistence.AnalyticsAssociationChangeUtil;
import com.liferay.analytics.message.storage.service.persistence.impl.constants.AnalyticsPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the analytics association change service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {
		AnalyticsAssociationChangePersistence.class, BasePersistence.class
	}
)
public class AnalyticsAssociationChangePersistenceImpl
	extends BasePersistenceImpl<AnalyticsAssociationChange>
	implements AnalyticsAssociationChangePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnalyticsAssociationChangeUtil</code> to access the analytics association change persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnalyticsAssociationChangeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByC_A;
	private FinderPath _finderPathWithoutPaginationFindByC_A;
	private FinderPath _finderPathCountByC_A;

	/**
	 * Returns all the analytics association changes where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @return the matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A(
		long companyId, String associationClassName) {

		return findByC_A(
			companyId, associationClassName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics association changes where companyId = &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @return the range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A(
		long companyId, String associationClassName, int start, int end) {

		return findByC_A(companyId, associationClassName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A(
		long companyId, String associationClassName, int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		return findByC_A(
			companyId, associationClassName, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A(
		long companyId, String associationClassName, int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean useFinderCache) {

		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_A;
				finderArgs = new Object[] {companyId, associationClassName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_A;
			finderArgs = new Object[] {
				companyId, associationClassName, start, end, orderByComparator
			};
		}

		List<AnalyticsAssociationChange> list = null;

		if (useFinderCache) {
			list = (List<AnalyticsAssociationChange>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsAssociationChange analyticsAssociationChange :
						list) {

					if ((companyId !=
							analyticsAssociationChange.getCompanyId()) ||
						!associationClassName.equals(
							analyticsAssociationChange.
								getAssociationClassName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				list = (List<AnalyticsAssociationChange>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_A_First(
			long companyId, String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByC_A_First(
				companyId, associationClassName, orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_A_First(
		long companyId, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		List<AnalyticsAssociationChange> list = findByC_A(
			companyId, associationClassName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_A_Last(
			long companyId, String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange = fetchByC_A_Last(
			companyId, associationClassName, orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_A_Last(
		long companyId, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		int count = countByC_A(companyId, associationClassName);

		if (count == 0) {
			return null;
		}

		List<AnalyticsAssociationChange> list = findByC_A(
			companyId, associationClassName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics association changes before and after the current analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param analyticsAssociationChangeId the primary key of the current analytics association change
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics association change
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange[] findByC_A_PrevAndNext(
			long analyticsAssociationChangeId, long companyId,
			String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		associationClassName = Objects.toString(associationClassName, "");

		AnalyticsAssociationChange analyticsAssociationChange =
			findByPrimaryKey(analyticsAssociationChangeId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsAssociationChange[] array =
				new AnalyticsAssociationChangeImpl[3];

			array[0] = getByC_A_PrevAndNext(
				session, analyticsAssociationChange, companyId,
				associationClassName, orderByComparator, true);

			array[1] = analyticsAssociationChange;

			array[2] = getByC_A_PrevAndNext(
				session, analyticsAssociationChange, companyId,
				associationClassName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsAssociationChange getByC_A_PrevAndNext(
		Session session, AnalyticsAssociationChange analyticsAssociationChange,
		long companyId, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

		sb.append(_FINDER_COLUMN_C_A_COMPANYID_2);

		boolean bindAssociationClassName = false;

		if (associationClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_3);
		}
		else {
			bindAssociationClassName = true;

			sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindAssociationClassName) {
			queryPos.add(associationClassName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						analyticsAssociationChange)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnalyticsAssociationChange> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics association changes where companyId = &#63; and associationClassName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 */
	@Override
	public void removeByC_A(long companyId, String associationClassName) {
		for (AnalyticsAssociationChange analyticsAssociationChange :
				findByC_A(
					companyId, associationClassName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(analyticsAssociationChange);
		}
	}

	/**
	 * Returns the number of analytics association changes where companyId = &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @return the number of matching analytics association changes
	 */
	@Override
	public int countByC_A(long companyId, String associationClassName) {
		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = _finderPathCountByC_A;

		Object[] finderArgs = new Object[] {companyId, associationClassName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_A_COMPANYID_2 =
		"analyticsAssociationChange.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_2 =
		"analyticsAssociationChange.associationClassName = ?";

	private static final String _FINDER_COLUMN_C_A_ASSOCIATIONCLASSNAME_3 =
		"(analyticsAssociationChange.associationClassName IS NULL OR analyticsAssociationChange.associationClassName = '')";

	private FinderPath _finderPathWithPaginationFindByC_GtM_A;
	private FinderPath _finderPathWithPaginationCountByC_GtM_A;

	/**
	 * Returns all the analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @return the matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName) {

		return findByC_GtM_A(
			companyId, modifiedDate, associationClassName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @return the range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName,
		int start, int end) {

		return findByC_GtM_A(
			companyId, modifiedDate, associationClassName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName,
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		return findByC_GtM_A(
			companyId, modifiedDate, associationClassName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName,
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean useFinderCache) {

		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByC_GtM_A;
		finderArgs = new Object[] {
			companyId, _getTime(modifiedDate), associationClassName, start, end,
			orderByComparator
		};

		List<AnalyticsAssociationChange> list = null;

		if (useFinderCache) {
			list = (List<AnalyticsAssociationChange>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsAssociationChange analyticsAssociationChange :
						list) {

					if ((companyId !=
							analyticsAssociationChange.getCompanyId()) ||
						(modifiedDate.getTime() >=
							analyticsAssociationChange.getModifiedDate(
							).getTime()) ||
						!associationClassName.equals(
							analyticsAssociationChange.
								getAssociationClassName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_GTM_A_COMPANYID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_2);
			}

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindModifiedDate) {
					queryPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				list = (List<AnalyticsAssociationChange>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_GtM_A_First(
			long companyId, Date modifiedDate, String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByC_GtM_A_First(
				companyId, modifiedDate, associationClassName,
				orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", modifiedDate>");
		sb.append(modifiedDate);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_GtM_A_First(
		long companyId, Date modifiedDate, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		List<AnalyticsAssociationChange> list = findByC_GtM_A(
			companyId, modifiedDate, associationClassName, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_GtM_A_Last(
			long companyId, Date modifiedDate, String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByC_GtM_A_Last(
				companyId, modifiedDate, associationClassName,
				orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", modifiedDate>");
		sb.append(modifiedDate);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_GtM_A_Last(
		long companyId, Date modifiedDate, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		int count = countByC_GtM_A(
			companyId, modifiedDate, associationClassName);

		if (count == 0) {
			return null;
		}

		List<AnalyticsAssociationChange> list = findByC_GtM_A(
			companyId, modifiedDate, associationClassName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics association changes before and after the current analytics association change in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param analyticsAssociationChangeId the primary key of the current analytics association change
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics association change
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange[] findByC_GtM_A_PrevAndNext(
			long analyticsAssociationChangeId, long companyId,
			Date modifiedDate, String associationClassName,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		associationClassName = Objects.toString(associationClassName, "");

		AnalyticsAssociationChange analyticsAssociationChange =
			findByPrimaryKey(analyticsAssociationChangeId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsAssociationChange[] array =
				new AnalyticsAssociationChangeImpl[3];

			array[0] = getByC_GtM_A_PrevAndNext(
				session, analyticsAssociationChange, companyId, modifiedDate,
				associationClassName, orderByComparator, true);

			array[1] = analyticsAssociationChange;

			array[2] = getByC_GtM_A_PrevAndNext(
				session, analyticsAssociationChange, companyId, modifiedDate,
				associationClassName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsAssociationChange getByC_GtM_A_PrevAndNext(
		Session session, AnalyticsAssociationChange analyticsAssociationChange,
		long companyId, Date modifiedDate, String associationClassName,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

		sb.append(_FINDER_COLUMN_C_GTM_A_COMPANYID_2);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_2);
		}

		boolean bindAssociationClassName = false;

		if (associationClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_3);
		}
		else {
			bindAssociationClassName = true;

			sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindModifiedDate) {
			queryPos.add(new Timestamp(modifiedDate.getTime()));
		}

		if (bindAssociationClassName) {
			queryPos.add(associationClassName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						analyticsAssociationChange)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnalyticsAssociationChange> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 */
	@Override
	public void removeByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName) {

		for (AnalyticsAssociationChange analyticsAssociationChange :
				findByC_GtM_A(
					companyId, modifiedDate, associationClassName,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(analyticsAssociationChange);
		}
	}

	/**
	 * Returns the number of analytics association changes where companyId = &#63; and modifiedDate &gt; &#63; and associationClassName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param associationClassName the association class name
	 * @return the number of matching analytics association changes
	 */
	@Override
	public int countByC_GtM_A(
		long companyId, Date modifiedDate, String associationClassName) {

		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByC_GtM_A;

		Object[] finderArgs = new Object[] {
			companyId, _getTime(modifiedDate), associationClassName
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_GTM_A_COMPANYID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				sb.append(_FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_2);
			}

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindModifiedDate) {
					queryPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_GTM_A_COMPANYID_2 =
		"analyticsAssociationChange.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_1 =
		"analyticsAssociationChange.modifiedDate IS NULL AND ";

	private static final String _FINDER_COLUMN_C_GTM_A_MODIFIEDDATE_2 =
		"analyticsAssociationChange.modifiedDate > ? AND ";

	private static final String _FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_2 =
		"analyticsAssociationChange.associationClassName = ?";

	private static final String _FINDER_COLUMN_C_GTM_A_ASSOCIATIONCLASSNAME_3 =
		"(analyticsAssociationChange.associationClassName IS NULL OR analyticsAssociationChange.associationClassName = '')";

	private FinderPath _finderPathWithPaginationFindByC_A_A;
	private FinderPath _finderPathWithoutPaginationFindByC_A_A;
	private FinderPath _finderPathCountByC_A_A;

	/**
	 * Returns all the analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @return the matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A_A(
		long companyId, String associationClassName, long associationClassPK) {

		return findByC_A_A(
			companyId, associationClassName, associationClassPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @return the range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A_A(
		long companyId, String associationClassName, long associationClassPK,
		int start, int end) {

		return findByC_A_A(
			companyId, associationClassName, associationClassPK, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A_A(
		long companyId, String associationClassName, long associationClassPK,
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		return findByC_A_A(
			companyId, associationClassName, associationClassPK, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findByC_A_A(
		long companyId, String associationClassName, long associationClassPK,
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean useFinderCache) {

		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_A_A;
				finderArgs = new Object[] {
					companyId, associationClassName, associationClassPK
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_A_A;
			finderArgs = new Object[] {
				companyId, associationClassName, associationClassPK, start, end,
				orderByComparator
			};
		}

		List<AnalyticsAssociationChange> list = null;

		if (useFinderCache) {
			list = (List<AnalyticsAssociationChange>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsAssociationChange analyticsAssociationChange :
						list) {

					if ((companyId !=
							analyticsAssociationChange.getCompanyId()) ||
						!associationClassName.equals(
							analyticsAssociationChange.
								getAssociationClassName()) ||
						(associationClassPK !=
							analyticsAssociationChange.
								getAssociationClassPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_A_A_COMPANYID_2);

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				queryPos.add(associationClassPK);

				list = (List<AnalyticsAssociationChange>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_A_A_First(
			long companyId, String associationClassName,
			long associationClassPK,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByC_A_A_First(
				companyId, associationClassName, associationClassPK,
				orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append(", associationClassPK=");
		sb.append(associationClassPK);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the first analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_A_A_First(
		long companyId, String associationClassName, long associationClassPK,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		List<AnalyticsAssociationChange> list = findByC_A_A(
			companyId, associationClassName, associationClassPK, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change
	 * @throws NoSuchAssociationChangeException if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByC_A_A_Last(
			long companyId, String associationClassName,
			long associationClassPK,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByC_A_A_Last(
				companyId, associationClassName, associationClassPK,
				orderByComparator);

		if (analyticsAssociationChange != null) {
			return analyticsAssociationChange;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", associationClassName=");
		sb.append(associationClassName);

		sb.append(", associationClassPK=");
		sb.append(associationClassPK);

		sb.append("}");

		throw new NoSuchAssociationChangeException(sb.toString());
	}

	/**
	 * Returns the last analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics association change, or <code>null</code> if a matching analytics association change could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByC_A_A_Last(
		long companyId, String associationClassName, long associationClassPK,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		int count = countByC_A_A(
			companyId, associationClassName, associationClassPK);

		if (count == 0) {
			return null;
		}

		List<AnalyticsAssociationChange> list = findByC_A_A(
			companyId, associationClassName, associationClassPK, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics association changes before and after the current analytics association change in the ordered set where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param analyticsAssociationChangeId the primary key of the current analytics association change
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics association change
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange[] findByC_A_A_PrevAndNext(
			long analyticsAssociationChangeId, long companyId,
			String associationClassName, long associationClassPK,
			OrderByComparator<AnalyticsAssociationChange> orderByComparator)
		throws NoSuchAssociationChangeException {

		associationClassName = Objects.toString(associationClassName, "");

		AnalyticsAssociationChange analyticsAssociationChange =
			findByPrimaryKey(analyticsAssociationChangeId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsAssociationChange[] array =
				new AnalyticsAssociationChangeImpl[3];

			array[0] = getByC_A_A_PrevAndNext(
				session, analyticsAssociationChange, companyId,
				associationClassName, associationClassPK, orderByComparator,
				true);

			array[1] = analyticsAssociationChange;

			array[2] = getByC_A_A_PrevAndNext(
				session, analyticsAssociationChange, companyId,
				associationClassName, associationClassPK, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsAssociationChange getByC_A_A_PrevAndNext(
		Session session, AnalyticsAssociationChange analyticsAssociationChange,
		long companyId, String associationClassName, long associationClassPK,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE);

		sb.append(_FINDER_COLUMN_C_A_A_COMPANYID_2);

		boolean bindAssociationClassName = false;

		if (associationClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_3);
		}
		else {
			bindAssociationClassName = true;

			sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_2);
		}

		sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindAssociationClassName) {
			queryPos.add(associationClassName);
		}

		queryPos.add(associationClassPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						analyticsAssociationChange)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AnalyticsAssociationChange> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 */
	@Override
	public void removeByC_A_A(
		long companyId, String associationClassName, long associationClassPK) {

		for (AnalyticsAssociationChange analyticsAssociationChange :
				findByC_A_A(
					companyId, associationClassName, associationClassPK,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(analyticsAssociationChange);
		}
	}

	/**
	 * Returns the number of analytics association changes where companyId = &#63; and associationClassName = &#63; and associationClassPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param associationClassName the association class name
	 * @param associationClassPK the association class pk
	 * @return the number of matching analytics association changes
	 */
	@Override
	public int countByC_A_A(
		long companyId, String associationClassName, long associationClassPK) {

		associationClassName = Objects.toString(associationClassName, "");

		FinderPath finderPath = _finderPathCountByC_A_A;

		Object[] finderArgs = new Object[] {
			companyId, associationClassName, associationClassPK
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ANALYTICSASSOCIATIONCHANGE_WHERE);

			sb.append(_FINDER_COLUMN_C_A_A_COMPANYID_2);

			boolean bindAssociationClassName = false;

			if (associationClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_3);
			}
			else {
				bindAssociationClassName = true;

				sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_2);
			}

			sb.append(_FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindAssociationClassName) {
					queryPos.add(associationClassName);
				}

				queryPos.add(associationClassPK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_A_A_COMPANYID_2 =
		"analyticsAssociationChange.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_2 =
		"analyticsAssociationChange.associationClassName = ? AND ";

	private static final String _FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSNAME_3 =
		"(analyticsAssociationChange.associationClassName IS NULL OR analyticsAssociationChange.associationClassName = '') AND ";

	private static final String _FINDER_COLUMN_C_A_A_ASSOCIATIONCLASSPK_2 =
		"analyticsAssociationChange.associationClassPK = ?";

	public AnalyticsAssociationChangePersistenceImpl() {
		setModelClass(AnalyticsAssociationChange.class);

		setModelImplClass(AnalyticsAssociationChangeImpl.class);
		setModelPKClass(long.class);

		setTable(AnalyticsAssociationChangeTable.INSTANCE);
	}

	/**
	 * Caches the analytics association change in the entity cache if it is enabled.
	 *
	 * @param analyticsAssociationChange the analytics association change
	 */
	@Override
	public void cacheResult(
		AnalyticsAssociationChange analyticsAssociationChange) {

		entityCache.putResult(
			AnalyticsAssociationChangeImpl.class,
			analyticsAssociationChange.getPrimaryKey(),
			analyticsAssociationChange);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the analytics association changes in the entity cache if it is enabled.
	 *
	 * @param analyticsAssociationChanges the analytics association changes
	 */
	@Override
	public void cacheResult(
		List<AnalyticsAssociationChange> analyticsAssociationChanges) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (analyticsAssociationChanges.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnalyticsAssociationChange analyticsAssociationChange :
				analyticsAssociationChanges) {

			if (entityCache.getResult(
					AnalyticsAssociationChangeImpl.class,
					analyticsAssociationChange.getPrimaryKey()) == null) {

				cacheResult(analyticsAssociationChange);
			}
		}
	}

	/**
	 * Clears the cache for all analytics association changes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnalyticsAssociationChangeImpl.class);

		finderCache.clearCache(AnalyticsAssociationChangeImpl.class);
	}

	/**
	 * Clears the cache for the analytics association change.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		AnalyticsAssociationChange analyticsAssociationChange) {

		entityCache.removeResult(
			AnalyticsAssociationChangeImpl.class, analyticsAssociationChange);
	}

	@Override
	public void clearCache(
		List<AnalyticsAssociationChange> analyticsAssociationChanges) {

		for (AnalyticsAssociationChange analyticsAssociationChange :
				analyticsAssociationChanges) {

			entityCache.removeResult(
				AnalyticsAssociationChangeImpl.class,
				analyticsAssociationChange);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AnalyticsAssociationChangeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AnalyticsAssociationChangeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new analytics association change with the primary key. Does not add the analytics association change to the database.
	 *
	 * @param analyticsAssociationChangeId the primary key for the new analytics association change
	 * @return the new analytics association change
	 */
	@Override
	public AnalyticsAssociationChange create(
		long analyticsAssociationChangeId) {

		AnalyticsAssociationChange analyticsAssociationChange =
			new AnalyticsAssociationChangeImpl();

		analyticsAssociationChange.setNew(true);
		analyticsAssociationChange.setPrimaryKey(analyticsAssociationChangeId);

		analyticsAssociationChange.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return analyticsAssociationChange;
	}

	/**
	 * Removes the analytics association change with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param analyticsAssociationChangeId the primary key of the analytics association change
	 * @return the analytics association change that was removed
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange remove(long analyticsAssociationChangeId)
		throws NoSuchAssociationChangeException {

		return remove((Serializable)analyticsAssociationChangeId);
	}

	/**
	 * Removes the analytics association change with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the analytics association change
	 * @return the analytics association change that was removed
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange remove(Serializable primaryKey)
		throws NoSuchAssociationChangeException {

		Session session = null;

		try {
			session = openSession();

			AnalyticsAssociationChange analyticsAssociationChange =
				(AnalyticsAssociationChange)session.get(
					AnalyticsAssociationChangeImpl.class, primaryKey);

			if (analyticsAssociationChange == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssociationChangeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(analyticsAssociationChange);
		}
		catch (NoSuchAssociationChangeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AnalyticsAssociationChange removeImpl(
		AnalyticsAssociationChange analyticsAssociationChange) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(analyticsAssociationChange)) {
				analyticsAssociationChange =
					(AnalyticsAssociationChange)session.get(
						AnalyticsAssociationChangeImpl.class,
						analyticsAssociationChange.getPrimaryKeyObj());
			}

			if (analyticsAssociationChange != null) {
				session.delete(analyticsAssociationChange);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (analyticsAssociationChange != null) {
			clearCache(analyticsAssociationChange);
		}

		return analyticsAssociationChange;
	}

	@Override
	public AnalyticsAssociationChange updateImpl(
		AnalyticsAssociationChange analyticsAssociationChange) {

		boolean isNew = analyticsAssociationChange.isNew();

		if (!(analyticsAssociationChange instanceof
				AnalyticsAssociationChangeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(analyticsAssociationChange.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					analyticsAssociationChange);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in analyticsAssociationChange proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AnalyticsAssociationChange implementation " +
					analyticsAssociationChange.getClass());
		}

		AnalyticsAssociationChangeModelImpl
			analyticsAssociationChangeModelImpl =
				(AnalyticsAssociationChangeModelImpl)analyticsAssociationChange;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (analyticsAssociationChange.getCreateDate() == null)) {
			if (serviceContext == null) {
				analyticsAssociationChange.setCreateDate(date);
			}
			else {
				analyticsAssociationChange.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!analyticsAssociationChangeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				analyticsAssociationChange.setModifiedDate(date);
			}
			else {
				analyticsAssociationChange.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(analyticsAssociationChange);
			}
			else {
				analyticsAssociationChange =
					(AnalyticsAssociationChange)session.merge(
						analyticsAssociationChange);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnalyticsAssociationChangeImpl.class,
			analyticsAssociationChangeModelImpl, false, true);

		if (isNew) {
			analyticsAssociationChange.setNew(false);
		}

		analyticsAssociationChange.resetOriginalValues();

		return analyticsAssociationChange;
	}

	/**
	 * Returns the analytics association change with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics association change
	 * @return the analytics association change
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssociationChangeException {

		AnalyticsAssociationChange analyticsAssociationChange =
			fetchByPrimaryKey(primaryKey);

		if (analyticsAssociationChange == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssociationChangeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return analyticsAssociationChange;
	}

	/**
	 * Returns the analytics association change with the primary key or throws a <code>NoSuchAssociationChangeException</code> if it could not be found.
	 *
	 * @param analyticsAssociationChangeId the primary key of the analytics association change
	 * @return the analytics association change
	 * @throws NoSuchAssociationChangeException if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange findByPrimaryKey(
			long analyticsAssociationChangeId)
		throws NoSuchAssociationChangeException {

		return findByPrimaryKey((Serializable)analyticsAssociationChangeId);
	}

	/**
	 * Returns the analytics association change with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param analyticsAssociationChangeId the primary key of the analytics association change
	 * @return the analytics association change, or <code>null</code> if a analytics association change with the primary key could not be found
	 */
	@Override
	public AnalyticsAssociationChange fetchByPrimaryKey(
		long analyticsAssociationChangeId) {

		return fetchByPrimaryKey((Serializable)analyticsAssociationChangeId);
	}

	/**
	 * Returns all the analytics association changes.
	 *
	 * @return the analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics association changes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @return the range of analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics association changes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findAll(
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics association changes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnalyticsAssociationChangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics association changes
	 * @param end the upper bound of the range of analytics association changes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of analytics association changes
	 */
	@Override
	public List<AnalyticsAssociationChange> findAll(
		int start, int end,
		OrderByComparator<AnalyticsAssociationChange> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AnalyticsAssociationChange> list = null;

		if (useFinderCache) {
			list = (List<AnalyticsAssociationChange>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANALYTICSASSOCIATIONCHANGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANALYTICSASSOCIATIONCHANGE;

				sql = sql.concat(
					AnalyticsAssociationChangeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnalyticsAssociationChange>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the analytics association changes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnalyticsAssociationChange analyticsAssociationChange :
				findAll()) {

			remove(analyticsAssociationChange);
		}
	}

	/**
	 * Returns the number of analytics association changes.
	 *
	 * @return the number of analytics association changes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ANALYTICSASSOCIATIONCHANGE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "analyticsAssociationChangeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANALYTICSASSOCIATIONCHANGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnalyticsAssociationChangeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the analytics association change persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "associationClassName"}, true);

		_finderPathWithoutPaginationFindByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_A",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "associationClassName"}, true);

		_finderPathCountByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "associationClassName"}, false);

		_finderPathWithPaginationFindByC_GtM_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_GtM_A",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId", "modifiedDate", "associationClassName"},
			true);

		_finderPathWithPaginationCountByC_GtM_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtM_A",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "modifiedDate", "associationClassName"},
			false);

		_finderPathWithPaginationFindByC_A_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_A_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {
				"companyId", "associationClassName", "associationClassPK"
			},
			true);

		_finderPathWithoutPaginationFindByC_A_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_A_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"companyId", "associationClassName", "associationClassPK"
			},
			true);

		_finderPathCountByC_A_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"companyId", "associationClassName", "associationClassPK"
			},
			false);

		_setAnalyticsAssociationChangeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnalyticsAssociationChangeUtilPersistence(null);

		entityCache.removeCache(AnalyticsAssociationChangeImpl.class.getName());
	}

	private void _setAnalyticsAssociationChangeUtilPersistence(
		AnalyticsAssociationChangePersistence
			analyticsAssociationChangePersistence) {

		try {
			Field field = AnalyticsAssociationChangeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, analyticsAssociationChangePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AnalyticsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AnalyticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AnalyticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_ANALYTICSASSOCIATIONCHANGE =
		"SELECT analyticsAssociationChange FROM AnalyticsAssociationChange analyticsAssociationChange";

	private static final String _SQL_SELECT_ANALYTICSASSOCIATIONCHANGE_WHERE =
		"SELECT analyticsAssociationChange FROM AnalyticsAssociationChange analyticsAssociationChange WHERE ";

	private static final String _SQL_COUNT_ANALYTICSASSOCIATIONCHANGE =
		"SELECT COUNT(analyticsAssociationChange) FROM AnalyticsAssociationChange analyticsAssociationChange";

	private static final String _SQL_COUNT_ANALYTICSASSOCIATIONCHANGE_WHERE =
		"SELECT COUNT(analyticsAssociationChange) FROM AnalyticsAssociationChange analyticsAssociationChange WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"analyticsAssociationChange.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnalyticsAssociationChange exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AnalyticsAssociationChange exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AnalyticsAssociationChangePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AnalyticsAssociationChangeModelArgumentsResolver
		_analyticsAssociationChangeModelArgumentsResolver;

}