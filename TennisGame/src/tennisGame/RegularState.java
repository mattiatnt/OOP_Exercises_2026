package tennisGame;
import tennisGame.AdvantageState.Player;
public class RegularState extends GameState {
	
	private int scoreServer;
	private int scoreReceiver;
	
	public RegularState(int scoreServer, int scoreReceiver) {
		if (scoreServer != 0 && scoreServer != 15 && scoreServer != 30 && scoreServer != 40) {
			throw new IllegalArgumentException("server score is wrong");
		}
		if (scoreReceiver != 0 && scoreReceiver != 15 && scoreReceiver != 30 && scoreReceiver != 40) {
			throw new IllegalArgumentException("receiver score is wrong");
		}
		
		this.scoreServer = scoreServer;
		this.scoreReceiver = scoreReceiver;
	}
	
	@Override
	public GameState stateAfterServerWins() {
		if (scoreServer == 40 && scoreReceiver == 40) {
			return new AdvantageState(Player.SERVER);
		}
		if (scoreServer == 40 && scoreReceiver != 40) {
			return new WonState(Player.SERVER);
		}
		int nextScore = (scoreServer == 0)? 15 : (scoreServer == 15)? 30 : 40;
		return new RegularState(nextScore, scoreReceiver);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof RegularState rs &&
				rs.scoreReceiver == this.scoreReceiver &&
				rs.scoreServer == this.scoreServer;
	}

	@Override
	public String toString() {
		return "RegularState [scoreServer=" + scoreServer + ", scoreReceiver=" + scoreReceiver + "]";
	}
}


	