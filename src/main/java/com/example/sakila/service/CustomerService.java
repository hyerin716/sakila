package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.CustomerMapper;
import com.example.sakila.vo.Customer;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@Transactional
public class CustomerService {
	@Autowired CustomerMapper customerMapper;
	
	// /on/addRental : 대여하기: 이름 검색해서 고객리스트 출력
	public List<Customer> getCustomerListByName(String searchName) {
		return customerMapper.selectCustomerListByName(searchName);
	}
	
	// lastPage 구하기
	public Integer getLastPage(Integer rowPerPage, String searchName) {
		// 총 개수 구하기
		Integer totalRow = customerMapper.countTotalRow(searchName);
		log.debug("total!!: " + totalRow);
		
		Integer lastPage = totalRow / rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage++;
		}
		
		log.debug("lastPage!!: " + lastPage);
		return lastPage;
	}
	
	// /on/customerList 고객리스트 출력
	public Map<String, Object> getCustomerList(Integer currentPage, Integer rowPerPage, String searchName) {
		Integer beginRow = (currentPage-1) * rowPerPage;
		
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("beginRow", beginRow);
		paraMap.put("rowPerPage", rowPerPage);
		paraMap.put("searchName", searchName);
		
		// 한페이지당 페이징개수는 10개씩이라고 가정
		Integer numPerPage = 10;
		// 페이징 첫번째 넘버
		Integer startPagingNum = (currentPage-1)/numPerPage * numPerPage + 1;
		// 페이징 마지막 넘버
		Integer endPagingNum = startPagingNum + (numPerPage - 1);

		
		// 현재페이지가 95다 91~100출력인데 마지막 페이지가 98이면 91~98 출력되도록...
		Integer lastPage = this.getLastPage(rowPerPage, searchName);
		if(lastPage < endPagingNum) {
			endPagingNum = lastPage;
		}
		
		// beginRow, rowPerpage과 함께 전달해서 customerList 출력함수 호출
		List<Customer> customerList = customerMapper.selectCustomerList(paraMap);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startPagingNum", startPagingNum);
		resultMap.put("endPagingNum", endPagingNum);
		resultMap.put("lastPage", lastPage);
		resultMap.put("customerList", customerList);
		return resultMap;	
		
	}
	
	
	// /on/addCustomer 고객 추가
	public Integer addCustomer(Customer customer) {
		return customerMapper.insertCustomer(customer);
	}

}
