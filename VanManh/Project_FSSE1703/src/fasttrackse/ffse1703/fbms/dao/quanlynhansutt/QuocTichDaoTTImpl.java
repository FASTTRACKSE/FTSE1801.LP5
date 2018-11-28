package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuocTichTT;

@Repository
public class QuocTichDaoTTImpl implements QuocTichDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<QuocTichTT> getAllQuocTich() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from QuocTichTT");
		List<QuocTichTT> listQuocTich = query.list();

		return listQuocTich;
	}

}
