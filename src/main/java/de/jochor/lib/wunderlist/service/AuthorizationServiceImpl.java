package de.jochor.lib.wunderlist.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.model.RetrieveAccessTokenResponse;

/**
 *
 * <p>
 * <b>Started:</b> 2015-09-04
 * </p>
 * @author Jochen Hormes
 *
 */
public class AuthorizationServiceImpl implements AuthorizationService {

	private static final String REDIRECT_TEMPLATE = "https://www.wunderlist.com/oauth/authorize?client_id=%s&redirect_uri=%s&state=%s";

	private static final URI ACCESS_TOKEN_URI = URI.create("https://www.wunderlist.com/oauth/access_token");

	private HTTPClient HTTPClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String builddAuthorisationRequestURL(String clientId, String callbackURL, String state) {
		try {
			String callbackURLEnc = URLEncoder.encode(callbackURL, StandardCharsets.UTF_8.name());
			String stateEnc = URLEncoder.encode(state, StandardCharsets.UTF_8.name());
			String redirectURL = String.format(REDIRECT_TEMPLATE, clientId, callbackURLEnc, stateEnc);
			return redirectURL;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String retrieveAccessToken(String clientId, String clientSecrete, String code) {
		PostRequest request = new PostRequest(ACCESS_TOKEN_URI);

		String responseJSON = HTTPClient.post(request);
		RetrieveAccessTokenResponse response = jsonEntityService.toEntity(responseJSON, RetrieveAccessTokenResponse.class);

		String accessToken = response.getAccess_token();

		return accessToken;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerAuthorization() {
		// TODO Auto-generated method stub

	}

}
