package de.jochor.lib.wunderlist.api;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.List;

/**
 * Interface of the {@link ListService} of the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface ListService {

	/**
	 * GET a.wunderlist.com/api/v1/lists
	 *
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return Array with all {@link List}s
	 */
	List[] retrieveAll(Authorization authorization);

	/**
	 * GET a.wunderlist.com/api/v1/lists/:id
	 *
	 * @param listID
	 *            ID of the List
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return The requested {@link List}
	 */
	List retrieve(int listID, Authorization authorization);

}
