package com.prerak.automation.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	static Properties prop;
	
	public ReadPropertiesFile(String path) throws IOException {

		prop = new Properties();
		InputStream input = null;

		input = new FileInputStream(path);

		prop.load(input);

	}
	
	public String getProperty(String key) throws IOException {

		String value = null;
		try {
			value = prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}
}
