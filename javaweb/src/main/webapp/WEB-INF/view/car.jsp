<%@ page import="javaweb.model.dto.UserDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- 核心庫 -->
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> <!-- 格式化 -->
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body>
		<!-- menu bar include -->
		<!--%@ include file="/WEB-INF/view/menu.jspf" %-->
		
		<!-- body content -->
		<div style="padding: 15px">
			<div class="pure-form">
				<fieldset>
					<legend>${userCert.username} 的 Cart購物車</legend>
					<table class="pure-table pure-table-bordered">
						<thead>
							<tr>
								<th>訂單Id</th>
								<th>使用者Id</th>
								<th>訂單日期</th>
								<th>商品Id</th>
								<th>商品名稱</th>
								<th>商品單價</th>
								<th>訂購數量</th>
								<th>總計</th>
								<th>訂單狀態</th>
							</tr>
						</thead>
						<tbody>
						<!-- 初始化"總計"變數 -->
						<c:set var="total" valuse="0"></c:set>
						<fmt:setLocale value="${locale }"/>
						<c:forEach var="userDto" items="${ userDtos }">
							<tr>
								<td>${ userDto.orderId }</td>
								<td>${ userDto.userId }</td>
								<td>${ userDto.orderDate}</td>
								<td>${ userDto.productId}</td>
								<td></td>
								<td>${ userDto.unitPrice}</td>
								<td>${ userDto.quantity }</td>
								<td>${ userDto.subtotal }</td>
								<td>${ userDto.orderStatus }</td>
							</tr>
							<c:set ="total" valuse="${total+orderDto.subtotal }"></c:set>
						</c:forEach>
						<!-- 顯示總計 -->
						<tr>
						<td colspan="7" align="right">總計</td>
						<td align="right">
						<strong>
						<fmt:formatNumber value="${total }" type="currency" />
						</strong>
						</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</body>
</html>