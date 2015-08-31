package de.jochor.lib.wunderlist.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.json.JSONBindingService;
import de.jochor.lib.json.gson.JSONBindingServiceGson;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-25
 *
 */
public class RetrieveListResponseTest {

	private static final int id = 83526310;
	private static final String createdAt = "2013-08-30T08:29:46.203Z";
	private static final String title = "Read Later";
	private static final String listType = "list";
	private static final String type = "list";
	private static final int revision = 10;

	private JSONBindingService jsonEntityService;

	@Before
	public void setUp() {
		jsonEntityService = new JSONBindingServiceGson();
	}

	@Test
	public void testJSONRoundtrip() {
		RetrieveListResponse retrieveListResponse = createListResponse();

		String json = jsonEntityService.toJSON(retrieveListResponse);
		Assert.assertNotNull(json);
		Assert.assertFalse(json.isEmpty());

		RetrieveListResponse retrieveListResponse2 = jsonEntityService.toEntity(json, RetrieveListResponse.class);

		assertEquals(retrieveListResponse, retrieveListResponse2);
	}

	public static RetrieveListResponse createListResponse() {
		RetrieveListResponse retrieveListResponse = new RetrieveListResponse();
		retrieveListResponse.setId(id);
		retrieveListResponse.setTitle(title);
		retrieveListResponse.setCreated_at(createdAt);
		retrieveListResponse.setList_type(listType);
		retrieveListResponse.setType(type);
		retrieveListResponse.setRevision(revision);
		return retrieveListResponse;
	}

	public static String createListJSON(int number) {
		return "{\"id\": " + (id + number) + ", " //
				+ "\"created_at\": \"" + createdAt + "\",  " //
				+ "\"title\": \"" + title + number + "\",  " //
				+ "\"list_type\": \"" + listType + "\",  " //
				+ "\"type\": \"" + type + "\",  " //
				+ "\"revision\": " + (revision + number) //
				+ "}";
	}

	public static void assertEquals(RetrieveListResponse expected, RetrieveListResponse actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getList_type(), actual.getList_type());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
	}

	public static void checkListResponse(RetrieveListResponse retrieveListResponse, int number) {
		Assert.assertNotNull(retrieveListResponse);
		Assert.assertEquals(id + number, retrieveListResponse.getId());
		Assert.assertEquals(createdAt, retrieveListResponse.getCreated_at());
		Assert.assertEquals(title + number, retrieveListResponse.getTitle());
		Assert.assertEquals(listType, retrieveListResponse.getList_type());
		Assert.assertEquals(type, retrieveListResponse.getType());
		Assert.assertEquals(revision + number, retrieveListResponse.getRevision());
	}

}
