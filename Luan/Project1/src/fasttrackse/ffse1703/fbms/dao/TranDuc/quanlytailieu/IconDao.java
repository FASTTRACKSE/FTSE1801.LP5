package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;

public interface IconDao {
	public List<IconTaiLieu> listAllIconTaiLieu();

	public void addIC(IconTaiLieu ic);

	public void updateIC(IconTaiLieu ic);

	public void deleteIC(String maIcon);

	public IconTaiLieu getICbyID(String maIcon);
}
