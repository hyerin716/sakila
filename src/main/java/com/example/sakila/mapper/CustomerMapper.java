package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Customer;

@Mapper
public interface CustomerMapper {
	
	// /on/addCustomer 고객 추가
	Integer insertCustomer(Customer customer);
}
