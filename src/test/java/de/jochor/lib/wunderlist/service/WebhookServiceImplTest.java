package de.jochor.lib.wunderlist.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.wunderlist.model.Webhook;
import de.jochor.lib.wunderlist.transfer.CreateWebhookRequest;

/**
 * Test for the {@link WebhookServiceImpl}.
 *
 * <p>
 * <b>Started:</b> 2015-10-28
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class WebhookServiceImplTest extends AbstractRESTClientServiceTest {

	private static final int id = 62;
	private static final int list_id = 105743947;
	private static final int membership_id = 49876097;
	private static final String membership_type = "Membership";
	private static final String url = "https:/yourhost.com/foo";
	private static final String processor_type = "generic";
	private static final String configuration = "";
	private static final String created_at = "2015-03-03T15:32:09.272Z";
	private static final int created_by_id = 84646989;
	private static final String updated_at = "2015-03-03T15:32:09.272Z";

	private WebhookServiceImpl webhookService;

	@Before
	public void setUp() throws Exception {
		webhookService = new WebhookServiceImpl();
	}

	@Test
	public void testRetrieveAll_noWebhooks() {
		String json = "[]";
		HTTPClientJUnit.addResponse(json, "list_id=1");

		Webhook[] webhooksForList = webhookService.retrieveAll(1, AUTHORIZATION);
		Assert.assertNotNull(webhooksForList);
		Assert.assertEquals(0, webhooksForList.length);
	}

	@Test
	public void testRetrieveAll_withWebhooks() {
		Webhook[] webhooks = createWebhooks(5);
		String json = jsonEntityService.toJSON(webhooks);
		HTTPClientJUnit.addResponse(json, "list_id=5");

		Webhook[] webhooksForList = webhookService.retrieveAll(5, AUTHORIZATION);
		Assert.assertNotNull(webhooksForList);
		Assert.assertEquals(webhooks.length, webhooksForList.length);
		for (int i = 0; i < webhooks.length; i++) {
			assertEquals(webhooks[i], webhooksForList[i]);
		}
	}

	@Test
	public void testCreate() {
		Webhook[] webhooks = createWebhooks(1);
		String json = jsonEntityService.toJSON(webhooks[0]);
		HTTPClientJUnit.addResponse(json);

		CreateWebhookRequest request = new CreateWebhookRequest(list_id, url, processor_type, configuration);
		Webhook webhook = webhookService.create(request, AUTHORIZATION);
		Assert.assertNotNull(webhook);
		assertEquals(webhooks[0], webhook);
	}

	@Test
	public void testDelete() {
		HTTPClientJUnit.addResponse("");

		Assert.assertTrue(webhookService.delete(id, AUTHORIZATION));
	}

	private Webhook[] createWebhooks(int count) {
		Webhook[] webhooks = new Webhook[count];

		for (int i = 0; i < count; i++) {
			Webhook webhook = new Webhook();

			webhook.setId(id + i);
			webhook.setList_id(list_id + i);
			webhook.setMembership_id(membership_id + i);
			webhook.setMembership_type(membership_type + i);
			webhook.setUrl(url + 1);
			webhook.setProcessor_type(processor_type);
			webhook.setConfiguration(configuration + i);
			webhook.setCreated_at(created_at);
			webhook.setCreated_by_id(created_by_id + i);
			webhook.setUpdated_at(updated_at);

			webhooks[i] = webhook;
		}

		return webhooks;
	}

	private void assertEquals(Webhook expected, Webhook actual) {
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
		Assert.assertEquals(expected.getCreated_by_id(), actual.getCreated_by_id());
		Assert.assertEquals(expected.getUpdated_at(), actual.getUpdated_at());
	}

}
