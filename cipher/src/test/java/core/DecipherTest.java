package core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.Cipher;
import core.Decipher;

public class DecipherTest {
	
	@Test
	public void decipherBasicTest() {
		String[] key = {"T", "H", "I", "S", "I", "S", "A", "K", "E", "Y"};
		Decipher decipher = new Decipher("DLG LMKT", key);
		assertEquals("KEY TEST", decipher.decycrpt());
	}
	
	@Test
	public void decipherShortKeyTest() {
		String[] key = {"T", "H"};
		Decipher decipher = new Decipher("MLES FL DLR PL MBUX", key);
		assertEquals("TELL ME KEY IS FINE", decipher.decycrpt());
	}
	
	@Test
	public void decipherManySpaceTest() {
		String[] key = {"T", "H", "I", "S", "I", "S", "A", "K", "E", "Y"};
		Decipher decipher = new Decipher("YVW KW E AX C QIH K W  PW", key);
		assertEquals("FOO SO M AN Y SPA C E  HE", decipher.decycrpt());
	}
}
