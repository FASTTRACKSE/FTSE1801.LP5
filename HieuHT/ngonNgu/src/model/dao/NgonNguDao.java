package model.dao;
import java.util.HashMap;
import java.util.Map;

public class NgonNguDao {
	public Map<String, String> engligh(){
		Map<String, String> map = new HashMap<>() ;
		map.put("tieuDe", "Hello");
		return map;
		
	}
	
	public Map<String, String> vietNam(){
		Map<String, String> map = new HashMap<>() ;
		map.put("tieuDe", "Xin Chào");
		return map;
		
	}
	
	
}
