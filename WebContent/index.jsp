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
	<s:form action="login" namespace="/user">
		<s:textfield name="uname" label="用户名" />
		<s:password name="userpass" label="密码" />
		<s:submit value="登录" />
	</s:form>
	<h3>还没有账号？点此<a href="${pageContext.request.contextPath}/register.jsp">立即注册</a></h3>
</body>
</html>