
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/lookupType")
public class LookupValueController {
    Logger logger = LoggerFactory.getLogger(LookupTypeController.class);
    @Autowired
    private LookupValueDAO lookupValueDAO;   


    @RequestMapping(value = {"/manage/lookupValue"}, method = RequestMethod.POST)
    public String handleLookupTypeSubmission(@ModelAttribute LookupValue lookupValue) {
        logger.info("En handleLookupTypeSubmission"); 
        String alertMessage = "";
        boolean daoResult = false;         
        
        if (lookupValue.getLookupTypeId() == 0) {
            lookupValue.setStartDate(new java.sql.Date(System.currentTimeMillis()));
            daoResult = lookupValueDAO.add(lookupValue); 
            if (daoResult)  alertMessage = "Valor agregado";
        } else {           
            daoResult = lookupValueDAO.update(lookupValue); 
            if (daoResult)  alertMessage = "Valor actualizado";
        }
        
        return "redirect:/manage/"+lookupValue.getLookupTypeId()+"/lookupType?alertMessage="+alertMessage;
    }    
}
