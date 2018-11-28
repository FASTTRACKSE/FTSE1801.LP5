package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

public interface FrameworkService {
	public List<Framework> getAll();
	public Framework getById(String id);
	public void add(Framework framework);
	public void update(Framework framework);
	public void delete(String id);
	public int checkNameFramework(String nameFramework);
	public List<Framework> listFramework(int start, int maxRows);
	public int countFramework();
}
