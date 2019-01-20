package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.UserDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.User;
import com.xem.py.pokyabmodel.validator.UserValidator;
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
public class UserController{
    
    Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LookupValueDAO lookupValueDAO; 
    
//    @ModelAttribute("maritalStatusCodes")
//    public List<LookupValue> getMaritalStatusCodes() {
//        return lookupValueDAO.getLkpValuesByType("MARITAL_STATUS_CODE", "");
//    }
    
    @RequestMapping(value = {"/users"})
    public ModelAndView showAllUsers(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllUsers method");
        ModelAndView mv = new ModelAndView("user/userMain");
        mv.addObject("title", "Users");
        mv.addObject("userClickUsers", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    @RequestMapping(value={"/manage/user"})
    public ModelAndView showManageUser() {
        ModelAndView mv = new ModelAndView("user/userMain");
        mv.addObject("title", "User");
        mv.addObject("userClickUser", true);        
        
        //Init new User
        User user = new User();
        mv.addObject("user", user);                
        return mv;
    }
    
    @RequestMapping(value = {"/manage/user/{id}"})
    public ModelAndView showManageUserEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showManageUserEdit");
        ModelAndView mv = new ModelAndView("user/userMain");
        mv.addObject("title", "User");
        mv.addObject("userClickUser", true);
        mv.addObject("alertMessage", alertMessage);
        
        //Get User object
        User user = userDAO.getUserById(id);
        mv.addObject("user", user);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/user", method=RequestMethod.POST)
    public String handleUserSubmission(@ModelAttribute User user
            ,HttpServletRequest request,BindingResult result, Model model) {
        logger.info("info.Inside handleUserSubmission method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl = "";
        logger.info("user:"+user.toString());
        
        //Spring Validator        
        new UserValidator().validate(user, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Usuario");
            model.addAttribute("userClickUser", true);             
            return "user/userMain";
        }
        
        if (user.getUserId() == 0) {
            daoResult = userDAO.add(user);
            if (daoResult) alertMessage = "Usuario agregada";            
        } else {
            daoResult = userDAO.update(user);
            if (daoResult) alertMessage = "Usuario modificada"; 
        }
               
        
        if (daoResult) returnUrl = "redirect:/manage/user/"+user.getUserId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/users?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/user/{id}/delete", method=RequestMethod.GET)
    public String handleUserDelete(@PathVariable int id) {
        logger.info("info.Inside handleUserDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        User user = userDAO.getUserById(id);
        if (user != null) {
            logger.info("user: "+user.toString());
            daoResult = userDAO.delete(user);
            if (daoResult) alertMessage = "Usuario borrada";                   
        } else {
            alertMessage = "Usuario no encontrada"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/users?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/user/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleUserActivation(@PathVariable int id) {
        logger.info("info.Inside handleUserActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        User user = userDAO.getUserById(id);
        logger.info("user:"+user.toString()); 

        if (user != null) {
            if (user.isEnabled()) user.setEnabled(false);
            else user.setEnabled(true);
            daoResult = userDAO.update(user);
            if (daoResult) alertMessage = "Usuario actualizada satisfactoriamente";
        } else {
            alertMessage = "Usuario no encontrada"; 
        }
        return alertMessage;
    }
}
