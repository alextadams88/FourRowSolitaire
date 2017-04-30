package test;

import static org.junit.Assert.*;

import FourRowSolitaire.AcePile;
import FourRowSolitaire.Card;

import org.junit.Test;


public class AcePileTester {

	AcePile pile;
	
	@org.junit.Before 
	public void setUp(){
		pile = new AcePile("Spades");
	}
	
	@org.junit.After
	public void tearDown(){
		pile = null;
	}
	
	@Test
	public void testPushCard() {
		pile.push(new Card("Spades",Card.ACE,1,1));
		assertTrue(pile.push(new Card("Spades",Card.TWO,1,2)).equals(new Card("Spades",Card.TWO,1,2)));
	}
	
	public void testPushCard2() {
		pile.push(new Card("Spades",Card.ACE,1,1));
		assertTrue(pile.push(new Card("Spades",Card.THREE,1,3)) == null);
	}


	@Test
	public void testIsValidMoveCard() {
		pile.addCard(new Card("Spades",Card.ACE,1,1));
		pile.addCard(new Card("Spades",Card.TWO,1,2));
		pile.addCard(new Card("Spades", Card.THREE,1,3));
		assertTrue(pile.isValidMove(new Card("Spades",Card.FOUR,1,4)) == true);
	}
	
	@Test
	public void testIsValidMoveCard2() {
		pile.addCard(new Card("Spades",Card.ACE,1,1));
		pile.addCard(new Card("Spades",Card.TWO,1,2));
		pile.addCard(new Card("Spades",Card.THREE,1,3));
		assertTrue(pile.isValidMove(new Card("Spades",Card.FIVE,1,5)) == false);
	}


	@Test
	public void testIsValidMoveCardStack() {
		pile.addCard(new Card("Spades",Card.ACE,1,1));
		pile.addCard(new Card("Spades",Card.TWO,1,2));
		pile.addCard(new Card("Spades", Card.THREE,1,3));
		AcePile pile2 = new AcePile("Spades");
		pile2.addCard(new Card("Spades",Card.FOUR,1,4));
		pile2.addCard(new Card("Spades",Card.FIVE,1,5));
		assertTrue(pile.isValidMove(pile2) == false);
	}
	
	@Test
	public void testIsValidMoveCardStack2() {
		pile.addCard(new Card("Spades",Card.ACE,1,1));
		pile.addCard(new Card("Spades",Card.TWO,1,2));
		pile.addCard(new Card("Spades", Card.THREE,1,3));
		AcePile pile2 = new AcePile("Spades");
		pile2.addCard(new Card("Spades",Card.FIVE,1,5));
		pile2.addCard(new Card("Spades",Card.SIX,1,6));
		assertTrue(pile.isValidMove(pile2) == false);
	}
}
