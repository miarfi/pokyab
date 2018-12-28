
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.TrainingActivityDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
import com.xem.py.pokyabmodel.validator.TrainActivValidator;
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
    @Autowired
    private LookupValueDAO lookupValueDAO;  
    
    @ModelAttribute("positionCodes")
    public List<LookupValue> getPositionCodes() {
        return lookupValueDAO.getLkpValuesByType("POSITION_CODE", "");
    }
    
    //lov activities
    @ModelAttribute("activities")
    public List<Activity> getActivities() {
        return activityDAO.getActiveActivities();
    }
        
    @RequestMapping(value = {"/manage/trainingActivity"})
    public ModelAndView showMngTrainingActivity() {
        logger.info("info.Inside showMngTrainingActivity method");
        ModelAndView mv = new ModelAndView("training/trainingMain");
        mv.addObject("title", "Training Activity");
        mv.addObject("userClickTrainActivity", true);
        
        //Init new TrainingActivity
        TrainingActivity trainingActivity = new TrainingActivity();        
        mv.addObject("trainingActivity", trainingActivity);
        return mv;
    }

    @RequestMapping(value = {"/manage/trainingActivity/{id}"})
    public ModelAndView showMngTrainingActivEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showMngTrainingActivEdit method");
        ModelAndView mv = new ModelAndView("training/trainingMain");
        mv.addObject("title", "Training");
        mv.addObject("userClickTrainActivity", true);     
        mv.addObject("alertMessage", alertMessage);
        
        //Get Training object
        TrainingActivity trainingActivity = trainingActivityDAO.getTrainActivityById(id);
        mv.addObject("trainingActivity", trainingActivity);   
        return mv;
    }   

    @RequestMapping(value = "/manage/trainingActivity", method = RequestMethod.POST)
    public String handleTrainActivitySubm(@ModelAttribute TrainingActivity trainingActivity,
            BindingResult result, Model model) {
        logger.info("info.Inside handleTrainActivitySubm method");
        String alertMessage = "";
        boolean daoResult = false;
        
        //Spring Validator        
        new TrainActivValidator().validate(trainingActivity, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "TrainingActivity");
            model.addAttribute("userClickTrainActiv", true);             
            return "training/trainingMain";
        }
        
        if (trainingActivity.getTrainActId() == 0) {
            daoResult =   trainingActivityDAO.add(trainingActivity);
            if (daoResult) alertMessage = "Actividad guardada";            
        } else {
            daoResult =   trainingActivityDAO.update(trainingActivity);
            if (daoResult) alertMessage = "Actividad actualizada";   
        }
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return "redirect:/manage/training/"+trainingActivity.getTrainingId()+"?alertMessage="+alertMessage;
    }
    
    
    @RequestMapping(value="/manage/trainingActivity/{id}/delete", method=RequestMethod.GET)
    public String handleTrainingActivityDelete(@PathVariable int id) {
        logger.info("info.Inside handleTrainingActivityDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        TrainingActivity trainingActivity = trainingActivityDAO.getTrainActivityById(id);
        if (trainingActivity != null) {
            logger.info("trainingActivity: "+trainingActivity.toString());
            daoResult = trainingActivityDAO.delete(trainingActivity);
            if (daoResult) alertMessage = "Actividad borrada";                   
        } else {
            alertMessage = "Actividad no encontrada"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/trainingActivities?alertMessage=" + alertMessage;
    }

    
//    @RequestMapping(value="/manage/trainingActivity/{id}/activation", method=RequestMethod.GET)
//    @ResponseBody
//    public String handleTrainingActivityActivation(@PathVariable int id) {
//        logger.info("info.Inside handleTrainingActivityActivation method");
//        String alertMessage = "";
//        boolean daoResult = false;
//        TrainingActivity trainingActivity = trainingActivityDAO.getTrainActivityById(id);
//        logger.info("trainingActivity:"+trainingActivity.toString()); 
//
//        if (trainingActivity != null) {
//            if (trainingActivity.getActive() == 'Y') trainingActivity.setActive('N');
//            else trainingActivity.setActive('Y');
//            daoResult = trainingActivityDAO.update(trainingActivity);
//            if (daoResult) alertMessage = "Equipo actualizada satisfactoriamente";
//        } else {
//            alertMessage = "Equipo no encontrado"; 
//        }
//        return alertMessage;
//    }
}
