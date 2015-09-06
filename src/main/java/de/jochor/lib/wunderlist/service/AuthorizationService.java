package de.jochor.lib.wunderlist.service;

/**
 *
 * @author Jochen Hormes
 * @start 2015-09-04
 *
 */
public interface AuthorizationService {

	String builddAuthorisationRequestURL(String clientId, String callbackURL, String state);

	/**
	 * POST https://www.wunderlist.com/oauth/access_token
	 */
	String retrieveAccessToken(String clientId,String clientSecrete, String code);

	void registerAuthorization();

}
