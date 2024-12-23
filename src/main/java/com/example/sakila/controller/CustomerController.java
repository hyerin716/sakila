package com.example.sakila.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.AddressService;
import com.example.sakila.service.CustomerService;
import com.example.sakila.service.RentalService;
import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Address;
import com.example.sakila.vo.Customer;
import com.example.sakila.vo.Store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired StoreService storeService;
	@Autowired AddressService addressService;
	@Autowired RentalService rentalService;
	
	// 고객 상세정보 출력
	@GetMapping("/on/customerOne")
	public String customerOne(Model model
									,@RequestParam Integer customerId) {
		
		// 고객정보 출력
		Map<String, Object> customer = customerService.getCustomerOne(customerId);
		log.debug(customer.toString());	//디버깅
		
		model.addAttribute("customer", customer);
		
		// 고객 대여정보 출력
		List<Map<String, Object>> rentalList = rentalService.getRentalOne(customerId);
		
		log.debug(rentalList.toString());	//디버깅
	    model.addAttribute("rentalList", rentalList);
		
		return "on/customerOne";
	}
	
	// 고객 리스트 출력
	@GetMapping("/on/customerList")
	public String customerList(Model model
									, @RequestParam(defaultValue = "1") Integer currentPage
									, @RequestParam(defaultValue = "10") Integer rowPerPage
									, @RequestParam(required = false) String searchName) {
		
		Map<String, Object> resultMap = customerService.getCustomerList(currentPage, rowPerPage, searchName);
		
		log.debug(resultMap.toString());
		
		model.addAttribute("searchName", searchName);
		model.addAttribute("currentPage", currentPage);
		// resultMap 풀어서... 이동(통으로 넘기면 View 코드 복잡)
		model.addAttribute("startPagingNum", resultMap.get("startPagingNum"));
		model.addAttribute("endPagingNum", resultMap.get("endPagingNum"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("customerList", resultMap.get("customerList"));
		
		return "on/customerList";
	}
	
	
	// 고객 추가
	@GetMapping("/on/addCustomer")
	public String addCustomer(Model model, @RequestParam(required = false) String searchAddress) {
		
		// storeList <--
		List<Store> storeList = storeService.getStoreListByStaff();
		model.addAttribute("storeList", storeList);
		
		// addressList <-- 검색 searchAddress != null
		if(searchAddress != null && !searchAddress.equals("")) {
			List<Address> addressList = addressService.getAddressListByWord(searchAddress);
			model.addAttribute("addressList", addressList);
		}
		
		return "on/addCustomer";
	}
	
	// 고객추가
	@PostMapping("/on/addCustomer")
	public String addCustomer(Customer customer) {
		log.debug("cutomer: " + customer);
		Integer row = customerService.addCustomer(customer);
		return "redirect:/on/customerList";
	}
}
