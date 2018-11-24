
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.TrainingDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.Training;
import com.xem.py.pokyabmodel.dto.TrainingActivity;
import com.xem.py.pokyabmodel.validator.TrainingValidator;
import java.util.List;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
public class TrainingController {
    Logger logger = LoggerFactory.getLogger(TrainingController.class);
    
    @Autowired  
    private TrainingDAO trainingDAO;
    
    @Autowired
    private ActivityDAO activityDAO;

    @ModelAttribute("training")
    public Training getTraining() {
        logger.info("En getTraining");
        return new Training();
    }
    
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

        return mv;
    }
    
    @RequestMapping(value = {"/manage/training/{id}"})
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
    
    @RequestMapping(value="/manage/training", method=RequestMethod.POST        )
    public String handleTrainingSubm(@Valid @ModelAttribute("training") Training training
            ,BindingResult result, Model model) {
        logger.info("info.Inside handleTrainingSubm method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl;

        //Spring Validator
        new TrainingValidator().validate(training, result);        
        if (result.hasErrors()) {
            model.addAttribute("title", "Training");
            model.addAttribute("userClickTraining", true); 
            return "page";
        } 

        if (training.getTrainingId() == 0) {
            daoResult = trainingDAO.add(training);
            if (daoResult) alertMessage = "Entrenamiento agregada";            
        } else {
            daoResult = trainingDAO.update(training);
            if (daoResult) alertMessage = "Entrenamiento actualizado";
        }
        if (daoResult) returnUrl = "redirect:/manage/training/"+training.getTrainingId();
        else returnUrl = "redirect:/manage/training";
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/training/{id}/delete", method=RequestMethod.GET)
    public String handleTrainingDelete(@PathVariable int id) {
        logger.info("info.Inside handleTrainingDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Training training = trainingDAO.getTrainingById(id);
        if (training != null) {
            logger.info("training: "+training.toString());
            daoResult = trainingDAO.delete(training);
            if (daoResult) alertMessage = "Entrenamiento borrada";                   
        } else {
            alertMessage = "Entrenamiento no encontrado"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/trainings?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/training/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleTrainingActivation(@PathVariable int id) {
        logger.info("info.Inside handleTrainingActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        Training training = trainingDAO.getTrainingById(id);
        logger.info("training:"+training.toString()); 

        if (training != null) {
            if (training.getActive() == 'Y') training.setActive('N');
            else training.setActive('Y');
            daoResult = trainingDAO.update(training);
            if (daoResult) alertMessage = "Entrenamiento actualizado satisfactoriamente";
        } else {
            alertMessage = "Entrenamiento no encontrado"; 
        }
        return alertMessage;
    }
}
