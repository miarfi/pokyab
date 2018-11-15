
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.League;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Season;
import com.xem.py.pokyabmodel.dto.Team;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/team")
public class TeamController {
        
    Logger logger = LoggerFactory.getLogger(TeamController.class);
    
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private SeasonDAO seasonDAO;
    @Autowired
    private LeagueDAO leagueDAO;  
    
     //Beans Modals Team
    @ModelAttribute("person")
    public Person getPerson() {
        return new Person();
    }
    
    @ModelAttribute("league")
    public League getLeague() {
        return new League();
    }
    
    @ModelAttribute("season")
    public Season getSeason() {
        return new Season();
    }    

    //Form Lists
    @ModelAttribute("trainers")
    public List<Person> getTrainers() {
        return personDAO.getActivePersons();
    }

    @ModelAttribute("leagues")
    public List<League> getLeagues() {
        return leagueDAO.getActiveLeagues();
    }
    
    @ModelAttribute("seasons")
    public List<Season> getSeasons() {
        return seasonDAO.getActiveSeasons();
    }
    
    @RequestMapping(value = {"/teams"})
    public ModelAndView showAllTeams() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Teams");
        mv.addObject("userClickTeams", true);
        return mv;
    }
    
    //Url Mappings - Manage
    @RequestMapping(value = {"/manage/team"})
    public ModelAndView showManageTeam() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Team");
        mv.addObject("userClickTeam", true);        
        
        //Init new Team
        Team team = new Team();
        mv.addObject("team", team);                
        return mv;
    }

    @RequestMapping(value = {"/manage/{id}/team"})
    public ModelAndView showManageTeamEdit(@PathVariable int id) {
        logger.info("info.Inside showManageTeamEdit method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Team");
        mv.addObject("userClickTeam", true);        
        
        //Get Team object
        Team team = teamDAO.getTeamById(id);
        mv.addObject("team", team);          
        return mv;
    }
    
    @RequestMapping(value = {"/manage/team"}, method = RequestMethod.POST)
    public String handleTeamSubmission(@ModelAttribute Team team) {
        logger.info("En handleTeamSubmission");    
        String alertMessage = "";
        boolean daoResult = false;
   
        if (team.getTeamId() == 0) {
            daoResult = teamDAO.add(team);
            if (daoResult) alertMessage = "Equipo agregado";
        } else {
            daoResult = teamDAO.update(team);
            if (daoResult) alertMessage = "Equipo actualizado";
        }       
        
        return "redirect:/teams?alertMessage="+alertMessage;
    }
       
    //ToDo Revisar donde dejar estos metodos y corregir
    @RequestMapping(value="/manage/league", method=RequestMethod.POST)
    public String handleLeagueSubmission(@ModelAttribute League league) {
        logger.info("En handleLeagueSubmission"); 
        String alertMessage = "";
        boolean daoResult = false;
        daoResult = leagueDAO.Add(league);
        if (daoResult) alertMessage = "Liga Agregada";
        return "redirect:/manage/team?alertMessage="+alertMessage;
    }
    
    //ToDo Revisar donde dejar estos metodos y corregir
    @RequestMapping(value="/manage/season", method=RequestMethod.POST)
    public String handleSeasonSubmission(@ModelAttribute Season season) {
        logger.info("En handleSeasonSubmission");  
        String alertMessage = "";
        boolean daoResult = false;        
        daoResult = seasonDAO.Add(season);
        if (daoResult) alertMessage = "Temporada Agregada";
        return "redirect:/manage/team?alertMessage="+alertMessage;
    }    

}
