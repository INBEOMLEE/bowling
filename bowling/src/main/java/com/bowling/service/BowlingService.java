package com.bowling.service;

import java.util.HashMap;

public interface BowlingService {
	
	public void setScoreboard(int player);

	public void setScore(int curPlayer, int curFrame, int curRoll, int curPins);

	public int getFinalScore(int curPlayer);

	public void arrayReset();

	public int[][] getFrameScore(int curPlayer);

	public HashMap<String, Object> clearEntry();

}
