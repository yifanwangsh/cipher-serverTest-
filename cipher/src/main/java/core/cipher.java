package core;

import java.util.ArrayList;

public class cipher {
	
	private final int Abase = "A".charAt(0);
	private String message;
	private String[] key;
	
	public cipher(String message, String[] key) {
		this.message = message;
		this.key = key;
	}
	
	public String encycrpt() {
		String[] mChar = message.split("");
		ArrayList<String> encycrpted = new ArrayList<String>();
		int cIndex = 0;
		for (String c : mChar) {
			if (c == " ") {
				encycrpted.add(c);
				continue;
			}
			int num = encycrptChar(c.toUpperCase(), key[cIndex]);
			String push = String.valueOf(num + Abase);
			encycrpted.add(push);
			cIndex++;
			if (cIndex >= key.length) cIndex=0;
		}
		StringBuilder sb = new StringBuilder();
		for (String s : encycrpted) {
			sb.append(s);
		}
		return sb.toString();
		
	}
	
	private int encycrptChar (String charA, String charB) {
		int num1 = charA.charAt(0) - Abase;
		int num2 = charB.charAt(0) - Abase;
		return (num1 + num2) % 26;
	}
}
