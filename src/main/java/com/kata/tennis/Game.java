package com.kata.tennis;

public class Game {
	private Player firstPlayer;
	private Player secondPlayer;

	public Game(Player firstPlayer, Player secondPlayer) {
		super();
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;

		initilisePlayerScores(firstPlayer);
		initilisePlayerScores(secondPlayer);
	}

	public String score() {
		if (isWon()) {
			return playerWithHighScore().getName() + " Won";
		}
		if (isAdvantage()) {
			return "A " + playerWithHighScore().getName();
		}
		if (isDuce()) {
			return "Deuce";
		}
		if (isAdvantage()) {
			return "A " + playerWithHighScore().getName();
		}
		return GameScoreEnum.getScore(firstPlayer.getScoreInGame()) + ","
				+ GameScoreEnum.getScore(secondPlayer.getScoreInGame());
	}

	public void playerScores(Player p) {
		p.setScoreInGame(p.getScoreInGame() + 1);
	}

	public Boolean isWon() {
		return (firstPlayer.getScoreInGame() > 3 || secondPlayer.getScoreInGame() > 3)
				&& Math.abs(firstPlayer.getScoreInGame() - secondPlayer.getScoreInGame()) >= 2;
	}

	private Boolean isDuce() {
		return (firstPlayer.getScoreInGame() == 3 && secondPlayer.getScoreInGame() == 3);
	}

	private Boolean isAdvantage() {
		return (firstPlayer.getScoreInGame() > 3 && secondPlayer.getScoreInGame() == 3)
				|| (secondPlayer.getScoreInGame() > 3 && firstPlayer.getScoreInGame() == 3);
	}

	public Player playerWithHighScore() {
		if (firstPlayer.getScoreInGame() > secondPlayer.getScoreInGame()) {
			return firstPlayer;
		}
		return secondPlayer;
	}

	private void initilisePlayerScores(Player p) {
		p.setScoreInGame(0);
		p.setBreakPointScore(0);
	}
}
