package com.kata.tennis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	public Game game;
	public Player firstPlayer;
	public Player secondPlayer;

	@Before
	public void setUp() {
		this.firstPlayer = new Player("First Player");
		this.secondPlayer = new Player("Second Player");
		this.game = new Game(firstPlayer, secondPlayer);
	}

	@Test
	public void testPlayerScoresBeforeStartGame() {
		Assert.assertEquals("ZERO,ZERO", this.game.score());
	}

	@Test
	public void testFifteenZero() {
		this.game.playerScores(firstPlayer);
		Assert.assertEquals(GameScoreEnum.FIFTEEN + "," + GameScoreEnum.ZERO, this.game.score());
	}

	@Test
	public void testFifteenAll() {
		this.game.playerScores(firstPlayer);
		this.game.playerScores(secondPlayer);
		Assert.assertEquals(GameScoreEnum.FIFTEEN + "," + GameScoreEnum.FIFTEEN, this.game.score());
	}

	@Test
	public void testThirtyFifTeen() {
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(secondPlayer);
		Assert.assertEquals(GameScoreEnum.THIRTY + "," + GameScoreEnum.FIFTEEN, this.game.score());
	}

	@Test
	public void testFortyFifteen() {
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		
		this.game.playerScores(secondPlayer);
		Assert.assertEquals(GameScoreEnum.FORTY + "," + GameScoreEnum.FIFTEEN, this.game.score());
	}

	@Test
	public void testPlayerWonSet() {
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);

		this.game.playerScores(secondPlayer);
		
		this.game.playerScores(firstPlayer);
		Assert.assertEquals("First Player Won", this.game.score());
	}

	@Test
	public void testDeuce() {
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);

		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);

		Assert.assertEquals("Deuce", this.game.score());
	}

	@Test
	public void testAdvantage() {

		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);

		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);

		this.game.playerScores(firstPlayer);

		Assert.assertEquals("A First Player", this.game.score());
	}

	@Test
	public void testPlayerWonAfterAdvantage() {

		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);

		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);
		this.game.playerScores(secondPlayer);

		this.game.playerScores(firstPlayer);
		this.game.playerScores(firstPlayer);

		Assert.assertEquals("First Player Won", this.game.score());

	}
}
