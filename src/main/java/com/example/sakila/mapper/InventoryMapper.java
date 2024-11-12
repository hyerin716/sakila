package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryMapper {
	
	// /on/removeFilm : 필름삭제 시 필요 -> inventory-rental 정보 확인하기 위해서
	Integer selectCountInventoryByFilm(Integer filmId);
	
}
