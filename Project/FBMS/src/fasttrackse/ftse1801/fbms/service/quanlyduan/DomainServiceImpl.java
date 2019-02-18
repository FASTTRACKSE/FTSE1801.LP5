package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.DomainDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.Domain;

@Service
public class DomainServiceImpl implements DomainService{
	@Autowired
	private DomainDao domainDao;
	
	@Override
	@Transactional
	public List<Domain> findAll() {
		return domainDao.findAll();
	}

	@Override
	@Transactional
	public Domain findById(String maDomain) {
		return domainDao.findById(maDomain);
	}

	@Override
	@Transactional
	public void addNew(Domain domain) {
		domainDao.addNew(domain);		
	}

	@Override
	@Transactional
	public void update(Domain domain) {
		domainDao.update(domain);		
	}

	@Override
	@Transactional
	public void delete(Domain domain) {
		domainDao.delete(domain);		
	}

	@Override
	@Transactional
	public int checkNameDomain(String tenDomain) {
		return domainDao.checkNameDomain(tenDomain);
	}

	@Override
	@Transactional
	public int checkMaDomain(String maDomain) {
		return domainDao.checkMaDomain(maDomain);
	}

	@Override
	@Transactional
	public List<Domain> listDomain(int start, int maxRows) {
		return domainDao.listDomain(start, maxRows);
	}

	@Override
	@Transactional
	public int countDomain() {
		return domainDao.countDomain();
	}

}
