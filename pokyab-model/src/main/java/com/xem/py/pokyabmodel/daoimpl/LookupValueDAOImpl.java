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
//            lookupValue.setActive('Y');
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
//            lookupValue.setActive('N');
//            lookupValue.setEndDate(new java.sql.Date(System.currentTimeMillis()));
            sessionFactory.getCurrentSession()
                          .delete(lookupValue);            
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

       
//    @Override
//    public List<LookupValue> getLkpValuesByType(String lookupType) {
//        //Busqueda de lookupTypeId
//        String query = "FROM LookupType WHERE lookupType = :lookupType";
//        int lookupTypeId =  sessionFactory.getCurrentSession()
//                .createQuery(query, LookupType.class)
//                .setParameter("lookupType", lookupType)
//                .getSingleResult()
//                .getLookupTypeId();
//        
//        query = "FROM LookupValue WHERE lookupTypeId = :lookupTypeId";
//        return sessionFactory.getCurrentSession()
//                .createQuery(query, LookupValue.class)
//                .setParameter("lookupTypeId", lookupTypeId)
//                .getResultList();
//    }
    
    @Override
    public List<LookupValue> getLkpValuesByType(String lookupType, String meaning) {
        String query = "FROM LookupType WHERE lookupType = :lookupType";
        int lookupTypeId;
        try {
            lookupTypeId =  sessionFactory.getCurrentSession()
                .createQuery(query, LookupType.class)
                .setParameter("lookupType", lookupType)
                .getSingleResult()
                .getLookupTypeId();
        } catch (Exception e) {
            lookupTypeId = -1;
        }
            

        
        query = "FROM LookupValue WHERE lookupTypeId = :lookupTypeId AND meaning LIKE :meaning";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupValue.class)
                .setParameter("lookupTypeId", lookupTypeId)
                .setParameter("meaning", meaning+'%')
                .getResultList();
    }

    @Override
    public LookupValue getLookupValueById(int id) {
        String query = "FROM LookupValue WHERE lookupValueId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupValue.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
