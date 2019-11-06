package kosta.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kosta.service.ConvenientFacilitiesService;
import kosta.service.ConvenientFacilitiesServiceImpl;
import kosta.view.FailView;

public class ConvenientFacilitiesController {
	private static ConvenientFacilitiesService service = new ConvenientFacilitiesServiceImpl();

	
	public static List<Vector<Object>> getSelectELC(){
		List<Vector<Object>>list=null;
		try {
		list = service.getSelectELC();
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	public static List<Vector<Object>> getSelectWS(){
		List<Vector<Object>>list=null;
		try {
		list = service.getSelectWS();
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	public static List<Vector<Object>> getSelectPK(){
		List<Vector<Object>>list=null;
		try {
		list = service.getSelectPK();
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	
	public static List<Vector<Object>> getSelectByUsingNow(String category){
		List<Vector<Object>>list=null;
		try {
			list = service.getSelectByUsingNow(category);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	public static List<Vector<Object>> getSearchByAddr1(String category, String addr) {
		List<Vector<Object>>list =null;
		try {
		list = service.getSearchByAddr1(category,addr);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}

/////////////³¡	
}
