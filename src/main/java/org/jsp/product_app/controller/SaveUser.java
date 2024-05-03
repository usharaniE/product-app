package org.jsp.product_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.product_app.dao.UserDao;
import org.jsp.product_app.dto.User;

@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("phone"));
		User user = new User();
		user.setAge(age);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);

		UserDao dao = new UserDao();
		dao.saveUser(user);
	}
}
