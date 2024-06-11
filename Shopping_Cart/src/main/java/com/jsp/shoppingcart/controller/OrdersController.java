package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.OrderDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Orders;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class OrdersController {
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	CustomerDao custdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cartdao;
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder() {
		Orders o = new Orders();
		ModelAndView mv = new ModelAndView();
		mv.addObject("orderobj", o);
		mv.setViewName("OrderForm");
		return mv;
	}
	
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("orderobj") Orders o,HttpSession session)
	{
		Customer c=(Customer)session.getAttribute("customerinfo");
		Customer customer=custdao.findCustomerById(c.getId());
		Cart  cart=customer.getCart();
		
		List<Item>items=cart.getItems();
		o.setTotalprice(cart.getTotalprice());
		
		List<Item> itemsList=new ArrayList<Item>();
		List<Item>itemswithGreaterQuantity=new ArrayList<Item>();
		for(Item i:items)
		{
			Product p=pdao.findProductById(i.getP_id());
			if(i.getQuantity()<p.getStock())
			{
				itemsList.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				
				pdao.updateProduct(p);
			}
			else
			{
				itemswithGreaterQuantity.add(i);
			}
		}
		o.setItems(itemsList);
		double totalpriceoforder=0;
		
		for(Item i:itemsList)
		{
			totalpriceoforder =totalpriceoforder+i.getPrice();
		}
		o.setTotalprice(totalpriceoforder);
		cart.setItems(itemswithGreaterQuantity);
		
		
		double totalprice=0;
		for(Item i:itemswithGreaterQuantity)
		{
			totalprice=totalprice+i.getPrice();
		}
		cart.setTotalprice(totalprice);
		List<Orders> orders=customer.getOrders();
		if(orders.size()>0)
		{
			orders.add(o);
			customer.setOrders(orders);
			
		}else {
			List<Orders>orders1=new ArrayList<Orders>();
			orders1.add(o);
			customer.setOrders(orders1);
		}
		customer.setCart(cart);
		cartdao.updateCart(cart);
		odao.saveOrders(o);
		custdao.updateCustomer(customer);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","Order Placed Sucessesfully....");
		mv.addObject("ordedetails",o);
		mv.setViewName("CustomerBill");
		
		return mv;
	}
}
