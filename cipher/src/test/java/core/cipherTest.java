package core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.cipher;

public class cipherTest {
	
	@Test
	public void cipherBasicTest() {
		String[] key = {"T", "H", "I", "S", "I", "S", "A", "K", "E", "Y"};
		cipher cipher = new cipher("key Test", key);
		assertEquals("DLG LMKT", cipher.encycrpt());
	}
	
	@Test
	public void cipherShortKeyTest() {
		String[] key = {"T", "H"};
		cipher cipher = new cipher("Tell me key is fine", key);
		assertEquals("MLES FL DLR PL MBUX", cipher.encycrpt());
	}
	
	@Test
	public void cipherManySpaceTest() {
		String[] key = {"T", "H", "I", "S", "I", "S", "A", "K", "E", "Y"};
		cipher cipher = new cipher("foo so m an y spa c e  he", key);
		assertEquals("YVW KW E AX C QIH K W  PW", cipher.encycrpt());
	}
}
