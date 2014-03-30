package hofbauer.cipher;

import hofbauer.cipher.Cipher;
import hofbauer.cipher.TestCipher;

/**
 * MonoAlphabeticCypher is used to en- and decrypt Strings.
 * 
 * The MonoAlphabeticCypher is the super-class of all other Cyphers in the package ableitinger.cipher.
 * 
 * It replaces all chars from the Strings given in the link encrypt and 
 * decrypt methods by the chars defined in the secret alphabet.
 * 
 * @author Manfred Hofbauer
 */
public abstract class MonoalphabeticCipher implements Cipher {

	/** Constant for the standard alphabet: abcdefghijklmnopqrstuvwxyz*/
	public static final char[] STANDARD_ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	private char[] secretAlphabet;
	
	/**
	 * Constructor
	 */
	protected MonoalphabeticCipher() {
	}
	
	@Override
	public String encrypt(String text) {

		StringBuilder sb = new StringBuilder();
		text = text.toLowerCase();
		
		for(int i = 0; i < text.length(); i++) {
			int index = TestCipher.arrayToList(STANDARD_ALPHABET).indexOf(text.charAt(i));
			if(index != -1) {
				sb.append(secretAlphabet[index]);
			} else {
				sb.append(text.indexOf(i));
			}
		}
		return sb.toString();
	}

	@Override
	public String decrypt(String text) {

		StringBuilder sb = new StringBuilder();
		text = text.toLowerCase();
		
		for(int i = 0; i < text.length(); i++) {
			int index = TestCipher.arrayToList(secretAlphabet).indexOf(text.charAt(i));
			if(index != -1) {
				sb.append(STANDARD_ALPHABET[index]);
			} else {
				sb.append(text.indexOf(i));
			}
		}
		return sb.toString();
	}
	
	/**
	 * The Secret alphabet of MonoalphabeticCipher is set.
	 * 
	 * @param the alphabet which should be set to secret alphabet
	 */
	protected void setSecretAlphabet(String alphabet) {
		if(alphabet.length() != STANDARD_ALPHABET.length){ 
			throw new IllegalArgumentException("Length of secret alphabet has to be " + STANDARD_ALPHABET.length + " given " + alphabet.length());
		}
		else if(!TestCipher.arrayToList(alphabet.toCharArray()).containsAll(TestCipher.arrayToList(STANDARD_ALPHABET))){ 
			throw new IllegalArgumentException("Secret Alphabet has to contain all letters exactly once");
		}
		else{
			secretAlphabet = alphabet.toLowerCase().toCharArray();
		}
	}
}
