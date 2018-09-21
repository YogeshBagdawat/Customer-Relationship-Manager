package com.crm.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.dao.CustomerDAO;
import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomer(Model model) {

		// get customer from dao

		/*int t = 1;
		if (t == 1) {
			throw new ArithmeticException();
		}*/

		/*
		 * exception inspring mvc
		 * using @ExceptionHandler(value=ArithmeticException.class) int t=1; if(t==1) {
		 * throw new NullPointerException(); }
		 */

		List<Customer> customers = customerService.getCustomers();

		// add customer to jsp;
		model.addAttribute("customers", customers);

		return "list-customer";

	}

	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model model) {

		Customer customer = new Customer();

		model.addAttribute(customer);

		return "customer-form";

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.save(customer);
		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
		// get customer from db
		Customer customer = customerService.getCustomer(customerId);
		// set customer as model attribute
		model.addAttribute("customer", customer);
		// send to our form

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model model) {
		// get customer from db
		customerService.deleteCustomer(customerId);

		// send to our form

		return "redirect:/customer/list";
	}

}
