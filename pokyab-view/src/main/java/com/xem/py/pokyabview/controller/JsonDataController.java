package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.MessageDAO;
import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.Message;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.Training;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private PersonDAO personDAO;
        @Autowired
	private ActivityDAO activityDAO;
        @Autowired
	private TrainingDAO trainingDAO;        

        
        @RequestMapping("/admin/all/messages")
	@ResponseBody
	public List<Message> getAdminMessages(){
            logger.info("info.Inside getAdminMessages method");
            logger.debug("debug.Inside getAdminMessages method");
            return messageDAO.getAllMessages();

	}
        
	@RequestMapping("/admin/all/persons")
	@ResponseBody
	public List<Person> getAdminPersons(){
            logger.info("info.Inside getAdminPersons method");
            logger.debug("debug.Inside getAdminPersons method");
            return personDAO.getAllPersons();
	}
        
        @RequestMapping("/admin/all/trainings")
	@ResponseBody
	public List<Training> getAdminTrainings(){
            logger.info("info.Inside getAdminTrainings method");
            logger.debug("debug.Inside getAdminTrainings method");
            return trainingDAO.getAllTrainings();
	}
        
        @RequestMapping("/admin/all/activities")
	@ResponseBody
	public List<Activity> getAdminActivities(){
            logger.info("info.Inside getAdminActivities method");
            logger.debug("debug.Inside getAdminActivities method");
            return activityDAO.getAllActivities();
	}        
}
