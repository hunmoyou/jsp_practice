package com.jsp.pboard.model;

import java.util.ArrayList;
import java.util.List;

public class PboardRepository {
	
	private static final List<PboardVO> pboardList = new ArrayList<>();
	
	public PboardRepository() {} 
	
	private static PboardRepository prepository = new PboardRepository();
	
	public static PboardRepository getInstance() {
		return prepository;
	}
	
	public void regist(PboardVO vo) {
		pboardList.add(vo);
	}
	
	public List<PboardVO> getList(){
		return pboardList;
	}
	
}
