<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/aside.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bowling</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Dancing+Script&display=swap');
	.main_outline {
		background: #353535;
		color: white;
		border-radius: 30px;
		width: 81%;
		height: 100%;
		position: absolute;
		top: 0;
		right: 3px;
	}
	
	.main_title {
		width: 700px;
		text-align: center;
		font-size: 55px;
		font-weight: 600;
		margin: 130px auto 60px;
		font-family: 'Dancing Script', cursive;
	}
	
	.main_img {
		width: 700px;
		margin: 0 auto;
		text-align: center;
	}
	
	.main_img img {
		border-radius: 30px;
	}

</style>
</head>
<body>
	<div class="main_outline">
		<div class="main_title">Bowling Score Calculation Program</div>
		<div class="main_img">
			<img alt="main" src="${path}/resources/img/main.jpg">
		</div>
	</div>
</body>
</html>