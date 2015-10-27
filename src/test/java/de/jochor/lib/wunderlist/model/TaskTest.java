package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

/**
 *
 * <p>
 * <b>Started:</b> 2015-10-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class TaskTest extends AbstractRoundtripTest<Task> {

	private static final int id = 62;
	private static final int assignee_id = 85893;
	private static final int assigner_id = 28758;
	private static final String created_at = "2015-03-03T15:32:09.272Z";
	private static final int created_by_id = 828986;
	private static final String due_date = "2015-03-05T15:32:09.272Z";
	private static final int list_id = 105743947;
	private static final int revision = 2;
	private static final boolean starred = false;
	private static final String title = "Test Task";
	private static final String completed_at = "2015-03-04T15:32:09.272Z";
	private static final int completed_by_id = 82984;

	@Override
	protected Task createEntity() {
		Task entity = new Task();
		entity.setId(id);
		entity.setAssignee_id(assignee_id);
		entity.setAssigner_id(assigner_id);
		entity.setCreated_at(created_at);
		entity.setCreated_by_id(created_by_id);
		entity.setDue_date(due_date);
		entity.setList_id(list_id);
		entity.setRevision(revision);
		entity.setStarred(starred);
		entity.setTitle(title);
		entity.setCompleted_at(completed_at);
		entity.setCompleted_by_id(completed_by_id);
		return entity;
	}

	@Override
	protected void assertEquals(Task expected, Task actual) {
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getAssignee_id(), actual.getAssignee_id());
		Assert.assertEquals(expected.getAssigner_id(), actual.getAssigner_id());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getCreated_by_id(), actual.getCreated_by_id());
		Assert.assertEquals(expected.getDue_date(), actual.getDue_date());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.isStarred(), actual.isStarred());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getCompleted_at(), actual.getCompleted_at());
		Assert.assertEquals(expected.getCompleted_by_id(), actual.getCompleted_by_id());
	}

}
