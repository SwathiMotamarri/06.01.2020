package org.cap.controller;

import org.cap.entities.Employee;
import org.cap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
    private IUserService service;
    public IUserService getService()
    {
    	return service;
    }
    
    @Autowired
    public void setService(IUserService service) 
    {
    	this.service=service;
    }
    
    @GetMapping("/userinput")
    public ModelAndView userInput()
    {
    	return new ModelAndView("userinput");
    }
    
    @GetMapping("/hello")

    //@RequestMapping(method = {RequestMethod.GET}, value = "/hello")
    public ModelAndView sayHello() 
    {
        return new ModelAndView("hellopage",
                "message", "Welcome to Deloitte");
    }
    
    @GetMapping("/userdetails")
       public ModelAndView processuserdetails( @RequestParam("name") String name,
    		   @RequestParam("password") String password) 
    {
           if(service.credentialsCorrect(name,password))
           {
        	   Employee fetched=service.getUserByName(name);
        	  ModelAndView mv=new ModelAndView("userdetails","employee",fetched);
        	  return mv;
           }else {
        	   return new ModelAndView("userinput");
           }
           
    }
    
}           
