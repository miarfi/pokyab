
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.League;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Season;
import com.xem.py.pokyabmodel.dto.Team;
import com.xem.py.pokyabmodel.validator.TeamValidator;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */

@Controller
//@RequestMapping("/team")
public class TeamPersonController {
        
    Logger logger = LoggerFactory.getLogger(TeamController.class);
    
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private TeamDAO teamDAO;
 
    @Autowired
    private LookupValueDAO lookupValueDAO; 
        
     //Beans Modal
    @ModelAttribute("person")
    public Person getPerson() {
        return new Person();
    }
    
  

    //Form Lists    
    @ModelAttribute("leagueCategoryCodes")
    public List<LookupValue> getLeagueCategoryCodes() {
        return lookupValueDAO.getLkpValuesByType("LEAGUE_CATEGORY_CODE", "");
    }  
    
    @ModelAttribute("leagueTypes")
    public List<LookupValue> getLeagueTypes() {
        return lookupValueDAO.getLkpValuesByType("LEAGUE_TYPE", "");
    }   
    
    @ModelAttribute("genderCodes")
    public List<LookupValue> getGenderCodes() {
        return lookupValueDAO.getLkpValuesByType("GENDER_CODE", "");
    }
    
    @ModelAttribute("trainers")
    public List<Person> getTrainers() {
        return personDAO.getActivePersons();
    }



    @RequestMapping(value = {"/teams"})
    public ModelAndView showAllTeams(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "Teams");
        mv.addObject("userClickTeams", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    //Url Mappings - Manage
    @RequestMapping(value = {"/manage/team"})
    public ModelAndView showManageTeam() {
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "Team");
        mv.addObject("userClickTeam", true);        
        
        //Init new Team
        Team team = new Team();
        mv.addObject("team", team);                
        return mv;
    }

    @RequestMapping(value = {"/manage/team/{id}"})
    public ModelAndView showManageTeamEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showManageTeamEdit method");
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "Team");
        mv.addObject("userClickTeam", true);   
        mv.addObject("alertMessage", alertMessage);
        
        //Get Team object
        Team team = teamDAO.getTeamById(id);
        mv.addObject("team", team);          
        return mv;
    }
    
    @RequestMapping(value = {"/manage/team"}, method = RequestMethod.POST)
    public String handleTeamSubmission(@ModelAttribute Team team,
            BindingResult result, Model model) {
        logger.info("En handleTeamSubmission");    
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
   
        //Spring Validator        
        new TeamValidator().validate(team, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Team");
            model.addAttribute("userClickTeam", true);             
            return "team/teamMain";
        }
        
        if (team.getTeamId() == 0) {
            daoResult = teamDAO.add(team);
            if (daoResult) alertMessage = "Equipo agregado";
        } else {
            daoResult = teamDAO.update(team);
            if (daoResult) alertMessage = "Equipo actualizado";
        }       
        if (daoResult) returnUrl = "redirect:/manage/team/"+team.getTeamId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/teams?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/team/{id}/delete", method=RequestMethod.GET)
    public String handleTeamDelete(@PathVariable int id) {
        logger.info("info.Inside handleTeamDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Team team = teamDAO.getTeamById(id);
        if (team != null) {
            logger.info("team: "+team.toString());
            daoResult = teamDAO.delete(team);
            if (daoResult) alertMessage = "Equipo borrado";                   
        } else {
            alertMessage = "Equipo no encontrado"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/teams?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/team/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleTeamActivation(@PathVariable int id) {
        logger.info("info.Inside handleTeamActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        Team team = teamDAO.getTeamById(id);
        logger.info("team:"+team.toString()); 

        if (team != null) {
            if (team.getActive() == 'Y') team.setActive('N');
            else team.setActive('Y');
            daoResult = teamDAO.update(team);
            if (daoResult) alertMessage = "Equipo actualizada satisfactoriamente";
        } else {
            alertMessage = "Equipo no encontrado"; 
        }
        return alertMessage;
    }
        
    //
    //
    //ToDo Revisar donde dejar estos metodos y corregir
//    @RequestMapping(value="/manage/season", method=RequestMethod.POST)
//    public String handleSeasonSubmission(@ModelAttribute Season season) {
//        logger.info("En handleSeasonSubmission");  
//        String alertMessage = "";
//        boolean daoResult = false;        
//        daoResult = seasonDAO.ddd(season);
//        if (daoResult) alertMessage = "Temporada Agregada";
//        return "redirect:/manage/team?alertMessage="+alertMessage;
//    }    
}
