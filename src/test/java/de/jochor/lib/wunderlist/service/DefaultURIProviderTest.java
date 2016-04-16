package de.jochor.lib.wunderlist.service;

import java.net.URI;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the {@link DefaultURIProvider}.
 *
 * <p>
 * <b>Started:</b> 2015-11-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class DefaultURIProviderTest {

	private static final String URI_BASE = "https://a.wunderlist.com/api/v1/";

	private DefaultURIProvider uriProvider;

	@Before
	public void setUp() {
		uriProvider = new DefaultURIProvider();
	}

	@Test(expected = InitException.class)
	public void testDefaultURIProviderPath() {
		new DefaultURIProvider(Paths.get("not-really-a-path"));
	}

	@Test
	public void testSameURITwice() {
		URI accessTokenURI1 = uriProvider.getAuthorizationAccessTokenURI();
		Assert.assertNotNull(accessTokenURI1);
		URI accessTokenURI2 = uriProvider.getAuthorizationAccessTokenURI();
		Assert.assertSame(accessTokenURI1, accessTokenURI2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGetStaticURI() {
		uriProvider.getStaticURI("not-static.tpl");
	}

	@Test
	public void testGetAuthorizationRequestURI() {
		String clientId = "clientId";
		String callback = "callback";
		String state = "state";
		URI uri = uriProvider.getAuthorizationRequestURI(clientId, callback, state);
		Assert.assertNotNull(uri);
		String expected = "https://www.wunderlist.com/oauth/authorize?client_id=" + clientId + "&redirect_uri=" + callback + "&state=" + state;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetListRetrieveAllURI() {
		URI uri = uriProvider.getListRetrieveAllURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "lists";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetListRetrieveURI() {
		int listId = 15;
		URI uri = uriProvider.getListRetrieveURI(listId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "lists/" + listId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetPositionsListRetrieveAllURI() {
		URI uri = uriProvider.getPositionsListRetrieveAllURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "list_positions";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetPositionsListRetrieveURI() {
		int positionsId = 83;
		URI uri = uriProvider.getPositionsListRetrieveURI(positionsId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "list_positions/" + positionsId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetPositionsTaskRetrieveAllURI() {
		URI uri = uriProvider.getPositionsTaskRetrieveAllURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "task_positions";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetPositionsTaskRetrieveURI() {
		int positionsId = 56;
		URI uri = uriProvider.getPositionsTaskRetrieveURI(positionsId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "task_positions/" + positionsId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetPositionsTaskUpdateURI() {
		int positionsId = 72;
		URI uri = uriProvider.getPositionsTaskUpdateURI(positionsId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "task_positions/" + positionsId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetTaskRetrieveAllURI() {
		URI uri = uriProvider.getTaskRetrieveAllURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "tasks";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetTaskRetrieveURI() {
		int taskId = 61;
		URI uri = uriProvider.getTaskRetrieveURI(taskId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "tasks/" + taskId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetTaskUpdateURI() {
		int taskId = 11;
		URI uri = uriProvider.getTaskUpdateURI(taskId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "tasks/" + taskId;
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetWebhookRetrieveAllURI() {
		URI uri = uriProvider.getWebhookRetrieveAllURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "webhooks";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetWebhookCreateURI() {
		URI uri = uriProvider.getWebhookCreateURI();
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "webhooks";
		Assert.assertEquals(expected, uri.toString());
	}

	@Test
	public void testGetWebhookDeleteURI() {
		int webhookId = 43;
		URI uri = uriProvider.getWebhookDeleteURI(webhookId);
		Assert.assertNotNull(uri);
		String expected = URI_BASE + "webhooks/" + webhookId;
		Assert.assertEquals(expected, uri.toString());
	}

}
