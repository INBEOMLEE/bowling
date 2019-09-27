package com.bowling.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bowling.CalcScore;
import com.bowling.dao.BowlingDAO;

import lombok.extern.slf4j.Slf4j;

@Service
public class BowlingServiceImpl implements BowlingService{
	CalcScore calcScore = new CalcScore();
	
	@Inject
	BowlingDAO bowlingDAO;
	
	@Override
	public void setScoreboard(int player) {
		calcScore.setScoreBoard(player);
	}
	
	@Override
	public void arrayReset() {
		calcScore.arrayReset();
	}
	
	@Override
	public void setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
		calcScore.setScore(curPlayer, curFrame, curRoll, curPins);
		calcScore.roll(curPlayer, curPins);
		calcScore.recordEntry(curPlayer, curFrame, curRoll);
	}
	
	@Override
	public int[][] getFrameScore(int curPlayer) {
		return calcScore.getFrameScore(curPlayer);
	}

	@Override
	public int getFinalScore(int curPlayer) {
		return calcScore.getFinalScore(curPlayer);
	}

	@Override
	public HashMap<String, Object> clearEntry() {
		return calcScore.clearEntry();
	}

}
