
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.ContactPointDAO;
import com.xem.py.pokyabmodel.dto.ContactPoint;
import com.xem.py.pokyabmodel.view.ContactPointV;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("contactPointDAO")
@Transactional
public class ContactPointDAOImpl implements ContactPointDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override    
    public boolean add(ContactPoint contactPoint) {        
        try {
            sessionFactory.getCurrentSession()
                          .persist(contactPoint);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;        
    }

    @Override
    public boolean update(ContactPoint contactPoint) {
        try { 
            
            sessionFactory.getCurrentSession()
                          .update(contactPoint);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(ContactPoint contactPoint) {
        try { 
            sessionFactory.getCurrentSession()
                          .delete(contactPoint);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    @Override
    public List<ContactPoint> getActiveContactPoints() {
        String query = "FROM ContactPoint WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, ContactPoint.class)                                     
                             .getResultList();
    }
    
    @Override
    public List<ContactPointV> getAllContactPointsV() {
        String query = "FROM ContactPointV";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, ContactPointV.class)                                     
                             .getResultList();
    }
    
    @Override
    public ContactPoint getContactPointById(int id) {
        String query = "FROM ContactPoint WHERE contactPointId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, ContactPoint.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
