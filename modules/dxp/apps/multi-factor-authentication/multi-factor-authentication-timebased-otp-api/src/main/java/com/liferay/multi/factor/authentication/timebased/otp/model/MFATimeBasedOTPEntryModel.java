/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.multi.factor.authentication.timebased.otp.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MFATimeBasedOTPEntry service. Represents a row in the &quot;MFATimeBasedOTPEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.multi.factor.authentication.timebased.otp.model.impl.MFATimeBasedOTPEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.multi.factor.authentication.timebased.otp.model.impl.MFATimeBasedOTPEntryImpl</code>.
 * </p>
 *
 * @author Arthur Chan
 * @see MFATimeBasedOTPEntry
 * @generated
 */
@ProviderType
public interface MFATimeBasedOTPEntryModel
	extends AuditedModel, BaseModel<MFATimeBasedOTPEntry>, MVCCModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mfa time based otp entry model instance should use the {@link MFATimeBasedOTPEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this mfa time based otp entry.
	 *
	 * @return the primary key of this mfa time based otp entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mfa time based otp entry.
	 *
	 * @param primaryKey the primary key of this mfa time based otp entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this mfa time based otp entry.
	 *
	 * @return the mvcc version of this mfa time based otp entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this mfa time based otp entry.
	 *
	 * @param mvccVersion the mvcc version of this mfa time based otp entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the mfa time based otp entry ID of this mfa time based otp entry.
	 *
	 * @return the mfa time based otp entry ID of this mfa time based otp entry
	 */
	public long getMfaTimeBasedOTPEntryId();

	/**
	 * Sets the mfa time based otp entry ID of this mfa time based otp entry.
	 *
	 * @param mfaTimeBasedOTPEntryId the mfa time based otp entry ID of this mfa time based otp entry
	 */
	public void setMfaTimeBasedOTPEntryId(long mfaTimeBasedOTPEntryId);

	/**
	 * Returns the company ID of this mfa time based otp entry.
	 *
	 * @return the company ID of this mfa time based otp entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this mfa time based otp entry.
	 *
	 * @param companyId the company ID of this mfa time based otp entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this mfa time based otp entry.
	 *
	 * @return the user ID of this mfa time based otp entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this mfa time based otp entry.
	 *
	 * @param userId the user ID of this mfa time based otp entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mfa time based otp entry.
	 *
	 * @return the user uuid of this mfa time based otp entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this mfa time based otp entry.
	 *
	 * @param userUuid the user uuid of this mfa time based otp entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this mfa time based otp entry.
	 *
	 * @return the user name of this mfa time based otp entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this mfa time based otp entry.
	 *
	 * @param userName the user name of this mfa time based otp entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this mfa time based otp entry.
	 *
	 * @return the create date of this mfa time based otp entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this mfa time based otp entry.
	 *
	 * @param createDate the create date of this mfa time based otp entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this mfa time based otp entry.
	 *
	 * @return the modified date of this mfa time based otp entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this mfa time based otp entry.
	 *
	 * @param modifiedDate the modified date of this mfa time based otp entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the failed attempts of this mfa time based otp entry.
	 *
	 * @return the failed attempts of this mfa time based otp entry
	 */
	public int getFailedAttempts();

	/**
	 * Sets the failed attempts of this mfa time based otp entry.
	 *
	 * @param failedAttempts the failed attempts of this mfa time based otp entry
	 */
	public void setFailedAttempts(int failedAttempts);

	/**
	 * Returns the last fail date of this mfa time based otp entry.
	 *
	 * @return the last fail date of this mfa time based otp entry
	 */
	public Date getLastFailDate();

	/**
	 * Sets the last fail date of this mfa time based otp entry.
	 *
	 * @param lastFailDate the last fail date of this mfa time based otp entry
	 */
	public void setLastFailDate(Date lastFailDate);

	/**
	 * Returns the last fail ip of this mfa time based otp entry.
	 *
	 * @return the last fail ip of this mfa time based otp entry
	 */
	@AutoEscape
	public String getLastFailIP();

	/**
	 * Sets the last fail ip of this mfa time based otp entry.
	 *
	 * @param lastFailIP the last fail ip of this mfa time based otp entry
	 */
	public void setLastFailIP(String lastFailIP);

	/**
	 * Returns the last success date of this mfa time based otp entry.
	 *
	 * @return the last success date of this mfa time based otp entry
	 */
	public Date getLastSuccessDate();

	/**
	 * Sets the last success date of this mfa time based otp entry.
	 *
	 * @param lastSuccessDate the last success date of this mfa time based otp entry
	 */
	public void setLastSuccessDate(Date lastSuccessDate);

	/**
	 * Returns the last success ip of this mfa time based otp entry.
	 *
	 * @return the last success ip of this mfa time based otp entry
	 */
	@AutoEscape
	public String getLastSuccessIP();

	/**
	 * Sets the last success ip of this mfa time based otp entry.
	 *
	 * @param lastSuccessIP the last success ip of this mfa time based otp entry
	 */
	public void setLastSuccessIP(String lastSuccessIP);

	/**
	 * Returns the shared secret of this mfa time based otp entry.
	 *
	 * @return the shared secret of this mfa time based otp entry
	 */
	@AutoEscape
	public String getSharedSecret();

	/**
	 * Sets the shared secret of this mfa time based otp entry.
	 *
	 * @param sharedSecret the shared secret of this mfa time based otp entry
	 */
	public void setSharedSecret(String sharedSecret);

	@Override
	public MFATimeBasedOTPEntry cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}