package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.dao.quanlyduan.TrangThaiTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TrangThaiTeam1;

@Service
public class TrangThaiTeam1ServiceImpl implements TrangThaiTeam1Service {
	@Autowired
	TrangThaiTeam1Dao trangthaiDaoTeam1;

	public void setTrangThaiDao(TrangThaiTeam1Dao trangthaiDaoTeam1) {
		this.trangthaiDaoTeam1 = trangthaiDaoTeam1;

	}

	@Override
	@Transactional
	public List<TrangThaiTeam1> getAll() {
		return this.trangthaiDaoTeam1.getAll();
	}

	@Override
	@Transactional
	public TrangThaiTeam1 findById(String maTrangThai) {
		return this.trangthaiDaoTeam1.findById(maTrangThai);
	}

	@Override
	@Transactional
	public void add(TrangThaiTeam1 trangthaiTeam1) {
		this.trangthaiDaoTeam1.create(trangthaiTeam1);
	}

	@Override
	@Transactional
	public void update(TrangThaiTeam1 trangthaiTeam1) {
		this.trangthaiDaoTeam1.update(trangthaiTeam1);

	}

	@Override
	@Transactional
	public void delete(TrangThaiTeam1 trangthaiTeam1) {
		this.trangthaiDaoTeam1.delete(trangthaiTeam1);

	}

	@Override
	@Transactional
	public List<TrangThaiTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.trangthaiDaoTeam1.findAllForPaging(startPosition, maxResult);
	}

}
