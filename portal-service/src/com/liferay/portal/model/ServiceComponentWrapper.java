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

package com.liferay.portal.model;

/**
 * <p>
 * This class is a wrapper for {@link ServiceComponent}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ServiceComponent
 * @generated
 */
public class ServiceComponentWrapper implements ServiceComponent {
	public ServiceComponentWrapper(ServiceComponent serviceComponent) {
		_serviceComponent = serviceComponent;
	}

	/**
	* Gets the primary key of this service component.
	*
	* @return the primary key of this service component
	*/
	public long getPrimaryKey() {
		return _serviceComponent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service component
	*
	* @param pk the primary key of this service component
	*/
	public void setPrimaryKey(long pk) {
		_serviceComponent.setPrimaryKey(pk);
	}

	/**
	* Gets the service component ID of this service component.
	*
	* @return the service component ID of this service component
	*/
	public long getServiceComponentId() {
		return _serviceComponent.getServiceComponentId();
	}

	/**
	* Sets the service component ID of this service component.
	*
	* @param serviceComponentId the service component ID of this service component
	*/
	public void setServiceComponentId(long serviceComponentId) {
		_serviceComponent.setServiceComponentId(serviceComponentId);
	}

	/**
	* Gets the build namespace of this service component.
	*
	* @return the build namespace of this service component
	*/
	public java.lang.String getBuildNamespace() {
		return _serviceComponent.getBuildNamespace();
	}

	/**
	* Sets the build namespace of this service component.
	*
	* @param buildNamespace the build namespace of this service component
	*/
	public void setBuildNamespace(java.lang.String buildNamespace) {
		_serviceComponent.setBuildNamespace(buildNamespace);
	}

	/**
	* Gets the build number of this service component.
	*
	* @return the build number of this service component
	*/
	public long getBuildNumber() {
		return _serviceComponent.getBuildNumber();
	}

	/**
	* Sets the build number of this service component.
	*
	* @param buildNumber the build number of this service component
	*/
	public void setBuildNumber(long buildNumber) {
		_serviceComponent.setBuildNumber(buildNumber);
	}

	/**
	* Gets the build date of this service component.
	*
	* @return the build date of this service component
	*/
	public long getBuildDate() {
		return _serviceComponent.getBuildDate();
	}

	/**
	* Sets the build date of this service component.
	*
	* @param buildDate the build date of this service component
	*/
	public void setBuildDate(long buildDate) {
		_serviceComponent.setBuildDate(buildDate);
	}

	/**
	* Gets the data of this service component.
	*
	* @return the data of this service component
	*/
	public java.lang.String getData() {
		return _serviceComponent.getData();
	}

	/**
	* Sets the data of this service component.
	*
	* @param data the data of this service component
	*/
	public void setData(java.lang.String data) {
		_serviceComponent.setData(data);
	}

	public boolean isNew() {
		return _serviceComponent.isNew();
	}

	public void setNew(boolean n) {
		_serviceComponent.setNew(n);
	}

	public boolean isCachedModel() {
		return _serviceComponent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_serviceComponent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _serviceComponent.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_serviceComponent.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceComponent.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceComponent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceComponent.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ServiceComponentWrapper((ServiceComponent)_serviceComponent.clone());
	}

	public int compareTo(
		com.liferay.portal.model.ServiceComponent serviceComponent) {
		return _serviceComponent.compareTo(serviceComponent);
	}

	public int hashCode() {
		return _serviceComponent.hashCode();
	}

	public com.liferay.portal.model.ServiceComponent toEscapedModel() {
		return new ServiceComponentWrapper(_serviceComponent.toEscapedModel());
	}

	public java.lang.String toString() {
		return _serviceComponent.toString();
	}

	public java.lang.String toXmlString() {
		return _serviceComponent.toXmlString();
	}

	public java.lang.String getTablesSQL() {
		return _serviceComponent.getTablesSQL();
	}

	public java.lang.String getSequencesSQL() {
		return _serviceComponent.getSequencesSQL();
	}

	public java.lang.String getIndexesSQL() {
		return _serviceComponent.getIndexesSQL();
	}

	public ServiceComponent getWrappedServiceComponent() {
		return _serviceComponent;
	}

	private ServiceComponent _serviceComponent;
}