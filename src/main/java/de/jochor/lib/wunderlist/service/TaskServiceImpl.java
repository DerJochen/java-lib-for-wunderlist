package de.jochor.lib.wunderlist.service;

import java.net.URI;

import lombok.Setter;
import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.api.RequestFactory;
import de.jochor.lib.wunderlist.api.TaskService;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Implementation of the {@link TaskService} of the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-10-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class TaskServiceImpl implements TaskService {

	private HTTPClient httpClient = HTTPClientFactory.create();

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	private RequestFactory requestFactory = new RequestFactoryImpl();

	@Setter
	private URIProvider uriProvider = new DefaultURIProvider();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task[] retrieveAll(int listID, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		getRequest.setQueryParameter("list_id", listID);

		String responseJSON = httpClient.get(getRequest);

		Task[] tasks = jsonEntityService.toEntity(responseJSON, Task[].class);

		return tasks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task[] retrieveAllCompleted(int listID, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		getRequest.setQueryParameter("list_id", listID);
		getRequest.setQueryParameter("completed", "true");

		String responseJSON = httpClient.get(getRequest);

		Task[] tasks = jsonEntityService.toEntity(responseJSON, Task[].class);

		return tasks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task retrieve(int taskID, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveURI(taskID);
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = httpClient.get(getRequest);

		Task task = jsonEntityService.toEntity(responseJSON, Task.class);

		return task;
	}

}
