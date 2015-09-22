package de.jochor.lib.wunderlist.model;

import lombok.Getter;
import lombok.Setter;

/**
 * json<br>
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
public class CreateWebhookResponse {

	private int id;

	private int created_by_id;

	private String processor_type;

	private String url;

	private String created_at;

	private String configuration;

}
