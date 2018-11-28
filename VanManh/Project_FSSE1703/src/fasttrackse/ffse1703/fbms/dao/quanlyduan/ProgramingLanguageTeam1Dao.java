package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;

public interface ProgramingLanguageTeam1Dao {
	
	public List<ProgramingLanguageTeam1> getAll();

	public void delete(String maNgonNgu);

	public void addNew(ProgramingLanguageTeam1 nn);

	public ProgramingLanguageTeam1 getById(String maNgonNgu);

	public void update(ProgramingLanguageTeam1 nn);

	public void setIsDelete(String maNgonNgu);
	
	public int getMa(String maNgonNgu);
	
	public List<ProgramingLanguageTeam1> findAllForPaging(int startPosition,int maxResult);
}
