package com.crm.service;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);
}
