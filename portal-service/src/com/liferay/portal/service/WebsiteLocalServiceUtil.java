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

package com.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the website local service. This utility wraps {@link com.liferay.portal.service.impl.WebsiteLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebsiteLocalService
 * @see com.liferay.portal.service.base.WebsiteLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.WebsiteLocalServiceImpl
 * @generated
 */
public class WebsiteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.WebsiteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the website to the database. Also notifies the appropriate model listeners.
	*
	* @param website the website to add
	* @return the website that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Website addWebsite(
		com.liferay.portal.model.Website website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWebsite(website);
	}

	/**
	* Creates a new website with the primary key. Does not add the website to the database.
	*
	* @param websiteId the primary key for the new website
	* @return the new website
	*/
	public static com.liferay.portal.model.Website createWebsite(long websiteId) {
		return getService().createWebsite(websiteId);
	}

	/**
	* Deletes the website with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param websiteId the primary key of the website to delete
	* @throws PortalException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWebsite(long websiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWebsite(websiteId);
	}

	/**
	* Deletes the website from the database. Also notifies the appropriate model listeners.
	*
	* @param website the website to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWebsite(com.liferay.portal.model.Website website)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWebsite(website);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the website with the primary key.
	*
	* @param websiteId the primary key of the website to get
	* @return the website
	* @throws PortalException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Website getWebsite(long websiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebsite(websiteId);
	}

	/**
	* Gets a range of all the websites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of websites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Website> getWebsites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebsites(start, end);
	}

	/**
	* Gets the number of websites.
	*
	* @return the number of websites
	* @throws SystemException if a system exception occurred
	*/
	public static int getWebsitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebsitesCount();
	}

	/**
	* Updates the website in the database. Also notifies the appropriate model listeners.
	*
	* @param website the website to update
	* @return the website that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Website updateWebsite(
		com.liferay.portal.model.Website website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWebsite(website);
	}

	/**
	* Updates the website in the database. Also notifies the appropriate model listeners.
	*
	* @param website the website to update
	* @param merge whether to merge the website with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the website that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Website updateWebsite(
		com.liferay.portal.model.Website website, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWebsite(website, merge);
	}

	public static com.liferay.portal.model.Website addWebsite(long userId,
		java.lang.String className, long classPK, java.lang.String url,
		int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWebsite(userId, className, classPK, url, typeId, primary);
	}

	public static void deleteWebsites(long companyId,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWebsites(companyId, className, classPK);
	}

	public static java.util.List<com.liferay.portal.model.Website> getWebsites()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebsites();
	}

	public static java.util.List<com.liferay.portal.model.Website> getWebsites(
		long companyId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebsites(companyId, className, classPK);
	}

	public static com.liferay.portal.model.Website updateWebsite(
		long websiteId, java.lang.String url, int typeId, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWebsite(websiteId, url, typeId, primary);
	}

	public static WebsiteLocalService getService() {
		if (_service == null) {
			_service = (WebsiteLocalService)PortalBeanLocatorUtil.locate(WebsiteLocalService.class.getName());

			ReferenceRegistry.registerReference(WebsiteLocalServiceUtil.class,
				"_service");
			MethodCache.remove(WebsiteLocalService.class);
		}

		return _service;
	}

	public void setService(WebsiteLocalService service) {
		MethodCache.remove(WebsiteLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(WebsiteLocalServiceUtil.class,
			"_service");
		MethodCache.remove(WebsiteLocalService.class);
	}

	private static WebsiteLocalService _service;
}