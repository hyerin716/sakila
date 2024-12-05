package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.RentalMapper;
import com.example.sakila.vo.Rental;

@Service
@Transactional
public class RentalService {
	@Autowired RentalMapper rentalMapper;

	// /on/customerOne : 고객 상세정보에서 대여정보 출력하기
	public List<Map<String, Object>> getRentalOne(int customerId){
		return rentalMapper.selectRentalOne(customerId);
	}
	
	// /on/addRental : 인벤토리 대여하기
	public Integer addRental(Rental rental) {
		return rentalMapper.insertRental(rental);
	}
}
