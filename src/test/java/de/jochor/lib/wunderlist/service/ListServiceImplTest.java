package de.jochor.lib.wunderlist.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.servicefactory.ServiceFactory;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;
import de.jochor.lib.wunderlist.model.RetrieveListResponseTest;

public class ListServiceImplTest {

	public static final int id = 83526310;
	private static final String createdAt = "2013-08-30T08:29:46.203Z";
	private static final String title = "Read Later";
	private static final String listType = "list";
	private static final String type = "list";
	private static final int revision = 10;

	private static final Authorization AUTHORIZATION = new Authorization();

	private ListServiceImpl listService;

	@BeforeClass
	public static void setUpBeforeClass() {
		// Switch off outputs from the service factory
		System.setProperty(ServiceFactory.SILENT_MODE, "true");

		AUTHORIZATION.setClientId("the applications id");
		AUTHORIZATION.setUserToken("the users access token");

		HTTPClientJUnit.addExpectedHeader("X-Client-ID", AUTHORIZATION.getClientId());
		HTTPClientJUnit.addExpectedHeader("X-Access-Token", AUTHORIZATION.getUserToken());
	}

	@AfterClass
	public static void tearDownAfterClass() {
		HTTPClientJUnit.clearExpectedHeaders();
	}

	@Before
	public void setUp() {
		listService = new ListServiceImpl();
	}

	@Test
	public void testRetrieveAll_noLists() {
		HTTPClientJUnit.addResponse("[]");

		RetrieveListResponse[] allListsResponse = listService.retrieveAll(AUTHORIZATION);

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(0, allListsResponse.length);
	}

	@Test
	public void testRetrieveAll_oneList() {
		String response = "[" + createListJSON(0) + "]";
		HTTPClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll(AUTHORIZATION);

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(1, allListsResponse.length);
		checkListResponse(allListsResponse[0], 0);
	}

	@Test
	public void testRetrieveAll_threeLists() {
		String response = "[" + createListJSON(0) + "," + createListJSON(1) + "," + createListJSON(2) + "]";
		HTTPClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll(AUTHORIZATION);
		Assert.assertEquals(3, allListsResponse.length);
		for (int i = 0; i < 3; i++) {
			checkListResponse(allListsResponse[i], i);
		}
	}

	@Test
	public void testRetrieveInt() {
		HTTPClientJUnit.addResponse(createListJSON(0));

		RetrieveListResponse retrieveListResponse = listService.retrieve(RetrieveListResponseTest.id, AUTHORIZATION);

		checkListResponse(retrieveListResponse, 0);
	}

	private static String createListJSON(int number) {
		return "{\"id\": " + (id + number) + ", " //
				+ "\"created_at\": \"" + createdAt + "\",  " //
				+ "\"title\": \"" + title + number + "\",  " //
				+ "\"list_type\": \"" + listType + "\",  " //
				+ "\"type\": \"" + type + "\",  " //
				+ "\"revision\": " + (revision + number) //
				+ "}";
	}

	private static void checkListResponse(RetrieveListResponse retrieveListResponse, int number) {
		Assert.assertNotNull(retrieveListResponse);
		Assert.assertEquals(id + number, retrieveListResponse.getId());
		Assert.assertEquals(createdAt, retrieveListResponse.getCreated_at());
		Assert.assertEquals(title + number, retrieveListResponse.getTitle());
		Assert.assertEquals(listType, retrieveListResponse.getList_type());
		Assert.assertEquals(type, retrieveListResponse.getType());
		Assert.assertEquals(revision + number, retrieveListResponse.getRevision());
	}

}
