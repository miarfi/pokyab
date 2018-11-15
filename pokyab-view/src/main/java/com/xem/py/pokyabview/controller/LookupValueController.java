
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/lookupType")
public class LookupValueController {
    Logger logger = LoggerFactory.getLogger(LookupValueController.class);
    @Autowired
    private LookupValueDAO lookupValueDAO;   


//    @RequestMapping(value = {"/manage/{id}/person"})
//    public ModelAndView showManageLookupValueEdit(@PathVariable int id) {
//        logger.info("En showManageLookupValueEdit");
//        ModelAndView mv = new ModelAndView("page");
//        mv.addObject("title", "LookupValue");
//        mv.addObject("userClickLookupValue", true);
//        
//        //Get Person object
//        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
//        mv.addObject("lookupValue", lookupValue);        
//        return mv;
//    }    
    
    @RequestMapping(value = {"/manage/lookupValue"}, method = RequestMethod.POST)
    public String handleLookupTypeSubmission(@ModelAttribute LookupValue lookupValue) {
        logger.info("En handleLookupTypeSubmission"); 
        String alertMessage = "";
        boolean daoResult = false;         
        
        if (lookupValue.getLookupValueId() == 0) {
            lookupValue.setStartDate(new java.sql.Date(System.currentTimeMillis()));
            daoResult = lookupValueDAO.add(lookupValue); 
            if (daoResult)  alertMessage = "Valor agregado";
        } else {           
            daoResult = lookupValueDAO.update(lookupValue); 
            if (daoResult)  alertMessage = "Valor actualizado";
        }
        
        return "redirect:/manage/lookupType/"+lookupValue.getLookupTypeId()+"?alertMessage="+alertMessage;
    }      
    
    @RequestMapping(value="/manage/lookupValue/{id}/delete", method=RequestMethod.GET)
    public String handleLookupValueDelete(@PathVariable int id) {
        logger.info("info.Inside handleLookupValueDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
        if (lookupValue != null) {
            logger.info("lookupValue: "+lookupValue.toString());
            daoResult = lookupValueDAO.delete(lookupValue);
            if (daoResult) alertMessage = "Valor borrada";                   
        } else {
            alertMessage = "Valor no encontrado"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/manage/lookupType/"+lookupValue.getLookupTypeId()+"?alertMessage="+alertMessage;
    }
   
    @RequestMapping(value="/manage/lookupValue/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleLookupValueActivation(@PathVariable int id) {
        logger.info("info.Inside handleLookupValueActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
        logger.info("lookupValue:"+lookupValue.toString()); 

        if (lookupValue != null) {
            if (lookupValue.getActive() == 'Y') lookupValue.setActive('N');
            else lookupValue.setActive('Y');
            daoResult = lookupValueDAO.update(lookupValue);
            if (daoResult) alertMessage = "Valor actualizada satisfactoriamente";
        } else {
            alertMessage = "Valor no encontrada"; 
        }
        return alertMessage;
    }
}
