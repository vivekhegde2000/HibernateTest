package org.jsp.merchantproduct;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchProductsByMerchantsId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Merchants ID to fetch Products");
		int id = sc.nextInt();
		String qry = "select merchant.products from Merchant merchant where merchant.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Product> products = q.getResultList();
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("Product Id : " + p.getId());
				System.out.println("Product Name : " + p.getName());
				System.out.println("Product Brand : " + p.getBrand());
				System.out.println("Product Description : " + p.getDescription());
				System.out.println("Product Category : " + p.getCategory());
				System.out.println("Product Cost : " + p.getCost());
				System.out.println("Product Merchant : " + p.getMerchant());
			}
		} else {
			System.out.println("No Products Found for Entered Merchant ID");
		}
	}

}
