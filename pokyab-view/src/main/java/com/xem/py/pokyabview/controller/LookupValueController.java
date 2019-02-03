package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.validator.LookupValueValidator;
import java.util.List;
//import javax.ejb.EJBTransactionRolledbackException;
import javax.persistence.RollbackException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
//@RequestMapping("/lookupValue")
public class LookupValueController {

    Logger logger = LoggerFactory.getLogger(LookupValueController.class);
    @Autowired
    private LookupValueDAO lookupValueDAO;

    
    @RequestMapping(value = "/lookupValues", method = RequestMethod.GET)
    public @ResponseBody  List<LookupValue> LookupValuesForType(
            @RequestParam(value = "lookupType", required = true) String lookupType
            ,@RequestParam(value = "meaning", required = true) String meaning
    ) {
        logger.debug("finding lookupValues for type " + lookupType);
        return lookupValueDAO.getLkpValuesByType(lookupType, meaning);
    }
    
    @RequestMapping(value = {"/manage/lookupValue/{id}"})
    public ModelAndView showManageLookupValueEdit(@PathVariable int id) {
        logger.info("En showManageLookupValueEdit");
        ModelAndView mv = new ModelAndView("lookup/lookupMain");
        mv.addObject("title", "Editar Valor");
        mv.addObject("userClickManageLookupValue", true);

        //Get LookupValue object
        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
        mv.addObject("lookupValue", lookupValue);
        return mv;
    }

    @RequestMapping(value = {"/manage/lookupValue"}, method = RequestMethod.POST)
    public String handleLookupValueSubmission(@ModelAttribute LookupValue lookupValue,
             BindingResult result, Model model) {
        logger.info("En handleLookupValueSubmission");
        String alertMessage = "";
        boolean daoResult = false;

        //Spring Validator        
        new LookupValueValidator().validate(lookupValue, result);

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Valor");
            model.addAttribute("userClickManageLookupValue", true);
            return "lookup/lookupMain";
        }
        logger.info("lookupValue: " + lookupValue.toString());
        try {
            if (lookupValue.getLookupValueId() == 0) {
                daoResult = lookupValueDAO.add(lookupValue);
                if (daoResult)
                    alertMessage = "Valor agregado";                
            } else {
                daoResult = lookupValueDAO.update(lookupValue);
                if (daoResult)
                    alertMessage = "Valor actualizado";                
            }
        } catch (RollbackException e) {
            logger.info("error1: " + e.getMessage());
            daoResult = false;
            alertMessage = "Error en db";
        } catch (org.hibernate.exception.ConstraintViolationException  e){
            logger.info("error2: " + e.getMessage());
            daoResult = false;
            alertMessage = "Error en db";
//        } catch (EJBTransactionRolledbackException e){
//            logger.info("error3: " + e.getMessage());
//            daoResult = false;
//            alertMessage = "Error en db";
        } catch(DataIntegrityViolationException e) {
            logger.info("error4: " + e.getMessage());
            daoResult = false;
            alertMessage = "Error en db";
        }

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return "redirect:/manage/lookupType/" + lookupValue.getLookupTypeId() + "?alertMessage=" + alertMessage;
    }

    @RequestMapping(value = "/manage/lookupValue/{id}/delete", method = RequestMethod.GET)
    public String handleLookupValueDelete(@PathVariable int id) {
        logger.info("info.Inside handleLookupValueDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
        if (lookupValue != null) {
            logger.info("lookupValue: " + lookupValue.toString());
            daoResult = lookupValueDAO.delete(lookupValue);
            if (daoResult)
                alertMessage = "Valor borrado";            
        } else
            alertMessage = "Valor no encontrado";        

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return "redirect:/manage/lookupType/" + lookupValue.getLookupTypeId() + "?alertMessage=" + alertMessage;
    }

    @RequestMapping(value = "/manage/lookupValue/{id}/activation", method = RequestMethod.GET)
    @ResponseBody
    public String handleLookupValueActivation(@PathVariable int id) {
        logger.info("info.Inside handleLookupValueActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupValue lookupValue = lookupValueDAO.getLookupValueById(id);
        logger.info("lookupValue:" + lookupValue.toString());

        if (lookupValue != null) {
            if (lookupValue.getActive() == 'Y')
                lookupValue.setActive('N');
            else
                lookupValue.setActive('Y');            
            daoResult = lookupValueDAO.update(lookupValue);
            if (daoResult)
                alertMessage = "Valor actualizada satisfactoriamente";            
        } else
            alertMessage = "Valor no encontrada";        

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return alertMessage;
    }
}
