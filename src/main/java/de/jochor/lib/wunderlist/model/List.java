package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Java representation of a JSON object encapsulating a list.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 83526310,
 *   "title": "Read Later",
 *   "owner_type":"user",
 *   "owner_id":1235616,
 *   "list_type": "list",
 *   "public" : false,
 *   "revision": 10,
 *   "created_at": "2013-08-30T08:29:46.203Z",
 *   "created_by_request_id" : "498d3ffc44ddfa2f275b:0fc81b85-31e0-4d09-b3f4-6af222...",
 *   "type": "list"
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
@ToString(of = { "id", "title" })
public class List {

	private int id;

	private String title;

	private String owner_type;

	private int owner_id;

	private String list_type;

	// upper case since 'public' is a key word
	private boolean Public;

	private int revision;

	private String created_at;

	private String created_by_request_id;

	private String type;

}
