package com.bowling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreBoard {
	private final int MAX_ALLFRAME_ROLL = 21;
	private final int MAX_FRAME_ROLL = 3;
	private final int MAX_PLAYER = 4;
	private final int MAX_FRAME = 10;
	
	// 프레임 점수를 계산하기 위한 배열
	private int[][][] pinsByPlayer = new int[MAX_PLAYER][MAX_FRAME][MAX_FRAME_ROLL];
	// 최종 점수를 계산하기 위한 배열
	private int[][] scoreByPlayer = new int[MAX_PLAYER][MAX_ALLFRAME_ROLL];
	// 프레임 점수를 반환 할 배열
	private int[][] scoreByFrame = new int[MAX_PLAYER][MAX_FRAME];
	// sequence 역할을 할 배열
	private int[] seqByPlayer = new int[MAX_PLAYER];
	// 투구 순서를 담을 프레임 워크
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
		//첫 칸일 때 되돌리기
		if(list.size() == 0) { 
			return null;
		}
		
		HashMap<String, Object> map = new HashMap<>();
		
		//가장 최근에 던진 정보 가져오기
		int curPlayer = (int) list.get(list.size()-1).get("curPlayer");
		int curFrame = (int) list.get(list.size()-1).get("curFrame");
		int curRoll = (int) list.get(list.size()-1).get("curRoll");
		
		//가장 최근에 던진 정보 초기화
		pinsByPlayer[curPlayer][curFrame][curRoll] = -1;
		scoreByPlayer[curPlayer][seqByPlayer[curPlayer]-1] = 0;
		seqByPlayer[curPlayer]--;
		list.remove(list.size()-1);
		
		//가장 최근에 던진 정보 담기
		map.put("curPlayer", curPlayer);
		map.put("curFrame", curFrame);
		map.put("curRoll", curRoll);
		
		//이전 내용이 있는지 체크
		if(list.size() == 0) {
			return map;
		}
		
		//이전에 던진 정보 가져오기
		int prePlayer = (int) list.get(list.size()-1).get("curPlayer");
		int preFrame = (int) list.get(list.size()-1).get("curFrame");
		int preRoll = (int) list.get(list.size()-1).get("curRoll");
		
		//이전에 던진 점수 가져오기
		int prePins = pinsByPlayer[prePlayer][preFrame][preRoll];
		
		//이전 점수 담기
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
		return scoreByPlayer[curPlayer][firstRollInFrame] + scoreByPlayer[curPlayer][firstRollInFrame + 1] == 10;
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
