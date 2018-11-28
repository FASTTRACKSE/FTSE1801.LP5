package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.GiaDinhPikalong;

public interface GiaDinhPikalongService {
	public void addGiaDinhPikalong(GiaDinhPikalong p);
	public void updateGiaDinhPikalong(GiaDinhPikalong p);
	public GiaDinhPikalong getGiaDinhPikalongById(int id);
	public void removeGiaDinhPikalong(int id);
	public List<GiaDinhPikalong> viewOne(String maNV);
	int checkQuanHe(String quanHe, String maNV);
}
