package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;

/**
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
	 * @return Array of {@link RetrieveListResponse}s for all lists
	 */
	RetrieveListResponse[] retrieveAll(Authorization authorization);

	/**
	 * GET a.wunderlist.com/api/v1/lists/:id
	 *
	 * @param id
	 *            ID of the List
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link RetrieveListResponse} for the requested list
	 */
	RetrieveListResponse retrieve(int id, Authorization authorization);

}
