package kosta.controller;

import java.util.List;
import java.util.Vector;

import kosta.service.ConvenientFacilitiesService;
import kosta.service.ConvenientFacilitiesServiceImpl;
import kosta.view.FailView;

public class ConvenientFacilitiesController {
	private static ConvenientFacilitiesService service = new ConvenientFacilitiesServiceImpl();

	/**
	 * 전체레코드 호출
	 * */
	public static List<Vector<Object>> getSelectAll(){
		List<Vector<Object>>list=null;
		try {
			list=service.getSelectAll();
			
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}return list;
	}
	
	
/////////////끝	
}
