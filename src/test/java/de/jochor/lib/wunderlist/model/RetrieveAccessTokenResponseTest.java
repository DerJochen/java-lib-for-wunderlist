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
public class RetrieveAccessTokenResponseTest extends AbstractRoundtripTest<RetrieveAccessTokenResponse> {

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
