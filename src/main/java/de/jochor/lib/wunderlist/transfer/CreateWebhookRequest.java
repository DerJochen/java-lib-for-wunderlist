package de.jochor.lib.wunderlist.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Java representation of a JSON object encapsulating a "create webhook" request.
 * 
 * <pre>
 * <code>json
 * {
 *   "list_id": 105743947,
 *   "url":"https://foo.bar.chadfowler.com/struts/asdf.do",
 *   "processor_type":"generic",
 *   "configuration":""}
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
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateWebhookRequest {

	private final int list_id;

	private final String url;

	private final String processor_type;

	private String configuration = "";

}
