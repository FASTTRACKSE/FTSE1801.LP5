<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Raleway:500'
	rel='stylesheet' type='text/css'>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="model.entity.Language" />
<style type="text/css">
body {
	width: 100px;
	height: 100px;
	background: -webkit-linear-gradient(90deg, #16222A 10%, #3A6073 90%);
	/* Chrome 10+, Saf5.1+ */
	background: -moz-linear-gradient(90deg, #16222A 10%, #3A6073 90%);
	/* FF3.6+ */
	background: -ms-linear-gradient(90deg, #16222A 10%, #3A6073 90%);
	/* IE10 */
	background: -o-linear-gradient(90deg, #16222A 10%, #3A6073 90%);
	/* Opera 11.10+ */
	background: linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* W3C */
	font-family: 'Raleway', sans-serif;
}

p {
	color: #CCC;
}

.spacing {
	padding-top: 7px;
	padding-bottom: 7px;
}

.middlePage {
	width: 680px;
	height: 500px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
}

.logo {
	color: #CCC;
}
</style>
<title>Insert title here</title>
</head>
<body>



	<div class="middlePage">
		<div class="page-header">
			<h1 class="logo">
				Techulus <small>Welcome to our place!</small>
			</h1>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Please Sign In</h3>
			</div>
			<div class="panel-body">

				<div class="row">

					<div class="col-md-5">
						<a href="#"><img src="http://techulus.com/buttons/fb.png" /></a><br />
						<a href="#"><img src="http://techulus.com/buttons/tw.png" /></a><br />
						<a href="#"><img src="http://techulus.com/buttons/gplus.png" /></a>
					</div>

					<div class="col-md-7"
						style="border-left: 1px solid #ccc; height: 160px">
						<form class="form-horizontal" action="LoginServlet" method="post">
						<input type="hidden" name="nameURL" value="${url}">
							<fieldset>

								<input id="textinput" name="user" type="text"
									placeholder="Enter User Name" class="form-control input-md">
								<div class="spacing">
									<input type="checkbox" name="checkboxes" id="checkboxes-0"
										value="1"><small> Remember me</small>
								</div>
								<input id="textinput" name="pass" type="password"
									placeholder="Enter Password" class="form-control input-md">
								<div class="spacing">
									<a href="#"><small> Forgot Password?</small></a><br />
								</div>
								<input type="submit" id="singlebutton" class="btn btn-info btn-sm pull-right" value="<fmt:message key="submit"/>" name="login">
							


							</fieldset>
						</form>
					</div>

				</div>

			</div>
		</div>

		<p>
			<a href="https://github.com/arjunkomath">About</a> · Arjun
		</p>

	</div>


</body>
</html>