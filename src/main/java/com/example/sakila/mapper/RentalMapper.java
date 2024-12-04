package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Rental;

@Mapper
public interface RentalMapper {
	
	// /on/addRental : 인벤토리 대여하기
	Integer insertRental(Rental rental);
}
