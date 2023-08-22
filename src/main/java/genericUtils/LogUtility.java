package genericUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class LogUtility {
	
	/*
	 * log utility for generating logs
	 */
	
	Logger logger = LogManager.getLogger(LogUtility.class);

	public void info(String message) {
		logger.info(message);
	}
	public void error(String message) {
		logger.error(message);
	}

	public void trace(String message) {
		logger.trace(message);
	}

	public void warn(String message) {
		logger.warn(message);
	}
}
