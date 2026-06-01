package tennisGame;
import tennisGame.RegularState;

public class AdvantageState extends GameState {
	
	public enum Player{
		SERVER,
		RECEIVER;
	}
	
	private Player playerWithAdvantage;
	
	public AdvantageState(Player player) {
		this.playerWithAdvantage = player;
	}

	public GameState stateAfterServerWins() {
		if (playerWithAdvantage == Player.SERVER) {
			return new WonState(Player.SERVER);
		}
		return new RegularState(40, 40);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof AdvantageState ad && ad.playerWithAdvantage == this.playerWithAdvantage;
	}

}
