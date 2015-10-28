package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 83526310,<br>
 * "title": "Read Later",<br>
 * "owner_type":"user",<br>
 * "owner_id":1235616<br>
 * "list_type": "list",<br>
 * "public" : false,<br>
 * "revision": 10<br>
 * "created_at": "2013-08-30T08:29:46.203Z",<br>
 * "created_by_request_id" : "498d3ffc44ddfa2f275b:0fc81b85-31e0-4d09-b3f4-6af222..." ,<br>
 * "type": "list",<br>
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
public class List {

	private int id;

	private String title;

	private String owner_type;

	private int owner_id;

	private String list_type;

	private boolean Public; // upper case since 'public' is a key word

	private int revision;

	private String created_at;

	private String created_by_request_id;

	private String type;

}
