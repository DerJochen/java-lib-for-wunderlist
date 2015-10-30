package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.api.PositionsService;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Positions;
import de.jochor.lib.wunderlist.transfer.UpdatePositionsRequest;

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
		 URI uri = uriProvider.getPositionsListRetrieveURI(positionsID);
		 GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		
		 String responseJSON = httpClient.get(getRequest);
		 Positions response = jsonEntityService.toEntity(responseJSON, Positions.class);
		
		 return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions[] retrieveAllTaskPositions(int listID, Authorization authorization) {
		 URI uri = uriProvider.getPositionsTaskRetrieveAllURI();
		 GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		 getRequest.setQueryParameter("list_id", listID);
		
		 String responseJSON = httpClient.get(getRequest);
		 Positions[] response = jsonEntityService.toEntity(responseJSON, Positions[].class);
		
		 return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions retrieveTaskPositions(int positionsID, Authorization authorization) {
		 URI uri = uriProvider.getPositionsTaskRetrieveURI(positionsID);
		 GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		
		 String responseJSON = httpClient.get(getRequest);
		 Positions response = jsonEntityService.toEntity(responseJSON, Positions.class);
		
		 return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Positions updateTaskPositions(int positionsID, int[] values, int revision, Authorization authorization) {
		 URI uri = uriProvider.getPositionsTaskUpdateURI(positionsID);
		 UpdatePositionsRequest request = new UpdatePositionsRequest(values, revision);
		 String json = jsonEntityService.toJSON(request);
		 PutRequest putRequest = requestFactory.createPutRequest(uri, authorization,json);
		
		 String responseJSON = httpClient.put(putRequest);
		 Positions response = jsonEntityService.toEntity(responseJSON, Positions.class);
		
		 return response;
	}

}
