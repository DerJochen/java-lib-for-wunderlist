package de.jochor.lib.wunderlist.service;

import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;
import de.jochor.lib.wunderlist.model.UpdateListPositionsRequest;
import de.jochor.lib.wunderlist.model.UpdateListPositionsResponse;

/**
 *
 * @author Jochen
 * @start 2015-08-19
 *
 */
public interface PositionsService {

	/**
	 * GET a.wunderlist.com/api/v1/list_positions/:id
	 * @param id
	 * @return
	 */
	RetrieveListPositionsResponse retrieveListPositions(int id);

	/**
	 * PUT or PATCH a.wunderlist.com/api/v1/list_positions/:id
	 * @param id
	 * @param request
	 */
	UpdateListPositionsResponse updateListPositions(int id, UpdateListPositionsRequest request);

}
