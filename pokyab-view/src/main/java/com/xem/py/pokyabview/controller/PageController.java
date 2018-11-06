package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.LookupType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author arria
 */
@Controller
public class PageController {
    
    Logger logger = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private TrainingDAO trainingDAO;
    @Autowired
    private ActivityDAO activityDAO;
    
    //Beans Modal
    @ModelAttribute("lookupType")
    public LookupType getLookupType() {
        return new LookupType();
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
    
    @RequestMapping(value = {"/players"})
    public ModelAndView showAllPersons() {
        logger.info("info.Inside showAllPersons method");
        logger.debug("debug.Inside showAllPersons method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Players");
        mv.addObject("userClickPlayers", true);
        //ToDo Crear metodo getActivePlayers
//        mv.addObject("persons", personDAO.getActivePersons());
        return mv;
    }
    
    @RequestMapping(value = {"/teams"})
    public ModelAndView showAllTeams() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Teams");
        mv.addObject("userClickTeams", true);
//        mv.addObject("teams", teamDAO.getAllTeams());
        return mv;
    }
    
    @RequestMapping(value = {"/activities"})
    public ModelAndView showAllActivities() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Activities");
        mv.addObject("userClickActivities", true);
//        mv.addObject("activities", activityDAO.getAllActivities());
        return mv;
    }    

    @RequestMapping(value = {"/trainings"})
    public ModelAndView showAllTrainings() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Trainings");
        mv.addObject("userClickTrainings", true);
//        mv.addObject("trainings", trainingDAO.getAllTrainings());
        return mv;
    }  
    
    @RequestMapping(value = {"/lookupTypes"})
    public ModelAndView showAllLookuptypes() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Lookup Types");
        mv.addObject("userClickLookupTypes", true);
//        mv.addObject("l", trainingDAO.getAllTrainings());
        return mv;
    }     
}
