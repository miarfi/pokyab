package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.LookupTypeDAO;
import com.xem.py.pokyabmodel.dao.MessageDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.TeamDAO;
import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.LookupType;
import com.xem.py.pokyabmodel.dto.Message;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Training;
import com.xem.py.pokyabmodel.view.TrainingActivityV;
import com.xem.py.pokyabmodel.view.TeamV;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author miguel
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController {
        
        Logger logger = LoggerFactory.getLogger(JsonDataController.class);

        @Autowired
        private MessageDAO messageDAO;
        @Autowired
        private LookupTypeDAO lookupTypeDAO;
	@Autowired
        private TeamDAO teamDAO;
        @Autowired
        private PersonDAO personDAO;
        @Autowired
	private ActivityDAO activityDAO;
        @Autowired
	private TrainingDAO trainingDAO;        
        @Autowired
	private TrainingActivityDAO trainingActivityDAO; 
        
        @RequestMapping("/admin/all/messages")
	@ResponseBody
	public List<Message> getAdminMessages(){
            logger.info("info.Inside getAdminMessages method");
            return messageDAO.getAllMessages();
	}
        
        @RequestMapping("/admin/all/lookupTypes")
	@ResponseBody
	public List<LookupType> getAdminLookupTypes(){
            logger.info("info.Inside getAdminLookupTypes method");
            return lookupTypeDAO.getAllLkpTypes();
	}   
	
        @RequestMapping("/admin/all/persons")
	@ResponseBody
	public List<Person> getAdminPersons(){
            logger.info("info.Inside getAdminPersons method");
            return personDAO.getAllPersons();
	}

        @RequestMapping("/admin/all/teams")
	@ResponseBody
	public List<TeamV> getAdminTeams(){
            logger.info("info.Inside getAdminTeamsV method");
            return teamDAO.getAllTeamsV();
	}
        
        @RequestMapping("/admin/all/trainings")
	@ResponseBody
	public List<Training> getAdminTrainings(){
            logger.info("info.Inside getAdminTrainings method");
            return trainingDAO.getAllTrainings();
	}
        
        @RequestMapping("/admin/all/activities")
	@ResponseBody
	public List<Activity> getAdminActivities(){
            logger.info("info.Inside getAdminActivities method");

            return activityDAO.getAllActivities();
	} 
        
        @RequestMapping("/admin/all/{id}/trainActivities")
	@ResponseBody
	public List<TrainingActivityV> getAdminTrainActivities(@PathVariable int id){
            logger.info("info.Inside getAdminTrainActivities method");
            return trainingActivityDAO.getAllTrainActivVByTrainId(id);
	}        
}
