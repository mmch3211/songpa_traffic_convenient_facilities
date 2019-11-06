package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kosta.dto.UserListDTO;

public interface UserListService {
	/**
	 *  Id 중복체크 하기
	 *   @return : true이면 중복, false이면 중복아님.
	 * */
	boolean getCheckById(String id) throws SQLException;
	
	/**
	 * 가입하기
	 * */
	int userListInsert(UserListDTO userListDTO)throws SQLException;
	
//	/**
//	 * 수정하기
//	 * (ID에 해당하는 이름,나이, 주소 수정) 
//	 * */
//	int userListUpdate(UserListDTO userListDTO)throws SQLException;
//	
	
	UserListDTO getLogin(String id, String pw) throws SQLException;
	
	/**
	 * 즐찾업데이트
	 * 	(수정하기)
	 * ID와 카테고리, 해당업체명을 인수로 받음 
	 * */
	int favoriteUpdate(String id, String ComName, String ComAddr)throws SQLException;

	/**
	 * 즐찾제거
	 * Id와 카테고리, 해당업체명을 인수로 받음
	 * */
	
	int favoriteDelete(String id, String ConName, String ComAddr)throws SQLException;
	
	/**
	 * 즐찾리스트 보여주기
	 * */
	List<Vector<Object>> getFavoriteList(String id) throws SQLException;
	
	
}
