package test;

import static org.junit.Assert.*;

import FourRowSolitaire.CardStack;
import FourRowSolitaire.Card;

import org.junit.Test;

public class CardStackTester {

	CardStack stack;
	
	@org.junit.Before 
	public void setUp(){
		stack = new CardStack();
	}
	
	@org.junit.After
	public void tearDown(){
		stack = null;
	}
	
	@Test
	public void testCardStack() {
		assertTrue(stack.peek() == null);
		assertTrue(stack.pop() == null);
		assertTrue(stack.pop(new CardStack()).peek() == null);
		assertTrue(stack.pop(new CardStack()).pop() == null);
		assertTrue(stack.isEmpty() == true);
		assertTrue(stack.length() == 0);
	}

	@Test
	public void testAddCard() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		assertTrue(stack.peek().equals(new Card("Spades",1,1,1)));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",1,1,1)));
	}

	@Test
	public void testAddStack() {
		stack.addStack(new CardStack());
		assertTrue(stack.peek() == null);
	}
	
	@Test
	public void testAddStack2() {
		CardStack pushStack = new CardStack();
		pushStack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addStack(pushStack);
		assertTrue(stack.peek().equals(new Card("Spades",Card.ACE,1,1)));
	}
	
	@Test
	public void testAddStack3() {
		CardStack pushStack = new CardStack();
		pushStack.addCard(new Card("Spades",Card.ACE,1,1));
		pushStack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addStack(pushStack);
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
	}
	
	@Test
	public void testAddStack4() {
		CardStack pushStack = new CardStack();
		pushStack.addCard(new Card("Spades",Card.ACE,1,1));
		pushStack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades",Card.THREE,1,3));
		stack.addStack(pushStack);
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.THREE,1,3)));
	}
	
	@Test
	public void testAddStack5() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addStack(new CardStack());
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
	}
	

	@Test
	public void testPushCard() {
		stack.push(new Card("Spades",Card.ACE,1,1));
		assertTrue(stack.peek().equals(new Card("Spades",Card.ACE,1,1)));
	}
	
	@Test
	public void testPushCard2() {
		stack.push(new Card("Spades",Card.ACE,1,1));
		stack.push(new Card("Spades",Card.TWO,1,2));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
	}

	@Test
	public void testPushCardStack() {
		stack.push(new CardStack());
		assertTrue(stack.peek() == null);
	}
	
	@Test
	public void testPushCardStack2() {
		CardStack pushStack = new CardStack();
		pushStack.push(new Card("Spades",Card.ACE,1,1));
		stack.push(pushStack);
		assertTrue(stack.peek().equals(new Card("Spades",Card.ACE,1,1)));
	}
	
	@Test
	public void testPushCardStack3() {
		CardStack pushStack = new CardStack();
		pushStack.push(new Card("Spades",Card.ACE,1,1));
		pushStack.push(new Card("Spades",Card.TWO,1,2));
		stack.push(pushStack);
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		
	}
	
	@Test
	public void testPushCardStack4() {
		CardStack pushStack = new CardStack();
		pushStack.push(new Card("Spades",Card.ACE,1,1));
		pushStack.push(new Card("Spades",Card.TWO,1,2));
		stack.push(new Card("Spades",Card.THREE,1,3));
		stack.push(pushStack);
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.THREE,1,3)));
		
	}
	
	@Test
	public void testPushCardStack5() {
		stack.push(new Card("Spades",Card.ACE,1,1));
		stack.push(new Card("Spades",Card.TWO,1,2));
		stack.push(new CardStack());
		assertTrue(stack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.pop().equals(new Card("Spades",Card.ACE,1,1)));
	}

	@Test
	public void testPop() {
		assertTrue(stack.pop() == null);
		
	}

	@Test
	public void testPopCardStack() {
		//fail("Not yet implemented");
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		assertTrue(stack.peek().equals(new Card("Spades",1,1,1)));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		assertTrue(stack.peek().equals(new Card("Spades",Card.TWO,1,2)));
	}

	@Test
	public void testPeek() {
		assertTrue(stack.peek() == null);
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		assertTrue(stack.peek().equals(new Card("Spades",Card.ACE,1,1)));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		assertTrue(stack.peek().equals(new Card("Spades",Card.TWO,1,2)));
	}

	@Test
	public void testSearch() {
		assertTrue(stack.search(new Card("Spades",Card.ACE,1,1)) == -1);
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		assertTrue(stack.search(new Card("Spades",Card.ACE,1,1)) == 1);
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		assertTrue(stack.search(new Card("Spades",Card.ACE,1,1)) == 3);
		assertTrue(stack.search(new Card("Spades",Card.TWO,1,2)) == 2);
		assertTrue(stack.search(new Card("Spades",Card.THREE,1,3)) == 1);
	}

	@Test
	public void testGetCardAtLocationInt() {
		assertTrue(stack.getCardAtLocation(0) == null);
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		assertTrue(stack.getCardAtLocation(0).equals(new Card("Spades",Card.ACE,1,1)));
		assertTrue(stack.getCardAtLocation(1).equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(stack.getCardAtLocation(2).equals(new Card("Spades",Card.THREE,1,3)));
	}

	@Test
	public void testGetStackCard() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		CardStack returnStack = stack.getStack(new Card("Spades", Card.TWO,1,2));
		assertTrue(returnStack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(returnStack.pop().equals(new Card("Spades", Card.THREE,1,3)));
	}
	
	@Test
	public void testGetStackCard2() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		CardStack returnStack = stack.getStack(new Card("Spades", Card.FOUR,1,3));
		assertTrue(returnStack.pop() == null);
	}

	@Test
	public void testGetStackInt() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Spades",Card.TWO,1,2));
		stack.addCard(new Card("Spades",Card.THREE,1,3));
		CardStack returnStack = stack.getStack(2);
		assertTrue(returnStack.pop().equals(new Card("Spades",Card.TWO,1,2)));
		assertTrue(returnStack.pop().equals(new Card("Spades", Card.THREE,1,3)));
	}

	@Test
	public void testIsValidMoveCard() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Diamonds",Card.TWO,1,28));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		stack.isValidMove(new Card("Diamonds",Card.FOUR,1,30));
		assertTrue(stack.isValidMove(new Card("Diamonds",Card.FOUR,1,30)) == false);
	}
	
	@Test
	public void testIsValidMoveCard2() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Diamonds",Card.TWO,1,28));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		assertTrue(stack.isValidMove(new Card("Spades",Card.FOUR,1,4)) == false);
	}

	@Test
	public void testIsValidMoveCardStack() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Diamonds",Card.TWO,1,28));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		CardStack stack2 = new CardStack();
		stack2.addCard(new Card("Diamonds",Card.FOUR,1,30));
		stack2.addCard(new Card("Diamonds",Card.FIVE,1,5));
		assertTrue(stack.isValidMove(stack2) == false);
	}
	
	@Test
	public void testIsValidMoveCardStack2() {
		stack.addCard(new Card("Spades",Card.ACE,1,1));
		stack.addCard(new Card("Diamonds",Card.TWO,1,28));
		stack.addCard(new Card("Spades", Card.THREE,1,3));
		CardStack stack2 = new CardStack();
		stack2.addCard(new Card("Spades",Card.FOUR,1,4));
		stack2.addCard(new Card("Spades",Card.FIVE,1,5));
		assertTrue(stack.isValidMove(stack2) == false);
	}
	
	@Test
	public void testIsEmpty(){
		assertTrue(stack.isEmpty());
	}


}
