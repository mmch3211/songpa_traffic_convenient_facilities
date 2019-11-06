package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import kosta.dto.UserListDTO;
import kosta.util.DbUtil;

public class UserListDAOImpl implements UserListDAO {

	@Override
	public boolean getCheckById(String id) throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result =false;
		String sql = "SELECT ID FROM USERLIST WHERE UPPER(ID)=UPPER(?)";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id.trim());
			rs = ps.executeQuery();
			if(rs.next()) {
				result=true;
			}return result;
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	}

	@Override
	public int userListInsert(UserListDTO userListDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		String sql = "INSERT INTO USERLIST VALUES (?,?,?,?)";
		 try {
			 con=DbUtil.getConnection();
			 ps=con.prepareStatement(sql);
			 ps.setString(1, userListDTO.getId());
			 ps.setString(2, userListDTO.getPw());
			 ps.setString(3, userListDTO.getName());
			 ps.setString(4, userListDTO.getAddr());
			 result=ps.executeUpdate();
		 }finally {
			 DbUtil.dbClose(con, ps);
		 }
		return result;
	}

	@Override
	public UserListDTO getLogin(String id, String pw) throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql = "select * from userlist where upper(id) = upper (?) and pw = ?";
		 UserListDTO dto =null;
		try {
			 con=DbUtil.getConnection();
			 ps=con.prepareStatement(sql);
			 ps.setString(1, id);
			 ps.setString(2, pw);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 dto = new UserListDTO(
				  rs.getString("id"),
				  rs.getString("pw"),
				  rs.getString("name"),	
				  rs.getString("addr"));
			 }
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public int favoriteUpdate(String id, String ComName, String ComAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		String sql = "INSERT INTO FAVORITE VALUES (?,?,?)";
		 try {
			 con=DbUtil.getConnection();
			 ps=con.prepareStatement(sql);
			 ps.setString(1, id);
			 ps.setString(2, ComName);
			 ps.setString(3, ComAddr);
			 result=ps.executeUpdate();
		 }finally {
			 DbUtil.dbClose(con, ps);
		 }
		return result;
	}
	
	@Override
	public int favoriteDelete(String id, String ConName, String ComAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		String sql = "INSERT INTO FAVORITE VALUES (?,?,?)";
		 try {
			 con=DbUtil.getConnection();
			 ps=con.prepareStatement(sql);
			 ps.setString(1, id);
			 ps.setString(2, ConName);
			 ps.setString(3, ComAddr);
			 result=ps.executeUpdate();
		 }finally {
			 DbUtil.dbClose(con, ps);
		 }
		return result;
	}
	
	@Override
	public List<Vector<Object>> getFavoriteList(String id) throws SQLException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Vector<Object>>list = new ArrayList<Vector<Object>>();
		String sql = "SELECT * FROM FAVORITE WHERE ID = ?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector<Object>v = new Vector<Object>();
				v.add(rs.getString("ID"));
				v.add(rs.getString("NAME"));
				v.add(rs.getString("ADDR1"));
				list.add(v);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
		
}
