package ftse1801.demo.spring.model.dao;

import java.util.List;

import ftse1801.demo.spring.model.entity.IconTaiLieu;

public interface IConTaiLieuDao {
	public List<IconTaiLieu> getAllIcon();

	public List<IconTaiLieu> getAllIcon(int page, int record);

	public boolean insertIcon(IConTaiLieuDao ic);

	public boolean updateIcon(IConTaiLieuDao ic);

	public boolean deleteIcon(String maIcon);

	public IconTaiLieu getIconbyMa(String maIcon);
}
