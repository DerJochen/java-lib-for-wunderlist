package de.jochor.lib.wunderlist.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.jochor.lib.json4j.JSONBindingService;
import de.jochor.lib.json4j.JSONBindingServiceFactory;
import de.jochor.lib.servicefactory.ServiceFactory;

/**
 * Base class for entity roundtrip tests.
 *
 * <p>
 * <b>Started:</b> 2015-10-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public abstract class AbstractRoundtripTest<T> {

	private JSONBindingService jsonEntityService = JSONBindingServiceFactory.create();

	@BeforeClass
	public static void setUpBeforeClass() {
		// Switch off outputs from the service factory
		System.setProperty(ServiceFactory.SILENT_MODE, "true");
	}

	@Test
	public void testJSONRoundtrip() {
		T entity = createEntity();

		String json = jsonEntityService.toJSON(entity);
		Assert.assertNotNull(json);
		Assert.assertFalse(json.isEmpty());

		@SuppressWarnings("unchecked")
		T entity2 = (T) jsonEntityService.toEntity(json, entity.getClass());

		assertEquals(entity, entity2);
	}

	protected abstract T createEntity();

	protected abstract void assertEquals(T expected, T actual);

}
