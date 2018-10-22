package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("PersonDAO")
@Transactional
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private SessionFactory sessionFactory;
        
    public boolean Add(Person person) {
        
        try {
            person.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                          .persist(person);            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
        
    }
    
    
    public List<Person> getActivePersons() {
        String query = "FROM Person WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Person.class)                                     
                             .getResultList();
    }
    
    public List<Person> getAllPersons() {
        String query = "FROM Person";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Person.class)                                     
                             .getResultList();
    }
}
