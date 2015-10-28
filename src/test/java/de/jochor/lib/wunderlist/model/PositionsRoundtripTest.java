package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Rount-trip test for a retrieved {@link Positions}.
 *
 * <p>
 * <b>Started:</b> 2015-08-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class PositionsRoundtripTest extends AbstractRoundtripTest<Positions> {

	private static final int id = 34234234;
	private static final int revision = 124;
	private static final String type = "task_position";
	private static final int[] values = { 123, 234, 345, 456, 321 };

	@Override
	protected Positions createEntity() {
		Positions retrieveListPositionsResponse = new Positions();
		retrieveListPositionsResponse.setId(id);
		retrieveListPositionsResponse.setRevision(revision);
		retrieveListPositionsResponse.setType(type);
		retrieveListPositionsResponse.setValues(values);
		return retrieveListPositionsResponse;
	}

	@Override
	protected void assertEquals(Positions expected, Positions actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
	}

}
