package de.jochor.lib.wunderlist.service;

/**
 * Exception thrown during the initialization phase.
 *
 * <p>
 * <b>Started:</b> 2015-11-22
 * </p>
 *
 * @author Jochen Hormes
 */
public class InitException extends RuntimeException {

	private static final long serialVersionUID = -8606713031073763354L;

	/**
	 * Creates a new {@link InitException}.
	 *
	 * @param e
	 *            Parent exception
	 */
	public InitException(Exception e) {
		super(e);
	}

}
