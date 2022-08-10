/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import ClayAlert from '@clayui/alert';
import Button from '@clayui/button';
import ClayIcon from '@clayui/icon';
import {ArrayHelpers} from 'formik';

import MDFRequestActivity from '../../../../../common/interfaces/mdfRequestActivity';

interface IProps {
	activities: MDFRequestActivity[];
	onAdd: () => void;
}

const Listing = ({activities, onAdd, remove}: IProps & ArrayHelpers) => {
	return (
		<>
			<div>
				<div>
					{activities.length ? (
						activities.map((activity, index) => (
							<div key={index}>
								{activity.name}

								<Button onClick={() => remove(index)}>-</Button>
							</div>
						))
					) : (
						<ClayAlert displayType="info" title="Info:">
							No entries were found
						</ClayAlert>
					)}
				</div>

				<Button className="d-flex" onClick={onAdd} outline small>
					<span className="inline-item inline-item-before">
						<ClayIcon symbol="plus" />
					</span>
					Add Activity
				</Button>
			</div>
		</>
	);
};

export default Listing;
