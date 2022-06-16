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

package com.liferay.portal.search.tuning.rankings.web.internal.application.list;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.search.tuning.rankings.web.internal.constants.ResultRankingsPortletKeys;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Wade Cao
 */
public class ResultRankingsPanelAppTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Before
	public void setUp() throws Exception {
		_resultRankingsPanelApp = new ResultRankingsPanelApp();

		ReflectionTestUtil.setFieldValue(
			_resultRankingsPanelApp, "_portletLocalService",
			_portletLocalService);
	}

	@Test
	public void testGetPortletId() {
		Assert.assertEquals(
			ResultRankingsPortletKeys.RESULT_RANKINGS,
			_resultRankingsPanelApp.getPortletId());
	}

	@Test
	public void testIsShow() throws Exception {
		Portlet portlet = Mockito.mock(Portlet.class);

		Mockito.doReturn(
			false
		).when(
			portlet
		).isActive();

		Mockito.doReturn(
			portlet
		).when(
			_portletLocalService
		).getPortletById(
			Mockito.anyLong(), Mockito.anyString()
		);

		Assert.assertFalse(
			_resultRankingsPanelApp.isShow(
				Mockito.mock(PermissionChecker.class),
				Mockito.mock(Group.class)));
	}

	@Test
	public void testSetPortlet() {
		Portlet portlet = Mockito.mock(Portlet.class);

		_resultRankingsPanelApp.setPortlet(portlet);

		Assert.assertEquals(portlet, _resultRankingsPanelApp.getPortlet());
	}

	private final PortletLocalService _portletLocalService = Mockito.mock(
		PortletLocalService.class);
	private ResultRankingsPanelApp _resultRankingsPanelApp;

}