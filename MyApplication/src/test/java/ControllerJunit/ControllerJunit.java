package ControllerJunit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.vikash.controller.RestController;
import com.vikash.modal.User;
import com.vikash.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class ControllerJunit {
	
	@InjectMocks
	private RestController restController;
	
	@Mock
	private UserService userService;
	
	
	
	@Test
    public void testToSaveUserDetails_validRequest_validResponse() {
		
		
		String expected=restController.saveUser("sum_rat", "Sumit", "Rathore", 21, "abc", "9871235635", "sumit@gmail.com", "KamlaNagar.Delhi");
		
		String actuals = "User Saved into Database";
		
		Assert.assertEquals(expected, actuals);
		
	}
	
	@Test
    public void testToCheck_validRequest_validResponse() {
		
		String expected=restController.hello();
		
		String actual = "This is Home page of Customer";
		
		Assert.assertEquals(expected, actual);
		
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
