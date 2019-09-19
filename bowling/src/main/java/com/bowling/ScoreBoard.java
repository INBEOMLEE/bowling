package com.bowling;

public class ScoreBoard {
	private final int MAX_ALLFRAME_ROLL = 21;
	private final int MAX_FRAME_ROLL = 3;
	private final int MAX_FRAME = 10;
	
	// 출력을 위해 모든 투구의 점수를 담을 배열
	private int[][][] pinsByPlayer = null;
	// 플레이어 별 최종 점수를 담을 배열
	private int[][] scoreByPlayer = null;
	// 플레이어 별 프레임 점수를 담을 배열
	private int[][] scoreByFrame = null;
	// 플레이어 별 투구의 횟수를 담을 배열
	private int[] seqByPlayer = null;
	
	public void setScoreBoard(int player) {
		pinsByPlayer = new int[player][MAX_FRAME][MAX_FRAME_ROLL];
		scoreByPlayer = new int[player][MAX_ALLFRAME_ROLL];
		scoreByFrame = new int[player][MAX_FRAME];
		seqByPlayer = new int[player];
	}
	
	public void arrayReset() {
		for (int i = 0; i < pinsByPlayer.length; i++) {
			for (int j = 0; j < pinsByPlayer[i].length; j++) {
				for (int j2 = 0; j2 < pinsByPlayer[i][j].length; j2++) {
					pinsByPlayer[i][j][j2] = -1;
				}
			}
		}
		
		for (int i = 0; i < scoreByPlayer.length; i++) {
			for (int j = 0; j < scoreByPlayer[i].length; j++) {
				scoreByPlayer[i][j] = 0;
			}
		}
		
		for (int i = 0; i < scoreByFrame.length; i++) {
			for (int j = 0; j < scoreByFrame[i].length; j++) {
				scoreByFrame[i][j] = 0;
			}
		}
		
		for (int i = 0; i < seqByPlayer.length; i++) {
			seqByPlayer[i] = 0;
		}
	}

	public void setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
//		System.out.println("setScore :: pinsByPlayer [" + curPlayer + "] " + "[" + curFrame + "] " + "[" + curRoll + "] = " + curPins);
		
		pinsByPlayer[curPlayer][curFrame][curRoll] = curPins;
	}

	public void roll(int curPlayer, int curPins) {
		scoreByPlayer[curPlayer][seqByPlayer[curPlayer]++] = curPins;
	}
	
	public int getFinalScore(int curPlayer) {
		int score = 0;
		int firstRollInFrame = 0;
		
		for (int frame = 0; frame < 10; frame++) {
			if(isSpare(curPlayer, firstRollInFrame)) {
				score += 10 + nextBallsForSpare(curPlayer, firstRollInFrame);
				firstRollInFrame += 2;
			} else if(isStrike(curPlayer, firstRollInFrame)) {
				score += 10 + nextBallsForStrike(curPlayer, firstRollInFrame);
				firstRollInFrame += 1;
			} else {
				score += nextBallsForFrame(curPlayer, firstRollInFrame);
				firstRollInFrame += 2;
			}
		}
		
		System.out.println("getFinalScore :: " + (curPlayer+1) + "번째 플레이어 총 점수 = " + score);
		
		return score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[][] getFrameScore(int curPlayer) {
		if(pinsByPlayer[0][0][0] == 10 && pinsByPlayer[0][1][0] == 10 && (pinsByPlayer[0][0][0] != -1 && pinsByPlayer[0][1][0] != -1 && pinsByPlayer[0][2][0] != -1)) {
			System.out.println("연속 스트라이크?");
			scoreByFrame[0][0] = pinsByPlayer[0][0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][2][0];
		} else if(pinsByPlayer[0][0][0] == 10 && (pinsByPlayer[0][0][0] != -1 && pinsByPlayer[0][1][0] != -1 && pinsByPlayer[0][1][1] != -1)) {
			System.out.println("스트라이크?");
			scoreByFrame[0][0] = pinsByPlayer[0][0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][1][1];
		} else if(pinsByPlayer[0][0][0] + pinsByPlayer[0][0][1] == 10 && (pinsByPlayer[0][0][0] != -1 && pinsByPlayer[0][0][1] != -1 && pinsByPlayer[0][1][0] != -1)) {
			System.out.println("스페어?");
			scoreByFrame[0][0] = pinsByPlayer[0][0][0] + pinsByPlayer[0][0][1] + pinsByPlayer[0][1][0];
		} else if(pinsByPlayer[0][0][0] + pinsByPlayer[0][0][1] != 10 && (pinsByPlayer[0][0][0] != -1 && pinsByPlayer[0][0][1] != -1)) {
			System.out.println("노멀?");
			System.out.println("pinsByPlayer[0][0][0]의 값 : " + pinsByPlayer[0][0][0]);
			System.out.println("pinsByPlayer[0][0][1]의 값 : " + pinsByPlayer[0][0][1]);
			scoreByFrame[0][0] = pinsByPlayer[0][0][0] + pinsByPlayer[0][0][1];
		}
		
//		if(pinsByPlayer[0][1][0] == 10 && pinsByPlayer[0][2][0] == 10) {
//			scoreByFrame[0][1] = scoreByFrame[0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][2][0] + pinsByPlayer[0][3][0];
//		} else if(pinsByPlayer[0][1][0] == 10) {
//			scoreByFrame[0][1] = scoreByFrame[0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][2][0] + pinsByPlayer[0][2][1];
//		} else if(pinsByPlayer[0][1][0] + pinsByPlayer[0][1][1] == 10) {
//			scoreByFrame[0][1] = scoreByFrame[0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][1][1] + pinsByPlayer[0][2][0];
//		} else {
//			scoreByFrame[0][1] = scoreByFrame[0][0] + pinsByPlayer[0][1][0] + pinsByPlayer[0][1][1];
//		}
		
		return scoreByFrame;
	}
	
	public boolean isSpare(int curPlayer, int firstRollInFrame) {
		return nextBallsForFrame(curPlayer, firstRollInFrame) == 10;
	}
	
	public boolean isStrike(int curPlayer, int firstRollInFrame) {
		return scoreByPlayer[curPlayer][firstRollInFrame] == 10;
	}
	
	public int nextBallsForSpare(int curPlayer, int firstRollInFrame) {
		return scoreByPlayer[curPlayer][firstRollInFrame + 2];
	}
	
	public int nextBallsForStrike(int curPlayer, int firstRollInFrame) {
		return scoreByPlayer[curPlayer][firstRollInFrame + 1] + scoreByPlayer[curPlayer][firstRollInFrame + 2];
	}
	
	public int nextBallsForFrame(int curPlayer, int firstRollInFrame) {
		return scoreByPlayer[curPlayer][firstRollInFrame] + scoreByPlayer[curPlayer][firstRollInFrame + 1];
	}
}