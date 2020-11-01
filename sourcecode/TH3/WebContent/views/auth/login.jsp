<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>Đăng nhập</title>
	<%@include file="/templates/inc/header.jsp" %>
	<%@include file="/templates/inc/left-bar.jsp" %>
	<%@include file="/templates/inc/right-bar.jsp" %>
	<%
		String msg = (String)request.getAttribute("msg");

	%>
	<div class="center">
		<form method="post" action="<%=request.getContextPath() %>/login" name="f1" onsubmit="return checkLogin();">
			<h1>Đăng nhập hệ thống quản lý phòng ban</h1>
			<span class="loi"><%if(msg!=null) out.print(msg);%></span>
			<span id="loi"></span>
			<label>Tài khoản: </label>
			<input type="text" class="" name="taiKhoan" style="width: 130px;"/>
			<br/>
			<br/>
			<label>Mật khẩu: </label>
			<input type="password" class="" name="matKhau"  style="width: 130px;" />
			<br/>
			<br/>
			<input type="submit" name="dangNhap" value="Đăng nhập" class="" />
			<input type="reset" name="nhapLai" value="Nhập lại" class="" />
		</form>
	</div>
	<script type="text/javascript">
		function checkLogin(){
			var taiKhoan,matKhau,msg="";
			taiKhoan = document.getElementsByName("taiKhoan")[0];
			matKhau = document.getElementsByName("matKhau")[0];
			switch(msg){
				case taiKhoan.value:
					msg="Tài khoản không được để trống";
					taiKhoan.focus();
					break;
				case matKhau.value:
					msg="Mật khẩu không được để trống";
					matKhau.focus();
					break;
			}
			if(taiKhoan.value.length>30){
				msg="Tài khoản phải nhỏ hơn 30 ký tự";
				taiKhoan.focus();
			}else
			if(matKhau.value.length>30){
				msg="Mật khẩu phải nhỏ hơn 30 ký tự";
				matKhau.focus();
			
			}
			if(msg!=""){
				document.getElementById("loi").innerHTML=msg;
				return false;
			}
		}
	</script>
	</div>
	</body>
</html>
