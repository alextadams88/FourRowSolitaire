package test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import FourRowSolitaire.Card;

import org.junit.Test;

public class CardTester {

	private Card card;
	
	@org.junit.Before 
	public void setUp(){
		card = new Card("Spades",1,1,1);
		//The Ace of Spades
	}
	
	@org.junit.After
	public void tearDown(){
		card = null;
	}
/**
	@Test
	public void testHighlight() {
		card.highlight();
		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource("/images/highlightedfaces/sAceH.png"));
			assertEquals(image, card.getImage());
			assertTrue(card.isHighlighted());
		}
		catch (Exception ex)
		{
			fail("Unable to open image");
		}
	}

	@Test
	public void testUnhighlight() {
		card.highlight();
		card.unhighlight();
		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource("/images/cardfaces/sAce.png"));
			assertSame(image, card.getImage());
			assertFalse(card.isHighlighted());
		}
		catch (Exception ex)
		{
			fail("Unable to open image");
		}
	}

	@Test
	public void testSetFaceUp() {
		card.setFaceDown();
		card.setFaceUp();
		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource("/images/cardfaces/sAce.png"));
			assertEquals(image, card.getImage());
			assertTrue(card.isFaceUp());
		}
		catch (Exception ex)
		{
			fail("Unable to open image");
		}
	}

	@Test
	public void testSetFaceDown() {
		card.setFaceDown();
		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource("/images/cardbacks/cardback1.png"));
			assertEquals(image, card.getImage());
			assertFalse(card.isFaceUp());
		}
		catch (Exception ex)
		{
			fail("Unable to open image");
		}
	}
*/

	@Test
	public void testIsValidSuit() {
		assertTrue(card.isValidSuit("Spades") == true);
		assertTrue(card.isValidSuit("Hearts") == true);
		assertTrue(card.isValidSuit("Diamonds") == true);
		assertTrue(card.isValidSuit("Clubs") == true);
		assertTrue(card.isValidSuit("BAD") == false);
		assertTrue(card.isValidSuit("") == false);
	}

}
