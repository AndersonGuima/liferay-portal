<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %><%@
page import="com.liferay.petra.string.CharPool" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder" %><%@
page import="com.liferay.portal.kernel.security.auth.PrincipalException" %><%@
page import="com.liferay.portal.kernel.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.security.service.access.policy.constants.SAPActionKeys" %><%@
page import="com.liferay.portal.security.service.access.policy.constants.SAPEntryConstants" %><%@
page import="com.liferay.portal.security.service.access.policy.exception.DuplicateSAPEntryNameException" %><%@
page import="com.liferay.portal.security.service.access.policy.exception.SAPEntryNameException" %><%@
page import="com.liferay.portal.security.service.access.policy.exception.SAPEntryTitleException" %><%@
page import="com.liferay.portal.security.service.access.policy.model.SAPEntry" %><%@
page import="com.liferay.portal.security.service.access.policy.service.SAPEntryServiceUtil" %><%@
page import="com.liferay.portal.security.service.access.policy.util.comparator.SAPEntryNameComparator" %><%@
page import="com.liferay.portal.security.service.access.policy.web.internal.constants.SAPWebKeys" %><%@
page import="com.liferay.portal.security.service.access.policy.web.internal.security.permission.resource.SAPEntryPermission" %><%@
page import="com.liferay.portal.security.service.access.policy.web.internal.security.permission.resource.SAPPermission" %><%@
page import="com.liferay.taglib.search.ResultRow" %>

<%@ page import="javax.portlet.ActionRequest" %><%@
page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />