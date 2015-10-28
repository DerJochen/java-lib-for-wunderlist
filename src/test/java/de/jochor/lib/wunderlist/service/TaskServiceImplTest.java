package de.jochor.lib.wunderlist.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.http4j.junit.HTTPClientJUnit;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Test for the {@link TaskServiceImpl}.
 *
 * <p>
 * <b>Started:</b> 2015-10-27
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class TaskServiceImplTest extends AbstractRESTClientServiceTest {

	private static final int assignee_id = 5461;
	private static final int assigner_id = 86484;
	private static final String completed_at = "2013-10-29T08:29:46.203Z";
	private static final int completed_by_id = 68496;
	private static final String created_at = "2013-10-27T08:29:46.203Z";
	private static final int created_by_id = 57584;
	private static final String due_date = "2013-10-28T08:29:46.203Z";
	private static final int id = 648931;
	private static final int list_id = 384169;
	private static final int revision = 2;
	private static final String title = "Test Task ";

	private TaskServiceImpl taskService;

	@Before
	public void setUp() throws Exception {
		taskService = new TaskServiceImpl();
	}

	@Test
	public void testRetrieveAll_noTasks() {
		String json = "[]";
		HTTPClientJUnit.addResponse(json, "list_id=1");

		Task[] tasksForList = taskService.retrieveAll(1, AUTHORIZATION);
		Assert.assertNotNull(tasksForList);
		Assert.assertEquals(0, tasksForList.length);
	}

	@Test
	public void testRetrieveAll_withTasks() {
		Task[] tasks = createTasks(5, false);
		String json = jsonEntityService.toJSON(tasks);
		HTTPClientJUnit.addResponse(json, "list_id=4");

		Task[] tasksForList = taskService.retrieveAll(4, AUTHORIZATION);
		Assert.assertNotNull(tasksForList);
		Assert.assertEquals(tasks.length, tasksForList.length);
		for (int i = 0; i < tasks.length; i++) {
			assertEquals(tasks[i], tasksForList[i]);
		}
	}

	@Test
	public void testRetrieveAllCompleted() {
		Task[] tasks = createTasks(3, true);
		String json = jsonEntityService.toJSON(tasks);
		HTTPClientJUnit.addResponse(json, "list_id=7", "completed=true");

		Task[] tasksForList = taskService.retrieveAllCompleted(7, AUTHORIZATION);
		Assert.assertNotNull(tasksForList);
		Assert.assertEquals(tasks.length, tasksForList.length);
		for (int i = 0; i < tasks.length; i++) {
			assertEquals(tasks[i], tasksForList[i]);
		}
	}

	@Test
	public void testRetrieve() {
		Task[] tasks = createTasks(1, true);
		String json = jsonEntityService.toJSON(tasks[0]);
		HTTPClientJUnit.addResponse(json);

		Task task = taskService.retrieve(id, AUTHORIZATION);
		Assert.assertNotNull(task);
		assertEquals(tasks[0], task);
	}

	private Task[] createTasks(int count, boolean completed) {
		Task[] tasks = new Task[count];

		for (int i = 0; i < count; i++) {
			Task task = new Task();

			task.setAssignee_id(assignee_id + i);
			task.setAssigner_id(assigner_id + i);
			if (completed) {
				task.setCompleted_at(completed_at + i);
				task.setCompleted_by_id(completed_by_id);
			}
			task.setCreated_at(created_at);
			task.setCreated_by_id(created_by_id + i);
			task.setDue_date(due_date);
			task.setId(id + i);
			task.setList_id(list_id + i);
			task.setRevision(revision + i);
			task.setStarred(i % 2 == 0);
			task.setTitle(title + i);

			tasks[i] = task;
		}

		return tasks;
	}

	private void assertEquals(Task expected, Task actual) {
		if (expected == null) {
			Assert.assertNull(actual);
			return;
		}

		Assert.assertNotNull(actual);
		Assert.assertEquals(expected.getAssignee_id(), actual.getAssignee_id());
		Assert.assertEquals(expected.getAssigner_id(), actual.getAssigner_id());
		Assert.assertEquals(expected.getCompleted_at(), actual.getCompleted_at());
		Assert.assertEquals(expected.getCompleted_by_id(), actual.getCompleted_by_id());
		Assert.assertEquals(expected.getCreated_at(), actual.getCreated_at());
		Assert.assertEquals(expected.getCreated_by_id(), actual.getCreated_by_id());
		Assert.assertEquals(expected.getDue_date(), actual.getDue_date());
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getList_id(), actual.getList_id());
		Assert.assertEquals(expected.getRevision(), actual.getRevision());
		Assert.assertEquals(expected.isStarred(), actual.isStarred());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
	}

}
