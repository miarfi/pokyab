
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    private PersonDAO personDAO;  
    
//    //Beans Modal
//    @ModelAttribute("person")
//    public Person getPerson() {
//        return new Person();
//    }
    
    @RequestMapping(value = {"/persons"})
    public ModelAndView showAllPersons() {
        logger.info("info.Inside showAllPersons method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Persons");
        mv.addObject("userClickPersons", true);
        return mv;
    }
    
    @RequestMapping(value={"/manage/person"})
    public ModelAndView showManagePerson() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Person");
        mv.addObject("userClickPerson", true);        
        
        //Init new Person
        Person person = new Person();
        mv.addObject("person", person);                
        return mv;
    }
    
    @RequestMapping(value = {"/manage/{id}/person"})
    public ModelAndView showManagePersonEdit(@PathVariable int id) {
        logger.info("En showManagePersonEdit");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Person");
        mv.addObject("userClickPerson", true);
        
        //Get Person object
        Person person = personDAO.getPersonById(id);
        mv.addObject("person", person);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/person", method=RequestMethod.POST)
    public String handlePersonSubmission(@ModelAttribute Person person) {
        logger.info("info.Inside handlePersonSubmission method");
        String alertMessage = "";
        boolean daoResult = false;
        logger.info("person:"+person.toString());
        if (person.getPersonId() == 0) {
            daoResult = personDAO.add(person);
            if (daoResult) alertMessage = "Persona agregada";            
        } else {
            daoResult = personDAO.update(person);
            if (daoResult) alertMessage = "Persona modificada"; 
        }
        return "redirect:/persons?alertMessage=" + alertMessage;
    }

}
