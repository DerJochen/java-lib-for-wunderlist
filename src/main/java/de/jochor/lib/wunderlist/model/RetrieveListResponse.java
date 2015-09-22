package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 83526310,<br>
 * "created_at": "2013-08-30T08:29:46.203Z",<br>
 * "title": "Read Later",<br>
 * "list_type": "list",<br>
 * "type": "list",<br>
 * "revision": 10<br>
 * }
 *
 * <p>
 * <b>Started:</b> 2015-08-19
 * </p>
 * 
 * @author Jochen
 *
 */
@Getter
@Setter
public class RetrieveListResponse {

	private int id;

	private String created_at;

	private String title;

	private String list_type;

	private String type;

	private int revision;

}
