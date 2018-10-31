package it.corsojava.testmaven.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corsojava.testmaven.Test;
//@WebServlet("/hellowordServlet")
//@WebServlet(value= {"/ViewServlet","/test2"})
public class HelloWordServlet extends HttpServlet {
	
	private static final long serialVersionUID=4353464563456546436L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Test t=new Test();
		List<Test> lista=new ArrayList<>();
		req.setAttribute("lista", lista);
		req.setAttribute("person", t);
		lista.add(t);
		resp.getWriter().print("<html><body><h1>ciao</h1></body></html>");
		
		req.getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
