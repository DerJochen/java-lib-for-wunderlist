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
public class RetrieveAccessTokenRequestTest extends AbstractRoundtripTest<RetrieveAccessTokenRequest> {

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
