package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http4j.model.DeleteRequest;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PatchRequest;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.wunderlist.model.Authorization;

/**
 * Interface for a convenience service. It creates pre-configured HTTP request objects.
 *
 * <p>
 * <b>Started:</b> 2015-09-22
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface RequestFactory {

	/**
	 * Creates a pre-configured HTTP DELETE request object.
	 *
	 * @param uri
	 *            Address to call
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return New {@link DeleteRequest} object
	 */
	DeleteRequest createDeleteRequest(URI uri, Authorization authorization);

	/**
	 * Creates a pre-configured HTTP GET request object.
	 *
	 * @param uri
	 *            Address to call
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @return New {@link GetRequest} object
	 */
	GetRequest createGetRequest(URI uri, Authorization authorization);

	/**
	 * Creates a pre-configured HTTP PATCH request object.
	 *
	 * @param uri
	 *            Address to call
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @param body
	 *            Body for the request
	 * @return New {@link PatchRequest} object
	 */
	PatchRequest createPatchRequest(URI uri, Authorization authorization, String body);

	/**
	 * Creates a pre-configured HTTP POST request object.
	 *
	 * @param uri
	 *            Address to call
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @param body
	 *            Body for the request
	 * @return New {@link PostRequest} object
	 */
	PostRequest createPostRequest(URI uri, Authorization authorization, String body);

	/**
	 * Creates a pre-configured HTTP PUT request object.
	 *
	 * @param uri
	 *            Address to call
	 * @param authorization
	 *            {@link Authorization} containing client ID and access token
	 * @param body
	 *            Body for the request
	 * @return New {@link PutRequest} object
	 */
	PutRequest createPutRequest(URI uri, Authorization authorization, String body);

}
