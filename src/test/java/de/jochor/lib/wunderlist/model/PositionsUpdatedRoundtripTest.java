package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Rount-trip test for updated {@link Positions}.
 *
 * <p>
 * <b>Started:</b> 2015-10-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class PositionsUpdatedRoundtripTest extends AbstractRoundtripTest<Positions> {

	private static final int id = 342334;
	private static final int revision = 14;
	private static final String type = "task_position";
	private static final int[] values = { 345, 456, 123, 234, 321 };
	private static final int listID = 87941;

	@Override
	protected Positions createEntity() {
		Positions entity = new Positions();
		entity.setId(id);
		entity.setRevision(revision);
		entity.setType(type);
		entity.setValues(values);
		entity.setList_id(listID);
		return entity;
	}

	@Override
	protected void assertEquals(Positions expected, Positions actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
	}

}
