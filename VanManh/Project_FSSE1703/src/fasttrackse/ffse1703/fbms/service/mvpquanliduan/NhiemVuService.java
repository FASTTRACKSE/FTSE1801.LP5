package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;

public interface NhiemVuService {
	public void add(Nhiemvu nhiemVu);

	public Nhiemvu getByID(String  idProjects);
	
	public Nhiemvu getByid(int id);

	public List<Nhiemvu> getByDuAn(String idProjects);

	public List<Nhiemvu> getByDuAn(String idProjects,String search,int start,int maxRows);

	public void update(Nhiemvu nhiemVu);

	public void delete(int id);
	
	public List<Nhiemvu> getByMaNhanVien(String idNv);
	public int countNhiemvu(String idProjects, String search);
	public int checkRole(String maNv,int idRole,String idProject );
}
