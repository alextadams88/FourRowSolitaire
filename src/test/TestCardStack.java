package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.*;

public class TestCardStack {

	CardStack stack;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack = new CardStack();
		
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
		
	}

	@Test
	public void testAddCard() {
		
		stack.addCard(new Card("Spades", 1, 1, 1));
		
		assertTrue(stack.peek().equals(new Card("Spades", 1, 1, 1)));
		//assertEquals(new Card("Spades", 1, 1, 1), stack.peek());
		
		assertNotNull(stack.peek());
		assertEquals("Spades", stack.peek().getSuit());
		assertEquals(1, stack.peek().getNumber());
		assertEquals(0, stack.peek().getColor());
	}

}
