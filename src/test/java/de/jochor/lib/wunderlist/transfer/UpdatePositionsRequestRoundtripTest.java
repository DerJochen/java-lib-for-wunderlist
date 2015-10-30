package de.jochor.lib.wunderlist.transfer;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;
import de.jochor.lib.wunderlist.transfer.UpdatePositionsRequest;

/**
 * Round-trip test for a {@link UpdatePositionsRequest}.
 * 
 * <pre>
 * <code>json
 * {
 * "values": [4567, 4568, 9876, 234],
 * "revision": 123
 * }</code>
 * </pre>
 *
 * <p>
 * <b>Started:</b> 2015-10-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class UpdatePositionsRequestRoundtripTest extends AbstractRoundtripTest<UpdatePositionsRequest> {

	private static final int[] values = { 9, 68, 34, 3 };
	private static final int revision = 54;

	@Override
	protected UpdatePositionsRequest createEntity() {
		UpdatePositionsRequest entity = new UpdatePositionsRequest(values, revision);
		return entity;
	}

	@Override
	protected void assertEquals(UpdatePositionsRequest expected, UpdatePositionsRequest actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected.getValues(), actual.getValues());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
	}

}
