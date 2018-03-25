<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<script type="text/javascript">
/* ajax */
 window.onload = getIp;
 function getIp(){
	 $.ajax({
			url : "getIp.action",
			type : "post",
			dataType : "json",
			success : function(m) {
				if(m.result == "userSessionNull")
					window.location.replace("logout.action");
				startWebSocket(m.result,m.hostIp);
			},
			error : function(m){
				alert("error");
				window.location.replace("logout.action");
			}});
 }
/* window.onload=startWebSocket; */
var ws = null;    
function startWebSocket(result,hostIp) { 
    if ('WebSocket' in window)    
        ws = new WebSocket("ws://"+hostIp+":8080/OASystem/loginWebsocket");    
    else if ('MozWebSocket' in window)    
        ws = new MozWebSocket("ws://"+hostIp+":8080/OASystem/loginWebsocket");    
    else    
        alert("浏览器版本过低，不支持本系统部分功能 "); 
    
    ws.onmessage = function(evt) {
    	if(evt.data != "noSession" && evt.data != "relogin"){
    		 alert(evt.data);  
    	}
        window.location.replace("forceLogout.action");
    };  
    
    ws.onopen = function(evt) { 
    	sendMsg(result);
    };    
      
   /*  ws.onclose = function(evt) {    
        alert("服务器连接失败 ~");    
    };  */   
        
}    
function sendMsg(result){
	/* var message = '${ isAccess }'; 
	alert(message);
	if(message == ""){
		alert("isAccess获取不到值 值为："+message);
		message = "relogin";
	} */
	ws.send(result);
}

</script>  
<html lang="en">

	<head>
		<!-- Basic -->
    	<meta charset="UTF-8" />
		<title>Dashboard | Fire - Admin Template</title>
		<!-- Mobile Metas -->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0"> 
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
		<link href="<%=basePath%>view/assets/vendor/css/pace.preloader.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->
		<link href="<%=basePath%>view/assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />	
		<link href="<%=basePath%>view/assets/plugins/scrollbar/css/mCustomScrollbar.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/magnific-popup/css/magnific-popup.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/jqvmap/jqvmap.css" rel="stylesheet" />
		
		<!-- Theme CSS -->
		<link href="<%=basePath%>view/assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="<%=basePath%>view/assets/css/style.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/css/add-ons.min.css" rel="stylesheet" />
		
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
	
		<!-- Start: Header -->
		<div class="navbar" role="navigation">
			<div class="container-fluid container-nav">
				<!-- Navbar Action -->
				<ul class="nav navbar-nav navbar-actions navbar-left">
					<li class="visible-md visible-lg"><a href="#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
					<li class="visible-xs visible-sm"><a href="#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
				</ul>
				<!-- Navbar Left -->
				<div class="navbar-left">
					<!-- Search Form -->					
					<form class="search navbar-form">
						<div class="input-group input-search">
							<input type="text" class="form-control bk-radius" name="q" id="q" placeholder="搜索感兴趣的东西...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
							</span>
						</div>						
					</form>
				</div>
				<!-- Navbar Right -->
				<div class="navbar-right">					
					<!-- Notifications -->
					<!-- End Notifications -->					
					<!-- Userbox -->
					<div class="userbox">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<figure class="profile-picture hidden-xs">
								<img src="<%=basePath%>view/assets/img/avatar1.jpg" class="img-circle" alt="" />
							</figure>
							<div class="profile-info">
								<span class="name">${user.userTrueName}</span>
								<span class="role"><i class="fa fa-circle bk-fg-success"></i>${user.role.roleName}</span>
							</div>			
							<i class="fa custom-caret"></i>
						</a>
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="dropdown-menu-header bk-bg-white bk-margin-top-15">						
									<div class="progress progress-xs  progress-striped active">
										<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
											60%
										</div>
									</div>							
								</li>	
								<li>
									<a href="logout.action"><i class="fa fa-power-off"></i>注销</a>
								</li>
							</ul>
						</div>						
					</div>
					<!-- End Userbox -->
				</div>
				<!-- End Navbar Right -->
			</div>		
		</div>
		<!-- End: Header -->
		<!-- Start: Content -->
		<div class="container-fluid content">	
			<div class="row">
			
