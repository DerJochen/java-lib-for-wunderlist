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
 * <li>updateListPositions() - Updates the {@link Positions} for the users {@link List}s</li>
 * <li>all suptasks methods</li>
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
	 * Retrieves the {@link Positions} objects for all {@link List}s of the user.<br>
	 * GET a.wunderlist.com/api/v1/list_positions
	 *
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return All requested {@link Positions} objects
	 */
	Positions[] retrieveListPositionsAll(Authorization authorization);

	/**
	 * Retrieves the specified {@link Positions} object for {@link List}s.<br>
	 * GET a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Requested {@link Positions} object
	 */
	Positions retrieveListPositions(int positionsID, Authorization authorization);

	/**
	 * Retrieves all {@link Positions} objects for a specified {@link List}.<br>
	 * GET a.wunderlist.com/api/v1/task_positions<br>
	 * Params: list_id
	 *
	 * @param listID
	 *            ID of the {@link List}
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return All requested {@link Positions} objects
	 */
	Positions[] retrieveTaskPositionsAll(int listID, Authorization authorization);

	/**
	 * Retrieves the specified {@link Positions} object for {@link Task}s.<br>
	 * GET a.wunderlist.com/api/v1/task_positions/:id
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Requested {@link Positions} object
	 */
	Positions retrieveTaskPositions(int positionsID, Authorization authorization);

	/**
	 * Updates the {@link Positions} object for a {@link List}.<br>
	 * PUT or PATCH a.wunderlist.com/api/v1/list_positions/:id
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @param values
	 *            Array of reordered {@link Task} IDs
	 * @param revision
	 *            Revision of the original {@link Positions} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Updated {@link Positions} object
	 */
	Positions updateTaskPositions(int positionsID, int[] values, int revision, Authorization authorization);

}
