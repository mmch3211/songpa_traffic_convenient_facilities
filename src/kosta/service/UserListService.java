package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

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
	
	UserListDTO getLogin(String id, String pw) throws SQLException;
	
	/**
	 * ��ã������Ʈ
	 * 	(�����ϱ�)
	 * ID�� ī�װ�, �ش��ü���� �μ��� ���� 
	 * */
	int favoriteUpdate(String id, String ComName, String ComAddr)throws SQLException;

	/**
	 * ��ã����
	 * Id�� ī�װ�, �ش��ü���� �μ��� ����
	 * */
	
	int favoriteDelete(String id, String ConName, String ComAddr)throws SQLException;
	
	/**
	 * ��ã����Ʈ �����ֱ�
	 * */
	List<Vector<Object>> getFavoriteList(String id) throws SQLException;
	
	
}
