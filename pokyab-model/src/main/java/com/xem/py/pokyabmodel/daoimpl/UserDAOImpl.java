package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.UserDAO;
import com.xem.py.pokyabmodel.dto.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByEmail(String email) {
        String selectQuery = "FROM User WHERE email = :email";
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery(selectQuery, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean add(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(User.class, id);
        } catch (Exception ex) {           
            return null;
        }
    }
}