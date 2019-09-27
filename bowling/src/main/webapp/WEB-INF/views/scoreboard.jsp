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
	
	.scoreboard_box {
		width: 95%;
		height: 65%;
		margin: 60px auto 0px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.score_box_outline {
		width: 95%;
		height: 10%;
		margin: 20px auto;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.scoreboard {
		width: 100%;
		border-spacing: 0px;
	}
	
	.scoreboard th, td {
		border: 1px solid white;
		font-size: 20px;
	}
	
	.scoreboard tr {
		height: 50px;
	}
	
	.score_box {
		width: 90%;
		height: auto;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	.score_box button {
		padding: 20px 30px;
		font-size: 18px;
		font-weight: 600; 
		background: white;
		border-radius: 20px;
		cursor: pointer;
		box-shadow: 5px 5px 5px black;
		outline: none;
		border: none;
		color: #353535;
	}
	
	.scoreboard td {
		font-weight: 600;
		text-align: center; 	
	}
	
	.scoreboard th{
		background: red;
	}
	
	.auto_btn_box {
		height: 60px;
		margin-top: 20px;
		text-align: right;
	}
	
	.auto_box {
		width: 90%;
		height: 60px;
		margin: 0 auto;
	}
	
	.auto_box button {
		outline: none;
		background: white;
		border-radius: 20px;
		height: 60px;
		width: 140px;
		color: #353535;
		border: none;
		font-size: 18px;
		font-weight: 600;
		box-shadow: 5px 5px 5px black;
		margin-right: 20px;
		cursor: pointer;
	}
	
</style>
</head>
<body>
	<div class="main_outline">
		<div class="scoreboard_box">
			<table class="scoreboard">
				<thead>
					<tr>
						<th style="width: 8%"></th>
						<th colspan="2" style="width: 8%">1</th>
						<th colspan="2" style="width: 8%">2</th>
						<th colspan="2" style="width: 8%">3</th>
						<th colspan="2" style="width: 8%">4</th>
						<th colspan="2" style="width: 8%">5</th>
						<th colspan="2" style="width: 8%">6</th>
						<th colspan="2" style="width: 8%">7</th>
						<th colspan="2" style="width: 8%">8</th>
						<th colspan="2" style="width: 8%">9</th>
						<th colspan="3" style="width: 12%">10</th>
						<th style="width: 8%">총  점</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="name" varStatus="status">
						<tr>
							<td rowspan="2" style="text-align: center">${name}</td>
							<td id="pins<c:out value="${status.index}"/>00" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>01" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>10" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>11" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>20" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>21" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>30" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>31" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>40" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>41" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>50" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>51" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>60" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>61" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>70" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>71" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>80" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>81" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>90" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>91" class="pins_box" style="width: 4%"></td>
							<td id="pins<c:out value="${status.index}"/>92" class="pins_box" style="width: 4%"></td>
							<td rowspan="2" id="total_score<c:out value="${status.index}"/>" class="pins_box"></td>
						</tr>
						<tr>
							<td colspan="2" class="frame<c:out value="${status.index}"/>0 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>1 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>2 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>3 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>4 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>5 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>6 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>7 pins_box"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>8 pins_box"></td>
							<td colspan="3" class="frame<c:out value="${status.index}"/>9 pins_box"></td>
						</tr>
					</c:forEach>				
				</tbody>
			</table>
		</div>
		<div class="auto_btn_box">
			<div class="auto_box">
				<button class="auto_btn">ALL ONES</button>
				<button class="auto_btn">ALL SPARE</button>
				<button class="auto_btn">ALL STRIKE</button>
				<button class="auto_btn">ALL RANDOM</button>
			</div>
		</div>
		<div class="score_box_outline">
			<div class="score_box">
				<button class="score_btn">0</button>
				<button class="score_btn">1</button>
				<button class="score_btn">2</button>
				<button class="score_btn">3</button>
				<button class="score_btn">4</button>
				<button class="score_btn">5</button>
				<button class="score_btn">6</button>
				<button class="score_btn">7</button>
				<button class="score_btn">8</button>
				<button class="score_btn">9</button>
				<button class="score_btn">10</button>
				<button class="command_btn">CE</button>
				<button class="command_btn">AC</button>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		arrayReset();
		
		var maxRoll = "${player}" * 21; 
		var player = "${player}" - 1;
		var curPlayer = 0;
		var curFrame = 0;
		var curRoll = 0;
		var curPins = 0;
		var theEnd = 0;
		
		$('.score_btn').click(function(){
			curPins = $(this).text();
			
			bowlingAction(curPins);
		});
		
		$('.command_btn').click(function(){
			var text = $(this).text();
			
			if(text == "CE") {
				clearEntryAction();
			} else if(text == "AC") {
				allClearAction();
			}
			
		});
		
		$('.auto_btn').click(function(){
			if(theEnd == 1) {
				return;
			}
			
			var btnText = $(this).text();
			var btnTextArr = btnText.split(" ");
			
			if(btnTextArr[1] == 'ONES') {
				for (var i = 0; i < maxRoll; i++) {
					bowlingAction(1);
					
					if(theEnd == 1) {
						break;
					}
				}
			} else
				
			if(btnTextArr[1] == 'SPARE') {
				if(curRoll == 1 && curPins > 5) {
					return;
				}
				
				for (var i = 0; i < maxRoll; i++) {
					bowlingAction(5);
					
					if(theEnd == 1) {
						break;
					}
				}
			} else
			
			if(btnTextArr[1] == 'STRIKE') {
				if(curRoll == 1 && curPins > 0) {
					return;
				}
				
				for (var i = 0; i < maxRoll; i++) {
					bowlingAction(10);
					
					if(theEnd == 1) {
						break;
					}
				}
			} else
				
			if(btnTextArr[1] == 'RANDOM') {
				for (var i = 0; i < maxRoll; i++) {
					
					if(curRoll == 1 && curPins != 10) {
						var pinsRange = 11 - curPins;
						curPins = Math.floor(Math.random() * pinsRange);
					} else {
						curPins = Math.floor(Math.random() * 11);
					}
					
					bowlingAction(curPins);
					
					if(theEnd == 1) {
						break;
					}
					
				}
			}
		});
		
		function bowlingAction(curPins){		
			$.ajax({
				type:"post",
				url: "${path}/bowling/setScore",
				async: false,
				dataType: "text",
				data: "curPlayer=" + curPlayer + "&curFrame=" + curFrame + "&curRoll=" + curRoll + "&curPins=" + curPins,
				success: function(){
					// 점수 입력 부분
					setScore(curPins);
					
					// 프레임 점수 처리 부분
					getFrameScore();
					
					// 다음 순서 처리 부분
					setNextTrun(curPins);
					
					// 점수 버튼 활성화 처리
					setRollRange(curPins);
				},
				error: function(){
					console.log('AJAX FAIL : BOWLING ACTION');
				}
			});	
		}
		
		function clearEntryAction() {
			$.ajax({
				type:"post",
				url: "${path}/bowling/clearEntry",
				async: false,
				success: function(data){
					// 다음 입력되는 곳 배경색 none
					$('#pins'+curPlayer+curFrame+curRoll).css("background", "none");
					
					// 모든 점수 버튼 visible
					$('.score_btn').css('visibility', 'visible');
					theEnd = 0;
					
					// 플레이어별 최종점수 공백 처리
					if(curRoll == 0) {
						$('#total_score'+(curPlayer-1)).text("");
					} else {
						$('#total_score'+curPlayer).text("");
					}
					
					if(data == null || data == ""){
						// 다음 순서 처리
						curPlayer = 0;
						curFrame = 0;
						curRoll = 0;
						curPins = 0;
						
					} else {
						// 다음 순서 처리
						curPlayer = data.curPlayer;
						curFrame = data.curFrame;
						curRoll = data.curRoll;
						curPins = data.prePins;
						
						// 프레임 점수 처리
						getFrameScore();
						
						// 다음 입력되는 곳 배경색 red
						$('#pins'+curPlayer+curFrame+curRoll).css("background", "red").text("");
						
						// 점수 버튼 활성화 처리
						setRollRange(data.prePins);
					}
					
				},
				error: function(){
					console.log('AJAX FAIL : clearEntry');
				}
			});
		}
		
		function allClearAction() {
			arrayReset();
			
			$('#pins'+curPlayer+curFrame+curRoll).css("background", "none");
			$('.score_btn').css('background', 'white').css('box-shadow', '7px 7px 7px black').css('cursor', 'pointer').css('visibility', 'visible').attr('disabled', false);
			$('.pins_box').text("");
			
			curPlayer = 0;
			curFrame = 0;
			curRoll = 0;
			theEnd = 0;
		}
		
		function arrayReset() {
			$.ajax({
				type:"post",
				url: "${path}/bowling/arrayReset",
				success: function(){
					console.log('AJAX SUCCESS : ARRAY RESET');
				},
				error: function(){
					console.log('AJAX FAIL : ARRAY RESET');
				}
			});	
		}
		
		function setScore(curPins){
			if(isSpare(curPins)) {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').text('/');
			} else if(isStrike(curPins)) {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').text('X');
			} else if(isGutter(curPins)) {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').text('-');
			} else {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').text(curPins);
			}
		}
		
		function getFrameScore(){
			$.ajax({
				type:"post",
				url: "${path}/bowling/getFrameScore",
				async : false,
				dataType: "json",
				data: "curPlayer=" + curPlayer,
				success: function(data){
					
					for (var player = 0; player < data.length; player++) {
						for (var frame = 0; frame < data[player].length; frame++) {
							if(data[player][frame] == '-1') {
								$('.frame'+player+frame).text("");
							} else {
								$('.frame'+player+frame).text(data[player][frame]);
							}
						}
					}
					
				},
				error: function(){
					console.log('AJAX FAIL : GET FRAME SCORE');
				}
			});	
		}
		
		function setNextTrun(curPins){
			if(curFrame < 9) {
				calcTurnOfFrame(curPins);
			} else if(curFrame == 9) {
				calcTurnOfTenthFrame(curPins);
			}
			
			if(theEnd != 1){
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'red');
			}
		}
		
		function calcTurnOfFrame(curPins) {
			if(isStrike(curPins)) {
				if(curPlayer == player){
					curPlayer = 0;
					curFrame++;
					curRoll = 0;
				} else {
					curPlayer++;
					curRoll = 0;
				}
			} else {
				if(curRoll == 1) {
					if(curPlayer == player){
						curPlayer = 0;
						curFrame++;
						curRoll = 0;
					} else {
						curPlayer++;
						curRoll = 0;
					}
				} else {
					curRoll++;
				}
			}
		}
		
		function calcTurnOfTenthFrame(curPins) {
			if(curRoll == 1 && isNormal(curPins)) {
				if(curPlayer == player) {
					$('.score_btn').css('visibility', 'hidden');
					$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none');
					getFinalScore();
					theEnd = 1;
				} else {
					getFinalScore();
					curPlayer++;
					curRoll = 0;
				}
			} else if(curRoll == 2) {
				if(curPlayer == player) {
					$('.score_btn').css('visibility', 'hidden');
					$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none');
					getFinalScore();
					theEnd = 1;
				} else {
					getFinalScore();
					curPlayer++;
					curRoll = 0;
				}
			} else {
				curRoll++;
			}
		}
		
		function setRollRange(curPins){
			if(curFrame < 9 && curRoll == 1) {
				var nextRollRange = 10 - curPins;
				for (var i = nextRollRange; i < 11; i++) {
					$('.score_btn').eq(i+1).css('background', '#353535').css('box-shadow', 'none').attr('disabled', true).css('cursor', 'default');
				}
			} else {
				$('.score_btn').css('background', 'white').css('box-shadow', '7px 7px 7px black').attr('disabled', false).css('cursor', 'pointer');
			}
			
			if(curFrame == 9 && curRoll == 1) {
				if(curPins == 10) {
					$('.score_btn').css('background', 'white').css('box-shadow', '7px 7px 7px black').attr('disabled', false).css('cursor', 'pointer');
				} else {
					var nextRollRange = 10 - curPins;
					for (var i = nextRollRange; i < 11; i++) {
						$('.score_btn').eq(i+1).css('background', '#353535').css('box-shadow', 'none').attr('disabled', true).css('cursor', 'default');
					}
				}
			}
			
			if(curFrame == 9 && curRoll == 2) {
				if($('#pins'+curPlayer+'90').text() == 10 && curPins != 10) {
					var nextRollRange = 10 - curPins;
					for (var i = nextRollRange; i < 11; i++) {
						$('.score_btn').eq(i+1).css('background', '#353535').attr('disabled', true).css('cursor', 'default');
					}
				} else {
					$('.score_btn').css('background', 'white').attr('disabled', false).css('cursor', 'pointer');
				}				
			}
		}
		
		function getFinalScore() {
			$.ajax({
				type:"post",
				url: "${path}/bowling/getFinalScore",
				async: false,
				dataType: "text",
				data: "curPlayer=" + curPlayer,
				success: function(data){
					if(data != $('.frame'+curPlayer+'9').text()) {
						data = $('.frame'+curPlayer+'9').text();
					}
					
					$('#total_score'+curPlayer).text(data);
				},
				error: function(){
					console.log('AJAX FAIL : GET FINAL SCORE');
				}
			});	
		}
		function isGutter(curPins) {
			return curPins == 0
		}
		
		function isSpare(curPins) {
			return curRoll == 1 && Number($('#pins'+curPlayer+curFrame+(curRoll-1)).text()) + Number(curPins) == 10
		}
		
		function isStrike(curPins) {
			return curPins == 10
		}
		
		function isNormal(curPins) {
			if($('#pins'+curPlayer+'90').text() == '-') {
				return 0 + Number(curPins) < 10;
			}
			
			return Number($('#pins'+curPlayer+'90').text()) + Number(curPins) < 10
		}
	});

</script>
</html>