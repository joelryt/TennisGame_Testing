import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
	public void testTennisGame_Player1_has_advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 advantage score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player1_has_advantage_again() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 advantage score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2_has_advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 advantage score incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2_has_advantage_again() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 advantage score incorrect", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_midgame_scores() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		String score1 = game.getScore() ;
		
		game.player1Scored();
		String score2 = game.getScore() ;
		
		game.player1Scored();
		String score3 = game.getScore() ;
		
		game.player2Scored();
		String score4 = game.getScore() ;
		
		game.player2Scored();
		String score5 = game.getScore() ;
		
		game.player2Scored();
		String score6 = game.getScore() ;
		
		// Assert
		assertEquals("Midgame1 score1 incorrect", "love - 15", score1);
		assertEquals("Midgame1 score2 incorrect", "love - 30", score2);
		assertEquals("Midgame1 score3 incorrect", "love - 40", score3);
		assertEquals("Midgame1 score4 incorrect", "15 - 40", score4);
		assertEquals("Midgame1 score5 incorrect", "30 - 40", score5);
		assertEquals("Midgame1 score6 incorrect", "40 - 40", score6);
	}
	
	
	@Test
	public void testTennisGame_midgame_scores2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		String score1 = game.getScore() ;
		
		game.player2Scored();
		String score2 = game.getScore() ;
		
		game.player2Scored();
		String score3 = game.getScore() ;
		
		game.player1Scored();
		String score4 = game.getScore() ;
		
		game.player1Scored();
		String score5 = game.getScore() ;
		
		// Assert
		assertEquals("Midgame2 score1 incorrect", "15 - love", score1);
		assertEquals("Midgame2 score2 incorrect", "30 - love", score2);
		assertEquals("Midgame2 score3 incorrect", "40 - love", score3);
		assertEquals("Midgame2 score4 incorrect", "40 - 15", score4);
		assertEquals("Midgame2 score5 incorrect", "40 - 30", score5);
	}
	
	@Test
	public void testTennisGame_Player1_wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 should have won", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2_wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 should have won", "player2 wins", score);
	}
	
}
