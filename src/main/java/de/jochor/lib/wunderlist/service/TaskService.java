package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;
import de.jochor.lib.wunderlist.model.Task;

/**
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
	 * GET a.wunderlist.com/api/v1/tasks/:id
	 *
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Array of {@link RetrieveListResponse}s for all lists
	 */
	Task retrieve(int id, Authorization authorization);

}
