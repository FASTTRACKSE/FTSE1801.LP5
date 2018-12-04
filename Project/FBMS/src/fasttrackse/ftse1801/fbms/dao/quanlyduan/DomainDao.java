package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Domain;

public interface DomainDao {
	public List<Domain> findAll();
	public Domain findById(String id);
	public void addNew(Domain domain);
	public void update(Domain domain);
	public void delete(Domain domain);
	public int checkNameDomain(String nameDomain);
	public int checkMaDomain(String idDomain);
	public List<Domain> listDomain(int start, int maxRows);
	public int countDomain();
}
