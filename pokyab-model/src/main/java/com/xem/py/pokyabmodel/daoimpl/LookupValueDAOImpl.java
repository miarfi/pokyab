package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
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
@Repository("LookupValueDAO")
@Transactional
public class LookupValueDAOImpl implements LookupValueDAO{

    @Autowired
    private SessionFactory sessionFactory;
        
    public boolean Add(LookupValue lookupValue) {
        try {
            lookupValue.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                          .persist(lookupValue);            
        } catch (HibernateException e) {
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


    
}
