package me.minicoral.action;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import me.minicoral.service.BlogService;
import me.minicoral.service.impl.BlogServiceImpl;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Blog extends ActionSupport
{
	private String bid;
	private String userid;
	private String title;
	private String blogcontent;
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid = bid;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String uid)
	{
		this.userid = uid;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String tittle)
	{
		this.title = tittle;
	}
	
	public String getBlogcontent()
	{
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent)
	{
		this.blogcontent = blogcontent;
	}
	@Override
	public String toString()
	{
		return "Blog [bid=" + bid + ", userid=" + userid + ", title=" + title
				+ ", blogcontent=" + blogcontent + "]";
	}
	private BlogService s = new BlogServiceImpl();
	public String addBlog()
	{
		//单独处理博客ID
		bid = UUID.randomUUID().toString();
		//单独获取用户ID
		ActionContext actionContext=ActionContext.getContext();  
		Map session=actionContext.getSession();  
		User user = (User) session.get("user");
		System.out.println(user);
		userid = user.getUserid();
		System.out.println(this);
		String message = s.addBlog(this);
		System.out.println(message);
		ActionContext.getContext().put("message", message);
		return SUCCESS;
	}
	
	public String showBlog()
	{
		List<Blog> blogs = s.findAllBlogs();
		ActionContext.getContext().put("blogs",blogs);
//		for (Blog blog : blogs)
//		{
//			System.out.println(blog);
//		}
		return SUCCESS;
	}
	
	public String showBlogDetail()
	{
		String bid = ServletActionContext.getRequest().getParameter("bid");
		Blog blog = s.findBlogById(bid);
		ActionContext.getContext().put("blog",blog);
		return SUCCESS;
	}
	
	public String editBlogUI(){
        String bid = ServletActionContext.getRequest().getParameter("bid");
        Blog blog = s.findBlogById(bid);
        ActionContext.getContext().put("blog",blog);
        return SUCCESS;
    }
	
	public String editBlog(){
		
		System.out.println(this);
		String message = s.updateBlog(this);
        ActionContext.getContext().put("message",message);
        return SUCCESS;
    }
	
	public String delBlog(){
        String bid = ServletActionContext.getRequest().getParameter("bid");
        String message = s.delBlog(bid);
        ActionContext.getContext().put("message",message);
        System.out.println(this);
        return SUCCESS;
    }
}
