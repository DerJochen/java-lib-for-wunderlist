package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

/**
 *
 * <p>
 * <b>Started:</b> 2015-10-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class UpdateListPositionsRequestTest extends AbstractRoundtripTest<UpdateListPositionsRequest> {

	private static final int[] values = { 9, 68, 34, 3 };
	private static final int revision = 54;

	@Override
	protected UpdateListPositionsRequest createEntity() {
		UpdateListPositionsRequest entity = new UpdateListPositionsRequest(values, revision);
		return entity;
	}

	@Override
	protected void assertEquals(UpdateListPositionsRequest expected, UpdateListPositionsRequest actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
	}

}
