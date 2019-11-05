package kosta.util;

/**
 * DB설정 정보를 상수필드로 관리
 * */
public interface DbProperty {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.0.114:1521:XE";
	public static final String USER = "noguri";
	public static final String PASSWORD = "1234";

}
