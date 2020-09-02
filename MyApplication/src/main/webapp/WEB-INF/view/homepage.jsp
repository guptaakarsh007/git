<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>e-commerce | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">E-commerce Baby Product</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<!-- <li><a href="/show-users">All Users</a></li> -->
					<a href="/aboutUs" class="navbar-brand">AboutUs</a>
					<a href="/contactUs" class="navbar-brand">contactUs</a>
					<li><a href="/edit-user-personal"><span
						class="glyphicon glyphicon-pencil">Edit</span></a></li>
						
						<li><a href="/delete-user-personal-mode"><span
						class="glyphicon glyphicon-trash">Delete</span></a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- <div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Welcome to E-Commerce Baby Product</h1>
			<h3>Baby Product</h3>
		</div>
	</div> -->

	<form class="form-horizontal">
	<div class="container text-centered">
		<!-- <div class="alert alert-success">
			<h4>Baby Care Produts</h4>
		</div> -->
		<!-- <iframe width="400" height="200"
			src="C:\Users\akarsgup\Desktop\BabyStoreImage.jpg" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe> -->
			
			<img src="/static/image/baby1.jpg" alt="BabyHomeImage" width="1200" >
			
			<!-- <p> Here is Baby Care Contains baby care store </p>
			<div class="alert alert-success">
			<h4>Baby Care Produts</h4> 
		</div> -->
		<!-- <iframe width="400" height="200"
			src="C:\Users\akarsgup\Desktop\BabyStoreImage.jpg" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe> -->
			
			<!-- <p> Here is Baby Care Contains baby care store </p>
			<div class="alert alert-success">
			<h4>Baby Care Produts</h4>
		</div> -->
		<!-- <iframe width="400" height="200"
			src="C:\Users\akarsgup\Desktop\BabyStoreImage.jpg" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe> -->
			
			<!-- <p> Here is Baby Care Contains baby care store </p>
			<div class="alert alert-success">
			<h4>Baby Care Produts</h4>
		</div> -->
		<!-- <iframe width="400" height="200"
			src="C:\Users\akarsgup\Desktop\BabyStoreImage.jpg" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe> -->
			<!-- <img src="C:\Users\akarsgup\Desktop\BabyStoreImage.jpg" alt="BabyStoreImage" width="500" height="600">
			<p> Here is Baby Care Contains baby care store </p> -->
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Logout" action="/login-user" />
				<button type="submit" formaction="/login-user">Submit to another page</button>
				
				<a href="/edit-user-personal"><span
						class="glyphicon glyphicon-pencil"></span></a>
						
				<a href="/delete-user-personal-mode"><span
						class="glyphicon glyphicon-trash"></span></a>		
			</div>
	</div>
	</form>
	
	<%-- <c:choose>
	
		
		</c:choose> --%>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>