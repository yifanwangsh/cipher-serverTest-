package validator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KeyValidatorTest {

	@Test
	public void KeyValidatorBasicGoodTest() {
		KeyValidator kv = new KeyValidator("legal String");
		assertTrue(kv.validate());
	}
	
	@Test
	public void KeyValidatorBasicBadTest() {
		KeyValidator kv = new KeyValidator("123");
		assertTrue(!kv.validate());
	}
	
	@Test
	public void KeyValidatorApostropheTest() {
		KeyValidator kv = new KeyValidator("This's good");
		assertTrue(kv.validate());
	}
}
