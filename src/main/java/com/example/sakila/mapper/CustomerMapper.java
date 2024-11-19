package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Customer;

@Mapper
public interface CustomerMapper {
	
	// /on/customerList 고객리스트 출력
	List<Customer> selectCustomerList(Map<String, Object> paramMap);
	
	// /on/addCustomer 고객 추가
	Integer insertCustomer(Customer customer);
}
