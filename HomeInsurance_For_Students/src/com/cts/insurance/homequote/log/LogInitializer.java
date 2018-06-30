/**
 * LogInitializer
 * Class for logging
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class LogInitializer extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant LOG. */
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(LogInitializer.class);

	/**
	 * ServletConfig - servlet config object.
	 *
	 * @param config the config
	 * @throws ServletException the servlet exception
	 */
	public void init(final ServletConfig config)
			throws ServletException {
		final String realPath = config.getServletContext()
				.getRealPath("/");
		final String log4jFile = realPath+"/WEB-INF/log4j.properties";
		PropertyConfigurator.configure(log4jFile);
		LOG.info("Application Initialized");
	}
}
