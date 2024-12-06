package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Store;

@Mapper
public interface StoreMapper {
	
	// /on/addStore : 지점 추가
	Integer insertStore(Store store);
	
	// /on/storeList : 지점리스트 출력 (store x staff x address)
	List<Map<String, Object>> selectStoreList();
	
	List<Store> selectStoreListByStaff();
}
