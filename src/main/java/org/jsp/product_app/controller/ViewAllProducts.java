package org.jsp.product_app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.product_app.dao.ProductDao;
import org.jsp.product_app.dto.Product;
@WebServlet("/view")
public class ViewAllProducts extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int user_id=Integer.parseInt(req.getParameter("user_id"));
	ProductDao dao=new ProductDao();
	List<Product> products=dao.getProductsByUserId(user_id);
	req.setAttribute("products", products);
	RequestDispatcher dispatcher=req.getRequestDispatcher("view.jsp");
	dispatcher.forward(req, resp);
}
}
