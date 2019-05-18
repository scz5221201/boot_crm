package com.hzy.core.service;

import java.util.List;

import com.hzy.core.po.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> findBaseDictByTypeCode(String typecode);

}
