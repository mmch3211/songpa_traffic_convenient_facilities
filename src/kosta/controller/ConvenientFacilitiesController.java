package kosta.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kosta.dto.UserListDTO;
import kosta.service.ConvenientFacilitiesService;
import kosta.service.ConvenientFacilitiesServiceImpl;
import kosta.service.UserListService;
import kosta.service.UserListServiceImpl;
import kosta.view.FailView;

public class ConvenientFacilitiesController {
	private static ConvenientFacilitiesService service = new ConvenientFacilitiesServiceImpl();
	private static UserListService userService = new UserListServiceImpl();
	
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

	public static int userListInsert(UserListDTO userListDTO) {
		int result=0;
		try {
			result = userService.userListInsert(userListDTO);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	public static boolean getCheckById(String id) {
		boolean result = true;
		try {
			 result = userService.getCheckById(id);
		}catch(SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	public static UserListDTO getLogin(String id, String pw) {
		UserListDTO dto =null;
		try {
			dto = userService.getLogin(id, pw);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return dto;
	}
	

	public static int favoriteUpdate(String id, String ComName, String ComAddr) {
			int result=0;
		try {
			result = userService.favoriteUpdate(id, ComName, ComAddr);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}

	public static int favoriteDelete(String id, String ComName, String ComAddr) {
		int result=0;
		try {
			result = userService.favoriteDelete(id, ComName, ComAddr);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}

	public static List<Vector<Object>> getFavoriteList(String id) {
		List<Vector<Object>>list=null;
		try {
			list = userService.getFavoriteList(id);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	
	
/////////////³¡	
}
