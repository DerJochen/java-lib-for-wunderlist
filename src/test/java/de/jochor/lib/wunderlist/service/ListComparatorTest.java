package de.jochor.lib.wunderlist.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.jochor.lib.wunderlist.model.List;
import de.jochor.lib.wunderlist.model.Positions;

/**
 * Test for the {@link ListComparator}.
 *
 * <p>
 * <b>Started:</b> 2015-11-06
 * </p>
 *
 * @author Jochen Hormes
 *
 */
public class ListComparatorTest {

	private static final int[] order1 = { 8, 6, 7, 2, 1, 4 };

	private static final int[] order2 = { 1, 8, 4, 2, 6, 7 };

	private ListComparator listComparator1;

	private ListComparator listComparator2;

	@Before
	public void setUp() throws Exception {
		Positions listPositions = new Positions();
		listPositions.setValues(order1);
		listComparator1 = new ListComparator(listPositions);

		listPositions = new Positions();
		listPositions.setValues(order2);
		listComparator2 = new ListComparator(listPositions);
	}

	@Test
	public void testCompare() {
		List[] lists = createLists(order1);
		checkLists(lists, order1);

		Arrays.sort(lists, listComparator2);
		checkLists(lists, order2);

		Arrays.sort(lists, listComparator1);
		checkLists(lists, order1);
	}

	private List[] createLists(int[] order) {
		List[] lists = new List[order.length];

		for (int i = 0; i < order.length; i++) {
			List list = new List();
			list.setId(order[i]);
			lists[i] = list;
		}

		return lists;
	}

	private void checkLists(List[] lists, int[] order) {
		for (int i = 0; i < order.length; i++) {
			Assert.assertEquals(order[i], lists[i].getId());
		}
	}

}
