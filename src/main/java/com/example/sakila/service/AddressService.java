package com.example.sakila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.AddressMapper;
import com.example.sakila.vo.Address;

@Service
@Transactional
public class AddressService {
	@Autowired AddressMapper addressMapper;
	
	// 검색어 없는 경우 주소 리스트
	public List<Address> getAddressListByStore(){
		return addressMapper.selectAddressListByStore();
	}
	
	// 검색어 있는 경우 주소 리스트
	public List<Address> getAddressListByWord(String searchAddress){
		return addressMapper.selectAddressListByWord(searchAddress);
	}
}
