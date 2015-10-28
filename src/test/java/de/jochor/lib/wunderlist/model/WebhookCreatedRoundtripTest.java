package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Round-trip test for a created {@link Webhook}.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 105743947,
 *   "processor_type": "generic",
 *   "url": "https://foo.bar.chadfowler.com/struts/asdf.do",
 *   "created_at": "2014-08-30T08:36:13.273Z",
 *   "created_by_id": 6234958,
 *   "configuration": ""
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
public class WebhookCreatedRoundtripTest extends AbstractRoundtripTest<Webhook> {

	private static final int id = 105743947;
	private static final String processor_type = "generic";
	private static final String url = "https:/yourhost.com/foo";
	private static final String created_at = "2015-03-03T15:32:09.272Z";
	private static final int created_by_id = 6234958;
	private static final String configuration = "";

	@Override
	protected Webhook createEntity() {
		Webhook entity = new Webhook();

		entity.setId(id);
		entity.setProcessor_type(processor_type);
		entity.setUrl(url);
		entity.setCreated_at(created_at);
		entity.setCreated_by_id(created_by_id);
		entity.setConfiguration(configuration);

		return entity;
	}

	@Override
	protected void assertEquals(Webhook expected, Webhook actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getProcessor_type(), actual.getProcessor_type());
		Assert.assertEquals(expected.getUrl(), actual.getUrl());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getCreated_by_id(), actual.getCreated_by_id());
		Assert.assertEquals(expected.getConfiguration(), actual.getConfiguration());
	}

}
