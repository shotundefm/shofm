/**
 * MySqlDAO - This DAO class is used to get MySQL DB connections
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySqlDAO extends AbstractDAOFactory
{
	/* (non-Javadoc)
	 * @see com.cts.insurance.homequote.dao.AbstractDAOFactory#getConnection()
	 */
	public Connection getConnection() throws ClassNotFoundException,
			IOException, SQLException {
		final Properties prop = new Properties();
		final InputStream inputStream = MySqlDAO.class.getClassLoader()
				.getResourceAsStream(
						"com/cts/insurance/homequote/resources/db.properties");
		prop.load(inputStream);
		Class.forName(prop.getProperty("driver"));
		final Connection connection = DriverManager.getConnection(prop.getProperty("url"), 
				prop.getProperty("user"), prop.getProperty("password"));
		return connection;
	}
}
