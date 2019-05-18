package com.hzy.core.dao;

import java.util.List;

import com.hzy.core.po.Customer;

public interface CustomerDao {
	
	public List<Customer> selectCustomerList(Customer customer);
	public Integer selectCustomerListCount(Customer customer);

}
