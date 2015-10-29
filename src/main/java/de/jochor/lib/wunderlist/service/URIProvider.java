package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.wunderlist.model.List;
import de.jochor.lib.wunderlist.model.Positions;
import de.jochor.lib.wunderlist.model.Task;
import de.jochor.lib.wunderlist.model.Webhook;

/**
 * Interface of the {@link URIProvider} for the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-10-20
 * </p>
 *
 * @author Jochen Hormes
 */
public interface URIProvider {

	// Property names for the List service
	public static final String PROP_AUTHORIZATION_REDIRECT = "url.auth.wunderlist.redirect.tpl";
	public static final String PROP_AUTHORIZATION_ACCESSTOKEN = "url.auth.wunderlist.accesstoken";

	// Property names for the List service
	public static final String PROP_LIST_RETRIEVE_ALL = "url.wunderlist.list.retrieve.all";
	public static final String PROP_LIST_RETRIEVE_ONE = "url.wunderlist.list.retrieve.one.tpl";

	// Property names for the Positions service
	public static final String PROP_POSITIONS_LIST_RETRIEVE_ALL = "url.wunderlist.positions.list.retrieve.all";
	public static final String PROP_POSITIONS_LIST_RETRIEVE_ONE = "url.wunderlist.positions.list.retrieve.one.tpl";
	public static final String PROP_POSITIONS_TASK_RETRIEVE_ALL = "url.wunderlist.positions.task.retrieve.all";
	public static final String PROP_POSITIONS_TASK_RETRIEVE_ONE = "url.wunderlist.positions.task.retrieve.one.tpl";
	public static final String PROP_POSITIONS_TASK_UPDATE_ONE = "url.wunderlist.positions.task.update.one.tpl";

	// Property names for the Task service
	public static final String PROP_TASK_RETRIEVE_ALL = "url.wunderlist.task.retrieve.all";
	public static final String PROP_TASK_RETRIEVE_ONE = "url.wunderlist.task.retrieve.one.tpl";

	// Property names for the Webhook service
	public static final String PROP_WEBHOOK_RETRIEVE_ALL = "url.wunderlist.webhook.retrieve.all";
	public static final String PROP_WEBHOOK_CREATE_ONE = "url.wunderlist.webhook.create.one";
	public static final String PROP_WEBHOOK_DELETE_ONE = "url.wunderlist.webhook.delete.one.tpl";

	/* Getters for Authorization service URIs */

	/**
	 * Creates the {@link URI} to request authorization for access to the users lists. The user has to be redirected to this
	 * URI.<br>
	 * The parameters have to be included in the URI, since it is not used for a Java-based HTTP client request, but for
	 * a HTTP redirect.
	 *
	 * @param clientID
	 *            Wunderlist ID of the client software
	 * @param callback
	 *            Callback address of the client software
	 * @param state
	 *            Unguessable string
	 * @return Authorization request {@link URI} containing the given values
	 */
	URI getAuthorizationRequestURI(String clientID, String callback, String state);

	/**
	 * Getter for the {@link URI} to request the users access token at.
	 *
	 * @return {@link URI} to request the users access token at
	 */
	URI getAuthorizationAccessTokenURI();

	/* Getters for List service URIs */

	/**
	 * Getter for the {@link URI} to retrieve all lists of the user.
	 *
	 * @return {@link URI} to retrieve all lists of the user
	 */
	URI getListRetrieveAllURI();

	/**
	 * Creates the {@link URI} to retrieve a specific list.
	 *
	 * @param listID
	 *            ID of the list to retrieve
	 * @return {@link URI} to request a specific list
	 */
	URI getListRetrieveURI(int listID);

	/* Getters for Positions service URIs */

	/**
	 * Creates the {@link URI} to retrieve all {@link Positions} objects of the user for {@link List}s.
	 * 
	 * @return {@link URI} to request all {@link Positions} objects for {@link List}s
	 */
	URI getPositionsListRetrieveAllURI();

	/**
	 * Creates the {@link URI} to retrieve a specific {@link Positions} object for {@link List}s.
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @return {@link URI} to request a specific {@link Positions} object for {@link List}s
	 */
	URI getPositionsListRetrieveURI(int positionsID);

	/**
	 * Creates the {@link URI} to retrieve all {@link Positions} objects of the user for {@link Task}s.
	 * 
	 * @return {@link URI} to request all {@link Positions} objects for {@link Task}s
	 */
	URI getPositionsTaskRetrieveAllURI();

	/**
	 * Creates the {@link URI} to retrieve a specific {@link Positions} object for {@link Task}s.
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @return {@link URI} to request a specific {@link Positions} object for {@link Task}s
	 */
	URI getPositionsTaskRetrieveURI(int positionsID);
	
	/**
	 * Creates the {@link URI} to update a {@link Positions} object for {@link Task}s.
	 *
	 * @param positionsID
	 *            ID of the {@link Positions} object
	 * @return {@link URI} to update a {@link Positions} object for {@link Task}s
	 */
	URI getPositionsTaskUpdateURI(int positionsID);

	/* Getters for Task service URIs */

	/**
	 * Creates the {@link URI} to request all {@link Task}s for a specific list.
	 *
	 * @return {@link URI} to request the {@link Task}s
	 */
	URI getTaskRetrieveAllURI();

	/**
	 * Creates the {@link URI} to retrieve a specific {@link Task}.
	 *
	 * @param taskID
	 *            ID of the {@link Task} to retrieve
	 * @return {@link URI} to request the {@link Task}
	 */
	URI getTaskRetrieveURI(int taskID);

	/* Getters for Webhook service URIs */

	/**
	 * Creates the {@link URI} to request all {@link Webhook}s for a specific list.
	 *
	 * @return {@link URI} to request the {@link Webhook}s
	 */
	URI getWebhookRetrieveAllURI();

	/**
	 * Getter for the {@link URI} to create a new {@link Webhook} at.
	 *
	 * @return {@link URI} to create a new {@link Webhook} at
	 */
	URI getWebhookCreateURI();

	/**
	 * Creates the {@link URI} to delete a specific {@link Webhook}.
	 *
	 * @param webhookID
	 *            ID of the {@link Webhook} to delete
	 * @return {@link URI} to delete the {@link Webhook}
	 */
	URI getWebhookDeleteURI(int webhookID);

}
