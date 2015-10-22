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

	private static final String WUNDERLIST_URIS_PROPERTIES = "wunderlist-uris.properties";

	private final Properties uris = new Properties();

	public DefaultURIProvider() {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try (InputStream inStream = contextClassLoader.getResourceAsStream(WUNDERLIST_URIS_PROPERTIES)) {
			uris.load(inStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* Getters for Authorization service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getRequestAuthorizationURI(String clientID, String callback, String state) {
		String uriTpl = uris.getProperty(PROP_AUTHORIZATION_REDIRECT);
		try {
			String utf8 = StandardCharsets.UTF_8.name();
			String clientIDEnc = URLEncoder.encode(clientID, utf8);
			String callbackEnc = URLEncoder.encode(callback, utf8);
			String stateEnc = URLEncoder.encode(state, utf8);

			String uriString = String.format(uriTpl, clientIDEnc, callbackEnc, stateEnc);
			URI uri = URI.create(uriString);

			return uri;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getAccessTokenURI() {
		String uriString = uris.getProperty(PROP_AUTHORIZATION_ACCESSTOKEN);
		URI uri = URI.create(uriString);
		return uri;
	}

	/* Getters for List service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getListRetrieveAllURI() {
		String uriString = uris.getProperty(PROP_LIST_RETRIEVE_ALL);
		URI uri = URI.create(uriString);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getListRetrieveURI(int listID) {
		String uriTpl = uris.getProperty(PROP_LIST_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, Integer.valueOf(listID));
		URI uri = URI.create(uriString);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	/* Getters for Positions service URIs */

	@Override
	public URI getPositionsRetrieveURI(int id) {
		String uriTpl = uris.getProperty(PROP_POSITIONS_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, Integer.valueOf(id));
		URI uri = URI.create(uriString);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsUpdateURI(int id) {
		String uriTpl = uris.getProperty(PROP_POSITIONS_UPDATE_ONE);
		String uriString = String.format(uriTpl, Integer.valueOf(id));
		URI uri = URI.create(uriString);
		return uri;
	}

	/* Getters for Webhook service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getWebhookCreateURI() {
		String uriString = uris.getProperty(PROP_WEBHOOK_CREATE_ONE);
		URI uri = URI.create(uriString);
		return uri;
	}

}
