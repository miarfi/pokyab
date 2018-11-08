package com.xem.py.pokyabview.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author arria
 */
@Controller
public class PageController {
    
    Logger logger = LoggerFactory.getLogger(PageController.class);
       
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login(@RequestParam(name="error", required=false)String error) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("title", "Login");
        if (error != null) {
             mv.addObject("message", "Invalido username/password");
        }
        return mv;
    }
    
    @RequestMapping(value = {"/", "/home"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Bienvenido a Pokyab");
        return mv;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Acerca de");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = {"/access-denied"})
    public ModelAndView accessDenied() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("title", "403 - Acceso denegado");
        mv.addObject("errorTitle", "No permitido!!!");
        mv.addObject("errorDescription", "No esta autorizado a ver esta pagina");
        return mv;
    }
    
    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact");
        mv.addObject("userClickContact", true);
        return mv;
    } 
}
