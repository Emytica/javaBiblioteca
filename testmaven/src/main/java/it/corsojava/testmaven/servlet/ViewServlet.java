package it.corsojava.testmaven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import it.corsojava.testmaven.dao.LibriDao;
import it.corsojava.testmaven.vo.LibriVo;

//@WebServlet("/ViewServlet")
@WebServlet(value = { "/ViewServlet","/logout" })
public class ViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessione = req.getSession(false);
		if (sessione != null) {
			sessione.removeAttribute("utenteLoggato");
			sessione.invalidate();
		}
		req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LibriDao libroDao = new LibriDao();
		LibriVo libro = new LibriVo();
		HttpSession sessione = req.getSession();

		String nome = req.getParameter("nome");
		String autore = req.getParameter("autore");
		String isbn = req.getParameter("isbn");
		String disponibilita = req.getParameter("disp");

		libro.setNome(nome);
		libro.setAutore(autore);
		libro.setDisponibilita(disponibilita);
		libro.setIsbn(isbn);

		libroDao.insertLibro(libro);

		req.setAttribute("libro", libro);

		req.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);

	}

}
