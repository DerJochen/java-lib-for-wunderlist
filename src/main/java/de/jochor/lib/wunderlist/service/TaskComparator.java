package de.jochor.lib.wunderlist.service;

import java.util.Comparator;

import lombok.RequiredArgsConstructor;
import de.jochor.lib.wunderlist.model.Positions;
import de.jochor.lib.wunderlist.model.Task;

/**
 * Comparator for {@link Task}s. Compares the {@link Task}s based on an array with {@link Task} IDs.
 *
 * <p>
 * <b>Started:</b> 2015-11-05
 * </p>
 *
 * @author Jochen Hormes
 *
 */
@RequiredArgsConstructor
public class TaskComparator implements Comparator<Task> {

	private final Positions taskPositions;

	@Override
	public int compare(Task task1, Task task2) {
		int id1 = task1.getId();
		int id2 = task2.getId();
		int[] values = taskPositions.getValues();

		for (int id : values) {
			if (id == id1) {
				return -1;
			}
			if (id == id2) {
				return 1;
			}
		}

		return 0;
	}

}