package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "values": [4567, 4568, 9876, 234],<br>
 * "revision": 123<br>
 * }
 *
 * @author Jochen Hormes
 * @start 2015-08-19
 *
 */
@Getter
@Setter
public class UpdateListPositionsRequest {

	private int[] values;

	private int revision;

}