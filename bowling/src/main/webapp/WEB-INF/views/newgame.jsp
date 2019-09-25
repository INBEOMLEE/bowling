<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/aside.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bowling</title>
<style type="text/css">
	.main_outline {
		background: #353535;
		color: white;
		border-radius: 30px;
		width: 81%;
		height: 100%;
		position: absolute;
		top: 0;
		right: 3px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.player_check {
		width: 80%;
		height: 80%;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	.player_many, .player_name {
		border: 2px solid white;
		border-radius: 30px;
		display: inline-block;
		width: 49%;
		height: 100%;
	}
	
	.player_name {
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	
	}
	
	.player_title {
		width: 100%;
		font-size: 30px;
		font-weight: 600;
		text-align: center;
		margin: 120px 0 100px;
	}
	
	.player_many_btn_box {
		text-align: center;
		display: inline-block;
		width: 100%;
		margin-top: 150px;
		display: flex;
		justify-content: space-evenly;
		align-items: center;
	}
	
	.player_many_btn {
		width: 20%;
		height: 80px;
		background: white;
		border: none;
		font-size: 30px;
		font-weight: 600;
		color: #353535;
		border-radius: 20px;
		cursor: pointer;
	}
	
	.error_message_box {
		margin-top: 30px;
		
	}
	
	.error_message {
		color: red;
		text-align: center;
		display: none;
	}
	
	.player_name_box {
		height: 60%;
		width: 90%;
	}
	
	.message {
		margin-top: 240px;
		font-size: 25px;
		text-align: center;
		display: block;
		font-weight: 600;
	}
	
	.form {
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: space-evenly;
		align-items: center;
		flex-direction: column;
		margin-top: 35px;
	}
	
	.player_name_input_box {
		width: 100%;
		height: 40px;
	}
	
	.player_name_input {
		width: 100%;
		color: black;
		text-align: center;
		height: 100%;
		font-size: 20px;
		font-weight: 600;
		border-radius: 10px;
	}
	
	.player_btn_box {
		width: 100%;
		margin-top: 60px;
	}
	
	.player_btn {
		font-size: 30px;
		font-weight: 600;
		width: 70%;
		margin: 0 auto;
		text-align: center;
		padding: 7px 10px;
		letter-spacing: 10;
		border: 1px solid red;
		background: red;
		border-radius: 30px;
		cursor: pointer;
	}
	
</style>
</head>
<body>
	<div class="main_outline">
		<div class="player_check">	
			<div class="player_many">
				<div class="player_title">플레이어 수를 입력해주세요</div>
				<div class="player_many_btn_box">
					<button class="player_many_btn">1</button>
					<button class="player_many_btn">2</button>
					<button class="player_many_btn">3</button>
					<button class="player_many_btn">4</button>
				</div>
			</div>
			<div class="player_name">
				<div class="player_name_box">
					<div class="message">플레이어 수를 입력하면 활성화됩니다</div>
					<form action="${path}/bowling/scoreboard" method="POST" class="form">
					</form>
				</div>
				<div class="error_message_box" style="margin: 15px; height: 30px">
					<div class="error_message">숫자만 입력 가능합니다</div>
				</div>
				<div class="player_btn_box" style="margin: 2px">
					<div class="player_btn">확 인</div>
				</div>
			</div>		
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var playerMany = 0;
	
	$('.player_many_btn').click(function(){
		playerMany = $(this).text();
		
		$('.message').css('display', 'none');
		
		$('.form').html("");
		for (var i = 0; i < playerMany; i++) {
			$('.form').append("<div class='player_name_input_box'><input type='text' name='player_name_"+ i +"' class='player_name_input' placeholder='이름' maxlength='4'></div>");
			if(i == (playerMany-1)) {
				$('.form').append("<input type='hidden' class='player' name='player' value="+ playerMany +">")
			}
		}
	});
	
	$('.player_btn').click(function(){
		if(playerMany == 0) {
			$('.error_message').text("플레이어 수를 입력해주세요.").css('display', 'block');
			return;
		}
		
		for (var i = 0; i < playerMany; i++) {
			var nameVal = $('.player_name_input').eq(i).val();
			
			if(nameVal == null || nameVal == "") {
				$('.error_message').text((i+1) + "번째 플레이어 이름을 입력해주세요.").css('display', 'block');
				$('.player_name_input').eq(i).focus();
				return;
			}
			
		}
		
		for (var i = 0; i < playerMany; i++) {
			for (var j = i+1; j < playerMany; j++) {
				if($('.player_name_input').eq(i).val() == $('.player_name_input').eq(j).val()) {
					$('.error_message').text("같은 이름의 플레이어가 존재합니다.").css('display', 'block');
					return;
				}
			}
		}
		
		
		$('.error_message').eq(1).text("").css('display', 'none');
		
		$('.form').submit();
	});
	
	
});



</script>
</html>