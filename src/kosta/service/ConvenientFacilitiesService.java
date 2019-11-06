package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface ConvenientFacilitiesService {
	/**
	 * 카테고리에서 주차장선택 
	 * */
	List<Vector<Object>> getSelectPK() throws SQLException;
	
	/**
	 * 카테고리에서 세자창선택
	 * */
	List<Vector<Object>> getSelectWS() throws SQLException;
	
	/**
	 * 카테고리에서 전기차충전소 선택
	 * */
	List<Vector<Object>> getSelectELC() throws SQLException;
	
	/**
	 * 카테고리별로 도로명주소 검색
	 * */
	List<Vector<Object>> getSearchByAddr1(String category, String addr) throws SQLException;
	
	/**
	 * 선택영역에 해당한 매장이 지금 시간에 이용가능한지 여부
	 * */
	List<Vector<Object>> getSelectByUsingNow(String category) throws SQLException;
	
	
}
