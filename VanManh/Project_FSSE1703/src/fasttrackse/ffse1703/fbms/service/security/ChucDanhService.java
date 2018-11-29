package fasttrackse.ffse1703.fbms.service.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;


public interface ChucDanhService {
	public List<ChucDanh> findAll();

	public void addNew(ChucDanh cd);

	public void update(ChucDanh cd);

	public void delete(String maChucDanh);

	public ChucDanh findByMaChucDanh(String maChucDanh);
	
	public List<ChucDanh> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
	
	public String getSQL(HttpServletRequest request);
	
	public String toJson(ChucDanh cd);
}
