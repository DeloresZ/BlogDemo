package me.minicoral.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import me.minicoral.action.Blog;
import me.minicoral.dao.BlogDao;
import me.minicoral.util.DBCPUtil;

public class BlogDaoImpl implements BlogDao
{
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource(), true);

	@Override
	public void addBlog(Blog blog)
	{
		try
		{
			String sql = "insert into tbl_blogger(bid,userid,title,blogcontent) values(?,?,?,?)";
			Object parms[] = { blog.getBid(), blog.getUserid(),
					blog.getTitle(), blog.getBlogcontent() };
			qr.update(sql, parms);
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Blog> findAllBlog()
	{
		try
		{
			String sql = "select * from tbl_blogger";
			return qr.query(sql, new BeanListHandler<Blog>(Blog.class));
		}
		catch (SQLException e)
		{
			return null;
		}
	}

	@Override
	public Blog findBlogById(String id)
	{
		if (id == null || id.trim().equals(""))
		{
			throw new RuntimeException("The id can not be empty");
		}
		try
		{
			List<Blog> blogs = findUserByCondition("where bid='" + id + "'");
			if (blogs != null && blogs.size() > 0)
			{
				return blogs.get(0);
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public List<Blog> findUserByCondition(String condition)
	{
		try
		{
			if (condition == null || condition.trim().equals(""))
			{
				return findAllBlog();
			}
			if (!condition.trim().startsWith("where")
					&& !condition.trim().startsWith("WHERE"))
			{
				throw new RuntimeException(
						"The parmas must be start with where");
			}
			return qr.query("select * from tbl_blogger " + condition,
					new BeanListHandler<Blog>(Blog.class));
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public void updateUser(Blog blog)
	{
		if (blog.getBid() == null || blog.getBid().trim().equals(""))
		{
			throw new RuntimeException("The id can not be empty");
		}
		try
		{
			String sql = "update tbl_blogger set bid=?,userid=?,title=?,blogcontent=?";
			Object parmas[] = { blog.getBid(), blog.getUserid(),
					blog.getTitle(), blog.getBlogcontent() };
			for (Object p : parmas)
			{
				System.out.println(p);
			}
			qr.update(sql, parmas);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBlog(String bid)
	{
		if (bid == null || bid.trim().equals(""))
		{
			throw new RuntimeException("The id can not be empty");
		}
		try
		{
			String sql = "delete from tbl_blogger where bid=?";
			qr.update(sql, bid);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
