package de.jochor.lib.wunderlist.service;

import java.net.URI;
import java.util.List;

import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.CreateWebhookRequest;
import de.jochor.lib.wunderlist.model.CreateWebhookResponse;
import de.jochor.lib.wunderlist.model.Webhook;

/**
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class WebhookServiceImpl implements WebhookService {

	private static final URI CREATE_URI = URI.create("a.wunderlist.com/api/v1/webhoooks");

	private HTTPClient HTTPClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateWebhookResponse create(CreateWebhookRequest request, Authorization authorization) {
		String body = jsonEntityService.toJSON(request);

		PostRequest postRequest = requestFactory.createPostRequest(CREATE_URI, authorization, body);

		String responseJSON = HTTPClient.post(postRequest);

		CreateWebhookResponse response = jsonEntityService.toEntity(responseJSON, CreateWebhookResponse.class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(int id, Authorization authorization) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Webhook> listWebhooks(int listId, Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

}
