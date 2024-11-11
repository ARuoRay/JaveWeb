<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" perfix="c" %>
<%@ taglib uri="jakarta.tags.fmt" perfix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Room</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/css/buttons.css">
	</head>
	<body >
			<!-- menu bar include -->
			<%@ include file="/WEB-INF/view/menu.jspf" %>

			<!-- body content -->
			<div style="padding":15px>
			<table>
				<tr>
				<!-- 表單 -->
				<td valign="top">
					<%@ include file="/WEB-INF/view/room_form.jspf" %>
					
				</td>
				
				<!-- 內容 -->
				<td valign="top">
					<%@ include file="/WEB-INF/view/room_form.jspf" %>
					
				</td>
				
				</tr>
			</table>
			&{ roomDtos }
			</div>
	</body>
</html>