package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 131232,<br>
 * "values": [123, 234, 345, 456],<br>
 * "revision": 1,<br>
 * "type": "list_position"<br>
 * }
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 *
 * @author Jochen Hormes
 *
 */
@Getter
@Setter
public class RetrieveListPositionsResponse {

	private int id;

	private int revision;

	private String type;

	private int[] values;

}
