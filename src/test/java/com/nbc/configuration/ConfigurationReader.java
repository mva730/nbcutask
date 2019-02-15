package com.nbc.configuration;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationReader {
	private static Configuration configuration;

	public static Configuration get() {
		if (configuration == null) {
			configuration = ConfigFactory.create(Configuration.class);
		}
		return configuration;
	}
}