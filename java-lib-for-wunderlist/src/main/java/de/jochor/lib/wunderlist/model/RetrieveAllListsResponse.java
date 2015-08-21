package de.jochor.lib.wunderlist.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * [<br>
 * {<br>
 * "id": 83526310,<br>
 * "created_at": "2013-08-30T08:29:46.203Z",<br>
 * "title": "Read Later",<br>
 * "list_type": "list",<br>
 * "type": "list",<br>
 * "revision": 10 <br>
 * }<br>
 * ]
 *
 * @author Jochen Hormes
 * @start 2015-08-19
 *
 */
@Getter
public class RetrieveAllListsResponse {
	
	@Getter
	@Setter
	public static class List {

		private int id;

		private String created_at;

		private String title;

		private String list_type;

		private String type;

		private int revision;
		
	}
	
	private final ArrayList<List> lists = new ArrayList<>();

}
