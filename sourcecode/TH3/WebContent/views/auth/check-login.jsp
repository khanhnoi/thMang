<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login </title>
    <link href="<%=request.getContextPath() %>/templates/css/bootstrap.css" rel="stylesheet">
	 <link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet">
  </head>
  
  <body>
 
   <section class="section-login">
  
		<div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
		
		<div class="col-xs-8 col-sm-6 col-md-6 col-lg-4 form-background">
		  <%
  String msg=request.getParameter("msg");
  if("1".equals(msg)){
	  out.print("<h3 style='text-align:center;color:yellow'>Invalid Username Or Password!</h3>");
  }
  %>
			<h3>LOGIN</h3>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<form method="post" action="<%=request.getContextPath() %>/login" name="f1" onsubmit="return checkLogin();">
					
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 form-item">
								<input type="text" name="taiKhoan" class="form-control" placeholder="Username: "/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 form-item">
								<input type="password" name="matKhau" class="form-control" placeholder="Password: "/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-6 col-sm-6 col-md-6 form-item">
								<input type="checkbox" name="Remember-me"/>Rememberme
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-6 col-sm-6 col-md-6 reset">
							<a href="#">Forgot Password ?</a>								
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 form-item">
								<!-- Show message-box-->
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-12 col-sm-12 col-md-12 form-item">
								<input type="submit" name="submit" class="btn-login" value="LOGIN "/>
							</div>
						</div>
						
						<div class="form-group user-register">
							<div class="col-xs-12 col-sm-12 col-md-12 form-item">
							</br>Don't have an Account ?
							<a href="#">Register an Account </a>								
							</div>
						</div>
					</form>
				</div>
				
			</div>
		</div>
		<div class="col-xs-2 col-sm-3 col-md-3 col-lg-4"></div>
   </section>

   
    <script src="<%=request.getContextPath() %>/templates/js/bootstrap.js"></script>
  </body>
</html>