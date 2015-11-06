package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Rount-trip test for a retrieved {@link Positions}.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 131232,
 *   "values": [123, 234, 345, 456],
 *   "revision": 1,
 *   "type": "list_position",
 *   "user_id": 43987865,
 *   "list_id": 326765049
 * }</code>
 * </pre>
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
	private static final int user_id = 43987865;
	private static final int list_id = 326765049;

	@Override
	protected Positions createEntity() {
		Positions entity = new Positions();

		entity.setId(id);
		entity.setRevision(revision);
		entity.setType(type);
		entity.setValues(values);
		entity.setUser_id(user_id);
		entity.setList_id(list_id);

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
		Assert.assertEquals(expected.getUser_id(), actual.getUser_id());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
	}

}
