package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;


public interface ProjectDAO {
	public List<Projects> findAll();
	public Projects findById(String id);
	public void addNew(Projects projects);
	public void update(Projects projects);
	public void delete(Projects projects);
	public int checkNameProjects(String nameProjects);
	public int checkMaProjects(String idProjects);
	public List<HoSoNhanVienPikalong> getPm(String maPhongBan);
	public List<Projects> listProject(String search,int start,int maxRows);
	public UserAccount getAccount(String userName);
}
