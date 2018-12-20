package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dao.LookupUseDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import com.xem.py.pokyabmodel.dto.LookupUse;
import com.xem.py.pokyabmodel.view.TableColumnV;
import com.xem.py.pokyabmodel.view.TableV;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author miguel
 */
@Repository("LookupUseDAO")
@Transactional
public class LookupUseDAOImpl implements LookupUseDAO{
    @Autowired
    private SessionFactory sessionFactory;
        
    public boolean add(LookupUse lookupUse) {
        try {
//            lookupUse.setActive(true);
            sessionFactory.getCurrentSession()
                          .persist(lookupUse);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }
    
    @Override
    public boolean update(LookupUse lookupUse) {
        try {
            sessionFactory.getCurrentSession()
                          .update(lookupUse);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }

    @Override
    public boolean delete(LookupUse lookupUse) {
        
        try {
//            lookupUse.setActive(false);
//            lookupUse.setEndDate(new java.sql.Date(System.currentTimeMillis()));
            sessionFactory.getCurrentSession()
                          .delete(lookupUse);            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    
        return true;
    }
    
    @Override
    public List<LookupUse> getLkpUsesByTypeId(int lookupTypeId) {
        String query = "FROM LookupUse WHERE lookupTypeId = :lookupTypeId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupUse.class)
                .setParameter("lookupTypeId", lookupTypeId)
                .getResultList();
    }

    //En automatico debe hacer esta consulta en el maestro.
    @Override
    public List<LookupUse> getLkpUsesByType(String lookupType) {
        //Busqueda de lookupTypeId
        String query = "FROM LookupType WHERE lookupType = :lookupType";
        int lookupTypeId =  sessionFactory.getCurrentSession()
                .createQuery(query, LookupType.class)
                .setParameter("lookupType", lookupType)
                .getSingleResult()
                .getLookupTypeId();
        
        query = "FROM LookupUse WHERE lookupTypeId = :lookupTypeId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupUse.class)
                .setParameter("lookupTypeId", lookupTypeId)
                .getResultList();
    }

    @Override
    public LookupUse getLookupUseById(int id) {
        String query = "FROM LookupUse WHERE lookupUseId = :id";
        return sessionFactory.getCurrentSession()
                .createQuery(query, LookupUse.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<TableColumnV> getTableColumnList() {
        String query = "FROM TableColumnV";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TableColumnV.class)                
                .getResultList();        
    }
    
    @Override
    public List<TableV> getTableList() {
        String query = "FROM TableV";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TableV.class)                
                .getResultList();        
    }

    @Override
    public List<TableColumnV> getTableColumnList(String tableName) {
        String query = "FROM TableColumnV WHERE tableName = :tableName";
        return sessionFactory.getCurrentSession()
                .createQuery(query, TableColumnV.class) 
                .setParameter("tableName", tableName)
                .getResultList();        
    }     
}