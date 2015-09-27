package de.jochor.lib.wunderlist.service;

import java.net.URI;

import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PostRequest;
import de.jochor.lib.http4j.model.PutRequest;
import de.jochor.lib.wunderlist.model.Authorization;

/**
 *
 * <p>
 * <b>Started:</b> 2015-09-22
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public interface RequestFactory {

	GetRequest createGetRequest(URI uri, Authorization authorization);

	PostRequest createPostRequest(URI uri, Authorization authorization, String body);

	PutRequest createPutRequest(URI uri, Authorization authorization, String body);

}