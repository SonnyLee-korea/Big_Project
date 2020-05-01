<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> memJoinOk </h1>
	Seq : ${member.seq }<br>
	Id : ${member.id }<br>
	Pw : ${member.pw }<br>
	Mail : ${member.mail }<br>
	Phone : ${member.phone }<br>
	<P> The time on the server is ${serverTime}</P>
	<a href="/myapp/resources/html/memJoin.html"> Go MemberJoin</a>
</body>
</html>