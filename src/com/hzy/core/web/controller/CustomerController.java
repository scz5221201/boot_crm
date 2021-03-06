package com.hzy.core.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.hzy.common.utils.Page;
import com.hzy.core.dao.CustomerDao;
import com.hzy.core.po.BaseDict;
import com.hzy.core.po.Customer;
import com.hzy.core.service.BaseDictService;
import com.hzy.core.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BaseDictService baseDictService;
	
	/* 客户来源 */
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	
	/* 客户所属行业 */
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	
	/* 客户级别 */
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	
	public String list(@RequestParam(defaultValue="1")Integer page,
					   @RequestParam(defaultValue="10")Integer rows,
					   @RequestParam(defaultValue="小张")String custName, 
					   @RequestParam(defaultValue="7")String custSource, 
					   @RequestParam(defaultValue="3")String custIndustry,
					   @RequestParam(defaultValue="23")String custLevel, Model model) {
		/* 条件查询所有客户 */
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
		model.addAttribute("page", customers);
		
		/* 客户来源 */
		List<BaseDict> fromType=this.baseDictService.findBaseDictByTypeCode(FROM_TYPE);
		
		/* 客户所属行业 */
		List<BaseDict> industryType=this.baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
		
		/* 客户级别 */
		List<BaseDict> levelType = this.baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName)", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		
		return "customer2";
	}
	
	
}
