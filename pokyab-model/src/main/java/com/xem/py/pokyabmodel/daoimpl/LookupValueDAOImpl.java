package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import com.xem.py.pokyabmodel.dto.LookupValue;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arria
 */
@Repository("LookupValueDAO")
@Transactional
public class LookupValueDAOImpl implements LookupValueDAO{

    @Autowired
    private SessionFactory sessionFactory;
        
    public boolean add(LookupValue lookupValue) {
        try {
            lookupValue.setActive('Y');
            sessionFactory.getCurrentSession()
                          .persist(lookupValue);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }
    
    @Override
    public boolean update(LookupValue lookupValue) {
        try {
            sessionFactory.getCurrentSession()
                          .update(lookupValue);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }

    @Override
    public boolean delete(LookupValue lookupValue) {
        
        try {
            lookupValue.setActive('N');
            lookupValue.setEndDate(new java.sql.Date(System.currentTimeMillis()));
            sessionFactory.getCurrentSession()
                          .update(lookupValue);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }
    
    @Override
    public List<LookupValue> getLkpValuesByTypeId(int lookupTypeId) {
        String query = "FROM LookupValue WHERE lookupTypeId = :lookupTypeId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupValue.class)
                .setParameter("lookupTypeId", lookupTypeId)
                .getResultList();
    }

    //En automatico debe hacer esta consulta en el maestro.
    @Override
    public List<LookupValue> getLkpValuesByType(String lookupType) {
        //Busqueda de lookupTypeId
        String query = "FROM LookupType WHERE lookupType = :lookupType";
        int lookupTypeId =  sessionFactory.getCurrentSession()
                .createQuery(query, LookupType.class)
                .setParameter("lookupType", lookupType)
                .getSingleResult()
                .getLookupTypeId();
        
        query = "FROM LookupValue WHERE lookupTypeId = :lookupTypeId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupValue.class)
                .setParameter("lookupTypeId", lookupTypeId)
                .getResultList();
    }
    
}
