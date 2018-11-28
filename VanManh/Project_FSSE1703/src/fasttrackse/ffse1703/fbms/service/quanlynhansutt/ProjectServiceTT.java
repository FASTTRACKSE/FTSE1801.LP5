package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ProjectsTT;

public interface ProjectServiceTT {
	public List<ProjectsTT> findAll();

	public ProjectsTT findById(String id);

	public void addNew(ProjectsTT projects);

	public void update(ProjectsTT projects);

	public void delete(ProjectsTT projects);

	public int checkNameProjects(String nameProjects);

	public int checkMaProjects(String idProjects);

	public List<HoSoNhanVienTT> getPm(String maPhongBan);
}
