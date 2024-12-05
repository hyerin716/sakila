package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Rental;

@Mapper
public interface RentalMapper {
	
	// /on/customerOne : 고객 상세정보에서 대여정보 출력하기
	List<Map<String, Object>> selectRentalOne(Integer customerId);
	
	// /on/addRental : 인벤토리 대여하기
	Integer insertRental(Rental rental);
}
