
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LookupTypeDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
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
@Repository("LookupTypeDAO")
@Transactional
public class LookupTypeDAOImpl implements LookupTypeDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    
    public boolean Add(LookupType lookupType) {
        try {
            lookupType.setActive("Y".charAt(0));
            sessionFactory.getCurrentSession()
                          .persist(lookupType);            
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

//    public List<LookupType> getLkpTypesByLkpType(String lookupType) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
