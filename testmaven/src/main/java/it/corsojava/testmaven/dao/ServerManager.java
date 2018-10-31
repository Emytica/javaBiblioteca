package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ServerManager {

	private static ServerManager _instance;

	private String driver;
	private String url;
	private String username;
	private String password;
	private String connection;

	public ServerManager() {

	}

	public static synchronized ServerManager getInstance() {
		if (_instance == null)
			_instance = new ServerManager();
		return _instance;
	}

	public void initDatabase(String driver, String url, String username, String password, String connection)
			throws ClassNotFoundException {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.connection = connection;
		Class.forName(driver);
	}

	public Connection connection() throws SQLException {

		if (this.connection.equals("1"))

			try {
				Context context = new InitialContext();
				Context envContext = (Context) context.lookup("java:/comp/env");
				javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/opengestdb-ds");
				Connection connection = ds.getConnection();
				
				return connection;
			} catch (Exception e) {
				e.printStackTrace();
			}
		else if (this.connection.equals("0")) {
			return DriverManager.getConnection(url, username, password);
		}

		return null;

	}



}
