package bowlingTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bowling.ScoreBoard;

public class ScoreBoardTest {
	
	ScoreBoard scoreBoard = new ScoreBoard();
	int player = 0;

	@Test
	public void canRoll() {
		scoreBoard.roll(player, 0);
	}
	
	private void rollMany(int pins, int frames) {
		for (int i = 0; i < frames; i++) 
			scoreBoard.roll(player, pins);
	}
	
	private void rollSpare() {
		scoreBoard.roll(player, 5);
		scoreBoard.roll(player, 5);
	}
	
	@Test
	public void gutterGame() {
		rollMany(0, 20);
		assertEquals(0, scoreBoard.getFinalScore(player));
	}

	@Test
	public void allOnes() {
		rollMany(1, 20);
		assertEquals(20, scoreBoard.getFinalScore(player));
	}
	
	@Test
	public void oneSpare() {
		rollSpare();
		scoreBoard.roll(player, 3);
		rollMany(0, 17);
		assertEquals(16, scoreBoard.getFinalScore(player));
	}
	
	@Test
	public void oneStrike() {
		rollStrike();
		scoreBoard.roll(player, 5);
		scoreBoard.roll(player, 3);
		rollMany(0, 16);
		assertEquals(26, scoreBoard.getFinalScore(player));
	}

	private void rollStrike() {
		scoreBoard.roll(player, 10);
	}
	
	@Test
	public void perfectRoll() {
		rollMany(10, 10);
		scoreBoard.roll(player, 10);
		scoreBoard.roll(player, 10);
		assertEquals(300, scoreBoard.getFinalScore(player));
	}
	
	@Test
	public void allSpareRoll() {
		for (int i = 0; i < 10; i++) {
			rollSpare();
		}
		scoreBoard.roll(player, 5);
		assertEquals(150, scoreBoard.getFinalScore(player));
		
	}

}
