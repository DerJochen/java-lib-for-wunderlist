package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * {<br>
 * "id": 409233670,<br>
 * "assignee_id": 12345,<br>
 * "assigner_id": 5432,<br>
 * "created_at": "2013-08-30T08:36:13.273Z",<br>
 * "created_by_id": 6234958,<br>
 * "due_date": "2013-08-30",<br>
 * "list_id": 123,<br>
 * "revision": 1,<br>
 * "starred": true,<br>
 * "title": "Hello"<br>
 * "completed_at": "2013-08-30T08:36:13.273Z",<br>
 * "completed_by_id": 123<br>
 * }<br>
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
