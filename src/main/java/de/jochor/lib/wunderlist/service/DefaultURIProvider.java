package de.jochor.lib.wunderlist.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

/**
 * Default implementation of the {@link URIProvider} for the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-10-20
 * </p>
 *
 * @author Jochen Hormes
 */
public class DefaultURIProvider implements URIProvider {

	private static final String WUNDERLIST_URIS_PROPERTIES = "wunderlist-uris.properties";

	// Property names for the List service
	private static final String PROP_AUTHORIZATION_REDIRECT = "url.auth.wunderlist.redirect.tpl";
	private static final String PROP_AUTHORIZATION_ACCESSTOKEN = "url.auth.wunderlist.accesstoken";

	// Property names for the List service
	private static final String PROP_LIST_RETRIEVE_ALL = "url.wunderlist.list.retrieve.all";
	private static final String PROP_LIST_RETRIEVE_ONE = "url.wunderlist.list.retrieve.one.tpl";

	// Property names for the Positions service
	private static final String PROP_POSITIONS_LIST_RETRIEVE_ALL = "url.wunderlist.positions.list.retrieve.all";
	private static final String PROP_POSITIONS_LIST_RETRIEVE_ONE = "url.wunderlist.positions.list.retrieve.one.tpl";
	private static final String PROP_POSITIONS_TASK_RETRIEVE_ALL = "url.wunderlist.positions.task.retrieve.all";
	private static final String PROP_POSITIONS_TASK_RETRIEVE_ONE = "url.wunderlist.positions.task.retrieve.one.tpl";
	private static final String PROP_POSITIONS_TASK_UPDATE_ONE = "url.wunderlist.positions.task.update.one.tpl";

	// Property names for the Task service
	private static final String PROP_TASK_RETRIEVE_ALL = "url.wunderlist.task.retrieve.all";
	private static final String PROP_TASK_RETRIEVE_ONE = "url.wunderlist.task.retrieve.one.tpl";

	// Property names for the Webhook service
	private static final String PROP_WEBHOOK_RETRIEVE_ALL = "url.wunderlist.webhook.retrieve.all";
	private static final String PROP_WEBHOOK_CREATE_ONE = "url.wunderlist.webhook.create.one";
	private static final String PROP_WEBHOOK_DELETE_ONE = "url.wunderlist.webhook.delete.one.tpl";

	private final Properties uriStrings = new Properties();

	private final HashMap<String, URI> uris = new HashMap<>();

	/**
	 * Default constructor for the {@link DefaultURIProvider}. Loads the {@link URI} data from a properties file.
	 *
	 * @throws IOException
	 */
	public DefaultURIProvider() {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try (InputStream inStream = contextClassLoader.getResourceAsStream(WUNDERLIST_URIS_PROPERTIES)) {
			uriStrings.load(inStream);
		} catch (IOException e) {
			throw new InitException(e);
		}
	}

	/* Getters for Authorization service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getAuthorizationRequestURI(String clientID, String callback, String state) {
		URI uri = null;
		String uriTpl = uriStrings.getProperty(PROP_AUTHORIZATION_REDIRECT);
		try {
			String utf8 = StandardCharsets.UTF_8.name();
			String clientIDEnc = URLEncoder.encode(clientID, utf8);
			String callbackEnc = URLEncoder.encode(callback, utf8);
			String stateEnc = URLEncoder.encode(state, utf8);

			String uriString = String.format(uriTpl, clientIDEnc, callbackEnc, stateEnc);
			uri = URI.create(uriString);
		} catch (UnsupportedEncodingException e) {
			// Encoding name is taken from a system constant. This can never happen.
		}

		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getAuthorizationAccessTokenURI() {
		URI uri = getStaticURI(PROP_AUTHORIZATION_ACCESSTOKEN);
		return uri;
	}

	/* Getters for List service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getListRetrieveAllURI() {
		URI uri = getStaticURI(PROP_LIST_RETRIEVE_ALL);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getListRetrieveURI(int listID) {
		String uriTpl = uriStrings.getProperty(PROP_LIST_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, listID);
		URI uri = URI.create(uriString);
		return uri;
	}

	/* Getters for Positions service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsListRetrieveAllURI() {
		URI uri = getStaticURI(PROP_POSITIONS_LIST_RETRIEVE_ALL);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsListRetrieveURI(int positionsID) {
		String uriTpl = uriStrings.getProperty(PROP_POSITIONS_LIST_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, positionsID);
		URI uri = URI.create(uriString);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsTaskRetrieveAllURI() {
		URI uri = getStaticURI(PROP_POSITIONS_TASK_RETRIEVE_ALL);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsTaskRetrieveURI(int positionsID) {
		String uriTpl = uriStrings.getProperty(PROP_POSITIONS_TASK_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, positionsID);
		URI uri = URI.create(uriString);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getPositionsTaskUpdateURI(int positionsID) {
		String uriTpl = uriStrings.getProperty(PROP_POSITIONS_TASK_UPDATE_ONE);
		String uriString = String.format(uriTpl, positionsID);
		URI uri = URI.create(uriString);
		return uri;
	}

	/* Getters for Task service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getTaskRetrieveAllURI() {
		URI uri = getStaticURI(PROP_TASK_RETRIEVE_ALL);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getTaskRetrieveURI(int taskID) {
		String uriTpl = uriStrings.getProperty(PROP_TASK_RETRIEVE_ONE);
		String uriString = String.format(uriTpl, taskID);
		URI uri = URI.create(uriString);
		return uri;
	}

	/* Getters for Webhook service URIs */

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getWebhookRetrieveAllURI() {
		URI uri = getStaticURI(PROP_WEBHOOK_RETRIEVE_ALL);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getWebhookCreateURI() {
		URI uri = getStaticURI(PROP_WEBHOOK_CREATE_ONE);
		return uri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getWebhookDeleteURI(int webhookID) {
		String uriTpl = uriStrings.getProperty(PROP_WEBHOOK_DELETE_ONE);
		String uriString = String.format(uriTpl, webhookID);
		URI uri = URI.create(uriString);
		return uri;
	}

	private URI getStaticURI(String uriName) {
		if (uriName.endsWith(".tpl")) {
			throw new UnsupportedOperationException("The name " + uriName + " points to a dynamic URI.");
		}

		URI uri = uris.get(uriName);
		if (uri == null) {
			String uriString = uriStrings.getProperty(uriName);
			uri = URI.create(uriString);
		}

		return uri;
	}

}
