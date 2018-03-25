<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<style type="text/css">
#mask {
	position: absolute;
	z-index: 888;
	background-color: #cccccc;
	display: none;
	top: 0;
	left: 0;
	filter: Alpha(opacity = 50); /*此处用于IE不透明度为半透明百分比*/
	-moz-opacity: 0.5; /*此处用于火狐不透明度*/
	opacity: 0.5; /*此处用于新版火狐不透明数*/
}

#view {
	position: absolute;
	width: 500px;
	height: 500px;
	z-index: 999; /*视图div的z-index要大於遮盖的*/
	display: none;
	top: 0px;
	left: 5%;
	background-color: #ffffff;
	border: 1px solid #ccccc0;
	-moz-user-select: none;
}
#mask1 {
	position: absolute;
	z-index: 888;
	background-color: #cccccc;
	display: none;
	top: 0;
	left: 0;
	filter: Alpha(opacity = 50); /*此处用于IE不透明度为半透明百分比*/
	-moz-opacity: 0.5; /*此处用于火狐不透明度*/
	opacity: 0.5; /*此处用于新版火狐不透明数*/
}

#view1 {
	position: absolute;
	width: 500px;
	height: 500px;
	z-index: 999; /*视图div的z-index要大於遮盖的*/
	display: none;
	top: 0px;
	left: 5%;
	background-color: #ffffff;
	border: 1px solid #ccccc0;
	-moz-user-select: none;
}
</style>
<!-- Basic -->
<meta charset="UTF-8" />

<title>Advanced Table | Fire - Admin Template</title>

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Import google fonts -->
<link href='http://fonts.useso.com/css?family=Titillium+Web'
	rel='stylesheet' type='text/css'>

<!-- Favicon and touch icons -->
<link rel="shortcut icon"
	href="<%=basePath%>view/assets/ico/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon"
	href="<%=basePath%>view/assets/ico/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="76x76"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-76x76.png" />
<link rel="apple-touch-icon" sizes="114x114"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-114x114.png" />
<link rel="apple-touch-icon" sizes="120x120"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-120x120.png" />
<link rel="apple-touch-icon" sizes="144x144"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-144x144.png" />
<link rel="apple-touch-icon" sizes="152x152"
	href="<%=basePath%>view/assets/ico/apple-touch-icon-152x152.png" />

<!-- start: CSS file-->

<!-- Vendor CSS-->
<link
	href="<%=basePath%>view/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>view/assets/vendor/skycons/css/skycons.css"
	rel="stylesheet" />
<link
	href="<%=basePath%>view/assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>view/assets/vendor/css/pace.preloader.css"
	rel="stylesheet" />

<!-- Plugins CSS-->
<link href="<%=basePath%>view/assets/plugins/bootkit/css/bootkit.css"
	rel="stylesheet" />
<link href="<%=basePath%>view/assets/plugins/select2/select2.css"
	rel="stylesheet" />
<link
	href="<%=basePath%>view/assets/plugins/jquery-datatables-bs3/css/datatables.css"
	rel="stylesheet" />

<!-- Theme CSS -->
<link href="<%=basePath%>view/assets/css/jquery.mmenu.css"
	rel="stylesheet" />

