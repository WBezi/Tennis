package com.kata.tennis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisSetTest {

	public TennisSet tennisSet;
	public Player firstPlayer;
	public Player secondPlayer;

	@Before
	public void setUp() {
		this.firstPlayer = new Player("First Player");
		this.secondPlayer = new Player("Second Player");
		this.tennisSet = new TennisSet(firstPlayer, secondPlayer);
	}

	/**
	 * Initialize a new SET
	 */
	@Test
	public void testInitializeGame() {
		Assert.assertEquals(Double.valueOf(0), Double.valueOf(this.tennisSet.getGames().size()));
		Assert.assertEquals("0,0", this.tennisSet.score());
	}

	/**
	 * Player Wins One Game in SET - SET SCORE: (Player 1) 1 - 0 (Player 2)
	 */
	@Test
	public void testPlayerWinGame() {
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		this.tennisSet.playerScoreInGame(secondPlayer);
		this.tennisSet.playerScoreInGame(secondPlayer);
		this.tennisSet.playerScoreInGame(secondPlayer);

		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		Assert.assertEquals("1,0", this.tennisSet.score());
	}

	/**
	 * Player Wins Two Game in SET - SET SCORE: (Player 1) 2 - 0 (Player 2)
	 */
	@Test
	public void testPlayerWinTwoGame() {
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		this.tennisSet.playerScoreInGame(secondPlayer);
		this.tennisSet.playerScoreInGame(secondPlayer);
		this.tennisSet.playerScoreInGame(secondPlayer);

		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		Assert.assertEquals("1,0", this.tennisSet.score());

		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		Assert.assertEquals("2,0", this.tennisSet.score());
	}

	/**
	 * SET SCORE: (Player 1) 3 - 1 (Player 2)
	 */
	@Test
	public void testThreeOneInSetScore() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 4; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}

		Assert.assertEquals("3,1", this.tennisSet.score());
	}

	/**
	 * Player Wins SET - SET SCORE: (Player 1) 6 - 1 (Player 2)
	 */
	@Test
	public void testPlayerWinSet() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 4; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}

		Assert.assertEquals("First Player Won the set", this.tennisSet.score());
	}

	/**
	 * SET SCORE: (Player 1) 6 - 5 (Player 2)
	 */
	@Test
	public void testSixFive() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 20; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}

		Assert.assertEquals("6,5", this.tennisSet.score());
	}

	/**
	 * Player Win SET - SET SCORE: (Player 1) 7 - 5 (Player 2)
	 */
	@Test
	public void testPlayerWinSetBySevenFive() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 20; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		for (int i = 0; i < 16; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}

		Assert.assertEquals("First Player Won the set", this.tennisSet.score());
	}

	/**
	 * SET SCORE: (Player 1) 6 - 6 (Player 2)
	 */
	@Test
	public void testSixAll() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 20; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}

		for (int i = 0; i < 4; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}

		Assert.assertEquals("6,6", this.tennisSet.score());
	}

	/**
	 * Player wins SET by Breakpoints - SET SCORE: (Player 1) 7 - 6 (Player 2) - Breakpoints : (Player 1) 9 - 7 (Player 2)
	 */
	@Test
	public void testBreakPoints() {
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}
		for (int i = 0; i < 20; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		for (int i = 0; i < 12; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
		}

		for (int i = 0; i < 4; i++) {
			this.tennisSet.playerScoreInGame(secondPlayer);
		}

		for (int i = 0; i < 6; i++) {
			this.tennisSet.playerScoreInGame(firstPlayer);
			this.tennisSet.playerScoreInGame(secondPlayer);
		}
		this.tennisSet.playerScoreInGame(firstPlayer);

		this.tennisSet.playerScoreInGame(secondPlayer);
		this.tennisSet.playerScoreInGame(firstPlayer);

		this.tennisSet.playerScoreInGame(firstPlayer);

		Assert.assertEquals("First Player Won the set", this.tennisSet.score());
	}

}
