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

import {ADD_FRAGMENT_COMPOSITION, INIT} from '../actions/types';
import {LAYOUT_DATA_ITEM_TYPES} from '../config/constants/layoutDataItemTypes';

const CONTENT_DISPLAY_COLLECTION_ID = 'content-display';

export default function fragmentsReducer(fragments = [], action) {
	switch (action.type) {
		case ADD_FRAGMENT_COMPOSITION: {
			const composition = action.fragmentComposition;
			const existingCollection = fragments.find(
				(collection) =>
					collection.fragmentCollectionId ===
					composition.fragmentCollectionId
			);

			const newCollection = existingCollection
				? {
						...existingCollection,
						fragmentEntries: [
							...existingCollection.fragmentEntries,
							composition,
						],
				  }
				: {
						fragmentCollectionId: composition.fragmentCollectionId,
						fragmentEntries: [composition],
						name: composition.fragmentCollectionName,
				  };

			return [
				...fragments.filter(
					(collection) =>
						collection.fragmentCollectionId !==
						newCollection.fragmentCollectionId
				),

				newCollection,
			];
		}

		case INIT: {
			const contentDisplayCollection = fragments.find(
				(fragment) =>
					fragment.fragmentCollectionId ===
					CONTENT_DISPLAY_COLLECTION_ID
			);

			const newFragments = fragments.filter(
				(fragment) =>
					fragment.fragmentCollectionId !==
					CONTENT_DISPLAY_COLLECTION_ID
			);

			newFragments.unshift({
				fragmentCollectionId: 'layout-elements',
				fragmentEntries: [
					{
						data: {
							itemType: LAYOUT_DATA_ITEM_TYPES.container,
						},
						icon: 'table',
						itemId: 'container',
						label: Liferay.Language.get('section'),
						type: 'container',
					},
					{
						data: {
							itemType: LAYOUT_DATA_ITEM_TYPES.row,
						},
						icon: 'table',
						itemId: 'row',
						label: Liferay.Language.get('row'),
						type: 'row',
					},
				],
				name: Liferay.Language.get('layout-elements'),
			});

			if (contentDisplayCollection) {
				newFragments.splice(2, 0, {
					...contentDisplayCollection,

					fragmentEntries: [
						...contentDisplayCollection.fragmentEntries,

						{
							data: {
								itemType: LAYOUT_DATA_ITEM_TYPES.collection,
							},
							icon: 'list',
							itemId: 'collection-display',
							label: Liferay.Language.get('collection-display'),
							type: LAYOUT_DATA_ITEM_TYPES.collection,
						},
					],
				});
			}

			return newFragments;
		}

		default:
			return fragments;
	}
}
