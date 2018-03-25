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
	
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="panel panel-default bk-bg-white">
								<div class="panel-heading bk-bg-white">
									<h6><i class="fa fa-table red"></i><span class="break"></span>用户管理</h6>
									<div class="panel-actions">
										<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
										<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
									</div>
								</div>
								<div class="panel-body">
								<div class="bk-margin-bottom-10">
										<button  class="btn btn-info" onclick="window.location.href='addUser.action'">添加成员<i class="fa fa-plus"></i></button>
									</div>
									<table class="table table-bordered table-striped mb-none" id="datatable-details">
										<thead>
											<tr>
												<th hidden="true"></th>
												<th></th>
												<th>姓名</th>
												<th>状态</th>
												<th>所属部门</th>
												<th>角色</th>
												<th>注册时间</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="userList" var="user">
											<tr class="gradeA">
												<td  hidden="true"><s:property value="#user.userId" /></td>
												<td class="text-center"><i data-toggle class="fa fa-plus-square-o text-primary h5 m-none" style="cursor: pointer;"></i></td>
												<td ><s:property value="#user.userTrueName" /> </td>
												<td><s:if test="#user.userState == 0">实习</s:if> 
													<s:if test="#user.userState == 1">在职</s:if>
													<s:if test="#user.userState == -1">离职</s:if>
												</td>
												<td><s:property value="#user.department.deptName" /></td>
												<td class="center"><s:property value="#user.role.roleName" /></td>
												<td class="center"><s:property value="#user.userProfile.userCreateTime" /></td>
											</tr>
										</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						
				<!-- End Main Page -->
					
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="<%=basePath%>view/assets/vendor/js/jquery.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>view/assets/vendor/skycons/js/skycons.js"></script>	
		<script src="<%=basePath%>view/assets/vendor/js/pace.min.js"></script>
		
		<!-- Plugins JS-->
		<script src="<%=basePath%>view/assets/plugins/moment/js/moment.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/select2/select2.js"></script>				
		<script src="<%=basePath%>view/assets/plugins/jquery-datatables/media/js/jquery.dataTables.js"></script>
		<script src="<%=basePath%>view/assets/plugins/jquery-datatables/extras/TableTools/js/dataTables.tableTools.min.js"></script>
		<script src="<%=basePath%>view/assets/plugins/jquery-datatables-bs3/js/datatables.js"></script>		
		<script src="<%=basePath%>view/assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>
		<!-- Theme JS -->		
		<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
		<script src="<%=basePath%>view/assets/js/core.min.js"></script>
		
		<!-- Pag es JS -->
		<script src="<%=basePath%>view/assets/js/pages/table-advanced.js"></script>
		<script type="text/javascript">/*  初始化 */
		//呵呵呵
		function fnFormatDetails   ( datatable, tr) {
			var id = datatable.fnGetData( tr )[0];
			var userGender;
			var userIdCard;
			var userPhone;
			var userBirthday;
			var userEmail;
			var userRemark;
			 $.ajax({
	    			url:"getUserMessage.action",
	    			type:"post",
	    			data:{"showUserId":id},
	    			dataType:"json",
	    			async:false,
	    			success:function(m){
	    				var user = m.showUserProfile;
	    				userIdCard = user.userIdCard == null ? "" :user.userIdCard;
	    				userPhone = user.userPhone == null ? "" :user.userPhone;
	    				userBirthday = user.userBirthday == null ? "" :user.userBirthday;
	    				userEmail = user.userEmail == null ? "" :user.userEmail;
	    				userRemark = user.userRemark == null ? "" :user.userRemark;
	    				if(user.userGender == "m"){
	    					userGender = "男";
	    				}else if(user.userGender == "w"){
	    					userGender = "女";
	    				}else{
	    					userGender = "";
	    				}
	    				
	    				str ='<table class="table mb-none"><tr class="b-top-none"><td   style="width: 4.5%"></td><td  style="width: 18.5%"><label class="mb-none">性别:&nbsp;&nbsp;</label>'+userGender+'</td><td   style="width: 34%"></td><td>'+
						'<a class="btn btn-info" href="#"><i class="fa fa-edit "></i>&nbsp;修改</a>&nbsp;&nbsp;'+
						'<a class="btn btn-danger" href="#"><i class="fa fa-trash-o "></i>&nbsp;离职</a></td></tr>'+
	    				'<tr class="b-top-none"><td></td><td><label class="mb-none">身份证号：&nbsp;&nbsp;</label>'+userIdCard+'</td><td><label class="mb-none">手机号：&nbsp;&nbsp;</label>'+userPhone+'</td><td></td></tr>'+
	    				'<tr class="b-top-none"><td></td><td><label class="mb-none">出生日期：&nbsp;&nbsp;</label><time>'+userBirthday+'</time></td><td></td><td></td></tr>'+
	    				'<tr class="b-top-none"><td></td><td><label class="mb-none">Email：&nbsp;&nbsp;</label>'+userEmail+'</td><td></td><td></td></tr>'+
	    				'<tr class="b-top-none"><td></td><td colspan="2"><label class="mb-none">备注：&nbsp;&nbsp;</label>'+userRemark+'</td><td></td></tr></div>';
	    			},
	    			
	    			error:function(m){
	    				alert("error");
	    			}});
			 //alert(userIdCard);
			console.debug("str:"+str);
			 return str;
		};
		(function( $ ) {

			

			var datatableInit = function() {
				var $table = $('#datatable-details');
				
				// format function for row details
		

				// insert the expand/collapse column
				// initialize
				var datatable = $table.dataTable({
					aoColumnDefs: [{
						bSortable: false,
						aTargets: [ 0 ]
					}],
					aaSorting: [
						[1, 'asc']
					]
				});

				// add a listener
				$table.on('click', 'i[data-toggle]', function() {
					var $this = $(this),
						tr = $(this).closest( 'tr' ).get(0);

					if ( datatable.fnIsOpen(tr) ) {
						$this.removeClass( 'fa-minus-square-o' ).addClass( 'fa-plus-square-o' );
						datatable.fnClose( tr );
					} else {
						$this.removeClass( 'fa-plus-square-o' ).addClass( 'fa-minus-square-o' );
						datatable.fnOpen( tr, fnFormatDetails( datatable, tr), 'details' );
					}
				});
			};

			$(function() {
				datatableInit();
			});

		}).apply( this, [ jQuery ]);
		</script>
		<!-- end: JavaScript-->
		
	</body>
	
</html>