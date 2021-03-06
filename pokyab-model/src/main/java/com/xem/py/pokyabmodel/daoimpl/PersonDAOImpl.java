package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.view.PersonV;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("personDAO")
@Transactional
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override    
    public boolean add(Person person) {        
        try {
            person.setFullName();
            sessionFactory.getCurrentSession()
                          .persist(person);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
        
    }

    @Override
    public boolean update(Person person) {
        try { 
            person.setFullName();
            sessionFactory.getCurrentSession()
                          .update(person);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(Person person) {
        try { 
            sessionFactory.getCurrentSession()
                          .delete(person);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    @Override
    public List<Person> getActivePersons() {
        String query = "FROM Person WHERE active = 'Y'";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Person.class)                                     
                             .getResultList();
    }
    
    @Override
    public List<Person> getAvailablePersons() {
        String query = "FROM Person p WHERE p.active = 'Y' " +
            " AND NOT EXISTS (FROM TeamPerson tp" +
            " WHERE p.personId = tp.personId)";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Person.class)                                     
                             .getResultList();
    }

    @Override
    public List<PersonV> getAllPersonsV() {
        String query = "FROM PersonV";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, PersonV.class)                                     
                             .getResultList();
    }
    
    @Override
    public Person getPersonById(int id) {
        String query = "FROM Person WHERE personId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
