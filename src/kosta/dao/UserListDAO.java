package kosta.dao;

import java.sql.SQLException;
import kosta.dto.UserListDTO;

public interface UserListDAO {

	/**
	 *  Id 중복체크 하기
	 *   @return : true이면 중복, false이면 중복아님.
	 * */
	boolean getCheckById(String id) throws SQLException;
	
	/**
	 * 가입하기
	 * */
	int userListInsert(UserListDTO userListDTO)throws SQLException;
	
	/**
	 * 수정하기
	 * (ID에 해당하는 pw,age,addr 수정) 
	 * */
	int userListUpdate(UserListDTO userListDTO)throws SQLException;
	
	/**
	 * 삭제하기
	 * (ID에 해당하는 레코드 삭제)
	 * */
	int userListDelete(String id) throws SQLException;
	

}














