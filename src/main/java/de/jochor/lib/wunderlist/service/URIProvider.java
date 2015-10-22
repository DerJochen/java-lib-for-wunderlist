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
	public static final String PROP_LIST_RETRIEVE_ALL = "url.wunderlist.list.retrieve.all";
	public static final String PROP_LIST_RETRIEVE_ONE = "url.wunderlist.list.retrieve.one.tpl";

	// Property names for the Positions service
	public static final String PROP_POSITIONS_RETRIEVE_ONE = "url.wunderlist.positions.retrieve.one.tpl";
	public static final String PROP_POSITIONS_UPDATE_ONE = "url.wunderlist.positions.update.one.tpl";

	// Property names for the Webhook service
	public static final String PROP_WEBHOOK_CREATE_ONE = "url.wunderlist.webhook.create.one";
	
	/* Getters for Authorization service URIs */
	
	// TODO JavaDoc
	URI getRequestAuthorizationURI(String clientID, String callback, String state);

	// TODO JavaDoc
	URI getAccessTokenURI();

	/* Getters for List service URIs */
	
	// TODO JavaDoc
	URI getListRetrieveAllURI();

	// TODO JavaDoc
	URI getListRetrieveURI(int listID);

	/* Getters for Positions service URIs */

	// TODO JavaDoc
	URI getPositionsRetrieveURI(int id);

	// TODO JavaDoc
	URI getPositionsUpdateURI(int id);

	/* Getters for Webhook service URIs */

	// TODO JavaDoc
	URI getWebhookCreateURI();

}
