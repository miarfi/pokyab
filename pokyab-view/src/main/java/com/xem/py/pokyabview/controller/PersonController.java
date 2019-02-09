
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ContactPointDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.validator.PersonValidator;
import com.xem.py.pokyabmodel.view.ContactPointV;
import com.xem.py.pokyabview.util.FileUploadUtility;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);
    
    @Autowired
    private PersonDAO personDAO;  
    @Autowired
    private ContactPointDAO contactPointDAO;  
    @Autowired
    private LookupValueDAO lookupValueDAO; 
    
    //Form Lists
    @ModelAttribute("personTypes")
    public List<LookupValue> getPersonTypes() {
        return lookupValueDAO.getLkpValuesByType("PERSON_TYPE", "");
    }
    
    @ModelAttribute("genderCodes")
    public List<LookupValue> getGenderCodes() {
        return lookupValueDAO.getLkpValuesByType("GENDER_CODE", "");
    }
    
    @ModelAttribute("maritalStatusCodes")
    public List<LookupValue> getMaritalStatusCodes() {
        return lookupValueDAO.getLkpValuesByType("MARITAL_STATUS_CODE", "");
    }
    
    @RequestMapping(value = {"/persons"})
    public ModelAndView showAllPersons(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllPersons method");
        ModelAndView mv = new ModelAndView("person/personMain");
        mv.addObject("title", "Persons");
        mv.addObject("userClickPersons", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    @RequestMapping(value={"/manage/person"})
    public ModelAndView showManagePerson() {
        ModelAndView mv = new ModelAndView("person/personMain");
        mv.addObject("title", "Person");
        mv.addObject("userClickPerson", true);        
        
        //Init new Person
        Person person = new Person();
        mv.addObject("person", person);    
        
        return mv;
    }
    
    @RequestMapping(value = {"/manage/person/{id}"})
    public ModelAndView showManagePersonEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showManagePersonEdit");
        ModelAndView mv = new ModelAndView("person/personMain");
        mv.addObject("title", "Person");
        mv.addObject("userClickPerson", true);
        mv.addObject("alertMessage", alertMessage);
        
        //Get Person object
        Person person = personDAO.getPersonById(id);
        mv.addObject("person", person);    
        
        //Get ContactPoint object
        List<ContactPointV> contactPoints =   contactPointDAO.getContactPointByOwnerId(id, "PERSON");
        mv.addObject("contactPoints", contactPoints); 
        logger.info("contactPoints: "+contactPoints.size());
        
        return mv;
    }    
    
    @RequestMapping(value="/manage/person", method=RequestMethod.POST)
    public String handlePersonSubmission(@ModelAttribute Person person
            ,HttpServletRequest request,BindingResult result, Model model) {
        logger.info("info.Inside handlePersonSubmission method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl = "";
        logger.info("person:"+person.toString());
        
        //Spring Validator        
        new PersonValidator().validate(person, result);        
        logger.info("Errores"+result.getErrorCount());
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Persona");
            model.addAttribute("userClickPerson", true);             
            return "person/personMain";
        }
        
        if (person.getPersonId() == 0) {
            daoResult = personDAO.add(person);
            if (daoResult) alertMessage = "Persona agregada";            
        } else {
            daoResult = personDAO.update(person);
            if (daoResult) alertMessage = "Persona modificada"; 
        }
        
        logger.info("Antes de FileUploadUtility ");
        if (person.getFile() != null)
            if (!person.getFile().getOriginalFilename().equals("")) 
                FileUploadUtility.uploadFile(request, person.getFile(), "person_"+String.valueOf(person.getPersonId()));
        logger.info("Despues de FileUploadUtility ");
        
        if (daoResult) returnUrl = "redirect:/manage/person/"+person.getPersonId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/persons?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/person/{id}/delete", method=RequestMethod.GET)
    public String handlePersonDelete(@PathVariable int id) {
        logger.info("info.Inside handlePersonDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Person person = personDAO.getPersonById(id);
        if (person != null) {
            logger.info("person: "+person.toString());
            daoResult = personDAO.delete(person);
            if (daoResult) alertMessage = "Persona borrada";                   
        } else 
            alertMessage = "Persona no encontrada"; 
        
        logger.info("daoResult: "+daoResult);
        return "redirect:/persons?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/person/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handlePersonActivation(@PathVariable int id) {
        logger.info("info.Inside handlePersonActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        Person person = personDAO.getPersonById(id);
        logger.info("person:"+person.toString()); 

        if (person != null) {
            if (person.getActive() == 'Y') person.setActive('N');
            else person.setActive('Y');
            daoResult = personDAO.update(person);
            if (daoResult) alertMessage = "Persona actualizada satisfactoriamente";
        } else 
            alertMessage = "Persona no encontrada"; 
        
        return alertMessage;
    }
}