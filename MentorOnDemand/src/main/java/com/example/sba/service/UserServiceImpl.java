package com.example.sba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sba.dao.UserDao;
import com.example.sba.model.User;
import com.example.sba.model.UserLogin;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User loginUser(UserLogin userlogin) {
		// TODO Auto-generated method stub
		return userDao.getOne(userlogin.getId());
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.save(user)!=null)
			return true;
		else
			return false;
	}

}
