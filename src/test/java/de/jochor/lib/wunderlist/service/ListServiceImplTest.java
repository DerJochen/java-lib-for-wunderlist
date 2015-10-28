package de.jochor.lib.wunderlist.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.wunderlist.model.List;
import de.jochor.lib.wunderlist.model.ListRoundtripTest;

/**
 * Test for the {@link ListServiceImpl}.
 *
 * <p>
 * <b>Started:</b> 2015-08-21
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class ListServiceImplTest extends AbstractRESTClientServiceTest {

	public static final int id = 83526310;
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
		HTTPClientJUnit.addResponse("[]");

		List[] allLists = listService.retrieveAll(AUTHORIZATION);

		Assert.assertNotNull(allLists);
		Assert.assertEquals(0, allLists.length);
	}

	@Test
	public void testRetrieveAll_oneList() {
		String response = "[" + createListJSON(0) + "]";
		HTTPClientJUnit.addResponse(response);

		List[] allLists = listService.retrieveAll(AUTHORIZATION);

		Assert.assertNotNull(allLists);
		Assert.assertEquals(1, allLists.length);
		checkList(allLists[0], 0);
	}

	@Test
	public void testRetrieveAll_threeLists() {
		String response = "[" + createListJSON(0) + "," + createListJSON(1) + "," + createListJSON(2) + "]";
		HTTPClientJUnit.addResponse(response);

		List[] allLists = listService.retrieveAll(AUTHORIZATION);
		Assert.assertEquals(3, allLists.length);
		for (int i = 0; i < 3; i++) {
			checkList(allLists[i], i);
		}
	}

	@Test
	public void testRetrieveInt() {
		HTTPClientJUnit.addResponse(createListJSON(0));

		List list = listService.retrieve(ListRoundtripTest.id, AUTHORIZATION);

		checkList(list, 0);
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

	private static void checkList(List list, int number) {
		Assert.assertNotNull(list);
		Assert.assertEquals(id + number, list.getId());
		Assert.assertEquals(createdAt, list.getCreated_at());
		Assert.assertEquals(title + number, list.getTitle());
		Assert.assertEquals(listType, list.getList_type());
		Assert.assertEquals(type, list.getType());
		Assert.assertEquals(revision + number, list.getRevision());
	}

}
