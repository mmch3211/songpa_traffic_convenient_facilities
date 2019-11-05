package kosta.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface ConvenientFacilitiesDAO {
	
	List<Vector<Object>> getSelectParking() throws SQLException;
	
	List<Vector<Object>> getSelectCarwash() throws SQLException;

	List<Vector<Object>> getSelectElectricChargingStation() throws SQLException;
	
	List<Vector<Object>> getSelectByRoadName(String roadName) throws SQLException;
	
	List<Vector<Object>> getSelectByUsingNow() throws SQLException;
	
}
