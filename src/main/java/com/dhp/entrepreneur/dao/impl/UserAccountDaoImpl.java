package com.dhp.entrepreneur.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhp.entrepreneur.dao.UserAccountDao;
import com.dhp.entrepreneur.domain.UserAccount;

/**
 * @author Chee-HongH
 * User account dao concrete implementation class
 */
@Service
@Transactional
public class UserAccountDaoImpl implements UserAccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(UserAccount userAccount) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(userAccount);
	}
	
	@Override
	public UserAccount get(String username, String password) {
		return (UserAccount) this.sessionFactory.getCurrentSession().createCriteria(UserAccount.class)
		.add(Restrictions.eq("username", username))
		.add(Restrictions.eq("password", password)).uniqueResult();
	}

	@Override
	public UserAccount get(String username) {
		return (UserAccount) this.sessionFactory.getCurrentSession().createCriteria(UserAccount.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
	}
}
