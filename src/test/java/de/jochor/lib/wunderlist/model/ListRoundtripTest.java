package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Round-trip test for a {@link List}.
 *
 * <pre>
 * <code>json
 * {
 * "id": 83526310,
 * "title": "Read Later",
 * "owner_type":"user",
 * "owner_id":1235616,
 * "list_type": "list",
 * "public" : false,
 * "revision": 10,
 * "created_at": "2013-08-30T08:29:46.203Z",
 * "created_by_request_id" : "498d3ffc44ddfa2f275b:0fc81b85-31e0-4d09-b3f4-6af222...",
 * "type": "list"
 * }</code>
 * </pre>
 *
 * <p>
 * <b>Started:</b> 2015-08-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class ListRoundtripTest extends AbstractRoundtripTest<List> {

	public static final int id = 83526310;
	private static final String title = "Read Later";
	private static final String ownerType = "user";
	private static final int ownerID = 1639234;
	private static final String listType = "list";
	private static final boolean isPublic = false;
	private static final int revision = 10;
	private static final String createdAt = "2013-08-30T08:29:46.203Z";
	private static final String created_by_request_id = "kaioutctphcpcp438qt983q498hqc4849";
	private static final String type = "list";

	@Override
	protected List createEntity() {
		List entity = new List();

		entity.setId(id);
		entity.setTitle(title);
		entity.setOwner_type(ownerType);
		entity.setOwner_id(ownerID);
		entity.setList_type(listType);
		entity.setPublic(isPublic);
		entity.setRevision(revision);
		entity.setCreated_at(createdAt);
		entity.setCreated_by_request_id(created_by_request_id);
		entity.setType(type);

		return entity;
	}

	@Override
	protected void assertEquals(List expected, List actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getOwner_type(), actual.getOwner_type());
		Assert.assertEquals(expected.getOwner_id(), actual.getOwner_id());
		Assert.assertEquals(expected.getList_type(), actual.getList_type());
		Assert.assertEquals(expected.isPublic(), actual.isPublic());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getCreated_by_request_id(), actual.getCreated_by_request_id());
		Assert.assertEquals(expected.getType(), actual.getType());
	}

}
