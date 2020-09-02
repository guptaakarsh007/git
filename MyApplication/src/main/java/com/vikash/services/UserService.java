package com.vikash.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.exception.InvalidInputException;
import com.vikash.modal.User;
import com.vikash.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	public void saveMyUser(User user ) {
		
		  if (userRepository.findOne(user.getContact()) != null) 
			  throw new InvalidInputException("Account is Already Created");
		  
		/*
		 * if(user.getContact()==null || user.getContact().isEmpty()) { throw new
		 * InvalidInputException("Contact number can't be empty"); }
		 * 
		 * String str = user.getContact(); int strsize = str.length();
		 * 
		 * if(strsize != 10){ throw new
		 * InvalidInputException("Size of contact number should be 10 digit"); }
		 * 
		 * if(user.getEmail()==null || user.getEmail().isEmpty()) { throw new
		 * InvalidInputException("Email address can't be empty"); }
		 * 
		 * if(user.getFirstname()==null || user.getFirstname().isEmpty()) { throw new
		 * InvalidInputException("First name can't be emlty"); }
		 * 
		 * if(user.getPassword()==null || user.getPassword().isEmpty()) { throw new
		 * InvalidInputException("Password can't be empty"); }
		 * 
		 * if(user.getUsername()==null || user.getUsername().isEmpty()) { throw new
		 * InvalidInputException("Username can't be empty"); }
		 */
		 
		userRepository.save(user);
	}
	
	public void updateMyUser(User user ) {
		
		 if(user.getContact()==null || user.getContact().isEmpty()) {
			  throw new InvalidInputException("Contact number can't be empty");
		  }
		  
		  String str = user.getContact();
		  int strsize = str.length();
		  
		  if(strsize != 10){
			  throw new InvalidInputException("Size of contact number should be 10 digit");
		  }
		  
		  if(user.getEmail()==null || user.getEmail().isEmpty()) {
			  throw new InvalidInputException("Email address can't be empty");
		  }
		  
		  if(user.getFirstname()==null || user.getFirstname().isEmpty()) {
			  throw new InvalidInputException("First name can't be emlty");
		  }
		  
		  if(user.getPassword()==null || user.getPassword().isEmpty()) {
			  throw new InvalidInputException("Password can't be empty");
		  }
		  
		  if(user.getUsername()==null || user.getUsername().isEmpty()) {
			  throw new InvalidInputException("Username can't be empty");
		  }
		 
		userRepository.save(user);
	}
	
	public void updateMyUserPersonal(User user ) {
		
		/*
		 * if(userRepository.findById(contact)==null) {
		 * 
		 * }
		 */
		User userPersonal=userRepository.findOne(user.getContact());
		
		/*
		 * if(userPersonal == null) { throw new
		 * InvalidInputException("Sorry Given contact number not matched with User or It does not exist"
		 * ); }
		 * 
		 * if(user.getContact() == null || user.getContact().isEmpty()) { throw new
		 * InvalidInputException("Contact number can't be empty"); }
		 * 
		 * String str = user.getContact(); int strsize = str.length();
		 * 
		 * if(strsize != 10){ throw new
		 * InvalidInputException("Size of contact number should be 10 digit"); }
		 * 
		 * if(user.getEmail()==null || user.getEmail().isEmpty()) { throw new
		 * InvalidInputException("Email address can't be empty"); }
		 * 
		 * if(user.getFirstname()==null || user.getFirstname().isEmpty()) { throw new
		 * InvalidInputException("First name can't be emlty"); }
		 * 
		 * if(user.getPassword()==null || user.getPassword().isEmpty()) { throw new
		 * InvalidInputException("Password can't be empty"); }
		 * 
		 * if(user.getUsername()==null || user.getUsername().isEmpty()) { throw new
		 * InvalidInputException("Username can't be empty"); }
		 */
		  userPersonal.setAddress(user.getAddress());
		  userPersonal.setAge(user.getAge());
		 //userPersonal.setContact(user.getContact());
		  userPersonal.setEmail(user.getEmail());
		  userPersonal.setFirstname(user.getFirstname());
		  userPersonal.setLastname(user.getLastname());
		  userPersonal.setPassword(user.getPassword());
		  userPersonal.setUsername(user.getUsername());
		  userRepository.save(userPersonal);
	}

	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			users.add(user);
		}

		return users;
	}

	
	public void deleteMyUser(String contact)
	{
		userRepository.delete(contact);
	}
	
	public void deleteMyUserPersonal(String contact, String password)
	{
		User user = userRepository.findOne(contact);
		if(user.getPassword().equals(password)) {
		userRepository.delete(contact);
		}
	}
	  
	public User editUser(String contact) { 
		return userRepository.findOne(contact); 
		}


	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	public User findByContactAndPassword(String contact, String password) {
		return userRepository.findByContactAndPassword(contact, password);
	}
	
	/* TODO */
	
	public User viewUser(String username, String password) {
		System.out.println("service");
		if(username==null && password==null || username.isEmpty() && password.isEmpty()) {
			throw new InvalidInputException("Username Or Password cannot be Empty");
		}
		System.out.println("service2");
		return userRepository.viewUserByUsernameAndPassword(username, password);
	}

}

