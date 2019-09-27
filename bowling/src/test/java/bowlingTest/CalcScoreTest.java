package bowlingTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bowling.CalcScore;

public class CalcScoreTest {
	
	CalcScore calcScore = new CalcScore();
	int player = 0;
	
	
	
	//입력한 점수 확인
	@Test
	public void canRoll() {
		calcScore.roll(player, 0);
	}
	
	//스페어 일 때 점수 확인
	@Test
	public void oneSpare() {
		rollSpare();
		calcScore.roll(player, 3);
		rollMany(0, 17);
		assertEquals(16, calcScore.getFinalScore(player));
	}
	
	//스트라이크 일 때 점수 확인
	@Test
	public void oneStrike() {
		rollStrike();
		calcScore.roll(player, 5);
		calcScore.roll(player, 3);
		rollMany(0, 16);
		assertEquals(26, calcScore.getFinalScore(player));
	}
	
	//모든 투구가 0일 때 점수 확인
	@Test
	public void gutterGame() {
		rollMany(0, 20);
		assertEquals(0, calcScore.getFinalScore(player));
	}

	//모든 투구가 1일 때 점수 확인
	@Test
	public void allOnes() {
		rollMany(1, 20);
		assertEquals(20, calcScore.getFinalScore(player));
	}
	
	//모든 투구가 5일 때 점수 확인
	@Test
	public void allSpareRoll() {
		for (int i = 0; i < 10; i++) {
			rollSpare();
		}
		calcScore.roll(player, 5);
		assertEquals(150, calcScore.getFinalScore(player));
	}
	
	//모든 투구가 10일 때 점수 확인
	@Test
	public void perfectRoll() {
		rollMany(10, 10);
		calcScore.roll(player, 10);
		calcScore.roll(player, 10);
		assertEquals(300, calcScore.getFinalScore(player));
	}
	
	

	
	
	
	
	
	
	
	
	private void rollMany(int pins, int frames) {
		for (int i = 0; i < frames; i++) 
			calcScore.roll(player, pins);
	}
	
	private void rollStrike() {
		calcScore.roll(player, 10);
	}
	
	private void rollSpare() {
		calcScore.roll(player, 5);
		calcScore.roll(player, 5);
	}
}
