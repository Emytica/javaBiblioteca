package it.corsojava.testmaven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String outPath = null;
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("utenteLoggato") == null)
			outPath = "/login.jsp";
		else
			outPath = execute(req, resp);

		getServletContext().getRequestDispatcher(outPath).forward(req, resp);

	}

	protected abstract String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

	protected HttpSession getCurrentSession(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null)
			return session;
		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
		return null;
	}

}
