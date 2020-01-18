<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Hello World JSP Page</h2>

<hr>
<h3>Link to Hello World REST Service</h3>
<a href="${pageContext.request.contextPath}/test/hello">Say Hello</a>

<hr>
<h3>See list of students</h3>
<a href="${pageContext.request.contextPath}/api/students">Students List</a>

</body>
</html>