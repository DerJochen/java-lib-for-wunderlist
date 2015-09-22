package de.jochor.lib.wunderlist.service;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.apache.HTTPClientJUnit;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;
import de.jochor.lib.wunderlist.model.RetrieveListResponseTest;

public class ListServiceImplTest {

	private static final Authorization AUTHORIZATION = new Authorization();

	private ListServiceImpl listService;

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
		String response = "[" + RetrieveListResponseTest.createListJSON(0) + "]";
		HTTPClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll(AUTHORIZATION);

		Assert.assertNotNull(allListsResponse);
		Assert.assertEquals(1, allListsResponse.length);
		RetrieveListResponseTest.checkListResponse(allListsResponse[0], 0);
	}

	@Test
	public void testRetrieveAll_threeLists() {
		String response = "[" + RetrieveListResponseTest.createListJSON(0) + "," + RetrieveListResponseTest.createListJSON(1) + ","
				+ RetrieveListResponseTest.createListJSON(2) + "]";
		HTTPClientJUnit.addResponse(response);

		RetrieveListResponse[] allListsResponse = listService.retrieveAll(AUTHORIZATION);
		Assert.assertEquals(3, allListsResponse.length);
		for (int i = 0; i < 3; i++) {
			RetrieveListResponseTest.checkListResponse(allListsResponse[i], i);
		}
	}

	@Test
	public void testRetrieveInt() {
		HTTPClientJUnit.addResponse(RetrieveListResponseTest.createListJSON(0));

		RetrieveListResponse retrieveListResponse = listService.retrieve(1, AUTHORIZATION);

		RetrieveListResponseTest.checkListResponse(retrieveListResponse, 0);
	}

	@Test
	public void testRetrieveInt_real() {
		Properties realProperties = RealProperties.getRealProperties();
		if (realProperties == null) {
			return;
		}

		; // TODO
	}

}
