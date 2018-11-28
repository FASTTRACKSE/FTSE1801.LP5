package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.DanTocTT;

@Repository
public class DanTocDaoTTImpl implements DanTocDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<DanTocTT> listDanTocTT() {
		Session session = sessionFactory.getCurrentSession();
		List<DanTocTT> listDanToc = session.createQuery("from DanTocTT").getResultList();
//		session.close();
		return listDanToc;
	}

}
