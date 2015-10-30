package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Java representation of a JSON object encapsulating a task.
 *
 * <pre>
 * <code>json
 * {
 *   "id": 409233670,
 *   "assignee_id": 12345,
 *   "assigner_id": 5432,
 *   "created_at": "2013-08-30T08:36:13.273Z",
 *   "created_by_id": 6234958,
 *   "due_date": "2013-08-30",
 *   "list_id": 123,
 *   "revision": 1,
 *   "starred": true,
 *   "title": "Hello",
 *   "completed_at": "2013-08-30T08:36:13.273Z",
 *   "completed_by_id": 123
 * }</code>
 * </pre>
 *
 * <p>
 * <b>Started:</b> 2015-09-23
 * </p>
 *
 * @author Jochen Hormes
 *
 */
@Getter
@Setter
public class Task {

	private int id;

	private int assignee_id;

	private int assigner_id;

	private String created_at;

	private int created_by_id;

	private String due_date;

	private int list_id;

	private int revision;

	private boolean starred;

	private String title;

	private String completed_at;

	private int completed_by_id;

}
