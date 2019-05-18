package com.hzy.core.service;

import com.hzy.common.utils.Page;
import com.hzy.core.po.Customer;

public interface CustomerService {
	
	public Page<Customer> findCustomerList(Integer page, Integer rows,
										   String custName, String custSource,
										   String custIndustry, String custLevel);
}
