package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;
import de.jochor.lib.wunderlist.model.UpdateListPositionsRequest;
import de.jochor.lib.wunderlist.model.UpdateListPositionsResponse;

/**
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
	public RetrieveListPositionsResponse retrieve(int id, Authorization authorization) {
		URI uri = uriProvider.getPositionsRetrieveURI(id);
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = httpClient.get(getRequest);
		RetrieveListPositionsResponse response = jsonEntityService.toEntity(responseJSON, RetrieveListPositionsResponse.class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UpdateListPositionsResponse update(int id, int[] values, int revision, Authorization authorization) {
		URI uri = uriProvider.getPositionsUpdateURI(id);
		UpdateListPositionsRequest request = new UpdateListPositionsRequest(values, revision);
		String requestJSON = jsonEntityService.toJSON(request);

		PutRequest putRequest = requestFactory.createPutRequest(uri, authorization, requestJSON);

		String responseJSON = httpClient.put(putRequest);
		UpdateListPositionsResponse response = jsonEntityService.toEntity(responseJSON, UpdateListPositionsResponse.class);

		return response;
	}

}
