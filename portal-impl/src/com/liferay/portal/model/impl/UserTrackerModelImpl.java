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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.UserTracker;
import com.liferay.portal.model.UserTrackerModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the UserTracker service. Represents a row in the &quot;UserTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.UserTrackerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserTrackerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerImpl
 * @see com.liferay.portal.model.UserTracker
 * @see com.liferay.portal.model.UserTrackerModel
 * @generated
 */
public class UserTrackerModelImpl extends BaseModelImpl<UserTracker>
	implements UserTrackerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user tracker model instance should use the {@link com.liferay.portal.model.UserTracker} interface instead.
	 */
	public static final String TABLE_NAME = "UserTracker";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userTrackerId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "modifiedDate", new Integer(Types.TIMESTAMP) },
			{ "sessionId", new Integer(Types.VARCHAR) },
			{ "remoteAddr", new Integer(Types.VARCHAR) },
			{ "remoteHost", new Integer(Types.VARCHAR) },
			{ "userAgent", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table UserTracker (userTrackerId LONG not null primary key,companyId LONG,userId LONG,modifiedDate DATE null,sessionId VARCHAR(200) null,remoteAddr VARCHAR(75) null,remoteHost VARCHAR(75) null,userAgent VARCHAR(200) null)";
	public static final String TABLE_SQL_DROP = "drop table UserTracker";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.UserTracker"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.UserTracker"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.UserTracker"));

	public UserTrackerModelImpl() {
	}

	public long getPrimaryKey() {
		return _userTrackerId;
	}

	public void setPrimaryKey(long pk) {
		setUserTrackerId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userTrackerId);
	}

	public long getUserTrackerId() {
		return _userTrackerId;
	}

	public void setUserTrackerId(long userTrackerId) {
		_userTrackerId = userTrackerId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getSessionId() {
		if (_sessionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _sessionId;
		}
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public String getRemoteAddr() {
		if (_remoteAddr == null) {
			return StringPool.BLANK;
		}
		else {
			return _remoteAddr;
		}
	}

	public void setRemoteAddr(String remoteAddr) {
		_remoteAddr = remoteAddr;
	}

	public String getRemoteHost() {
		if (_remoteHost == null) {
			return StringPool.BLANK;
		}
		else {
			return _remoteHost;
		}
	}

	public void setRemoteHost(String remoteHost) {
		_remoteHost = remoteHost;
	}

	public String getUserAgent() {
		if (_userAgent == null) {
			return StringPool.BLANK;
		}
		else {
			return _userAgent;
		}
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public UserTracker toEscapedModel() {
		if (isEscapedModel()) {
			return (UserTracker)this;
		}
		else {
			return (UserTracker)Proxy.newProxyInstance(UserTracker.class.getClassLoader(),
				new Class[] { UserTracker.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					UserTracker.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		UserTrackerImpl clone = new UserTrackerImpl();

		clone.setUserTrackerId(getUserTrackerId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setSessionId(getSessionId());
		clone.setRemoteAddr(getRemoteAddr());
		clone.setRemoteHost(getRemoteHost());
		clone.setUserAgent(getUserAgent());

		return clone;
	}

	public int compareTo(UserTracker userTracker) {
		long pk = userTracker.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserTracker userTracker = null;

		try {
			userTracker = (UserTracker)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = userTracker.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userTrackerId=");
		sb.append(getUserTrackerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append(", remoteAddr=");
		sb.append(getRemoteAddr());
		sb.append(", remoteHost=");
		sb.append(getRemoteHost());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.UserTracker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userTrackerId</column-name><column-value><![CDATA[");
		sb.append(getUserTrackerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteAddr</column-name><column-value><![CDATA[");
		sb.append(getRemoteAddr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteHost</column-name><column-value><![CDATA[");
		sb.append(getRemoteHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userTrackerId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _modifiedDate;
	private String _sessionId;
	private String _remoteAddr;
	private String _remoteHost;
	private String _userAgent;
	private transient ExpandoBridge _expandoBridge;
}