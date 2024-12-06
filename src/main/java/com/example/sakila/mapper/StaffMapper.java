package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Staff;

@Mapper
public interface StaffMapper {
	
	// /on/addStore: 지점 추가에서 staff 선택시 리스트 출력 필요
	List<Staff> selectStaffListByStore();
	
	int updateStaff(Staff staff); 	// 업뎃문 하나로 모든 컬럼을 개별수정 가능하게
	
	int selectStaffCount();
	
	List<Staff> selectStaffList(Map<String, Object> map);
	
	int insertStaff(Staff staff);

	// /on/staffOne.jsp
	Map<String, Object> selectStaffOne(int staffId); 
	
	// /off/login.jsp
	Staff login(Staff staff);
}

// MyBatis에게 이 인터페이스가 매퍼임을 알려줍니다.
// MyBatis는 이 인터페이스의 메소드를 호출할 때, 매핑된 SQL 쿼리를 찾아 실행합니다.