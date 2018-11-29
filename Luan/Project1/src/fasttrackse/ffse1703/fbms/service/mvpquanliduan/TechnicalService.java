package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;

public interface TechnicalService {
	public List<Technical> findAll();
	public Technical findById(String id);
	public void addNew(Technical technical);
	public void update(Technical technical);
	public void delete(Technical technical);
	public int checkNameTechnical(String nameTechnical);
	public int checkMaTechnical(String idTechnical);
	public List<Technical> listTechnical(int start, int maxRows);
	public int countTechnical();
}