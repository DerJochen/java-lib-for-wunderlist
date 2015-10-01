package de.jochor.lib.wunderlist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * json<br>
 * {<br>
 * "clientId": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"<br>
 * "clientSecrete": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"<br>
 * "code": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"<br>
 * }
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