<!--
	*******************************
 		Sidebar 左侧导航
 	*******************************	
 									-->
				<div class="sidebar">
					<div class="sidebar-collapse">
						<!-- Sidebar Header Logo-->
						<div class="sidebar-header">
							<img src="<%=basePath%>view/assets/img/logo.png" class="img-responsive" alt="" />
						</div>
<!-- 
	*******************************
	Sidebar Menu     左侧导航菜单在这里开始

	*******************************
									-->
						<div class="sidebar-menu">						
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-sidebar">
									<div class="panel-body text-center">								
										<div class="flag">
										<%-- 	<img src="<%=basePath%>view/assets/img/flags/china.png" class="img-flags" alt="" /> --%>
										</div>
									</div>
									<li class="active">
										<a href="toSignIN.action?userIds=<s:property value="#session.user.userId"/>" target="newframe">
											<i class="fa fa-laptop" aria-hidden="true"></i><span>主面板</span>
										</a>
									</li>
									<li><a href="toMessage.action?userIds=<s:property value="#session.user.userId"/>" target="newframe">
									<%--  <span class="pull-right label label-danger">235</span> <i
										class="fa fa-envelope" aria-hidden="true"></i> --%>
										<i class="fa fa-envelope" aria-hidden="true"></i><span>邮件</span>
									</a></li>
									
									<!-- <li class="nav-parent">
										<a>
											<i class="fa fa-copy" aria-hidden="true"></i><span>Pages</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="page-profile.html"><span class="text"> Profile</span></a></li>
											<li><a href="page-activity.html"><span class="text"> Activity</span></a></li>
											<li><a href="page-timeline.html"><span class="text"> Timeline</span></a></li>
											<li><a href="page-invoice.html"><span class="text"> Invoice</span></a></li>
										</ul>
									</li>
									<li class="nav-parent">
										<a>
											<i class="fa fa-bolt" aria-hidden="true"></i><span>Icons</span>
										</a>
										<ul class="nav nav-children">
											<li><a href="icons-font-awesome.html"><span class="text"> Font Awesome</span></a></li>
											<li><a href="icons-weathericons.html"><span class="text"> Weather Icons</span></a></li>
											<li><a href="icons-glyphicons.html"><span class="text"> Glyphicons</span></a></li>
										</ul> -->
										<s:iterator value="navList" var="nav"> 
										<s:if test="#nav != null"> 
												<s:if test="#nav.navParentId == 0">
													<li class="nav-parent">
															<a><i class="${ nav.navClass }" aria-hidden="true"></i><span>${ nav.navValue }</span></a>
														<ul class="nav nav-children">
												</s:if>
												<s:if test="#nav.navParentId != 0">
													<li><a href="${nav.navUrl}" target="newframe"><span class="text"> ${ nav.navValue }</span></a></li>
												</s:if>
										</s:if><s:if test="#nav == null">
													</ul></li>
												</s:if>
										</s:iterator>
									</li>
								</ul>
							</nav>
						</div>
