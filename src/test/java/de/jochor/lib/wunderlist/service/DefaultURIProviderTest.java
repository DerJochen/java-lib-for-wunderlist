package de.jochor.lib.wunderlist.service;

import java.net.URI;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the {@link DefaultURIProvider}.
 *
 * <p>
 * <b>Started:</b> 2015-11-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class DefaultURIProviderTest {

	private DefaultURIProvider uriProvider;

	@Before
	public void setUp() {
		uriProvider = new DefaultURIProvider();
	}

	@Test(expected = InitException.class)
	public void testDefaultURIProviderPath() {
		new DefaultURIProvider(Paths.get("not-really-a-path"));
	}

	@Test
	public void testSameURITwice() {
		URI accessTokenURI1 = uriProvider.getAuthorizationAccessTokenURI();
		Assert.assertNotNull(accessTokenURI1);
		URI accessTokenURI2 = uriProvider.getAuthorizationAccessTokenURI();
		Assert.assertSame(accessTokenURI1, accessTokenURI2);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGetStaticURI() {
		uriProvider.getStaticURI("not-static.tpl");
	}

}
