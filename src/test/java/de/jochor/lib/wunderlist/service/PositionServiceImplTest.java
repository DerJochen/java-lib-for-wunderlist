package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.jochor.lib.http4j.apache.HttpClientJUnit;
import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-24
 *
 */
public class PositionServiceImplTest {

	private static final int id = 34234234;
	private static final int revision = 124;
	private static final String type = "task_position";

	private PositionServiceImpl positionService;

	@Before
	public void setUp() {
		positionService = new PositionServiceImpl();
	}

	@Test
	public void testRetrieveListPositionsInt_emptyList() {
		int[] values = { 123, 234, 345, 456, 321 };
		String json = createRequestJSON(values);
		HttpClientJUnit.addResponse(json);

		RetrieveListPositionsResponse retrieveListPositionsResponse = positionService.retrieve(1);

		checkResponse(values, retrieveListPositionsResponse);
	}

	@Test
	public void testRetrieveListPositionsInt_normalList() {
		int[] values = { 123, 234, 345, 456, 321 };
		String json = createRequestJSON(values);
		HttpClientJUnit.addResponse(json);

		RetrieveListPositionsResponse retrieveListPositionsResponse = positionService.retrieve(1);

		checkResponse(values, retrieveListPositionsResponse);
	}

	@Ignore
	@Test
	public void testUpdateListPositionsIntArrayOfIntInt() {
		int id = 34234234;
		int listId = 34234234;
		int revision = 124;
		String type = "task_position";
		HttpClientJUnit.addResponse( //
				"{\"id\": " + id + "," //
						+ "\"values\": []," //
						+ "\"revision\": " + revision + "," //
						+ "\"list_id\": " + listId + "," //
						+ "\"type\": \"" + type + "\"" //
						+ "}");
		// TODO not yet implemented
		Assert.fail("not yet implemented");
	}

	protected String createRequestJSON(int[] values) {
		String json = "{\"id\": " + id + "," //
				+ "\"values\": " + Arrays.toString(values) + "," //
				+ "\"revision\": " + revision + "," //
				+ "\"type\": \"" + type + "\"" //
				+ "}";
		return json;
	}

	protected void checkResponse(int[] values, RetrieveListPositionsResponse retrieveListPositionsResponse) {
		Assert.assertNotNull(retrieveListPositionsResponse);
		Assert.assertEquals(id, retrieveListPositionsResponse.getId());
		Assert.assertEquals(revision, retrieveListPositionsResponse.getRevision());
		Assert.assertEquals(type, retrieveListPositionsResponse.getType());

		// FIXME int[] actualValues = retrieveListPositionsResponse.getValues();
		// Assert.assertNotNull(actualValues);
		// Assert.assertArrayEquals(values, actualValues);
	}

}
