package de.jochor.lib.wunderlist.api;

import java.net.URI;

/**
 * Interface of the {@link AuthorizationService} of the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-09-04
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface AuthorizationService {

	/**
	 * Builds the authorization request URL to redirect the user to.
	 *
	 * @param clientID
	 *            The Client ID you received from Wunderlist when you registered your application.
	 * @param callback
	 *            The address in your application where users will be redirected to after authorization.
	 * @param state
	 *            An unguessable random string. It is used to protect against cross-site request forgery attacks.
	 * @return Authorization request URI
	 */
	URI buildAuthorisationRequestURI(String clientID, String callback, String state);

	/**
	 * Retrieves the users access token from Wunderlist<br>
	 * POST https://www.wunderlist.com/oauth/access_token
	 *
	 * @param clientID
	 *            The Client ID you received from Wunderlist when you registered your application.
	 * @param clientSecrete
	 *            The client secret you received from Wunderlist when you registered.
	 * @param code
	 *            The code you received as a response to the authorization request.
	 * @return The access token
	 */
	String retrieveAccessToken(String clientID, String clientSecrete, String code);

}
