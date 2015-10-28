package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 62,<br>
 * "list_id": 105743947,<br>
 * "membership_id": 49876097,<br>
 * "membership_type": "Membership",<br>
 * "url": "https:/yourhost.com/foo",<br>
 * "processor_type": "generic",<br>
 * "configuration": "",<br>
 * "created_at": "2015-03-03T15:32:09.272Z",<br>
 * "updated_at": "2015-03-03T15:32:09.272Z"<br>
 * }<br>
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
public class Webhook {

	private int id;

	private int list_id;

	private int membership_id;

	private String membership_type;

	private String url;

	private String processor_type;

	private String configuration;

	private String created_at;

	private int created_by_id;

	private String updated_at;

}
