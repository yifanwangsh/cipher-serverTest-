package rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.cipher;
import core.decipher;

@RestController
@RequestMapping("/rest")
public class cipherController {
	
    private String[] key;

    @RequestMapping(value = "encycrpt/{message}", method = RequestMethod.GET)
    public String encycrpt(@PathVariable("message") String message) {
        cipher cipher = new cipher(message, key);
        return cipher.encycrpt();
    }
    
    @RequestMapping(value = "decycrpt/{message}", method = RequestMethod.GET)
    public String decycrpt(@PathVariable("message") String message) {
    	decipher decipher = new decipher(message, key);
    	return decipher.decycrpt();
    }
    
    @RequestMapping(value = "updateKey/{message}", method = RequestMethod.POST)
    public void update(@PathVariable("message") String message) {
    	if (message.equals("error")) {
    		throw new IllegalArgumentException("The key value to update is not valid");
    	};
    	this.key = message.replace(" ", "").toUpperCase().split("");
    }
}
