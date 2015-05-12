<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改博客</title>
</head>
<body>
	<s:form action="editBlog" namespace="/user">
		<s:hidden name="bid" value="%{#blog.bid}"></s:hidden>
		<s:hidden name="userid" value="%{#blog.userid}"></s:hidden>
		<s:textfield name="title" label="标题" value="%{#blog.title}"/>
		<s:textarea name="blogcontent" label="内容" rows="3" cols="45" value="%{#blog.blogcontent}" />
		<s:submit value="保存" />
	</s:form>
	<s:debug></s:debug>
</body>
</html>