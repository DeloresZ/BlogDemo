package me.minicoral.service.impl;

import java.util.List;

import me.minicoral.action.Blog;
import me.minicoral.dao.BlogDao;
import me.minicoral.dao.impl.BlogDaoImpl;
import me.minicoral.service.BlogService;

public class BlogServiceImpl implements BlogService
{
	BlogDao dao = new BlogDaoImpl();

	@Override
	public String addBlog(Blog blog)
	{
		dao.addBlog(blog);
		return "博客添加成功";

	}

	@Override
	public List<Blog> findAllBlogs()
	{
		return dao.findAllBlog();
	}

	@Override
	public Blog findBlogById(String bid)
	{
		Blog blog = dao.findBlogById(bid);
		return blog;
	}

	@Override
	public String updateBlog(Blog blog)
	{
		dao.updateUser(blog);
		return "更新博客成功";
	}

	@Override
	public String delBlog(String bid)
	{
		dao.deleteBlog(bid);
		return "删除成功";
	}

}
