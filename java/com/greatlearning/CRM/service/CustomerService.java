package com.greatlearning.CRM.service;

import java.util.List;

import com.greatlearning.CRM.entity.Customer;

public interface CustomerService {

	public Customer findById(int theId);

	public void save(Customer thecustomer);

	public void deleteById(int theId);

	public List<Customer> findAll();
}
