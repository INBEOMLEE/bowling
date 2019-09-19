package com.bowling.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bowling.Bowling;
import com.bowling.ScoreBoard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BowlingServiceImpl implements BowlingService{
	ScoreBoard scoreBoard = new ScoreBoard();
	
	@Override
	public void setScoreboard(int player) {
		
	}
	
	@Override
	public HashMap<String, Object> setScore(int curPlayer, int curFrame, int curRoll, int curPins) {
		HashMap<String, Object> map = new HashMap<>();
		
		scoreBoard.setScore(curPlayer, curFrame, curRoll, curPins);
		scoreBoard.roll(curPlayer, curPins);

		return map;
	}

	@Override
	public int getFinalScore(int curPlayer) {
		return scoreBoard.getFinalScore(curPlayer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* @Override
	public HashMap<String, Object> roll(String strInput) {
		HashMap<String, Object> map = new HashMap<>();
		int temp = 9 * 2 * player;
		
		if(!strInput.equals("CE") && !strInput.equals("AC")) {
			int temp2 = seq - temp;
			if(seq < player*21) {
				if((temp2%3)+18 == 20) {
					if(score[seq-2] != 10 && score[seq-2] + score[seq-1] != 10) {
						seq++;
					}
				}
				if(seq%2 != 0 && seq != 0 && score[seq-1] + Integer.parseInt(strInput) > 10 && seq < 9 * 2 * player) {
					map.put("code", 1);
					return map;
				}
				
				score[seq] = Integer.parseInt(strInput);
				seq++;
				if(Integer.parseInt(strInput) == 10 && seq < 9 * 2 * player && seq%2 != 0) {
					score[seq] = 0;
					seq++;
				}
			}
		} else if(strInput.equals("CE")) {
			score[seq-1] = 0;
			seq--;
		} else if(strInput.equals("AC")) {
			for (int i = 0; i < score.length; i++) {
				score[i] = 0;
			}
			seq = 0;
		}
		
		
		for (int i = 0; i < score.length; i++) {
			if(i >= 9 * 2 * player) {
				int temp2 = i - temp;
				System.out.println("i의 값 : " + i + ", temp2의 값 : " + temp2 + ", " + ", 계산값 : " + ((temp2%3)+18));
				scoreByPlayer[(temp2/3)%player][(temp2%3)+18] = score[i];
			} else {
				scoreByPlayer[(i/2)%player][(i%2)+(i/(player*2)*2)] = score[i];
			}
		}
		
		for (int player = 0; player < this.player; player++) {
			for (int i = 0; i < 10; i++) { // 10> MAX_FRAME
				if(i < 8) {
					if(scoreByPlayer[player][i*2] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+2] + scoreByPlayer[player][(i*2)+3] ;
						if(scoreByPlayer[player][(i*2)+2] == 10) {
							scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+2] + scoreByPlayer[player][(i*2)+4];
						}
					} else if(scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] + scoreByPlayer[player][(i*2)+2];
					} else {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1];
				    }
				}
				
				if(i == 8) {
					if(scoreByPlayer[player][i*2] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+2] + scoreByPlayer[player][(i*2)+3] ;
					} else if(scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] + scoreByPlayer[player][(i*2)+2];
					} else {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1];
				    }
				}
				
				if(i == 9) {
					if(scoreByPlayer[player][i*2] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] + scoreByPlayer[player][(i*2)+2] ;
					} else if(scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] == 10) {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1] + scoreByPlayer[player][(i*2)+2];
					} else {
						scoreByFrame[player][i] = scoreByPlayer[player][(i*2)] + scoreByPlayer[player][(i*2)+1];
				    }
				}
			}
		}
		
		for (int player = 0; player < this.player; player++) {
			totalScore[player] = 0;
		}
		
		for (int player = 0; player < this.player; player++) {
			for (int i = 0; i < 10; i++) {
				totalScore[player] += scoreByFrame[player][i];
			}	
		}
		
		map.put("scoreByPlayer", scoreByPlayer);
		map.put("scoreByFrame", scoreByFrame);
		map.put("totalScore", totalScore);
		
		return map;
	} */
}
