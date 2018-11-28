package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DomainTeam1;

public interface DomainTeam1Service {
	
	public List<DomainTeam1> getAll();

	public DomainTeam1 findById(String maNghiepVu);

	public void add(DomainTeam1 domainTeam1);

	public void update( DomainTeam1 domainTeam1);

	public void delete(DomainTeam1 domainTeam1);

	public List<DomainTeam1> findAllForPaging(int startPosition, int maxResult);

}
