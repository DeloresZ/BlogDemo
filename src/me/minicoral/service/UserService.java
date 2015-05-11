package me.minicoral.service;

import me.minicoral.action.User;

public interface UserService
{
	User login(String uname, String userpass);

	String addUser(User user);
}
