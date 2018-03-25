<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

	<head>
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>Login | Fire - Admin Template</title>
	
		<!-- Mobile Metas -->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		
		<!-- Import google fonts -->
        <link href='http://fonts.useso.com/css?family=Titillium+Web' rel='stylesheet' type='text/css'>
        
		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="<%=basePath%>view/assets/ico/favicon.ico" type="image/x-icon" />
		<link rel="apple-touch-icon" href="<%=basePath%>view/assets/ico/apple-touch-icon.png" />
		<link rel="apple-touch-icon" sizes="57x57" href="<%=basePath%>view/assets/ico/apple-touch-icon-57x57.png" />
		<link rel="apple-touch-icon" sizes="72x72" href="<%=basePath%>view/assets/ico/apple-touch-icon-72x72.png" />
		<link rel="apple-touch-icon" sizes="76x76" href="<%=basePath%>view/assets/ico/apple-touch-icon-76x76.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="<%=basePath%>view/assets/ico/apple-touch-icon-114x114.png" />
		<link rel="apple-touch-icon" sizes="120x120" href="<%=basePath%>view/assets/ico/apple-touch-icon-120x120.png" />
		<link rel="apple-touch-icon" sizes="144x144" href="<%=basePath%>view/assets/ico/apple-touch-icon-144x144.png" />
		<link rel="apple-touch-icon" sizes="152x152" href="<%=basePath%>view/assets/ico/apple-touch-icon-152x152.png" />
		
	    <!-- start: CSS file-->
		
		<!-- Vendor CSS-->
		<link href="<%=basePath%>view/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->
		<link href="<%=basePath%>view/assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />	
		
		<!-- Theme CSS -->
		<link href="<%=basePath%>view/assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="<%=basePath%>view/assets/css/style.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/css/add-ons.min.css" rel="stylesheet" />
		
		<style>
			footer {
				display: none;
			}
		</style>
		
		<!-- end: CSS file-->	
	    
		
		<!-- Head Libs -->
		<script src="<%=basePath%>view/assets/plugins/modernizr/js/modernizr.js"></script>
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->		
		
	</head>

	<body>
		<!-- Start: Content -->
		<div class="container-fluid content">
			<div class="row">
				<!-- Main Page -->
				<div id="content" class="col-sm-12 full">
					<div class="row">
						<div class="login-box">
							<div class="panel">
								<div class="panel-body">								
									<div class="header bk-margin-bottom-20 text-center">										
										<img src="<%=basePath%>view/assets/img/logo.png" class="img-responsive" alt="" />
										<h4></h4>
									</div>		
										<div class="bk-padding-left-20 bk-padding-right-20">
											<div class="form-group">
												<label></label>
												<div class="input-group input-group-icon">
													<input type="text" class="form-control bk-radius" id="username" name="userLoginName"  placeholder="请输入登录名..."/>
													<span class="input-group-addon">
														<span class="icon">
															<i class="fa fa-user"></i>
														</span>
													</span>
												</div>
											</div>											
											<div class="form-group">
												<label></label>
												<div class="input-group input-group-icon">
													<input type="password" class="form-control bk-radius" id="password" name= "userLoginPassword"  placeholder="请输入密码..."/>
													<span class="input-group-addon">
														<span class="icon">
															<i class="fa fa-key"></i>
														</span>
													</span>
												</div>
											</div>
											<div class="row bk-margin-top-20 bk-margin-bottom-10">
												<div class="col-sm-8">
													
												</div>
												<div class="col-sm-4 text-right">
													<button type="submit" id="loginsubmit" class="btn btn-primary hidden-xs"
													>点击登陆</button>
												</div>
											</div>
											<p class="text-center"><i class="fa fa-coffee"></i>&nbsp;&nbsp;&nbsp;办公自动化系统</p>
										</div>
								</div>
							</div>
								<!-- <p class="text-center text-muted">这里能写很多东西能放图片</p>	 -->
						</div>
					</div>			
				</div>
				<!-- End Main Page -->
			</div>
		</div><!--/container-->
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="<%=basePath%>view/assets/vendor/js/jquery.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/skycons/js/skycons.js"></script>	
		
		<!-- Plugins JS-->
		<script src="<%=basePath%>view/assets/plugins/bootkit/js/bootkit.js"></script>
		
		<!-- Theme JS -->		
		<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
		<script src="<%=basePath%>view/assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="<%=basePath%>view/assets/js/pages/page-login.js"></script>
		<!-- 自定义的javascript -->
		<script type="text/javascript">
		document.getElementById("loginsubmit").onclick = login;
		function login(){
			var loginName = document.getElementById("username").value;
			var loginPassword = document.getElementById("password").value;
			 $.ajax({
    			url:"login.action",
    			type:"post",
    			data:{"loginName":loginName,"loginPassword":loginPassword},
    			dataType:"json",
    			success:function(m){
    				if(m.result == "error"){
    					alert("用户名或密码错误啦！ 请重新输入 ");
    					document.getElementById("password").value = "";
    				}else if(m.result == "success"){
    					  window.location.href = "gotoIndex.action";
    					
    				}else if(m.result == "hasLogined"){
    					var choose = confirm("此账号已经被登陆，点击确定继续登陆，点击取消退出登陆 ");
    					if(choose == false){
    						document.getElementById("password").value = "";
    						return;
    					}else{
    						 $.ajax({
    				    			url:"forceLogin.action",
    				    			type:"post",
    				    			dataType:"json",
    				    			success:function(m){
    				    				if(m.result == "forceLoginSuccess"){
    				    					 window.location.href = "gotoIndex.action"; 
    				    				}
    				    			},
    				    			error:function(m){
    				    				alert("登陆失败 ");
    				    				document.getElementById("password").value = "";
    				    			}		
    						 });
    					}
    				}
    			},
    			error:function(m){
    				alert("未知错误");
    				document.getElementById("password").value = "";
    			}}) 
		}
		</script>
		<!-- end: JavaScript-->
		
		
	</body>
	
</html>