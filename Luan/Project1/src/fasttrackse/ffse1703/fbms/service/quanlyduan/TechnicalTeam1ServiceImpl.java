package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.TechnicalTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TechnicalTeam1;

@Service

public class TechnicalTeam1ServiceImpl implements TechnicalTeam1Service {

		@Autowired
		TechnicalTeam1Dao technicalTeam1Dao;

		@Override
		@Transactional
		public List<TechnicalTeam1> getAll() {
			return this.technicalTeam1Dao.getAll();

		}

		@Override
		@Transactional
		public void delete(String maCongNghe) {
			this.technicalTeam1Dao.delete(maCongNghe);

		}

		@Override
		@Transactional
		public void save(TechnicalTeam1 congNghe) {
			this.technicalTeam1Dao.save(congNghe);

		}

		@Override
		@Transactional
		public TechnicalTeam1 getById(String maCongNghe) {
			return this.technicalTeam1Dao.getById(maCongNghe);

		}

		@Override
		@Transactional
		public void update(TechnicalTeam1 congNghe) {
			this.technicalTeam1Dao.update(congNghe);

		}

		@Override
		@Transactional
		public void setIsDelete(String maCongNghe) {
			this.technicalTeam1Dao.setIsDelete(maCongNghe);

		}

		@Override
		@Transactional
		public int getName(String tenCongNghe) {
			return this.technicalTeam1Dao.getName(tenCongNghe);


}
		}
