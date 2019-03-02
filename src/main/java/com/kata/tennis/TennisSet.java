package com.kata.tennis;

import java.util.ArrayList;
import java.util.List;

public class TennisSet {
	private Player firstPlayer;
	private Player secondPlayer;

	private List<Game> games;
	private Game lastGame;

	public TennisSet(Player firstPlayer, Player secondPlayer) {
		this.games = new ArrayList<Game>();
		this.lastGame = new Game(firstPlayer, secondPlayer);
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game getLastGame() {
		return lastGame;
	}

	public void setLastGame(Game lastGame) {
		this.lastGame = lastGame;
	}

	public String score() {
		if (isWon()) {
			return playerWithHighScore().getName() + " Won the set";
		}
		return firstPlayer.getTennisSetScore() + "," + secondPlayer.getTennisSetScore();
	}

	private void playerScoresSet(Player p) {
		p.setTennisSetScore(p.getTennisSetScore() + 1);
	}

	private Boolean isWon() {
		return ((firstPlayer.getTennisSetScore() > 4 || secondPlayer.getTennisSetScore() > 4)
				&& Math.abs(firstPlayer.getTennisSetScore() - secondPlayer.getTennisSetScore()) >= 2)
				|| ((firstPlayer.getTennisSetScore() == 7 && secondPlayer.getTennisSetScore() == 6)
						|| (firstPlayer.getTennisSetScore() == 6 && secondPlayer.getTennisSetScore() == 7));
	}

	private Boolean isBreakPoints() {
		return firstPlayer.getTennisSetScore() == 6 && secondPlayer.getTennisSetScore() == 6;
	}

	private Player playerWithHighScore() {
		if (firstPlayer.getTennisSetScore() > secondPlayer.getTennisSetScore()) {
			return firstPlayer;
		}
		return secondPlayer;
	}

	private Player playerWithHighBreakPoints() {
		if (firstPlayer.getBreakPointScore() > secondPlayer.getBreakPointScore()) {
			return firstPlayer;
		}
		return secondPlayer;
	}

	public void checkSetScore() {
		if (isBreakPoints()) {
			if ((firstPlayer.getBreakPointScore() > 6 || secondPlayer.getBreakPointScore() > 6)
					&& Math.abs(firstPlayer.getBreakPointScore() - secondPlayer.getBreakPointScore()) >= 2) {
				playerScoresSet(playerWithHighBreakPoints());
			}
		} else {
			if (this.lastGame.isWon()) {
				playerScoresSet(this.lastGame.playerWithHighScore());
				this.games.add(lastGame);
				this.lastGame = new Game(firstPlayer, secondPlayer);
			}
		}

	}

	public void playerScoreInGame(Player p) {
		if (isBreakPoints()) {
			p.setBreakPointScore(p.getBreakPointScore() + 1);
		} else {
			this.lastGame.playerScores(p);
		}
		this.checkSetScore();
	}
}
