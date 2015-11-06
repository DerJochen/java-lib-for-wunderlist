package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Java representation of a JSON object encapsulating positions for {@link List}s or {@link Task}s.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 131232,
 *   "values": [123, 234, 345, 456],
 *   "revision": 1,
 *   "type": "list_position",
 *   "user_id": 43987865,
 *   "list_id": 326765049
 * }</code>
 * </pre>
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
public class Positions {

	private int id;

	private int revision;

	private String type;

	private int[] values;

	private int user_id;

	private int list_id;

}
