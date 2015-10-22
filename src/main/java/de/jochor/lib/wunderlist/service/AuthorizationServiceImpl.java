package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.model.RetrieveAccessTokenRequest;
import de.jochor.lib.wunderlist.model.RetrieveAccessTokenResponse;

/**
 *
 * <p>
 * <b>Started:</b> 2015-09-04
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class AuthorizationServiceImpl implements AuthorizationService {

	private HTTPClient httpClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	@Setter
	private URIProvider uriProvider = new DefaultURIProvider();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI buildAuthorisationRequestURI(String clientID, String callback, String state) {
		URI redirectURI = uriProvider.getRequestAuthorizationURI(clientID, callback, state);
		return redirectURI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String retrieveAccessToken(String clientID, String clientSecrete, String code) {
		RetrieveAccessTokenRequest request = new RetrieveAccessTokenRequest(clientID, clientSecrete, code);
		String requestJSON = jsonEntityService.toJSON(request);

		URI accessTokenURI = uriProvider.getAccessTokenURI();
		PostRequest postRequest = requestFactory.createPostRequest(accessTokenURI, null, requestJSON);

		String responseJSON = httpClient.post(postRequest);
		RetrieveAccessTokenResponse response = jsonEntityService.toEntity(responseJSON, RetrieveAccessTokenResponse.class);

		String accessToken = response.getAccess_token();

		return accessToken;
	}

}
