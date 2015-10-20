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

	// TODO JavaDoc
	URI getRequestAuthorizationURI(String clientID, String callback, String state);

	// TODO JavaDoc
	URI getAccessTokenURI();

	// TODO JavaDoc
	URI getWunderlistCallBackURI();

}
