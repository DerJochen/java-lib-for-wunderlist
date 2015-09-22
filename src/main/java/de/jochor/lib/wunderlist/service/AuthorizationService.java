package de.jochor.lib.wunderlist.service;

/**
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
	 * @param clientId
	 *            The Client ID you received from Wunderlist when you registered your application.
	 * @param callbackURL
	 *            The URL in your app where users will be sent after authorization.
	 * @param state
	 *            An unguessable random string. It is used to protect against cross-site request forgery attacks.
	 * @return Authorization request URL
	 */
	String builddAuthorisationRequestURL(String clientId, String callbackURL, String state);

	/**
	 *
	 * POST https://www.wunderlist.com/oauth/access_token
	 *
	 * @param clientId
	 *            The Client ID you received from Wunderlist when you registered your application.
	 * @param clientSecrete
	 *            The client secret you received from Wunderlist when you registered.
	 * @param code
	 *            The code you received as a response to the authorization request.
	 * @return The access token
	 */
	String retrieveAccessToken(String clientId, String clientSecrete, String code);

}
