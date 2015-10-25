package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

/**
 *
 * <p>
 * <b>Started:</b> 2015-08-25
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class RetrieveListResponseTest extends AbstractRoundtripTest<RetrieveListResponse> {

	public static final int id = 83526310;
	private static final String createdAt = "2013-08-30T08:29:46.203Z";
	private static final String title = "Read Later";
	private static final String listType = "list";
	private static final String type = "list";
	private static final int revision = 10;

	@Override
	protected RetrieveListResponse createEntity() {
		RetrieveListResponse retrieveListResponse = new RetrieveListResponse();
		retrieveListResponse.setId(id);
		retrieveListResponse.setTitle(title);
		retrieveListResponse.setCreated_at(createdAt);
		retrieveListResponse.setList_type(listType);
		retrieveListResponse.setType(type);
		retrieveListResponse.setRevision(revision);
		return retrieveListResponse;
	}

	@Override
	protected void assertEquals(RetrieveListResponse expected, RetrieveListResponse actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getList_type(), actual.getList_type());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
	}

}
