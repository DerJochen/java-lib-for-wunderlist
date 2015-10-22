package de.jochor.lib.wunderlist.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *
 * <p>
 * <b>Started:</b> 2015-10-20
 * </p>
 *
 * @author Jochen Hormes
 */
public class DefaultURIProvider implements URIProvider {

	private Properties uris;

	public DefaultURIProvider() {
		uris = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wunderlist-uris.properties");
		try {
			uris.load(inStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public URI getRequestAuthorizationURI(String clientID, String callback, String state) {
		String requestAuthorizationTpl = uris.getProperty("url.auth.wl.redirect.tpl");
		try {
			String utf8 = StandardCharsets.UTF_8.name();
			String clientIDEnc = URLEncoder.encode(clientID, utf8);
			String callbackEnc = URLEncoder.encode(callback, utf8);
			String stateEnc = URLEncoder.encode(state, utf8);

			String requestAuthorization = String.format(requestAuthorizationTpl, clientIDEnc, callbackEnc, stateEnc);
			URI requestAuthorizationURI = URI.create(requestAuthorization);

			return requestAuthorizationURI;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public URI getAccessTokenURI() {
		String accessToken = uris.getProperty("url.auth.wl.accesstoken");
		URI accessTokenURI = URI.create(accessToken);
		return accessTokenURI;
	}

}
