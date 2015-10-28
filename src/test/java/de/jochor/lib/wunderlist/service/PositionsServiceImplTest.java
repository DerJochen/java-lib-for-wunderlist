package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;

import de.jochor.lib.wunderlist.model.Positions;

/**
 * Test for the {@link PositionsServiceImpl}.
 *
 * <p>
 * <b>Started:</b> 2015-08-24
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class PositionsServiceImplTest extends AbstractRESTClientServiceTest {

	private static final int id = 34234234;
	private static final int revision = 124;
	private static final int listId = 34234;
	private static final String type = "task_position";

	private PositionsServiceImpl positionService;

	@Before
	public void setUp() {
		positionService = new PositionsServiceImpl();
	}

	// @Test
	// public void testRetrieveListPositionsInt_emptyList() {
	// int[] values = {};
	// String json = createRequestJSON(values);
	// HTTPClientJUnit.addResponse(json);
	//
	// Positions positions = positionService.retrieve(1, AUTHORIZATION);
	//
	// checkResponse(values, positions);
	// }
	//
	// @Test
	// public void testRetrieveListPositionsInt_normalList() {
	// int[] values = { 123, 234, 345, 456, 321 };
	// String json = createRequestJSON(values);
	// HTTPClientJUnit.addResponse(json);
	//
	// Positions positions = positionService.retrieve(1, AUTHORIZATION);
	//
	// checkResponse(values, positions);
	// }
	//
	// @Test
	// public void testUpdateListPositionsIntArrayOfIntInt_emptyList() {
	// int[] values = {};
	// String json = createUpdateJSON(values);
	// HTTPClientJUnit.addResponse(json);
	//
	// Positions positions = positionService.update(id, values, revision, AUTHORIZATION);
	//
	// checkResponse(values, positions);
	// }
	//
	// @Test
	// public void testUpdateListPositionsIntArrayOfIntInt_normalList() {
	// int[] values = { 234, 345, 123, 456, 321 };
	// String json = createUpdateJSON(values);
	// HTTPClientJUnit.addResponse(json);
	//
	// Positions positions = positionService.update(id, values, revision, AUTHORIZATION);
	//
	// checkResponse(values, positions);
	// }

	protected String createRequestJSON(int[] values) {
		String json = "{\"id\": " + id + "," //
				+ "\"values\": " + Arrays.toString(values) + "," //
				+ "\"revision\": " + (revision + 1) + "," //
				+ "\"type\": \"" + type + "\"" //
				+ "}";
		return json;
	}

	protected String createUpdateJSON(int[] values) {
		String json = "{\"id\": " + id + "," //
				+ "\"values\": " + Arrays.toString(values) + "," //
				+ "\"revision\": " + (revision + 1) + "," //
				+ "\"list_id\": " + listId + "," //
				+ "\"type\": \"" + type + "\"" //
				+ "}";
		return json;
	}

	protected void checkResponse(int[] values, Positions positions) {
		Assert.assertNotNull(positions);
		Assert.assertEquals(id, positions.getId());
		Assert.assertEquals(revision + 1, positions.getRevision());
		Assert.assertEquals(type, positions.getType());
		int[] actualValues = positions.getValues();
		Assert.assertNotNull(actualValues);
		Assert.assertArrayEquals(values, actualValues);
		if (positions.getList_id() != 0) {
			Assert.assertEquals(listId, positions.getList_id());
		}
	}

}
