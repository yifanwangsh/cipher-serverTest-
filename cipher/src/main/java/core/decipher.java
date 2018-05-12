package core;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

public class decipher {
	
	private int Abase = "A".charAt(0);
	private String message;
	private String[] key;
	
	public decipher(String message, String[] key) {
		this.message = message;
		this.key = key;
	}
	
	public String decycrpt() {
		String[] eChar = message.split("");
		ArrayList<String> decycrpted = new ArrayList<String>();
		int dIndex = 0;
		for (String e : eChar) {
			if (e.equals(" ")) {
				decycrpted.add(e);
			} else {
				int num = decycrptChar(e.toUpperCase(), key[dIndex]);
				String push = Character.toString((char)(num + Abase));
				decycrpted.add(push);
				dIndex++;
				if (dIndex >= key.length) dIndex = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String s : decycrpted) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	private int decycrptChar(String charA, String charB) {
		int num1 = charA.charAt(0) - Abase;
		int num2 = charB.charAt(0) - Abase;
		if (num1 - num2 >= 0) {
			return num1 - num2;
		} else return num1 - num2 + 26;
	}
}
