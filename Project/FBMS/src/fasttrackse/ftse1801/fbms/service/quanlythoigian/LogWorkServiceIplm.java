package fasttrackse.ftse1801.fbms.service.quanlythoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlythoigian.LogWorkDaoIplm;
import fasttrackse.ftse1801.fbms.entity.quanlythoigian.LogWork;

@Service
public class LogWorkServiceIplm implements LogWorkService{
	@Autowired
	private LogWorkDaoIplm logWorkDaoIplm;
	
	public List<LogWork> getAllLogWork() {
		return logWorkDaoIplm.getAllLorkWork();
	}
	
	public LogWork getLogWorkByID(int id) {
		return logWorkDaoIplm.getLorkWorkTheoNhanVien(id);
	}
	
	public void updateLogWork(LogWork logWork) {
		logWorkDaoIplm.editLogWork(logWork);
	}
}
