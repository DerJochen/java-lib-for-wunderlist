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
 * @author Jochen Hormes
 * @start 2015-08-19
 *
 */
@Getter
@Setter
public class RetrieveListPositionsResponse {

	private int id;

	private int[] values;

	private int revision;

	private String type;

}
