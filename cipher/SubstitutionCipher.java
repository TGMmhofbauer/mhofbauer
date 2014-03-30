package hofbauer.cipher;

import hofbauer.cipher.MonoalphabeticCipher;

/**
 * Used to en- and decrypt Strings.
 * 
 * All chars from a given String are replaced according to the given secret alphabet.
 * Every index of the String is replaced by the same index but from the secret alphabet.
 * 
 * @author Manfred Hofbauer
 *
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

	/**
	 * Constructor is setting the secret alphabet to the given secretAlphabet 
	 *
	 * @param secretAlphabet the secrecet alphabet which is used to encrypt Strings
	 */
	public SubstitutionCipher(String secretAlphabet) {
		setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * secret alphabet is set to the given secretAlphabet
	 * 
	 * @param alphabet the secrecet alphabet which is used to encrypt Strings
	 */
	@Override
	public void setSecretAlphabet(String alphabet) {
		super.setSecretAlphabet(alphabet);
	}
}