<!-- 
	*******************************
	Sidebar Menu     左侧导航菜单在这里结束

	*******************************
									-->
					</div>
					<!-- Sidebar Footer-->
					<div class="sidebar-footer">					
						<div class="small-chart-visits">
							<div class="small-chart" id="sparklineLineVisits"></div>
							<div class="small-chart-info">
								<label>New Visits</label>
								<strong>70,79%</strong>
							</div>
							<script type="text/javascript">
								var sparklineLineVisitsData = [15, 16, 17, 19, 15, 25, 23, 35, 29, 15, 30, 45];
							</script>
						</div>
					</div>
					<!-- End Sidebar Footer-->
				</div>
				<!-- End Sidebar -->
						
				<!-- Main Page -->
				<div class="main ">
					<!-- Page Header -->
					<div class="page-header">
						<div class="pull-left" id="tishi1">
							<table><tr><td> <h2 style="color: yellow;">!&nbsp;温馨提示：</h2></td><td style="color: black;"><h4>(上班时间为8:30:00 A.M )</h4></td><td><h2>亲，要及时签到哦！！</h2></td></tr></table>						
						</div>
						<div class="pull-left" id="tishi2" style="display: none;">
							<table><tr><td> <h2 style="color: orange;">!&nbsp;温馨提示：</h2></td><td style="color: black;"><h4>(下班时间为6:00:00 P.M )</h4></td><td><h2>亲，要及时签退哦！！</h2></td></tr></table>						
						</div>				
					</div>
					
				<!-- //加载其余页面	 -->
				<iframe  src="toSignIN.action?userIds=<s:property value="#session.user.userId"/>" id="newframe" name="newframe" style="width:100%;border: 0" height="900px"></iframe>
				</div>
				<!-- End Page Header -->
				
				<!-- 中间内容开始 -->
				
				<!-- 中间内容结束 -->
				<!-- Footer -->
				<div id="footer">
					<ul>
						<li>
							<div class="title">Memory</div>
							<div class="bar">
								<div class="progress light progress-sm  progress-striped active">
									<div class="progress-bar progress-squared progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
										60%
									</div>
								</div>
							</div>			
							<div class="desc">4GB of 8GB</div>
						</li>
						<li>
							<div class="title">HDD</div>
							<div class="bar">
								<div class="progress light progress-sm  progress-striped active">
									<div class="progress-bar progress-squared progress-bar-primary" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
										40%
									</div>
								</div>
							</div>			
							<div class="desc">250GB of 1TB</div>
						</li>
						<li>
							<div class="title">SSD</div>
							<div class="bar">
								<div class="progress light progress-sm  progress-striped active">
									<div class="progress-bar progress-squared progress-bar-warning" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
										70%
									</div>
								</div>
							</div>			
							<div class="desc">700GB of 1TB</div>
						</li>
						<li>
							<div class="copyright">
								<p class="text-muted text-right">Fire <i class="fa fa-coffee"></i> Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></p>
							</div>
						</li>				
					</ul>	
				</div>
				<!-- End Footer -->
			
			</div>
		</div>
		
		
		<!--/container-->
		
		
		<div class="clearfix"></div>		
		
		
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="<%=basePath%>view/assets/vendor/js/jquery.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/skycons/js/skycons.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/pace.min.js"></script>
		
		<!-- Plugins JS-->
		<script src="<%=basePath%>view/assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/bootkit/js/bootkit.js"></script>
		<script src="<%=basePath%>view/assets/plugins/magnific-popup/js/magnific-popup.js"></script>
		<script src="<%=basePath%>view/assets/plugins/moment/js/moment.min.js"></script>	
		<script src="<%=basePath%>view/assets/plugins/fullcalendar/js/fullcalendar.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot/js/jquery.flot.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot/js/jquery.flot.pie.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot/js/jquery.flot.resize.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot/js/jquery.flot.stack.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot/js/jquery.flot.time.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/flot-tooltip/js/jquery.flot.tooltip.js"></script>
		<script src="<%=basePath%>view/assets/plugins/chart-master/js/Chart.js"></script>
		<script src="<%=basePath%>view/assets/plugins/jqvmap/jquery.vmap.js"></script>
		<script src="<%=basePath%>view/assets/plugins/jqvmap/data/jquery.vmap.sampledata.js"></script>
		<script src="<%=basePath%>view/assets/plugins/jqvmap/maps/jquery.vmap.world.js"></script>
		<script src="<%=basePath%>view/assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>
		
		<!-- Theme JS -->		
		<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
		<script src="<%=basePath%>view/assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="<%=basePath%>view/assets/js/pages/index.js"></script>
		<!-- end: JavaScript-->
	</body>
	
</html>