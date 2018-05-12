package validator;

public class CipherValidator implements Validator {
	
	private String message;
	private MessageType mt = MessageType.CIPHER;
	
	public CipherValidator(String message) {
		this.message = message;
	}

	@Override
	public boolean validate() {
		char[] split = message.toCharArray();
		for (char c : split) {
			int charCode = (int)c;
			if (charCode == 32 || charCode ==39 
					|| (charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}
