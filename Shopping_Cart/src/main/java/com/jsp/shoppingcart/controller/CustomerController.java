package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dto.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao cdao;

	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
		Customer c = new Customer();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerobj", c);
		mv.setViewName("CustomerForm");

		return mv;
	}

	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c) {
		cdao.saveCustomer(c);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Customer Added Success...");
		mv.setViewName("CustomerMenu");
		return mv;
	}

	@RequestMapping("/customerloginvalidation")
	public ModelAndView customerlogin(ServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		ModelAndView mv = new ModelAndView();
		Customer c = cdao.login(email, password);
		if (c != null) {
			mv.addObject("msg1", "Login Successfull...");
			mv.setViewName("CustomerOption");
			session.setAttribute("customerinfo", c);
			return mv;
		} else {
			mv.addObject("msg1", "Invalid Credentials");
			mv.setViewName("CustomerLoginForm");
			return mv;
		}

	}

}
