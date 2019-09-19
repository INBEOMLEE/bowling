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
		margin: 10px auto;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.scoreboard {
		width: 100%;
		border-spacing: 0px;
	}
	
	.scoreboard th {
		font-size: 20px;
	}
	
	.scoreboard th, td {
		border: 1px solid white;
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
		color: black;
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
	
	.error_message {
		font-size: 20px;
		font-weight: 600;
		text-align: center;
		color: tomato;
		margin-top: 60px;
		visibility: hidden;
	}
	.scoreboard th{
		background: red;
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
							<td rowspan="2" style="text-align: center; font-size: 25px;">${name}</td>
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
							<td rowspan="2" id="total_score<c:out value="${status.index}"/>"></td>
						</tr>
						<tr>
							<td colspan="2" class="frame<c:out value="${status.index}"/>0"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>1"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>2"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>3"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>4"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>5"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>6"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>7"></td>
							<td colspan="2" class="frame<c:out value="${status.index}"/>8"></td>
							<td colspan="3" class="frame<c:out value="${status.index}"/>9"></td>
						</tr>
					</c:forEach>				
				</tbody>
			</table>
		</div>
		<div class="error_message">한 프레임에 두번의 투구가 10점을 넘을 수 없습니다.</div>
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
		
		var player = "${player}" - 1;
		var curPlayer = 0;
		var curFrame = 0;
		var curRoll = 0;
		var theEnd = 0;
		var flag = 0;
		
		$('.score_btn').click(function(){
			var curPins = $(this).text();
			bowlingAction(curPins);
			
			if(theEnd == 1){
				getFinalScore();
			}
		});
		
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
		
		function bowlingAction(curPins){		
			$.ajax({
				type:"post",
				url: "${path}/bowling/setScore",
				async: false,
				dataType: "text",
				data: "curPlayer=" + curPlayer + "&curFrame=" + curFrame + "&curRoll=" + curRoll + "&curPins=" + curPins,
				success: function(){
					console.log('AJAX SUCCESS : BOWLING ACTION');
					
					// 점수 입력 부분
					setScore(curPins);
					
					// 프레임 점수 입력 부분
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
		
		function setScore(curPins){
			if(curRoll == 1 && Number($('#pins'+curPlayer+curFrame+(curRoll-1)).text()) + Number(curPins) == 10) {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').css('font-size', '30px').text('/');
			} else if(curPins == 10) {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').css('font-size', '30px').text('X');
			} else {
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none').css('font-size', '25px').text(curPins);
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
					console.log('AJAX SUCCESS : GET FRAME SCORE');
					for (var i = 0; i < data.length; i++) {
						for (var j = 0; j < data[i].length; j++) {
							$('.frame'+i+j).text(data[i][j]);
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
				if(curPins == 10) {
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
			} else {
				if(curRoll == 1 && Number($('#pins'+curPlayer+'90').text()) + Number(curPins) < 10) {
					if(curPlayer == player) {
						$('.score_btn').css('visibility', 'hidden');
						$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none');
						curPlayer++;
						flag = 1;
					} else {
						curPlayer++;
						curRoll = 0;
					}
					
					theEnd = 1;
				} else if(curRoll == 2) {
					if(curPlayer == player) {
						$('.score_btn').css('visibility', 'hidden');
						$('#pins'+curPlayer+curFrame+curRoll).css('background', 'none');
						curPlayer++;
						flag = 1;
					} else {
						curPlayer++;
						curRoll = 0;
					}
					
					theEnd = 1;
				} else {
					curRoll++;
				}
			}
			
			if(flag != 1){
				$('#pins'+curPlayer+curFrame+curRoll).css('background', 'red');
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
				dataType: "text",
				data: "curPlayer=" + (curPlayer-1),
				success: function(finalScore){
					console.log('AJAX SUCCESS : GET FINAL SCORE');
					$('#total_score'+(curPlayer-1)).css('font-size', '25px').text(finalScore);
					theEnd = 0;
				},
				error: function(){
					console.log('AJAX FAIL : GET FINAL SCORE');
				}
			});	
		}
	});

</script>
</html>