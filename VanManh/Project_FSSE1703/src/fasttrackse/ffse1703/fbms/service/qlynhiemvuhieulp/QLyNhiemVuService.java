package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.DuAnEntityHieuLp;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.HoSoNhanVienHLP;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaicongviecEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaitrangthaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;


public interface QLyNhiemVuService {

	public void delete(QLyNhiemVuEntity nv);

	public void add(QLyNhiemVuEntity nv);

	public void update(QLyNhiemVuEntity nv);

	public QLyNhiemVuEntity findById(int id);

	public List<QLyNhiemVuEntity> getAll();

	public List<LoaitrangthaiEntity> trangThai();

	public List<LoaicongviecEntity> congViec();

	public List<DuAnEntityHieuLp> duAn();

	public List<HoSoNhanVienHLP> nhanVienHLP();

	public List<QLyNhiemVuEntity> findAll(Integer offset, Integer maxResult, String seach);

	public String toJson(List<QLyNhiemVuEntity> list);
	
	public List<QLyNhiemVuEntity> searchAll(String search);
}
