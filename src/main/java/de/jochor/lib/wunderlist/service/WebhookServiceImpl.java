package de.jochor.lib.wunderlist.service;

import java.net.URI;
import java.util.List;

import de.jochor.lib.http4j.HttpClient;
import de.jochor.lib.http4j.HttpClientFactory;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.wunderlist.model.CreateWebhookRequest;
import de.jochor.lib.wunderlist.model.CreateWebhookResponse;
import de.jochor.lib.wunderlist.model.Webhook;

/**
 *
 * @author Jochen Hormes
 *
 */
public class WebhookServiceImpl implements WebhookService {

	private static final URI CREATE_URI = URI.create("a.wunderlist.com/api/v1/webhoooks");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateWebhookResponse create(CreateWebhookRequest request) {
		HttpClient httpClient = HttpClientFactory.create();

		String body = ""; // TODO convert to JSON: request

		PostRequest postRequest = new PostRequest(CREATE_URI);
		postRequest.setBody(body);

		String responseJSON = httpClient.post(postRequest);

		// TODO convert to Object: responseJSON

		return null;
	}

	@Override
	public boolean delete(int id) {

		return false;
	}

	@Override
	public List<Webhook> listWebhooks(int listId) {
		// TODO Auto-generated method stub
		return null;
	}

}
