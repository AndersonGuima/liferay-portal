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

package com.liferay.portlet.blogs.model;

/**
 * The model interface for the BlogsEntry service. Represents a row in the &quot;BlogsEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.blogs.model.impl.BlogsEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlogsEntryModel
 * @see com.liferay.portlet.blogs.model.impl.BlogsEntryImpl
 * @see com.liferay.portlet.blogs.model.impl.BlogsEntryModelImpl
 * @generated
 */
public interface BlogsEntry extends BlogsEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. All methods that expect a blogs entry model instance should use the {@link BlogsEntry} interface instead.
	 */
	public java.lang.String getSmallImageType()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setSmallImageType(java.lang.String smallImageType);
}