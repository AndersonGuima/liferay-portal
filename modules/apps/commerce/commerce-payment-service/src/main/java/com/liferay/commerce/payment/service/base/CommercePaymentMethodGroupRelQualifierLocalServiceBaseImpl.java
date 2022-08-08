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

package com.liferay.commerce.payment.service.base;

import com.liferay.commerce.payment.model.CommercePaymentMethodGroupRelQualifier;
import com.liferay.commerce.payment.service.CommercePaymentMethodGroupRelQualifierLocalService;
import com.liferay.commerce.payment.service.CommercePaymentMethodGroupRelQualifierLocalServiceUtil;
import com.liferay.commerce.payment.service.persistence.CommercePaymentMethodGroupRelQualifierPersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the commerce payment method group rel qualifier local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.payment.service.impl.CommercePaymentMethodGroupRelQualifierLocalServiceImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see com.liferay.commerce.payment.service.impl.CommercePaymentMethodGroupRelQualifierLocalServiceImpl
 * @generated
 */
public abstract class CommercePaymentMethodGroupRelQualifierLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CommercePaymentMethodGroupRelQualifierLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommercePaymentMethodGroupRelQualifierLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommercePaymentMethodGroupRelQualifierLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce payment method group rel qualifier to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePaymentMethodGroupRelQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePaymentMethodGroupRelQualifier the commerce payment method group rel qualifier
	 * @return the commerce payment method group rel qualifier that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePaymentMethodGroupRelQualifier
		addCommercePaymentMethodGroupRelQualifier(
			CommercePaymentMethodGroupRelQualifier
				commercePaymentMethodGroupRelQualifier) {

		commercePaymentMethodGroupRelQualifier.setNew(true);

		return commercePaymentMethodGroupRelQualifierPersistence.update(
			commercePaymentMethodGroupRelQualifier);
	}

	/**
	 * Creates a new commerce payment method group rel qualifier with the primary key. Does not add the commerce payment method group rel qualifier to the database.
	 *
	 * @param commercePaymentMethodGroupRelQualifierId the primary key for the new commerce payment method group rel qualifier
	 * @return the new commerce payment method group rel qualifier
	 */
	@Override
	@Transactional(enabled = false)
	public CommercePaymentMethodGroupRelQualifier
		createCommercePaymentMethodGroupRelQualifier(
			long commercePaymentMethodGroupRelQualifierId) {

		return commercePaymentMethodGroupRelQualifierPersistence.create(
			commercePaymentMethodGroupRelQualifierId);
	}

	/**
	 * Deletes the commerce payment method group rel qualifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePaymentMethodGroupRelQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePaymentMethodGroupRelQualifierId the primary key of the commerce payment method group rel qualifier
	 * @return the commerce payment method group rel qualifier that was removed
	 * @throws PortalException if a commerce payment method group rel qualifier with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePaymentMethodGroupRelQualifier
			deleteCommercePaymentMethodGroupRelQualifier(
				long commercePaymentMethodGroupRelQualifierId)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierPersistence.remove(
			commercePaymentMethodGroupRelQualifierId);
	}

	/**
	 * Deletes the commerce payment method group rel qualifier from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePaymentMethodGroupRelQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePaymentMethodGroupRelQualifier the commerce payment method group rel qualifier
	 * @return the commerce payment method group rel qualifier that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePaymentMethodGroupRelQualifier
			deleteCommercePaymentMethodGroupRelQualifier(
				CommercePaymentMethodGroupRelQualifier
					commercePaymentMethodGroupRelQualifier)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierPersistence.remove(
			commercePaymentMethodGroupRelQualifier);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return commercePaymentMethodGroupRelQualifierPersistence.dslQuery(
			dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommercePaymentMethodGroupRelQualifier.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commercePaymentMethodGroupRelQualifierPersistence.
			findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.payment.model.impl.CommercePaymentMethodGroupRelQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commercePaymentMethodGroupRelQualifierPersistence.
			findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.payment.model.impl.CommercePaymentMethodGroupRelQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commercePaymentMethodGroupRelQualifierPersistence.
			findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commercePaymentMethodGroupRelQualifierPersistence.
			countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commercePaymentMethodGroupRelQualifierPersistence.
			countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public CommercePaymentMethodGroupRelQualifier
		fetchCommercePaymentMethodGroupRelQualifier(
			long commercePaymentMethodGroupRelQualifierId) {

		return commercePaymentMethodGroupRelQualifierPersistence.
			fetchByPrimaryKey(commercePaymentMethodGroupRelQualifierId);
	}

	/**
	 * Returns the commerce payment method group rel qualifier with the primary key.
	 *
	 * @param commercePaymentMethodGroupRelQualifierId the primary key of the commerce payment method group rel qualifier
	 * @return the commerce payment method group rel qualifier
	 * @throws PortalException if a commerce payment method group rel qualifier with the primary key could not be found
	 */
	@Override
	public CommercePaymentMethodGroupRelQualifier
			getCommercePaymentMethodGroupRelQualifier(
				long commercePaymentMethodGroupRelQualifierId)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierPersistence.
			findByPrimaryKey(commercePaymentMethodGroupRelQualifierId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commercePaymentMethodGroupRelQualifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommercePaymentMethodGroupRelQualifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePaymentMethodGroupRelQualifierId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commercePaymentMethodGroupRelQualifierLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommercePaymentMethodGroupRelQualifier.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePaymentMethodGroupRelQualifierId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commercePaymentMethodGroupRelQualifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommercePaymentMethodGroupRelQualifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePaymentMethodGroupRelQualifierId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierLocalService.
			deleteCommercePaymentMethodGroupRelQualifier(
				(CommercePaymentMethodGroupRelQualifier)persistedModel);
	}

	@Override
	public BasePersistence<CommercePaymentMethodGroupRelQualifier>
		getBasePersistence() {

		return commercePaymentMethodGroupRelQualifierPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commercePaymentMethodGroupRelQualifierPersistence.
			findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce payment method group rel qualifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.payment.model.impl.CommercePaymentMethodGroupRelQualifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce payment method group rel qualifiers
	 * @param end the upper bound of the range of commerce payment method group rel qualifiers (not inclusive)
	 * @return the range of commerce payment method group rel qualifiers
	 */
	@Override
	public List<CommercePaymentMethodGroupRelQualifier>
		getCommercePaymentMethodGroupRelQualifiers(int start, int end) {

		return commercePaymentMethodGroupRelQualifierPersistence.findAll(
			start, end);
	}

	/**
	 * Returns the number of commerce payment method group rel qualifiers.
	 *
	 * @return the number of commerce payment method group rel qualifiers
	 */
	@Override
	public int getCommercePaymentMethodGroupRelQualifiersCount() {
		return commercePaymentMethodGroupRelQualifierPersistence.countAll();
	}

	/**
	 * Updates the commerce payment method group rel qualifier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePaymentMethodGroupRelQualifierLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePaymentMethodGroupRelQualifier the commerce payment method group rel qualifier
	 * @return the commerce payment method group rel qualifier that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePaymentMethodGroupRelQualifier
		updateCommercePaymentMethodGroupRelQualifier(
			CommercePaymentMethodGroupRelQualifier
				commercePaymentMethodGroupRelQualifier) {

		return commercePaymentMethodGroupRelQualifierPersistence.update(
			commercePaymentMethodGroupRelQualifier);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CommercePaymentMethodGroupRelQualifierLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		commercePaymentMethodGroupRelQualifierLocalService =
			(CommercePaymentMethodGroupRelQualifierLocalService)aopProxy;

		_setLocalServiceUtilService(
			commercePaymentMethodGroupRelQualifierLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommercePaymentMethodGroupRelQualifierLocalService.class.
			getName();
	}

	protected Class<?> getModelClass() {
		return CommercePaymentMethodGroupRelQualifier.class;
	}

	protected String getModelClassName() {
		return CommercePaymentMethodGroupRelQualifier.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commercePaymentMethodGroupRelQualifierPersistence.
					getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CommercePaymentMethodGroupRelQualifierLocalService
			commercePaymentMethodGroupRelQualifierLocalService) {

		try {
			Field field =
				CommercePaymentMethodGroupRelQualifierLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, commercePaymentMethodGroupRelQualifierLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CommercePaymentMethodGroupRelQualifierLocalService
		commercePaymentMethodGroupRelQualifierLocalService;

	@Reference
	protected CommercePaymentMethodGroupRelQualifierPersistence
		commercePaymentMethodGroupRelQualifierPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}