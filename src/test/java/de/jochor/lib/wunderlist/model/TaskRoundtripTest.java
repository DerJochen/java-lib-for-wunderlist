package de.jochor.lib.wunderlist.model;

import org.junit.Assert;

import de.jochor.lib.wunderlist.AbstractRoundtripTest;

/**
 * Round-trip test for a {@link Task}.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 409233670,
 *   "assignee_id": 12345,
 *   "assigner_id": 5432,
 *   "created_at": "2013-08-30T08:36:13.273Z",
 *   "created_by_id": 6234958,
 *   "created_by_request_id": "498d3ffc44ddfa2f275b:0f...",
 *   "due_date": "2013-08-30",
 *   "list_id": 123,
 *   "recurrence_type": "month",
 *   "recurrence_count": 1,
 *   "revision": 1,
 *   "starred": true,
 *   "title": "Hello",
 *   "type": "task",
 *   "completed": false,
 *   "completed_at":"2013-08-30T08:36:13.273Z",
 *   "completed_by_id": 123
 * }</code>
 * </pre>
 *
 * <p>
 * <b>Started:</b> 2015-10-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class TaskRoundtripTest extends AbstractRoundtripTest<Task> {

	private static final int id = 62;
	private static final int assignee_id = 85893;
	private static final int assigner_id = 28758;
	private static final String created_at = "2015-03-03T15:32:09.272Z";
	private static final int created_by_id = 828986;
	private static final String created_by_request_id = "498d3ffc44ddfa2f275b:0f...";
	private static final String due_date = "2015-03-05T15:32:09.272Z";
	private static final int list_id = 105743947;
	private static final String recurrence_type = "month";
	private static final int recurrence_count = 1;
	private static final int revision = 2;
	private static final boolean starred = false;
	private static final String title = "Test Task";
	private static final String type = "task";
	private static final boolean completed = false;
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
		entity.setCreated_by_request_id(created_by_request_id);
		entity.setDue_date(due_date);
		entity.setList_id(list_id);
		entity.setRecurrence_type(recurrence_type);
		entity.setRecurrence_count(recurrence_count);
		entity.setRevision(revision);
		entity.setStarred(starred);
		entity.setTitle(title);
		entity.setType(type);
		entity.setCompleted(completed);
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
		Assert.assertEquals(expected.getCreated_by_request_id(), actual.getCreated_by_request_id());
		Assert.assertEquals(expected.getDue_date(), actual.getDue_date());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertEquals(expected.getRecurrence_type(), actual.getRecurrence_type());
		Assert.assertEquals(expected.getRecurrence_count(), actual.getRecurrence_count());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.isStarred(), actual.isStarred());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertEquals(expected.isCompleted(), actual.isCompleted());
		Assert.assertEquals(expected.getCompleted_at(), actual.getCompleted_at());
		Assert.assertEquals(expected.getCompleted_by_id(), actual.getCompleted_by_id());
	}

}
