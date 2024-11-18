package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Inventory;

@Mapper
public interface InventoryMapper {
	
	// /on/removeInventoryBykey : inventoryList.jsp -> 인벤토리 삭제
	Integer deleteInventoryBykey(Integer inventoryId);
	
	// /on/addInventory : storeList.jsp -> 인벤토리 추가
	Integer insertInventory(Inventory inventory);	
	
	// /on/inventoryList : storeList.jsp -> inventoryList 출력
	List<Map<String, Object>> selectInventoryListByStore(Map<String, Object> paramMap);
	
	// /on/removeFilm : 필름삭제 시 필요 -> inventory-rental 정보 확인하기 위해서
	Integer selectCountInventoryByFilm(Integer filmId);
	
}
