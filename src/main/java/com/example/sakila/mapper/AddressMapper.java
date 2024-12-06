package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Address;

@Mapper
public interface AddressMapper {
	
	// 검색어 없는 경우 주소 리스트
	// /on/addStore: 지점 추가에서 address 선택시 리스트 출력 필요
	List<Address> selectAddressListByStore();
	
	// 검색어 있는 경우 주소 리스트
	List<Address> selectAddressListByWord(String searchAddress);
	
}
