package de.jochor.lib.wunderlist.transfer;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;
import de.jochor.lib.wunderlist.transfer.RetrieveAccessTokenRequest;

/**
 * Round-trip test for a {@link RetrieveAccessTokenRequest}.
 * 
 * <pre>
 * <code>json
 * {
 *   "clientId": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3",
 *   "clientSecrete": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3",
 *   "code": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"
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
public class RetrieveAccessTokenRequestRoundtripTest extends AbstractRoundtripTest<RetrieveAccessTokenRequest> {

	private static final String clientId = "The_clientId";
	private static final String clientSecrete = "The_clientSecrete";
	private static final String code = "The_code";

	@Override
	protected RetrieveAccessTokenRequest createEntity() {
		RetrieveAccessTokenRequest entity = new RetrieveAccessTokenRequest(clientId, clientSecrete, code);
		return entity;
	}

	@Override
	protected void assertEquals(RetrieveAccessTokenRequest expected, RetrieveAccessTokenRequest actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getClientId(), actual.getClientId());
		Assert.assertEquals(expected.getClientSecrete(), actual.getClientSecrete());
		Assert.assertEquals(expected.getCode(), actual.getCode());
	}

}
