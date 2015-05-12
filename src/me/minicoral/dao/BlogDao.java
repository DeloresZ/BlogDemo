package me.minicoral.dao;

import java.util.List;

import me.minicoral.action.Blog;

public interface BlogDao
{
	/**
	 * 添加博客
	 * @param blog
	 */
	void addBlog(Blog blog);
	
	/**
	 * 查询所有博客
	 * @return
	 */
	List<Blog> findAllBlog();
	
	/**
	 * 通过博客号码查找博客
	 * @param title 博客号码
	 * @return 一篇博客对象
	 */
	Blog findBlogById(String bid);

	/**
	 * 通过条件查询
	 * @param condition 条件
	 * @return 
	 */
	List<Blog> findUserByCondition(String condition);
	
	/**
	 * 更新博客
	 * @param blog
	 */
	void updateUser(Blog blog);

	/**
	 * 通过Id删除
	 * @param bid
	 */
	void deleteBlog(String bid);
}
