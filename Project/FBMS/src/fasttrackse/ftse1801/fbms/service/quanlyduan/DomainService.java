package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Domain;

public interface DomainService {
	public List<Domain> findAll();
	public Domain findById(String maDomain);
	public void addNew(Domain domain);
	public void update(Domain domain);
	public void delete(Domain domain);
	public int checkNameDomain(String tenDomain);
	public int checkMaDomain(String maDomain);
	public List<Domain> listDomain(int start, int maxRows);
	public int countDomain();
}
