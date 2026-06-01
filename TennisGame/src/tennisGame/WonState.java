package tennisGame;
import tennisGame.AdvantageState.Player;

public class WonState extends GameState{
	
	private Player winner;
	
	public WonState(Player player) {
		this.winner = player; 
	}

	@Override
	public GameState stateAfterServerWins() {
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof WonState ws && ws.winner == this.winner;
	}

}
