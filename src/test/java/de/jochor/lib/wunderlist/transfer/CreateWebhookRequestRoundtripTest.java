package de.jochor.lib.wunderlist.transfer;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;
import de.jochor.lib.wunderlist.transfer.CreateWebhookRequest;

/**
 * Round-trip test for a {@link CreateWebhookRequest}.
 * 
 * <pre>
 * <code>json
 * {
 *   "list_id": 105743947,
 *   "url":"https://foo.bar.chadfowler.com/struts/asdf.do",
 *   "processor_type":"generic",
 *   "configuration":""}
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
public class CreateWebhookRequestRoundtripTest extends AbstractRoundtripTest<CreateWebhookRequest> {

	private static final int list_id = 6956219;
	private static final String url = "http://my.callback.url/";
	private static final String processor_type = "The processor type";
	private static final String configuration = "The configuration";

	@Override
	protected CreateWebhookRequest createEntity() {
		CreateWebhookRequest entity = new CreateWebhookRequest(list_id, url, processor_type, configuration);
		return entity;
	}

	@Override
	protected void assertEquals(CreateWebhookRequest expected, CreateWebhookRequest actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertEquals(expected.getUrl(), actual.getUrl());
		Assert.assertEquals(expected.getProcessor_type(), actual.getProcessor_type());
		Assert.assertEquals(expected.getConfiguration(), actual.getConfiguration());
	}

}
