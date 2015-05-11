package me.minicoral.service.impl;

import java.util.List;

import me.minicoral.action.User;
import me.minicoral.dao.UserDao;
import me.minicoral.dao.impl.UserDaoImpl;
import me.minicoral.service.UserService;
import me.minicoral.util.MD5Util;

public class UserServiceImpl implements UserService
{

	private UserDao dao = new UserDaoImpl();
	@Override
	public User login(String uname, String userpass)
	{
		if (uname == null||userpass==null)
        {
            throw new IllegalArgumentException();
        }
		userpass = MD5Util.encode(userpass);
        List<User> users = dao.findUserByCondition("where uname='"+uname+"' and userpass='"+userpass+"'");
        if (users!=null&&users.size()>0)
        {
            return users.get(0);
        }else {
            return null;
        }
	}
	@Override
	public String addUser(User user)
	{
		List<User> users = dao.findUserByCondition("where uname='"+user.getUname()+"'");
		if (users!=null&&users.size()>0)
		{
			return "用户已经存在，请勿重复注册";
		}
		else {
			dao.addUser(user);
			return "注册成功";
		}
	}
	
	
}
