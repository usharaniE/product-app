package org.jsp.product_app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.product_app.dao.ProductDao;
import org.jsp.product_app.dto.Product;

@WebServlet("/saveProduct")
public class SaveProduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		String name = req.getParameter("name");
		double cost = Double.parseDouble(req.getParameter("cost"));
		String type = req.getParameter("type");
		Product product = new Product();
		product.setCost(cost);
		product.setType(type);
		product.setName(name);
		ProductDao dao = new ProductDao();
		product = dao.saveProduct(product, user_id);
	}
}
