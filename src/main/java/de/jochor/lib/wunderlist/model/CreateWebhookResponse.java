package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
 *
 * @author Jochen Hormes
 *
 */
@Getter
@Setter
public class CreateWebhookResponse {

	private int id;

	private int created_by_id;

	private String processor_type;

	private String url;

	private String created_at;

	private String configuration;

}
