package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupTypeDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.validator.LookupTypeValidator;
import javax.validation.Valid;
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
//@RequestMapping("/lookupType")
public class LookupTypeController {

    Logger logger = LoggerFactory.getLogger(LookupTypeController.class);

    @Autowired
    private LookupTypeDAO lookupTypeDAO;
//    @Autowired
//    @Qualifier("lookupTypeValidator")
//    private Validator lookupTypeValidator;

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(lookupTypeValidator);
//    }
    
    //Beans Modal
    @ModelAttribute("lookupType")
    public LookupType getLookupType() {
        logger.info("En getLookupType");
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

    @RequestMapping(value = {"/manage/lookupType/{id}"})
    public ModelAndView showManageLookupTypeEdit(@PathVariable int id
        ,@RequestParam(name="alertMessage", required=false)String alertMessage) {
        logger.info("En showManageLookupTypeEdit");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Lookup Type");        
        mv.addObject("userClickManageLookupType", true);
        mv.addObject("alertMessage", alertMessage);
        
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
    public String handleLookupTypeSub(@Valid @ModelAttribute("lookupType")  LookupType lookupType,
            BindingResult result, Model model) {
        
        logger.info("En handleLookupTypeSub");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
        
        //Spring Validator        
        new LookupTypeValidator().validate(lookupType, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "LookupType");
            model.addAttribute("userClickManageLookupType", true);             
            return "page";
        }
        
        if (lookupType.getLookupTypeId() == 0) {
            daoResult = lookupTypeDAO.add(lookupType);
            if (daoResult) alertMessage = "Catalogo agregado";
        } else {
            daoResult = lookupTypeDAO.update(lookupType);
            if (daoResult) alertMessage = "Catalogo actualizado";
        }
        
        if (daoResult) returnUrl = "redirect:/manage/lookupType/"+lookupType.getLookupTypeId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/lookupTypes?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }  
    
    @RequestMapping(value="/manage/lookupType/{id}/delete", method=RequestMethod.GET)
    public String handleLookupTypeDelete(@PathVariable int id) {
        logger.info("info.Inside handleLookupTypeDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupType lookupType = lookupTypeDAO.getLookupTypeById(id);
        
        if (lookupType != null) {
            logger.info("lookupType: "+lookupType.toString());
            daoResult = lookupTypeDAO.delete(lookupType);
            if (daoResult) alertMessage = "Catalogo borrado";                   
        } else {
            alertMessage = "Catalogo no encontrado"; 
        }
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return "redirect:/lookupTypes?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/lookupType/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleLookupTypeActivation(@PathVariable int id) {
        logger.info("info.Inside handleLookupTypeActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupType lookupType = lookupTypeDAO.getLookupTypeById(id);
        logger.info("lookupType:"+lookupType.toString()); 

        if (lookupType != null) {
            if (lookupType.getActive() == 'Y') lookupType.setActive('N');
            else lookupType.setActive('Y');
            daoResult = lookupTypeDAO.update(lookupType);
            if (daoResult) alertMessage = "Catalogo actualizado satisfactoriamente";
        } else {
            alertMessage = "Catalogo no encontrado"; 
        }
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return alertMessage;
    }
}