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
	
	.player_many_input_box {
		text-align: center;
		display: inline-block;
		width: 100%;
	}
	
	.player_many_input {
		width: 180px;
		border: 1px solid white;
		font-size: 120px;
		margin: 0 auto;
		height: 120px;
		color: black;
		text-align: center;
		border-radius: 10px;
		
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
		height: 51%;
		width: 90%;
		margin-top: 40px;
	}
	
	.message {
		font-size: 25px;
		text-align: center;
		margin-top: 130px;
	}
	
	.form {
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: space-evenly;
		align-items: center;
		flex-direction: column;
		margin-top: 10px;
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
				<div class="player_many_input_box">
					<input type="text" name="player_many" class="player_many_input" maxlength="1"> 
				</div>
				<div class="error_message_box">
					<div class="error_message">숫자만 입력 가능합니다</div>
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
	var playerCheck = false;
	var playerMany = 0;
	
	$('.player_many_input').keyup(function(){
		var regNumber = /^[0-9]*$/;
		playerMany = $(this).val();
		
		$('.form').html("");
		
		if(!regNumber.test(playerMany)){
			$('.error_message').eq(0).text("숫자만 입력 가능합니다.").css('display', 'block');
			$('.message').css('display', 'block');
			$(this).select();
			playerCheck = false;
			return;
		} else if(1 > playerMany || playerMany > 4) {
			$('.error_message').eq(0).text("1 부터 4 까지 입력 가능합니다.").css('display', 'block');
			$('.message').css('display', 'block');
			$(this).select();
			playerCheck = false;
			return;
		} else {
			$('.error_message').eq(0).text("").css('display', 'none');
			$('.message').css('display', 'none');
			playerCheck = true;
		} 
		
		if(playerCheck) {
			for (var i = 0; i < playerMany; i++) {
				$('.form').append("<div class='player_name_input_box'><input type='text' name='player_name_"+ i +"' class='player_name_input' placeholder='이름' maxlength='4'></div>");
				if(i == (playerMany-1)) {
					$('.form').append("<input type='hidden' class='player' name='player' value="+ playerMany +">")
				}
			}
		}
	});
	
	$('.player_btn').click(function(){
		var regName = /^[가-힣]{2,4}$/;
		
		if(!playerCheck) {
			$('.error_message').eq(1).text("플레이어 수 입력을 확인해주세요.").css('display', 'block');
			return;
		}
		
		for (var i = 0; i < playerMany; i++) {
			var nameVal = $('.player_name_input').eq(i).val();
			
			if(nameVal == null || nameVal == "") {
				$('.error_message').eq(1).text((i+1) + "번째 플레이어 이름을 입력해주세요.").css('display', 'block');
				$('.player_name_input').eq(i).focus();
				return;
			} else if(!regName.test(nameVal)) {
				$('.error_message').eq(1).text("플레이어 이름은 완성된 한글 2~4자로 입력해주세요.").css('display', 'block');
				$('.player_name_input').eq(i).select();
				return;
			}
		}
		
		$('.error_message').eq(1).text("").css('display', 'none');
		
		$('.form').submit();
	});
	
	
});



</script>
</html>