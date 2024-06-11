package com.jsp.shoppingcart.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double totalprice;

	@OneToMany
	@Cascade(CascadeType.MERGE)
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

}
