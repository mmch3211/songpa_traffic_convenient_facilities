package kosta.service;

import java.sql.SQLException;

import kosta.dto.UserListDTO;

public interface UserListService {
	/**
	 *  Id �ߺ�üũ �ϱ�
	 *   @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
	 * */
	boolean getCheckById(String id) throws SQLException;
	
	/**
	 * �����ϱ�
	 * */
	int userListInsert(UserListDTO userListDTO)throws SQLException;
	
//	/**
//	 * �����ϱ�
//	 * (ID�� �ش��ϴ� �̸�,����, �ּ� ����) 
//	 * */
//	int userListUpdate(UserListDTO userListDTO)throws SQLException;
//	
}
