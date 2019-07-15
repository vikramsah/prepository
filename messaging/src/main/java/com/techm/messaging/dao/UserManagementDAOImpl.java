package com.techm.messaging.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.techm.message.common.model.User;

public class UserManagementDAOImpl implements IUserManagementDAO {

	private final Map<String, User> registeredUserMap = new HashMap<>();
	private final Map<String, List<User>> mapOfUserToFollower = new HashMap<>();
	
	@Override
	public User registerUser(User registerUser) {
		registerUser.setId(generateUserId());
		registeredUserMap.put(registerUser.getId(), registerUser);
		return registerUser;
	}

	@Override
	public User folloUser(String userIdFollowing, String userIdToBeFollowed) {
		if(!mapOfUserToFollower.containsKey(userIdToBeFollowed)) {
			mapOfUserToFollower.put(userIdToBeFollowed, new ArrayList<User>());
		}
		mapOfUserToFollower.get(userIdToBeFollowed).add(registeredUserMap.get(userIdFollowing));
		return registeredUserMap.get(userIdFollowing);
	}
	Random r = new Random();
	private String generateUserId() {
		return String.valueOf(r.nextInt());
	}

}
