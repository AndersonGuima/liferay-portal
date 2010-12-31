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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PasswordPolicy service. Represents a row in the &quot;PasswordPolicy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.PasswordPolicyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.PasswordPolicyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PasswordPolicy
 * @see com.liferay.portal.model.impl.PasswordPolicyImpl
 * @see com.liferay.portal.model.impl.PasswordPolicyModelImpl
 * @generated
 */
public interface PasswordPolicyModel extends BaseModel<PasswordPolicy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a password policy model instance should use the {@link PasswordPolicy} interface instead.
	 */

	/**
	 * Gets the primary key of this password policy.
	 *
	 * @return the primary key of this password policy
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this password policy
	 *
	 * @param pk the primary key of this password policy
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the password policy ID of this password policy.
	 *
	 * @return the password policy ID of this password policy
	 */
	public long getPasswordPolicyId();

	/**
	 * Sets the password policy ID of this password policy.
	 *
	 * @param passwordPolicyId the password policy ID of this password policy
	 */
	public void setPasswordPolicyId(long passwordPolicyId);

	/**
	 * Gets the company ID of this password policy.
	 *
	 * @return the company ID of this password policy
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this password policy.
	 *
	 * @param companyId the company ID of this password policy
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user ID of this password policy.
	 *
	 * @return the user ID of this password policy
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this password policy.
	 *
	 * @param userId the user ID of this password policy
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this password policy.
	 *
	 * @return the user uuid of this password policy
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this password policy.
	 *
	 * @param userUuid the user uuid of this password policy
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this password policy.
	 *
	 * @return the user name of this password policy
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this password policy.
	 *
	 * @param userName the user name of this password policy
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this password policy.
	 *
	 * @return the create date of this password policy
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this password policy.
	 *
	 * @param createDate the create date of this password policy
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this password policy.
	 *
	 * @return the modified date of this password policy
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this password policy.
	 *
	 * @param modifiedDate the modified date of this password policy
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the default policy of this password policy.
	 *
	 * @return the default policy of this password policy
	 */
	public boolean getDefaultPolicy();

	/**
	 * Determines if this password policy is default policy.
	 *
	 * @return <code>true</code> if this password policy is default policy; <code>false</code> otherwise
	 */
	public boolean isDefaultPolicy();

	/**
	 * Sets whether this password policy is default policy.
	 *
	 * @param defaultPolicy the default policy of this password policy
	 */
	public void setDefaultPolicy(boolean defaultPolicy);

	/**
	 * Gets the name of this password policy.
	 *
	 * @return the name of this password policy
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this password policy.
	 *
	 * @param name the name of this password policy
	 */
	public void setName(String name);

	/**
	 * Gets the description of this password policy.
	 *
	 * @return the description of this password policy
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this password policy.
	 *
	 * @param description the description of this password policy
	 */
	public void setDescription(String description);

	/**
	 * Gets the changeable of this password policy.
	 *
	 * @return the changeable of this password policy
	 */
	public boolean getChangeable();

	/**
	 * Determines if this password policy is changeable.
	 *
	 * @return <code>true</code> if this password policy is changeable; <code>false</code> otherwise
	 */
	public boolean isChangeable();

	/**
	 * Sets whether this password policy is changeable.
	 *
	 * @param changeable the changeable of this password policy
	 */
	public void setChangeable(boolean changeable);

	/**
	 * Gets the change required of this password policy.
	 *
	 * @return the change required of this password policy
	 */
	public boolean getChangeRequired();

	/**
	 * Determines if this password policy is change required.
	 *
	 * @return <code>true</code> if this password policy is change required; <code>false</code> otherwise
	 */
	public boolean isChangeRequired();

	/**
	 * Sets whether this password policy is change required.
	 *
	 * @param changeRequired the change required of this password policy
	 */
	public void setChangeRequired(boolean changeRequired);

	/**
	 * Gets the min age of this password policy.
	 *
	 * @return the min age of this password policy
	 */
	public long getMinAge();

	/**
	 * Sets the min age of this password policy.
	 *
	 * @param minAge the min age of this password policy
	 */
	public void setMinAge(long minAge);

	/**
	 * Gets the check syntax of this password policy.
	 *
	 * @return the check syntax of this password policy
	 */
	public boolean getCheckSyntax();

	/**
	 * Determines if this password policy is check syntax.
	 *
	 * @return <code>true</code> if this password policy is check syntax; <code>false</code> otherwise
	 */
	public boolean isCheckSyntax();

	/**
	 * Sets whether this password policy is check syntax.
	 *
	 * @param checkSyntax the check syntax of this password policy
	 */
	public void setCheckSyntax(boolean checkSyntax);

	/**
	 * Gets the allow dictionary words of this password policy.
	 *
	 * @return the allow dictionary words of this password policy
	 */
	public boolean getAllowDictionaryWords();

	/**
	 * Determines if this password policy is allow dictionary words.
	 *
	 * @return <code>true</code> if this password policy is allow dictionary words; <code>false</code> otherwise
	 */
	public boolean isAllowDictionaryWords();

	/**
	 * Sets whether this password policy is allow dictionary words.
	 *
	 * @param allowDictionaryWords the allow dictionary words of this password policy
	 */
	public void setAllowDictionaryWords(boolean allowDictionaryWords);

	/**
	 * Gets the min alphanumeric of this password policy.
	 *
	 * @return the min alphanumeric of this password policy
	 */
	public int getMinAlphanumeric();

	/**
	 * Sets the min alphanumeric of this password policy.
	 *
	 * @param minAlphanumeric the min alphanumeric of this password policy
	 */
	public void setMinAlphanumeric(int minAlphanumeric);

	/**
	 * Gets the min length of this password policy.
	 *
	 * @return the min length of this password policy
	 */
	public int getMinLength();

	/**
	 * Sets the min length of this password policy.
	 *
	 * @param minLength the min length of this password policy
	 */
	public void setMinLength(int minLength);

	/**
	 * Gets the min lower case of this password policy.
	 *
	 * @return the min lower case of this password policy
	 */
	public int getMinLowerCase();

	/**
	 * Sets the min lower case of this password policy.
	 *
	 * @param minLowerCase the min lower case of this password policy
	 */
	public void setMinLowerCase(int minLowerCase);

	/**
	 * Gets the min numbers of this password policy.
	 *
	 * @return the min numbers of this password policy
	 */
	public int getMinNumbers();

	/**
	 * Sets the min numbers of this password policy.
	 *
	 * @param minNumbers the min numbers of this password policy
	 */
	public void setMinNumbers(int minNumbers);

	/**
	 * Gets the min symbols of this password policy.
	 *
	 * @return the min symbols of this password policy
	 */
	public int getMinSymbols();

	/**
	 * Sets the min symbols of this password policy.
	 *
	 * @param minSymbols the min symbols of this password policy
	 */
	public void setMinSymbols(int minSymbols);

	/**
	 * Gets the min upper case of this password policy.
	 *
	 * @return the min upper case of this password policy
	 */
	public int getMinUpperCase();

	/**
	 * Sets the min upper case of this password policy.
	 *
	 * @param minUpperCase the min upper case of this password policy
	 */
	public void setMinUpperCase(int minUpperCase);

	/**
	 * Gets the history of this password policy.
	 *
	 * @return the history of this password policy
	 */
	public boolean getHistory();

	/**
	 * Determines if this password policy is history.
	 *
	 * @return <code>true</code> if this password policy is history; <code>false</code> otherwise
	 */
	public boolean isHistory();

	/**
	 * Sets whether this password policy is history.
	 *
	 * @param history the history of this password policy
	 */
	public void setHistory(boolean history);

	/**
	 * Gets the history count of this password policy.
	 *
	 * @return the history count of this password policy
	 */
	public int getHistoryCount();

	/**
	 * Sets the history count of this password policy.
	 *
	 * @param historyCount the history count of this password policy
	 */
	public void setHistoryCount(int historyCount);

	/**
	 * Gets the expireable of this password policy.
	 *
	 * @return the expireable of this password policy
	 */
	public boolean getExpireable();

	/**
	 * Determines if this password policy is expireable.
	 *
	 * @return <code>true</code> if this password policy is expireable; <code>false</code> otherwise
	 */
	public boolean isExpireable();

	/**
	 * Sets whether this password policy is expireable.
	 *
	 * @param expireable the expireable of this password policy
	 */
	public void setExpireable(boolean expireable);

	/**
	 * Gets the max age of this password policy.
	 *
	 * @return the max age of this password policy
	 */
	public long getMaxAge();

	/**
	 * Sets the max age of this password policy.
	 *
	 * @param maxAge the max age of this password policy
	 */
	public void setMaxAge(long maxAge);

	/**
	 * Gets the warning time of this password policy.
	 *
	 * @return the warning time of this password policy
	 */
	public long getWarningTime();

	/**
	 * Sets the warning time of this password policy.
	 *
	 * @param warningTime the warning time of this password policy
	 */
	public void setWarningTime(long warningTime);

	/**
	 * Gets the grace limit of this password policy.
	 *
	 * @return the grace limit of this password policy
	 */
	public int getGraceLimit();

	/**
	 * Sets the grace limit of this password policy.
	 *
	 * @param graceLimit the grace limit of this password policy
	 */
	public void setGraceLimit(int graceLimit);

	/**
	 * Gets the lockout of this password policy.
	 *
	 * @return the lockout of this password policy
	 */
	public boolean getLockout();

	/**
	 * Determines if this password policy is lockout.
	 *
	 * @return <code>true</code> if this password policy is lockout; <code>false</code> otherwise
	 */
	public boolean isLockout();

	/**
	 * Sets whether this password policy is lockout.
	 *
	 * @param lockout the lockout of this password policy
	 */
	public void setLockout(boolean lockout);

	/**
	 * Gets the max failure of this password policy.
	 *
	 * @return the max failure of this password policy
	 */
	public int getMaxFailure();

	/**
	 * Sets the max failure of this password policy.
	 *
	 * @param maxFailure the max failure of this password policy
	 */
	public void setMaxFailure(int maxFailure);

	/**
	 * Gets the lockout duration of this password policy.
	 *
	 * @return the lockout duration of this password policy
	 */
	public long getLockoutDuration();

	/**
	 * Sets the lockout duration of this password policy.
	 *
	 * @param lockoutDuration the lockout duration of this password policy
	 */
	public void setLockoutDuration(long lockoutDuration);

	/**
	 * Gets the require unlock of this password policy.
	 *
	 * @return the require unlock of this password policy
	 */
	public boolean getRequireUnlock();

	/**
	 * Determines if this password policy is require unlock.
	 *
	 * @return <code>true</code> if this password policy is require unlock; <code>false</code> otherwise
	 */
	public boolean isRequireUnlock();

	/**
	 * Sets whether this password policy is require unlock.
	 *
	 * @param requireUnlock the require unlock of this password policy
	 */
	public void setRequireUnlock(boolean requireUnlock);

	/**
	 * Gets the reset failure count of this password policy.
	 *
	 * @return the reset failure count of this password policy
	 */
	public long getResetFailureCount();

	/**
	 * Sets the reset failure count of this password policy.
	 *
	 * @param resetFailureCount the reset failure count of this password policy
	 */
	public void setResetFailureCount(long resetFailureCount);

	/**
	 * Gets the reset ticket max age of this password policy.
	 *
	 * @return the reset ticket max age of this password policy
	 */
	public long getResetTicketMaxAge();

	/**
	 * Sets the reset ticket max age of this password policy.
	 *
	 * @param resetTicketMaxAge the reset ticket max age of this password policy
	 */
	public void setResetTicketMaxAge(long resetTicketMaxAge);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PasswordPolicy passwordPolicy);

	public int hashCode();

	public PasswordPolicy toEscapedModel();

	public String toString();

	public String toXmlString();
}