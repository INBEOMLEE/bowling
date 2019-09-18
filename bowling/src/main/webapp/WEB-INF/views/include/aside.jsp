<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/common.css?v=1">
<title>Bowling</title>
<style type="text/css">
	.aside_outline {
		position: absolute;
		top: 0;
		left: 0;
		border: 3px solid red;
		width: 18%;
		height: 100%;
		background: #353535;
		border-radius: 30px;
		box-shadow: 10px 10px 10px black;
		display: inline-block;
		flex: 1;
	}
	.aside_title {
		display: inline-block;
		width: 100%;
		margin: 120px auto 0;
		font-size: 34px;
		text-align: center;
		font-weight: 600;
		color: white;
		cursor: pointer;
	}
	.aside_menu {
		width: 100%;
		margin: 100px auto 0;
		height: 400px;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	.aside_menu a {
		width: 100%;
		font-size: 22px;
		font-weight: 600;
		display: flex;
		justify-content: center;
		align-items: center;
		flex: 1;
		margin-bottom: 40px;
		color: white;
		cursor: pointer;
	}
	.aside_menu a:hover {
		background: red;
	}
</style>
</head>
<body>
	<div class="aside_outline">
		<a href="${path}/bowling" class="aside_title">Bowling Game</a>
		<div class="aside_menu">
			<a href="${path}/bowling/newgame">새로하기</a>
			<a href="#">이어하기</a>
			<a href="#">불러오기</a>
			<a href="#">순위보기</a>
		</div>
	</div>
</body>
</html>