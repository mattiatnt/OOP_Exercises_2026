package tennisGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tennisGame.AdvantageState.Player;

class TennisGameTest {
	private GameState state1;
	
	@BeforeEach
	void setUp(){
		state1 = new RegularState(0,15);
	}

	@Test
	void makeServerWinFromRegularTest() {
		GameState score = state1.stateAfterServerWins();
		assertEquals(new RegularState(15,15), score);
		GameState score1 = score.stateAfterServerWins();
		assertEquals(new RegularState(30,15), score1);
		GameState score2 = score1.stateAfterServerWins();
		assertEquals(new RegularState(40,15), score2);
		GameState score3 = score2.stateAfterServerWins();
		assertEquals(new WonState(Player.SERVER), score3 );
		
		GameState state = new RegularState(40,40);
		assertEquals(new AdvantageState(Player.SERVER), state.stateAfterServerWins());
	}

	@Test 
	void newTest() {
		GameState state = new AdvantageState(Player.SERVER);
		assertEquals(new WonState(Player.SERVER), state.stateAfterServerWins());
		
	}

	@Test 
	void newTest2() {
		GameState state = new AdvantageState(Player.RECEIVER);
		assertEquals(new RegularState(40,40), state.stateAfterServerWins());
		
	}
}
