package de.jochor.lib.wunderlist.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import de.jochor.lib.wunderlist.model.Positions;

/**
 * Java representation of a JSON object encapsulating a "update {@link Positions}" request.
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
public class UpdatePositionsRequest {

	private int[] values;

	private int revision;

}
