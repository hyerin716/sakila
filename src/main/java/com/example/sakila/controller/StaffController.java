package com.example.sakila.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.AddressService;
import com.example.sakila.service.StaffService;
import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Address;
import com.example.sakila.vo.Staff;
import com.example.sakila.vo.Store;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StaffController {
	@Autowired StaffService staffService;
	@Autowired StoreService storeService;
	@Autowired AddressService addressService;
	
	// active 수정
	@GetMapping("/on/modifyStaffActive")
	public String modifyStaffActive(Staff staff) {
		if(staff.getActive() == 1) {
			staff.setActive(2);
		} else {
			staff.setActive(1);
		}
		
		int row = staffService.modifyStaff(staff);	// 어떤 컬럼값을 수정하던 mapper 메서드는 하나다.		
		return "redirect:/on/staffList";
	}
	
	
	// leftMenu.a태그 -> 매개값 x, addStaff.주소검색 -> searchAddress값이 넘어옴
	@GetMapping("/on/addStaff")
	public String addStaff(Model model
							, @RequestParam(defaultValue = "") String searchAddress) {
		// model(storeList)
		log.debug("searchAddress: "+ searchAddress);
		
		List<Store> storeList = storeService.getStoreListByStaff();
		model.addAttribute("storeList", storeList);
		
		// model(addresslist) <- searchAddress가 공백이 아니면 검색후
		if(!searchAddress.equals("")) {	// searchAddress가 공백이 아니면
			List<Address> addressList = addressService.getAddressListByWord(searchAddress);
			log.debug(addressList.toString());
			model.addAttribute("addressList", addressList);
			model.addAttribute("searchAddress", searchAddress);
		}
		return "on/addStaff";
	}
	
	@PostMapping("/on/addStaff")
	public String addStaff(Staff staff) {	// 커맨드 객체 생성 -> 커맨드객체.set(request.getParameter())
		// insert 호출
		log.debug(staff.toString());
		int row = staffService.addStaff(staff);
		log.debug("row: " + row);
		
		if(row == 0) { // 입력 실패시 입력페이지로 포워딩
			return "on/addStaff";
		}
		return "redirect:/on/staffList";
	}
	
	@GetMapping("/on/staffList")
	public String staffList(Model model
								, @RequestParam(defaultValue = "1") int currentPage
								, @RequestParam(defaultValue = "2") int rowPerPage) {	//(@RequestParam(defaultValue = "1") int currentPage: currnetPage가  null이면 문자열 1로 해준다
		// model(staffList)
		Map<String, Object> map = new HashMap<>();
		int beginRow = (currentPage - 1) * rowPerPage;
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		log.debug(map.toString());	// 디버깅		
		
		List<Staff> staffList = staffService.getStaffList(map);
		log.debug(staffList.toString());	// 디버깅		
		 
		int lastPage = staffService.getLastPage(rowPerPage);
		log.debug("lastPage: " + lastPage);	// 디버깅	
		
		model.addAttribute("staffList", staffList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		
		
		return "on/staffList";
	}
	
	@GetMapping("/on/staffOne")
	public String staffOne(HttpSession session, Model model) {
		int staffId = ((Staff)(session.getAttribute("loginStaff"))).getStaffId();
		Map<String, Object> map = staffService.getStaffOne(staffId);
		model.addAttribute("staff", map);
		log.debug(map.toString());	//디버깅
		
		return "on/staffOne";
	}
	
}
