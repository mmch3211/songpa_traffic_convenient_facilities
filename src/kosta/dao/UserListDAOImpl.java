package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
//
//	@Override
//	public int userListUpdate(UserListDTO userListDTO) throws SQLException {
//		Connection con = null;
//		PreparedStatement ps =null;
//		int result =0;
//		String sql = "UPDATE USERLIST SET PW = ?, NAME =?, ADDR =? WHERE UPPER(ID) = UPPER(?)";
//		 try {
//			 con=DbUtil.getConnection();
//			 ps=con.prepareStatement(sql);
//			 ps.setString(1, userListDTO.getId());
//			 ps.setString(2, userListDTO.getPw());
//			 ps.setString(3, userListDTO.getName());
//			 ps.setString(4, userListDTO.getAddr());
//			 result=ps.executeUpdate();
//			 
//		 }finally {
//			 DbUtil.dbClose(con, ps);
//		 }
//		return result;
//	}
//	

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
	public int favoriteUpdate() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int favoriteDelete() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}