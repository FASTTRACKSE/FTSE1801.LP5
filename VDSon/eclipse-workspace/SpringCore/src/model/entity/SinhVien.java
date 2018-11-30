package model.entity;

public class SinhVien {
	private String MASV;
	private String NAME;
	private String PASS;
	private int AGE;

	public SinhVien() {

	}

	public SinhVien(String mASV, String nAME, String pASS ,int aGE) {
		MASV = mASV;
		NAME = nAME;
		PASS = pASS;
		AGE = aGE;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	public String getPASS() {
		return PASS;
	}
	
	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public int getAGE() {
		return AGE;
	}
	
	public void setAGE(int aGE) {
		AGE = aGE;
	}

}
