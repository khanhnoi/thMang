
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
</head>
<body>
	<!-- Header -->
	<jsp:include page="/templates/inc/header.jsp"></jsp:include>
	<jsp:include page="/templates/inc/left-bar.jsp"></jsp:include>
	<jsp:include page="/templates/inc/right-bar.jsp"></jsp:include>
	<!-- end header -->
	<!-- Container -->
	<div class="container text-left">
		<h1 style="color: red">Trợ giúp chương trình</h1>
		
		
		<div class="col-md-8 col-sm-8 col-xs-8 borderCenter style='font-size:120%'">
		<ul style='color:black' style='font-weight:30px'>
			<li style='color:green'>
				Muốn truy cập các chức năng cần đăng nhập vào hệ thống
			</li>
			<li style='color:green'>
				*Sau khi đăng nhập: 
			</li>
			<li style='color:green'>
				*Chọn menu "Trang chủ" để xem trang chủ của hệ thống 
			</li>
			<li style='color:green'>
				*Chọn menu "Xem nhân viên" để xem danh sách nhân viên. Tại đây ta có thể thực hiện các chức năng
				<ul >
					<li style='color:black'>
						+Chỉnh sửa thông tin.  
					</li>
					<li style='color:black'>
						+Chức năng tìm kiếm nhân viên theo id.  
					</li>
					<li style='color:black'>
						+Xóa 1 nhân viên.  
					</li>
					<li style='color:black'>
						+Thêm nhân viên  
					</li>
					<li style='color:black'>
						+Xem chi tiết để xem những nhân viên thuộc cùng phòng ban đã chọn
					</li>
				</ul> 
			</li>
			<li style='color:green'>
				*Chọn menu "Xem phòng ban" để xem danh sách phòng ban. Tại đây ta có thể thực hiện các chức năng
				<ul>
					<li style='color:black'>
						+Chỉnh sửa thông tin.  
					</li>
					<li style='color:black'>
						+Chức năng tìm kiếm  theo id.  
					</li>
					<li style='color:black'>
						+Xóa 1 phòng ban.  
					</li>
					<li style='color:black'>
						+Thêm phòng ban  
					</li>
					<li style='color:black'>
						+Xem chi tiết để xem những nhân viên thuộc cùng phòng ban đã chọn.
					</li>
				</ul> 
			</li>
			<li style='color:green'>
				*Chọn menu "Xóa tất cả các phòng ban" để xóa tất cả các phòng ban
			</li>
			<li style='color:green'>
				*Chọn menu "Xóa tất cả các nhân viên" để xóa tất cả các nhân viên
			</li>
			<li style='color:green'>
				*Chọn menu "Trợ giúp chương trình " để xem hướng dẫn 
			</li>
			
		</ul>
		</div>
	</div>
</body>
</html>