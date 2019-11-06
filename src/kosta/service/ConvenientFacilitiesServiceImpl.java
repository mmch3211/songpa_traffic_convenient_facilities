package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kosta.dao.ConvenientFacilitiesDAO;
import kosta.dao.ConvenientFacilitiesDAOImpl;

public class ConvenientFacilitiesServiceImpl implements ConvenientFacilitiesService {
	ConvenientFacilitiesDAO dao = new ConvenientFacilitiesDAOImpl();
	

	@Override
	public List<Vector<Object>> getSelectPK() throws SQLException {
		List<Vector<Object>>list = dao.getSelectPK();
		if(list==null||list.isEmpty()) {
			throw new SQLException("검색된 주차장이 없습니다.");
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSelectWS() throws SQLException {
		List<Vector<Object>>list = dao.getSelectWS();
		if(list==null||list.isEmpty()) {
			throw new SQLException("검색된 세차장이 없습니다.");
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSelectELC() throws SQLException {
		List<Vector<Object>>list = dao.getSelectELC();
		if(list==null||list.isEmpty()) {
			throw new SQLException("검색된 충전소가 없습니다.");
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSearchByAddr1(String category, String addr) throws SQLException {
		List<Vector<Object>>list = dao.getSearchByAddr1(category,addr);
		if(list==null||list.isEmpty()) {
			throw new SQLException("검색된 주소가 없습니다.");
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSelectByUsingNow(String category) throws SQLException {
		List<Vector<Object>>list = dao.getSelectByUsingNow(category);
		if(list==null||list.isEmpty()) {
			throw new SQLException("검색된 현재 가능한 장소가 없습니다.");
		}
		return list;
	}


}
