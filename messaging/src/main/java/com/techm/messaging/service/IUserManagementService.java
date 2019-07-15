package com.techm.messaging.service;

import com.techm.message.common.model.User;

public interface IUserManagementService {
	
	
	public User registerUser(User user);
	
	public User followUser(String userIdFollowing, String userIdToBeFollowed);

}
