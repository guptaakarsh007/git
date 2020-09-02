package com.vikash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.modal.User;
import com.vikash.repository.UserRepository;
import com.vikash.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/aboutUs")
	  public String aboutUs() {
	  //request.setAttribute("mode", "MODE_HOME");
		return "AboutUs";
	}
	
	@RequestMapping("/contactUs")
	  public String contactUs() {
	  //request.setAttribute("mode", "MODE_HOME");
		return "contactUs";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		if(user.getContact().isEmpty()) {
			request.setAttribute("error", "Contact number can't be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		if(user.getPassword().isEmpty()) {
			request.setAttribute("error", "password can't be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		if(user.getUsername().isEmpty()) {
			request.setAttribute("error", "User name can't be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		String contact=user.getContact();
		int contactLength=contact.length();
		if(contactLength!=10) {
			request.setAttribute("error", "Size of Contact number must be in 10 digit");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		
		if (userRepository.findOne(user.getContact()) != null) {
			request.setAttribute("error", "Account is Already Created");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@PostMapping("/update-user")
	public String updateUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		
		if(user.getContact().isEmpty()) {
			request.setAttribute("error", "Contact number can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getPassword().isEmpty()) {
			request.setAttribute("error", "password can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getFirstname().isEmpty()) {
			request.setAttribute("error", "First name name can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getUsername().isEmpty()) {
			request.setAttribute("error", "User name can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		String contact=user.getContact();
		int contactLength=contact.length();
		if(contactLength!=10) {
			request.setAttribute("error", "Size of Contact number must be in 10 digit");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		
		userService.updateMyUser(user);
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@PostMapping("/update-user-personal")
	public String updateUserPersonal(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		
		if(user.getContact().isEmpty()) {
			request.setAttribute("error", "Contact number can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getPassword().isEmpty()) {
			request.setAttribute("error", "password can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getFirstname().isEmpty()) {
			request.setAttribute("error", "First name name can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		if(user.getUsername().isEmpty()) {
			request.setAttribute("error", "User name can't be empty");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		String contact=user.getContact();
		int contactLength=contact.length();
		if(contactLength!=10) {
			request.setAttribute("error", "Size of Contact number must be in 10 digit");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		User userPersonal = userRepository.findOne(user.getContact());
		//String userContact=userPersonal.getContact();
		//String userUpdateContact = user.getContact();
		if (userPersonal == null) {
			request.setAttribute("error", "Sorry Given contact number not matched with User or It does not exist");
			request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
			return "welcomepage";
		}
		
		userService.updateMyUserPersonal(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam String contact, HttpServletRequest request) {
		userService.deleteMyUser(contact);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user-personal-mode")
	public String deleteUserPersonal( HttpServletRequest request) {
		//userService.deleteMyUser(contact);
		//request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_LOGIN_PERSONAL");
		return "welcomepage";
	}

	
	@RequestMapping("/edit-user") 
	public String editUser(@RequestParam String contact, HttpServletRequest request) {
	request.setAttribute("user",userService.editUser(contact)); 
	request.setAttribute("mode", "MODE_UPDATE");
	return "welcomepage"; }
	
	
	@RequestMapping("/edit-user-personal") 
	public String editUserPersonal( HttpServletRequest request) {
		//request.setAttribute("user",userService.editUser(contact)); 
		request.setAttribute("mode", "MODE_UPDATE_PERSONAL");
		return "welcomepage"; }
	 

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";

		}
	}
	
	@RequestMapping ("/login-admin")
	public String loginAdmin(@ModelAttribute User user, HttpServletRequest request) {
		if(userRepository.viewUserByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			request.setAttribute("mode", "MODE_ADMIN_LOGIN");
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_ADMIN_LOGIN");
			return "welcomepage";

		}
	}
	
	
	@RequestMapping ("/delete-user-personal")
	public String deleteUserPersonal(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByContactAndPassword(user.getContact(), user.getPassword())!=null) {
			
			userService.deleteMyUserPersonal(user.getContact(), user.getPassword());
			return "successPage";
		}
		else {
			request.setAttribute("error", "Invalid contact or Password");
			request.setAttribute("mode", "MODE_LOGIN_PERSONAL");
			return "welcomepage";

		}
	}

}
