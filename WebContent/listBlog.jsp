<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是展示博客页面</h1>
	<h3>
		<a href="${pageContext.request.contextPath}/addBlog.jsp">添加一篇博客</a>
	</h3>

	<div>
		<s:iterator value="#blogs" var="blog" status="vs">
			<tr><a href="${pageContext.request.contextPath}/user/showBlogDetail.action?bid=<s:property value="#blog.bid"/>"><s:property value="#blog.title"/></a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/user/editBlogUI.action?bid=<s:property value="#blog.bid"/>">[修改]</a>&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/user/delBlog.action?bid=<s:property value="#blog.bid"/>">[删除]</a></tr><br><br>
		</s:iterator>
	</div>
</body>
</html>