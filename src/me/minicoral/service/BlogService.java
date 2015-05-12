package me.minicoral.service;

import java.util.List;

import me.minicoral.action.Blog;

public interface BlogService
{
	String addBlog(Blog blog);
	
	List<Blog> findAllBlogs();

	Blog findBlogById(String bid);
	
	String updateBlog(Blog blog);

	String delBlog(String bid);
}
