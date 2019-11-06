package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import kosta.util.DbUtil;

public class ConvenientFacilitiesDAOImpl implements ConvenientFacilitiesDAO {

	@Override
	public List<Vector<Object>> getSelectAll() throws SQLException {
	
		return null;
	}

	@Override
	public List<Vector<Object>> getSelectPK() throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		String sql = "SELECT PK_NAME, PK_ADDR1, PK_LOT, PK_START, PK_END, PK_TIME, PK_FEE, PK_CONTACT FROM PARKING";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector<Object>v = new Vector<Object>();
				v.add(rs.getString("PK_NAME"));
				v.add(rs.getString("PK_ADDR1"));
				v.add(rs.getString("PK_LOT"));
				v.add(rs.getString("PK_START"));
				v.add(rs.getString("PK_END"));
				v.add(rs.getString("PK_TIME"));
				v.add(rs.getString("PK_FEE"));
				v.add(rs.getString("PK_CONTACT"));
				list.add(v);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
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
