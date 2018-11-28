package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.UserAccountTT;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserAccountDaoTTImpl implements UserAccountDaoTT {

	@Autowired
	SessionFactory sessionFatory;

	@Override
	public UserAccountTT loadUserByUsername(final String username) {
		Session session = sessionFatory.getCurrentSession();
		UserAccountTT user = null;
		try {
			user = session.createQuery("from UserAccountTT where username='" + username + "'", UserAccountTT.class)
					.getSingleResult();
		} catch (NoResultException nre) {
			// Ignore this because as per your logic this is ok!
		}

		return user;
	}
}
