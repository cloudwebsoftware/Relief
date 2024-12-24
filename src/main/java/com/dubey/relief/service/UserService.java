package com.dubey.relief.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubey.relief.Entity.User;
import com.dubey.relief.dao.UserRepository;

@Service
public class UserService {
	
	
	   @Autowired
	    private UserRepository userRepository;

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public Optional<User> getUserById(Integer id) {
	        return userRepository.findById(id);
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public User updateUser(Integer id, User userDetails) {
	        return userRepository.findById(id).map(user -> {
	            user.setUserName(userDetails.getUserName());
	            user.setAddress(userDetails.getAddress());
	            return userRepository.save(user);
	        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
	    }

	    public void deleteUser(Integer id) {
	        userRepository.deleteById(id);
	    }
}
