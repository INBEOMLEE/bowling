package com.bowling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreBoard {
	private final int MAX_ALLFRAME_ROLL = 21;
	private final int MAX_FRAME_ROLL = 3;
	private final int MAX_PLAYER = 4;
	private final int MAX_FRAME = 10;
	
	// 출력을 위해 모든 투구의 점수를 담을 배열
	private int[][][] pinsByPlayer = new int[MAX_PLAYER][MAX_FRAME][MAX_FRAME_ROLL];
	// 플레이어 별 최종 점수를 담을 배열
	private int[][] scoreByPlayer = new int[MAX_PLAYER][MAX_ALLFRAME_ROLL];
	// 플레이어 별 프레임 점수를 담을 배열
	private int[][] scoreByFrame = new int[MAX_PLAYER][MAX_FRAME];
	// 플레이어 별 투구의 횟수를 담을 배열
	private int[] seqByPlayer = new int[MAX_PLAYER];
	
	List<HashMap<String, Object>> list = new ArrayList<>();
	
	public void setScoreBoard(int player) {

	
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
				scoreByFrame[i][j] = -1;
			}
		}
		
		for (int i = 0; i < seqByPlayer.length; i++) {
			seqByPlayer[i] = 0;
		}
		
		list.clear();
		
	}

	public void setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
//		System.out.println("setScore :: pinsByPlayer [" + curPlayer + "] " + "[" + curFrame + "] " + "[" + curRoll + "] = " + curPins);
		
		pinsByPlayer[curPlayer][curFrame][curRoll] = curPins;
	}

	public void roll(int curPlayer, int curPins) {
		scoreByPlayer[curPlayer][seqByPlayer[curPlayer]++] = curPins;
	}
	
	public void recordEntry(int curPlayer, int curFrame, int curRoll) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("curPlayer", curPlayer);
		map.put("curFrame", curFrame);
		map.put("curRoll", curRoll);
		
		list.add(map);
	}
	
	public HashMap<String, Object> clearEntry() {
		if(list.size() == 0) {
			return null;
		}
		
		HashMap<String, Object> map = new HashMap<>();
		
		int curPlayer = (int) list.get(list.size()-1).get("curPlayer");
		int curFrame = (int) list.get(list.size()-1).get("curFrame");
		int curRoll = (int) list.get(list.size()-1).get("curRoll");
		
		pinsByPlayer[curPlayer][curFrame][curRoll] = -1;
		scoreByPlayer[curPlayer][seqByPlayer[curPlayer]-1] = 0;
		seqByPlayer[curPlayer]--;
		list.remove(list.size()-1);
		
		map.put("curPlayer", curPlayer);
		map.put("curFrame", curFrame);
		map.put("curRoll", curRoll);
		
		if(list.size() == 0) {
			return map;
		}
		
		int prePlayer = (int) list.get(list.size()-1).get("curPlayer");
		int preFrame = (int) list.get(list.size()-1).get("curFrame");
		int preRoll = (int) list.get(list.size()-1).get("curRoll");
		
		int prePins = pinsByPlayer[prePlayer][preFrame][preRoll];
		
		map.put("prePins", prePins);
		
		return map;
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
		
		return score;
	}
	
	public int[][] getFrameScore(int curPlayer) {
		for (int frame = 0; frame < MAX_FRAME; frame++) {
			if(frame == 0) {
				if(pinsByPlayer[curPlayer][frame][0] == 10 && pinsByPlayer[curPlayer][frame+1][0] == 10 && (pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+2][0] != -1)) {
					scoreByFrame[curPlayer][frame] = pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+2][0];
				} else if(pinsByPlayer[curPlayer][frame][0] == 10 && (pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+1][1] != -1)) {
					scoreByFrame[curPlayer][frame] = pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+1][1];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] == 10 && (pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1)) {
					scoreByFrame[curPlayer][frame] = pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] + pinsByPlayer[curPlayer][frame+1][0];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] != 10 && (pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1)) {
					scoreByFrame[curPlayer][frame] = pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1];
				} else {
					scoreByFrame[curPlayer][frame] = -1;
				}
			} else
			
			if(frame < 8 ) {
				if(pinsByPlayer[curPlayer][frame][0] == 10 && pinsByPlayer[curPlayer][frame+1][0] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+2][0] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+2][0];
				} else if(pinsByPlayer[curPlayer][frame][0] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+1][1] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+1][1];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] + pinsByPlayer[curPlayer][frame+1][0];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] != 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1];
				} else {
					scoreByFrame[curPlayer][frame] = -1;
				}
			} else
				
			if(frame == 8) {
				if(pinsByPlayer[curPlayer][frame][0] == 10 && pinsByPlayer[curPlayer][frame+1][0] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+1][1] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+1][1];
				} else if(pinsByPlayer[curPlayer][frame][0] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1 && pinsByPlayer[curPlayer][frame+1][1] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame+1][0] + pinsByPlayer[curPlayer][frame+1][1];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] == 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1 && pinsByPlayer[curPlayer][frame+1][0] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] + pinsByPlayer[curPlayer][frame+1][0];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] != 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1];
				} else {
					scoreByFrame[curPlayer][frame] = -1;
				}
			} else
			
			if(frame == 9) {
				if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] >= 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1 && pinsByPlayer[curPlayer][frame][2] != -1)) {
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] + pinsByPlayer[curPlayer][frame][2];
				} else if(pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1] < 10 && (scoreByFrame[curPlayer][frame-1] != -1 && pinsByPlayer[curPlayer][frame][0] != -1 && pinsByPlayer[curPlayer][frame][1] != -1)){
					scoreByFrame[curPlayer][frame] = scoreByFrame[curPlayer][frame-1] + pinsByPlayer[curPlayer][frame][0] + pinsByPlayer[curPlayer][frame][1];
				} else {
					scoreByFrame[curPlayer][frame] = -1;
				}
			}
		}
			
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
