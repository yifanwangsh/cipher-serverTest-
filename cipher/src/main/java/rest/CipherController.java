package rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.Cipher;
import core.Decipher;
import validator.KeyValidator;

@RestController
@RequestMapping("/rest")
public class CipherController {
	
    private String[] key;

    @RequestMapping(value = "encycrpt/{message}", method = RequestMethod.GET)
    public String encycrpt(@PathVariable("message") String message) throws IllegalArgumentException{
        try {
        	Cipher cipher = new Cipher(message, key);
        	return cipher.encycrpt();
        } catch (IllegalArgumentException e) {
        	throw new IllegalArgumentException (e.getMessage());
        }
    }
    
    @RequestMapping(value = "decycrpt/{message}", method = RequestMethod.GET)
    public String decycrpt(@PathVariable("message") String message) throws IllegalArgumentException{
    	try {
    		Decipher decipher = new Decipher(message, key);
    		return decipher.decycrpt();
    	} catch (IllegalArgumentException e) {
    		throw new IllegalArgumentException (e.getMessage());
    	}
    }
    
    @RequestMapping(value = "updateKey/{message}", method = RequestMethod.POST)
    public void update(@PathVariable("message") String message) throws IllegalArgumentException{
    	KeyValidator kv = new KeyValidator(message);
    	if (!kv.validate()) {
    		throw new IllegalArgumentException("The key entered is not valid");
    	}
    	this.key = message.replace(" ", "").toUpperCase().split("");
    }
}
