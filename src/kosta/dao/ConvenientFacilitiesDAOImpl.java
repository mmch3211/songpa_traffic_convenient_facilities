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
				v.add(rs.getInt("PK_LOT"));
				v.add(rs.getString("PK_START"));
				v.add(rs.getString("PK_END"));
				v.add(rs.getInt("PK_TIME"));
				v.add(rs.getInt("PK_FEE"));
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
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		String sql = "SELECT WS_NAME, WS_FIELD, WS_KIND, WS_KIND, WS_ADDR1, WS_CONTACT, WS_DATE FROM WASH";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector <Object> v = new Vector<Object>();
				v.add(rs.getString("WS_NAME"));
				v.add(rs.getString("WS_FIELD"));
				v.add(rs.getString("WS_KIND"));
				v.add(rs.getString("WS_ADDR1"));
				v.add(rs.getString("WS_CONTACT"));
				v.add(rs.getString("WS_DATE"));
				list.add(v);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSelectELC() throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		String sql = "SELECT ELC_NAME, ELC_ADDR_DT, ELC_START, ELC_END, ELC_QUICK_TYPE, ELC_PARKINGFEE, ELC_ADDR1 FROM ELC";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector <Object> v = new Vector<Object>();
				v.add(rs.getString("ELC_NAME"));
				v.add(rs.getString("ELC_ADDR_DT"));
				v.add(rs.getString("ELC_START"));
				v.add(rs.getString("ELC_END"));
				v.add(rs.getString("ELC_QUICK_TYPE"));
				v.add(rs.getString("ELC_PARKINGFEE"));
				v.add(rs.getString("ELC_ADDR1"));
				list.add(v);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSearchByAddr1(String category, String addr) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT ";
		List<Vector<Object>> list=new ArrayList<Vector<Object>>();
		try {
			if(category.equals("ALL")) {
				
			}else {
				sql="";
			}
			
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+addr+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getString(""));
				list.add(v);
			}
			
			
			
		}finally {
			
		}DbUtil.dbClose(con, ps, rs);
		
		return list;
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
