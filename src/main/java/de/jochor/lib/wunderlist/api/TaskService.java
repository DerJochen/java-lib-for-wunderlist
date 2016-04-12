package de.jochor.lib.wunderlist.api;

import java.util.List;
import java.util.Map;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Interface of the {@link TaskService} of the Wunderlist REST API.
 *
 * <p>
 * Unimplemented methods:
 * </p>
 * <ul>
 * <li>create() - Creates a new {@link Task}</li>
 * <li>update() - Updates a {@link Task}</li>
 * <li>delete() - Deletes a {@link Task} permanently</li>
 * </ul>
 *
 * <p>
 * <b>Started:</b> 2015-09-23
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface TaskService {

	/**
	 * Retrieves all active {@link Task}s of a list.<br>
	 * GET a.wunderlist.com/api/v1/tasks<br>
	 * Params: list_id
	 *
	 * @param listID
	 *            ID of the list
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Array of {@link Task}s for the lists
	 */
	Task[] retrieveAll(int listID, Authorization authorization);

	/**
	 * Retrieves all completed {@link Task}s of a list.<br>
	 * GET a.wunderlist.com/api/v1/tasks<br>
	 * Params: list_id, completed
	 *
	 * @param listID
	 *            ID of the list
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Array of {@link Task}s for the lists
	 */
	Task[] retrieveAllCompleted(int listID, Authorization authorization);

	/**
	 * Retrieves one specific {@link Task}.<br>
	 * GET a.wunderlist.com/api/v1/tasks/:id
	 *
	 * @param taskID
	 *            ID of the {@link Task} to retrieve
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Specified {@link Task}
	 */
	Task retrieve(int taskID, Authorization authorization);

	/**
	 * Update a {@link Task} by overwriting properties.<br>
	 * PATCH a.wunderlist.com/api/v1/tasks/:id
	 *
	 * @param taskId
	 *            ID of the {@link Task} to update
	 * @param changes
	 *            Map containing the changed properties
	 * @param removed
	 *            List of the removed properties
	 * @param revision
	 *            Revision of the original {@link Task} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Updated {@link Task}
	 */
	Task update(int taskId, Map<String, Object> changes, List<String> removed, int revision, Authorization authorization);

}
