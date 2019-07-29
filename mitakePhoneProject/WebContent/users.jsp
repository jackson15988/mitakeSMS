<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>遇見未來團隊系統後臺</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>


<%
String account = (String)session.getAttribute("account");
if (account == null ){
response.sendRedirect("sign-in.jsp"); 
}
%>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->


	<!-- 客戶左邊欄位 以及上方欄位  -->
	<jsp:include page="sharedField.jsp"></jsp:include>


	<div class="content">

		<div class="header">
			<h1 class="page-title">會員資料</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="users.jsp">Home</a> <span class="divider">/</span></li>
			<li class="active">會員資料</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar">
					<!--     <button class="btn btn-primary"><i class="icon-plus"></i> New User</button> -->
					<button class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">
						<i class="icon-plus"></i>添加新會員
					</button>
<!-- 					<button class="btn">Import</button> -->
<!-- 					<button class="btn">Export</button> -->
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>會員編號</th>
								<th>會員姓名</th>
								<th>會員手機號碼</th>
								<th>會員創建日期</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>Mark</td>
								<td>Tompson</td>
								<td>the_mark7</td>
								<td>
								<a href="#myeditmember" role="button" data-toggle="editmember"><i class="icon-pencil"></i></a> 
								<a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
								</td>
							</tr>
							<tr>
								<td>1</td>
								<td>2</td>
								<td>Ashley</td>
								<td>Jacobs</td>
								<td>ash11927</td>
								<td>
								<a href="#myModal" role="button" data-toggle="modal"><i class="icon-pencil"></i></a> 
								<a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
								</td>
							</tr>
							<tr>
								<td>1</td>
								<td>3</td>
								<td>Audrey</td>
								<td>Ann</td>
								<td>audann84</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>4</td>
								<td>John</td>
								<td>Robinson</td>
								<td>jr5527</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>5</td>
								<td>Aaron</td>
								<td>Butler</td>
								<td>aaron_butler</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>6</td>
								<td>Chris</td>
								<td>Albert</td>
								<td>cab79</td>
								<td><a href="user.html"><i class="icon-pencil"></i></a> <a
									href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<ul>
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>

				<!-- <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
				<!--     <div class="modal-header"> -->
				<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
				<!--         <h3 id="myModalLabel">Delete Confirmation</h3> -->
				<!--     </div> -->
				<!--     <div class="modal-body"> -->
				<!--         <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p> -->
				<!--     </div> -->
				<!--     <div class="modal-footer"> -->
				<!--         <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button> -->
				<!--         <button class="btn btn-danger" data-dismiss="modal">Delete</button> -->
				<!--     </div> -->
				<!-- </div> -->


				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加新的會員</h4>
							</div>
						<form id="form1" onsubmit="return false" action="##" method="post">
							<div class="modal-body">
									<label>會員姓名</label> <input type="text"  name="username"
										class="input-xlarge"> <label>會員手機號碼</label> <input
										type="text" name="userPhone" class="input-xlarge"> <label>EMAIL</label>
									<input type="text" name="email" class="input-xlarge"> <label>地址</label>
									<textarea name="address" rows="3" class="input-xlarge"></textarea>
							
							</div>
							
								<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" onclick="addmemberInformation()"> 提交更改</button>
							</div>
							
							</form>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				
<footer>
				<hr>

				<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
				<p class="pull-right">
					A <a href="http://www.portnine.com/bootstrap-themes"
						target="_blank">Free Bootstrap Theme</a> by <a
						href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>

				<p>
					&copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
				</footer>

			</div>
		</div>
	</div>


<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.notify.js"></script>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
		
		
		
		function addmemberInformation() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/mitakePhoneProject/addNewUser" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
          
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
		
		
	</script>

</body>
</html>