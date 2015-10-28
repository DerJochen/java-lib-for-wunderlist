package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Java representation of a JSON object encapsulating a webhook.
 *
 * <pre>
 * <code>json
 * {
 * "id": 62,
 * "list_id": 105743947,
 * "membership_id": 49876097,
 * "membership_type": "Membership",
 * "url": "https:/yourhost.com/foo",
 * "processor_type": "generic",
 * "configuration": "",
 * "created_at": "2015-03-03T15:32:09.272Z",
 * "created_by_id": 84646989,
 * "updated_at": "2015-03-03T15:32:09.272Z"
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
