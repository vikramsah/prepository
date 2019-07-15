package com.techm.messaging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.message.common.model.User;
import com.techm.messaging.service.IUserManagementService;

@RestController
@RequestMapping("/registration/")
public class UserManagementController {
	
	
	@Autowired
	IUserManagementService userManagementService;
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public @ResponseBody User registerUser(@RequestBody final User userForRegistration, BindingResult result) {
		// We can add a validation to the userForRegistration
		return userManagementService.registerUser(userForRegistration);
		
	}
	
	@RequestMapping(path = "/follow/{userIdFollowing}/{userIdToBeFollowed}", method = RequestMethod.POST)
	public @ResponseBody User followUser(@PathVariable("userIdFollowing") String userIdFollowing, @PathVariable("userIdToBeFollowed") String userIdToBeFollowed){
		
		// We can add a validation to the userForRegistration
		return userManagementService.followUser(userIdFollowing, userIdToBeFollowed);
		
	}

}
