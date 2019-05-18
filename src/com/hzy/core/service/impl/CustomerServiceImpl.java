package com.hzy.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.common.utils.Page;
import com.hzy.core.dao.CustomerDao;
import com.hzy.core.po.Customer;
import com.hzy.core.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource,
			String custIndustry, String custLevel) {
		
		Customer customer = new Customer();
		if (StringUtils.isNotBlank(custName)) {
			customer.setCust_name(custName);
		}
		if (StringUtils.isNotBlank(custSource)) {
			customer.setCust_source(custSource);
		}
		if (StringUtils.isNotBlank(custIndustry)) {
			customer.setCust_industry(custIndustry);
		}
		if (StringUtils.isNotBlank(custLevel)) {
			customer.setCust_level(custLevel);
		}
		customer.setStart((page-1)*rows);
		
		List<Customer> customers=customerDao.selectCustomerList(customer);
		
		Integer count = customerDao.selectCustomerListCount(customer);
		
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		
		return result;
	}

}
