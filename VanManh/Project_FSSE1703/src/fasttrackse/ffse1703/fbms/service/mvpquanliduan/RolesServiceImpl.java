package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.RolesDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;

@Service
public class RolesServiceImpl implements RolesService{
	@Autowired
	private RolesDAO rolesDAO;
	@Override
	@Transactional
	public List<Roles> findAll() {
		
		return rolesDAO.findAll();
	}

	@Override
	@Transactional
	public Roles findById(int id) {
	
		return rolesDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Roles roles) {
		rolesDAO.addNew(roles);
		
	}

	@Override
	@Transactional
	public void update(Roles roles) {
		rolesDAO.update(roles);
		
	}

	@Override
	@Transactional
	public void delete(Roles roles) {
		rolesDAO.delete(roles);
		
	}

	@Override
	@Transactional
	public int checkNameRoles(String nameRoles) {
	
		return rolesDAO.checkNameRoles(nameRoles);
	}

	@Override
	@Transactional
	public List<Roles> listRoles(int start, int maxRows) {
		
		return rolesDAO.listRoles(start, maxRows);
	}

	@Override
	@Transactional
	public int countRoles() {
		
		return rolesDAO.countRoles();
	}



}
