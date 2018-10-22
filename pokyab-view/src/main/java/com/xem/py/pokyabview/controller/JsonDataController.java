
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author miguel
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController {
    
        @Autowired
	private PersonDAO personDAO;
    
	@RequestMapping("/admin/all/persons")
	@ResponseBody
	public List<Person> getAdminPersons(){
		
		return personDAO.getActivePersons();
	}
}
