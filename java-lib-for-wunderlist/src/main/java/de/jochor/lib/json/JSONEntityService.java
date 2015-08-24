package de.jochor.lib.json;

/**
 *
 * @author Jochen Hormes
 * @start 2015-08-24
 *
 */
public interface JSONEntityService {

	<T>T toEntity(String json, Class<T> entityType);

	String toJSON(Object entity);

}