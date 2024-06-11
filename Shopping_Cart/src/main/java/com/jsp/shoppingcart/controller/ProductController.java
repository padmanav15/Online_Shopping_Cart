package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.MerchantDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ProductController {

	@Autowired
	MerchantDao mdao;

	@Autowired
	ProductDao pdao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product p = new Product();
		ModelAndView mv = new ModelAndView();
		mv.addObject("productobj", p);
		mv.setViewName("AddProduct");

		return mv;
	}

	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p, HttpSession session) {
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		List<Product> product = m.getProducts();
		if (product.size() > 0) {
			product.add(p);
			m.setProducts(product);
		} else {
			List<Product> plist = new ArrayList<Product>();
			plist.add(p);

			m.setProducts(plist);
		}
		pdao.saveProduct(p);
		mdao.updateMerchant(m);
		ModelAndView mv = new ModelAndView();
		mv.addObject("addProduct", "Product Added Successfully...");
		mv.setViewName("MerchantOptions");

		return mv;
	}

	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute("merchantinfo");

		Merchant m = mdao.deleteProductFromMerchant(merchant.getId(), id);
		mdao.updateMerchant(m);
		pdao.deleteProductById(id);
		
		session.setAttribute("merchantinfo", m);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("ViewAllProducts");

		return mv;
	}

	@RequestMapping("/Updateform")
	public ModelAndView updateProductById(@RequestParam("id") int id) {
		Product p = pdao.findProductById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("updateproduct", p);
		mv.setViewName("UpdateForm");

		return mv;
	}

	@RequestMapping("/productupdate")
	public ModelAndView updateProduct(Product p) {
		pdao.updateProduct(p);
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatemsg", "Successfull...");
		mv.setViewName("redirect://Updateform");

		return mv;
	}
	
	@RequestMapping("/displayproducts")
	public ModelAndView displayProducts() {
		List<Product> products = pdao.fetchAllProducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", products);
		mv.setViewName("CustomerViewAllProducts");
		
		return mv;
	}
	
	@RequestMapping("/displayproductsbybrand")
	public ModelAndView displayProductsByBrand1(ServletRequest request) {
		String brand1 = request.getParameter("brand");
		List<Product> products = pdao.findProductByBrand(brand1);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", products);
		mv.setViewName("CustomerViewAllProducts");
		
		return mv;
	}
	
	@RequestMapping("/displayproductsbycategory")
	public ModelAndView displayProductsByCategory(ServletRequest request) {
		String category = request.getParameter("category");
		List<Product> products = pdao.findProductByCategory(category);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", products);
		mv.setViewName("CustomerViewAllProducts");
		
		return mv;
	}
	
	@RequestMapping("/displayproductbyrange")
	public ModelAndView displayProductsByRange(ServletRequest req,Double lowrange, Double highrange){
		try {
			String low =  req.getParameter("low");
			String high = req.getParameter("high");
			List<Product> products = pdao.findProductByRange(lowrange, highrange);
			ModelAndView mv = new ModelAndView();
			mv.addObject("productlist", products);
			mv.setViewName("CustomerViewAllProducts");
			
			return mv;
			
		}catch (Exception e) {
			return null;
		}
		
	}

}
