package org.jsp.merchantproduct;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		System.out.println("Enter Product Name");
		String name = sc.next();
		System.out.println("Enter Product Brand");
		String brand = sc.next();
		System.out.println("Enter Product Description");
		String description = sc.next();
		System.out.println("Enter Product Category");
		String category = sc.next();
		System.out.println("Enter Product Cost");
		double cost = sc.nextDouble();

		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setDescription(description);
		product.setCategory(category);
		product.setCost(cost);

		System.out.println("Enter Merchant Id");
		int mid = sc.nextInt();

		Merchant merchant = manager.find(Merchant.class, mid);
		if (merchant != null) {
			product.setMerchant(merchant);
			manager.merge(product);
			trans.begin();
			trans.commit();
			System.out.println("Product has been Added / Updated with an Id : " + product.getId());
		} else {
			Merchant m = new Merchant();
			System.out.println("Enter Merchant Name");
			String mname = sc.next();
			System.out.println("Enter Merchant Phone Number");
			long mphone = sc.nextLong();
			System.out.println("Enter Merchant Email Id");
			String memail = sc.next();
			System.out.println("Enter Merchant Password");
			String mpassword = sc.next();
			m.setName(mname);
			m.setEmail(memail);
			m.setPhone(mphone);
			m.setPassword(mpassword);
			product.setMerchant(m);
			manager.merge(product);
			trans.begin();
			trans.commit();
			System.out.println("Product has been Updated with an Id : " + product.getId());
		}

	}

}