<!-- Page CSS -->
<link href="<%=basePath%>view/assets/css/style.css" rel="stylesheet" />
<link href="<%=basePath%>view/assets/css/add-ons.min.css"
	rel="stylesheet" />

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
				<h6>
					<i class="fa fa-table red"></i><span class="break"></span>用户管理
				</h6>
				<div class="panel-actions">
					<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i></a>
					<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
				</div>
			</div>
			<div class="panel-body">
				<div class="bk-margin-bottom-10">
					<button class="btn btn-info"
						onclick="window.location.href='#'">
						添加部门<i class="fa fa-plus"></i>
					</button>
					
					<button class="btn btn-info"
						onclick="addMessage()">
						添加角色<i class="fa fa-plus"></i>
					</button>
				</div>
				<table class="table table-bordered table-striped mb-none"
					id="datatable-details" style="-moz-user-select: none;">
					<thead>
						<tr>
							<th hidden="true"></th>
							<th></th>
							<th>部门名称</th>
							<th>在职员工数</th>
							<th>部门电话</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="deptList" var="dept" >
							<tr class="gradeA">
								<td hidden="true"><s:property value="#dept.deptId" /></td>
								<td class="text-center"><i data-toggle
									class="fa fa-plus-square-o text-primary h5 m-none"
									style="cursor: pointer;"></i></td>
								<td><s:property value="#dept.deptName" /></td>
								<td><s:property value="#dept.deptStaffCount" /></td>
								<td style="font: red;"><s:property value="#dept.deptPhone" /></td>
								<td class="center"><s:property value="#dept.deptCreateTime" /></td>
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
	<script
		src="<%=basePath%>view/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="<%=basePath%>view/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>view/assets/vendor/skycons/js/skycons.js"></script>
	<script src="<%=basePath%>view/assets/vendor/js/pace.min.js"></script>

	<!-- Plugins JS-->
	<script src="<%=basePath%>view/assets/plugins/moment/js/moment.min.js"></script>
	<script src="<%=basePath%>view/assets/plugins/select2/select2.js"></script>
	<script
		src="<%=basePath%>view/assets/plugins/jquery-datatables/media/js/jquery.dataTables.js"></script>
	<script
		src="<%=basePath%>view/assets/plugins/jquery-datatables/extras/TableTools/js/dataTables.tableTools.min.js"></script>
	<script
		src="<%=basePath%>view/assets/plugins/jquery-datatables-bs3/js/datatables.js"></script>
	<script
		src="<%=basePath%>view/assets/plugins/sparkline/js/jquery.sparkline.min.js"></script>
	<!-- Theme JS -->
	<script src="<%=basePath%>view/assets/js/jquery.mmenu.min.js"></script>
	<script src="<%=basePath%>view/assets/js/core.min.js"></script>

	<!-- Pag es JS -->
	<script src="<%=basePath%>view/assets/js/pages/table-advanced.js"></script>
	<script type="text/javascript">
		/*  初始化 */
		//呵呵呵
		function fnFormatDetails(datatable, tr) {
			var deptId = datatable.fnGetData(tr)[0];
			var userGender;
			var userIdCard;
			var userPhone;
			var userBirthday;
			var userEmail;
			var userRemark;
			$
					.ajax({
						url : "getRoleByDept.action",
						type : "post",
						data : {
							"deptId" : deptId
						},
						dataType : "json",
						async : false,
						success : function(m) {
							var result = m.roleList;
							result = eval("(" + result + ")");
							str = '<table class="table mb-none">';
							for (var i = 0; i < result.length; i++) {
								str += '<tr class="b-top-none"><td   style="width: 5%"></td><td  style="width: 25%;-moz-user-select: none;">&nbsp;&nbsp;<label class="mb-none"><a href="#" onclick="getByIdMessage('
										+ result[i].roleId
										+ ')">'
										+ result[i].roleName
										+ '</a></label></td><td style="-moz-user-select: none;"><label>'+result[i].roleCount+' 人</label></td>';
							}
							str += '</div>';
						},

						error : function(m) {
							alert("error");
						}
					});
			//alert(userIdCard);
			return str;
		};
		(function($) {

			var datatableInit = function() {
				var $table = $('#datatable-details');

				// format function for row details

				// insert the expand/collapse column
				// initialize
				var datatable = $table.dataTable({
					aoColumnDefs : [ {
						bSortable : false,
						aTargets : [ 0 ]
					} ],
					aaSorting : [ [ 1, 'asc' ] ]
				});

				// add a listener
				$table.on('click', 'i[data-toggle]', function() {
					var $this = $(this), tr = $(this).closest('tr').get(0);

					if (datatable.fnIsOpen(tr)) {
						$this.removeClass('fa-minus-square-o').addClass(
								'fa-plus-square-o');
						datatable.fnClose(tr);
					} else {
						$this.removeClass('fa-plus-square-o').addClass(
								'fa-minus-square-o');
						datatable.fnOpen(tr, fnFormatDetails(datatable, tr),
								'details');
					}
				});
			};

			$(function() {
				datatableInit();
			});

		}).apply(this, [ jQuery ]);
	</script>
	<!-- end: JavaScript-->
	<script type="text/javascript">
	
		function getByIdMessage(id) {
			var oldRoleId;
			$.ajax({
				url : "getNavViaMenu.action",
				type : "post",
				data : {
					"roleId" : id,
					"navFlage" : "select"
				},
				async : false,
				dataType : "json",
				success : function(m) {
					var roles = $("#showRole").find(":checkbox");
					if(m != null){
					 oldRoleId = m.split(",");//这是一个数组  
						for(var j = 0; j < roles.length; j++){
							for (var i = 0; i < oldRoleId.length; i++) {
								if(roles[j].value == oldRoleId[i]){
									$(roles[j]).attr("checked", true);
							}
						}
					}
					}else{
						oldRoleId = [];
						for(var j = 0; j < roles.length; j++){
									$(roles[j]).attr("checked", false);
							}
					
					}
				},
				error : function(m) {
					alert("getByIdMessage(id) error");
				}
			});
			//ajax结束 
			
			var mask = document.getElementById("mask");
			var view = document.getElementById("view");

			/*计算当前页面面的大小*/
			var h_c = document.documentElement.scrollHeight;
			var w_c = document.documentElement.scrollWidth;
			var h_b = document.body.scrollHeight;
			var w_b = document.body.scrollWidth;
			var height = h_c > h_b ? h_c : h_b;
			var width = w_c > w_b ? w_c : w_b;

			/*显示遮挡*/
			mask.style.width = width + "px";
			mask.style.height = height + "px";
			mask.style.display = "block";

			/*显示视图层*/

			/*450为div的宽*/
			view.style.left = (width - 900) / 2 + "px";
			/*450为div的高*/
			view.style.top = document.documentElement.scrollTop

			+ (document.documentElement.clientHeight - 600) / 2 + "px";

			view.style.display = "block";
			
			$("#newrole").click(function(event){  
				updateRoleAjax(oldRoleId,id);
				
			});
		}
		function updateRoleAjax(oldRoleId,id){
			var newRoleId = [];
			var roles = $("#showRole").find(":checkbox:checked").each(function(){
				newRoleId.push(this.value);
			});
			var i
			var j;
			var oldRoleLength = oldRoleId.length;
			for(i=0;i<oldRoleLength;i++){
				for(j=0;j<newRoleId.length;j++){
					if(oldRoleId[i] == newRoleId[j]){
						newRoleId.splice(j,1);
						oldRoleId.splice(i,1);
						--oldRoleLength;
						--i;
						break;
					} 
				}
			}
			var needDelId;
			var needAddId;
			needDelId=oldRoleId.join(",");
			needAddId=newRoleId.join(",");
			$("#newrole").unbind('click');  
			 $.ajax({
						url : "updateRoleAjax.action",
						type : "post",
						async : false,
						data : {"needDelId":needDelId,"needAddId":needAddId,"roleId":id},
						dataType : "json",
						success : function(m) {
							if("success" == m){
								alert("修改成功 ");
							}else{
								alert("修改失败 ");
							}
							back();
						},
						error : function(m){
							alert("error");
						}});
		}
		
	
		
	
		function back() {
			var roles = $("#showRole").find(":checkbox");
			for(var j = 0; j < roles.length; j++){
				$(roles[j]).removeAttr("checked");
			}
			var view = document.getElementById("view");
			view.style.display = "none";
			var mask = document.getElementById("mask");
			mask.style.display = "none";
			$("#newrole").unbind('click');  
		}
		$(function() {
				$.ajax({
						url : "getNavViaMenu.action",
						type : "post",
						async : false,
						data : {
							"roleId" : "all"
						},
						dataType : "json",
						success : function(m) {
							var result = eval("(" + m + ")");
							var str = '<span>';
							var addstr = '<span>';
							var count = 0;
							var parentflag = 0;
							for (var i = 0; i < result.length; i++) {
								if (result[i] == null) {
									str += '<br /><br /></span>';
									addstr += '<br /><br /></span>';
								} else {
									if (result[i].navParentId == '0') {
										count = 0;
										++parentflag;
										str += '<span><input type="checkbox" class="parents" name="navs" value="'+result[i].navId+'" id="nav'+result[i].navId+'" /><label for="nav'+result[i].navId+'">'
												+ result[i].navValue
												+ '</label><br /><br />';
										if(parentflag == 1){
											addstr += '<span><input type="checkbox" checked="checked" class="parents" name="navs" isfirst="true" value="'+result[i].navId+'" id="addnav'+result[i].navId+'" /><label for="addnav'+result[i].navId+'">'
											+ result[i].navValue
											+ '</label><br /><br />';
										}else{
											addstr += '<span><input type="checkbox" class="parents" name="navs" value="'+result[i].navId+'" id="addnav'+result[i].navId+'" /><label for="addnav'+result[i].navId+'">'
											+ result[i].navValue
											+ '</label><br /><br />';
										}
										
									} else {
										++count;
										if(count == 5){
											str +='<br />';
											addstr +='<br />';
											count = 0;
										}
										str += '<input type="checkbox" class="children" name="navs" value="'+result[i].navId+'" id="nav'+result[i].navId+'" /><label for="nav'+result[i].navId+'">'
												+ result[i].navValue
												+ '</label>&nbsp;&nbsp;';
										if(parentflag == 1){
											addstr += '<input type="checkbox"  checked="checked" isfirst="true"  class="children" name="navs" value="'+result[i].navId+'" id="addnav'+result[i].navId+'" /><label for="addnav'+result[i].navId+'">'
											+ result[i].navValue
											+ '</label>&nbsp;&nbsp;'
										}else{
											addstr += '<input type="checkbox" class="children" name="navs" value="'+result[i].navId+'" id="addnav'+result[i].navId+'" /><label for="addnav'+result[i].navId+'">'
											+ result[i].navValue
											+ '</label>&nbsp;&nbsp;'
										}
									}

								}
							}
							str += '</div>';
							addstr += '</div>';
							$("#showRole").append(str);
							$("#showRole1").append(addstr);
							listencheckbox();
						},
						error : function(m) {
							alert("error????");
						}
					});
		})

		/* 复选框的js */
		function listencheckbox() {
			$(".parents").click(function() {
				var $span = $(this).parent();
				var flag = this.checked;
				$span.children(".children").attr("checked", flag);
			});

			$(".children")
					.click(
							function() {
								var $span = $(this).parent();
								$span
										.children(".parents")
										.attr(
												"checked",
												$span
														.children(".children:checked").length > 0);
							});
		}
	</script>
	<div id="mask"></div>
	<div id="view">
		<div style="height: 40px; background-color: #CCCCC0">
			<table>
				<tr>
					<td
						style="position: absolute; left: 5px; top: 10px; color: #000000">详细信息</td>
					<td
						style="position: absolute; right: 5px; top: 10px; color: #000000">
				</tr>
			</table>
		</div>
		<!-- <HR width="100%" color=#987cb9 SIZE=10 /> -->
		<div style="height: 8px"></div>
		<div id="showRole" style="padding: 40px; font-size: small; overflow:auto; height: 365px;">
		</div>
		<div style="height: 40px; background-color: #CCCCC0;"></div>
		<div align="center">
			<input type="button" id="newrole" value="确定" style="height: 43px; width: 100px;" /><input
				type="button" style="height: 43px; width: 100px;" value="取消"
				onclick="javascript:back();" />
		</div>
	</div>
	
	
	<!-- 测试~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~测试 -->
	<div id="mask1"></div>
	<form>
	<div id="view1">
		<div style="height: 40px; background-color: #CCCCC0">
			<table>
				<tr>
					<td
						style="position: absolute; left: 5px; top: 10px; color: #000000">添加角色</td>
					<td
						style="position: absolute; right: 5px; top: 10px; color: #000000">
				</tr>
			</table>
		</div>
		<!-- <HR width="100%" color=#987cb9 SIZE=10 /> -->
		<div style="height: 8px"></div>
		<div id="showRole1" style="padding: 40px; font-size: small; overflow:auto; height: 365px;">
		<div id = "addinit">
		
			<label>角色名称:&nbsp;&nbsp;<input type="text" name="role.roleName" id="rolenameofid"  /></label>
			<br /><label>所属部门   :&nbsp;&nbsp;<s:select list="deptList" id="dept" listKey="deptId" listValue="deptName" name="role.department.deptId" />
			</label>&nbsp;&nbsp;
			<span id="hasparent"><label>直接上级:&nbsp;&nbsp;<select id="role" name="role.roleParentId" >
												</select></label> &nbsp;&nbsp;<a onclick="hiddenpar('tono')"><label>无上级</label></a></span><input type="hidden" name="hasparent" value="yes" id="parentflag" />
			<span hidden="hidden" id="hasnotparent"><label>直接上级:&nbsp;&nbsp;<label>无</label></label> &nbsp;&nbsp;<a onclick="hiddenpar('toyes')"><label>有上级</label></a></span>
			<br /><label>是否有下级<label> :&nbsp;&nbsp;<input type="radio" name="role.roleChildId" value="1" id= "yes"><label for="yes">是</label>&nbsp;&nbsp;<input type="radio" name="role.roleChildId" value="0" id = "no" checked="checked"><label for="no">否</label>
			
		</div>
		</div>
		<div style="height: 40px; background-color: #CCCCC0;"></div>
		<div align="center">
			<input type="button" id="addrole" value="添加" style="height: 43px; width: 100px;" /><input
				type="button" style="height: 43px; width: 100px;" value="取消"
				onclick="javascript:addback(); " />
		</div>
	</div>
	</form>
	<script type="text/javascript">   //隐藏添加角色框框 
	function addMessage() {
		/* var addinit = $("#addinit");

		
		var namestr = '<label>角色名称<label> :&nbsp;&nbsp;<input type="text" name="roleName" id="rolenameofid"  />';
		addinit.append(namestr);

		
		var deptstr = '<br /><label>所属部门  <label> :&nbsp;&nbsp;<select name="deptId" id="dept">';
		deptstr += '<option value="1">保安部 </option>';
		deptstr += '</select>';
		addinit.append(deptstr+"<br/>");

		
		var parentstr = '<label>直接上级<label> :&nbsp;&nbsp;<select name="deptId" id="dept">';
		parentstr += '<option value="1">保安部 </option>';
		parentstr += '</select>';
		addinit.append("&nbsp;&nbsp;"+parentstr);

		
		var childstr = '<br /><label>是否有下级<label> :&nbsp;&nbsp;<input type="radio" name="hasChild" value="1" id= "yes"><label for="yes">是</label>&nbsp;&nbsp;<input type="radio" name="hasChild" value="0" id = "no" checked="checked"><label for="no">否</label>';
		addinit.append(childstr); */
		
		var mask = document.getElementById("mask1");
		var view = document.getElementById("view1");

		/*计算当前页面面的大小*/
		var h_c = document.documentElement.scrollHeight;
		var w_c = document.documentElement.scrollWidth;
		var h_b = document.body.scrollHeight;
		var w_b = document.body.scrollWidth;
		var height = h_c > h_b ? h_c : h_b;
		var width = w_c > w_b ? w_c : w_b;

		/*显示遮挡*/
		mask.style.width = width + "px";
		mask.style.height = height + "px";
		mask.style.display = "block";

		/*显示视图层*/

		/*450为div的宽*/
		view.style.left = (width - 900) / 2 + "px";
		/*450为div的高*/
		view.style.top = document.documentElement.scrollTop

		+ (document.documentElement.clientHeight - 600) / 2 + "px";
		view.style.display = "block";
		$("#addrole").click(function (){//这个是点击提交以后要执行的操作 
			$("#addrole").unbind('click');
		
			var params = $("form").serialize();                
			$.ajax({
					url:"addRole.action",
					type:"post",
					data:params,//要传递的数据
					dataType:"json",
					success:function(m){
						if(m = "yes"){
							alert("添加成功");
						}else{
							alert("添加失败");
						}
						addback();
					},
					error:function(m){
						alert(error);
					}});
		});
	}
	
	function addback() {
		var roles = $("#showRole1").find(":checkbox");
		if(roles != null){
			for(var j = 0; j < roles.length; j++){
				$(roles[j]).removeAttr("checked");
				if($(roles[j]).attr("isfirst") == "true"){
					$(roles[j]).attr("checked","checked");
				}
			}
		} 
		var view = document.getElementById("view1");
		view.style.display = "none";
		var mask = document.getElementById("mask1");
		mask.style.display = "none";
		$("#addrole").unbind('click');  
	}
	
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
	
	function hiddenpar (flag){  //toyes  tono  hasparent  hasnotparent 
		var has = $("#hasparent");
		var hasnot = $("#hasnotparent");
		var hasparent = $("#parentflag");
		if(flag == "tono"){
			hasnot.removeAttr("hidden") ;
			has.attr("hidden","hidden");
			hasparent.attr("value","no");
		}else{
			has.removeAttr("hidden");
			hasnot.attr("hidden","hidden");
			hasparent.attr("value","yes");
		}
		
	}
	</script>
</body>

</html>