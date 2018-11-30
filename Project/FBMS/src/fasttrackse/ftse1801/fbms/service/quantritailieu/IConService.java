package fasttrackse.ftse1801.fbms.service.quantritailieu;

import java.util.List;

import fasttrackse.ftse1801.fbms.dao.quantritailieu.IConTaiLieuDao;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;

public interface IConService {
	public List<IconTaiLieu> getAllIcon();

	public List<IconTaiLieu> getAllIcon(int page, int record);

	public void insertIcon(IConTaiLieuDao ic);

	public void updateIcon(IConTaiLieuDao ic);

	public void deleteIcon(String maIcon);

	public IconTaiLieu getIconbyMa(String maIcon);
}
