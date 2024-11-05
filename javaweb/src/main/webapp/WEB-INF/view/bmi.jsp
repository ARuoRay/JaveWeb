<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
身高:<%=request.getAttribute("height") %><p/>
體重:<%=request.getAttribute("weight") %><p/>
BMI<%=request.getAttribute("bmi") %><p/>
</h1>

</body>
</html>