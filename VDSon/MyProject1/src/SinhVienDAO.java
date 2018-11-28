import java.util.ArrayList;

public class SinhVienDAO {
	public ArrayList<SinhVien> getSinhVien(){
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		sinhVien = new SinhVien("Sơn", "25","đn");
		list.add(sinhVien);
		sinhVien = new SinhVien("Thiên", "24","qn");
		list.add(sinhVien);
		sinhVien = new SinhVien("Mạnh", "21","qn");
		list.add(sinhVien);
		return list;
	}
}
