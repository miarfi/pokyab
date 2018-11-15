package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LookupTypeDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("LookupTypeDAO")
@Transactional
public class LookupTypeDAOImpl implements LookupTypeDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    
    public boolean add(LookupType lookupType) {
        try {
            lookupType.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                          .persist(lookupType);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }

    @Override
    public boolean update(LookupType lookupType) {
        try {            
            sessionFactory.getCurrentSession()
                          .update(lookupType);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }


    @Override
    public boolean delete(LookupType lookupType) {
        try {  
            
            if (lookupType.getSystemFlag() != null 
                && lookupType.getSystemFlag() == 'Y'){
                lookupType.setActive('N');
                lookupType.setEndDate(new java.sql.Date(System.currentTimeMillis()));
                sessionFactory.getCurrentSession()
                          .update(lookupType);
            } else {
                sessionFactory.getCurrentSession()
                          .delete(lookupType);
            }           
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }
    
    @Override
    public List<LookupType> getAllLkpTypes() {
        String query = "FROM LookupType";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupType.class)
                .getResultList();
    }

    @Override
    public LookupType getLookupTypeById(int id) {
        String query = "FROM LookupType WHERE lookupTypeId = :id ";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupType.class)
                .setParameter("id", id)
                .getSingleResult();
    }    
}
