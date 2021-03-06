package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http4j.model.BaseRequest;
import de.jochor.lib.http4j.model.DeleteRequest;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PatchRequest;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.wunderlist.model.Authorization;

/**
 * Implementation of the {@link RequestFactory} interface. It is a convenience service that creates pre-configured HTTP
 * request objects.
 *
 * <p>
 * <b>Started:</b> 2015-09-22
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class RequestFactoryImpl implements RequestFactory {

	private static final String CLIENT_ID = "X-Client-ID";

	private static final String ACCESS_TOKEN = "X-Access-Token";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DeleteRequest createDeleteRequest(URI uri, Authorization authorization) {
		DeleteRequest request = new DeleteRequest(uri);
		addAuthorization(request, authorization);
		return request;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetRequest createGetRequest(URI uri, Authorization authorization) {
		GetRequest request = new GetRequest(uri);
		addAuthorization(request, authorization);
		return request;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PatchRequest createPatchRequest(URI uri, Authorization authorization, String body) {
		PatchRequest request = new PatchRequest(uri, body);
		addAuthorization(request, authorization);

		return request;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PostRequest createPostRequest(URI uri, Authorization authorization, String body) {
		PostRequest request = new PostRequest(uri, body);
		addAuthorization(request, authorization);

		return request;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PutRequest createPutRequest(URI uri, Authorization authorization, String body) {
		PutRequest request = new PutRequest(uri, body);
		addAuthorization(request, authorization);

		return request;
	}

	protected void addAuthorization(BaseRequest request, Authorization authorization) {
		if (authorization == null) {
			return;
		}
		request.setHeader(CLIENT_ID, authorization.getClientId());
		request.setHeader(ACCESS_TOKEN, authorization.getUserToken());
	}

}
