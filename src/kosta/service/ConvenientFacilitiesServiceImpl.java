package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kosta.dao.ConvenientFacilitiesDAO;
import kosta.dao.ConvenientFacilitiesDAOImpl;

public class ConvenientFacilitiesServiceImpl implements ConvenientFacilitiesService {
	ConvenientFacilitiesDAO dao = new ConvenientFacilitiesDAOImpl();
	
	@Override
	public List<Vector<Object>> getSelectAll() throws SQLException {
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectPK() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectWS() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectELC() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vector<Object>> getSearchByAddr1(String category, String addr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectByUsingNow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectByCategoryNow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
