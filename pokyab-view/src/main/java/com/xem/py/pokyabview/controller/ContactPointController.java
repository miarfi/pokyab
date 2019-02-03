
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.ContactPointDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.ContactPoint;
import com.xem.py.pokyabmodel.validator.ContactPointValidator;
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
public class ContactPointController {
        Logger logger = LoggerFactory.getLogger(ContactPointController.class);
    
    @Autowired
    private ContactPointDAO contactPointDAO;  
    @Autowired
    private LookupValueDAO lookupValueDAO; 
    
    //Form Lists
    @ModelAttribute("contactPointTypes")
    public List<LookupValue> getContactPointTypes() {
        return lookupValueDAO.getLkpValuesByType("CONTACT_POINT_TYPE", "");
    }

    @ModelAttribute("contactUseTypes")
    public List<LookupValue> getContactUseTypes() {
        return lookupValueDAO.getLkpValuesByType("CP_USE_TYPE", "");
    }    
       
    @RequestMapping(value = {"/contactPoints"})
    public ModelAndView showAllContactPoints(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllContactPoints method");
        ModelAndView mv = new ModelAndView("contactPoint/contactPointMain");
        mv.addObject("title", "ContactPoints");
        mv.addObject("userClickContactPoints", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    @RequestMapping(value={"/manage/contactPoint"})
    public ModelAndView showManageContactPoint() {
        ModelAndView mv = new ModelAndView("contactPoint/contactPointMain");
        mv.addObject("title", "ContactPoint");
        mv.addObject("userClickContactPoint", true);        
        
        //Init new ContactPoint
        ContactPoint contactPoint = new ContactPoint();
        mv.addObject("contactPoint", contactPoint);                
        return mv;
    }
    
    @RequestMapping(value = {"/manage/contactPoint/{id}"})
    public ModelAndView showManageContactPointEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showManageContactPointEdit");
        ModelAndView mv = new ModelAndView("contactPoint/contactPointMain");
        mv.addObject("title", "ContactPoint");
        mv.addObject("userClickContactPoint", true);
        mv.addObject("alertMessage", alertMessage);
        
        //Get ContactPoint object
        ContactPoint contactPoint = contactPointDAO.getContactPointById(id);
        mv.addObject("contactPoint", contactPoint);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/contactPoint", method=RequestMethod.POST)
    public String handleContactPointSubmission(@ModelAttribute ContactPoint contactPoint
            ,HttpServletRequest request,BindingResult result, Model model) {
        logger.info("info.Inside handleContactPointSubmission method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl = "";
        logger.info("contactPoint:"+contactPoint.toString());
        
        //Spring Validator        
        new ContactPointValidator().validate(contactPoint, result);        
        logger.info("Errores"+result.getErrorCount());
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Punto de Contacto");
            model.addAttribute("userClickContactPoint", true);             
            return "contactPoint/contactPointMain";
        }
        
        if (contactPoint.getContactPointId() == 0) {
            daoResult = contactPointDAO.add(contactPoint);
            if (daoResult) alertMessage = "Punto de Contacto agregada";            
        } else {
            daoResult = contactPointDAO.update(contactPoint);
            if (daoResult) alertMessage = "Punto de Contacto modificada"; 
        }
        
        if (daoResult) returnUrl = "redirect:/manage/contactPoint/"+contactPoint.getContactPointId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/contactPoints?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/contactPoint/{id}/delete", method=RequestMethod.GET)
    public String handleContactPointDelete(@PathVariable int id) {
        logger.info("info.Inside handleContactPointDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        ContactPoint contactPoint = contactPointDAO.getContactPointById(id);
        if (contactPoint != null) {
            logger.info("contactPoint: "+contactPoint.toString());
            daoResult = contactPointDAO.delete(contactPoint);
            if (daoResult) alertMessage = "Punto de Contacto borrado";                   
        } else 
            alertMessage = "Punto de Contacto no encontrado"; 
        
        logger.info("daoResult: "+daoResult);
        return "redirect:/contactPoints?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/contactPoint/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleContactPointActivation(@PathVariable int id) {
        logger.info("info.Inside handleContactPointActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        ContactPoint contactPoint = contactPointDAO.getContactPointById(id);
        logger.info("contactPoint:"+contactPoint.toString()); 

        if (contactPoint != null) {
            if (contactPoint.getActive() == 'Y') contactPoint.setActive('N');
            else contactPoint.setActive('Y');
            daoResult = contactPointDAO.update(contactPoint);
            if (daoResult) alertMessage = "Punto de Contacto actualizada satisfactoriamente";
        } else 
            alertMessage = "Punto de Contacto no encontrado"; 
        
        return alertMessage;
    }

}