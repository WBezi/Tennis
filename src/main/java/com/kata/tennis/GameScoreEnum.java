package com.kata.tennis;

public enum GameScoreEnum {
	ZERO(0), FIFTEEN(1), THIRTY(2), FORTY(3);

	private final int value;

	private GameScoreEnum(int value) {
		this.value = value;
	}

	public Integer getCode() {
		return this.value;
	}

	public static GameScoreEnum getScore(Integer code) {
		for (GameScoreEnum score : GameScoreEnum.values()) {
			if (score.getCode() == code) {
				return score;
			}
		}
		return null;
	}
}
