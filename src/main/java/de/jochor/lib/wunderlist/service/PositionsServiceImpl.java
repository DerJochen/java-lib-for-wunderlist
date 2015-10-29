package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.api.PositionsService;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Positions;

/**
 * Implementation of the {@link PositionsService} of the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-08-24
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class PositionsServiceImpl implements PositionsService {

	private HTTPClient httpClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	@Setter
	private URIProvider uriProvider = new DefaultURIProvider();

	// TODO re-use parts of the old implementation
	// public Positions retrieve(int id, Authorization authorization) {
	// URI uri = uriProvider.getPositionsRetrieveURI(id);
	// GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
	//
	// String responseJSON = httpClient.get(getRequest);
	// Positions response = jsonEntityService.toEntity(responseJSON, Positions.class);
	//
	// return response;
	// }
	//
	// public Positions update(int id, int[] values, int revision, Authorization authorization) {
	// URI uri = uriProvider.getPositionsUpdateURI(id);
	// UpdateListPositionsRequest request = new UpdateListPositionsRequest(values, revision);
	// String requestJSON = jsonEntityService.toJSON(request);
	//
	// PutRequest putRequest = requestFactory.createPutRequest(uri, authorization, requestJSON);
	//
	// String responseJSON = httpClient.put(putRequest);
	// Positions response = jsonEntityService.toEntity(responseJSON, Positions.class);
	//
	// return response;
	// }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions[] retrieveAllListPositions(Authorization authorization) {
		 URI uri = uriProvider.getPositionsListRetrieveAllURI();
		 GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		
		 String responseJSON = httpClient.get(getRequest);
		 Positions[] response = jsonEntityService.toEntity(responseJSON, Positions[].class);
		
		 return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions retrieveListPositions(int positionsID, Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions[] retrieveAllTaskPositions(int listID, Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions retrieveTaskPositions(int positionsID, Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions updateTaskPositions(int positionsID, int[] values, int revision, Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

}
