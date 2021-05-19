package com.accenture.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.Entity.User;
import com.accenture.demo.Repository.UserRepository;
import com.accenture.demo.Service.UserService;

//annotate the class as a controller
@RestController
public class Controller {
	
	/* API Creation steps:
	 * 1. Setup your controller
	 * 2. Setup your entities
	 * 3. Setup database config (application.properties)
	 * 4. Create Repository
	 * 5. Create your endpoints
	 * */

	/* Controller
	 * -Where we set up our endpoints
	 * -Where clients can invoke methods using endpoints
	 * */
	
	//Dependency Injection - You are letting spring handle the creation of objects in your stead
	@Autowired
	UserService userService;
	
	//Endpoints
	@GetMapping("/hello") //HTTP GET Request type
	public String hello() {
		return "Hello there! hello() method invoked!";
	}
	
	@GetMapping("/singleUser")
	public User user() {
		User myUser = new User("Stephen", "stephen@email.com", 22);
		myUser.setId(191);
		return myUser;
	}
	
	/*
	 * find a single user
	 * find all users
	 * create a user
	 * update a user
	 * delete a user
	 * */
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam int id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User userToAdd) throws Exception {
		//check if user is existing, if existing, do not add, else, add user
		return userService.addUser(userToAdd);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User userDetails, @RequestParam int id) {	
		//Save the user to the database
		return userService.updateUser(userDetails, id);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam int id) {
		//Check if user is existing first before deleting
		userService.deleteUser(id);
	}
}
