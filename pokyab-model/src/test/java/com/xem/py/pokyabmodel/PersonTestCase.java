
package com.xem.py.pokyabmodel;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import java.sql.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author arria
 */
public class PersonTestCase {
  
    private static AnnotationConfigApplicationContext context;
	private static PersonDAO personDAO;
	private Person person = null;

	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.xem.py.pokyabmodel");
		context.refresh();
		
		personDAO = (PersonDAO) context.getBean("personDAO");
	}
        
        
        @Test 
        public void addMessage(){
            person = new Person();

            person.setFirstName("pedro");
            person.setLastName("perez");
            person.setGenderCode("M");
            person.setMaritalStatusCode("SINGLE");
            person.setDateOfBirth(Date.valueOf("2010-07-07"));
//            long millis=System.currentTimeMillis();  
//            Date date=new Date(millis);  
//            System.out.println(date);  
//            person.setStartDate(date);
            person.setStartDate(new Date(System.currentTimeMillis()));
            person.setPersonType("PLAYER");            
                   
            
            
           
            assertEquals("Failed to add person!", true,  personDAO.add(person));
        }

}
