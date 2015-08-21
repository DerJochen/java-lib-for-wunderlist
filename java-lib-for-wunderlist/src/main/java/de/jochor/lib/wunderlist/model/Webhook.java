package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 * 
 * @author Jochen
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

	private String updated_at;

}
