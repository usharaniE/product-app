package org.jsp.product_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.product_app.dto.Product;
import org.jsp.product_app.dto.User;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Product saveProduct(Product product, int user_id) {
		User user = entityManager.find(User.class, user_id);
		if (user != null) {
			user.getProducts().add(product);
			product.setUser(user);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(product);
			entityManager.merge(user);
			entityTransaction.commit();
			return product;
		}
		return null;
	}

	public Product updateProduct(Product product, int user_id) {
		User user = entityManager.find(User.class, user_id);
		if (user != null) {
			user.getProducts().add(product);
			product.setUser(user);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(product);
			entityManager.merge(user);
			entityTransaction.commit();
			return product;
		}
		return null;
	}

	public List<Product> getProductsByUserId(int user_id) {
		User user = entityManager.find(User.class, user_id);
		return user.getProducts();
	}
}
