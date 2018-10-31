package it.corsojava.testmaven.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.corsojava.testmaven.dao.LibriDao;
import it.corsojava.testmaven.dao.RentBookDao;
import it.corsojava.testmaven.vo.LibriVo;
import it.corsojava.testmaven.vo.UtenteVo;

@WebServlet(value = { "/noleggio", "/out" })
public class RentBook extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessione = req.getSession(false);
		String path = req.getServletPath();
		String out = "";
		UtenteVo user = (UtenteVo) sessione.getAttribute("utenteLogato");
		String idlibro=req.getParameter("id");
		sessione.getAttribute("utenteLoggato");
		LibriDao lib = new LibriDao();
		List<LibriVo> libro = lib.sfogliaLibri();
		req.setAttribute("libri", libro);
		RentBookDao daoBook = new RentBookDao();
		
//		if ("/out".equals(path)) {
//			daoBook.initDbNoleggio(user, libro);
//		}

		return "/noleggio.jsp";
	}

}
