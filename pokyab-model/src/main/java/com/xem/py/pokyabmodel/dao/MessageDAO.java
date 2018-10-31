package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Message;
import java.util.List;

/**
 *
 * @author arria
 */
public interface MessageDAO {
    boolean Add(Message message);
    
     List<Message> getAllMessages();
}
