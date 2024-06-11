package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.ItemDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ItemController {
	@Autowired
	ItemDao idao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("/addtocart")
	public ModelAndView addItemToCart(@RequestParam("id") int id) {
		
		Product p = pdao.findProductById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("prodobj", p);
		mv.setViewName("ItemForm");
		return mv;
	}
	
	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(ServletRequest request,HttpSession session) {
		int pid = Integer.parseInt(request.getParameter("id"));
		String brand = request.getParameter("brand");
		double price = Double.parseDouble(request.getParameter("price"));
		String model = request.getParameter("model");
		String category = request.getParameter("category");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Item item = new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setQuantity(quantity);
		item.setP_id(pid);
		item.setPrice(price*quantity);
		
		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart c = customer.getCart();
		
		if(c==null) {    // for save the cart
			
			Cart cart = new Cart();
			List<Item> ilist = new ArrayList<Item>();
			ilist.add(item);
			
			cart.setItems(ilist);
			cart.setName(customer.getName());
			
			
			
			cart.setTotalprice(item.getPrice());
			
			customer.setCart(cart);
			
			idao.saveItem(item);
			cdao.saveCart(cart);
			
			custdao.updateCustomer(customer);
			
		}else {    // for update the cart
			List<Item> items = c.getItems();
			if(items.size()>0) {
				items.add(item);
				c.setItems(items);
				double totalprice = 0;
				for(Item i : items) totalprice = totalprice+i.getPrice();
				c.setTotalprice(totalprice);
				customer.setCart(c);
				
				idao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
				
			}else {
				List<Item> itemslist = new ArrayList<Item>();
				itemslist.add(item);
				c.setItems(itemslist);
				c.setTotalprice(item.getPrice());
				
				idao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect://displayproducts");
		return mv;
	}
	
}
