package de.jochor.lib.wunderlist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateWebhookRequest {

	private final int list_id;

	private final String url;

	private final String processor_type;

	private String configuration = "";

}
