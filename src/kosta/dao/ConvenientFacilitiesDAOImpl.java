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
	public List<Vector<Object>> getSelectPK() throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		String sql = "SELECT * FROM VIEW_PK";
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
		String sql = "SELECT * FROM VIEW_WS";
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
		String sql = "SELECT * FROM VIEW_ELC";
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
		List<Vector<Object>> list=new ArrayList<Vector<Object>>();
		try {
			switch(category) {
				case "林瞒厘"://林瞒厘老版快
					con=DbUtil.getConnection();
					ps=con.prepareStatement("SELECT * FROM VIEW_PK WHERE PK_ADDR1 LIKE ?");
					ps.setString(1, "%"+addr+"%");
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
						break;
					}
				case "技瞒厘" :
					con=DbUtil.getConnection();
					ps=con.prepareStatement("SELECT * FROM VIEW_WS WHERE WS_ADDR1 LIKE ?");
					ps.setString(1, "%"+addr+"%");
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
						break;
					}
				case"面傈家":
					con=DbUtil.getConnection();
					ps=con.prepareStatement("SELECT * FROM VIEW_ELC WHERE ELC_ADDR1 LIKE ?");
					ps.setString(1, "%"+addr+"%");
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
						break;
					}
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Vector<Object>> getSelectByUsingNow(String category) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		try {
			switch(category) {
				case "林瞒厘"://林瞒厘老版快
					con=DbUtil.getConnection();
					ps=con.prepareStatement("SELECT * FROM VIEW_NOW_PK");
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
						break;
					}

				case"面傈家":
					con=DbUtil.getConnection();
					ps=con.prepareStatement("SELECT * FROM VIEW_NOW_ELC");
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
						break;
					}
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}


}
