package de.jochor.lib.wunderlist.service;

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
	 * Retrieves all {@link Webhook}s registered for the specified list.<br>
	 * GET a.wunderlist.com/api/v1/webhooks
	 *
	 * @param listID
	 *            ID of the list to request the {@link Webhook}s for
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return An array of all registered {@link Webhook}s
	 */
	Webhook[] retrieveAll(int listID, Authorization authorization);

	/**
	 * Creates a new {@link Webhook} specified by the request object given.<br>
	 * POST a.wunderlist.com/api/v1/webhoooks
	 *
	 * @param request
	 *            {@link CreateWebhookRequest} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link CreateWebhookResponse} object
	 */
	CreateWebhookResponse create(CreateWebhookRequest request, Authorization authorization);

	/**
	 * Deletes the {@link Webhook} specified by the ID given.<br>
	 * DELETE a.wunderlist.com/api/v1/webhooks/:id<br>
	 * Response: Status 204
	 *
	 * @param webhookID
	 *            ID of the {@link Webhook} to delete
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return True if the deletion was successful, false otherwise
	 */
	boolean delete(int webhookID, Authorization authorization);

}
