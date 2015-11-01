package de.jochor.lib.wunderlist.transfer;

import lombok.Getter;
import lombok.Setter;

/**
 * Java representation of a JSON object encapsulating a "retrieve access token" response.
 *
 * <pre>
 * <code>json
 * {
 *   "access_token": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"
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
public class RetrieveAccessTokenResponse {

	private String access_token;

}
