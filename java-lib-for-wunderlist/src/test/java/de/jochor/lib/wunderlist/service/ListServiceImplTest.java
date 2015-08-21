package de.jochor.lib.wunderlist.service;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http.apache.HttpClientJUnit;
import de.jochor.lib.wunderlist.model.RetrieveAllListsResponse;
import de.jochor.lib.wunderlist.model.RetrieveAllListsResponse.List;
import de.jochor.lib.wunderlist.model.RetrieveListResponse;

public class ListServiceImplTest {

	private ListServiceImpl listService;

	@Before
	public void setUp() {
		listService = new ListServiceImpl();
	}

	@Test
	public void testRetrieveAll_noLists() {
		HttpClientJUnit.addResponse("[]");

		RetrieveAllListsResponse allListsResponse = listService.retrieveAll();

		Assert.assertNotNull(allListsResponse);

		ArrayList<List> lists = allListsResponse.getLists();
		Assert.assertNotNull(lists);
		Assert.assertTrue(lists.isEmpty());
	}

	@Test
	public void testRetrieveInt() {
		int id = 83526310;
		HttpClientJUnit.addResponse( //
				"{\"id\": " + id + ", " //
						+ "\"created_at\": \"2013-08-30T08:29:46.203Z\",  " //
						+ "\"title\": \"Read Later\",  " //
						+ "\"list_type\": \"list\",  " //
						+ "\"type\": \"list\",  " //
						+ "\"revision\": 10}" //
		);

		RetrieveListResponse retrieveListResponse = listService.retrieve(1);

		Assert.assertNotNull(retrieveListResponse);
		Assert.assertEquals(id, retrieveListResponse.getId());
		// TODO continue test
	}

}
