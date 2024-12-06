package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.AddressService;
import com.example.sakila.service.StaffService;
import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Address;
import com.example.sakila.vo.Staff;
import com.example.sakila.vo.Store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StoreController {
	@Autowired StoreService storeService;
	@Autowired StaffService staffService;
	@Autowired AddressService addressService;
	
	// addStore : 지점 추가
	@GetMapping("/on/addStore")
	public String addStore(Model model) {
		// staff 리스트, address 리스트 출력 후 선택해서 지점 추가
		// 1) staff 리스트 출력
		List<Staff> staffList = staffService.getStaffListByStore();
		log.debug("staffList: "+ staffList);
		model.addAttribute("staffList", staffList);
		
		// 2) address 리스트 출력
		List<Address> addressList = addressService.getAddressListByStore();
		log.debug(addressList.toString());
		model.addAttribute("addressList", addressList);
		
		return "on/addStore";
	}
	// addStore : 지점 추가
	@PostMapping("/on/addStore")
	public String addStore(Store store) {
		log.debug(store.toString());
		Integer row = storeService.addStore(store);
		
		if(row==0) {
			return "on/addStore";
		}
		
		return "redirect:/on/storeList";
	}
	
	// storeList 출력
	@GetMapping("/on/storeList")
	public String storeList(Model model) {
		List<Map<String, Object>> storeList = storeService.getStoreList();
		log.debug(storeList.toString());
		
		model.addAttribute("storeList", storeList);
		return "on/storeList";
	}
}
