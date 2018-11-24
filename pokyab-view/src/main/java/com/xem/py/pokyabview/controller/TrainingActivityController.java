
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/trainingActivity")
public class TrainingActivityController {
    Logger logger = LoggerFactory.getLogger(TrainingActivityController.class);
     
    @Autowired
    private ActivityDAO activityDAO; 
    @Autowired
    private TrainingActivityDAO trainingActivityDAO; 
    
    //lov activities
    @ModelAttribute("activities")
    public List<Activity> getActivities() {
        return activityDAO.getActiveActivities();
    }
        
    @RequestMapping(value = {"/manage/trainingActivity"})
    public ModelAndView showMngTrainingActivity() {
        logger.info("info.Inside showMngTrainingActivity method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Training Activity");
        mv.addObject("userClickTrainActivity", true);
        
        //Init new TrainingActivity
        TrainingActivity trainingActivity = new TrainingActivity();        
        mv.addObject("trainingActivity", trainingActivity);
        return mv;
    }

       

    @RequestMapping(value = "/manage/trainingActivity", method = RequestMethod.POST)
    public String handleTrainActivitySubm(@ModelAttribute TrainingActivity trainingActivity) {
        logger.info("info.Inside handleTrainActivitySubm method");
        String alertMessage = "";
        boolean daoResult = false;
        
        if (trainingActivity.getTrainActId() == 0) {
            daoResult =   trainingActivityDAO.add(trainingActivity);
            if (daoResult) alertMessage = "Actividad guardada";            
        } else {
            daoResult =   trainingActivityDAO.update(trainingActivity);
            if (daoResult) alertMessage = "Actividad actualizada";   
        }
                     
        return "redirect:/manage/"+trainingActivity.getTrainingId()+"/training";
    }
}
