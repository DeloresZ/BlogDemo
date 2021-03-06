package me.minicoral.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class PermissionInterceptor implements Interceptor
{
    public void destroy() {
    }
    public void init() {
    }
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object obj = session.getAttribute("user");
        if(obj==null){
            return "login";
        }else{
            return invocation.invoke();
        }
    }
}