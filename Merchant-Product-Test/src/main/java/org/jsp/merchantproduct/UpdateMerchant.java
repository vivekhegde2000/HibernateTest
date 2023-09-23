package org.jsp.merchantproduct;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		System.out.println("Enter Merchant Id");
		int id = sc.nextInt();
		System.out.println("Enter Merchant Name");
		String name = sc.next();
		System.out.println("Enter Merchant Phone Number");
		long phone = sc.nextLong();
		System.out.println("Enter Merchant Email Id");
		String email = sc.next();
		System.out.println("Enter Merchant Password");
		String password = sc.next();

		Merchant merchant = new Merchant();
		merchant.setId(id);
		merchant.setName(name);
		merchant.setEmail(email);
		merchant.setPhone(phone);
		merchant.setPassword(password);

		manager.merge(merchant);
		trans.begin();
		trans.commit();
		System.out.println("Merchant is Updated / Saved with an Id : " + merchant.getId());
	}

}
