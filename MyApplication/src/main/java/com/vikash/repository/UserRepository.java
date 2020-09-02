package com.vikash.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vikash.modal.User;

public interface UserRepository extends CrudRepository<User, String> {	
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByContactAndPassword(String contact, String password);
	
	/* TODO */
	
	@Query("select u from User u where u.username=?1 AND u.password=?2")
	public User viewUserByUsernameAndPassword(String username, String Password);
}
