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

	URI getRequestAuthorizationURI(String clientID, String callBack, String state);

	URI getAccessTokenURI();

	URI getWunderlistCallBackURI();

}
