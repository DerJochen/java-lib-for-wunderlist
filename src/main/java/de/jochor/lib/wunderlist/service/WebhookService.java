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
	 *
	 * @param request
	 *            {@link CreateWebhookRequest} object
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return {@link CreateWebhookResponse} object
	 */
	CreateWebhookResponse create(CreateWebhookRequest request, Authorization authorization);

	/**
	 *
	 * @param id
	 *            ID of the web hook to delete
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return
	 */
	boolean delete(int id, Authorization authorization);

	/**
	 *
	 * @param listId
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return
	 */
	List<Webhook> listWebhooks(int listId, Authorization authorization);

}
