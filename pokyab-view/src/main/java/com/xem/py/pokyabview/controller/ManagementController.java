package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.LeagueDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.SeasonDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.League;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Season;
import com.xem.py.pokyabmodel.dto.Team;
import com.xem.py.pokyabmodel.dto.Training;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
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
@RequestMapping("/manage")
public class ManagementController {
 
    Logger logger = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private TeamDAO teamDAO;
    @Autowired
    private SeasonDAO seasonDAO;
    @Autowired
    private LeagueDAO leagueDAO;    
    @Autowired
    private TrainingDAO trainingDAO;
    @Autowired
    private ActivityDAO activityDAO;      
    @Autowired
    private TrainingActivityDAO trainingActivityDAO; 
    
    
    //Bean Modal
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

    @ModelAttribute("activities")
    public List<Activity> getActivities() {
        return activityDAO.getActiveActivities();
    }

     //URl Mappings - POST
    @RequestMapping(value = {"/team"}, method = RequestMethod.POST)
    public String handleTeamSubmission(@ModelAttribute Team team) {
        team.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        logger.info("En handleTeamSubmission");
        logger.info("leagueId"+team.getLeagueId());     
        teamDAO.Add(team);
        return "redirect:/home";
    }
        
    @RequestMapping(value="/person", method=RequestMethod.POST)
    public String handlePersonSubmission(@ModelAttribute Person person) {
        //ToDo Quitar este valor
        person.setDateOfBirth(new java.sql.Date(System.currentTimeMillis()));
        personDAO.Add(person);
        return "redirect:/home";
    }
    
    @RequestMapping(value="/league", method=RequestMethod.POST)
    public String handleLeagueSubmission(@ModelAttribute League league) {
        //ToDo Quitar este valor
        league.setActive('Y');
        league.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        leagueDAO.Add(league);
        return "redirect:/home";
    }
    
    @RequestMapping(value="/season", method=RequestMethod.POST)
    public String handleSeasonSubmission(@ModelAttribute Season season) {
        //ToDo Quitar este valor
        season.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        season.setEndDate(new java.sql.Date(System.currentTimeMillis()));    
        seasonDAO.Add(season);
        return "redirect:/home";
    }

    @RequestMapping(value="/training", method=RequestMethod.POST)
    public String handleTrainingSubm(@ModelAttribute Training training) {
        //ToDo Quitar este valor
        training.setStartDate(new java.sql.Date(System.currentTimeMillis()));        
        trainingDAO.Add(training);
//        training = trainingDAO.getTrainingByName(training.getTrainingName());
        return "redirect:/trainings";
//        return "/manage/"+training.getTrainingId()+"/training";
    }
         
    @RequestMapping(value="/activity", method=RequestMethod.POST)
    public String handleActivitySubm(@ModelAttribute Activity activity) {
        //ToDo Quitar este valor
        activity.setStartDate(new java.sql.Date(System.currentTimeMillis()));
//        activity.setEndDate(new java.sql.Date(System.currentTimeMillis()));    
        activityDAO.Add(activity);
        return "redirect:/home";
    }

    @RequestMapping(value="/trainingActivity", method=RequestMethod.POST)
    public String handleTrainActivitySubm(@ModelAttribute TrainingActivity trainingActivity) {
        //ToDo Quitar este valor
//        trainingActivity.setStartDate(new java.sql.Date(System.currentTimeMillis()));
        trainingActivityDAO.Add(trainingActivity);
        return "redirect:/home";
    }
    
    //Url Mappings - Manage
    @RequestMapping(value = {"/team"})
    public ModelAndView showManageTeam() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Team");
        mv.addObject("userClickTeam", true);        
        //Init new Team
        Team nTeam = new Team();
        nTeam.setActive('Y');
        mv.addObject("team", nTeam);                
        return mv;
    }
    
    @RequestMapping(value = {"/training"})
    public ModelAndView showManageTraining() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training");
        mv.addObject("userClickTraining", true);        
        //Init new Training
        Training nTraining = new Training();
        //ToDo definir en constructor
        nTraining.setActive('Y');
        nTraining.setStatusCode("CREADO");
        mv.addObject("training", nTraining);
         //Init new TrainingActivity
//        TrainingActivity nTrainingActivity = new TrainingActivity();
//        ToDo definir en constructor
//        nTrainingActivity.setActivityId(1);
//        nTrainingActivity.setTrainingId(1);
//        mv.addObject("trainingActivity", nTrainingActivity); 
        return mv;
    }
    
    @RequestMapping(value = {"/activity"})
    public ModelAndView showManageActivity() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Activity");
        mv.addObject("userClickActivity", true);        
        //Init new Activity
        Activity nActivity = new Activity();
        //ToDo definir en constructor
        nActivity.setActive('Y');
        mv.addObject("activity", nActivity);                
        return mv;
    }    

    @RequestMapping(value = {"/trainingActivity"})
    public ModelAndView showMngTrainingActivity() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training Activity");
        mv.addObject("userClickTrainActivity", true);        
        //Init new TrainingActivity
        TrainingActivity nTrainingActivity = new TrainingActivity();
        //ToDo definir en constructor
        nTrainingActivity.setActivityId(1);
        nTrainingActivity.setTrainingId(1);
        mv.addObject("trainingActivity", nTrainingActivity);                
        return mv;
    }  
    
    //URL Mapping - Manage by id
    @RequestMapping(value = {"/{id}/training"})
    public ModelAndView showManageTrainingEdit(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training");
        mv.addObject("userClickTraining", true);        
        //Init new Training
        Training training = trainingDAO.getTrainingById(id);
        mv.addObject("training", training);  
         //Init new TrainingActivity
        TrainingActivity nTrainingActivity = new TrainingActivity();
        //ToDo definir en constructor
        //nTrainingActivity.setActivityId(1);
        nTrainingActivity.setTrainingId(id);
        mv.addObject("trainingActivity", nTrainingActivity); 
        return mv;
    }
    
}
