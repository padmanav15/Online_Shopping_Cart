package com.jsp.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Repository
public class MerchantDao {

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	ProductDao pdao;

	public void saveMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(merchant);
		et.commit();

	}

	public Merchant login(String email, String password) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select a from Merchant a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {
			Merchant merchant = (Merchant) query.getSingleResult();
			return merchant;
		} catch (Exception e) {
			return null;
		}

	}

	public void updateMerchant(Merchant m) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(m);
		et.commit();
	}

	public void deleteMerchant(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Merchant m = em.find(Merchant.class, id);
		et.begin();
		em.remove(m);
		et.commit();
	}

	public Merchant findMerchantById(int id) {
		EntityManager em = emf.createEntityManager();

		Merchant m = em.find(Merchant.class, id);

		if (m != null) {
			return m;
		} else {
			return null;

		}

	}

	public Merchant deleteProductFromMerchant(int merchant_id, int product_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Merchant m = em.find(Merchant.class, merchant_id);
		List<Product> products = m.getProducts();
//		products.stream().filter(product->product.getId()!=product_id).collect(Collectors.toList()); or -->

		List<Product> plist = new ArrayList<>();
		
		for (Product p : products) {
			if (p.getId() != product_id) {
				plist.add(p);
			}
		}

		m.setProducts(plist);
		return m;
	}

}
