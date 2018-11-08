
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Activity;
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
public class TrainingController {
    Logger logger = LoggerFactory.getLogger(PageController.class);
    
    @Autowired  
    private TrainingDAO trainingDAO;
    
    //trainActiviModal required
    @Autowired
    private TrainingActivityDAO trainingActivityDAO; 
    @Autowired
    private ActivityDAO activityDAO;
    
    //lov activities
    @ModelAttribute("activities")
    public List<Activity> getActivities() {
        return activityDAO.getActiveActivities();
    }
    
    @RequestMapping(value = {"/trainings"})
    public ModelAndView showAllTrainings() {
        logger.info("info.Inside showAllTrainings method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Trainings");
        mv.addObject("userClickTrainings", true);
        return mv;
    }  
    
    @RequestMapping(value = {"/manage/training"})
    public ModelAndView showManageTraining() {
        logger.info("info.Inside showManageTraining method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training");
        mv.addObject("userClickTraining", true);        
        
        //Init new Training
        Training training = new Training();
        mv.addObject("training", training);

        return mv;
    }
    
    @RequestMapping(value = {"/manage/{id}/training"})
    public ModelAndView showManageTrainingEdit(@PathVariable int id) {
        logger.info("info.Inside showManageTrainingEdit method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training");
        mv.addObject("userClickTraining", true);        
        
        //Get Training object
        Training training = trainingDAO.getTrainingById(id);
        mv.addObject("training", training);  
        
        //Init new TrainingActivity
        TrainingActivity ntrainingActivity = new TrainingActivity();
        ntrainingActivity.setTrainingId(id);
        mv.addObject("trainingActivity", ntrainingActivity); 
        return mv;
    }
    
    @RequestMapping(value="/manage/training", method=RequestMethod.POST)
    public String handleTrainingSubm(@ModelAttribute Training training) {
        logger.info("info.Inside showManageTrainingEdit method");
        String alertMessage = "";
        boolean daoResult = false;

        if (training.getTrainingId() == 0) {
            daoResult = trainingDAO.add(training);
            if (daoResult) alertMessage = "Entrenamiento agregada";            
        } else {
            daoResult = trainingDAO.update(training);
            if (daoResult) alertMessage = "Entrenamiento actualizado";
        }
        
//        training = trainingDAO.getTrainingByName(training.getTrainingName());
        return "redirect:/trainings";
//        return "/manage/"+training.getTrainingId()+"/training";
    }
}
