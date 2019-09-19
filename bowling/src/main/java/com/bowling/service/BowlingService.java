package com.bowling.service;

import java.util.HashMap;

public interface BowlingService {
	
	public void setScoreboard(int player);

	public HashMap<String, Object> setScore(int curPlayer, int curFrame, int curRoll, int curPins);

	public int getFinalScore(int curPlayer);

	public void arrayReset();

	public int[][] getFrameScore(int curPlayer);

}
