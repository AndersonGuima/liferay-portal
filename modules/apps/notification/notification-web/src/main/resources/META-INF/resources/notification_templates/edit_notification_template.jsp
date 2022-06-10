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

<%@ include file="/init.jsp" %>

<%
ViewNotificationTemplatesDisplayContext viewNotificationTemplatesDisplayContext = (ViewNotificationTemplatesDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

NotificationTemplate notificationTemplate = viewNotificationTemplatesDisplayContext.getNotificationTemplate();

long editingNotificationTemplateId = 0;

if (notificationTemplate != null) {
	editingNotificationTemplateId = notificationTemplate.getNotificationTemplateId();
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);
%>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" var="baseResourceURL" />

<react:component
	module="js/components/EditNotificationTemplate"
	props='<%=
		HashMapBuilder.<String, Object>put(
			"baseResourceURL", String.valueOf(baseResourceURL)
		).put(
			"editingNotificationTemplateId", editingNotificationTemplateId
		).put(
			"editorConfig", viewNotificationTemplatesDisplayContext.getEditorConfig("rich_text")
		).build()
	%>'
/>