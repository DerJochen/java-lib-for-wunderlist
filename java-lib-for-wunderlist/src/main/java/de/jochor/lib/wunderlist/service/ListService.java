package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.RetrieveAllListsResponse;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-19
 *
 */
public interface ListService {

	/**
	 * GET a.wunderlist.com/api/v1/lists
	 * @return
	 */
	RetrieveAllListsResponse retrieveAll();

	/**
	 * GET a.wunderlist.com/api/v1/lists/:id
	 * @param id
	 * @return
	 */
	RetrieveListResponse retrieve(int id);

}
