<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>404</title>
	 
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
					<div class="row box-error">					
						<div class="col-lg-12 col-md-12 col-xs-12">
							<div class="text-center">
								<h1>404</h1>
								<h2>服务器响应错误页面不存在</h2>
								<p>请求错误. ...</p>
								<a href="javascript: history.go(-1)">
									<button type="button" class="btn btn-primary"><i class="fa fa-chevron-left"></i>返回</button>
								</a>
								<a href="view/login.jsp">
									<button type="button" class="btn btn-primary"><i class="fa fa-lock"></i> 登陆</button>
								</a>
								<a href="view/login.jsp">
									<button type="button" class="btn btn-primary"><i class="fa fa-envelope"></i> 联系我们</button>
								</a>
							</div>						
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
		
		<!-- Theme JS -->		
		<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
		<script src="<%=basePath%>view/assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="<%=basePath%>view/assets/js/pages/page-404.js"></script>
		
		<!-- end: JavaScript-->
		
	</body>
	
</html>