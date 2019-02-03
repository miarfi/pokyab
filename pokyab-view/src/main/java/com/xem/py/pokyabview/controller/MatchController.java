
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dao.MatchDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dto.League;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Season;
import com.xem.py.pokyabmodel.dto.Match;
import com.xem.py.pokyabmodel.dto.Team;
import com.xem.py.pokyabmodel.validator.MatchValidator;
import com.xem.py.pokyabmodel.view.MatchV;
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
//@RequestMapping("/match")
public class MatchController {
   Logger logger = LoggerFactory.getLogger(MatchController.class);
    
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private MatchDAO matchDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private SeasonDAO seasonDAO;
    @Autowired
    private LeagueDAO leagueDAO;
    @Autowired
  
    private LookupValueDAO lookupValueDAO; 
       
     //Beans Modal
//    @ModelAttribute("person")
//    public Person getPerson() {
//        return new Person();
//    }
//    
    //
    @ModelAttribute("matchStatus")
    public List<LookupValue> getMatchStatus() {
        return lookupValueDAO.getLkpValuesByType("MATCH_STATUS", "");
    }
    
        
    //Lovs
    @ModelAttribute("persons")
    public List<Person> getPersons() {
        return personDAO.getAvailablePersons();
    }
    
    @ModelAttribute("teams")
    public List<Team> getTeams() {
        return teamDAO.getActiveTeams();
    }
       
    @ModelAttribute("leagues")
    public List<League> getLeagues() {
        return leagueDAO.getActiveLeagues();
    }
    
    @ModelAttribute("seasons")
    public List<Season> getSeasons() {
        return seasonDAO.getActiveSeasons();
    }
    
    @RequestMapping(value = {"/matchs"})
    public ModelAndView showAllMatchs(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        ModelAndView mv = new ModelAndView("match/matchMain");
        mv.addObject("title", "Matchs");
        mv.addObject("userClickMatchs", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    //Url Mappings - Manage
    @RequestMapping(value = {"/manage/match"})
    public ModelAndView showManageMatch() {
        ModelAndView mv = new ModelAndView("match/matchMain");
        mv.addObject("title", "Match");
        mv.addObject("userClickMatch", true);        
        
        //Init new Match
        Match match = new Match();
        mv.addObject("match", match);                
        return mv;
    }

    @RequestMapping(value = {"/manage/match/{id}"})
    public ModelAndView showManageMatchEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showManageMatchEdit method");
        ModelAndView mv = new ModelAndView("match/matchMain");
        mv.addObject("title", "Match");
        mv.addObject("userClickMatch", true);   
        mv.addObject("alertMessage", alertMessage);
        
        //Get Match object
        Match match = matchDAO.getMatchById(id);
        mv.addObject("match", match);          
        return mv;
    }
    
    @RequestMapping(value = {"/manage/match"}, method = RequestMethod.POST)
    public String handleMatchSubmission(@ModelAttribute Match match,
            BindingResult result, Model model) {
        logger.info("En handleMatchSubmission");    
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;
   
        //Spring Validator        
        new MatchValidator().validate(match, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Match");
            model.addAttribute("userClickMatch", true);  
             logger.info("Errores");
            return "match/matchMain";
        }
        
        if (match.getMatchId() == 0) {
            daoResult = matchDAO.add(match);
           
            if (daoResult) alertMessage = "Encuentro agregado";
        } else {
            daoResult = matchDAO.update(match);
            if (daoResult) alertMessage = "Encuentro actualizado";
        }       
        if (daoResult) returnUrl = "redirect:/manage/match/"+match.getMatchId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/matchs?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/match/{id}/delete", method=RequestMethod.GET)
    public String handleMatchDelete(@PathVariable int id) {
        logger.info("info.Inside handleMatchDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Match match = matchDAO.getMatchById(id);
        if (match != null) {
            logger.info("match: "+match.toString());
            daoResult = matchDAO.delete(match);
            if (daoResult) alertMessage = "Encuentro borrado";                   
        } else {
            alertMessage = "Encuentro no encontrado"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/matchs?alertMessage=" + alertMessage;
    }
   
//    @RequestMapping(value="/manage/match/{id}/activation", method=RequestMethod.GET)
//    @ResponseBody
//    public String handleMatchActivation(@PathVariable int id) {
//        logger.info("info.Inside handleMatchActivation method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        Match match = matchDAO.getMatchById(id);
//        logger.info("match:"+match.toString()); 
//
//        if (match != null) {
//            if (match.getActive() == 'Y') match.setActive('N');
//            else match.setActive('Y');
//            daoResult = matchDAO.update(match);
//            if (daoResult) alertMessage = "Encuentro actualizada satisfactoriamente";
//        } else {
//            alertMessage = "Encuentro no encontrado"; 
//        }
//        return alertMessage;
//    }
    
//    @RequestMapping("/json/data")
        @RequestMapping("/json/data/admin/all/matchs")
	@ResponseBody
	public List<MatchV> getAllMatchs(){
            logger.info("info.Inside getAllMatchs method");
            return matchDAO.getAllMatchsV();
	} 
}
