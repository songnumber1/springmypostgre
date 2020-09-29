package com.my.storage.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.storage.dto.UserDto;
import com.my.storage.vo.userVO;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<UserDto> sel(){
		return sqlSession.selectList("user.userselect");
	}
	
	public List<UserDto> getParamterString(String para) {
		return sqlSession.selectList("user.getParaString", para);
	}
	
	public List<UserDto> getParamterMap(Map<String, Object> map) {
		//String in_user_seq = "0xu9n9w9ox176k418dlgq12f2h42tqs461t6";
		return sqlSession.selectList("user.getParamterMap", map);
	}
	
	public List<UserDto> getParamterVO(userVO uservo) {
		//String in_user_seq = "0xu9n9w9ox176k418dlgq12f2h42tqs461t6";
		return sqlSession.selectList("user.getParamterVO", uservo);
	}
	
	public String CallProcedure(Map<String, Object> map) {
		//String in_user_seq = "0xu9n9w9ox176k418dlgq12f2h42tqs461t6";
		return sqlSession.selectOne("user.CallProcedure", map);
	}
}
