package de.jochor.lib.wunderlist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * json<br>
 * {<br>
 * "values": [4567, 4568, 9876, 234],<br>
 * "revision": 123<br>
 * }
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 * @author Jochen Hormes
 *
 */
@Getter
@AllArgsConstructor
public class UpdateListPositionsRequest {

	private int[] values;

	private int revision;

}