package com.xem.py.pokyabmodel;

import com.xem.py.pokyabmodel.dto.Message;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xem.py.pokyabmodel.dao.MessageDAO;

/**
 *
 * @author arria
 */
public class MessageTestCase {
    
	private static AnnotationConfigApplicationContext context;
	private static MessageDAO messageDAO;
	private Message message = null;
		
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.xem.py.pokyabmodel");
		context.refresh();
		
		messageDAO = (MessageDAO) context.getBean("messageDAO");
	}
        
        
        
        @Test 
        public void addMessage(){
            message = new Message();
            message.setCode("102");
            message.setDescription("Descripcion 101");
            message.setMsgType("ERR");
            message.setMsgNum(1);
           
            assertEquals("Failed to add message!", true,  messageDAO.Add(message));
        }
}
