package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;

public interface RolesDAO {
	public List<Roles> findAll();
	public Roles findById(int id);
	public void addNew(Roles roles);
	public void update(Roles roles);
	public void delete(Roles roles);
	public int checkNameRoles(String nameRoles);
	public List<Roles> listRoles(int start, int maxRows);
	public int countRoles();
}
