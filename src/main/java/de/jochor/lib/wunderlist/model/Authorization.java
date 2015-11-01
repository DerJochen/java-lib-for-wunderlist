package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Holds all security elements this library need to access the Wunderlist REST API.
 *
 * <p>
 * <b>Started:</b> 2015-09-22
 * </p>
 *
 * @author Jochen Hormes
 *
 */
@Getter
@Setter
public class Authorization {

	private String clientId;

	private String userToken;

}
