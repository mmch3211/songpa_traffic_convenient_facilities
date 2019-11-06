package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface ConvenientFacilitiesService {
	/**
	 * ī�װ����� �����弱�� 
	 * */
	List<Vector<Object>> getSelectPK() throws SQLException;
	
	/**
	 * ī�װ����� ����â����
	 * */
	List<Vector<Object>> getSelectWS() throws SQLException;
	
	/**
	 * ī�װ����� ������������ ����
	 * */
	List<Vector<Object>> getSelectELC() throws SQLException;
	
	/**
	 * ī�װ����� ���θ��ּ� �˻�
	 * */
	List<Vector<Object>> getSearchByAddr1(String category, String addr) throws SQLException;
	
	/**
	 * ���ÿ����� �ش��� ������ ���� �ð��� �̿밡������ ����
	 * */
	List<Vector<Object>> getSelectByUsingNow(String category) throws SQLException;
	
	
}
