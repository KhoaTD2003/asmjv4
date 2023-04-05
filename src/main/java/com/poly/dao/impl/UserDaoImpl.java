package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.AbstracDAO;
import com.poly.dao.UserDao;
import com.poly.entity.User;

public class UserDaoImpl extends AbstracDAO<User> implements UserDao{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "select o from User o where o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select o from User o where o.username = ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "select u from User u where u.username = ?0 and u.password = ?1";
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}
	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}
	

	

}
