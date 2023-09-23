package org.jsp.merchantproduct;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantByPhonePassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Merchant Phone Number to Verify");
		long phone = sc.nextLong();
		System.out.println("Enter Merchant Password");
		String password = sc.next();
		String qry = "select merchant from Merchant merchant where merchant.phone=?1 and merchant.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			Merchant merchant = (Merchant) q.getSingleResult();
			System.out.println("Merchant ID : " + merchant.getId());
			System.out.println("Merchant Name : " + merchant.getName());
			System.out.println("Merchant Phone Number : " + merchant.getPhone());
			System.out.println("Merchant Email Id : " + merchant.getEmail());
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("Invalid Phone / Password!!");
		}
	}

}
