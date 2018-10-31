package it.corsojava.testmaven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.corsojava.testmaven.dao.SecurityDao;
import it.corsojava.testmaven.vo.UtenteVo;

@WebServlet("/login")
public class UtenteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessione = req.getSession(false);

		sessione.getAttribute("utenteLoggato");
		req.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String outPath = "";

		SecurityDao login = new SecurityDao();
		UtenteVo utente = new UtenteVo();
		HttpSession sessione = req.getSession();
		utente = login.autenticationUsernameAndPassword(username, password);
		if (utente == null)
			outPath = "index.jsp";
		else if (utente != null && path.equals("/login"))
			outPath = "home.jsp";

		sessione.setAttribute("utenteLoggato", utente);

		req.getRequestDispatcher(outPath).forward(req, resp);

	}

}
