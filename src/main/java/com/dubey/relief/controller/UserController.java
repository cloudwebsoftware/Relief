package com.dubey.relief.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dubey.relief.Entity.User;
import com.dubey.relief.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	
	    @Autowired
	    private UserService userService;

	    // Create User
	    @PostMapping("/createuser")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        return ResponseEntity.ok(userService.createUser(user));
	    }

	    // Get All Users
	    @GetMapping("/getuser")
	    public ResponseEntity<List<User>> getAllUsers() {
	        return ResponseEntity.ok(userService.getAllUsers());
	    }

	    // Get User by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
	        return userService.getUserById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Update User
	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
	        return ResponseEntity.ok(userService.updateUser(id, userDetails));
	    }

	    // Delete User
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
	        userService.deleteUser(id);
	        return ResponseEntity.noContent().build();
	    }
}
