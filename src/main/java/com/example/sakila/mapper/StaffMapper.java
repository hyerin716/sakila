package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Staff;

@Mapper
public interface StaffMapper {

	// /on/staffOne.jsp
	Staff selectStaffOne(int staffId); 
	
	// /off/login.jsp
	Staff login(Staff staff);
}

// MyBatis에게 이 인터페이스가 매퍼임을 알려줍니다.
// MyBatis는 이 인터페이스의 메소드를 호출할 때, 매핑된 SQL 쿼리를 찾아 실행합니다.