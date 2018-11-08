package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupTypeDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import com.xem.py.pokyabmodel.dto.LookupValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/lookupType")
public class LookupTypeController {

    Logger logger = LoggerFactory.getLogger(LookupTypeController.class);

    @Autowired
    private LookupTypeDAO lookupTypeDAO;

    //Beans Modal
    @ModelAttribute("lookupType")
    public LookupType getLookupType() {
        return new LookupType();
    }

    @RequestMapping(value = {"/lookupTypes"})
    public ModelAndView showAllLookuptypes(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showAllLookuptypes");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Lookup Types");
        mv.addObject("userClickLookupTypes", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }    

    @RequestMapping(value = {"/manage/{id}/lookupType"})
    public ModelAndView showManageLookupTypeEdit(@PathVariable int id) {
        logger.info("En showManageLookupTypeEdit");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Lookup Type");
        mv.addObject("userClickManageLookupType", true);
        
        //Get LookupType object
        LookupType lookupType = lookupTypeDAO.getLookupTypeById(id);
        mv.addObject("lookupType", lookupType);
        
        //Init new lookupValue
        LookupValue lookupValue = new LookupValue();
        lookupValue.setLookupTypeId(id);
        mv.addObject("lookupValue", lookupValue);
        return mv;
    }
    
    //Url Mappings - POST
    @RequestMapping(value = {"/manage/lookupType"}, method = RequestMethod.POST)
    public String handleLookupTypeSub(@ModelAttribute LookupType lookupType) {
        logger.info("En handleLookupTypeSub");
        String alertMessage = "";
        boolean daoResult = false;

        if (lookupType.getLookupTypeId() == 0) {
            lookupType.setStartDate(new java.sql.Date(System.currentTimeMillis()));
            daoResult = lookupTypeDAO.add(lookupType);
            if (daoResult) alertMessage = "Catalogo agregado";
        } else {
            daoResult = lookupTypeDAO.update(lookupType);
            if (daoResult) alertMessage = "Catalogo actualizado";
        }
        return "redirect:/lookupTypes?alertMessage=" + alertMessage;
    }    
}
