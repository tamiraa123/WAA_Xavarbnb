package edu.miu.xavarbnb.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.miu.xavarbnb.domain.User;
import edu.miu.xavarbnb.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService  userService;

	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String login() {
 		return "signin";
	}
 
	@RequestMapping(value="/signinfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "signin";
 
	}
 
	@RequestMapping(value="/signout", method = RequestMethod.GET)
	public String logout(Model model) {
		
 		return "redirect:/signin";
 	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("user") User user) {
	   return "signup";
	}  
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processAddNewMemberForm(@Valid @ModelAttribute("user")  User user, BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "signup";
		}
		redirectAttributes.addFlashAttribute(user);

		userService.saveFull(user);
 	   	return "redirect:/welcome";
	}
}
