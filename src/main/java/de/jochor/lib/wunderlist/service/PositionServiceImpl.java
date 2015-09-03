package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http4j.HttpClient;
import de.jochor.lib.http4j.HttpClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;
import de.jochor.lib.wunderlist.model.UpdateListPositionsRequest;
import de.jochor.lib.wunderlist.model.UpdateListPositionsResponse;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-24
 *
 */
public class PositionServiceImpl implements PositionsService {

	private static final String RETRIEVE_URI = "a.wunderlist.com/api/v1/list_positions/%d";

	private static final String UPDATE_URI = "a.wunderlist.com/api/v1/list_positions/%d";

	private HttpClient httpClient = HttpClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListPositionsResponse retrieve(int id) {
		String uriString = String.format(RETRIEVE_URI, id);
		URI uri = URI.create(uriString);
		GetRequest getRequest = new GetRequest(uri);

		String responseJSON = httpClient.get(getRequest);
		RetrieveListPositionsResponse response = jsonEntityService.toEntity(responseJSON, RetrieveListPositionsResponse.class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UpdateListPositionsResponse update(int id, int[] values, int revision) {
		String uriString = String.format(UPDATE_URI, id);
		URI uri = URI.create(uriString);
		PutRequest putRequest = new PutRequest(uri);

		UpdateListPositionsRequest request = new UpdateListPositionsRequest(values, revision);
		String requestJSON = jsonEntityService.toJSON(request);
		putRequest.setBody(requestJSON);

		String responseJSON = httpClient.put(putRequest);
		UpdateListPositionsResponse response = jsonEntityService.toEntity(responseJSON, UpdateListPositionsResponse.class);

		return response;
	}

}
