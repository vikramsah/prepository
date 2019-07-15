package com.techm.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.message.common.model.User;
import com.techm.messaging.dao.IUserManagementDAO;

@Service
public class UserManagementServiceImpl implements IUserManagementService{
	
	@Autowired
	private IUserManagementDAO userRegistrationDAO;

	@Override
	public User registerUser(User registerUser) {
		return userRegistrationDAO.registerUser(registerUser);
	}

	@Override
	public User followUser(String userIdFollowing, String userIdToBeFollowed) {
		return userRegistrationDAO.folloUser(userIdFollowing, userIdToBeFollowed);
	}

}
