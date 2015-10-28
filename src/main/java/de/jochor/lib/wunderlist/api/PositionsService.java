package de.jochor.lib.wunderlist.api;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.List;
import de.jochor.lib.wunderlist.model.Positions;

/**
 * Interface of the {@link PositionsService} of the Wunderlist REST API.
 *
 * <p>
 * Unimplemented methods:
 * </p>
 * <ul>
 * <li>retrieveAll() - Retrieves the {@link Positions} for all {@link List}s of the user</li>
 * <li>...</li>
 * </ul>
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface PositionsService {

	/**
	 * Retrieves the {@link Positions} for a specified {@link List}.<br>
	 * GET a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param id
	 *            ID of the List ? (or of the Positions, needs checking)
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Requested {@link Positions} object
	 */
	Positions retrieve(int id, Authorization authorization);

	/**
	 * PUT or PATCH a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param id
	 *            ID of the List
	 * @param values
	 *            Array of reordered item IDs
	 * @param revision
	 *            Revision of the original {@link Positions}
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Updated {@link Positions} object
	 */
	Positions update(int id, int[] values, int revision, Authorization authorization);

}
