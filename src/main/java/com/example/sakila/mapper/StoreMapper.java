package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Store;

@Mapper
public interface StoreMapper {
	
	// /on/storeList : 지점리스트 출력 (store x staff x address)
	List<Map<String, Object>> selectStoreList();
	
	List<Store> selectStoreListByStaff();
}
