package de.jochor.lib.wunderlist.service;

import java.util.List;

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
public interface WebhookService {

	/**
	 * Creates a new webhook specified by the request object given.
	 *
	 * @param request
	 *            {@link CreateWebhookRequest} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link CreateWebhookResponse} object
	 */
	CreateWebhookResponse create(CreateWebhookRequest request, Authorization authorization);

	/**
	 * Deletes the webhook specified by the ID given.
	 *
	 * @param webhookID
	 *            ID of the web hook to delete
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return True if the deletion was successful, false otherwise
	 */
	boolean delete(int webhookID, Authorization authorization);

	/**
	 * Retrieves all webhooks registered for the specified list.
	 *
	 * @param listID
	 *            ID of the list to request the webhooks for
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return A list of all registered webhooks
	 */
	List<Webhook> listWebhooks(int listID, Authorization authorization);

}
