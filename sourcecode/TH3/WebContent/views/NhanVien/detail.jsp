
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XEM THONG TIN NHAN VIEN</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/templates/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/templates/inc/header.jsp"></jsp:include>
	<jsp:include page="/templates/inc/left-bar.jsp"></jsp:include>
	<jsp:include page="/templates/inc/right-bar.jsp"></jsp:include>
	<!-- end header -->
	<!-- Container -->
	
	<div class="container text-center" style="margin-top: 6px;">
	<!-- Container -->
	
		<div class="container text-center">
		<%
								ArrayList<NhanVien> listNV=(ArrayList<NhanVien>)request.getAttribute("listNV");
		%>
			<h1 style="color: red">NHỮNG NHÂN VIÊN THUỘC PHÒNG BAN <%=listNV.get(0).getIdpb() %></h1></br>
			
		
		<table class="tablenv">
		<tr>
			<th >IDNV</th>
			<th>Tên Nhân Viên</th>
			<th >Địa Chỉ</th>
			
		</tr>
		<% if(listNV.size()>0){
		for(NhanVien nv:listNV){ %>
		
		
								<tr>
									<td ><%=nv.getIdnv()%></td>
									<td ><%=nv.getHoten()%></td>
									<td ><%=nv.getDiachi()%></td>
									
									
								</tr>
								
		<%
									
									}}else{
										
									
			%>
			
			<tr>Không có nhân viên nào</tr>
			<%} %>
		</table>
		
	</div>
	
	<style>
.tablenv 
{
	height:80%;
	width:70%;
	border:2px solid green;
	margin-left:15%;
	margin-top:5%
}
th 
{
	
	border:2px solid green;
	text-align:center;
	height: 60px;
	
}
td
{
	border:2px solid green;
	height: 40px;
}
tr
{
	border:2px solid green;
}
	</style>
	</body>
</html>