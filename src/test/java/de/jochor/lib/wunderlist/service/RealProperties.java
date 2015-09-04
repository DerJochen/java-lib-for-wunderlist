package de.jochor.lib.wunderlist.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Jochen Hormes
 * @start 2015-09-04
 *
 */
public class RealProperties {

	private static final Path propertiesFile = Paths.get("src/test/resources/real.properties");

	public static Properties getRealProperties() {
		if (!Files.exists(propertiesFile)) {
			return null;
		}

		try {
			Properties realProperties = new Properties();
			realProperties.load(new FileInputStream(propertiesFile.toFile()));

			return realProperties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
