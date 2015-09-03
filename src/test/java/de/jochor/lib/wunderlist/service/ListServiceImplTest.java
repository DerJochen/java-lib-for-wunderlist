package de.jochor.lib.wunderlist.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.apache.HttpClientJUnit;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;
import de.jochor.lib.wunderlist.model.RetrieveListResponseTest;

public class ListServiceImplTest {

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
		String response = "[" + RetrieveListResponseTest.createListJSON(0) + "]";
		HttpClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll();

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(1, allListsResponse.length);
		RetrieveListResponseTest.checkListResponse(allListsResponse[0], 0);
	}

	@Test
	public void testRetrieveAll_threeLists() {
		String response = "[" + RetrieveListResponseTest.createListJSON(0) + "," + RetrieveListResponseTest.createListJSON(1) + ","
				+ RetrieveListResponseTest.createListJSON(2) + "]";
		HttpClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll();
		Assert.assertEquals(3, allListsResponse.length);
		for (int i = 0; i < 3; i++) {
			RetrieveListResponseTest.checkListResponse(allListsResponse[i], i);
		}
	}

	@Test
	public void testRetrieveInt() {
		HttpClientJUnit.addResponse(RetrieveListResponseTest.createListJSON(0));

		RetrieveListResponse retrieveListResponse = listService.retrieve(1);

		RetrieveListResponseTest.checkListResponse(retrieveListResponse, 0);
	}

}
