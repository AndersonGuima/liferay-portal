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

package com.liferay.portlet.wiki.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.wiki.model.WikiPageResource;
import com.liferay.portlet.wiki.service.WikiNodeLocalService;
import com.liferay.portlet.wiki.service.WikiNodeService;
import com.liferay.portlet.wiki.service.WikiPageLocalService;
import com.liferay.portlet.wiki.service.WikiPageResourceLocalService;
import com.liferay.portlet.wiki.service.WikiPageService;
import com.liferay.portlet.wiki.service.persistence.WikiNodePersistence;
import com.liferay.portlet.wiki.service.persistence.WikiPageFinder;
import com.liferay.portlet.wiki.service.persistence.WikiPagePersistence;
import com.liferay.portlet.wiki.service.persistence.WikiPageResourcePersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the wiki page resource local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.wiki.service.impl.WikiPageResourceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.wiki.service.impl.WikiPageResourceLocalServiceImpl
 * @see com.liferay.portlet.wiki.service.WikiPageResourceLocalServiceUtil
 * @generated
 */
public abstract class WikiPageResourceLocalServiceBaseImpl
	implements WikiPageResourceLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.wiki.service.WikiPageResourceLocalServiceUtil} to access the wiki page resource local service.
	 */

	/**
	 * Adds the wiki page resource to the database. Also notifies the appropriate model listeners.
	 *
	 * @param wikiPageResource the wiki page resource to add
	 * @return the wiki page resource that was added
	 * @throws SystemException if a system exception occurred
	 */
	public WikiPageResource addWikiPageResource(
		WikiPageResource wikiPageResource) throws SystemException {
		wikiPageResource.setNew(true);

		return wikiPageResourcePersistence.update(wikiPageResource, false);
	}

	/**
	 * Creates a new wiki page resource with the primary key. Does not add the wiki page resource to the database.
	 *
	 * @param resourcePrimKey the primary key for the new wiki page resource
	 * @return the new wiki page resource
	 */
	public WikiPageResource createWikiPageResource(long resourcePrimKey) {
		return wikiPageResourcePersistence.create(resourcePrimKey);
	}

	/**
	 * Deletes the wiki page resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourcePrimKey the primary key of the wiki page resource to delete
	 * @throws PortalException if a wiki page resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteWikiPageResource(long resourcePrimKey)
		throws PortalException, SystemException {
		wikiPageResourcePersistence.remove(resourcePrimKey);
	}

	/**
	 * Deletes the wiki page resource from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wikiPageResource the wiki page resource to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteWikiPageResource(WikiPageResource wikiPageResource)
		throws SystemException {
		wikiPageResourcePersistence.remove(wikiPageResource);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return wikiPageResourcePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return wikiPageResourcePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return wikiPageResourcePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return wikiPageResourcePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the wiki page resource with the primary key.
	 *
	 * @param resourcePrimKey the primary key of the wiki page resource to get
	 * @return the wiki page resource
	 * @throws PortalException if a wiki page resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WikiPageResource getWikiPageResource(long resourcePrimKey)
		throws PortalException, SystemException {
		return wikiPageResourcePersistence.findByPrimaryKey(resourcePrimKey);
	}

	/**
	 * Gets a range of all the wiki page resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wiki page resources to return
	 * @param end the upper bound of the range of wiki page resources to return (not inclusive)
	 * @return the range of wiki page resources
	 * @throws SystemException if a system exception occurred
	 */
	public List<WikiPageResource> getWikiPageResources(int start, int end)
		throws SystemException {
		return wikiPageResourcePersistence.findAll(start, end);
	}

	/**
	 * Gets the number of wiki page resources.
	 *
	 * @return the number of wiki page resources
	 * @throws SystemException if a system exception occurred
	 */
	public int getWikiPageResourcesCount() throws SystemException {
		return wikiPageResourcePersistence.countAll();
	}

	/**
	 * Updates the wiki page resource in the database. Also notifies the appropriate model listeners.
	 *
	 * @param wikiPageResource the wiki page resource to update
	 * @return the wiki page resource that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public WikiPageResource updateWikiPageResource(
		WikiPageResource wikiPageResource) throws SystemException {
		wikiPageResource.setNew(false);

		return wikiPageResourcePersistence.update(wikiPageResource, true);
	}

	/**
	 * Updates the wiki page resource in the database. Also notifies the appropriate model listeners.
	 *
	 * @param wikiPageResource the wiki page resource to update
	 * @param merge whether to merge the wiki page resource with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the wiki page resource that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public WikiPageResource updateWikiPageResource(
		WikiPageResource wikiPageResource, boolean merge)
		throws SystemException {
		wikiPageResource.setNew(false);

		return wikiPageResourcePersistence.update(wikiPageResource, merge);
	}

	/**
	 * Gets the wiki node local service.
	 *
	 * @return the wiki node local service
	 */
	public WikiNodeLocalService getWikiNodeLocalService() {
		return wikiNodeLocalService;
	}

	/**
	 * Sets the wiki node local service.
	 *
	 * @param wikiNodeLocalService the wiki node local service
	 */
	public void setWikiNodeLocalService(
		WikiNodeLocalService wikiNodeLocalService) {
		this.wikiNodeLocalService = wikiNodeLocalService;
	}

	/**
	 * Gets the wiki node remote service.
	 *
	 * @return the wiki node remote service
	 */
	public WikiNodeService getWikiNodeService() {
		return wikiNodeService;
	}

	/**
	 * Sets the wiki node remote service.
	 *
	 * @param wikiNodeService the wiki node remote service
	 */
	public void setWikiNodeService(WikiNodeService wikiNodeService) {
		this.wikiNodeService = wikiNodeService;
	}

	/**
	 * Gets the wiki node persistence.
	 *
	 * @return the wiki node persistence
	 */
	public WikiNodePersistence getWikiNodePersistence() {
		return wikiNodePersistence;
	}

	/**
	 * Sets the wiki node persistence.
	 *
	 * @param wikiNodePersistence the wiki node persistence
	 */
	public void setWikiNodePersistence(WikiNodePersistence wikiNodePersistence) {
		this.wikiNodePersistence = wikiNodePersistence;
	}

	/**
	 * Gets the wiki page local service.
	 *
	 * @return the wiki page local service
	 */
	public WikiPageLocalService getWikiPageLocalService() {
		return wikiPageLocalService;
	}

	/**
	 * Sets the wiki page local service.
	 *
	 * @param wikiPageLocalService the wiki page local service
	 */
	public void setWikiPageLocalService(
		WikiPageLocalService wikiPageLocalService) {
		this.wikiPageLocalService = wikiPageLocalService;
	}

	/**
	 * Gets the wiki page remote service.
	 *
	 * @return the wiki page remote service
	 */
	public WikiPageService getWikiPageService() {
		return wikiPageService;
	}

	/**
	 * Sets the wiki page remote service.
	 *
	 * @param wikiPageService the wiki page remote service
	 */
	public void setWikiPageService(WikiPageService wikiPageService) {
		this.wikiPageService = wikiPageService;
	}

	/**
	 * Gets the wiki page persistence.
	 *
	 * @return the wiki page persistence
	 */
	public WikiPagePersistence getWikiPagePersistence() {
		return wikiPagePersistence;
	}

	/**
	 * Sets the wiki page persistence.
	 *
	 * @param wikiPagePersistence the wiki page persistence
	 */
	public void setWikiPagePersistence(WikiPagePersistence wikiPagePersistence) {
		this.wikiPagePersistence = wikiPagePersistence;
	}

	/**
	 * Gets the wiki page finder.
	 *
	 * @return the wiki page finder
	 */
	public WikiPageFinder getWikiPageFinder() {
		return wikiPageFinder;
	}

	/**
	 * Sets the wiki page finder.
	 *
	 * @param wikiPageFinder the wiki page finder
	 */
	public void setWikiPageFinder(WikiPageFinder wikiPageFinder) {
		this.wikiPageFinder = wikiPageFinder;
	}

	/**
	 * Gets the wiki page resource local service.
	 *
	 * @return the wiki page resource local service
	 */
	public WikiPageResourceLocalService getWikiPageResourceLocalService() {
		return wikiPageResourceLocalService;
	}

	/**
	 * Sets the wiki page resource local service.
	 *
	 * @param wikiPageResourceLocalService the wiki page resource local service
	 */
	public void setWikiPageResourceLocalService(
		WikiPageResourceLocalService wikiPageResourceLocalService) {
		this.wikiPageResourceLocalService = wikiPageResourceLocalService;
	}

	/**
	 * Gets the wiki page resource persistence.
	 *
	 * @return the wiki page resource persistence
	 */
	public WikiPageResourcePersistence getWikiPageResourcePersistence() {
		return wikiPageResourcePersistence;
	}

	/**
	 * Sets the wiki page resource persistence.
	 *
	 * @param wikiPageResourcePersistence the wiki page resource persistence
	 */
	public void setWikiPageResourcePersistence(
		WikiPageResourcePersistence wikiPageResourcePersistence) {
		this.wikiPageResourcePersistence = wikiPageResourcePersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = wikiPageResourcePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = WikiNodeLocalService.class)
	protected WikiNodeLocalService wikiNodeLocalService;
	@BeanReference(type = WikiNodeService.class)
	protected WikiNodeService wikiNodeService;
	@BeanReference(type = WikiNodePersistence.class)
	protected WikiNodePersistence wikiNodePersistence;
	@BeanReference(type = WikiPageLocalService.class)
	protected WikiPageLocalService wikiPageLocalService;
	@BeanReference(type = WikiPageService.class)
	protected WikiPageService wikiPageService;
	@BeanReference(type = WikiPagePersistence.class)
	protected WikiPagePersistence wikiPagePersistence;
	@BeanReference(type = WikiPageFinder.class)
	protected WikiPageFinder wikiPageFinder;
	@BeanReference(type = WikiPageResourceLocalService.class)
	protected WikiPageResourceLocalService wikiPageResourceLocalService;
	@BeanReference(type = WikiPageResourcePersistence.class)
	protected WikiPageResourcePersistence wikiPageResourcePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
}