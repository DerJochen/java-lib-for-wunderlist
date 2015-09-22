package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
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
public class ListServiceImpl implements ListService {

	private static final URI RETRIEVE_ALL_URI = URI.create("a.wunderlist.com/api/v1/lists");

	private static final String RETRIEVE_URI = "a.wunderlist.com/api/v1/lists/%d";

	private HTTPClient HTTPClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse[] retrieveAll(Authorization authorization) {
		GetRequest getRequest = requestFactory.createGetRequest(RETRIEVE_ALL_URI, authorization);

		String responseJSON = HTTPClient.get(getRequest);
		RetrieveListResponse[] response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse[].class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse retrieve(int id, Authorization authorization) {
		String uriString = String.format(RETRIEVE_URI, id);
		URI uri = URI.create(uriString);

		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = HTTPClient.get(getRequest);
		RetrieveListResponse response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse.class);

		return response;
	}

}
