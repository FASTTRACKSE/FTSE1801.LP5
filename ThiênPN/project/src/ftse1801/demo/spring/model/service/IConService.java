package ftse1801.demo.spring.model.service;

import java.util.List;

import ftse1801.demo.spring.model.dao.IConTaiLieuDao;
import ftse1801.demo.spring.model.entity.IconTaiLieu;

public interface IConService {
	public List<IconTaiLieu> getAllIcon();

	public List<IconTaiLieu> getAllIcon(int page, int record);

	public void insertIcon(IConTaiLieuDao ic);

	public void updateIcon(IConTaiLieuDao ic);

	public void deleteIcon(String maIcon);

	public IconTaiLieu getIconbyMa(String maIcon);
}
