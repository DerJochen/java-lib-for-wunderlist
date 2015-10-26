package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Interface of the {@link TaskService} of the Wunderlist REST API.
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
	 * GET a.wunderlist.com/api/v1/tasks/:id
	 *
	 * @param id
	 *            ID of the task to retrieve
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Specified {@link Task}
	 */
	Task retrieve(int id, Authorization authorization);

}
