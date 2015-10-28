package de.jochor.lib.wunderlist.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.servicefactory.ServiceFactory;
import de.jochor.lib.wunderlist.model.Authorization;

/**
 * Abstract base class for REST client service implementations.
 *
 * <p>
 * <b>Started:</b> 2015-10-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public abstract class AbstractRESTClientServiceTest {

	protected static final Authorization AUTHORIZATION = new Authorization();

	@BeforeClass
	public static void setUpBeforeClass() {
		// Switch off outputs from the service factory
		System.setProperty(ServiceFactory.SILENT_MODE, "true");

		AUTHORIZATION.setClientId("the applications id");
		AUTHORIZATION.setUserToken("the users access token");

		HTTPClientJUnit.addExpectedHeader("X-Client-ID", AUTHORIZATION.getClientId());
		HTTPClientJUnit.addExpectedHeader("X-Access-Token", AUTHORIZATION.getUserToken());
	}

	@AfterClass
	public static void tearDownAfterClass() {
		HTTPClientJUnit.clearExpectedHeaders();
	}

	protected JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	@After
	public void tearDown() {
		HTTPClientJUnit.clearResponses();
	}

}
