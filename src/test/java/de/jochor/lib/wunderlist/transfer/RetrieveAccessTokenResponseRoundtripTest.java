package de.jochor.lib.wunderlist.transfer;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;
import de.jochor.lib.wunderlist.transfer.RetrieveAccessTokenResponse;

/**
 * Round-trip test for a {@link RetrieveAccessTokenResponse}.
 * 
 * <pre>
 * <code>json
 * {
 * "access_token": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"
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
public class RetrieveAccessTokenResponseRoundtripTest extends AbstractRoundtripTest<RetrieveAccessTokenResponse> {

	private static final String accessToken = "The_accessToken";

	@Override
	protected RetrieveAccessTokenResponse createEntity() {
		RetrieveAccessTokenResponse entity = new RetrieveAccessTokenResponse();
		entity.setAccess_token(accessToken);
		return entity;
	}

	@Override
	protected void assertEquals(RetrieveAccessTokenResponse expected, RetrieveAccessTokenResponse actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getAccess_token(), actual.getAccess_token());
	}

}
