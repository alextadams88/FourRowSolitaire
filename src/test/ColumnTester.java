package test;

import static org.junit.Assert.*;
import FourRowSolitaire.Column;
import FourRowSolitaire.Card;

import org.junit.Test;

public class ColumnTester {
	
	Column column;
	
	
	@org.junit.Before 
	public void setUp(){
		column = new Column();
	}
	
	@org.junit.After
	public void tearDown(){
		column = null;
	}
	
	@Test
	public void testPushCard() {
		column.push(new Card("Spades",Card.KING,1,13));
		column.push(new Card("Diamonds",Card.QUEEN,1,38));
		assertTrue((column.peek()).equals(new Card("Diamonds",Card.QUEEN,1,38)));
	}
	
	@Test
	public void testPushCard2() {
		column.push(new Card("Spades",Card.KING,1,13));
		assertTrue(column.push(new Card("Spades",Card.THREE,1,3)) == null);
	}

	@Test
	public void testIsValidMoveCard() {
		column.addCard(new Card("Spades",Card.KING,1,13));
		column.addCard(new Card("Diamonds",Card.QUEEN,1,38));
		column.addCard(new Card("Spades", Card.JACK,1,11));
		assertTrue(column.isValidMove(new Card("Diamonds",Card.TEN,1,36)));
	}
	
	@Test
	public void testIsValidMoveCard2() {
		column.addCard(new Card("Spades",Card.KING,1,13));
		column.addCard(new Card("DIAMONDS",Card.QUEEN,1,38));
		column.addCard(new Card("Spades", Card.JACK,1,11));
		assertTrue(column.isValidMove(new Card("Spades",Card.FIVE,1,5)) == false);
	}

	@Test
	public void testIsValidMoveCardStack() {
		column.addCard(new Card("Spades",13,1,13));
		column.addCard(new Card("Diamonds",12,1,38));
		column.addCard(new Card("Spades", 11,1,11));
		Column column2 = new Column();
		column2.addCard(new Card("Spades",9,1,9));
		column2.addCard(new Card("Diamonds",10,1,36));
		assertTrue(column.isValidMove(column2) == true);
	}
	
	@Test
	public void testIsValidMoveCardStack2() {
		column.addCard(new Card("Spades",Card.KING,1,13));
		column.addCard(new Card("Diamonds",Card.QUEEN,1,38));
		column.addCard(new Card("Spades", Card.JACK,1,11));
		Column column2 = new Column();
		column2.addCard(new Card("Spades",Card.FOUR,1,4));
		column2.addCard(new Card("Spades",Card.FIVE,1,5));
		assertTrue(column.isValidMove(column2) == false);
	}


}
