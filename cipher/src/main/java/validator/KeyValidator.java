package validator;

public class KeyValidator implements Validator{

	private String key;
	private MessageType mt = MessageType.KEY;
	
	public KeyValidator(String key) {
		this.key = key;
	}

	@Override
	public boolean validate() {
		char[] split = key.toCharArray();
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
