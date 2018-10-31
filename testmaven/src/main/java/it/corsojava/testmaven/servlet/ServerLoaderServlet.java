package it.corsojava.testmaven.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import it.corsojava.testmaven.dao.ServerManager;

public class ServerLoaderServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String driver=getInitParameter("DATABASE_DRIVER");
		String url=getInitParameter("DATABASE_URL");
		String username=getInitParameter("DATABASE_USERNAME");
		String password=getInitParameter("DATABASE_PASSWORD");
		String connection = getInitParameter("CONNECTION");
		
		try {
			ServerManager.getInstance().initDatabase(driver, url, username, password, connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
