package kosta.dao;

import java.sql.SQLException;
import kosta.dto.UserListDTO;

public interface UserListDAO {

	/**
	 *  Id �ߺ�üũ �ϱ�
	 *   @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
	 * */
	boolean getCheckById(String id) throws SQLException;
	
	/**
	 * �����ϱ�
	 * */
	int userListInsert(UserListDTO userListDTO)throws SQLException;
	
	/**
	 * �����ϱ�
	 * (ID�� �ش��ϴ� pw,age,addr ����) 
	 * */
	int userListUpdate(UserListDTO userListDTO)throws SQLException;
	
	/**
	 * �����ϱ�
	 * (ID�� �ش��ϴ� ���ڵ� ����)
	 * */
	int userListDelete(String id) throws SQLException;
	

}














