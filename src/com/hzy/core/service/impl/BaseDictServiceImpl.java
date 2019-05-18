package com.hzy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.core.dao.BaseDictDao;
import com.hzy.core.po.BaseDict;
import com.hzy.core.service.BaseDictService;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictDao baseDictDao;
	
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		return this.baseDictDao.selectBaseDictByTypeCode(typecode);
		
	}

}
