
package com.xem.py.pokyabmodel.daoimpl;

import com.xem.py.pokyabmodel.dto.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.xem.py.pokyabmodel.dao.MessageDAO;
import java.util.List;

/**
 *
 * @author arria
 */

@Repository("messageDAO")
@Transactional
public class MessageDAOImpl implements MessageDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean Add(Message messages) {
        
        try {
            sessionFactory.getCurrentSession().persist(messages);			
            return true;
        } catch (Exception ex) {
               ex.printStackTrace();
              return false;
        }
      
    }

    @Override
    public List<Message> getAllMessages() {
         String query = "FROM Message";
        return sessionFactory.getCurrentSession()
                             .createQuery(query, Message.class)                                     
                             .getResultList();
    }
    
}
