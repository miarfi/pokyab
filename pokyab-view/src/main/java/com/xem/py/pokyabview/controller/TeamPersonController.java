
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.TeamPersonDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.TeamPerson;
import com.xem.py.pokyabmodel.validator.TeamPersonValidator;
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
    private TeamPersonDAO teamPersonDAO;
 
    @Autowired
    private LookupValueDAO lookupValueDAO; 

    //Form Lists    
    @ModelAttribute("memberTypes")
    public List<LookupValue> getLeagueCategoryCodes() {
        return lookupValueDAO.getLkpValuesByType("MEMBER_TYPE", "");
    }  
    
    @ModelAttribute("positionCodes")
    public List<LookupValue> getLeagueTypes() {
        return lookupValueDAO.getLkpValuesByType("POSITION_CODE", "");
    }   
    
    @ModelAttribute("phisicCodes")
    public List<LookupValue> getGenderCodes() {
        return lookupValueDAO.getLkpValuesByType("PHISIC_CODE", "");
    }
    
    @ModelAttribute("players")
    public List<Person> getPlayers() {
        return personDAO.getActivePersons();
    }



    @RequestMapping(value = {"/teamPersons"})
    public ModelAndView showAllTeams(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "TeamPersons");
        mv.addObject("userClickTeamPersons", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    //Url Mappings - Manage
    @RequestMapping(value = {"/manage/teamPerson"})
    public ModelAndView showManageTeam() {
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "TeamPerson");
        mv.addObject("userClickTeamPerson", true);        
        
        //Init new TeamPerson
        TeamPerson teamPerson = new TeamPerson();
        mv.addObject("teamPerson", teamPerson);                
        return mv;
    }

    @RequestMapping(value = {"/manage/teamPerson/{id}"})
    public ModelAndView showManageTeamPersonEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showManageTeamPersonEdit method");
        ModelAndView mv = new ModelAndView("team/teamMain");
        mv.addObject("title", "TeamPerson");
        mv.addObject("userClickTeamPerson", true);   
        mv.addObject("alertMessage", alertMessage);
        
        //Get Team object
        TeamPerson teamPerson = teamPersonDAO.getTeamPersonById(id);
        mv.addObject("teamPerson", teamPerson);          
        return mv;
    }
    
    @RequestMapping(value = {"/manage/teamPerson"}, method = RequestMethod.POST)
    public String handleTeamPersonSubm(@ModelAttribute TeamPerson teamPerson,
            BindingResult result, Model model) {
        logger.info("En handleTeamPersonSubm");    
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
   
        //Spring Validator        
        new TeamPersonValidator().validate(teamPerson, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "TeamPerson");
            model.addAttribute("userClickTeamPerson", true);             
            return "team/teamMain";
        }
        
        if (teamPerson.getTeamPersonId() == 0) {
            daoResult = teamPersonDAO.add(teamPerson);
            if (daoResult) alertMessage = "Persona agregado";
        } else {
            daoResult = teamPersonDAO.update(teamPerson);
            if (daoResult) alertMessage = "Persona actualizado";
        }       
        if (daoResult) returnUrl = "redirect:/manage/teamPerson/"+teamPerson.getTeamPersonId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/teamPersons?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/teamPerson/{id}/delete", method=RequestMethod.GET)
    public String handleTeamPersonDelete(@PathVariable int id) {
        logger.info("info.Inside handleTeamPersonDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        TeamPerson teamPerson = teamPersonDAO.getTeamPersonById(id);
        if (teamPerson != null) {
            logger.info("teamPerson: "+teamPerson.toString());
            daoResult = teamPersonDAO.delete(teamPerson);
            if (daoResult) alertMessage = "Persona borrado";                   
        } else {
            alertMessage = "Persona no encontrado"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/teamPersons?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/teamPerson/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleTeamPersonActiv(@PathVariable int id) {
        logger.info("info.Inside handleTeamPersonActiv method");
        String alertMessage = "";
        boolean daoResult = false;
        TeamPerson teamPerson = teamPersonDAO.getTeamPersonById(id);
        logger.info("teamPerson:"+teamPerson.toString()); 

        if (teamPerson != null) {
            if (teamPerson.getActive() == 'Y') teamPerson.setActive('N');
            else teamPerson.setActive('Y');
            daoResult = teamPersonDAO.update(teamPerson);
            if (daoResult) alertMessage = "Persona actualizada satisfactoriamente";
        } else {
            alertMessage = "Persona no encontrado"; 
        }
        return alertMessage;
    }
       
}
