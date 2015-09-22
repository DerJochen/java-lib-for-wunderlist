package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "access_token": "976d16a81ccf621a654fcc23193b09498b220e89eb72ced3"<br>
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
public class RetrieveAccessTokenResponse {

	private String access_token;

}
