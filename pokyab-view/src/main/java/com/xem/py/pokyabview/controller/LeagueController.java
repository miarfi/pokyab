package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.League;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.validator.LeagueValidator;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/league")
public class LeagueController {
    
    Logger logger = LoggerFactory.getLogger(LeagueController.class);
    
    @Autowired
    private LeagueDAO leagueDAO;  
    @Autowired
    private LookupValueDAO lookupValueDAO; 
 
    //Form Lists    
    @ModelAttribute("leagueCategoryCodes")
    public List<LookupValue> getLeagueCategoryCodes() {
        return lookupValueDAO.getLkpValuesByType("LEAGUE_CATEGORY_CODE", "");
    }      
    @ModelAttribute("leagueTypes")
    public List<LookupValue> getLeagueTypes() {
        return lookupValueDAO.getLkpValuesByType("LEAGUE_TYPE", "");
    }   
        
//    @RequestMapping(value = {"/leagues"})
//    public ModelAndView showAllLeagues(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
//        ModelAndView mv = new ModelAndView("team/teamMain");
//        mv.addObject("title", "Leagues");
//        mv.addObject("userClickLeagues", true);
//        mv.addObject("alertMessage", alertMessage);
//        return mv;
//    }
    
    //Url Mappings - Manage
//    @RequestMapping(value = {"/manage/league"})
//    public ModelAndView showManageLeague() {
//        ModelAndView mv = new ModelAndView("league/leagueMain");
//        mv.addObject("title", "League");
//        mv.addObject("userClickLeague", true);        
//        
//        //Init new League
//        League league = new League();
//        mv.addObject("league", league);                
//        return mv;
//    }
    
    @RequestMapping(value = {"/manage/league/{id}"})
    public ModelAndView showManageLeagueEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showManageLeagueEdit method");
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "League");
        mv.addObject("userClickLeague", true);   
        mv.addObject("alertMessage", alertMessage);
        
        //Get League object
        League league = leagueDAO.getLeagueById(id);
        mv.addObject("league", league);          
        return mv;
    }
    
    @RequestMapping(value="/manage/league", method=RequestMethod.POST)
    public String handleLeagueSubmission(@ModelAttribute League league,
            BindingResult result, Model model) {
        logger.info("En handleLeagueSubmission"); 
  
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
   
        //Spring Validator        
        new LeagueValidator().validate(league, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "League");
            model.addAttribute("userClickLeague", true);             
            return "team/teamMain";
        }
        
        if (league.getLeagueId() == 0) {
            daoResult = leagueDAO.add(league);
            if (daoResult) alertMessage = "Liga agregada";
        } else {
            daoResult = leagueDAO.update(league);
            if (daoResult) alertMessage = "Liga actualizada";
        }       
        if (daoResult) returnUrl = "redirect:/manage/team/?alertMessage="+alertMessage;
        else returnUrl = "redirect:/manage/league?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    
//    @RequestMapping(value="/manage/league/{id}/delete", method=RequestMethod.GET)
//    public String handleLeagueDelete(@PathVariable int id) {
//        logger.info("info.Inside handleLeagueDelete method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        League league = leagueDAO.getLeagueById(id);
//        if (league != null) {
//            logger.info("league: "+league.toString());
//            daoResult = leagueDAO.delete(league);
//            if (daoResult) alertMessage = "Liga borrado";                   
//        } else {
//            alertMessage = "Liga no encontrado"; 
//        }
//        logger.info("daoResult: "+daoResult);
//        return "redirect:/leagues?alertMessage=" + alertMessage;
//    }
   
////    @RequestMapping(value="/manage/league/{id}/activation", method=RequestMethod.GET)
//    @ResponseBody
//    public String handleLeagueActivation(@PathVariable int id) {
//        logger.info("info.Inside handleLeagueActivation method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        League league = leagueDAO.getLeagueById(id);
//        logger.info("league:"+league.toString()); 
//
//        if (league != null) {
//            if (league.getActive() == 'Y') league.setActive('N');
//            else league.setActive('Y');
//            daoResult = leagueDAO.update(league);
//            if (daoResult) alertMessage = "Liga actualizada satisfactoriamente";
//        } else {
//            alertMessage = "Liga no encontrado"; 
//        }
//        return alertMessage;
//    }
    
    
}
