package de.jochor.lib.wunderlist.model;

import java.util.Arrays;

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
public class RetrieveListPositionsResponseTest {

	private static final int id = 34234234;
	private static final int revision = 124;
	private static final String type = "task_position";

	private JSONBindingService jsonEntityService;

	@Before
	public void setUp() {
		jsonEntityService = new JSONBindingServiceGson();
	}

	@Test
	public void testJSONRoundtrip() {
		int[] values = { 123, 234, 345, 456, 321 };

		RetrieveListPositionsResponse retrieveListPositionsResponse = new RetrieveListPositionsResponse();
		retrieveListPositionsResponse.setId(id);
		retrieveListPositionsResponse.setRevision(revision);
		retrieveListPositionsResponse.setType(type);
		retrieveListPositionsResponse.setValues(values);

		String json = jsonEntityService.toJSON(retrieveListPositionsResponse);
		Assert.assertNotNull(json);
		Assert.assertFalse(json.isEmpty());

		RetrieveListPositionsResponse retrieveListPositionsResponse2 = jsonEntityService.toEntity(json, RetrieveListPositionsResponse.class);

		assertEquals(retrieveListPositionsResponse, retrieveListPositionsResponse2);
	}

	protected String createRequestJSON(int[] values) {
		String json = "{\"id\": " + id + "," //
				+ "\"values\": " + Arrays.toString(values) + "," //
				+ "\"revision\": " + revision + "," //
				+ "\"type\": \"" + type + "\"" //
				+ "}";
		return json;
	}

	protected void assertEquals(RetrieveListPositionsResponse expected, RetrieveListPositionsResponse actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.getType(), actual.getType());

		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
	}

}
