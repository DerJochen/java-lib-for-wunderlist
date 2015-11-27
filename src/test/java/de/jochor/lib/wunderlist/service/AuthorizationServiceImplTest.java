package de.jochor.lib.wunderlist.service;

import java.net.URI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.servicefactory.ServiceFactory;

/**
 * Test for the {@link AuthorizationServiceImpl}.
 *
 * <p>
 * <b>Started:</b> 2015-11-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class AuthorizationServiceImplTest {

	private final String clientID = "the_clientID";
	private final String callback = "http://localhost/the_callback";
	private final String state = "the_state";
	private final String clientSecrete = "the_clientSecrete";
	private final String code = "the_code";
	private final String accessToken = "the_accessToken";

	private AuthorizationServiceImpl authorizationService;

	@BeforeClass
	public static void setUpBeforeClass() {
		// Switch off outputs from the service factory
		System.setProperty(ServiceFactory.SILENT_MODE, "true");
	}

	@Before
	public void setUp() {
		authorizationService = new AuthorizationServiceImpl();
	}

	@Test
	public void testBuildAuthorisationRequestURI() {
		URI authorisationRequestURI = authorizationService.buildAuthorisationRequestURI(clientID, callback, state);

		Assert.assertNotNull(authorisationRequestURI);
		Assert.assertEquals(
				URI.create("https://www.wunderlist.com/oauth/authorize?client_id=" + clientID + "&redirect_uri=http%3A%2F%2Flocalhost%2Fthe_callback&state="
						+ state), authorisationRequestURI);
	}

	@Test
	public void testRetrieveAccessToken() {
		HTTPClientJUnit.addResponse("{\"access_token\":\"" + accessToken + "\"}");

		String actualAccessToken = authorizationService.retrieveAccessToken(clientID, clientSecrete, code);

		Assert.assertNotNull(accessToken);
		Assert.assertEquals(accessToken, actualAccessToken);
	}

}
