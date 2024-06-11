package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.MerchantDao;
import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class MerchantController {

	@Autowired
	MerchantDao dao;

	@RequestMapping("/addmerchant")
	public ModelAndView addMerchant() {
		Merchant m = new Merchant();
		ModelAndView mv = new ModelAndView();
		mv.addObject("merchantobj", m);
		mv.setViewName("MerchantForm");

		return mv;
	}

	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj") Merchant m) {
		dao.saveMerchant(m);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addMerchant", "Merchant Added Successfully...");
		mv.setViewName("MerchantMenu");

		return mv;
	}

	@RequestMapping("/merchantloginvalidation")
	public ModelAndView login(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		ModelAndView mv = new ModelAndView();
		Merchant m = dao.login(email, password);
		if (m != null) {
			mv.addObject("msg", "Login Successfull...");
			mv.setViewName("MerchantOptions");
			session.setAttribute("merchantinfo", m);
			return mv;
		} else {
			mv.addObject("msg", "Invalid Credentials !!");
			mv.setViewName("MerchantLoginForm");
			return mv;
		}
	}
}
