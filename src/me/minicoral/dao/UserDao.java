package me.minicoral.dao;

import java.util.List;

import me.minicoral.action.Blog;
import me.minicoral.action.User;

public interface UserDao
{
	/**
	 * 添加用户
	 * 
	 * @param user
	 *            要添加的用户信息
	 */
	void addUser(User user);

	/**
	 * 根据条件查询用户信息，条件参数为查询条件，若为null或者“”，则查询全部
	 * 
	 * @param condition
	 *            查询条件
	 * @return 查询到的用户的List集合
	 */
	List<User> findUserByCondition(String condition);
}
