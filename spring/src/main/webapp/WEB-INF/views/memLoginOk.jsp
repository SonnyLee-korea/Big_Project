<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> memLoginOk </h1>
	
	ID : ${member.id }<br>
	PW : ${member.pw }
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="/myapp/resources/html/index.html"> Go Main </a>
</body>
</html>