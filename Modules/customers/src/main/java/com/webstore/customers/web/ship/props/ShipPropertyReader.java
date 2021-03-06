package com.webstore.customers.web.ship.props;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ShipPropertyReader {

	public Properties getShipPropsObj() {
		InputStream inputStream = null;
		String propFileName = "ship.props";
		try {
			Properties props = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				props.load(inputStream);
				return props;
			} 
		} catch (Exception exception) {
			try {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			} catch (FileNotFoundException fileNotFound) {
				fileNotFound.printStackTrace();
			}
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception inputStreamException) {
					inputStreamException.printStackTrace();
				}
			}
		}
		return null;
	}
}
