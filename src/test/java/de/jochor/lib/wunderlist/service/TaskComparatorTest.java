package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.wunderlist.model.Positions;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Test for the {@link TaskComparator}.
 *
 * <p>
 * <b>Started:</b> 2015-11-06
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class TaskComparatorTest {

	private static final int[] order1 = { 8, 6, 7, 2, 1, 4 };

	private static final int[] order2 = { 1, 8, 4, 2, 6, 7 };

	private TaskComparator taskComparator1;

	private TaskComparator taskComparator2;

	@Before
	public void setUp() throws Exception {
		Positions taskPositions = new Positions();
		taskPositions.setValues(order1);
		taskComparator1 = new TaskComparator(taskPositions);

		taskPositions = new Positions();
		taskPositions.setValues(order2);
		taskComparator2 = new TaskComparator(taskPositions);
	}

	@Test
	public void testCompare() {
		Task[] tasks = createTasks(order1);
		checkTasks(tasks, order1);

		Arrays.sort(tasks, taskComparator2);
		checkTasks(tasks, order2);

		Arrays.sort(tasks, taskComparator1);
		checkTasks(tasks, order1);
	}

	private Task[] createTasks(int[] order) {
		Task[] tasks = new Task[order.length];

		for (int i = 0; i < order.length; i++) {
			Task task = new Task();
			task.setId(order[i]);
			tasks[i] = task;
		}

		return tasks;
	}

	private void checkTasks(Task[] tasks, int[] order) {
		for (int i = 0; i < order.length; i++) {
			Assert.assertEquals(order[i], tasks[i].getId());
		}
	}

}
