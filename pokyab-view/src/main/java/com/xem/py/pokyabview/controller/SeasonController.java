
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dto.Season;
import com.xem.py.pokyabmodel.validator.SeasonValidator;
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
//@RequestMapping("/season")
public class SeasonController {
        
    Logger logger = LoggerFactory.getLogger(SeasonController.class);
    
    @Autowired
    private SeasonDAO seasonDAO;   

//    @RequestMapping(value = {"/seasons"})
//    public ModelAndView showAllSeasons(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
//        ModelAndView mv = new ModelAndView("season/seasonMain");
//        mv.addObject("title", "Seasons");
//        mv.addObject("userClickSeasons", true);
//        mv.addObject("alertMessage", alertMessage);
//        return mv;
//    }
    
    //Url Mappings - Manage
//    @RequestMapping(value = {"/manage/season"})
//    public ModelAndView showManageSeason() {
//        ModelAndView mv = new ModelAndView("season/seasonMain");
//        mv.addObject("title", "Season");
//        mv.addObject("userClickSeason", true);        
//        
//        //Init new Season
//        Season season = new Season();
//        mv.addObject("season", season);                
//        return mv;
//    }

    @RequestMapping(value = {"/manage/season/{id}"})
    public ModelAndView showManageSeasonEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showManageSeasonEdit method");
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "Season");
        mv.addObject("userClickSeason", true);   
        mv.addObject("alertMessage", alertMessage);
        
        //Get Season object
        Season season = seasonDAO.getSeasonById(id);
        mv.addObject("season", season);          
        return mv;
    }
    
    @RequestMapping(value = {"/manage/season"}, method = RequestMethod.POST)
    public String handleSeasonSubmission(@ModelAttribute Season season,
            BindingResult result, Model model) {
        logger.info("En handleSeasonSubmission");    
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
   
        //Spring Validator        
        new SeasonValidator().validate(season, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Season");
            model.addAttribute("userClickSeason", true);             
            return "team/teamMain";
        }
        
        if (season.getSeasonId() == 0) {
            daoResult = seasonDAO.add(season);
            if (daoResult) alertMessage = "Equipo agregado";
        } else {
            daoResult = seasonDAO.update(season);
            if (daoResult) alertMessage = "Equipo actualizado";
        }       
        if (daoResult) returnUrl = "redirect:/team/manage/"+season.getSeasonId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/seasons?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
//    @RequestMapping(value="/manage/season/{id}/delete", method=RequestMethod.GET)
//    public String handleSeasonDelete(@PathVariable int id) {
//        logger.info("info.Inside handleSeasonDelete method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        Season season = seasonDAO.getSeasonById(id);
//        if (season != null) {
//            logger.info("season: "+season.toString());
//            daoResult = seasonDAO.delete(season);
//            if (daoResult) alertMessage = "Equipo borrado";                   
//        } else {
//            alertMessage = "Equipo no encontrado"; 
//        }
//        logger.info("daoResult: "+daoResult);
//        return "redirect:/seasons?alertMessage=" + alertMessage;
//    }
   
//    @RequestMapping(value="/manage/season/{id}/activation", method=RequestMethod.GET)
//    @ResponseBody
//    public String handleSeasonActivation(@PathVariable int id) {
//        logger.info("info.Inside handleSeasonActivation method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        Season season = seasonDAO.getSeasonById(id);
//        logger.info("season:"+season.toString()); 
//
//        if (season != null) {
//            if (season.getActive() == 'Y') season.setActive('N');
//            else season.setActive('Y');
//            daoResult = seasonDAO.update(season);
//            if (daoResult) alertMessage = "Equipo actualizada satisfactoriamente";
//        } else {
//            alertMessage = "Equipo no encontrado"; 
//        }
//        return alertMessage;
//    }
}
