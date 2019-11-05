package kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB������ ���� �ε�, ����, ����
 * */
public class DbUtil {
	
	/**
	 * �ε�
	 * */
	static {
		try {
			Class.forName(DbProperty.DRIVER_NAME);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
	 	return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORD);
	}

	
	/**
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�.)
	 * (Insert, Update, Delete �� ���)
	 * */
	public static void dbClose(Connection con, Statement stmt){
		
		try {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ݱ�(DB���� ���� ��ü�� close()�Ѵ�.)
	 * (Select �� ���)
	 * */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs){
		try{
			if(rs != null) rs.close();
			dbClose(con, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}