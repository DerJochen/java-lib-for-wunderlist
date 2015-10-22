package de.jochor.lib.wunderlist.service;

import java.net.URI;

/**
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
	public static final String PROP_POSITIONS_RETRIEVE_ONE = "url.wunderlist.positions.retrieve.one.tpl";
	public static final String PROP_POSITIONS_UPDATE_ONE = "url.wunderlist.positions.update.one.tpl";

	// Property names for the Webhook service
	public static final String PROP_WEBHOOK_CREATE_ONE = "url.wunderlist.webhook.create.one";

	/* Getters for Authorization service URIs */

	/**
	 * Creates the URI to request authorization for access to the users lists. The user has to be redirected to this
	 * URI.
	 *
	 * @param clientID
	 *            Wunderlist ID of the client software
	 * @param callback
	 *            Callback address of the client software
	 * @param state
	 *            Unguessable string
	 * @return Authorization request URI containing the given values
	 */
	URI getAuthorizationRequestURI(String clientID, String callback, String state);

	/**
	 * Getter for the URI to request the users access token at.
	 *
	 * @return URI to request the users access token at
	 */
	URI getAuthorizationAccessTokenURI();

	/* Getters for List service URIs */

	/**
	 * Getter for the URI to retrieve all lists of the user.
	 *
	 * @return URI to retrieve all lists of the user
	 */
	URI getListRetrieveAllURI();

	/**
	 * Creates the URI to retrieve a specific list.
	 *
	 * @param listID
	 *            ID of the list to retrieve
	 * @return URI to request a specific list
	 */
	URI getListRetrieveURI(int listID);

	/* Getters for Positions service URIs */

	/**
	 * Creates the URI to retrieve the positions of a specific list.
	 *
	 * @param listID
	 *            ID of the list to retrieve the positions of
	 * @return URI to request the positions of a specific list
	 */
	URI getPositionsRetrieveURI(int listID);

	/**
	 * Creates the URI to update the positions of a specific list.
	 *
	 * @param listID
	 *            ID of the list to retrieve the positions of
	 * @return URI to update the positions of a specific list
	 */
	URI getPositionsUpdateURI(int listID);

	/* Getters for Webhook service URIs */

	/**
	 * Getter for the URI to create a new webhook at.
	 *
	 * @return URI to create a new webhook at
	 */
	URI getWebhookCreateURI();

}
