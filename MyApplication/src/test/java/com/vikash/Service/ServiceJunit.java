package com.vikash.Service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.vikash.modal.User;
import com.vikash.repository.UserRepository;
import com.vikash.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceJunit {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	
	@Test
	public void testToShowUserDetails_validRequest_validResponse() {
		
		User user =userCreate();
		
		List<User> expected=new ArrayList<User>();
		List<User> actual=new ArrayList<User>();
		List<User> list=new ArrayList<User>();
		list.add(user);
		
		Mockito.when(userRepository.findAll()).thenReturn(list);
		
		actual.add(user);
		
		expected = userService.showAllUsers();
		
		Assert.assertEquals(expected, actual);
		
		
	}
	
	@Test
    public void testToSaveUserDetails_validRequest_validResponse() {
		
		userService.saveMyUser(userCreate());
		
	}
	
	  @Test public void testToDeleteUserByContactNumber_validRequest_validResponse() {
		  
		  //Mockito.when(userRepository.delete(Mockito.anyString())).thenReturn(userCreate());
		  
		  userService.deleteMyUser("9876543210");
	  }
	  
	  
	  @Test public void testToEditUserByContactNumber_validRequest_validResponse() {
		  
		  Mockito.when(userRepository.findOne(Mockito.anyString())).thenReturn(userCreate());
		  
		  User actual = userCreate();
		  
		  User expected = userService.editUser("9876543210");
		  
		  Assert.assertNotEquals(expected, actual);
	  }
	  
	  
	  @Test public void testTofindByUsernameAndPassword_validRequest_validResponse() {
		  
		  Mockito.when(userRepository.findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(userCreate());
		  
		  userService.deleteMyUser("9876543210");
	  }
	 
	
	private User userCreate() {
		User user=new User();
		user.setAddress("Address");
		user.setUsername("username");
		user.setAge(25);
		user.setContact("9876543210");
		user.setEmail("aka@gmail.com");
		user.setFirstname("firstname");
		user.setLastname("lastname");
		user.setPassword("abc");
		
		return user;
	}

}
