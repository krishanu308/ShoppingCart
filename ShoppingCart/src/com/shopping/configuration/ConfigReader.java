package com.shopping.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ConfigReader {

	private static ConfigReader single_instance = null; 
	private Properties prop = null;
	
	private ConfigReader() {
		prop = new Properties();
	}
	
	public static ConfigReader getInstance() {
		if(single_instance == null) {
			single_instance = new ConfigReader();
		}
		return single_instance;
	}
	
	public Properties getProperty(String filename) {
		InputStream fis = this.getClass().getResourceAsStream("/resources/" + filename);
		try {
			if (fis != null) {
				prop.load(fis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	public void getLogger() {
		try {
			prop.load(this.getClass().getResourceAsStream("/resources/log4j/log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(prop);
	}
}
