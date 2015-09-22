package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;
import de.jochor.lib.wunderlist.model.UpdateListPositionsResponse;

/**
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen
 *
 */
public interface PositionsService {

	/**
	 * GET a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param id
	 *            ID of the List
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link RetrieveListPositionsResponse} for the requested positions
	 */
	RetrieveListPositionsResponse retrieve(int id, Authorization authorization);

	/**
	 * PUT or PATCH a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param id
	 *            ID of the List
	 * @param values
	 *            Array of reordered item IDs
	 * @param revision
	 *            Revision of the original {@link RetrieveListPositionsResponse}
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link UpdateListPositionsResponse} object
	 */
	UpdateListPositionsResponse update(int id, int[] values, int revision, Authorization authorization);

}
