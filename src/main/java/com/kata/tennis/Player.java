package com.kata.tennis;

public class Player {
	private String name;
	private int scoreInGame;
	private int breakPointScore;
	private int tennisSetScore;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScoreInGame() {
		return scoreInGame;
	}

	public void setScoreInGame(int scoreInGame) {
		this.scoreInGame = scoreInGame;
	}

	public int getTennisSetScore() {
		return tennisSetScore;
	}

	public void setTennisSetScore(int tennisSetScore) {
		this.tennisSetScore = tennisSetScore;
	}

	public int getBreakPointScore() {
		return breakPointScore;
	}

	public void setBreakPointScore(int breakPointScore) {
		this.breakPointScore = breakPointScore;
	}
}
