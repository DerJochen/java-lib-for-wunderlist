package de.jochor.lib.wunderlist.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Java representation of a JSON object encapsulating a "retrieve access token" request.
 * 
 * <pre>
 * <code>json
 * {
 *   "clientId": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3",
 *   "clientSecrete": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3",
 *   "code": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"
 * }</code>
 * </pre>
 *
 * <p>
 * <b>Started:</b> 2015-10-01
 * </p>
 * 
 * @author Jochen Hormes
 *
 */
@Getter
@AllArgsConstructor
public class RetrieveAccessTokenRequest {

	private String clientId;

	private String clientSecrete;

	private String code;

}
