package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http.HttpClient;
import de.jochor.lib.http.HttpClientBuilder;
import de.jochor.lib.http.model.GetRequest;
import de.jochor.lib.json.JSONEntityService;
import de.jochor.lib.json.jackson.JSONEntityServiceJackson;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-19
 *
 */
public class ListServiceImpl implements ListService {

	private static final String RETRIEVE_ALL_URI = "a.wunderlist.com/api/v1/lists";

	private static final String RETRIEVE_URI = "a.wunderlist.com/api/v1/lists/%d";

	private HttpClient httpClient;

	// TODO
	private JSONEntityService jsonEntityService = new JSONEntityServiceJackson();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse[] retrieveAll() {
		URI uri = URI.create(RETRIEVE_ALL_URI);
		GetRequest getRequest = new GetRequest(uri);

		String responseJSON = getHttpClient().get(getRequest);
		RetrieveListResponse[] response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse[].class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse retrieve(int id) {
		String uriString = String.format(RETRIEVE_URI, id);
		URI uri = URI.create(uriString);
		GetRequest getRequest = new GetRequest(uri);

		String responseJSON = getHttpClient().get(getRequest);
		RetrieveListResponse response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse.class);

		return response;
	}

	private HttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create();
		}
		return httpClient;
	}

}
