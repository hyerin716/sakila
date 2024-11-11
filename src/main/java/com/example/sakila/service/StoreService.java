package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.StoreMapper;
import com.example.sakila.vo.Store;

@Service
@Transactional
public class StoreService {
	@Autowired StoreMapper storeMapper;
	
	// /on/storeList
	public List<Map<String, Object>> getStoreList(){
		return storeMapper.selectStoreList();
	}
	
	// /on/addStaff 
	public List<Store> getStoreListByStaff() {
		return storeMapper.selectStoreListByStaff();
	}
}
