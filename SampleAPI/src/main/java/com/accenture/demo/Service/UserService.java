package com.accenture.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.demo.Entity.User;
import com.accenture.demo.Repository.UserRepository;

//Where all business logic should be
@Service //specifies to spring that this is a service class
public class UserService {

	//Dependency Injection - You are letting spring handle the creation of objects in your stead
		@Autowired
		UserRepository userRepository;
		
		/*
		 * find a single user
		 * find all users
		 * create a user
		 * update a user
		 * delete a user
		 * */
		
		public User getUser(int id) {
			return userRepository.findById(id).get();
		}
		
		public List<User> getAllUsers(){
			return userRepository.findAll();
		}
		
		public User addUser(User userToAdd) throws Exception {
			//check if user is existing, if existing, do not add, else, add user
			if(userRepository.findByFirstName(userToAdd.getFirstName()) == null) { //check if user does not exist
				return userRepository.save(userToAdd);
			}else {
				//User does not exist!
				throw new Exception("User not found!");
			}
		}
		
		public User updateUser(User userDetails, int id) {
			//Check if user is existing, if existing, update user, else throw error
			//get the user to update and update the details
			try {
				if(userRepository.existsById(id)) {
					User userToUpdate = userRepository.findById(id).get();
					userToUpdate.setFirstName(userDetails.getFirstName());
					userToUpdate.setAge(userDetails.getAge());
					userToUpdate.setEmail(userDetails.getEmail());
					
					//Save the user to the database
					return userRepository.save(userToUpdate);
				} else {
					throw new Exception("User not found!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
		
		public void deleteUser(int id) {
			//Check if user is existing first before deleting
			try {
				if(userRepository.existsById(id))
					userRepository.deleteById(id);
				else
					throw new Exception("User not found!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
