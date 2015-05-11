package me.minicoral.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import me.minicoral.action.User;
import me.minicoral.dao.UserDao;
import me.minicoral.exception.DaoException;
import me.minicoral.util.DBCPUtil;

public class UserDaoImpl implements UserDao
{
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource(), true);

	@Override
	public void addUser(User user)
	{
		if (user.getUserid() == null || user.getUserid().trim().equals(""))
		{
			throw new RuntimeException("The id can not be empty");
		}
		try
		{
			String sql = "insert into tbl_user(userid,uname,userpass,blogname,email,descriptions,createtime,lastmodifytime,delflag) values(?,?,?,?,?,?,?,?,?)";
			Object parms[] = { user.getUserid(), user.getUname(),
					user.getUserpass(), user.getBlogname(), user.getEmail(),user.getDescriptions(),user.getCreatetime(),user.getLastmodifytime(),user.getDelflag() };
			qr.update(sql, parms);
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findUserByCondition(String condition)
	{
		try
        {
            if (!condition.trim().startsWith("where") && !condition.trim().startsWith("WHERE"))
            {
                throw new RuntimeException("The parmas must be start with where");
            }
            return qr.query("select * from tbl_user " + condition,new BeanListHandler<User>(User.class));
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	return null;
        }
	}

}
