package me.minicoral.action;

import java.util.Date;
import java.util.UUID;

import me.minicoral.service.UserService;
import me.minicoral.service.impl.UserServiceImpl;
import me.minicoral.util.MD5Util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String userid;
	private String uname;
	private String blogname;
	private String userpass;
	private String email;
	private String descriptions;
	private String createtime;
	private Date lastmodifytime;
	private String delflag;

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public String getBlogname()
	{
		return blogname;
	}

	public void setBlogname(String blogname)
	{
		this.blogname = blogname;
	}

	public String getUserpass()
	{
		return userpass;
	}

	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDescriptions()
	{
		return descriptions;
	}

	public void setDescriptions(String descriptions)
	{
		this.descriptions = descriptions;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public Date getLastmodifytime()
	{
		return lastmodifytime;
	}

	public void setLastmodifytime(Date lastmodifytime)
	{
		this.lastmodifytime = lastmodifytime;
	}

	public String getDelflag()
	{
		return delflag;
	}

	public void setDelflag(String delflag)
	{
		this.delflag = delflag;
	}

	@Override
	public String toString()
	{
		return "User [userid=" + userid + ", uname=" + uname + ", blogname="
				+ blogname + ", userpass=" + userpass + ", email=" + email
				+ ", descriptions=" + descriptions + ", createtime="
				+ createtime + ", lastmodifytime=" + lastmodifytime
				+ ", delflag=" + delflag + "]";
	}

	private UserService s = new UserServiceImpl();
	public String login()
	{
		User user = s.login(uname, userpass);
		if (user == null)
		{
			return LOGIN;
		}
		else
		{
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", user);
			return SUCCESS;
		}
	}
	public String register()
	{
		//单独处理Userid采用UUID随机值
		setUserid(UUID.randomUUID().toString());
		//单独处理密码采用MD5加密
		setUserpass(MD5Util.encode(getUserpass()));
		//单独处理是否删除标志
		setDelflag("1");
		System.out.println(this);
		String message = s.addUser(this);
		ActionContext.getContext().put("message", message);
		return SUCCESS;
	}
}
