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

package com.liferay.jenkins.results.parser.test.clazz.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael Hashimoto
 */
public class SegmentTestClassGroup extends BaseTestClassGroup {

	public void addAxisTestClassGroup(
		int segmentIndex, AxisTestClassGroup axisTestClassGroup) {

		_axisTestClassGroups.put(segmentIndex, axisTestClassGroup);

		axisTestClassGroup.setSegmentTestClassGroup(this, segmentIndex);
	}

	public int getAxisCount() {
		return _axisTestClassGroups.size();
	}

	public AxisTestClassGroup getAxisTestClassGroup(int segmentIndex) {
		return _axisTestClassGroups.get(segmentIndex);
	}

	public List<AxisTestClassGroup> getChildAxisTestClassGroups() {
		return new ArrayList<>(_axisTestClassGroups.values());
	}

	public BatchTestClassGroup getParentBatchTestClassGroup() {
		return _parentBatchTestClassGroup;
	}

	protected SegmentTestClassGroup(
		BatchTestClassGroup parentBatchTestClassGroup, int batchIndex) {

		_parentBatchTestClassGroup = parentBatchTestClassGroup;
	}

	private final Map<Integer, AxisTestClassGroup> _axisTestClassGroups =
		new TreeMap<>();
	private final BatchTestClassGroup _parentBatchTestClassGroup;

}