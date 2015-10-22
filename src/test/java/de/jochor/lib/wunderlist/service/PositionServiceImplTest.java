package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.servicefactory.ServiceFactory;
import de.jochor.lib.wunderlist.model.Authorization;
import de.jochor.lib.wunderlist.model.RetrieveListPositionsResponse;
import de.jochor.lib.wunderlist.model.UpdateListPositionsResponse;

/**
 *
 * <p>
 * <b>Started:</b> 2015-08-24
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class PositionServiceImplTest {

	private static final Authorization AUTHORIZATION = new Authorization();

	private static final int id = 34234234;
	private static final int revision = 124;
	private static final int listId = 34234;
	private static final String type = "task_position";

	private PositionsServiceImpl positionService;

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
		positionService = new PositionsServiceImpl();
	}

	@Test
	public void testRetrieveListPositionsInt_emptyList() {
		int[] values = {};
		String json = createRequestJSON(values);
		HTTPClientJUnit.addResponse(json);

		RetrieveListPositionsResponse retrieveListPositionsResponse = positionService.retrieve(1, AUTHORIZATION);

		checkResponse(values, retrieveListPositionsResponse);
	}

	@Test
	public void testRetrieveListPositionsInt_normalList() {
		int[] values = { 123, 234, 345, 456, 321 };
		String json = createRequestJSON(values);
		HTTPClientJUnit.addResponse(json);

		RetrieveListPositionsResponse retrieveListPositionsResponse = positionService.retrieve(1, AUTHORIZATION);

		checkResponse(values, retrieveListPositionsResponse);
	}

	@Test
	public void testUpdateListPositionsIntArrayOfIntInt_emptyList() {
		int[] values = {};
		String json = createUpdateJSON(values);
		HTTPClientJUnit.addResponse(json);

		UpdateListPositionsResponse updateListPositionsResponse = positionService.update(id, values, revision, AUTHORIZATION);

		checkResponse(values, updateListPositionsResponse);
	}

	@Test
	public void testUpdateListPositionsIntArrayOfIntInt_normalList() {
		int[] values = { 234, 345, 123, 456, 321 };
		String json = createUpdateJSON(values);
		HTTPClientJUnit.addResponse(json);

		UpdateListPositionsResponse updateListPositionsResponse = positionService.update(id, values, revision, AUTHORIZATION);

		checkResponse(values, updateListPositionsResponse);
	}

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

	protected void checkResponse(int[] values, RetrieveListPositionsResponse listPositionsResponse) {
		Assert.assertNotNull(listPositionsResponse);
		Assert.assertEquals(id, listPositionsResponse.getId());
		Assert.assertEquals(revision + 1, listPositionsResponse.getRevision());
		Assert.assertEquals(type, listPositionsResponse.getType());

		if (listPositionsResponse instanceof UpdateListPositionsResponse) {
			Assert.assertEquals(listId, ((UpdateListPositionsResponse) listPositionsResponse).getList_id());
		}

		int[] actualValues = listPositionsResponse.getValues();
		Assert.assertNotNull(actualValues);
		Assert.assertArrayEquals(values, actualValues);
	}

}
