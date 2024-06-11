package com.jsp.shoppingcart.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private long mobilenumber;
	@Column(unique = false)
	private String email;
	private String password;

	@OneToMany
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> product) {
		this.products = product;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
