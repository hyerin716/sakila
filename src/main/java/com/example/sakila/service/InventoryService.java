package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sakila.mapper.InventoryMapper;
import com.example.sakila.vo.Inventory;

@Service
public class InventoryService {
	@Autowired InventoryMapper inventoryMapper;
	
	// /on/addInventory : storeList.jsp -> 인벤토리 추가
	public Integer addInventory(Inventory inventory) {
		return inventoryMapper.insertInventory(inventory);
	}
	
	// /on/inventoryList : storeList.jsp -> inventoryList 출력
	public List<Map<String, Object>> getInventoryListByStore(
							Integer storeId, Integer currentPage, Integer rowPerPage){
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("storeId", storeId);
		paraMap.put("rowPerPage", rowPerPage);
		int beginRow = (currentPage - 1) * rowPerPage;
		paraMap.put("beginRow", beginRow);
		
		return inventoryMapper.selectInventoryListByStore(paraMap);
	}
	
	// /on/removeFilm : 필름삭제 시 필요 -> inventory-rental 정보 확인하기 위해서
	public Integer getCountInventoryByFilm(Integer filmId) {
		return inventoryMapper.selectCountInventoryByFilm(filmId);
	}
	
	
}
