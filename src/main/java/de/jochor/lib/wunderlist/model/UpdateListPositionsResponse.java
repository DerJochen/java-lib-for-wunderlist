package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 34234234,<br>
 * "values": [123, 234, 345, 456, 321],<br>
 * "revision": 124,<br>
 * "list_id": 34234234,<br>
 * "type": "task_position"<br>
 * }
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 * @author Jochen Hormes
 *
 */
@Getter
@Setter
public class UpdateListPositionsResponse extends RetrieveListPositionsResponse {

	private int list_id;

}
