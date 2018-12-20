package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupUseDAO;
import com.xem.py.pokyabmodel.dto.LookupUse;
import com.xem.py.pokyabmodel.validator.LookupUseValidator;
import com.xem.py.pokyabmodel.view.TableColumnV;
import com.xem.py.pokyabmodel.view.TableV;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
//@RequestMapping("/lookupUse")
public class LookupUseController {

    Logger logger = LoggerFactory.getLogger(LookupUseController.class);
    @Autowired
    private LookupUseDAO lookupUseDAO;

    @ModelAttribute("tables")
    public List<TableV> getTables() {
        return lookupUseDAO.getTableList();
    }
    
    //Form Lists
//    @ModelAttribute("tableColumns")
//    public List<TableColumnV> getTableColumns() {
//        return lookupUseDAO.getTableColumnList();
//    }   
    
    @RequestMapping(value = "/tableColumns", method = RequestMethod.GET)
    public @ResponseBody  List<TableColumnV> columnsForTable(@ModelAttribute("lookupUse") LookupUse lookupUse
            ,@RequestParam(value = "tableName", required = true) String tableName
            ,ModelMap modelMap) {
        logger.debug("finding columns for table " + tableName);
        return lookupUseDAO.getTableColumnList(tableName);
    }

    @RequestMapping(value = {"/manage/lookupUse/{id}"})
    public ModelAndView showManageLookupUseEdit(@PathVariable int id) {
        logger.info("En showManageLookupUseEdit");
        ModelAndView mv = new ModelAndView("lookup/lookupMain");
        mv.addObject("title", "Editar Uso");
        mv.addObject("userClickManageLookupUse", true);

        //Get LookupUse object
        LookupUse lookupUse = lookupUseDAO.getLookupUseById(id);
        mv.addObject("lookupUse", lookupUse);
        logger.info("lookupUse "+lookupUse);
        
        //Get columns for table
        if (lookupUse.getTableName().length() > 0){            
            List<TableColumnV> tableColumns = lookupUseDAO.getTableColumnList(lookupUse.getTableName());
            logger.info("tableColumns "+tableColumns.size());
            mv.addObject("tableColumns", tableColumns);
        }
            
        return mv;
    }

    @RequestMapping(value = {"/manage/lookupUse"}, method = RequestMethod.POST)
    public String handleLookupUseSubmission(@ModelAttribute LookupUse lookupUse,
            BindingResult result, Model model) {
        logger.info("En handleLookupUseSubmission");
        String alertMessage = "";
        boolean daoResult = false;

        //Spring Validator        
        new LookupUseValidator().validate(lookupUse, result);

        if (result.hasErrors()) {
            model.addAttribute("title", "Editar Uso");
            model.addAttribute("userClickManageLookupUse", true);
            return "lookup/lookupMain";
        }
        logger.info("lookupUse: " + lookupUse.toString());
        try {
            if (lookupUse.getLookupUseId() == 0) {
//                lookupUse.setStartDate(new java.sql.Date(System.currentTimeMillis()));
                daoResult = lookupUseDAO.add(lookupUse);
                if (daoResult) {
                    alertMessage = "Uso agregado";
                }
            } else {
                daoResult = lookupUseDAO.update(lookupUse);
                if (daoResult) {
                    alertMessage = "Uso actualizado";
                }
            }
        } catch (ConstraintViolationException e) {
            logger.info("error: " + e.getMessage());
            daoResult = false;
            alertMessage = "Error en db";
        }

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return "redirect:/manage/lookupType/" + lookupUse.getLookupTypeId() + "?alertMessage=" + alertMessage;
    }

    @RequestMapping(value = "/manage/lookupUse/{id}/delete", method = RequestMethod.GET)
    public String handleLookupUseDelete(@PathVariable int id) {
        logger.info("info.Inside handleLookupUseDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupUse lookupUse = lookupUseDAO.getLookupUseById(id);
        if (lookupUse != null) {
            logger.info("lookupUse: " + lookupUse.toString());
            daoResult = lookupUseDAO.delete(lookupUse);
            if (daoResult) {
                alertMessage = "Uso borrado";
            }
        } else {
            alertMessage = "Uso no encontrado";
        }

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return "redirect:/manage/lookupType/" + lookupUse.getLookupTypeId() + "?alertMessage=" + alertMessage;
    }

    @RequestMapping(value = "/manage/lookupUse/{id}/activation", method = RequestMethod.GET)
    @ResponseBody
    public String handleLookupUseActivation(@PathVariable int id) {
        logger.info("info.Inside handleLookupUseActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        LookupUse lookupUse = lookupUseDAO.getLookupUseById(id);
        logger.info("lookupUse:" + lookupUse.toString());

        if (lookupUse != null) {
            if (lookupUse.isActive()) {
                lookupUse.setActive(false);
            } else {
                lookupUse.setActive(true);
            }
            daoResult = lookupUseDAO.update(lookupUse);
            if (daoResult) {
                alertMessage = "Uso actualizado satisfactoriamente";
            }
        } else {
            alertMessage = "Uso no encontrado";
        }

        logger.info("daoResult: " + daoResult + " alertMessage: " + alertMessage);
        return alertMessage;
    }
}
