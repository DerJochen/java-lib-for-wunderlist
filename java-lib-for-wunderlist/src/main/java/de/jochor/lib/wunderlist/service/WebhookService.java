package de.jochor.lib.wunderlist.service;

import java.util.List;

import de.jochor.lib.wunderlist.model.CreateWebhookRequest;
import de.jochor.lib.wunderlist.model.CreateWebhookResponse;
import de.jochor.lib.wunderlist.model.Webhook;

/**
 *
 * @author Jochen Hormes
 *
 */
public interface WebhookService {

	CreateWebhookResponse create(CreateWebhookRequest request);

	boolean delete(int id);

	List<Webhook> listWebhooks(int listId);

}
