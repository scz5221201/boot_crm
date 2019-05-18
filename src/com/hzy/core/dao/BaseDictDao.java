package com.hzy.core.dao;

import java.util.List;

import com.hzy.core.po.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
