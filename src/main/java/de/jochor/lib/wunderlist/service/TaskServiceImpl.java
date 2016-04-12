package de.jochor.lib.wunderlist.service;

import java.net.URI;
import java.util.List;
import java.util.Map;

import de.jochor.lib.http4j.HTTPClient;
import de.jochor.lib.http4j.HTTPClientFactory;
import de.jochor.lib.http4j.model.GetRequest;
import de.jochor.lib.http4j.model.PatchRequest;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.wunderlist.api.TaskService;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.Task;
import lombok.Setter;

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
	public Task[] retrieveAll(int listId, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		getRequest.setQueryParameter("list_id", listId);

		String responseJSON = httpClient.get(getRequest);

		Task[] tasks = jsonEntityService.toEntity(responseJSON, Task[].class);

		return tasks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task[] retrieveAllCompleted(int listId, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveAllURI();
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);
		getRequest.setQueryParameter("list_id", listId);
		getRequest.setQueryParameter("completed", "true");

		String responseJSON = httpClient.get(getRequest);

		Task[] tasks = jsonEntityService.toEntity(responseJSON, Task[].class);

		return tasks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task retrieve(int taskId, Authorization authorization) {
		URI uri = uriProvider.getTaskRetrieveURI(taskId);
		GetRequest getRequest = requestFactory.createGetRequest(uri, authorization);

		String responseJSON = httpClient.get(getRequest);

		Task task = jsonEntityService.toEntity(responseJSON, Task.class);

		return task;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Task update(int taskId, Map<String, Object> changes, List<String> removed, int revision, Authorization authorization) {
		URI uri = uriProvider.getTaskUpdateURI(taskId);
		changes.put("revision", revision);
		if (removed != null) {
			changes.put("remove", removed);
		}
		String json = jsonEntityService.toJSON(changes);
		PatchRequest patchRequest = requestFactory.createPatchRequest(uri, authorization, json);

		String responseJSON = httpClient.patch(patchRequest);

		Task updatedTask = jsonEntityService.toEntity(responseJSON, Task.class);

		return updatedTask;
	}

}
