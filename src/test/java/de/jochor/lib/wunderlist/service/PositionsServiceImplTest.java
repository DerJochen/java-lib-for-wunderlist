package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
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
	private static final String type_list = "list_position";
	private static final String type_task = "task_position";

	private PositionsServiceImpl positionsService;

	@Before
	public void setUp() {
		positionsService = new PositionsServiceImpl();
	}

	@Test
	public void testRetrieveAllListPositions_noPositions() {
		HTTPClientJUnit.addResponse("[]");

		Positions[] positions = positionsService.retrieveAllListPositions(AUTHORIZATION);
		Assert.assertNotNull(positions);
		Assert.assertEquals(0, positions.length);
	}

	@Test
	public void testRetrieveAllListPositions_onePositions() {
		int[] values = { 123, 234, 345, 456, 321 };
		Positions[] positionsArray = createListPositions(type_list, values);
		String json = jsonEntityService.toJSON(positionsArray);
		HTTPClientJUnit.addResponse(json);

		Positions[] actuals = positionsService.retrieveAllListPositions(AUTHORIZATION);
		Assert.assertNotNull(actuals);
		Assert.assertEquals(positionsArray.length, actuals.length);
		for (int i = 0, length = positionsArray.length; i < length; i++) {
			assertEquals(positionsArray[i], actuals[i]);
		}
	}

	@Test
	public void testRetrieveListPositions() {
		int[] values = { 123, 234, 345, 456, 321 };
		Positions[] positionsArray = createListPositions(type_list, values);
		Positions positions = positionsArray[0];
		String json = jsonEntityService.toJSON(positions);
		HTTPClientJUnit.addResponse(json);

		Positions actual = positionsService.retrieveListPositions(id, AUTHORIZATION);
		Assert.assertNotNull(actual);
		assertEquals(positions, actual);
	}

	@Test
	public void testRetrieveAllTaskPositions_noPositions() {
		HTTPClientJUnit.addResponse("[]");

		int listID = 843;
		Positions[] positions = positionsService.retrieveAllTaskPositions(listID, AUTHORIZATION);
		Assert.assertNotNull(positions);
		Assert.assertEquals(0, positions.length);
	}

	@Test
	public void testRetrieveAllTaskPositions_onePositions() {
		int[] values = { 123, 234, 345, 456, 321 };
		Positions[] positionsArray = createListPositions(type_task, values);
		String json = jsonEntityService.toJSON(positionsArray);
		HTTPClientJUnit.addResponse(json);

		int listID = 843;
		Positions[] actuals = positionsService.retrieveAllTaskPositions(listID, AUTHORIZATION);
		Assert.assertNotNull(actuals);
		Assert.assertEquals(positionsArray.length, actuals.length);
		for (int i = 0, length = positionsArray.length; i < length; i++) {
			assertEquals(positionsArray[i], actuals[i]);
		}
	}

	@Test
	public void testRetrieveTaskPositions() {
		int[] values = { 123, 234, 345, 456, 321 };
		Positions[] positionsArray = createListPositions(type_task, values);
		Positions positions = positionsArray[0];
		String json = jsonEntityService.toJSON(positions);
		HTTPClientJUnit.addResponse(json);

		Positions actual = positionsService.retrieveTaskPositions(id, AUTHORIZATION);
		Assert.assertNotNull(actual);
		assertEquals(positions, actual);
	}

	@Test
	public void testUpdateTaskPositions() {
		int[] values = { 123, 234, 345, 456, 321 };
		Positions[] positionsArray = createListPositions(type_task, values);
		Positions positions = positionsArray[0];
		String json = jsonEntityService.toJSON(positions);
		HTTPClientJUnit.addResponse(json);

		Positions actual = positionsService.updateTaskPositions(id, values, positions.getRevision(), AUTHORIZATION);
		Assert.assertNotNull(actual);
		assertEquals(positions, actual);
	}

	private Positions[] createListPositions(String type, int[]... valuesArrays) {
		int positionsCount = valuesArrays.length;
		Positions[] positionsArray = new Positions[positionsCount];

		for (int i = 0; i < positionsCount; i++) {
			Positions positions = new Positions();

			positions.setId(id + i);
			positions.setRevision(revision + i);
			positions.setValues(valuesArrays[i]);
			positions.setType(type);

			positionsArray[i] = positions;
		}

		return positionsArray;
	}

	protected String createTaskUpdateJSON(int[] values) {
		String json = "{\"id\": " + id + "," //
				+ "\"values\": " + Arrays.toString(values) + "," //
				+ "\"revision\": " + (revision + 1) + "," //
				+ "\"list_id\": " + listId + "," //
				+ "\"type\": \"" + type_task + "\"" //
				+ "}";
		return json;
	}

	private void assertEquals(Positions expected, Positions actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
		Assert.assertEquals(expected.getType(), actual.getType());
	}

}
