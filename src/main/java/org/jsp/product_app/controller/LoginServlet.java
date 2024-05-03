package org.jsp.product_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.product_app.dao.UserDao;
import org.jsp.product_app.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		UserDao dao = new UserDao();
		User user = dao.verifyUser(phone, password);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
