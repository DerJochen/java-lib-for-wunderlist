package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http.HttpClient;
import de.jochor.lib.http.HttpClientBuilder;
import de.jochor.lib.http.model.GetRequest;
import de.jochor.lib.wunderlist.model.RetrieveAllListsResponse;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveAllListsResponse retrieveAll() {
		HttpClient httpClient = HttpClientBuilder.create();

		URI uri = URI.create(RETRIEVE_ALL_URI);
		GetRequest getRequest = new GetRequest(uri);

		String responseJSON = httpClient.get(getRequest);

		// TODO convert to Object

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse retrieve(int id) {
		HttpClient httpClient = HttpClientBuilder.create();

		String uriString = String.format(RETRIEVE_URI, id);
		URI uri = URI.create(uriString);
		GetRequest getRequest = new GetRequest(uri);

		String responseJSON = httpClient.get(getRequest);

		// TODO convert to Object

		return null;
	}

}
