package edu.miu.xavarbnb.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.xavarbnb.domain.Authority;
import edu.miu.xavarbnb.domain.Property;
import edu.miu.xavarbnb.domain.User;
import edu.miu.xavarbnb.service.PropertyService;
  
@Controller
public class HomeController {

	@Autowired
	PropertyService propertyService;
	
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		List<Property> properties = propertyService.getAll();
		model.addAttribute("properties", properties);
		
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        if (principal instanceof Authority)
	        	System.out.println("@@@"+principal);
			else
				System.out.println("@@@"+principal);
	    }
	    
		//return "properties";
		return "welcome";
	}
	
	@ModelAttribute ("homeTestOrder")
	 public String testOrder() {
		
		// test interceptor Order		
		System.out.println("CONTROLLER @MODELATTRIBUTE PREHANDLE");

		return "This is CONTROLLER ORDER!";
	}

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String listAllProperty(Model model) {
//		
//	}
 
}
