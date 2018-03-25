<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

	<head>
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>Advanced Table | Fire - Admin Template</title>
	 
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
		<link href="<%=basePath%>view/assets/vendor/css/pace.preloader.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->
		<link href="<%=basePath%>view/assets/plugins/bootkit/css/bootkit.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/select2/select2.css" rel="stylesheet" />
		<link href="<%=basePath%>view/assets/plugins/jquery-datatables-bs3/css/datatables.css" rel="stylesheet" />		
		
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
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="width: 50%">
	<div class="panel panel-default bk-bg-white">
								<div class="panel-heading bk-bg-white">
									<h6><i class="fa fa-indent red"></i>添加成员</h6>							
									<div class="panel-actions">
										<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
										<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
									</div>
								</div>
								<div class="panel-body">
									<form action="addUserSave.action" method="post"  class="form-horizontal ">
										<div class="form-group">
											<label class="col-md-3 control-label" for="text-input">姓名：</label>
											<div class="col-md-9">
												<input type="text" id="" name="addUser.userTrueName" class="form-control" placeholder="张三" autofocus="autofocus">
											</div>
										</div>
										<!-- 性别 -->
										<div class="form-group">
											<label class="col-md-3 control-label">性别：</label>
											<div class="col-md-9">
												<div class="radio-custom radio-inline">
													<input type="radio" id="gender_1" name="addUser.userProfile.userGender" value="m" checked="checked"> 
													<label for="gender_1" > 男</label>
												</div>
												<div class="radio-custom radio-inline">
													<input type="radio" id="gender_2" name="addUser.userProfile.userGender" value="w"> 
													<label for="gender_2"> 女</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="dept">部门：</label>
											<div class="col-md-9">
											<s:select list="deptList" id="dept" name="addUser.department.deptId" listKey="deptId" listValue="deptName" cssClass="form-control" size="1" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="role">职位：</label>
											<div class="col-md-9" style="float:left;">
											
												<select id="role" name="addUser.role.roleId" class="form-control" size="1">
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-md-3 control-label">状态：</label>
											<div class="col-md-9">
												<div class="radio-custom radio-inline">
													<input type="radio" id="inline-radio1" name="addUser.userState" value="0" checked="checked"> 
													<label for="inline-radio1" > 实习</label>
												</div>
												<div class="radio-custom radio-inline">
													<input type="radio" id="inline-radio2" name="addUser.userState" value="1"> 
													<label for="inline-radio2"> 在职</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="idCard">身份证：</label>
											<div class="col-md-9">
												<input type="text" id="idCard" name="addUser.userProfile.userIdCard" class="form-control">
											</div>
										</div>
										<!-- 日期  时间 生日 -->
										<div class="form-group">
											<label class="col-md-3 control-label">出生日期</label>
											<div class="col-md-6">
												<div class="input-group has-warning">
													<span class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</span>
													<input id="date" data-plugin-masked-input data-input-mask="9999/99/99" placeholder="____/__/__" class="form-control" name="addUser.userProfile.userBirthday"/>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="loginName">登录名：</label>
											<div class="col-md-9">
												<input type="text" id="loginName" name="addUser.userLoginName" class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="phone">手机号：</label>
											<div class="col-md-9">
												<input type="text" id="phone" name="addUser.userProfile.userPhone" class="form-control" >
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="email-input">邮箱：</label>
											<div class="col-md-9">
												<input type="email" id="email-input" name="addUser.userProfile.userEmail" class="form-control" placeholder="123@qq.com">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-3 control-label" for="textarea-input">备注：</label>
											<div class="col-md-9">
												<textarea id="textarea-input" name="addUser.userProfile.userRemark" rows="9" class="form-control"></textarea>
											</div>
										</div>
										<div class="row" align="right">
											<div class="col-sm-9 col-sm-offset-3">
											<button type="submit" class="bk-margin-5 btn btn-primary" >提交</button>
												<button type="button" class="bk-margin-5 btn btn-default" onclick="history.go(-1)">取消</button>
											</div>
										</div>
									</form>
								</div>		
								
								<!-- 下面扯犊子 -->	
													
							</div>
	
			</div>
	</body>
	<!-- Vendor JS-->				
		<script src="<%=basePath%>view/assets/vendor/js/jquery.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/skycons/js/skycons.js"></script>	
		<script src="<%=basePath%>view/assets/vendor/js/pace.min.js"></script>
		
		<!-- Plugins JS-->
		<script src="<%=basePath%>view/assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/touchpunch/js/jquery.ui.touch-punch.min.js"></script>		
		<script src="<%=basePath%>view/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
		<script src="<%=basePath%>view/assets/plugins/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
		<script src="<%=basePath%>view/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
		<script src="<%=basePath%>view/assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.js"></script>
		<script src="<%=basePath%>view/assets/plugins/maskedinput/js/jquery.maskedinput.js"></script>
		<script src="<%=basePath%>view/assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>
		
		<!-- Theme JS -->		
		<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
		<script src="<%=basePath%>view/assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="<%=basePath%>view/assets/js/pages/form-elements.js"></script>
		<script type="text/javascript">
			$(function(){
				getRoleAjax();
			})
			$("#dept").change(function (){
				$("#role").empty();
				getRoleAjax();
			});
			
			function getRoleAjax(){
				var deptId = $("#dept").val();
				$.ajax({
					url : "getRoleByDept.action",
					type : "post",
					data : {"deptId":deptId},
					dataType : "json",
					success : function(m) {
					var result = m.roleList;
					result = eval("("+result+")");
					for(var i=0;i<result.length;i++){
						$("<option />").appendTo("#role").attr("value",result[i].roleId).text(result[i].roleName);
					}
				},
					error : function(m){
					alert("error");	
					
					}
			});
			}
		</script>
</html>