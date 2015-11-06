package de.jochor.lib.wunderlist.service;

import java.util.Comparator;

import lombok.RequiredArgsConstructor;
import de.jochor.lib.wunderlist.model.List;
import de.jochor.lib.wunderlist.model.Positions;

/**
 * Comparator for {@link List}s. Compares the {@link List}s based on an array with {@link List} IDs.
 *
 * <p>
 * <b>Started:</b> 2015-11-05
 * </p>
 *
 * @author Jochen Hormes
 *
 */
@RequiredArgsConstructor
public class ListComparator implements Comparator<List> {

	private final Positions listPositions;

	@Override
	public int compare(List list1, List list2) {
		int id1 = list1.getId();
		int id2 = list2.getId();
		int[] values = listPositions.getValues();

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