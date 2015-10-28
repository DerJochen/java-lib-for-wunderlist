package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Round-trip test for a retrieved {@link Webhook}.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 62,
 *   "list_id": 105743947,
 *   "membership_id": 49876097,
 *   "membership_type": "Membership",
 *   "url": "https:/yourhost.com/foo",
 *   "processor_type": "generic",
 *   "configuration": "",
 *   "created_at": "2015-03-03T15:32:09.272Z",
 *   "updated_at": "2015-03-03T15:32:09.272Z"
 * }</code>
 * </pre>
 *
 * <p>
 * <i>In the current methods always an array of {@link Webhook}s is retrieved.</i>
 * </p>
 *
 * <p>
 * <b>Started:</b> 2015-10-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class WebhookRoundtripTest extends AbstractRoundtripTest<Webhook> {

	private static final int id = 62;
	private static final int list_id = 105743947;
	private static final int membership_id = 49876097;
	private static final String membership_type = "Membership";
	private static final String url = "https:/yourhost.com/foo";
	private static final String processor_type = "generic";
	private static final String configuration = "";
	private static final String created_at = "2015-03-03T15:32:09.272Z";
	private static final String updated_at = "2015-03-03T15:32:09.272Z";

	@Override
	protected Webhook createEntity() {
		Webhook entity = new Webhook();

		entity.setId(id);
		entity.setList_id(list_id);
		entity.setMembership_id(membership_id);
		entity.setMembership_type(membership_type);
		entity.setUrl(url);
		entity.setProcessor_type(processor_type);
		entity.setConfiguration(configuration);
		entity.setCreated_at(created_at);
		entity.setUpdated_at(updated_at);

		return entity;
	}

	@Override
	protected void assertEquals(Webhook expected, Webhook actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertEquals(expected.getMembership_id(), actual.getMembership_id());
		Assert.assertEquals(expected.getMembership_type(), actual.getMembership_type());
		Assert.assertEquals(expected.getUrl(), actual.getUrl());
		Assert.assertEquals(expected.getProcessor_type(), actual.getProcessor_type());
		Assert.assertEquals(expected.getConfiguration(), actual.getConfiguration());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getUpdated_at(), actual.getUpdated_at());
	}

}
