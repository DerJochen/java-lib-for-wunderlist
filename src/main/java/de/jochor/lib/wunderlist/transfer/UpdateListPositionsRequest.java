package de.jochor.lib.wunderlist.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Java representation of a JSON object encapsulating a "update list positions" request.
 * 
 * <pre>
 * <code>json
 * {
 * "values": [4567, 4568, 9876, 234],
 * "revision": 123
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
@AllArgsConstructor
public class UpdateListPositionsRequest {

	private int[] values;

	private int revision;

}
