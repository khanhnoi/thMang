
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="left-bar" style='background-color:#7d70e6;'>
	<ul>
		<li><a href="<%=request.getContextPath()%>/HomeController">Trang
				chủ</a></li>
		<li><a href="<%=request.getContextPath()%>/NhanVienController">Xem
				nhân viên</a></li>
		<li><a href="<%=request.getContextPath()%>/PhongBanController">Xem
				phòng ban</a></li>
		<li><a href="<%=request.getContextPath()%>/XoatatcaphongbanController"onclick="return confirm('Bạn có chắc muốn xóa hết cất cả các phòng ban?')">Xóa tất cả phòng ban</a></li>
		<li><a href="<%=request.getContextPath()%>/XoatatcanhanvienController" onclick="return confirm('Bạn có chắc muốn xóa hết cất cả các nhân viên?')">Xóa tất cả các nhân viên</a></li>
		<li><a href="<%=request.getContextPath()%>/TrogiupchuongtrinhController">Trợ giúp chương
				trình</a></li>
	</ul>
</div>
<style>
.wrapper .left-bar ul li{
	border:1px solid #6c6cdb;
	border-radius:10px;
	margin-bottom:10px;
	text-align:center;
	background-color: white;
	font-size: 18px;
}
.wrapper .left-bar ul {
    border: 1px solid black;
    padding: 10px;
    background-color: #7d70e6;
    min-height: 450px;
}

</style>