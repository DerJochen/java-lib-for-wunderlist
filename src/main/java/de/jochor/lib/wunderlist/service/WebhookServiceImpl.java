package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.DeleteRequest;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.api.WebhookService;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Webhook;
import de.jochor.lib.wunderlist.transfer.CreateWebhookRequest;

/**
 * Implementation of the {@link WebhookService} of the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class WebhookServiceImpl implements WebhookService {

	private HTTPClient httpClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	@Setter
	private URIProvider uriProvider = new DefaultURIProvider();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Webhook[] retrieveAll(int listID, Authorization authorization) {
		URI uri = uriProvider.getWebhookRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		getRequest.setQueryParameter("list_id", listID);

		String responseJSON = httpClient.get(getRequest);

		Webhook[] webhooks = jsonEntityService.toEntity(responseJSON, Webhook[].class);

		return webhooks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Webhook create(CreateWebhookRequest request, Authorization authorization) {
		String body = jsonEntityService.toJSON(request);

		URI uri = uriProvider.getWebhookCreateURI();
		PostRequest postRequest = requestFactory.createPostRequest(uri, authorization, body);

		String responseJSON = httpClient.post(postRequest);

		Webhook response = jsonEntityService.toEntity(responseJSON, Webhook.class);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(int webhookID, Authorization authorization) {
		URI uri = uriProvider.getWebhookDeleteURI(webhookID);
		DeleteRequest deleteRequest = requestFactory.createDeleteRequest(uri, authorization);

		httpClient.delete(deleteRequest);

		return true;
	}

}
