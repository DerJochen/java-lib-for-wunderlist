package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
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

	private HTTPClient httpClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	@Setter
	private URIProvider uriProvider = new DefaultURIProvider();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse[] retrieveAll(Authorization authorization) {
		URI uri = uriProvider.getListRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = httpClient.get(getRequest);
		RetrieveListResponse[] response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse[].class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RetrieveListResponse retrieve(int id, Authorization authorization) {
		URI uri = uriProvider.getListRetrieveURI(id);
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = httpClient.get(getRequest);
		RetrieveListResponse response = jsonEntityService.toEntity(responseJSON, RetrieveListResponse.class);

		return response;
	}

}
