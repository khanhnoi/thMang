<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Quản Lý Phòng Ban</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/templates/css/reset.css"
	type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/templates/css/style.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<div class="header" style='background-color:#e4ff0161;'>
			<table border="1">
				<tr>
					<td><img alt="1.jpg"
						src="<%=request.getContextPath()%>/templates/images/1.jpg" /></td>
					<td><marquee width="940px" bgcolor="#e4ff0161">
							<p>CHƯƠNG TRÌNH QUẢN LÝ PHÒNG BAN</p>
						</marquee></td>
					<td><img alt="2.jpg"
						src="<%=request.getContextPath()%>/templates/images/22.jpg" /></td>
				</tr>
				<tr><%
            	if(session.getAttribute("user")!=null){
            		User userr=(User) session.getAttribute("user");
            	
            %>
            <p style="color: black;padding: 15px 100px 5px 50px;float: right;font-size: 16px;"> Xin chào,<%=userr.getUsername() %> &nbsp; <a href="<%=request.getContextPath() %>/logout" class="btn btn-danger square-btn-adjust">Đăng xuất</a> </p>
      		 <%} %>
				</tr>
			</table>
		</div>