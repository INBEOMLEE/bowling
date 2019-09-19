package com.bowling;

public class ScoreBoard {
	// 출력을 위해 모든 투구의 점수를 담을 배열
	private int[][][] pinsByPlayer = new int[4][10][3];
	// 플레이어 별 최종 점수를 담을 배열
	private int[][] scoreByPlayer = new int[4][21];
	// 플레이어 별 투구의 횟수를 담을 배열
	private int[] seqByPlayer = new int[4];

	public int[][][] setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
		pinsByPlayer[curPlayer][curFrame][curRoll] = curPins;
		
		System.out.println("setScore :: pinsByPlayer [" + curPlayer + "] " + "[" + curFrame + "] " + "[" + curRoll + "] = " + curPins);
		
		return pinsByPlayer;
	}

	public void roll(int curPlayer, int curPins) {
		scoreByPlayer[curPlayer][seqByPlayer[curPlayer]++] = curPins;
	}
	
	public int getFinalScore(int curPlayer) {
		int[] score = new int[Bowling.MAX_PLAYER];
		int firstRollInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if(isSpare1(curPlayer, firstRollInFrame)) {
				score[curPlayer] += 10 + nextBallsForSpare(curPlayer, firstRollInFrame);
				firstRollInFrame += 2;
			} else if(isStrike1(curPlayer, firstRollInFrame)) {
				score[curPlayer] += 10 + nextBallsForStrike(curPlayer, firstRollInFrame);
				firstRollInFrame += 1;
			} else {
				score[curPlayer] += nextBallsForFrame(curPlayer, firstRollInFrame);
				firstRollInFrame += 2;
			}
		}
		
		System.out.println((curPlayer+1) + "번째 플레이어 총 점수 : " + score[curPlayer]);
		
		return score[curPlayer];
	}
	
	public boolean isSpare1(int curPlayer, int firstRollInFrame) {
		return nextBallsForFrame(curPlayer, firstRollInFrame) == 10;
	}
	
	public boolean isStrike1(int curPlayer, int firstRollInFrame) {
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
