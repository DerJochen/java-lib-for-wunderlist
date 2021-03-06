package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
 *   "created_by_request_id": "498d3ffc44ddfa2f275b:0f...",
 *   "due_date": "2013-08-30",
 *   "list_id": 123,
 *   "recurrence_type": "month",
 *   "recurrence_count": 1,
 *   "revision": 1,
 *   "starred": true,
 *   "title": "Hello",
 *   "type": "task",
 *   "completed": false,
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
@ToString(of = { "id", "title" })
public class Task {

	private int id;

	private int assignee_id;

	private int assigner_id;

	private String created_at;

	private int created_by_id;

	private String created_by_request_id;

	private boolean completed;

	private String due_date;

	private int list_id;

	private String recurrence_type;

	private int recurrence_count;

	private int revision;

	private boolean starred;

	private String title;

	private String type;

	private String completed_at;

	private int completed_by_id;

}
