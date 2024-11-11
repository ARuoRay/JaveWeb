<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/css/buttons.css">
	</head>
	<body>
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<div style="padding:15px">
			<div class="pure-form">
				<legend>發生錯誤</legend>
				${message }
			</div>
		</div>
	</body>
</html>