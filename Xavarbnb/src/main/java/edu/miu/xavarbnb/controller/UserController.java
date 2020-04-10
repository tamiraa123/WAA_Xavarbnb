package edu.miu.xavarbnb.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.jdbc.Blob;

import edu.miu.xavarbnb.domain.User;
import edu.miu.xavarbnb.domain.UserCredentials;
import edu.miu.xavarbnb.service.UserCredentialsService;
import edu.miu.xavarbnb.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService  userService;

	@Autowired
	private UserCredentialsService  credentialsService;

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String listMembers(Model model) {
		model.addAttribute("users", userService.findAll());
		System.out.println(model);
		return "users";
	}
	

	@RequestMapping(value="/id", method = RequestMethod.GET)
	public @ResponseBody User getMemberByMemberNumber(@RequestParam("id") String id) {
		System.out.println("123");
		long num = Long.parseLong(id);
		User user = userService.findByUserId(num);
	
 		return user;
	}
	
	 
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	  void deleteUser(@PathVariable Long id) {
	    userService.deleteById(id);
	  }
	
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	  void updateUser(@RequestBody User user, @PathVariable Long id) {
	    userService.updateById(user, id);
	  }
	
	
	
 
}
