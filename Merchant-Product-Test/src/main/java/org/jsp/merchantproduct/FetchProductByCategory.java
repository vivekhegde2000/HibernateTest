package org.jsp.merchantproduct;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchProductByCategory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Category to Fetch Products");
		String category = sc.next();
		String qry = "select product from Product product where category=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, category);
		List<Product> products = q.getResultList();
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product ID : " + p.getId());
				System.out.println("Product Name : " + p.getName());
				System.out.println("Product Brand : " + p.getBrand());
				System.out.println("Product Description : " + p.getDescription());
				System.out.println("Product Category : " + p.getCategory());
			}
		} else {
			System.out.println("Products Not Found with this Category!!");
		}

	}

}
