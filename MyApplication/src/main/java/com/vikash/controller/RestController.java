package com.vikash.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.modal.User;
import com.vikash.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String hello() {
		return "This is Home page of Customer";
	}

	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password,
						@RequestParam String contact, @RequestParam String email, @RequestParam String address) {
		User user = new User(username, firstname, lastname, age, password, contact, email, address);
		userService.saveMyUser(user);
		return "User Saved into Database";
	}
	
	@PostMapping("/save_user")
	public String registerUser(@ModelAttribute User user) {
		userService.saveMyUser(user);
		//request.setAttribute("mode", "MODE_HOME");
		return "USER REGISTER THE ACCOUNT SUCCESSFULLY";
	}
	
	@GetMapping("/view_user/{username}/{password}")
	public User loginUser(@PathVariable String username, @PathVariable String password) {
		System.out.println("Controller");
		User user=userService.viewUser(username, password);
			return user;
		}
}
		/*else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";

		}*/
	

/*
 * @DeleteMapping("deleteUserById") public String deleteUser(@RequestParam
 * String id){ userService.deleteUserById(new Long(id)); return "User with Id "
 * + id + " deleted"; }
 */
