package de.jochor.lib.wunderlist.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http.apache.HttpClientJUnit;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;

public class ListServiceImplTest {

	private static final int id = 83526310;
	private static final String createdAt = "2013-08-30T08:29:46.203Z";
	private static final String title = "Read Later";
	private static final String listType = "list";
	private static final String type = "list";
	private static final int revision = 10;

	private ListServiceImpl listService;

	@Before
	public void setUp() {
		listService = new ListServiceImpl();
	}

	@Test
	public void testRetrieveAll_noLists() {
		HttpClientJUnit.addResponse("[]");

		RetrieveListResponse[] allListsResponse = listService.retrieveAll();

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(0, allListsResponse.length);
	}

	@Test
	public void testRetrieveAll_oneList() {
		String response = "[" + createListJSON(0) + "]";
		HttpClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll();

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(1, allListsResponse.length);
		checkListResponse(allListsResponse[0], 0);
	}

	@Test
	public void testRetrieveAll_threeLists() {
		String response = "[" + createListJSON(0) + "," + createListJSON(1) + "," + createListJSON(2) + "]";
		HttpClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll();
		Assert.assertEquals(3, allListsResponse.length);
		for (int i = 0; i < 3; i++) {
			checkListResponse(allListsResponse[i], i);
		}
	}

	@Test
	public void testRetrieveInt() {
		HttpClientJUnit.addResponse(createListJSON(0));

		RetrieveListResponse retrieveListResponse = listService.retrieve(1);

		checkListResponse(retrieveListResponse, 0);
	}

	protected String createListJSON(int number) {
		return "{\"id\": " + (id + number) + ", " //
				+ "\"created_at\": \"" + createdAt + "\",  " //
				+ "\"title\": \"" + title + number + "\",  " //
				+ "\"list_type\": \"" + listType + "\",  " //
				+ "\"type\": \"" + type + "\",  " //
				+ "\"revision\": " + (revision + number) + "}";
	}

	protected void checkListResponse(RetrieveListResponse retrieveListResponse, int number) {
		Assert.assertNotNull(retrieveListResponse);
		Assert.assertEquals(id + number, retrieveListResponse.getId());
		Assert.assertEquals(createdAt, retrieveListResponse.getCreated_at());
		Assert.assertEquals(title + number, retrieveListResponse.getTitle());
		Assert.assertEquals(listType, retrieveListResponse.getList_type());
		Assert.assertEquals(type, retrieveListResponse.getType());
		Assert.assertEquals(revision + number, retrieveListResponse.getRevision());
	}

}
